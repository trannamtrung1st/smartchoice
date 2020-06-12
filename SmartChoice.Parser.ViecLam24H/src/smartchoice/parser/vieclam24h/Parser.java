/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.vieclam24h;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import smartchoice.helper.HttpHelper;
import smartchoice.helper.XMLHelper;
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
    protected List<String> jobLinks;
    protected Templates jobTemplate;

    public Parser(XmlParserConfig xmlParserConfig, ParserConfig parserConfig, Templates jobTemplate) {
        this.xmlParserConfig = xmlParserConfig;
        this.parserConfig = parserConfig;
        this.xpath = XMLHelper.getXPath();
        this.jobLinks = new ArrayList<>();
        this.jobTemplate = jobTemplate;
    }

    public void start() {
        for (ParserConfig.Pages.Page page : parserConfig.getPages().getPage()) {
            try {
                System.out.println("Start parsing page: " + page.getUrl());
                parsePage(page);
                System.out.println("Finish parsing page: " + page.getUrl());
                System.out.println("------------------------");
            } catch (IOException | JAXBException | ParserConfigurationException | SAXException | XPathExpressionException e) {
                System.out.println("Error parse page: " + page.getUrl());
                e.printStackTrace();
            }
        }
    }

    protected void parsePage(ParserConfig.Pages.Page startPage) throws IOException, JAXBException, ParserConfigurationException, SAXException, XPathExpressionException {
        String content = preprocess(startPage.getUrl());

        //parse DOM and use XPath to get links
        Document doc = XMLHelper.parseDOMFromString(content);
        getLinks(jobLinks, doc, startPage);
        //parse another pages
        NodeList pageLinkNodes = (NodeList) xpath.evaluate(startPage.getPagingLinksXPath(), doc, XPathConstants.NODESET);
        for (int i = 0; i < pageLinkNodes.getLength(); i++) {
            String pageLink = pageLinkNodes.item(i).getNodeValue();
            pageLink = resolveFullUrl(startPage, pageLink);
            content = preprocess(pageLink);
            doc = XMLHelper.parseDOMFromString(content);
            getLinks(jobLinks, doc, startPage);
        }
        //get uncrawled links only
        filterLinks();
        System.out.println(jobLinks.size());
        for (String jobLink : jobLinks) {
            try {
                System.out.println("Start parsing page: " + jobLink);
                String pageContent = preprocess(jobLink);
                String modelXml = transform(pageContent);
                System.out.println(modelXml);
                System.out.println("Finish parsing page: " + jobLink);
                System.out.println("------------------------");
            } catch (IOException | TransformerException e) {
                System.out.println("Parsing error: " + jobLink);
                e.printStackTrace();
            }
        }
    }

    protected void filterLinks() {
        //TODO
    }

    protected String transform(String pageContent) throws TransformerConfigurationException, FileNotFoundException, TransformerException {
        // Use the template to create a transformer
        Transformer xformer = jobTemplate.newTransformer();
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

    protected void getLinks(List<String> jobLinks, Document doc, ParserConfig.Pages.Page page) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
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

}
