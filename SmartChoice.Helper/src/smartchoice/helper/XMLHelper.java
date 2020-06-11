/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.helper;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.ErrorListener;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author TNT
 */
public class XMLHelper {

    public static XMLEventReader getXMLEventReader(InputStream stream) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLEventReader reader = factory.createXMLEventReader(stream);
        return reader;
    }

    public static Document parseDOMFromString(String srcXml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(FileHelper.getStreamFromString(srcXml));
        return doc;
    }

    public static <T> T unmarshallElement(String file, Class objectFactoryClass) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(objectFactoryClass);
        Unmarshaller u = jc.createUnmarshaller();
        File f = new File(file);
        T obj = (T) ((JAXBElement) u.unmarshal(f)).getValue();
        return obj;
    }

    public static <T> T unmarshallDoc(String file, Class objectFactoryClass) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(objectFactoryClass);
        Unmarshaller u = jc.createUnmarshaller();
        File f = new File(file);
        T obj = (T) u.unmarshal(f);
        return obj;
    }

    public static void generateCodeFromSchema(String output, String forcePkgName, String xsd, ErrorListener errListener) throws IOException {
        SchemaCompiler sc = XJC.createSchemaCompiler();
        if (errListener != null) {
            sc.setErrorListener(errListener);
        }
        sc.forcePackageName(forcePkgName);
        File schema = new File(xsd);
        InputSource is = new InputSource(schema.toURI().toString());
        sc.parseSchema(is);
        S2JJAXBModel model = sc.bind();
        JCodeModel code = model.generateCode(null, null);
        code.build(new File(output));
    }

}
