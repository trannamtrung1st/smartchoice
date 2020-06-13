/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.vieclam24h;

import java.io.FileNotFoundException;
import javax.persistence.EntityManager;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import smartchoice.business.services.CompanyService;
import smartchoice.data.EntityContext;
import smartchoice.data.daos.CompanyDAO;
import smartchoice.helper.XMLHelper;
import smartchoice.xmlparser.XmlParserConfig;

/**
 *
 * @author TNT
 */
public class Entry {

    public static void main(String[] args) throws JAXBException, TransformerConfigurationException, FileNotFoundException {
        ParserConfig parserConfig = XMLHelper.unmarshallDocFile("parser-config.xml", ObjectFactory.class);
        XmlParserConfig xmlParserConfig = XMLHelper.unmarshallDocFile("xml-parser-config.xml", smartchoice.xmlparser.ObjectFactory.class);
        Templates jobTemplate = XMLHelper.getTemplates("job-item.xsl");
        EntityContext context = EntityContext.newInstance();
        EntityManager em = context.getEntityManager();
        CompanyService companyService = new CompanyService(em, new CompanyDAO(em));
        Parser parser = new Parser(em, companyService, xmlParserConfig, parserConfig, jobTemplate);
        parser.start();
    }
}
