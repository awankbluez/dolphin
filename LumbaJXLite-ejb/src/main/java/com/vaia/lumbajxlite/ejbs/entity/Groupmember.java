/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(name = "groupmember", catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupmember.findAll", query = "SELECT g FROM Groupmember g"),
    @NamedQuery(name = "Groupmember.findByGroupmemberid", query = "SELECT g FROM Groupmember g WHERE g.groupmemberid = :groupmemberid"),
    @NamedQuery(name = "Groupmember.findByCreationdate", query = "SELECT g FROM Groupmember g WHERE g.creationdate = :creationdate"),
    @NamedQuery(name = "Groupmember.findByEditdate", query = "SELECT g FROM Groupmember g WHERE g.editdate = :editdate"),
    @NamedQuery(name = "Groupmember.findByMemberstatus", query = "SELECT g FROM Groupmember g WHERE g.memberstatus = :memberstatus"),
    @NamedQuery(name = "Groupmember.findByGroupmemberstatus", query = "SELECT g FROM Groupmember g WHERE g.groupmemberstatus = :groupmemberstatus"),
    @NamedQuery(name = "Groupmember.findBySessiondate", query = "SELECT g FROM Groupmember g WHERE g.sessiondate = :sessiondate"),
    @NamedQuery(name = "Groupmember.findByIsleader", query = "SELECT g FROM Groupmember g WHERE g.isleader = :isleader"),
    @NamedQuery(name = "Groupmember.findByCreator", query = "SELECT g FROM Groupmember g WHERE g.creator = :creator"),
    @NamedQuery(name = "Groupmember.findByEditor", query = "SELECT g FROM Groupmember g WHERE g.editor = :editor")})
public class Groupmember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupmemberid", nullable = false)
    private Integer groupmemberid;
    @Column(name = "creationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "editdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Column(name = "memberstatus")
    private Boolean memberstatus;
    @Column(name = "groupmemberstatus")
    private Character groupmemberstatus;
    @Column(name = "sessiondate")
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @Column(name = "isleader")
    private Boolean isleader;
    @Column(name = "creator")
    private Integer creator;
    @Column(name = "editor")
    private Integer editor;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne
    private Customer customer;
    @JoinColumn(name = "groupingid", referencedColumnName = "groupingid")
    @ManyToOne
    private Grouping groupingid;

    public Groupmember() {
    }

    public Groupmember(Integer groupmemberid) {
        this.groupmemberid = groupmemberid;
    }

    public Integer getGroupmemberid() {
        return groupmemberid;
    }

    public void setGroupmemberid(Integer groupmemberid) {
        this.groupmemberid = groupmemberid;
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

    public Boolean getMemberstatus() {
        return memberstatus;
    }

    public void setMemberstatus(Boolean memberstatus) {
        this.memberstatus = memberstatus;
    }

    public Character getGroupmemberstatus() {
        return groupmemberstatus;
    }

    public void setGroupmemberstatus(Character groupmemberstatus) {
        this.groupmemberstatus = groupmemberstatus;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Boolean getIsleader() {
        return isleader;
    }

    public void setIsleader(Boolean isleader) {
        this.isleader = isleader;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Grouping getGroupingid() {
        return groupingid;
    }

    public void setGroupingid(Grouping groupingid) {
        this.groupingid = groupingid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupmemberid != null ? groupmemberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupmember)) {
            return false;
        }
        Groupmember other = (Groupmember) object;
        if ((this.groupmemberid == null && other.groupmemberid != null) || (this.groupmemberid != null && !this.groupmemberid.equals(other.groupmemberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Groupmember[ groupmemberid=" + groupmemberid + " ]";
    }
}
