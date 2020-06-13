/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.data.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TNT
 */
@Entity
@Table(catalog = "SmartChoice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByName", query = "SELECT l FROM Location l WHERE l.name = :name")
    , @NamedQuery(name = "Location.findByIsInVietNam", query = "SELECT l FROM Location l WHERE l.isInVietNam = :isInVietNam")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String name;
    private Boolean isInVietNam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<JobLocation> jobLocationCollection;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsInVietNam() {
        return isInVietNam;
    }

    public void setIsInVietNam(Boolean isInVietNam) {
        this.isInVietNam = isInVietNam;
    }

    @XmlTransient
    public Collection<JobLocation> getJobLocationCollection() {
        return jobLocationCollection;
    }

    public void setJobLocationCollection(Collection<JobLocation> jobLocationCollection) {
        this.jobLocationCollection = jobLocationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartchoice.data.models.Location[ name=" + name + " ]";
    }
    
}
