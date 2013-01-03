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
@Table(schema = "public", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"religi"})})
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Religi.findAll", query = "SELECT r FROM Religi r"),
    @javax.persistence.NamedQuery(name = "Religi.findByReligiid", query = "SELECT r FROM Religi r WHERE r.religiid = :religiid"),
    @javax.persistence.NamedQuery(name = "Religi.findByReligi", query = "SELECT r FROM Religi r WHERE r.religi = :religi"),
    @javax.persistence.NamedQuery(name = "Religi.findByCreationdate", query = "SELECT r FROM Religi r WHERE r.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Religi.findByEditdate", query = "SELECT r FROM Religi r WHERE r.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Religi.findByCreator", query = "SELECT r FROM Religi r WHERE r.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Religi.findByEditor", query = "SELECT r FROM Religi r WHERE r.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Religi.findBySessiondate", query = "SELECT r FROM Religi r WHERE r.sessiondate = :sessiondate")})
public class Religi
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer religiid;
    @Size(max = 40)
    @Column(length = 40)
    private String religi;
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
    @OneToMany(mappedBy = "religiid")
    private List<Person> personList;

    public Religi() {
    }

    public Religi(Integer religiid) {
        this.religiid = religiid;
    }

    public Integer getReligiid() {
        return this.religiid;
    }

    public void setReligiid(Integer religiid) {
        this.religiid = religiid;
    }

    public String getReligi() {
        return this.religi;
    }

    public void setReligi(String religi) {
        this.religi = religi;
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
        hash += (this.religiid != null ? this.religiid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Religi)) {
            return false;
        }
        Religi other = (Religi) object;
        if (((this.religiid == null) && (other.religiid != null)) || ((this.religiid != null) && (!this.religiid.equals(other.religiid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Religi[ religiid=" + this.religiid + " ]";
    }
}