/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.timviecnhanh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javax.persistence.EntityManager;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import smartchoice.business.services.CompanyService;
import smartchoice.business.services.JobPostService;
import smartchoice.data.models.Company;
import smartchoice.data.models.JobPost;
import smartchoice.helper.DateHelper;
import smartchoice.helper.FileHelper;
import smartchoice.helper.HttpHelper;
import smartchoice.helper.RegexHelper;
import smartchoice.helper.XMLHelper;
import smartchoice.parser.timviecnhanh.models.schema.JobItem;
import smartchoice.xmlparser.XmlParserConfig;
import smartchoice.xmlparser.statemachine.HtmlPreprocessor;

/**
 *
 * @author TNT
 */
public class Parser {

    protected XmlParserConfig xmlParserConfig;
    protected ParserConfig parserConfig;
    protected XPath xpath;
    protected Set<String> jobLinks;
    protected Templates jobTemplate;
    protected EntityManager entityManager;
    protected CompanyService companyService;
    protected JobPostService jobPostService;

    public Parser(EntityManager entityManager,
            CompanyService companyService,
            JobPostService jobPostService,
            XmlParserConfig xmlParserConfig,
            ParserConfig parserConfig, Templates jobTemplate) {
        this.entityManager = entityManager;
        this.companyService = companyService;
        this.jobPostService = jobPostService;
        this.xmlParserConfig = xmlParserConfig;
        this.parserConfig = parserConfig;
        this.xpath = XMLHelper.getXPath();
        this.jobLinks = new HashSet<>();
        this.jobTemplate = jobTemplate;
    }

    public void start() {
        for (ParserConfig.Pages.Page page : parserConfig.getPages().getPage()) {
            try {
                System.out.println("Start get links page: " + page.getUrl());
                parsePageToGetLinks(page);
                System.out.println("Finish get links page: " + page.getUrl());
                System.out.println("------------------------");
            } catch (IOException | JAXBException | ParserConfigurationException | SAXException | XPathExpressionException e) {
                System.out.println("Error get links page: " + page.getUrl());
                e.printStackTrace();
            }
        }
        //get uncrawled links only
        filterLinks();
        parseJobLinks();
    }

    protected void parsePageToGetLinks(ParserConfig.Pages.Page startPage) throws IOException, JAXBException, ParserConfigurationException, SAXException, XPathExpressionException {
        String content = preprocess(startPage.getUrl());

        //parse DOM and use XPath to get links
        Document doc = XMLHelper.parseDOMFromString(content);
        getLinks(jobLinks, doc, startPage);
        //can not parsed because paging loaded by javascript ...
    }

    protected void filterLinks() {
        //TODO
    }

