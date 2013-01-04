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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"districtcode"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
    @NamedQuery(name = "District.findAllByProvinceid", query = "SELECT d FROM District d WHERE d.provinceid = :provinceid ORDER BY d.districtname"),
    @NamedQuery(name = "District.findByDistrictid", query = "SELECT d FROM District d WHERE d.districtid = :districtid"),
    @NamedQuery(name = "District.findByDistrictcode", query = "SELECT d FROM District d WHERE d.districtcode = :districtcode"),
    @NamedQuery(name = "District.findByDistrictname", query = "SELECT d FROM District d WHERE d.districtname = :districtname"),
    @NamedQuery(name = "District.findByCreationdate", query = "SELECT d FROM District d WHERE d.creationdate = :creationdate"),
    @NamedQuery(name = "District.findByEditdate", query = "SELECT d FROM District d WHERE d.editdate = :editdate"),
    @NamedQuery(name = "District.findByCreator", query = "SELECT d FROM District d WHERE d.creator = :creator"),
    @NamedQuery(name = "District.findByEditor", query = "SELECT d FROM District d WHERE d.editor = :editor"),
    @NamedQuery(name = "District.findBySandi", query = "SELECT d FROM District d WHERE d.sandi = :sandi"),
    @NamedQuery(name = "District.findBySessiondate", query = "SELECT d FROM District d WHERE d.sessiondate = :sessiondate")})
public class District implements Serializable {

    public static final String SQL_FIND_BY_PROVINCE = "District.findAllByProvinceid";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer districtid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(nullable = false, length = 8)
    private String districtcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String districtname;
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
    @Size(max = 4)
    @Column(length = 4)
    private String sandi;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @JoinColumn(name = "provinceid", referencedColumnName = "provinceid", nullable = false)
    @ManyToOne(optional = false)
    private Province provinceid;
    @OneToMany(mappedBy = "districtid")
    private List<Subdistrict> subdistrictList;

    public District() {
    }

    public District(Integer districtid) {
        this.districtid = districtid;
    }

    public District(Integer districtid, String districtcode, String districtname) {
        this.districtid = districtid;
        this.districtcode = districtcode;
        this.districtname = districtname;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
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

    public String getSandi() {
        return sandi;
    }

    public void setSandi(String sandi) {
        this.sandi = sandi;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Province getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Province provinceid) {
        this.provinceid = provinceid;
    }

    @XmlTransient
    public List<Subdistrict> getSubdistrictList() {
        return subdistrictList;
    }

    public void setSubdistrictList(List<Subdistrict> subdistrictList) {
        this.subdistrictList = subdistrictList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtid != null ? districtid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.districtid == null && other.districtid != null) || (this.districtid != null && !this.districtid.equals(other.districtid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.District[ districtid=" + districtid + " ]";
    }
}
