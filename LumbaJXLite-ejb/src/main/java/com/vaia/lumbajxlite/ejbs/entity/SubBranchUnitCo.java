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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subbranchunitco.findAll", query = "SELECT s FROM Subbranchunitco s"),
    @NamedQuery(name = "Subbranchunitco.findBySubbranchunitcoid", query = "SELECT s FROM Subbranchunitco s WHERE s.subbranchunitcoid = :subbranchunitcoid"),
    @NamedQuery(name = "Subbranchunitco.findBySubbranchunitcocode", query = "SELECT s FROM Subbranchunitco s WHERE s.subbranchunitcocode = :subbranchunitcocode"),
    @NamedQuery(name = "Subbranchunitco.findBySubbranchunitconame", query = "SELECT s FROM Subbranchunitco s WHERE s.subbranchunitconame = :subbranchunitconame"),
    @NamedQuery(name = "Subbranchunitco.findBySubbranchunitcostatus", query = "SELECT s FROM Subbranchunitco s WHERE s.subbranchunitcostatus = :subbranchunitcostatus"),
    @NamedQuery(name = "Subbranchunitco.findByType", query = "SELECT s FROM Subbranchunitco s WHERE s.type = :type"),
    @NamedQuery(name = "Subbranchunitco.findByCreator", query = "SELECT s FROM Subbranchunitco s WHERE s.creator = :creator"),
    @NamedQuery(name = "Subbranchunitco.findByEditor", query = "SELECT s FROM Subbranchunitco s WHERE s.editor = :editor"),
    @NamedQuery(name = "Subbranchunitco.findByCreationdate", query = "SELECT s FROM Subbranchunitco s WHERE s.creationdate = :creationdate"),
    @NamedQuery(name = "Subbranchunitco.findByEditdate", query = "SELECT s FROM Subbranchunitco s WHERE s.editdate = :editdate"),
    @NamedQuery(name = "Subbranchunitco.findByBranchvaultaccount", query = "SELECT s FROM Subbranchunitco s WHERE s.branchvaultaccount = :branchvaultaccount"),
    @NamedQuery(name = "Subbranchunitco.findByInterbranchaccount", query = "SELECT s FROM Subbranchunitco s WHERE s.interbranchaccount = :interbranchaccount"),
    @NamedQuery(name = "Subbranchunitco.findByBranchbankaccount", query = "SELECT s FROM Subbranchunitco s WHERE s.branchbankaccount = :branchbankaccount"),
    @NamedQuery(name = "Subbranchunitco.findBySessiondate", query = "SELECT s FROM Subbranchunitco s WHERE s.sessiondate = :sessiondate")})
public class Subbranchunitco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer subbranchunitcoid;
    @Size(max = 4)
    @Column(length = 4)
    private String subbranchunitcocode;
    @Size(max = 40)
    @Column(length = 40)
    private String subbranchunitconame;
    private Boolean subbranchunitcostatus;
    private Character type;
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
    @OneToMany(mappedBy = "subbranchunitcoid")
    private List<Masteroperational> masteroperationalList;
    @JoinColumn(name = "branchid", referencedColumnName = "branchid")
    @ManyToOne
    private Branch branchid;

    public Subbranchunitco() {
    }

    public Subbranchunitco(Integer subbranchunitcoid) {
        this.subbranchunitcoid = subbranchunitcoid;
    }

    public Integer getSubbranchunitcoid() {
        return subbranchunitcoid;
    }

    public void setSubbranchunitcoid(Integer subbranchunitcoid) {
        this.subbranchunitcoid = subbranchunitcoid;
    }

    public String getSubbranchunitcocode() {
        return subbranchunitcocode;
    }

    public void setSubbranchunitcocode(String subbranchunitcocode) {
        this.subbranchunitcocode = subbranchunitcocode;
    }

    public String getSubbranchunitconame() {
        return subbranchunitconame;
    }

    public void setSubbranchunitconame(String subbranchunitconame) {
        this.subbranchunitconame = subbranchunitconame;
    }

    public Boolean getSubbranchunitcostatus() {
        return subbranchunitcostatus;
    }

    public void setSubbranchunitcostatus(Boolean subbranchunitcostatus) {
        this.subbranchunitcostatus = subbranchunitcostatus;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
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

    public Branch getBranchid() {
        return branchid;
    }

    public void setBranchid(Branch branchid) {
        this.branchid = branchid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subbranchunitcoid != null ? subbranchunitcoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subbranchunitco)) {
            return false;
        }
        Subbranchunitco other = (Subbranchunitco) object;
        if ((this.subbranchunitcoid == null && other.subbranchunitcoid != null) || (this.subbranchunitcoid != null && !this.subbranchunitcoid.equals(other.subbranchunitcoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Subbranchunitco[ subbranchunitcoid=" + subbranchunitcoid + " ]";
    }

}
