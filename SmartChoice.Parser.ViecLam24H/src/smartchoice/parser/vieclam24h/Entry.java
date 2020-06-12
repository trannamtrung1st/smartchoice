/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.vieclam24h;

import javax.xml.bind.JAXBException;
import smartchoice.helper.XMLHelper;
import smartchoice.xmlparser.XmlParserConfig;

/**
 *
 * @author TNT
 */
public class Entry {

    public static void main(String[] args) throws JAXBException {
        ParserConfig parserConfig = XMLHelper.unmarshallDoc("parser-config.xml", ObjectFactory.class);
        XmlParserConfig xmlParserConfig = XMLHelper.unmarshallDoc("xml-parser-config.xml", smartchoice.xmlparser.ObjectFactory.class);
        Parser parser = new Parser(xmlParserConfig, parserConfig);
        parser.start();
    }
}
