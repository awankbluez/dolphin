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
@Table(name = "grouping", catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grouping.findAll", query = "SELECT g FROM Grouping g"),
    @NamedQuery(name = "Grouping.findByGroupingid", query = "SELECT g FROM Grouping g WHERE g.groupingid = :groupingid"),
    @NamedQuery(name = "Grouping.findByGroupcode", query = "SELECT g FROM Grouping g WHERE g.groupcode = :groupcode"),
    @NamedQuery(name = "Grouping.findByGroupname", query = "SELECT g FROM Grouping g WHERE g.groupname = :groupname"),
    @NamedQuery(name = "Grouping.findByOpendate", query = "SELECT g FROM Grouping g WHERE g.opendate = :opendate"),
    @NamedQuery(name = "Grouping.findByDescription", query = "SELECT g FROM Grouping g WHERE g.description = :description"),
    @NamedQuery(name = "Grouping.findByCreationdate", query = "SELECT g FROM Grouping g WHERE g.creationdate = :creationdate"),
    @NamedQuery(name = "Grouping.findByEditdate", query = "SELECT g FROM Grouping g WHERE g.editdate = :editdate"),
    @NamedQuery(name = "Grouping.findByTypegroup", query = "SELECT g FROM Grouping g WHERE g.typegroup = :typegroup"),
    @NamedQuery(name = "Grouping.findBySessiondate", query = "SELECT g FROM Grouping g WHERE g.sessiondate = :sessiondate"),
    @NamedQuery(name = "Grouping.findByAccountofficer", query = "SELECT g FROM Grouping g WHERE g.accountofficer = :accountofficer"),
    @NamedQuery(name = "Grouping.findByCreator", query = "SELECT g FROM Grouping g WHERE g.creator = :creator"),
    @NamedQuery(name = "Grouping.findByEditor", query = "SELECT g FROM Grouping g WHERE g.editor = :editor"),
    @NamedQuery(name = "Grouping.findByMeetingday", query = "SELECT g FROM Grouping g WHERE g.meetingday = :meetingday"),
    @NamedQuery(name = "Grouping.findByGroupstatus", query = "SELECT g FROM Grouping g WHERE g.groupstatus = :groupstatus"),
    @NamedQuery(name = "Grouping.findByGrouptype", query = "SELECT g FROM Grouping g WHERE g.grouptype = :grouptype"),
    @NamedQuery(name = "Grouping.findByCustomerid", query = "SELECT g FROM Grouping g WHERE g.customerid = :customerid")})
public class Grouping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupingid", nullable = false)
    private Integer groupingid;
    @Size(max = 6)
    @Column(name = "groupcode", length = 6)
    private String groupcode;
    @Size(max = 30)
    @Column(name = "groupname", length = 30)
    private String groupname;
    @Column(name = "opendate")
    @Temporal(TemporalType.DATE)
    private Date opendate;
    @Size(max = 200)
    @Column(name = "description", length = 200)
    private String description;
    @Column(name = "creationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Column(name = "editdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 20)
    @Column(name = "typegroup", length = 20)
    private String typegroup;
    @Column(name = "sessiondate")
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @Column(name = "accountofficer")
    private Integer accountofficer;
    @Column(name = "creator")
    private Integer creator;
    @Column(name = "editor")
    private Integer editor;
    @Size(max = 2147483647)
    @Column(name = "meetingday", length = 2147483647)
    private String meetingday;
    @Column(name = "groupstatus")
    private Boolean groupstatus;
    @Column(name = "grouptype")
    private Integer grouptype;
    @Column(name = "customerid")
    private Integer customerid;
    @OneToMany(mappedBy = "groupingid")
    private List<Groupmember> groupmemberList;

    public Grouping() {
    }

    public Grouping(Integer groupingid) {
        this.groupingid = groupingid;
    }

    public Integer getGroupingid() {
        return groupingid;
    }

    public void setGroupingid(Integer groupingid) {
        this.groupingid = groupingid;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getTypegroup() {
        return typegroup;
    }

    public void setTypegroup(String typegroup) {
        this.typegroup = typegroup;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Integer getAccountofficer() {
        return accountofficer;
    }

    public void setAccountofficer(Integer accountofficer) {
        this.accountofficer = accountofficer;
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

    public String getMeetingday() {
        return meetingday;
    }

    public void setMeetingday(String meetingday) {
        this.meetingday = meetingday;
    }

    public Boolean getGroupstatus() {
        return groupstatus;
    }

    public void setGroupstatus(Boolean groupstatus) {
        this.groupstatus = groupstatus;
    }

    public Integer getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(Integer grouptype) {
        this.grouptype = grouptype;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    @XmlTransient
    public List<Groupmember> getGroupmemberList() {
        return groupmemberList;
    }

    public void setGroupmemberList(List<Groupmember> groupmemberList) {
        this.groupmemberList = groupmemberList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupingid != null ? groupingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grouping)) {
            return false;
        }
        Grouping other = (Grouping) object;
        if ((this.groupingid == null && other.groupingid != null) || (this.groupingid != null && !this.groupingid.equals(other.groupingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Grouping[ groupingid=" + groupingid + " ]";
    }

}
