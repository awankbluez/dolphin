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
    @javax.persistence.NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @javax.persistence.NamedQuery(name = "Currency.findByCurrencyid", query = "SELECT c FROM Currency c WHERE c.currencyid = :currencyid"),
    @javax.persistence.NamedQuery(name = "Currency.findByCurrencycode", query = "SELECT c FROM Currency c WHERE c.currencycode = :currencycode"),
    @javax.persistence.NamedQuery(name = "Currency.findByCurrencydescribe", query = "SELECT c FROM Currency c WHERE c.currencydescribe = :currencydescribe"),
    @javax.persistence.NamedQuery(name = "Currency.findByCreationdate", query = "SELECT c FROM Currency c WHERE c.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Currency.findByEditdate", query = "SELECT c FROM Currency c WHERE c.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Currency.findByCreator", query = "SELECT c FROM Currency c WHERE c.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Currency.findByEditor", query = "SELECT c FROM Currency c WHERE c.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Currency.findByCurrencysymbol", query = "SELECT c FROM Currency c WHERE c.currencysymbol = :currencysymbol"),
    @javax.persistence.NamedQuery(name = "Currency.findByActive", query = "SELECT c FROM Currency c WHERE c.active = :active"),
    @javax.persistence.NamedQuery(name = "Currency.findBySessiondate", query = "SELECT c FROM Currency c WHERE c.sessiondate = :sessiondate")})
public class Currency
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer currencyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String currencycode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String currencydescribe;
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
    @Size(max = 5)
    @Column(length = 5)
    private String currencysymbol;
    private Boolean active;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "currencyid")
    private List<Chartofaccount> chartofaccountList;

    public Currency() {
    }

    public Currency(Integer currencyid) {
        this.currencyid = currencyid;
    }

    public Currency(Integer currencyid, String currencycode, String currencydescribe) {
        this.currencyid = currencyid;
        this.currencycode = currencycode;
        this.currencydescribe = currencydescribe;
    }

    public Integer getCurrencyid() {
        return this.currencyid;
    }

    public void setCurrencyid(Integer currencyid) {
        this.currencyid = currencyid;
    }

    public String getCurrencycode() {
        return this.currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getCurrencydescribe() {
        return this.currencydescribe;
    }

    public void setCurrencydescribe(String currencydescribe) {
        this.currencydescribe = currencydescribe;
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

    public String getCurrencysymbol() {
        return this.currencysymbol;
    }

    public void setCurrencysymbol(String currencysymbol) {
        this.currencysymbol = currencysymbol;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
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
        hash += (this.currencyid != null ? this.currencyid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if (((this.currencyid == null) && (other.currencyid != null)) || ((this.currencyid != null) && (!this.currencyid.equals(other.currencyid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Currency[ currencyid=" + this.currencyid + " ]";
    }
}