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
    @javax.persistence.NamedQuery(name = "Residencecustomer.findAll", query = "SELECT r FROM Residencecustomer r"),
    @javax.persistence.NamedQuery(name = "Residencecustomer.findByResidencecustomerid", query = "SELECT r FROM Residencecustomer r WHERE r.residencecustomerid = :residencecustomerid"),
    @javax.persistence.NamedQuery(name = "Residencecustomer.findByResidence", query = "SELECT r FROM Residencecustomer r WHERE r.residence = :residence"),
    @javax.persistence.NamedQuery(name = "Residencecustomer.findByCreationdate", query = "SELECT r FROM Residencecustomer r WHERE r.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Residencecustomer.findByEditdate", query = "SELECT r FROM Residencecustomer r WHERE r.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Residencecustomer.findByCreator", query = "SELECT r FROM Residencecustomer r WHERE r.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Residencecustomer.findByEditor", query = "SELECT r FROM Residencecustomer r WHERE r.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Residencecustomer.findBySessiondate", query = "SELECT r FROM Residencecustomer r WHERE r.sessiondate = :sessiondate")})
public class Residencecustomer
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer residencecustomerid;
    @Size(max = 50)
    @Column(length = 50)
    private String residence;
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
    @OneToMany(mappedBy = "residencecustomerid")
    private List<Person> personList;

    public Residencecustomer() {
    }

    public Residencecustomer(Integer residencecustomerid) {
        this.residencecustomerid = residencecustomerid;
    }

    public Integer getResidencecustomerid() {
        return this.residencecustomerid;
    }

    public void setResidencecustomerid(Integer residencecustomerid) {
        this.residencecustomerid = residencecustomerid;
    }

    public String getResidence() {
        return this.residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
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

    @XmlTransient
    public List<Person> getPersonList() {
        return this.personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.residencecustomerid != null ? this.residencecustomerid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Residencecustomer)) {
            return false;
        }
        Residencecustomer other = (Residencecustomer) object;
        if (((this.residencecustomerid == null) && (other.residencecustomerid != null)) || ((this.residencecustomerid != null) && (!this.residencecustomerid.equals(other.residencecustomerid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Residencecustomer[ residencecustomerid=" + this.residencecustomerid + " ]";
    }
}