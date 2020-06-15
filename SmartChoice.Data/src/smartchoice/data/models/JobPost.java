/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.data.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TNT
 */
@Entity
@Table(catalog = "SmartChoice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobPost.findAll", query = "SELECT j FROM JobPost j")
    , @NamedQuery(name = "JobPost.findById", query = "SELECT j FROM JobPost j WHERE j.id = :id")
    , @NamedQuery(name = "JobPost.findByCode", query = "SELECT j FROM JobPost j WHERE j.code = :code")
    , @NamedQuery(name = "JobPost.findByName", query = "SELECT j FROM JobPost j WHERE j.name = :name")
    , @NamedQuery(name = "JobPost.findByUrl", query = "SELECT j FROM JobPost j WHERE j.url = :url")
    , @NamedQuery(name = "JobPost.findBySalaryFrom", query = "SELECT j FROM JobPost j WHERE j.salaryFrom = :salaryFrom")
    , @NamedQuery(name = "JobPost.findBySalaryTo", query = "SELECT j FROM JobPost j WHERE j.salaryTo = :salaryTo")
    , @NamedQuery(name = "JobPost.findByExperienceRequirement", query = "SELECT j FROM JobPost j WHERE j.experienceRequirement = :experienceRequirement")
    , @NamedQuery(name = "JobPost.findByDegreeRequirement", query = "SELECT j FROM JobPost j WHERE j.degreeRequirement = :degreeRequirement")
    , @NamedQuery(name = "JobPost.findByNumOfVacancy", query = "SELECT j FROM JobPost j WHERE j.numOfVacancy = :numOfVacancy")
    , @NamedQuery(name = "JobPost.findByGenderRequirement", query = "SELECT j FROM JobPost j WHERE j.genderRequirement = :genderRequirement")
    , @NamedQuery(name = "JobPost.findByDescription", query = "SELECT j FROM JobPost j WHERE j.description = :description")
    , @NamedQuery(name = "JobPost.findByBenefit", query = "SELECT j FROM JobPost j WHERE j.benefit = :benefit")
    , @NamedQuery(name = "JobPost.findByOtherRequirement", query = "SELECT j FROM JobPost j WHERE j.otherRequirement = :otherRequirement")
    , @NamedQuery(name = "JobPost.findByExpiredDate", query = "SELECT j FROM JobPost j WHERE j.expiredDate = :expiredDate")
    , @NamedQuery(name = "JobPost.findByUpdatedDate", query = "SELECT j FROM JobPost j WHERE j.updatedDate = :updatedDate")
    , @NamedQuery(name = "JobPost.findByContactPerson", query = "SELECT j FROM JobPost j WHERE j.contactPerson = :contactPerson")
    , @NamedQuery(name = "JobPost.findByContactAddress", query = "SELECT j FROM JobPost j WHERE j.contactAddress = :contactAddress")})
public class JobPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Column(length = 1000)
    private String url;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53)
    private Double salaryFrom;
    @Column(precision = 53)
    private Double salaryTo;
    @Column(length = 100)
    private String experienceRequirement;
    @Column(length = 100)
    private String degreeRequirement;
    private Integer numOfVacancy;
    private Boolean genderRequirement;
    @Column(length = 2147483647)
    private String description;
    @Column(length = 2147483647)
    private String benefit;
    @Column(length = 2147483647)
    private String otherRequirement;
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
    @Column(length = 255)
    private String contactPerson;
    @Column(length = 500)
    private String contactAddress;
    @JoinColumn(name = "companyId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Company companyId;

    public JobPost() {
    }

    public JobPost(Integer id) {
        this.id = id;
    }

    public JobPost(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(Double salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public Double getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(Double salaryTo) {
        this.salaryTo = salaryTo;
    }

    public String getExperienceRequirement() {
        return experienceRequirement;
    }

    public void setExperienceRequirement(String experienceRequirement) {
        this.experienceRequirement = experienceRequirement;
    }

    public String getDegreeRequirement() {
        return degreeRequirement;
    }

    public void setDegreeRequirement(String degreeRequirement) {
        this.degreeRequirement = degreeRequirement;
    }

    public Integer getNumOfVacancy() {
        return numOfVacancy;
    }

    public void setNumOfVacancy(Integer numOfVacancy) {
        this.numOfVacancy = numOfVacancy;
    }

    public Boolean getGenderRequirement() {
        return genderRequirement;
    }

    public void setGenderRequirement(Boolean genderRequirement) {
        this.genderRequirement = genderRequirement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getOtherRequirement() {
        return otherRequirement;
    }

    public void setOtherRequirement(String otherRequirement) {
        this.otherRequirement = otherRequirement;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPost)) {
            return false;
        }
        JobPost other = (JobPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartchoice.data.models.JobPost[ id=" + id + " ]";
    }
    
}
