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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Accountcategory.findAll", query = "SELECT a FROM Accountcategory a"),
    @NamedQuery(name = "Accountcategory.findByAccountcategoryid", query = "SELECT a FROM Accountcategory a WHERE a.accountcategoryid = :accountcategoryid"),
    @NamedQuery(name = "Accountcategory.findByReference", query = "SELECT a FROM Accountcategory a WHERE a.reference = :reference"),
    @NamedQuery(name = "Accountcategory.findByDescription", query = "SELECT a FROM Accountcategory a WHERE a.description = :description"),
    @NamedQuery(name = "Accountcategory.findByStatus", query = "SELECT a FROM Accountcategory a WHERE a.status = :status"),
    @NamedQuery(name = "Accountcategory.findByCreationdate", query = "SELECT a FROM Accountcategory a WHERE a.creationdate = :creationdate"),
    @NamedQuery(name = "Accountcategory.findByCreator", query = "SELECT a FROM Accountcategory a WHERE a.creator = :creator"),
    @NamedQuery(name = "Accountcategory.findByEditdate", query = "SELECT a FROM Accountcategory a WHERE a.editdate = :editdate"),
    @NamedQuery(name = "Accountcategory.findByEditor", query = "SELECT a FROM Accountcategory a WHERE a.editor = :editor"),
    @NamedQuery(name = "Accountcategory.findBySessiondate", query = "SELECT a FROM Accountcategory a WHERE a.sessiondate = :sessiondate")})
public class Accountcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer accountcategoryid;
    private Integer reference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean status;
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
    @JoinColumn(name = "fcid", referencedColumnName = "fcid")
    @ManyToOne
    private Financialcategory fcid;
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    @ManyToOne
    private Category categoryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountcategoryid")
    private List<Chartofaccount> chartofaccountList;

    public Accountcategory() {
    }

    public Accountcategory(Integer accountcategoryid) {
        this.accountcategoryid = accountcategoryid;
    }

    public Accountcategory(Integer accountcategoryid, String description, boolean status) {
        this.accountcategoryid = accountcategoryid;
        this.description = description;
        this.status = status;
    }

    public Integer getAccountcategoryid() {
        return accountcategoryid;
    }

    public void setAccountcategoryid(Integer accountcategoryid) {
        this.accountcategoryid = accountcategoryid;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Financialcategory getFcid() {
        return fcid;
    }

    public void setFcid(Financialcategory fcid) {
        this.fcid = fcid;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
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
        hash += (accountcategoryid != null ? accountcategoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountcategory)) {
            return false;
        }
        Accountcategory other = (Accountcategory) object;
        if ((this.accountcategoryid == null && other.accountcategoryid != null) || (this.accountcategoryid != null && !this.accountcategoryid.equals(other.accountcategoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Accountcategory[ accountcategoryid=" + accountcategoryid + " ]";
    }

}
