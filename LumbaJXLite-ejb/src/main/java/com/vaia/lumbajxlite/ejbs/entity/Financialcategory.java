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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @javax.persistence.NamedQuery(name = "Financialcategory.findAll", query = "SELECT f FROM Financialcategory f"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByFcid", query = "SELECT f FROM Financialcategory f WHERE f.fcid = :fcid"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByFccode", query = "SELECT f FROM Financialcategory f WHERE f.fccode = :fccode"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByFcname", query = "SELECT f FROM Financialcategory f WHERE f.fcname = :fcname"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByStatus", query = "SELECT f FROM Financialcategory f WHERE f.status = :status"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByCreationdate", query = "SELECT f FROM Financialcategory f WHERE f.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByCreator", query = "SELECT f FROM Financialcategory f WHERE f.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByEditdate", query = "SELECT f FROM Financialcategory f WHERE f.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findByEditor", query = "SELECT f FROM Financialcategory f WHERE f.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Financialcategory.findBySessiondate", query = "SELECT f FROM Financialcategory f WHERE f.sessiondate = :sessiondate")})
public class Financialcategory
        implements Serializable {

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
    private List<Accountcategory> accountcategoryList;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "fcid")
    private List<Chartofaccount> chartofaccountList;

    public Financialcategory() {
    }

    public Financialcategory(Integer fcid) {
        this.fcid = fcid;
    }

    public Financialcategory(Integer fcid, String fccode, String fcname, boolean status) {
        this.fcid = fcid;
        this.fccode = fccode;
        this.fcname = fcname;
        this.status = status;
    }

    public Integer getFcid() {
        return this.fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }

    public String getFccode() {
        return this.fccode;
    }

    public void setFccode(String fccode) {
        this.fccode = fccode;
    }

    public String getFcname() {
        return this.fcname;
    }

    public void setFcname(String fcname) {
        this.fcname = fcname;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Category getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
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
        hash += (this.fcid != null ? this.fcid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Financialcategory)) {
            return false;
        }
        Financialcategory other = (Financialcategory) object;
        if (((this.fcid == null) && (other.fcid != null)) || ((this.fcid != null) && (!this.fcid.equals(other.fcid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Financialcategory[ fcid=" + this.fcid + " ]";
    }
}