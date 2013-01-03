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
    @javax.persistence.NamedQuery(name = "Accountcategory.findAll", query = "SELECT a FROM Accountcategory a"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByAccountcategoryid", query = "SELECT a FROM Accountcategory a WHERE a.accountcategoryid = :accountcategoryid"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByReference", query = "SELECT a FROM Accountcategory a WHERE a.reference = :reference"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByDescription", query = "SELECT a FROM Accountcategory a WHERE a.description = :description"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByStatus", query = "SELECT a FROM Accountcategory a WHERE a.status = :status"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByCreationdate", query = "SELECT a FROM Accountcategory a WHERE a.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByCreator", query = "SELECT a FROM Accountcategory a WHERE a.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByEditdate", query = "SELECT a FROM Accountcategory a WHERE a.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findByEditor", query = "SELECT a FROM Accountcategory a WHERE a.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Accountcategory.findBySessiondate", query = "SELECT a FROM Accountcategory a WHERE a.sessiondate = :sessiondate")})
public class Accountcategory
        implements Serializable {

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
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "accountcategoryid")
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
        return this.accountcategoryid;
    }

    public void setAccountcategoryid(Integer accountcategoryid) {
        this.accountcategoryid = accountcategoryid;
    }

    public Integer getReference() {
        return this.reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Financialcategory getFcid() {
        return this.fcid;
    }

    public void setFcid(Financialcategory fcid) {
        this.fcid = fcid;
    }

    public Category getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
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
        hash += (this.accountcategoryid != null ? this.accountcategoryid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Accountcategory)) {
            return false;
        }
        Accountcategory other = (Accountcategory) object;
        if (((this.accountcategoryid == null) && (other.accountcategoryid != null)) || ((this.accountcategoryid != null) && (!this.accountcategoryid.equals(other.accountcategoryid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Accountcategory[ accountcategoryid=" + this.accountcategoryid + " ]";
    }
}