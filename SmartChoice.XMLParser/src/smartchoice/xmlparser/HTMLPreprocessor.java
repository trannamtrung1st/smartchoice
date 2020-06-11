/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.xmlparser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import smartchoice.helper.FileHelper;
import smartchoice.helper.HttpHelper;
import smartchoice.helper.RegexHelper;
import smartchoice.helper.XMLHelper;

/**
 *
 * @author TNT
 */
public class HTMLPreprocessor {

    public static final String REMOVE_HTML_CONTENT_REGEX = "(<head[ ]*?[^>]*?>.*?(?=</head>)</head>)|(<style[ ]*?[^>]*?>.*?(?=</style>)</style>)|(<script[ ]*?[^>]*?>.*?(?=</script>)</script>)|"
            + "(<(/)?area[ ]*?[^>]*?>)|(<(/)?base[ ]*?[^>]*?>)|(<(/)?br[ ]*?[^>]*?>)|(<(/)?col[ ]*?[^>]*?>)|(<(/)?embed[ ]*?[^>]*?>)|(<(/)?hr[ ]*?[^>]*?>)|(<(/)?keygen[ ]*?[^>]*?>)|(<(/)?link[ ]*?[^>]*?>)|(<(/)?meta[ ]*?[^>]*?>)|(<(/)?param[ ]*?[^>]*?>)|(<(/)?wbr[ ]*?[^>]*?>)";

    public void processURL(String url, String destPath) throws IOException, XMLStreamException, ParserConfigurationException, SAXException {
        try (InputStream is = HttpHelper.getInputStream(url)) {
            FileHelper.saveStreamToFile(is, destPath);
            processFile(destPath, destPath);
        } finally {
        }
    }

    public void processFile(String dataPath, String destPath) throws IOException, XMLStreamException, ParserConfigurationException, SAXException {
        String content = FileHelper.readContent(dataPath);
        content = RegexHelper.replaceDotAll(content, REMOVE_HTML_CONTENT_REGEX, "");
        content = RegexHelper.replaceDotAll(content, " (selected)[^=>]?", " selected=\"\" ");
        content = RegexHelper.replaceDotAll(content, " (itemscope)[^=>]?", " itemscope=\"\" ");
        content = content.replace("\"class", "\" class");
        content = RegexHelper.replaceDotAll(content, "&nbsp;", " ");
        content = RegexHelper.replaceGroupDotAll(content, "<input(.*?[^>])(?<group>>)", "group", "/>");
        content = RegexHelper.replaceGroupDotAll(content, "<img(.*?[^>])(?<group>>)", "group", "/>");
        content = content.replace("//>", "/>");
        content = RegexHelper.replaceDotAll(content, "data-loading-text=\"(.*?)\"", "");
        content = content.replace("&", "&#38;");
        FileHelper.writeToFile(content, destPath);
        Document doc = XMLHelper.parseDOMFromString(content);
    }

}
