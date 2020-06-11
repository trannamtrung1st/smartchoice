/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.xmlparser.statemachine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TNT
 */
public class HtmlPreprocessor {

    public static String refineHtml(String src) {
        src = getBody(src);
        src = removeMiscTags(src);
        XMLSyntaxChecker checker = new XMLSyntaxChecker();
        src = checker.check(src);
        src = getBody(src);
        return src;
    }

    public static String getBody(String src) {
        String result = src;
        String regex = "<body.*?></body>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);
        if (matcher.find()) {
            result = matcher.group(0);
        }
        return result;
    }

    public static String removeMiscTags(String src) {
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
