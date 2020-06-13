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
    @NamedQuery(name = "JobLocation.findAll", query = "SELECT j FROM JobLocation j")
    , @NamedQuery(name = "JobLocation.findByLocationName", query = "SELECT j FROM JobLocation j WHERE j.jobLocationPK.locationName = :locationName")
    , @NamedQuery(name = "JobLocation.findByJobPostCode", query = "SELECT j FROM JobLocation j WHERE j.jobLocationPK.jobPostCode = :jobPostCode")})
public class JobLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobLocationPK jobLocationPK;
    @JoinColumn(name = "locationName", referencedColumnName = "name", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;

    public JobLocation() {
    }

    public JobLocation(JobLocationPK jobLocationPK) {
        this.jobLocationPK = jobLocationPK;
    }

    public JobLocation(String locationName, String jobPostCode) {
        this.jobLocationPK = new JobLocationPK(locationName, jobPostCode);
    }

    public JobLocationPK getJobLocationPK() {
        return jobLocationPK;
    }

    public void setJobLocationPK(JobLocationPK jobLocationPK) {
        this.jobLocationPK = jobLocationPK;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobLocationPK != null ? jobLocationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobLocation)) {
            return false;
        }
        JobLocation other = (JobLocation) object;
        if ((this.jobLocationPK == null && other.jobLocationPK != null) || (this.jobLocationPK != null && !this.jobLocationPK.equals(other.jobLocationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartchoice.data.models.JobLocation[ jobLocationPK=" + jobLocationPK + " ]";
    }
    
}
