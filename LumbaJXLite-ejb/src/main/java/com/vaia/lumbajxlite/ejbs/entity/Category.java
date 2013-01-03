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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @javax.persistence.NamedQuery(name = "Category.findByCategoryid", query = "SELECT c FROM Category c WHERE c.categoryid = :categoryid"),
    @javax.persistence.NamedQuery(name = "Category.findByCategoryname", query = "SELECT c FROM Category c WHERE c.categoryname = :categoryname"),
    @javax.persistence.NamedQuery(name = "Category.findByReportname", query = "SELECT c FROM Category c WHERE c.reportname = :reportname"),
    @javax.persistence.NamedQuery(name = "Category.findByReportstatus", query = "SELECT c FROM Category c WHERE c.reportstatus = :reportstatus"),
    @javax.persistence.NamedQuery(name = "Category.findByReportorder", query = "SELECT c FROM Category c WHERE c.reportorder = :reportorder"),
    @javax.persistence.NamedQuery(name = "Category.findByCreationdate", query = "SELECT c FROM Category c WHERE c.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Category.findByCreator", query = "SELECT c FROM Category c WHERE c.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Category.findByEditdate", query = "SELECT c FROM Category c WHERE c.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Category.findByEditor", query = "SELECT c FROM Category c WHERE c.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Category.findByRefference", query = "SELECT c FROM Category c WHERE c.refference = :refference"),
    @javax.persistence.NamedQuery(name = "Category.findByNormallycredit", query = "SELECT c FROM Category c WHERE c.normallycredit = :normallycredit"),
    @javax.persistence.NamedQuery(name = "Category.findBySessiondate", query = "SELECT c FROM Category c WHERE c.sessiondate = :sessiondate")})
public class Category
        implements Serializable {

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
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "categoryid")
    private List<Financialcategory> financialcategoryList;
    @OneToMany(mappedBy = "categoryid")
    private List<Accountcategory> accountcategoryList;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "categoryid")
    private List<Chartofaccount> chartofaccountList;

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
        return this.categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return this.categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getReportname() {
        return this.reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public Boolean getReportstatus() {
        return this.reportstatus;
    }

    public void setReportstatus(Boolean reportstatus) {
        this.reportstatus = reportstatus;
    }

    public Integer getReportorder() {
        return this.reportorder;
    }

    public void setReportorder(Integer reportorder) {
        this.reportorder = reportorder;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getEditdate() {
        return this.editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getRefference() {
        return this.refference;
    }

    public void setRefference(Integer refference) {
        this.refference = refference;
    }

    public Boolean getNormallycredit() {
        return this.normallycredit;
    }

    public void setNormallycredit(Boolean normallycredit) {
        this.normallycredit = normallycredit;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Financialcategory> getFinancialcategoryList() {
        return this.financialcategoryList;
    }

    public void setFinancialcategoryList(List<Financialcategory> financialcategoryList) {
        this.financialcategoryList = financialcategoryList;
    }

    @XmlTransient
    public List<Accountcategory> getAccountcategoryList() {
        return this.accountcategoryList;
    }

    public void setAccountcategoryList(List<Accountcategory> accountcategoryList) {
        this.accountcategoryList = accountcategoryList;
    }

    @XmlTransient
    public List<Chartofaccount> getChartofaccountList() {
        return this.chartofaccountList;
    }

    public void setChartofaccountList(List<Chartofaccount> chartofaccountList) {
        this.chartofaccountList = chartofaccountList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.categoryid != null ? this.categoryid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if (((this.categoryid == null) && (other.categoryid != null)) || ((this.categoryid != null) && (!this.categoryid.equals(other.categoryid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Category[ categoryid=" + this.categoryid + " ]";
    }
}