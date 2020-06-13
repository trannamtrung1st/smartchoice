
package smartchoice.parser.vieclam24h.models.schema;

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
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jobName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="company">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="detailUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="salaryRange" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expRequirement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="degreeRequirement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numOfVacancy" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="careerFields">
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
 *         &lt;element name="workLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="genderRequirement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="benefit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="otherRequirement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="expiredDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contactPerson" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contactAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "jobName",
    "company",
    "code",
    "salaryRange",
    "expRequirement",
    "degreeRequirement",
    "numOfVacancy",
    "careerFields",
    "workLocation",
    "genderRequirement",
    "description",
    "benefit",
    "otherRequirement",
    "expiredDate",
    "contactPerson",
    "contactAddress"
})
@XmlRootElement(name = "jobItem")
public class JobItem {

    @XmlElement(required = true)
    protected String url;
    @XmlElement(required = true)
    protected String jobName;
    @XmlElement(required = true)
    protected JobItem.Company company;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String salaryRange;
    @XmlElement(required = true)
    protected String expRequirement;
    @XmlElement(required = true)
    protected String degreeRequirement;
    @XmlSchemaType(name = "unsignedByte")
    protected short numOfVacancy;
    @XmlElement(required = true)
    protected JobItem.CareerFields careerFields;
    @XmlElement(required = true)
    protected String workLocation;
    @XmlElement(required = true)
    protected String genderRequirement;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected String benefit;
    @XmlElement(required = true)
    protected String otherRequirement;
    @XmlElement(required = true)
    protected String expiredDate;
    @XmlElement(required = true)
    protected String contactPerson;
    @XmlElement(required = true)
    protected String contactAddress;

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
     * Gets the value of the jobName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets the value of the jobName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobName(String value) {
        this.jobName = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link JobItem.Company }
     *     
     */
    public JobItem.Company getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobItem.Company }
     *     
     */
    public void setCompany(JobItem.Company value) {
        this.company = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the salaryRange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalaryRange() {
        return salaryRange;
    }

    /**
     * Sets the value of the salaryRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalaryRange(String value) {
        this.salaryRange = value;
    }

    /**
     * Gets the value of the expRequirement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpRequirement() {
        return expRequirement;
    }

    /**
     * Sets the value of the expRequirement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpRequirement(String value) {
        this.expRequirement = value;
    }

    /**
     * Gets the value of the degreeRequirement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegreeRequirement() {
        return degreeRequirement;
    }

    /**
     * Sets the value of the degreeRequirement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegreeRequirement(String value) {
        this.degreeRequirement = value;
    }

    /**
     * Gets the value of the numOfVacancy property.
     * 
     */
    public short getNumOfVacancy() {
        return numOfVacancy;
    }

    /**
     * Sets the value of the numOfVacancy property.
     * 
     */
    public void setNumOfVacancy(short value) {
        this.numOfVacancy = value;
    }

    /**
     * Gets the value of the careerFields property.
     * 
     * @return
     *     possible object is
     *     {@link JobItem.CareerFields }
     *     
     */
    public JobItem.CareerFields getCareerFields() {
        return careerFields;
    }

    /**
     * Sets the value of the careerFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobItem.CareerFields }
     *     
     */
    public void setCareerFields(JobItem.CareerFields value) {
        this.careerFields = value;
    }

    /**
     * Gets the value of the workLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Sets the value of the workLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkLocation(String value) {
        this.workLocation = value;
    }

    /**
     * Gets the value of the genderRequirement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenderRequirement() {
        return genderRequirement;
    }

    /**
     * Sets the value of the genderRequirement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenderRequirement(String value) {
        this.genderRequirement = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the benefit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenefit() {
        return benefit;
    }

    /**
     * Sets the value of the benefit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenefit(String value) {
        this.benefit = value;
    }

    /**
     * Gets the value of the otherRequirement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherRequirement() {
        return otherRequirement;
    }

    /**
     * Sets the value of the otherRequirement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherRequirement(String value) {
        this.otherRequirement = value;
    }

    /**
     * Gets the value of the expiredDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiredDate() {
        return expiredDate;
    }

    /**
     * Sets the value of the expiredDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiredDate(String value) {
        this.expiredDate = value;
    }

    /**
     * Gets the value of the contactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * Sets the value of the contactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPerson(String value) {
        this.contactPerson = value;
    }

    /**
     * Gets the value of the contactAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * Sets the value of the contactAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactAddress(String value) {
        this.contactAddress = value;
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
    public static class CareerFields {

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
     *         &lt;element name="detailUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "detailUrl",
        "name"
    })
    public static class Company {

        @XmlElement(required = true)
        protected String detailUrl;
        @XmlElement(required = true)
        protected String name;

        /**
         * Gets the value of the detailUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDetailUrl() {
            return detailUrl;
        }

        /**
         * Sets the value of the detailUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDetailUrl(String value) {
            this.detailUrl = value;
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

    }

}
