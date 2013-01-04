/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounttype.findAll", query = "SELECT a FROM Accounttype a"),
    @NamedQuery(name = "Accounttype.findByAccounttypeid", query = "SELECT a FROM Accounttype a WHERE a.accounttypeid = :accounttypeid"),
    @NamedQuery(name = "Accounttype.findByAccounttypecode", query = "SELECT a FROM Accounttype a WHERE a.accounttypecode = :accounttypecode"),
    @NamedQuery(name = "Accounttype.findByDescription", query = "SELECT a FROM Accounttype a WHERE a.description = :description"),
    @NamedQuery(name = "Accounttype.findByCreationdate", query = "SELECT a FROM Accounttype a WHERE a.creationdate = :creationdate"),
    @NamedQuery(name = "Accounttype.findByCreator", query = "SELECT a FROM Accounttype a WHERE a.creator = :creator"),
    @NamedQuery(name = "Accounttype.findByEditdate", query = "SELECT a FROM Accounttype a WHERE a.editdate = :editdate"),
    @NamedQuery(name = "Accounttype.findByEditor", query = "SELECT a FROM Accounttype a WHERE a.editor = :editor"),
    @NamedQuery(name = "Accounttype.findBySessiondate", query = "SELECT a FROM Accounttype a WHERE a.sessiondate = :sessiondate")})
public class Accounttype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer accounttypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String accounttypecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Size(max = 40)
    @Column(length = 40)
    private String creator;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 40)
    @Column(length = 40)
    private String editor;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accounttypeid")
    private List<Chartofaccount> chartofaccountList;

    public Accounttype() {
    }

    public Accounttype(Integer accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public Accounttype(Integer accounttypeid, String accounttypecode, String description) {
        this.accounttypeid = accounttypeid;
        this.accounttypecode = accounttypecode;
        this.description = description;
    }

    public Integer getAccounttypeid() {
        return accounttypeid;
    }

    public void setAccounttypeid(Integer accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public String getAccounttypecode() {
        return accounttypecode;
    }

    public void setAccounttypecode(String accounttypecode) {
        this.accounttypecode = accounttypecode;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
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
    public List<Chartofaccount> getChartofaccountList() {
        return chartofaccountList;
    }

    public void setChartofaccountList(List<Chartofaccount> chartofaccountList) {
        this.chartofaccountList = chartofaccountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accounttypeid != null ? accounttypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounttype)) {
            return false;
        }
        Accounttype other = (Accounttype) object;
        if ((this.accounttypeid == null && other.accounttypeid != null) || (this.accounttypeid != null && !this.accounttypeid.equals(other.accounttypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Accounttype[ accounttypeid=" + accounttypeid + " ]";
    }

}
