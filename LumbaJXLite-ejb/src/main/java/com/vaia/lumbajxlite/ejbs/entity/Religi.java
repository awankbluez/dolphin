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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"religi"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religi.findAll", query = "SELECT r FROM Religi r"),
    @NamedQuery(name = "Religi.findByReligiid", query = "SELECT r FROM Religi r WHERE r.religiid = :religiid"),
    @NamedQuery(name = "Religi.findByReligi", query = "SELECT r FROM Religi r WHERE r.religi = :religi"),
    @NamedQuery(name = "Religi.findByCreationdate", query = "SELECT r FROM Religi r WHERE r.creationdate = :creationdate"),
    @NamedQuery(name = "Religi.findByEditdate", query = "SELECT r FROM Religi r WHERE r.editdate = :editdate"),
    @NamedQuery(name = "Religi.findByCreator", query = "SELECT r FROM Religi r WHERE r.creator = :creator"),
    @NamedQuery(name = "Religi.findByEditor", query = "SELECT r FROM Religi r WHERE r.editor = :editor"),
    @NamedQuery(name = "Religi.findBySessiondate", query = "SELECT r FROM Religi r WHERE r.sessiondate = :sessiondate")})
public class Religi implements Serializable {
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
        return religiid;
    }

    public void setReligiid(Integer religiid) {
        this.religiid = religiid;
    }

    public String getReligi() {
        return religi;
    }

    public void setReligi(String religi) {
        this.religi = religi;
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

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (religiid != null ? religiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Religi)) {
            return false;
        }
        Religi other = (Religi) object;
        if ((this.religiid == null && other.religiid != null) || (this.religiid != null && !this.religiid.equals(other.religiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Religi[ religiid=" + religiid + " ]";
    }

}
