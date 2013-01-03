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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"regioncode"}),
    @javax.persistence.UniqueConstraint(columnNames = {"regionname"})})
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @javax.persistence.NamedQuery(name = "Region.findByRegionid", query = "SELECT r FROM Region r WHERE r.regionid = :regionid"),
    @javax.persistence.NamedQuery(name = "Region.findByRegioncode", query = "SELECT r FROM Region r WHERE r.regioncode = :regioncode"),
    @javax.persistence.NamedQuery(name = "Region.findByRegionname", query = "SELECT r FROM Region r WHERE r.regionname = :regionname"),
    @javax.persistence.NamedQuery(name = "Region.findByRegionstatus", query = "SELECT r FROM Region r WHERE r.regionstatus = :regionstatus"),
    @javax.persistence.NamedQuery(name = "Region.findByCreator", query = "SELECT r FROM Region r WHERE r.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Region.findByEditor", query = "SELECT r FROM Region r WHERE r.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Region.findByCreationdate", query = "SELECT r FROM Region r WHERE r.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Region.findByEditdate", query = "SELECT r FROM Region r WHERE r.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Region.findByBranchvaultaccount", query = "SELECT r FROM Region r WHERE r.branchvaultaccount = :branchvaultaccount"),
    @javax.persistence.NamedQuery(name = "Region.findByInterbranchaccount", query = "SELECT r FROM Region r WHERE r.interbranchaccount = :interbranchaccount"),
    @javax.persistence.NamedQuery(name = "Region.findByBranchbankaccount", query = "SELECT r FROM Region r WHERE r.branchbankaccount = :branchbankaccount"),
    @javax.persistence.NamedQuery(name = "Region.findBySessiondate", query = "SELECT r FROM Region r WHERE r.sessiondate = :sessiondate")})
public class Region
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer regionid;
    @Size(max = 4)
    @Column(length = 4)
    private String regioncode;
    @Size(max = 40)
    @Column(length = 40)
    private String regionname;
    private Boolean regionstatus;
    @Size(max = 40)
    @Column(length = 40)
    private String creator;
    @Size(max = 40)
    @Column(length = 40)
    private String editor;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    private Integer branchvaultaccount;
    private Integer interbranchaccount;
    private Integer branchbankaccount;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @JoinColumn(name = "headofficeid", referencedColumnName = "headofficeid")
    @ManyToOne
    private Headoffice headofficeid;
    @OneToMany(mappedBy = "regionid")
    private List<Masteroperational> masteroperationalList;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "regionid")
    private List<Branch> branchList;

    public Region() {
    }

    public Region(Integer regionid) {
        this.regionid = regionid;
    }

    public Integer getRegionid() {
        return this.regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public String getRegioncode() {
        return this.regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    public String getRegionname() {
        return this.regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public Boolean getRegionstatus() {
        return this.regionstatus;
    }

    public void setRegionstatus(Boolean regionstatus) {
        this.regionstatus = regionstatus;
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

    public Headoffice getHeadofficeid() {
        return this.headofficeid;
    }

    public void setHeadofficeid(Headoffice headofficeid) {
        this.headofficeid = headofficeid;
    }

    @XmlTransient
    public List<Masteroperational> getMasteroperationalList() {
        return this.masteroperationalList;
    }

    public void setMasteroperationalList(List<Masteroperational> masteroperationalList) {
        this.masteroperationalList = masteroperationalList;
    }

    @XmlTransient
    public List<Branch> getBranchList() {
        return this.branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.regionid != null ? this.regionid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if (((this.regionid == null) && (other.regionid != null)) || ((this.regionid != null) && (!this.regionid.equals(other.regionid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Region[ regionid=" + this.regionid + " ]";
    }
}