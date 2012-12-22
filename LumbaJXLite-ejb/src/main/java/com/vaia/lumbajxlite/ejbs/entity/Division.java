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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d"),
    @NamedQuery(name = "Division.findByDivisionid", query = "SELECT d FROM Division d WHERE d.divisionid = :divisionid"),
    @NamedQuery(name = "Division.findByDivisioncode", query = "SELECT d FROM Division d WHERE d.divisioncode = :divisioncode"),
    @NamedQuery(name = "Division.findByDivisionname", query = "SELECT d FROM Division d WHERE d.divisionname = :divisionname"),
    @NamedQuery(name = "Division.findByDivisionstatus", query = "SELECT d FROM Division d WHERE d.divisionstatus = :divisionstatus"),
    @NamedQuery(name = "Division.findByCreationdate", query = "SELECT d FROM Division d WHERE d.creationdate = :creationdate"),
    @NamedQuery(name = "Division.findByEditdate", query = "SELECT d FROM Division d WHERE d.editdate = :editdate"),
    @NamedQuery(name = "Division.findByCreator", query = "SELECT d FROM Division d WHERE d.creator = :creator"),
    @NamedQuery(name = "Division.findByEditor", query = "SELECT d FROM Division d WHERE d.editor = :editor"),
    @NamedQuery(name = "Division.findBySessiondate", query = "SELECT d FROM Division d WHERE d.sessiondate = :sessiondate")})
public class Division implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer divisionid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(nullable = false, length = 4)
    private String divisioncode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String divisionname;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean divisionstatus;
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
    @JoinColumn(name = "directorateid", referencedColumnName = "directorateid")
    @ManyToOne
    private Directorate directorateid;
    @OneToMany(mappedBy = "divisionid")
    private List<OperatorUser> operatoruserList;

    public Division() {
    }

    public Division(Integer divisionid) {
        this.divisionid = divisionid;
    }

    public Division(Integer divisionid, String divisioncode, String divisionname, boolean divisionstatus) {
        this.divisionid = divisionid;
        this.divisioncode = divisioncode;
        this.divisionname = divisionname;
        this.divisionstatus = divisionstatus;
    }

    public Integer getDivisionid() {
        return divisionid;
    }

    public void setDivisionid(Integer divisionid) {
        this.divisionid = divisionid;
    }

    public String getDivisioncode() {
        return divisioncode;
    }

    public void setDivisioncode(String divisioncode) {
        this.divisioncode = divisioncode;
    }

    public String getDivisionname() {
        return divisionname;
    }

    public void setDivisionname(String divisionname) {
        this.divisionname = divisionname;
    }

    public boolean getDivisionstatus() {
        return divisionstatus;
    }

    public void setDivisionstatus(boolean divisionstatus) {
        this.divisionstatus = divisionstatus;
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

    public Directorate getDirectorateid() {
        return directorateid;
    }

    public void setDirectorateid(Directorate directorateid) {
        this.directorateid = directorateid;
    }

    @XmlTransient
    public List<OperatorUser> getOperatoruserList() {
        return operatoruserList;
    }

    public void setOperatoruserList(List<OperatorUser> operatoruserList) {
        this.operatoruserList = operatoruserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (divisionid != null ? divisionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if ((this.divisionid == null && other.divisionid != null) || (this.divisionid != null && !this.divisionid.equals(other.divisionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Division[ divisionid=" + divisionid + " ]";
    }

}
