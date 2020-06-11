/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.xmlparser;

import java.io.IOException;
import smartchoice.helper.XMLHelper;

/**
 *
 * @author TNT
 */
public class Console {

    public static void main(String[] args) throws IOException {
        XMLHelper.generateCodeFromSchema("src/", "smartchoice.xmlparser", "config.xsd", null);
    }
}
