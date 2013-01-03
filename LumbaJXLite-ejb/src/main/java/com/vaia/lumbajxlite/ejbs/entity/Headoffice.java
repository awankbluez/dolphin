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
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Headoffice.findAll", query = "SELECT h FROM Headoffice h"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByHeadofficeid", query = "SELECT h FROM Headoffice h WHERE h.headofficeid = :headofficeid"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByHeadofficecode", query = "SELECT h FROM Headoffice h WHERE h.headofficecode = :headofficecode"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByHeadofficename", query = "SELECT h FROM Headoffice h WHERE h.headofficename = :headofficename"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByBusinessunit", query = "SELECT h FROM Headoffice h WHERE h.businessunit = :businessunit"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByHeadofficestatus", query = "SELECT h FROM Headoffice h WHERE h.headofficestatus = :headofficestatus"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByCreator", query = "SELECT h FROM Headoffice h WHERE h.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByEditor", query = "SELECT h FROM Headoffice h WHERE h.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByCreationdate", query = "SELECT h FROM Headoffice h WHERE h.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByEditdate", query = "SELECT h FROM Headoffice h WHERE h.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByBranchvaultaccount", query = "SELECT h FROM Headoffice h WHERE h.branchvaultaccount = :branchvaultaccount"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByInterbranchaccount", query = "SELECT h FROM Headoffice h WHERE h.interbranchaccount = :interbranchaccount"),
    @javax.persistence.NamedQuery(name = "Headoffice.findByBranchbankaccount", query = "SELECT h FROM Headoffice h WHERE h.branchbankaccount = :branchbankaccount"),
    @javax.persistence.NamedQuery(name = "Headoffice.findBySessiondate", query = "SELECT h FROM Headoffice h WHERE h.sessiondate = :sessiondate")})
public class Headoffice
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer headofficeid;
    @Size(max = 4)
    @Column(length = 4)
    private String headofficecode;
    @Size(max = 40)
    @Column(length = 40)
    private String headofficename;
    @Size(max = 50)
    @Column(length = 50)
    private String businessunit;
    private Boolean headofficestatus;
    @Size(max = 40)
    @Column(length = 40)
    private String creator;
    @Size(max = 40)
    @Column(length = 40)
    private String editor;
    @Temporal(TemporalType.TIME)
    private Date creationdate;
    @Temporal(TemporalType.TIME)
    private Date editdate;
    private Integer branchvaultaccount;
    private Integer interbranchaccount;
    private Integer branchbankaccount;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(mappedBy = "headofficeid")
    private List<Region> regionList;
    @OneToMany(mappedBy = "headofficeid")
    private List<Masteroperational> masteroperationalList;

    public Headoffice() {
    }

    public Headoffice(Integer headofficeid) {
        this.headofficeid = headofficeid;
    }

    public Integer getHeadofficeid() {
        return this.headofficeid;
    }

    public void setHeadofficeid(Integer headofficeid) {
        this.headofficeid = headofficeid;
    }

    public String getHeadofficecode() {
        return this.headofficecode;
    }

    public void setHeadofficecode(String headofficecode) {
        this.headofficecode = headofficecode;
    }

    public String getHeadofficename() {
        return this.headofficename;
    }

    public void setHeadofficename(String headofficename) {
        this.headofficename = headofficename;
    }

    public String getBusinessunit() {
        return this.businessunit;
    }

    public void setBusinessunit(String businessunit) {
        this.businessunit = businessunit;
    }

    public Boolean getHeadofficestatus() {
        return this.headofficestatus;
    }

    public void setHeadofficestatus(Boolean headofficestatus) {
        this.headofficestatus = headofficestatus;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getEditdate() {
        return this.editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public Integer getBranchvaultaccount() {
        return this.branchvaultaccount;
    }

    public void setBranchvaultaccount(Integer branchvaultaccount) {
        this.branchvaultaccount = branchvaultaccount;
    }

    public Integer getInterbranchaccount() {
        return this.interbranchaccount;
    }

    public void setInterbranchaccount(Integer interbranchaccount) {
        this.interbranchaccount = interbranchaccount;
    }

    public Integer getBranchbankaccount() {
        return this.branchbankaccount;
    }

    public void setBranchbankaccount(Integer branchbankaccount) {
        this.branchbankaccount = branchbankaccount;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Region> getRegionList() {
        return this.regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    @XmlTransient
    public List<Masteroperational> getMasteroperationalList() {
        return this.masteroperationalList;
    }

    public void setMasteroperationalList(List<Masteroperational> masteroperationalList) {
        this.masteroperationalList = masteroperationalList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.headofficeid != null ? this.headofficeid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Headoffice)) {
            return false;
        }
        Headoffice other = (Headoffice) object;
        if (((this.headofficeid == null) && (other.headofficeid != null)) || ((this.headofficeid != null) && (!this.headofficeid.equals(other.headofficeid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Headoffice[ headofficeid=" + this.headofficeid + " ]";
    }
}