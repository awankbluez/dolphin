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
    @NamedQuery(name = "Routinglog.findAll", query = "SELECT r FROM Routinglog r"),
    @NamedQuery(name = "Routinglog.findByRoutinglogid", query = "SELECT r FROM Routinglog r WHERE r.routinglogid = :routinglogid"),
    @NamedQuery(name = "Routinglog.findByModule", query = "SELECT r FROM Routinglog r WHERE r.module = :module"),
    @NamedQuery(name = "Routinglog.findByRefid", query = "SELECT r FROM Routinglog r WHERE r.refid = :refid"),
    @NamedQuery(name = "Routinglog.findByCreationdate", query = "SELECT r FROM Routinglog r WHERE r.creationdate = :creationdate"),
    @NamedQuery(name = "Routinglog.findByNote", query = "SELECT r FROM Routinglog r WHERE r.note = :note"),
    @NamedQuery(name = "Routinglog.findByEditdate", query = "SELECT r FROM Routinglog r WHERE r.editdate = :editdate"),
    @NamedQuery(name = "Routinglog.findByCreator", query = "SELECT r FROM Routinglog r WHERE r.creator = :creator"),
    @NamedQuery(name = "Routinglog.findByEditor", query = "SELECT r FROM Routinglog r WHERE r.editor = :editor"),
    @NamedQuery(name = "Routinglog.findByLastaction", query = "SELECT r FROM Routinglog r WHERE r.lastaction = :lastaction"),
    @NamedQuery(name = "Routinglog.findBySessiondate", query = "SELECT r FROM Routinglog r WHERE r.sessiondate = :sessiondate")})
public class RoutingLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer routinglogid;
    @Size(max = 2)
    @Column(length = 2)
    private String module;
    private Integer refid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Size(max = 255)
    @Column(length = 255)
    private String note;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    private Integer creator;
    private Integer editor;
    @Size(max = 2)
    @Column(length = 2)
    private String lastaction;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(mappedBy = "routinglogid")
    private List<Account> accountList;

    public RoutingLog() {
    }

    public RoutingLog(Integer routinglogid) {
        this.routinglogid = routinglogid;
    }

    public Integer getRoutinglogid() {
        return routinglogid;
    }

    public void setRoutinglogid(Integer routinglogid) {
        this.routinglogid = routinglogid;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getRefid() {
        return refid;
    }

    public void setRefid(Integer refid) {
        this.refid = refid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
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

    public String getLastaction() {
        return lastaction;
    }

    public void setLastaction(String lastaction) {
        this.lastaction = lastaction;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routinglogid != null ? routinglogid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoutingLog)) {
            return false;
        }
        RoutingLog other = (RoutingLog) object;
        if ((this.routinglogid == null && other.routinglogid != null) || (this.routinglogid != null && !this.routinglogid.equals(other.routinglogid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Routinglog[ routinglogid=" + routinglogid + " ]";
    }

}
