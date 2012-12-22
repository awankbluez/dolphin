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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuid", query = "SELECT m FROM Menu m WHERE m.menuid = :menuid"),
    @NamedQuery(name = "Menu.findByMenuname", query = "SELECT m FROM Menu m WHERE m.menuname = :menuname"),
    @NamedQuery(name = "Menu.findByAlias", query = "SELECT m FROM Menu m WHERE m.alias = :alias"),
    @NamedQuery(name = "Menu.findByLink", query = "SELECT m FROM Menu m WHERE m.link = :link"),
    @NamedQuery(name = "Menu.findByMenustatus", query = "SELECT m FROM Menu m WHERE m.menustatus = :menustatus"),
    @NamedQuery(name = "Menu.findByParentid", query = "SELECT m FROM Menu m WHERE m.parentid = :parentid"),
    @NamedQuery(name = "Menu.findByLevel", query = "SELECT m FROM Menu m WHERE m.level = :level"),
    @NamedQuery(name = "Menu.findByOrdering", query = "SELECT m FROM Menu m WHERE m.ordering = :ordering"),
    @NamedQuery(name = "Menu.findByMenutype", query = "SELECT m FROM Menu m WHERE m.menutype = :menutype"),
    @NamedQuery(name = "Menu.findByAction", query = "SELECT m FROM Menu m WHERE m.action = :action"),
    @NamedQuery(name = "Menu.findBySessiondate", query = "SELECT m FROM Menu m WHERE m.sessiondate = :sessiondate")})
public class Menu implements Serializable {
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
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getMenustatus() {
        return menustatus;
    }

    public void setMenustatus(Boolean menustatus) {
        this.menustatus = menustatus;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuid != null ? menuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuid == null && other.menuid != null) || (this.menuid != null && !this.menuid.equals(other.menuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Menu[ menuid=" + menuid + " ]";
    }

}
