/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountid", query = "SELECT a FROM Account a WHERE a.accountid = :accountid"),
    @NamedQuery(name = "Account.findByAccountcode", query = "SELECT a FROM Account a WHERE a.accountcode = :accountcode"),
    @NamedQuery(name = "Account.findByInterest", query = "SELECT a FROM Account a WHERE a.interest = :interest"),
    @NamedQuery(name = "Account.findByCramount", query = "SELECT a FROM Account a WHERE a.cramount = :cramount"),
    @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"),
    @NamedQuery(name = "Account.findByDramount", query = "SELECT a FROM Account a WHERE a.dramount = :dramount"),
    @NamedQuery(name = "Account.findByAccountofficer", query = "SELECT a FROM Account a WHERE a.accountofficer = :accountofficer"),
    @NamedQuery(name = "Account.findByType", query = "SELECT a FROM Account a WHERE a.type = :type"),
    @NamedQuery(name = "Account.findByStatus", query = "SELECT a FROM Account a WHERE a.status = :status"),
    @NamedQuery(name = "Account.findByCreator", query = "SELECT a FROM Account a WHERE a.creator = :creator"),
    @NamedQuery(name = "Account.findByCreationdate", query = "SELECT a FROM Account a WHERE a.creationdate = :creationdate"),
    @NamedQuery(name = "Account.findByEditdate", query = "SELECT a FROM Account a WHERE a.editdate = :editdate"),
    @NamedQuery(name = "Account.findByEditor", query = "SELECT a FROM Account a WHERE a.editor = :editor"),
    @NamedQuery(name = "Account.findByLasttransaction", query = "SELECT a FROM Account a WHERE a.lasttransaction = :lasttransaction"),
    @NamedQuery(name = "Account.findByLatestmonthpaid", query = "SELECT a FROM Account a WHERE a.latestmonthpaid = :latestmonthpaid"),
    @NamedQuery(name = "Account.findBySavingarrears", query = "SELECT a FROM Account a WHERE a.savingarrears = :savingarrears"),
    @NamedQuery(name = "Account.findByPenalty", query = "SELECT a FROM Account a WHERE a.penalty = :penalty"),
    @NamedQuery(name = "Account.findByRestructureid", query = "SELECT a FROM Account a WHERE a.restructureid = :restructureid"),
    @NamedQuery(name = "Account.findBySessiondate", query = "SELECT a FROM Account a WHERE a.sessiondate = :sessiondate"),
    @NamedQuery(name = "Account.findByExistingloan", query = "SELECT a FROM Account a WHERE a.existingloan = :existingloan"),
    @NamedQuery(name = "Account.findByInterestamount", query = "SELECT a FROM Account a WHERE a.interestamount = :interestamount"),
    @NamedQuery(name = "Account.findByDifferentBalanceDate", query = "SELECT a FROM Account a WHERE a.differentBalanceDate = :differentBalanceDate")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer accountid;
    @Size(max = 100)
    @Column(length = 100)
    private String accountcode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double interest;
    @Column(precision = 17, scale = 17)
    private Double cramount;
    @Column(precision = 17, scale = 17)
    private Double balance;
    @Column(precision = 17, scale = 17)
    private Double dramount;
    private Integer accountofficer;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private char type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String status;
    private Integer creator;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    private Integer editor;
    @Temporal(TemporalType.DATE)
    private Date lasttransaction;
    @Temporal(TemporalType.DATE)
    private Date latestmonthpaid;
    @Column(precision = 17, scale = 17)
    private Double savingarrears;
    @Column(precision = 17, scale = 17)
    private Double penalty;
    private Integer restructureid;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    private Boolean existingloan;
    @Column(precision = 17, scale = 17)
    private Double interestamount;
    @Column(name = "different_balance_date")
    private Integer differentBalanceDate;
    @JoinColumn(name = "savingid", referencedColumnName = "savingid")
    @ManyToOne
    private Saving savingid;
    @JoinColumn(name = "routinglogid", referencedColumnName = "routinglogid")
    @ManyToOne
    private RoutingLog routinglogid;
    @JoinColumn(name = "masteroperationalid", referencedColumnName = "masteroperationalid")
    @ManyToOne
    private Masteroperational masteroperationalid;
    @JoinColumn(name = "loanapplicationid", referencedColumnName = "loanapplicationid")
    @ManyToOne
    private LoanApplication loanapplicationid;
    @JoinColumn(name = "loanid", referencedColumnName = "loanid")
    @ManyToOne
    private Loan loanid;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerid;

    public Account() {
    }

    public Account(Integer accountid) {
        this.accountid = accountid;
    }

    public Account(Integer accountid, char type, String status) {
        this.accountid = accountid;
        this.type = type;
        this.status = status;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getCramount() {
        return cramount;
    }

    public void setCramount(Double cramount) {
        this.cramount = cramount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getDramount() {
        return dramount;
    }

    public void setDramount(Double dramount) {
        this.dramount = dramount;
    }

    public Integer getAccountofficer() {
        return accountofficer;
    }

    public void setAccountofficer(Integer accountofficer) {
        this.accountofficer = accountofficer;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public Integer getEditor() {
        return editor;
    }

    public void setEditor(Integer editor) {
        this.editor = editor;
    }

    public Date getLasttransaction() {
        return lasttransaction;
    }

    public void setLasttransaction(Date lasttransaction) {
        this.lasttransaction = lasttransaction;
    }

    public Date getLatestmonthpaid() {
        return latestmonthpaid;
    }

    public void setLatestmonthpaid(Date latestmonthpaid) {
        this.latestmonthpaid = latestmonthpaid;
    }

    public Double getSavingarrears() {
        return savingarrears;
    }

    public void setSavingarrears(Double savingarrears) {
        this.savingarrears = savingarrears;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public Integer getRestructureid() {
        return restructureid;
    }

    public void setRestructureid(Integer restructureid) {
        this.restructureid = restructureid;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Boolean getExistingloan() {
        return existingloan;
    }

    public void setExistingloan(Boolean existingloan) {
        this.existingloan = existingloan;
    }

    public Double getInterestamount() {
        return interestamount;
    }

    public void setInterestamount(Double interestamount) {
        this.interestamount = interestamount;
    }

    public Integer getDifferentBalanceDate() {
        return differentBalanceDate;
    }

    public void setDifferentBalanceDate(Integer differentBalanceDate) {
        this.differentBalanceDate = differentBalanceDate;
    }

    public Saving getSavingid() {
        return savingid;
    }

    public void setSavingid(Saving savingid) {
        this.savingid = savingid;
    }

    public RoutingLog getRoutinglogid() {
        return routinglogid;
    }

    public void setRoutinglogid(RoutingLog routinglogid) {
        this.routinglogid = routinglogid;
    }

    public Masteroperational getMasteroperationalid() {
        return masteroperationalid;
    }

    public void setMasteroperationalid(Masteroperational masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public LoanApplication getLoanapplicationid() {
        return loanapplicationid;
    }

    public void setLoanapplicationid(LoanApplication loanapplicationid) {
        this.loanapplicationid = loanapplicationid;
    }

    public Loan getLoanid() {
        return loanid;
    }

    public void setLoanid(Loan loanid) {
        this.loanid = loanid;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountid != null ? accountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountid == null && other.accountid != null) || (this.accountid != null && !this.accountid.equals(other.accountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Account[ accountid=" + accountid + " ]";
    }

}
