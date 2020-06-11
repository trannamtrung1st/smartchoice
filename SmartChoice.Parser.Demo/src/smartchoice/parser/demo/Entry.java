/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.demo;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.SAXException;
import smartchoice.helper.FileHelper;
import smartchoice.helper.HttpHelper;
import smartchoice.helper.XMLHelper;
import smartchoice.xmlparser.Config;
import smartchoice.xmlparser.ObjectFactory;
import smartchoice.xmlparser.statemachine.HtmlPreprocessor;

/**
 *
 * @author TNT
 */
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, XMLStreamException, ParserConfigurationException, SAXException, JAXBException {
        String file = "viec-lam-moi.html";
        String content = HttpHelper.getPageContent("https://vieclam24h.vn/viec-lam-moi.html");
        Config config = XMLHelper.unmarshallDoc("config.xml", ObjectFactory.class);
        HtmlPreprocessor processor = new HtmlPreprocessor(config);
        content = processor.refineHtml(content);
        FileHelper.writeToFile(content, file);
        XMLHelper.parseDOMFromString(content);
    }

}
