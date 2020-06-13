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
public class JobLocationPK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String locationName;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String jobPostCode;

    public JobLocationPK() {
    }

    public JobLocationPK(String locationName, String jobPostCode) {
        this.locationName = locationName;
        this.jobPostCode = jobPostCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
        hash += (locationName != null ? locationName.hashCode() : 0);
        hash += (jobPostCode != null ? jobPostCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobLocationPK)) {
            return false;
        }
        JobLocationPK other = (JobLocationPK) object;
        if ((this.locationName == null && other.locationName != null) || (this.locationName != null && !this.locationName.equals(other.locationName))) {
            return false;
        }
        if ((this.jobPostCode == null && other.jobPostCode != null) || (this.jobPostCode != null && !this.jobPostCode.equals(other.jobPostCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartchoice.data.models.JobLocationPK[ locationName=" + locationName + ", jobPostCode=" + jobPostCode + " ]";
    }
    
}
