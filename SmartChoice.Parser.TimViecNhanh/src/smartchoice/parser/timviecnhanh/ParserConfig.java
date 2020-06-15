
package smartchoice.parser.timviecnhanh;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maleStr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="femaleStr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="salaryRangeRegex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="moneyConversion" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="codeFromUrlRegex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pagingAppendStr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="careerMapping">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="locationMapping">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
    "pages",
    "name",
    "dateFormat",
    "maleStr",
    "femaleStr",
    "salaryRangeRegex",
    "moneyConversion",
    "codeFromUrlRegex",
    "pagingAppendStr",
    "careerMapping",
    "locationMapping"
})
@XmlRootElement(name = "parserConfig")
public class ParserConfig {

    @XmlElement(required = true)
    protected String baseUrl;
    @XmlElement(required = true)
    protected ParserConfig.Pages pages;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String dateFormat;
    @XmlElement(required = true)
    protected String maleStr;
    @XmlElement(required = true)
    protected String femaleStr;
    @XmlElement(required = true)
    protected String salaryRangeRegex;
    @XmlSchemaType(name = "unsignedInt")
    protected long moneyConversion;
    @XmlElement(required = true)
    protected String codeFromUrlRegex;
    @XmlElement(required = true)
    protected String pagingAppendStr;
    @XmlElement(required = true)
    protected ParserConfig.CareerMapping careerMapping;
    @XmlElement(required = true)
    protected ParserConfig.LocationMapping locationMapping;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the dateFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * Sets the value of the dateFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFormat(String value) {
        this.dateFormat = value;
    }

    /**
     * Gets the value of the maleStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaleStr() {
        return maleStr;
    }

    /**
     * Sets the value of the maleStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaleStr(String value) {
        this.maleStr = value;
    }

    /**
     * Gets the value of the femaleStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFemaleStr() {
        return femaleStr;
    }

    /**
     * Sets the value of the femaleStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFemaleStr(String value) {
        this.femaleStr = value;
    }

    /**
     * Gets the value of the salaryRangeRegex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalaryRangeRegex() {
        return salaryRangeRegex;
    }

    /**
     * Sets the value of the salaryRangeRegex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalaryRangeRegex(String value) {
        this.salaryRangeRegex = value;
    }

    /**
     * Gets the value of the moneyConversion property.
     * 
     */
    public long getMoneyConversion() {
        return moneyConversion;
    }

    /**
     * Sets the value of the moneyConversion property.
     * 
     */
    public void setMoneyConversion(long value) {
        this.moneyConversion = value;
    }

    /**
     * Gets the value of the codeFromUrlRegex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeFromUrlRegex() {
        return codeFromUrlRegex;
    }

    /**
     * Sets the value of the codeFromUrlRegex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeFromUrlRegex(String value) {
        this.codeFromUrlRegex = value;
    }

    /**
     * Gets the value of the pagingAppendStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagingAppendStr() {
        return pagingAppendStr;
    }

    /**
     * Sets the value of the pagingAppendStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagingAppendStr(String value) {
        this.pagingAppendStr = value;
    }

    /**
     * Gets the value of the careerMapping property.
     * 
     * @return
     *     possible object is
     *     {@link ParserConfig.CareerMapping }
     *     
     */
    public ParserConfig.CareerMapping getCareerMapping() {
        return careerMapping;
    }

    /**
     * Sets the value of the careerMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParserConfig.CareerMapping }
     *     
     */
    public void setCareerMapping(ParserConfig.CareerMapping value) {
        this.careerMapping = value;
    }

    /**
     * Gets the value of the locationMapping property.
     * 
     * @return
     *     possible object is
     *     {@link ParserConfig.LocationMapping }
     *     
     */
    public ParserConfig.LocationMapping getLocationMapping() {
        return locationMapping;
    }

    /**
     * Sets the value of the locationMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParserConfig.LocationMapping }
     *     
     */
    public void setLocationMapping(ParserConfig.LocationMapping value) {
        this.locationMapping = value;
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
     *         &lt;element name="item" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "item"
    })
    public static class CareerMapping {

        @XmlElement(required = true)
        protected List<String> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getItem() {
            if (item == null) {
                item = new ArrayList<String>();
            }
            return this.item;
        }

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
     *         &lt;element name="item" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "item"
    })
    public static class LocationMapping {

        @XmlElement(required = true)
        protected List<String> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getItem() {
            if (item == null) {
                item = new ArrayList<String>();
            }
            return this.item;
        }

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
