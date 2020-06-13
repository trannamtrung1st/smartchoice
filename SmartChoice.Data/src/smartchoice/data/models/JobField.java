/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.data.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TNT
 */
@Entity
@Table(catalog = "SmartChoice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobField.findAll", query = "SELECT j FROM JobField j")
    , @NamedQuery(name = "JobField.findByCareerFieldId", query = "SELECT j FROM JobField j WHERE j.jobFieldPK.careerFieldId = :careerFieldId")
    , @NamedQuery(name = "JobField.findByJobPostCode", query = "SELECT j FROM JobField j WHERE j.jobFieldPK.jobPostCode = :jobPostCode")})
public class JobField implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobFieldPK jobFieldPK;
    @JoinColumn(name = "careerFieldId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CareerField careerField;

    public JobField() {
    }

    public JobField(JobFieldPK jobFieldPK) {
        this.jobFieldPK = jobFieldPK;
    }

    public JobField(int careerFieldId, String jobPostCode) {
        this.jobFieldPK = new JobFieldPK(careerFieldId, jobPostCode);
    }

    public JobFieldPK getJobFieldPK() {
        return jobFieldPK;
    }

    public void setJobFieldPK(JobFieldPK jobFieldPK) {
        this.jobFieldPK = jobFieldPK;
    }

    public CareerField getCareerField() {
        return careerField;
    }

    public void setCareerField(CareerField careerField) {
        this.careerField = careerField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobFieldPK != null ? jobFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobField)) {
            return false;
        }
        JobField other = (JobField) object;
        if ((this.jobFieldPK == null && other.jobFieldPK != null) || (this.jobFieldPK != null && !this.jobFieldPK.equals(other.jobFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartchoice.data.models.JobField[ jobFieldPK=" + jobFieldPK + " ]";
    }
    
}