    protected void parseJobLinks() {
        System.out.println("Size: " + jobLinks.size());
        for (String jobLink : jobLinks) {
            try {
                System.out.println("Start parsing page: " + jobLink);
                String pageContent = preprocess(jobLink);
                FileHelper.writeToFile(pageContent, "temp.html");
                String modelXml = transform(jobLink, pageContent);
//                FileHelper.writeToFile(modelXml, "temp.xml");
                JobItem jobItem = XMLHelper.unmarshallDocXml(modelXml, smartchoice.parser.timviecnhanh.models.schema.ObjectFactory.class);
                processJobItem(jobItem);
                System.out.println(jobItem.getJobName());
                System.out.println("Finish parsing page: " + jobLink);
                System.out.println("------------------------");
            } catch (IOException | TransformerException e) {
                System.out.println("Parsing error: " + jobLink);
                e.printStackTrace();
            } catch (JAXBException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void processJobItem(JobItem jobItem) throws ParseException, Exception {
        if (jobItem.getJobName() == null || jobItem.getJobName().isEmpty()) {
            return;
        }
        Company company = getOrCreateCompany(jobItem.getCompany());
        String code = parserConfig.getName() + "_" + jobItem.getCode();
        boolean existed = jobPostService.jobPostCodeExists(code);
        if (!existed) {
            //TODO: move String to config
            JobPost entity = new JobPost();
            entity.setBenefit(jobItem.getBenefit());
            entity.setCode(code);
            entity.setCompanyId(company);
            entity.setContactAddress(jobItem.getContactAddress());
            entity.setContactPerson(jobItem.getContactPerson());
            entity.setDegreeRequirement(jobItem.getDegreeRequirement());
            entity.setDescription(jobItem.getDescription());
            entity.setExperienceRequirement(jobItem.getExpRequirement());
            try {
                Date expDate = DateHelper.convertToJavaDate(parserConfig.getDateFormat(), jobItem.getExpiredDate());
                entity.setExpiredDate(expDate);
            } catch (Exception e) {
                entity.setExpiredDate(new Date());
            }
            String genReq = jobItem.getGenderRequirement();
            if (genReq.equalsIgnoreCase(parserConfig.getMaleStr())) {
                entity.setGenderRequirement(true);
            } else if (genReq.equalsIgnoreCase(parserConfig.getFemaleStr())) {
                entity.setGenderRequirement(false);
            }
            entity.setName(jobItem.getJobName());
            entity.setNumOfVacancy((int) jobItem.getNumOfVacancy());
            entity.setOtherRequirement(jobItem.getOtherRequirement());
            try {
                Date upDate = DateHelper.convertToJavaDate(parserConfig.getDateFormat(), jobItem.getUpdatedDate());
                entity.setUpdatedDate(upDate);
            } catch (Exception e) {
                entity.setUpdatedDate(new Date());
            }
            entity.setUrl(jobItem.getUrl());
            try {
                Matcher matcher = RegexHelper.matcherDotAll(jobItem.getSalaryRange(), parserConfig.getSalaryRangeRegex());
                if (matcher.find()) {
                    Double from = Double.parseDouble(matcher.group(1)) * parserConfig.getMoneyConversion();
                    Double to = Double.parseDouble(matcher.group(2)) * parserConfig.getMoneyConversion();
                    entity.setSalaryFrom(from);
                    entity.setSalaryTo(to);
                }
            } catch (Exception e) {
            }
        } else {
            Date updatedDate = DateHelper.convertToJavaDate(parserConfig.getDateFormat(), jobItem.getUpdatedDate());
            boolean needUpdated = jobPostService.needUpdatedJobPost(code, updatedDate);
            if (needUpdated) {

            }
        }
    }

    protected Company getOrCreateCompany(JobItem.Company company) throws Exception {
        String url = company.getDetailUrl();
        Matcher matcher = RegexHelper.matcherDotAll(url, parserConfig.getCodeFromUrlRegex());
        String code = null;
        if (matcher.find()) {
            code = matcher.group(1);
        } else {
            throw new Exception("Code not found");
        }
        List<Company> list = companyService.queryCompanyByCode(code, (Integer id) -> {
            return new Company(id);
        }, "id");
        if (list.isEmpty()) {
            Company entity = new Company();
            entity.setCode(code);
            entity.setAddress(company.getAddress());
            entity.setDetailUrl(company.getDetailUrl());
            entity.setImage(company.getImage());
            entity.setName(company.getName());
            if (!companyService.validateForCreate(entity)) {
                return null;
            }
            entityManager.getTransaction().begin();
            companyService.createCompany(entity);
            entityManager.getTransaction().commit();
            return entity;
        }
        return list.get(0);
    }

    protected String transform(String pageUrl, String pageContent) throws TransformerConfigurationException, FileNotFoundException, TransformerException, Exception {
        // Use the template to create a transformer
        Transformer xformer = jobTemplate.newTransformer();
        xformer.setParameter("url", pageUrl);
        Matcher matcher = RegexHelper.matcherDotAll(pageUrl, parserConfig.getCodeFromUrlRegex());
        String code = null;
        if (matcher.find()) {
            code = matcher.group(1);
        } else {
            throw new Exception("Code not found");
        }
        xformer.setParameter("code", code);

        // Prepare the input and output files
        Source source = new StreamSource(new StringReader(pageContent));
        StringWriter writer = new StringWriter();
        Result result = new StreamResult(writer);
        // Apply the xsl file to the source file and write the result
        // to the output file
        xformer.transform(source, result);
        return writer.toString();
    }

    protected String preprocess(String url) throws IOException {
        String content = HttpHelper.getPageContent(url);
        HtmlPreprocessor processor = new HtmlPreprocessor(xmlParserConfig);
        content = processor.refineHtml(content);
        return content;
    }

    protected void getLinks(Set<String> jobLinks, Document doc, ParserConfig.Pages.Page page) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        NodeList linkNodes = (NodeList) xpath.evaluate(page.getJobLinksXPath(), doc, XPathConstants.NODESET);
        for (int i = 0; i < linkNodes.getLength(); i++) {
            String link = linkNodes.item(i).getNodeValue();
            link = resolveFullUrl(page, link);
            jobLinks.add(link);
        }
    }

    protected String resolveFullUrl(ParserConfig.Pages.Page page, String relPath) {
        return relPath.startsWith("http") ? relPath
                : ((parserConfig.getBaseUrl() + (relPath.startsWith("/") ? relPath : "/" + relPath)));
    }

    protected String resolveFullPagingUrl(ParserConfig.Pages.Page page, String relPath) {
        return page.getUrl() + parserConfig.getPagingAppendStr().replace("{p}", relPath);
    }

}
