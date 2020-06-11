/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.xmlparser.statemachine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import smartchoice.xmlparser.Config;

/**
 *
 * @author TNT
 */
public class HtmlPreprocessor {

    private final Config config;

    public HtmlPreprocessor(Config config) {
        this.config = config;
    }

    public String refineHtml(String src) {
        src = getNecessaryPart(src);
        src = removeMiscs(src);
        XMLSyntaxChecker checker = new XMLSyntaxChecker();
        src = checker.check(src);
        src = getNecessaryPart(src);
        return src;
    }

    public String getNecessaryPart(String src) {
        String result = src;
        String regex = "<body.*?></body>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
            result = matcher.group(0);
        }
        return result;
    }

    public String removeMiscs(String src) {
        String result = src;
        String regex = "<script.*?</script>";
        result = result.replaceAll(regex, "");
        regex = "<style.*?</style>";//custom
        result = result.replaceAll(regex, "");
        regex = "<!--.*?-->";
        result = result.replaceAll(regex, "");
        regex = "&nbsp;";
        result = result.replaceAll(regex, "");
        return result;
    }
}
