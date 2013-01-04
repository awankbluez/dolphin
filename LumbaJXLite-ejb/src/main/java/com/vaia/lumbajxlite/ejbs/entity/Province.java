/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"provincename"}),
    @UniqueConstraint(columnNames = {"provincecode"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p"),
    @NamedQuery(name = "Province.findByProvinceid", query = "SELECT p FROM Province p WHERE p.provinceid = :provinceid"),
    @NamedQuery(name = "Province.findByProvincecode", query = "SELECT p FROM Province p WHERE p.provincecode = :provincecode"),
    @NamedQuery(name = "Province.findByProvincename", query = "SELECT p FROM Province p WHERE p.provincename = :provincename"),
    @NamedQuery(name = "Province.findByCreationdate", query = "SELECT p FROM Province p WHERE p.creationdate = :creationdate"),
    @NamedQuery(name = "Province.findByEditdate", query = "SELECT p FROM Province p WHERE p.editdate = :editdate"),
    @NamedQuery(name = "Province.findByCreator", query = "SELECT p FROM Province p WHERE p.creator = :creator"),
    @NamedQuery(name = "Province.findByEditor", query = "SELECT p FROM Province p WHERE p.editor = :editor"),
    @NamedQuery(name = "Province.findBySessiondate", query = "SELECT p FROM Province p WHERE p.sessiondate = :sessiondate")})
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer provinceid;
    @Size(max = 4)
    @Column(length = 4)
    private String provincecode;
    @Size(max = 100)
    @Column(length = 100)
    private String provincename;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 40)
    @Column(length = 40)
    private String creator;
    @Size(max = 40)
    @Column(length = 40)
    private String editor;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @JoinColumn(name = "countryid", referencedColumnName = "countryid")
    @ManyToOne
    private Country countryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provinceid")
    private List<District> districtList;

    public Province() {
    }

    public Province(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    @XmlTransient
    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceid != null ? provinceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Province)) {
            return false;
        }
        Province other = (Province) object;
        if ((this.provinceid == null && other.provinceid != null) || (this.provinceid != null && !this.provinceid.equals(other.provinceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Province[ provinceid=" + provinceid + " ]";
    }

}
