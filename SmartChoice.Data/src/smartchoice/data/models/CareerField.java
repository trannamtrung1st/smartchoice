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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "CareerField.findAll", query = "SELECT c FROM CareerField c")
    , @NamedQuery(name = "CareerField.findById", query = "SELECT c FROM CareerField c WHERE c.id = :id")
    , @NamedQuery(name = "CareerField.findByName", query = "SELECT c FROM CareerField c WHERE c.name = :name")})
public class CareerField implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "careerField")
    private Collection<JobField> jobFieldCollection;

    public CareerField() {
    }

    public CareerField(Integer id) {
        this.id = id;
    }

    public CareerField(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<JobField> getJobFieldCollection() {
        return jobFieldCollection;
    }

    public void setJobFieldCollection(Collection<JobField> jobFieldCollection) {
        this.jobFieldCollection = jobFieldCollection;
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
        if (!(object instanceof CareerField)) {
            return false;
        }
        CareerField other = (CareerField) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartchoice.data.models.CareerField[ id=" + id + " ]";
    }
    
}
