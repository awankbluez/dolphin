/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    @NamedQuery(name = "Bankaccount.findAll", query = "SELECT b FROM Bankaccount b"),
    @NamedQuery(name = "Bankaccount.findByBankacountid", query = "SELECT b FROM Bankaccount b WHERE b.bankacountid = :bankacountid"),
    @NamedQuery(name = "Bankaccount.findByBankaccountname", query = "SELECT b FROM Bankaccount b WHERE b.bankaccountname = :bankaccountname"),
    @NamedQuery(name = "Bankaccount.findByBankaccountnumber", query = "SELECT b FROM Bankaccount b WHERE b.bankaccountnumber = :bankaccountnumber"),
    @NamedQuery(name = "Bankaccount.findByChequenumber", query = "SELECT b FROM Bankaccount b WHERE b.chequenumber = :chequenumber"),
    @NamedQuery(name = "Bankaccount.findByOverdraftlimit", query = "SELECT b FROM Bankaccount b WHERE b.overdraftlimit = :overdraftlimit"),
    @NamedQuery(name = "Bankaccount.findByCreationdate", query = "SELECT b FROM Bankaccount b WHERE b.creationdate = :creationdate"),
    @NamedQuery(name = "Bankaccount.findByCreator", query = "SELECT b FROM Bankaccount b WHERE b.creator = :creator"),
    @NamedQuery(name = "Bankaccount.findByEditdate", query = "SELECT b FROM Bankaccount b WHERE b.editdate = :editdate"),
    @NamedQuery(name = "Bankaccount.findByEditor", query = "SELECT b FROM Bankaccount b WHERE b.editor = :editor"),
    @NamedQuery(name = "Bankaccount.findByInvesment", query = "SELECT b FROM Bankaccount b WHERE b.invesment = :invesment"),
    @NamedQuery(name = "Bankaccount.findByInvesmentmaturitydate", query = "SELECT b FROM Bankaccount b WHERE b.invesmentmaturitydate = :invesmentmaturitydate"),
    @NamedQuery(name = "Bankaccount.findByCredit", query = "SELECT b FROM Bankaccount b WHERE b.credit = :credit"),
    @NamedQuery(name = "Bankaccount.findBySessiondate", query = "SELECT b FROM Bankaccount b WHERE b.sessiondate = :sessiondate")})
public class BankAccount implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    private BankBranch bankbranchid;
    @JoinColumn(name = "bankid", referencedColumnName = "bankid")
    @ManyToOne
    private Bank bankid;
    @OneToMany(mappedBy = "bankacountid")
    private List<ChartOfAccount> chartofaccountList;

    public BankAccount() {
    }

    public BankAccount(Integer bankacountid) {
        this.bankacountid = bankacountid;
    }

    public BankAccount(Integer bankacountid, String bankaccountname, String bankaccountnumber) {
        this.bankacountid = bankacountid;
        this.bankaccountname = bankaccountname;
        this.bankaccountnumber = bankaccountnumber;
    }

    public Integer getBankacountid() {
        return bankacountid;
    }

    public void setBankacountid(Integer bankacountid) {
        this.bankacountid = bankacountid;
    }

    public String getBankaccountname() {
        return bankaccountname;
    }

    public void setBankaccountname(String bankaccountname) {
        this.bankaccountname = bankaccountname;
    }

    public String getBankaccountnumber() {
        return bankaccountnumber;
    }

    public void setBankaccountnumber(String bankaccountnumber) {
        this.bankaccountnumber = bankaccountnumber;
    }

    public String getChequenumber() {
        return chequenumber;
    }

    public void setChequenumber(String chequenumber) {
        this.chequenumber = chequenumber;
    }

    public Double getOverdraftlimit() {
        return overdraftlimit;
    }

    public void setOverdraftlimit(Double overdraftlimit) {
        this.overdraftlimit = overdraftlimit;
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

    public Boolean getInvesment() {
        return invesment;
    }

    public void setInvesment(Boolean invesment) {
        this.invesment = invesment;
    }

    public Date getInvesmentmaturitydate() {
        return invesmentmaturitydate;
    }

    public void setInvesmentmaturitydate(Date invesmentmaturitydate) {
        this.invesmentmaturitydate = invesmentmaturitydate;
    }

    public Boolean getCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public BankBranch getBankbranchid() {
        return bankbranchid;
    }

    public void setBankbranchid(BankBranch bankbranchid) {
        this.bankbranchid = bankbranchid;
    }

    public Bank getBankid() {
        return bankid;
    }

    public void setBankid(Bank bankid) {
        this.bankid = bankid;
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
        hash += (bankacountid != null ? bankacountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankAccount)) {
            return false;
        }
        BankAccount other = (BankAccount) object;
        if ((this.bankacountid == null && other.bankacountid != null) || (this.bankacountid != null && !this.bankacountid.equals(other.bankacountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Bankaccount[ bankacountid=" + bankacountid + " ]";
    }

}
