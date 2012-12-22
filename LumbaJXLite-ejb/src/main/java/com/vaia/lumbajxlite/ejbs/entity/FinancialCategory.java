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
@Table(catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Financialcategory.findAll", query = "SELECT f FROM Financialcategory f"),
    @NamedQuery(name = "Financialcategory.findByFcid", query = "SELECT f FROM Financialcategory f WHERE f.fcid = :fcid"),
    @NamedQuery(name = "Financialcategory.findByFccode", query = "SELECT f FROM Financialcategory f WHERE f.fccode = :fccode"),
    @NamedQuery(name = "Financialcategory.findByFcname", query = "SELECT f FROM Financialcategory f WHERE f.fcname = :fcname"),
    @NamedQuery(name = "Financialcategory.findByStatus", query = "SELECT f FROM Financialcategory f WHERE f.status = :status"),
    @NamedQuery(name = "Financialcategory.findByCreationdate", query = "SELECT f FROM Financialcategory f WHERE f.creationdate = :creationdate"),
    @NamedQuery(name = "Financialcategory.findByCreator", query = "SELECT f FROM Financialcategory f WHERE f.creator = :creator"),
    @NamedQuery(name = "Financialcategory.findByEditdate", query = "SELECT f FROM Financialcategory f WHERE f.editdate = :editdate"),
    @NamedQuery(name = "Financialcategory.findByEditor", query = "SELECT f FROM Financialcategory f WHERE f.editor = :editor"),
    @NamedQuery(name = "Financialcategory.findBySessiondate", query = "SELECT f FROM Financialcategory f WHERE f.sessiondate = :sessiondate")})
public class FinancialCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer fcid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(nullable = false, length = 5)
    private String fccode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String fcname;
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
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid", nullable = false)
    @ManyToOne(optional = false)
    private Category categoryid;
    @OneToMany(mappedBy = "fcid")
    private List<AccountCategory> accountcategoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fcid")
    private List<ChartOfAccount> chartofaccountList;

    public FinancialCategory() {
    }

    public FinancialCategory(Integer fcid) {
        this.fcid = fcid;
    }

    public FinancialCategory(Integer fcid, String fccode, String fcname, boolean status) {
        this.fcid = fcid;
        this.fccode = fccode;
        this.fcname = fcname;
        this.status = status;
    }

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }

    public String getFccode() {
        return fccode;
    }

    public void setFccode(String fccode) {
        this.fccode = fccode;
    }

    public String getFcname() {
        return fcname;
    }

    public void setFcname(String fcname) {
        this.fcname = fcname;
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

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    @XmlTransient
    public List<AccountCategory> getAccountcategoryList() {
        return accountcategoryList;
    }

    public void setAccountcategoryList(List<AccountCategory> accountcategoryList) {
        this.accountcategoryList = accountcategoryList;
    }

    @XmlTransient
    public List<ChartOfAccount> getChartofaccountList() {
        return chartofaccountList;
    }

    public void setChartofaccountList(List<ChartOfAccount> chartofaccountList) {
        this.chartofaccountList = chartofaccountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fcid != null ? fcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinancialCategory)) {
            return false;
        }
        FinancialCategory other = (FinancialCategory) object;
        if ((this.fcid == null && other.fcid != null) || (this.fcid != null && !this.fcid.equals(other.fcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Financialcategory[ fcid=" + fcid + " ]";
    }

}
