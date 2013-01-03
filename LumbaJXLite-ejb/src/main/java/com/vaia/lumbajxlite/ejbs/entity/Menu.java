package com.vaia.lumbajxlite.ejbs.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @javax.persistence.NamedQuery(name = "Menu.findByMenuid", query = "SELECT m FROM Menu m WHERE m.menuid = :menuid"),
    @javax.persistence.NamedQuery(name = "Menu.findByMenuname", query = "SELECT m FROM Menu m WHERE m.menuname = :menuname"),
    @javax.persistence.NamedQuery(name = "Menu.findByAlias", query = "SELECT m FROM Menu m WHERE m.alias = :alias"),
    @javax.persistence.NamedQuery(name = "Menu.findByLink", query = "SELECT m FROM Menu m WHERE m.link = :link"),
    @javax.persistence.NamedQuery(name = "Menu.findByMenustatus", query = "SELECT m FROM Menu m WHERE m.menustatus = :menustatus"),
    @javax.persistence.NamedQuery(name = "Menu.findByParentid", query = "SELECT m FROM Menu m WHERE m.parentid = :parentid"),
    @javax.persistence.NamedQuery(name = "Menu.findByLevel", query = "SELECT m FROM Menu m WHERE m.level = :level"),
    @javax.persistence.NamedQuery(name = "Menu.findByOrdering", query = "SELECT m FROM Menu m WHERE m.ordering = :ordering"),
    @javax.persistence.NamedQuery(name = "Menu.findByMenutype", query = "SELECT m FROM Menu m WHERE m.menutype = :menutype"),
    @javax.persistence.NamedQuery(name = "Menu.findByAction", query = "SELECT m FROM Menu m WHERE m.action = :action"),
    @javax.persistence.NamedQuery(name = "Menu.findBySessiondate", query = "SELECT m FROM Menu m WHERE m.sessiondate = :sessiondate")})
public class Menu
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer menuid;
    @Size(max = 50)
    @Column(length = 50)
    private String menuname;
    @Size(max = 50)
    @Column(length = 50)
    private String alias;
    @Size(max = 100)
    @Column(length = 100)
    private String link;
    private Boolean menustatus;
    private Integer parentid;
    private Integer level;
    private Integer ordering;
    @Size(max = 2)
    @Column(length = 2)
    private String menutype;
    @Size(max = 5)
    @Column(length = 5)
    private String action;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;

    public Menu() {
    }

    public Menu(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getMenuid() {
        return this.menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return this.menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getMenustatus() {
        return this.menustatus;
    }

    public void setMenustatus(Boolean menustatus) {
        this.menustatus = menustatus;
    }

    public Integer getParentid() {
        return this.parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrdering() {
        return this.ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public String getMenutype() {
        return this.menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.menuid != null ? this.menuid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if (((this.menuid == null) && (other.menuid != null)) || ((this.menuid != null) && (!this.menuid.equals(other.menuid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Menu[ menuid=" + this.menuid + " ]";
    }
}