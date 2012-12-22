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
    @NamedQuery(name = "Directorate.findAll", query = "SELECT d FROM Directorate d"),
    @NamedQuery(name = "Directorate.findByDirectorateid", query = "SELECT d FROM Directorate d WHERE d.directorateid = :directorateid"),
    @NamedQuery(name = "Directorate.findByDirectoratecode", query = "SELECT d FROM Directorate d WHERE d.directoratecode = :directoratecode"),
    @NamedQuery(name = "Directorate.findByDirectoratename", query = "SELECT d FROM Directorate d WHERE d.directoratename = :directoratename"),
    @NamedQuery(name = "Directorate.findByDirectoratestatus", query = "SELECT d FROM Directorate d WHERE d.directoratestatus = :directoratestatus"),
    @NamedQuery(name = "Directorate.findByCreationdate", query = "SELECT d FROM Directorate d WHERE d.creationdate = :creationdate"),
    @NamedQuery(name = "Directorate.findByEditdate", query = "SELECT d FROM Directorate d WHERE d.editdate = :editdate"),
    @NamedQuery(name = "Directorate.findByCreator", query = "SELECT d FROM Directorate d WHERE d.creator = :creator"),
    @NamedQuery(name = "Directorate.findByEditor", query = "SELECT d FROM Directorate d WHERE d.editor = :editor"),
    @NamedQuery(name = "Directorate.findBySessiondate", query = "SELECT d FROM Directorate d WHERE d.sessiondate = :sessiondate")})
public class Directorate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer directorateid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(nullable = false, length = 4)
    private String directoratecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String directoratename;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean directoratestatus;
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
    @OneToMany(mappedBy = "directorateid")
    private List<Division> divisionList;
    @OneToMany(mappedBy = "directorateid")
    private List<OperatorUser> operatoruserList;

    public Directorate() {
    }

    public Directorate(Integer directorateid) {
        this.directorateid = directorateid;
    }

    public Directorate(Integer directorateid, String directoratecode, String directoratename, boolean directoratestatus) {
        this.directorateid = directorateid;
        this.directoratecode = directoratecode;
        this.directoratename = directoratename;
        this.directoratestatus = directoratestatus;
    }

    public Integer getDirectorateid() {
        return directorateid;
    }

    public void setDirectorateid(Integer directorateid) {
        this.directorateid = directorateid;
    }

    public String getDirectoratecode() {
        return directoratecode;
    }

    public void setDirectoratecode(String directoratecode) {
        this.directoratecode = directoratecode;
    }

    public String getDirectoratename() {
        return directoratename;
    }

    public void setDirectoratename(String directoratename) {
        this.directoratename = directoratename;
    }

    public boolean getDirectoratestatus() {
        return directoratestatus;
    }

    public void setDirectoratestatus(boolean directoratestatus) {
        this.directoratestatus = directoratestatus;
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
    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
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
        hash += (directorateid != null ? directorateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directorate)) {
            return false;
        }
        Directorate other = (Directorate) object;
        if ((this.directorateid == null && other.directorateid != null) || (this.directorateid != null && !this.directorateid.equals(other.directorateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Directorate[ directorateid=" + directorateid + " ]";
    }

}
