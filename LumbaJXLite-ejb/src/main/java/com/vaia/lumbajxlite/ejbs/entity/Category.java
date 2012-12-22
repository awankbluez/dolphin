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
@Table(catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryid", query = "SELECT c FROM Category c WHERE c.categoryid = :categoryid"),
    @NamedQuery(name = "Category.findByCategoryname", query = "SELECT c FROM Category c WHERE c.categoryname = :categoryname"),
    @NamedQuery(name = "Category.findByReportname", query = "SELECT c FROM Category c WHERE c.reportname = :reportname"),
    @NamedQuery(name = "Category.findByReportstatus", query = "SELECT c FROM Category c WHERE c.reportstatus = :reportstatus"),
    @NamedQuery(name = "Category.findByReportorder", query = "SELECT c FROM Category c WHERE c.reportorder = :reportorder"),
    @NamedQuery(name = "Category.findByCreationdate", query = "SELECT c FROM Category c WHERE c.creationdate = :creationdate"),
    @NamedQuery(name = "Category.findByCreator", query = "SELECT c FROM Category c WHERE c.creator = :creator"),
    @NamedQuery(name = "Category.findByEditdate", query = "SELECT c FROM Category c WHERE c.editdate = :editdate"),
    @NamedQuery(name = "Category.findByEditor", query = "SELECT c FROM Category c WHERE c.editor = :editor"),
    @NamedQuery(name = "Category.findByRefference", query = "SELECT c FROM Category c WHERE c.refference = :refference"),
    @NamedQuery(name = "Category.findByNormallycredit", query = "SELECT c FROM Category c WHERE c.normallycredit = :normallycredit"),
    @NamedQuery(name = "Category.findBySessiondate", query = "SELECT c FROM Category c WHERE c.sessiondate = :sessiondate")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer categoryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String categoryname;
    @Size(max = 40)
    @Column(length = 40)
    private String reportname;
    private Boolean reportstatus;
    private Integer reportorder;
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
    private Integer refference;
    private Boolean normallycredit;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryid")
    private List<FinancialCategory> financialcategoryList;
    @OneToMany(mappedBy = "categoryid")
    private List<AccountCategory> accountcategoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryid")
    private List<ChartOfAccount> chartofaccountList;

    public Category() {
    }

    public Category(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Category(Integer categoryid, String categoryname) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public Boolean getReportstatus() {
        return reportstatus;
    }

    public void setReportstatus(Boolean reportstatus) {
        this.reportstatus = reportstatus;
    }

    public Integer getReportorder() {
        return reportorder;
    }

    public void setReportorder(Integer reportorder) {
        this.reportorder = reportorder;
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

    public Integer getRefference() {
        return refference;
    }

    public void setRefference(Integer refference) {
        this.refference = refference;
    }

    public Boolean getNormallycredit() {
        return normallycredit;
    }

    public void setNormallycredit(Boolean normallycredit) {
        this.normallycredit = normallycredit;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<FinancialCategory> getFinancialcategoryList() {
        return financialcategoryList;
    }

    public void setFinancialcategoryList(List<FinancialCategory> financialcategoryList) {
        this.financialcategoryList = financialcategoryList;
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
        hash += (categoryid != null ? categoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryid == null && other.categoryid != null) || (this.categoryid != null && !this.categoryid.equals(other.categoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Category[ categoryid=" + categoryid + " ]";
    }

}
