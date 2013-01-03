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
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d"),
    @javax.persistence.NamedQuery(name = "Division.findByDivisionid", query = "SELECT d FROM Division d WHERE d.divisionid = :divisionid"),
    @javax.persistence.NamedQuery(name = "Division.findByDivisioncode", query = "SELECT d FROM Division d WHERE d.divisioncode = :divisioncode"),
    @javax.persistence.NamedQuery(name = "Division.findByDivisionname", query = "SELECT d FROM Division d WHERE d.divisionname = :divisionname"),
    @javax.persistence.NamedQuery(name = "Division.findByDivisionstatus", query = "SELECT d FROM Division d WHERE d.divisionstatus = :divisionstatus"),
    @javax.persistence.NamedQuery(name = "Division.findByCreationdate", query = "SELECT d FROM Division d WHERE d.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Division.findByEditdate", query = "SELECT d FROM Division d WHERE d.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Division.findByCreator", query = "SELECT d FROM Division d WHERE d.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Division.findByEditor", query = "SELECT d FROM Division d WHERE d.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Division.findBySessiondate", query = "SELECT d FROM Division d WHERE d.sessiondate = :sessiondate")})
public class Division
        implements Serializable {

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
    private List<Operatoruser> operatoruserList;

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
        return this.divisionid;
    }

    public void setDivisionid(Integer divisionid) {
        this.divisionid = divisionid;
    }

    public String getDivisioncode() {
        return this.divisioncode;
    }

    public void setDivisioncode(String divisioncode) {
        this.divisioncode = divisioncode;
    }

    public String getDivisionname() {
        return this.divisionname;
    }

    public void setDivisionname(String divisionname) {
        this.divisionname = divisionname;
    }

    public boolean getDivisionstatus() {
        return this.divisionstatus;
    }

    public void setDivisionstatus(boolean divisionstatus) {
        this.divisionstatus = divisionstatus;
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

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Directorate getDirectorateid() {
        return this.directorateid;
    }

    public void setDirectorateid(Directorate directorateid) {
        this.directorateid = directorateid;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList() {
        return this.operatoruserList;
    }

    public void setOperatoruserList(List<Operatoruser> operatoruserList) {
        this.operatoruserList = operatoruserList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.divisionid != null ? this.divisionid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if (((this.divisionid == null) && (other.divisionid != null)) || ((this.divisionid != null) && (!this.divisionid.equals(other.divisionid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Division[ divisionid=" + this.divisionid + " ]";
    }
}