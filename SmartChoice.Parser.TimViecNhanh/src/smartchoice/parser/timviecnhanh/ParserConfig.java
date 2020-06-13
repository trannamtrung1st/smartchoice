
package smartchoice.parser.timviecnhanh;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baseUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pages">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="page" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="jobLinksXPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="pagingLinksXPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "baseUrl",
    "pages"
})
@XmlRootElement(name = "parserConfig")
public class ParserConfig {

    @XmlElement(required = true)
    protected String baseUrl;
    @XmlElement(required = true)
    protected ParserConfig.Pages pages;

    /**
     * Gets the value of the baseUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets the value of the baseUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseUrl(String value) {
        this.baseUrl = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * @return
     *     possible object is
     *     {@link ParserConfig.Pages }
     *     
     */
    public ParserConfig.Pages getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParserConfig.Pages }
     *     
     */
    public void setPages(ParserConfig.Pages value) {
        this.pages = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="page" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="jobLinksXPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="pagingLinksXPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "page"
    })
    public static class Pages {

        @XmlElement(required = true)
        protected List<ParserConfig.Pages.Page> page;

        /**
         * Gets the value of the page property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the page property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ParserConfig.Pages.Page }
         * 
         * 
         */
        public List<ParserConfig.Pages.Page> getPage() {
            if (page == null) {
                page = new ArrayList<ParserConfig.Pages.Page>();
            }
            return this.page;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="jobLinksXPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="pagingLinksXPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "url",
            "jobLinksXPath",
            "pagingLinksXPath"
        })
        public static class Page {

            @XmlElement(required = true)
            protected String url;
            @XmlElement(required = true)
            protected String jobLinksXPath;
            @XmlElement(required = true)
            protected String pagingLinksXPath;

            /**
             * Gets the value of the url property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrl() {
                return url;
            }

            /**
             * Sets the value of the url property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrl(String value) {
                this.url = value;
            }

            /**
             * Gets the value of the jobLinksXPath property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getJobLinksXPath() {
                return jobLinksXPath;
            }

            /**
             * Sets the value of the jobLinksXPath property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setJobLinksXPath(String value) {
                this.jobLinksXPath = value;
            }

            /**
             * Gets the value of the pagingLinksXPath property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPagingLinksXPath() {
                return pagingLinksXPath;
            }

            /**
             * Sets the value of the pagingLinksXPath property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPagingLinksXPath(String value) {
                this.pagingLinksXPath = value;
            }

        }

    }

}
