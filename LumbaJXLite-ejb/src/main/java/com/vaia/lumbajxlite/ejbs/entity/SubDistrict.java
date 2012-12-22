/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(catalog = "DB_LUMBA", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"subdistrictcode"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subdistrict.findAll", query = "SELECT s FROM Subdistrict s"),
    @NamedQuery(name = "Subdistrict.findBySubdistrictid", query = "SELECT s FROM Subdistrict s WHERE s.subdistrictid = :subdistrictid"),
    @NamedQuery(name = "Subdistrict.findBySubdistrictcode", query = "SELECT s FROM Subdistrict s WHERE s.subdistrictcode = :subdistrictcode"),
    @NamedQuery(name = "Subdistrict.findBySubdistrictname", query = "SELECT s FROM Subdistrict s WHERE s.subdistrictname = :subdistrictname"),
    @NamedQuery(name = "Subdistrict.findByCreationdate", query = "SELECT s FROM Subdistrict s WHERE s.creationdate = :creationdate"),
    @NamedQuery(name = "Subdistrict.findByEditdate", query = "SELECT s FROM Subdistrict s WHERE s.editdate = :editdate"),
    @NamedQuery(name = "Subdistrict.findByCreator", query = "SELECT s FROM Subdistrict s WHERE s.creator = :creator"),
    @NamedQuery(name = "Subdistrict.findByEditor", query = "SELECT s FROM Subdistrict s WHERE s.editor = :editor"),
    @NamedQuery(name = "Subdistrict.findBySessiondate", query = "SELECT s FROM Subdistrict s WHERE s.sessiondate = :sessiondate")})
public class SubDistrict implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer subdistrictid;
    @Size(max = 15)
    @Column(length = 15)
    private String subdistrictcode;
    @Size(max = 100)
    @Column(length = 100)
    private String subdistrictname;
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
    @OneToMany(mappedBy = "subdistrictid")
    private List<Village> villageList;
    @JoinColumn(name = "districtid", referencedColumnName = "districtid")
    @ManyToOne
    private District districtid;

    public SubDistrict() {
    }

    public SubDistrict(Integer subdistrictid) {
        this.subdistrictid = subdistrictid;
    }

    public Integer getSubdistrictid() {
        return subdistrictid;
    }

    public void setSubdistrictid(Integer subdistrictid) {
        this.subdistrictid = subdistrictid;
    }

    public String getSubdistrictcode() {
        return subdistrictcode;
    }

    public void setSubdistrictcode(String subdistrictcode) {
        this.subdistrictcode = subdistrictcode;
    }

    public String getSubdistrictname() {
        return subdistrictname;
    }

    public void setSubdistrictname(String subdistrictname) {
        this.subdistrictname = subdistrictname;
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

    @XmlTransient
    public List<Village> getVillageList() {
        return villageList;
    }

    public void setVillageList(List<Village> villageList) {
        this.villageList = villageList;
    }

    public District getDistrictid() {
        return districtid;
    }

    public void setDistrictid(District districtid) {
        this.districtid = districtid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subdistrictid != null ? subdistrictid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubDistrict)) {
            return false;
        }
        SubDistrict other = (SubDistrict) object;
        if ((this.subdistrictid == null && other.subdistrictid != null) || (this.subdistrictid != null && !this.subdistrictid.equals(other.subdistrictid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Subdistrict[ subdistrictid=" + subdistrictid + " ]";
    }

}
