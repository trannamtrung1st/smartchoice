/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.parser.timviecnhanh;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Templates;
import javax.xml.transform.TransformerConfigurationException;
import smartchoice.business.services.CareerFieldService;
import smartchoice.business.services.CompanyService;
import smartchoice.business.services.JobPostService;
import smartchoice.business.services.LocationService;
import smartchoice.data.EntityContext;
import smartchoice.data.daos.CareerFieldDAO;
import smartchoice.data.daos.CompanyDAO;
import smartchoice.data.daos.JobPostDAO;
import smartchoice.data.daos.LocationDAO;
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
        JobPostService jobPostService = new JobPostService(em, new JobPostDAO(em));
        CareerFieldService careerFieldService = new CareerFieldService(em, new CareerFieldDAO(em));
        LocationService locationService = new LocationService(em, new LocationDAO(em));
        Map<String, String> careerMapping = new HashMap<>();
        for (String item : parserConfig.getCareerMapping().getItem()) {
            String[] kvp = item.split("~");
            careerMapping.put(kvp[0].trim(), kvp[1].trim());
        }
        Map<String, String> locationMapping = new HashMap<>();
        for (String item : parserConfig.getLocationMapping().getItem()) {
            String[] kvp = item.split("~");
            locationMapping.put(kvp[0].trim(), kvp[1].trim());
        }
        Parser parser = new Parser(em, companyService, jobPostService, locationService, careerFieldService,
                xmlParserConfig, parserConfig, jobTemplate, careerMapping, locationMapping);
        parser.start();
    }
}
