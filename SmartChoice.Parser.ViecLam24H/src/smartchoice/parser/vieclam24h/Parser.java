/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.vieclam24h;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import smartchoice.helper.FileHelper;
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

    public Parser(XmlParserConfig xmlParserConfig, ParserConfig parserConfig) {
        this.xmlParserConfig = xmlParserConfig;
        this.parserConfig = parserConfig;
    }

    public void start() {
        for (ParserConfig.Pages.Page page : parserConfig.getPages().getPage()) {
            try {
                System.out.println("Start parsing page: " + page.getUrl());
                parsePage(page);
                System.out.println("Finish parsing page: " + page.getUrl());
                System.out.println("------------------------");
            } catch (IOException | JAXBException | ParserConfigurationException | SAXException e) {
                System.out.println("Error parse page: " + page.getUrl());
                e.printStackTrace();
            }
        }
    }

    protected void parsePage(ParserConfig.Pages.Page page) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        FileHelper.removeAllTempFileInFolderPath("");
        String file = FileHelper.randomFileName(10) + ".tmp";
        String content = HttpHelper.getPageContent(page.url);
        HtmlPreprocessor processor = new HtmlPreprocessor(xmlParserConfig);
        content = processor.refineHtml(content);
        FileHelper.writeToFile(content, file);
        XMLHelper.parseDOMFromString(content);
    }

}
