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
    @javax.persistence.NamedQuery(name = "Bankaccount.findAll", query = "SELECT b FROM Bankaccount b"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByBankacountid", query = "SELECT b FROM Bankaccount b WHERE b.bankacountid = :bankacountid"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByBankaccountname", query = "SELECT b FROM Bankaccount b WHERE b.bankaccountname = :bankaccountname"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByBankaccountnumber", query = "SELECT b FROM Bankaccount b WHERE b.bankaccountnumber = :bankaccountnumber"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByChequenumber", query = "SELECT b FROM Bankaccount b WHERE b.chequenumber = :chequenumber"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByOverdraftlimit", query = "SELECT b FROM Bankaccount b WHERE b.overdraftlimit = :overdraftlimit"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByCreationdate", query = "SELECT b FROM Bankaccount b WHERE b.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByCreator", query = "SELECT b FROM Bankaccount b WHERE b.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByEditdate", query = "SELECT b FROM Bankaccount b WHERE b.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByEditor", query = "SELECT b FROM Bankaccount b WHERE b.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByInvesment", query = "SELECT b FROM Bankaccount b WHERE b.invesment = :invesment"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByInvesmentmaturitydate", query = "SELECT b FROM Bankaccount b WHERE b.invesmentmaturitydate = :invesmentmaturitydate"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findByCredit", query = "SELECT b FROM Bankaccount b WHERE b.credit = :credit"),
    @javax.persistence.NamedQuery(name = "Bankaccount.findBySessiondate", query = "SELECT b FROM Bankaccount b WHERE b.sessiondate = :sessiondate")})
public class Bankaccount
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer bankacountid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String bankaccountname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String bankaccountnumber;
    @Size(max = 50)
    @Column(length = 50)
    private String chequenumber;
    @Column(precision = 17, scale = 17)
    private Double overdraftlimit;
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
    private Boolean invesment;
    @Temporal(TemporalType.DATE)
    private Date invesmentmaturitydate;
    private Boolean credit;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @JoinColumn(name = "bankbranchid", referencedColumnName = "bankbranchid", nullable = false)
    @ManyToOne(optional = false)
    private Bankbranch bankbranchid;
    @JoinColumn(name = "bankid", referencedColumnName = "bankid")
    @ManyToOne
    private Bank bankid;
    @OneToMany(mappedBy = "bankacountid")
    private List<Chartofaccount> chartofaccountList;

    public Bankaccount() {
    }

    public Bankaccount(Integer bankacountid) {
        this.bankacountid = bankacountid;
    }

    public Bankaccount(Integer bankacountid, String bankaccountname, String bankaccountnumber) {
        this.bankacountid = bankacountid;
        this.bankaccountname = bankaccountname;
        this.bankaccountnumber = bankaccountnumber;
    }

    public Integer getBankacountid() {
        return this.bankacountid;
    }

    public void setBankacountid(Integer bankacountid) {
        this.bankacountid = bankacountid;
    }

    public String getBankaccountname() {
        return this.bankaccountname;
    }

    public void setBankaccountname(String bankaccountname) {
        this.bankaccountname = bankaccountname;
    }

    public String getBankaccountnumber() {
        return this.bankaccountnumber;
    }

    public void setBankaccountnumber(String bankaccountnumber) {
        this.bankaccountnumber = bankaccountnumber;
    }

    public String getChequenumber() {
        return this.chequenumber;
    }

    public void setChequenumber(String chequenumber) {
        this.chequenumber = chequenumber;
    }

    public Double getOverdraftlimit() {
        return this.overdraftlimit;
    }

    public void setOverdraftlimit(Double overdraftlimit) {
        this.overdraftlimit = overdraftlimit;
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

    public Boolean getInvesment() {
        return this.invesment;
    }

    public void setInvesment(Boolean invesment) {
        this.invesment = invesment;
    }

    public Date getInvesmentmaturitydate() {
        return this.invesmentmaturitydate;
    }

    public void setInvesmentmaturitydate(Date invesmentmaturitydate) {
        this.invesmentmaturitydate = invesmentmaturitydate;
    }

    public Boolean getCredit() {
        return this.credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Bankbranch getBankbranchid() {
        return this.bankbranchid;
    }

    public void setBankbranchid(Bankbranch bankbranchid) {
        this.bankbranchid = bankbranchid;
    }

    public Bank getBankid() {
        return this.bankid;
    }

    public void setBankid(Bank bankid) {
        this.bankid = bankid;
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
        hash += (this.bankacountid != null ? this.bankacountid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Bankaccount)) {
            return false;
        }
        Bankaccount other = (Bankaccount) object;
        if (((this.bankacountid == null) && (other.bankacountid != null)) || ((this.bankacountid != null) && (!this.bankacountid.equals(other.bankacountid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Bankaccount[ bankacountid=" + this.bankacountid + " ]";
    }
}