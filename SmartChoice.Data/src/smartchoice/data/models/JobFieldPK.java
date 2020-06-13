/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.data.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author TNT
 */
@Embeddable
public class JobFieldPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int careerFieldId;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String jobPostCode;

    public JobFieldPK() {
    }

    public JobFieldPK(int careerFieldId, String jobPostCode) {
        this.careerFieldId = careerFieldId;
        this.jobPostCode = jobPostCode;
    }

    public int getCareerFieldId() {
        return careerFieldId;
    }

    public void setCareerFieldId(int careerFieldId) {
        this.careerFieldId = careerFieldId;
    }

    public String getJobPostCode() {
        return jobPostCode;
    }

    public void setJobPostCode(String jobPostCode) {
        this.jobPostCode = jobPostCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) careerFieldId;
        hash += (jobPostCode != null ? jobPostCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobFieldPK)) {
            return false;
        }
        JobFieldPK other = (JobFieldPK) object;
        if (this.careerFieldId != other.careerFieldId) {
            return false;
        }
        if ((this.jobPostCode == null && other.jobPostCode != null) || (this.jobPostCode != null && !this.jobPostCode.equals(other.jobPostCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartchoice.data.models.JobFieldPK[ careerFieldId=" + careerFieldId + ", jobPostCode=" + jobPostCode + " ]";
    }
    
}
