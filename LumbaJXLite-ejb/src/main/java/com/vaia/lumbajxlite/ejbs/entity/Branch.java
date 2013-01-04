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
    @UniqueConstraint(columnNames = {"branchcode"}),
    @UniqueConstraint(columnNames = {"branchname"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchid", query = "SELECT b FROM Branch b WHERE b.branchid = :branchid"),
    @NamedQuery(name = "Branch.findByBranchcode", query = "SELECT b FROM Branch b WHERE b.branchcode = :branchcode"),
    @NamedQuery(name = "Branch.findByBranchname", query = "SELECT b FROM Branch b WHERE b.branchname = :branchname"),
    @NamedQuery(name = "Branch.findByBranchstatus", query = "SELECT b FROM Branch b WHERE b.branchstatus = :branchstatus"),
    @NamedQuery(name = "Branch.findByCreator", query = "SELECT b FROM Branch b WHERE b.creator = :creator"),
    @NamedQuery(name = "Branch.findByEditor", query = "SELECT b FROM Branch b WHERE b.editor = :editor"),
    @NamedQuery(name = "Branch.findByCreationdate", query = "SELECT b FROM Branch b WHERE b.creationdate = :creationdate"),
    @NamedQuery(name = "Branch.findByEditdate", query = "SELECT b FROM Branch b WHERE b.editdate = :editdate"),
    @NamedQuery(name = "Branch.findByBranchvaultaccount", query = "SELECT b FROM Branch b WHERE b.branchvaultaccount = :branchvaultaccount"),
    @NamedQuery(name = "Branch.findByInterbranchaccount", query = "SELECT b FROM Branch b WHERE b.interbranchaccount = :interbranchaccount"),
    @NamedQuery(name = "Branch.findByBranchbankaccount", query = "SELECT b FROM Branch b WHERE b.branchbankaccount = :branchbankaccount"),
    @NamedQuery(name = "Branch.findBySessiondate", query = "SELECT b FROM Branch b WHERE b.sessiondate = :sessiondate")})
public class Branch implements Serializable {
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
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public boolean getBranchstatus() {
        return branchstatus;
    }

    public void setBranchstatus(boolean branchstatus) {
        this.branchstatus = branchstatus;
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

    public Integer getBranchvaultaccount() {
        return branchvaultaccount;
    }

    public void setBranchvaultaccount(Integer branchvaultaccount) {
        this.branchvaultaccount = branchvaultaccount;
    }

    public Integer getInterbranchaccount() {
        return interbranchaccount;
    }

    public void setInterbranchaccount(Integer interbranchaccount) {
        this.interbranchaccount = interbranchaccount;
    }

    public Integer getBranchbankaccount() {
        return branchbankaccount;
    }

    public void setBranchbankaccount(Integer branchbankaccount) {
        this.branchbankaccount = branchbankaccount;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Masteroperational> getMasteroperationalList() {
        return masteroperationalList;
    }

    public void setMasteroperationalList(List<Masteroperational> masteroperationalList) {
        this.masteroperationalList = masteroperationalList;
    }

    @XmlTransient
    public List<Subbranchunitco> getSubbranchunitcoList() {
        return subbranchunitcoList;
    }

    public void setSubbranchunitcoList(List<Subbranchunitco> subbranchunitcoList) {
        this.subbranchunitcoList = subbranchunitcoList;
    }

    public Region getRegionid() {
        return regionid;
    }

    public void setRegionid(Region regionid) {
        this.regionid = regionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchid != null ? branchid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchid == null && other.branchid != null) || (this.branchid != null && !this.branchid.equals(other.branchid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Branch[ branchid=" + branchid + " ]";
    }

}
