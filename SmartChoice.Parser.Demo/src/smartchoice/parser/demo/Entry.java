/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import org.xml.sax.SAXException;
import smartchoice.helper.FileHelper;
import smartchoice.helper.HttpHelper;
import smartchoice.helper.RegexHelper;
import smartchoice.helper.XMLHelper;
import smartchoice.xmlparser.HTMLPreprocessor;
import smartchoice.xmlparser.HTMLPreprocessorOld;
import smartchoice.xmlparser.statemachine.HtmlPreprocessor;

/**
 *
 * @author TNT
 */
public class Entry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, XMLStreamException, ParserConfigurationException, SAXException {
//        HTMLPreprocessor processor = new HTMLPreprocessor();
        String file = "viec-lam-moi.html";
//        processor.processURL("https://vieclam24h.vn/viec-lam-moi.html", file);
        String content = HttpHelper.getPageContent("https://vieclam24h.vn/viec-lam-moi.html");
        content = HtmlPreprocessor.refineHtml(content);
        FileHelper.writeToFile(content, file);
        XMLHelper.parseDOMFromString(content);
    }

}
