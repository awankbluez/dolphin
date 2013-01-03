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
@Table(schema = "public", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"countrycode"}),
    @javax.persistence.UniqueConstraint(columnNames = {"countryname"})})
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @javax.persistence.NamedQuery(name = "Country.findByCountryid", query = "SELECT c FROM Country c WHERE c.countryid = :countryid"),
    @javax.persistence.NamedQuery(name = "Country.findByCountrycode", query = "SELECT c FROM Country c WHERE c.countrycode = :countrycode"),
    @javax.persistence.NamedQuery(name = "Country.findByCountryname", query = "SELECT c FROM Country c WHERE c.countryname = :countryname"),
    @javax.persistence.NamedQuery(name = "Country.findByCreationdate", query = "SELECT c FROM Country c WHERE c.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Country.findByEditdate", query = "SELECT c FROM Country c WHERE c.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Country.findByCreator", query = "SELECT c FROM Country c WHERE c.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Country.findByEditor", query = "SELECT c FROM Country c WHERE c.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Country.findBySessiondate", query = "SELECT c FROM Country c WHERE c.sessiondate = :sessiondate")})
public class Country
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer countryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String countrycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String countryname;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 40)
    @Column(length = 40)
    private String creator;
    @Size(max = 40)
    @Column(length = 40)
    private String editor;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(mappedBy = "countryid")
    private List<Customer> customerList;
    @OneToMany(mappedBy = "countryid")
    private List<Province> provinceList;

    public Country() {
    }

    public Country(Integer countryid) {
        this.countryid = countryid;
    }

    public Country(Integer countryid, String countrycode, String countryname) {
        this.countryid = countryid;
        this.countrycode = countrycode;
        this.countryname = countryname;
    }

    public Integer getCountryid() {
        return this.countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public String getCountrycode() {
        return this.countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryname() {
        return this.countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getEditdate() {
        return this.editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    @XmlTransient
    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlTransient
    public List<Province> getProvinceList() {
        return this.provinceList;
    }

    public void setProvinceList(List<Province> provinceList) {
        this.provinceList = provinceList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.countryid != null ? this.countryid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if (((this.countryid == null) && (other.countryid != null)) || ((this.countryid != null) && (!this.countryid.equals(other.countryid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Country[ countryid=" + this.countryid + " ]";
    }
}