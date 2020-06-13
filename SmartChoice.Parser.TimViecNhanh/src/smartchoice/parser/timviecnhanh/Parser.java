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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import smartchoice.data.models.Company;
import smartchoice.helper.HttpHelper;
import smartchoice.helper.XMLHelper;
import smartchoice.parser.timviecnhanh.models.schema.JobItem;
import smartchoice.xmlparser.XmlParserConfig;
import smartchoice.xmlparser.statemachine.HtmlPreprocessor;

/**
 *
 * @author TNT
 */
public class Parser {

    public static String NAME = "TVN";
    protected XmlParserConfig xmlParserConfig;
    protected ParserConfig parserConfig;
    protected XPath xpath;
    protected Set<String> jobLinks;
    protected Templates jobTemplate;
    protected EntityManager entityManager;
    protected CompanyService companyService;

    public Parser(EntityManager entityManager,
            CompanyService companyService,
            XmlParserConfig xmlParserConfig,
            ParserConfig parserConfig, Templates jobTemplate) {
        this.entityManager = entityManager;
        this.companyService = companyService;
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
//                FileHelper.writeToFile(pageContent, "temp.html");
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

    protected void processJobItem(JobItem jobItem) {
        //TODO
        processCompany(jobItem.getCompany());
    }

    protected boolean processCompany(JobItem.Company company) {
        String code = company.getCode();
        code = Parser.NAME + "_" + code.substring(code.lastIndexOf('-') + 1, code.lastIndexOf('.'));
        boolean existed = companyService.codeExists(code);
        if (!existed) {
            Company entity = new Company();
            entity.setCode(code);
            entity.setAddress(company.getAddress());
            entity.setDetailUrl(company.getDetailUrl());
            entity.setImage(company.getImage());
            entity.setName(company.getCode());
            if (!companyService.validateForCreate(entity)) {
                return false;
            }
            entityManager.getTransaction().begin();
            companyService.createCompany(entity);
            entityManager.getTransaction().commit();
        }
        return true;
    }

    protected String transform(String pageUrl, String pageContent) throws TransformerConfigurationException, FileNotFoundException, TransformerException {
        // Use the template to create a transformer
        Transformer xformer = jobTemplate.newTransformer();
        xformer.setParameter("url", pageUrl);
        String code = pageUrl.substring(pageUrl.lastIndexOf('-') + 1, pageUrl.lastIndexOf('.'));
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
        return page.getUrl() + "?page=" + relPath;
    }

}
