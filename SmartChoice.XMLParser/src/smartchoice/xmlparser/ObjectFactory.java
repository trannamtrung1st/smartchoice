
package smartchoice.xmlparser;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the smartchoice.xmlparser package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: smartchoice.xmlparser
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Config }
     * 
     */
    public Config createConfig() {
        return new Config();
    }

    /**
     * Create an instance of {@link Config.AttrReplacements }
     * 
     */
    public Config.AttrReplacements createConfigAttrReplacements() {
        return new Config.AttrReplacements();
    }

    /**
     * Create an instance of {@link Config.OpenBracketReplacements }
     * 
     */
    public Config.OpenBracketReplacements createConfigOpenBracketReplacements() {
        return new Config.OpenBracketReplacements();
    }

    /**
     * Create an instance of {@link Config.Miscs }
     * 
     */
    public Config.Miscs createConfigMiscs() {
        return new Config.Miscs();
    }

    /**
     * Create an instance of {@link Config.AttrReplacements.Replacement }
     * 
     */
    public Config.AttrReplacements.Replacement createConfigAttrReplacementsReplacement() {
        return new Config.AttrReplacements.Replacement();
    }

    /**
     * Create an instance of {@link Config.OpenBracketReplacements.Replacement }
     * 
     */
    public Config.OpenBracketReplacements.Replacement createConfigOpenBracketReplacementsReplacement() {
        return new Config.OpenBracketReplacements.Replacement();
    }

}
