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
@Table(catalog = "DB_LUMBA", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"positionname"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
    @NamedQuery(name = "Position.findByPositionid", query = "SELECT p FROM Position p WHERE p.positionid = :positionid"),
    @NamedQuery(name = "Position.findByPositioncode", query = "SELECT p FROM Position p WHERE p.positioncode = :positioncode"),
    @NamedQuery(name = "Position.findByPositionname", query = "SELECT p FROM Position p WHERE p.positionname = :positionname"),
    @NamedQuery(name = "Position.findByPositionstatus", query = "SELECT p FROM Position p WHERE p.positionstatus = :positionstatus"),
    @NamedQuery(name = "Position.findByIsaccountofficer", query = "SELECT p FROM Position p WHERE p.isaccountofficer = :isaccountofficer"),
    @NamedQuery(name = "Position.findByCreationdate", query = "SELECT p FROM Position p WHERE p.creationdate = :creationdate"),
    @NamedQuery(name = "Position.findByEditdate", query = "SELECT p FROM Position p WHERE p.editdate = :editdate"),
    @NamedQuery(name = "Position.findByParentposition", query = "SELECT p FROM Position p WHERE p.parentposition = :parentposition"),
    @NamedQuery(name = "Position.findBySessiondate", query = "SELECT p FROM Position p WHERE p.sessiondate = :sessiondate"),
    @NamedQuery(name = "Position.findByCreator", query = "SELECT p FROM Position p WHERE p.creator = :creator"),
    @NamedQuery(name = "Position.findByEditor", query = "SELECT p FROM Position p WHERE p.editor = :editor")})
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer positionid;
    @Size(max = 4)
    @Column(length = 4)
    private String positioncode;
    @Size(max = 20)
    @Column(length = 20)
    private String positionname;
    private Boolean positionstatus;
    private Boolean isaccountofficer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    private Integer parentposition;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    private Integer creator;
    private Integer editor;
    @OneToMany(mappedBy = "positionid")
    private List<OperatorUser> operatoruserList;

    public Position() {
    }

    public Position(Integer positionid) {
        this.positionid = positionid;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getPositioncode() {
        return positioncode;
    }

    public void setPositioncode(String positioncode) {
        this.positioncode = positioncode;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public Boolean getPositionstatus() {
        return positionstatus;
    }

    public void setPositionstatus(Boolean positionstatus) {
        this.positionstatus = positionstatus;
    }

    public Boolean getIsaccountofficer() {
        return isaccountofficer;
    }

    public void setIsaccountofficer(Boolean isaccountofficer) {
        this.isaccountofficer = isaccountofficer;
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

    public Integer getParentposition() {
        return parentposition;
    }

    public void setParentposition(Integer parentposition) {
        this.parentposition = parentposition;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getEditor() {
        return editor;
    }

    public void setEditor(Integer editor) {
        this.editor = editor;
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
        hash += (positionid != null ? positionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.positionid == null && other.positionid != null) || (this.positionid != null && !this.positionid.equals(other.positionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Position[ positionid=" + positionid + " ]";
    }

}
