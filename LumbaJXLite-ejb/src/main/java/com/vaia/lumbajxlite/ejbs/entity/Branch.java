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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"branchcode"}),
    @javax.persistence.UniqueConstraint(columnNames = {"branchname"})})
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @javax.persistence.NamedQuery(name = "Branch.findByBranchid", query = "SELECT b FROM Branch b WHERE b.branchid = :branchid"),
    @javax.persistence.NamedQuery(name = "Branch.findByBranchcode", query = "SELECT b FROM Branch b WHERE b.branchcode = :branchcode"),
    @javax.persistence.NamedQuery(name = "Branch.findByBranchname", query = "SELECT b FROM Branch b WHERE b.branchname = :branchname"),
    @javax.persistence.NamedQuery(name = "Branch.findByBranchstatus", query = "SELECT b FROM Branch b WHERE b.branchstatus = :branchstatus"),
    @javax.persistence.NamedQuery(name = "Branch.findByCreator", query = "SELECT b FROM Branch b WHERE b.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Branch.findByEditor", query = "SELECT b FROM Branch b WHERE b.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Branch.findByCreationdate", query = "SELECT b FROM Branch b WHERE b.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Branch.findByEditdate", query = "SELECT b FROM Branch b WHERE b.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Branch.findByBranchvaultaccount", query = "SELECT b FROM Branch b WHERE b.branchvaultaccount = :branchvaultaccount"),
    @javax.persistence.NamedQuery(name = "Branch.findByInterbranchaccount", query = "SELECT b FROM Branch b WHERE b.interbranchaccount = :interbranchaccount"),
    @javax.persistence.NamedQuery(name = "Branch.findByBranchbankaccount", query = "SELECT b FROM Branch b WHERE b.branchbankaccount = :branchbankaccount"),
    @javax.persistence.NamedQuery(name = "Branch.findBySessiondate", query = "SELECT b FROM Branch b WHERE b.sessiondate = :sessiondate")})
public class Branch
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer branchid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(nullable = false, length = 4)
    private String branchcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String branchname;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean branchstatus;
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
    @OneToMany(mappedBy = "branchid")
    private List<Masteroperational> masteroperationalList;
    @OneToMany(mappedBy = "branchid")
    private List<Subbranchunitco> subbranchunitcoList;
    @JoinColumn(name = "regionid", referencedColumnName = "regionid", nullable = false)
    @ManyToOne(optional = false)
    private Region regionid;

    public Branch() {
    }

    public Branch(Integer branchid) {
        this.branchid = branchid;
    }

    public Branch(Integer branchid, String branchcode, String branchname, boolean branchstatus) {
        this.branchid = branchid;
        this.branchcode = branchcode;
        this.branchname = branchname;
        this.branchstatus = branchstatus;
    }

    public Integer getBranchid() {
        return this.branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getBranchcode() {
        return this.branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getBranchname() {
        return this.branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public boolean getBranchstatus() {
        return this.branchstatus;
    }

    public void setBranchstatus(boolean branchstatus) {
        this.branchstatus = branchstatus;
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
    public List<Masteroperational> getMasteroperationalList() {
        return this.masteroperationalList;
    }

    public void setMasteroperationalList(List<Masteroperational> masteroperationalList) {
        this.masteroperationalList = masteroperationalList;
    }

    @XmlTransient
    public List<Subbranchunitco> getSubbranchunitcoList() {
        return this.subbranchunitcoList;
    }

    public void setSubbranchunitcoList(List<Subbranchunitco> subbranchunitcoList) {
        this.subbranchunitcoList = subbranchunitcoList;
    }

    public Region getRegionid() {
        return this.regionid;
    }

    public void setRegionid(Region regionid) {
        this.regionid = regionid;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.branchid != null ? this.branchid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if (((this.branchid == null) && (other.branchid != null)) || ((this.branchid != null) && (!this.branchid.equals(other.branchid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Branch[ branchid=" + this.branchid + " ]";
    }
}