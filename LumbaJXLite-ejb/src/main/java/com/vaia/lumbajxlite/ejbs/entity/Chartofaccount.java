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
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chartofaccount.findAll", query = "SELECT c FROM Chartofaccount c"),
    @NamedQuery(name = "Chartofaccount.findByChartofaccountid", query = "SELECT c FROM Chartofaccount c WHERE c.chartofaccountid = :chartofaccountid"),
    @NamedQuery(name = "Chartofaccount.findByGeneralaccountnumber", query = "SELECT c FROM Chartofaccount c WHERE c.generalaccountnumber = :generalaccountnumber"),
    @NamedQuery(name = "Chartofaccount.findByChartofaccountname", query = "SELECT c FROM Chartofaccount c WHERE c.chartofaccountname = :chartofaccountname"),
    @NamedQuery(name = "Chartofaccount.findByNormallycredit", query = "SELECT c FROM Chartofaccount c WHERE c.normallycredit = :normallycredit"),
    @NamedQuery(name = "Chartofaccount.findByInvestment", query = "SELECT c FROM Chartofaccount c WHERE c.investment = :investment"),
    @NamedQuery(name = "Chartofaccount.findByInvestmentmaturitydate", query = "SELECT c FROM Chartofaccount c WHERE c.investmentmaturitydate = :investmentmaturitydate"),
    @NamedQuery(name = "Chartofaccount.findByAlsodisplayaccountnumber", query = "SELECT c FROM Chartofaccount c WHERE c.alsodisplayaccountnumber = :alsodisplayaccountnumber"),
    @NamedQuery(name = "Chartofaccount.findByCreationdate", query = "SELECT c FROM Chartofaccount c WHERE c.creationdate = :creationdate"),
    @NamedQuery(name = "Chartofaccount.findByCreator", query = "SELECT c FROM Chartofaccount c WHERE c.creator = :creator"),
    @NamedQuery(name = "Chartofaccount.findByEditdate", query = "SELECT c FROM Chartofaccount c WHERE c.editdate = :editdate"),
    @NamedQuery(name = "Chartofaccount.findByEditor", query = "SELECT c FROM Chartofaccount c WHERE c.editor = :editor"),
    @NamedQuery(name = "Chartofaccount.findByMainaccountid", query = "SELECT c FROM Chartofaccount c WHERE c.mainaccountid = :mainaccountid"),
    @NamedQuery(name = "Chartofaccount.findByDramount", query = "SELECT c FROM Chartofaccount c WHERE c.dramount = :dramount"),
    @NamedQuery(name = "Chartofaccount.findByCramount", query = "SELECT c FROM Chartofaccount c WHERE c.cramount = :cramount"),
    @NamedQuery(name = "Chartofaccount.findByDrcurrencyamount", query = "SELECT c FROM Chartofaccount c WHERE c.drcurrencyamount = :drcurrencyamount"),
    @NamedQuery(name = "Chartofaccount.findByCrcurrencyamount", query = "SELECT c FROM Chartofaccount c WHERE c.crcurrencyamount = :crcurrencyamount"),
    @NamedQuery(name = "Chartofaccount.findByNumberoftransactions", query = "SELECT c FROM Chartofaccount c WHERE c.numberoftransactions = :numberoftransactions"),
    @NamedQuery(name = "Chartofaccount.findByBalancedate", query = "SELECT c FROM Chartofaccount c WHERE c.balancedate = :balancedate"),
    @NamedQuery(name = "Chartofaccount.findByStatus", query = "SELECT c FROM Chartofaccount c WHERE c.status = :status"),
    @NamedQuery(name = "Chartofaccount.findByBalance", query = "SELECT c FROM Chartofaccount c WHERE c.balance = :balance"),
    @NamedQuery(name = "Chartofaccount.findByFlag", query = "SELECT c FROM Chartofaccount c WHERE c.flag = :flag"),
    @NamedQuery(name = "Chartofaccount.findByLevel", query = "SELECT c FROM Chartofaccount c WHERE c.level = :level"),
    @NamedQuery(name = "Chartofaccount.findBySessiondate", query = "SELECT c FROM Chartofaccount c WHERE c.sessiondate = :sessiondate")})
public class Chartofaccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer chartofaccountid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String generalaccountnumber;
    @Size(max = 100)
    @Column(length = 100)
    private String chartofaccountname;
    private Boolean normallycredit;
    private Boolean investment;
    @Temporal(TemporalType.DATE)
    private Date investmentmaturitydate;
    private Boolean alsodisplayaccountnumber;
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
    private Integer mainaccountid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double dramount;
    @Column(precision = 17, scale = 17)
    private Double cramount;
    @Column(precision = 17, scale = 17)
    private Double drcurrencyamount;
    @Column(precision = 17, scale = 17)
    private Double crcurrencyamount;
    @Column(precision = 17, scale = 17)
    private Double numberoftransactions;
    @Temporal(TemporalType.DATE)
    private Date balancedate;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean status;
    @Column(precision = 17, scale = 17)
    private Double balance;
    private Integer flag;
    private Integer level;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(mappedBy = "userterminalcontra")
    private List<Operatoruser> operatoruserList;
    @OneToMany(mappedBy = "userterminalsuspense")
    private List<Operatoruser> operatoruserList1;
    @OneToMany(mappedBy = "userterminalchequecontra")
    private List<Operatoruser> operatoruserList2;
    @OneToMany(mappedBy = "userterminaldeficitsurplus")
    private List<Operatoruser> operatoruserList3;
    @OneToMany(mappedBy = "savinginterestdevidedtaxpayable")
    private List<Saving> savingList;
    @OneToMany(mappedBy = "savinginterestdevidedpayable")
    private List<Saving> savingList1;
    @OneToMany(mappedBy = "savinginterestdevidedexpense")
    private List<Saving> savingList2;
    @OneToMany(mappedBy = "productcontrolaccountnormal")
    private List<Saving> savingList3;
    @OneToMany(mappedBy = "overdraftcontrolaccountnormal")
    private List<Saving> savingList4;
    @OneToMany(mappedBy = "baddebtincome")
    private List<Saving> savingList5;
    @OneToMany(mappedBy = "baddebtexpense")
    private List<Saving> savingList6;
    @OneToMany(mappedBy = "savingstaxwithheld")
    private List<Saving> savingList7;
    @JoinColumn(name = "masteroperationalid", referencedColumnName = "masteroperationalid", nullable = false)
    @ManyToOne(optional = false)
    private Masteroperational masteroperationalid;
    @JoinColumn(name = "fcid", referencedColumnName = "fcid", nullable = false)
    @ManyToOne(optional = false)
    private Financialcategory fcid;
    @JoinColumn(name = "currencyid", referencedColumnName = "currencyid", nullable = false)
    @ManyToOne(optional = false)
    private Currency currencyid;
    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid", nullable = false)
    @ManyToOne(optional = false)
    private Category categoryid;
    @JoinColumn(name = "bankacountid", referencedColumnName = "bankacountid")
    @ManyToOne
    private Bankaccount bankacountid;
    @JoinColumn(name = "accounttypeid", referencedColumnName = "accounttypeid", nullable = false)
    @ManyToOne(optional = false)
    private Accounttype accounttypeid;
    @JoinColumn(name = "accountcategoryid", referencedColumnName = "accountcategoryid", nullable = false)
    @ManyToOne(optional = false)
    private Accountcategory accountcategoryid;

    public Chartofaccount() {
    }

    public Chartofaccount(Integer chartofaccountid) {
        this.chartofaccountid = chartofaccountid;
    }

    public Chartofaccount(Integer chartofaccountid, String generalaccountnumber, boolean status) {
        this.chartofaccountid = chartofaccountid;
        this.generalaccountnumber = generalaccountnumber;
        this.status = status;
    }

    public Integer getChartofaccountid() {
        return chartofaccountid;
    }

    public void setChartofaccountid(Integer chartofaccountid) {
        this.chartofaccountid = chartofaccountid;
    }

    public String getGeneralaccountnumber() {
        return generalaccountnumber;
    }

    public void setGeneralaccountnumber(String generalaccountnumber) {
        this.generalaccountnumber = generalaccountnumber;
    }

    public String getChartofaccountname() {
        return chartofaccountname;
    }

    public void setChartofaccountname(String chartofaccountname) {
        this.chartofaccountname = chartofaccountname;
    }

    public Boolean getNormallycredit() {
        return normallycredit;
    }

    public void setNormallycredit(Boolean normallycredit) {
        this.normallycredit = normallycredit;
    }

    public Boolean getInvestment() {
        return investment;
    }

    public void setInvestment(Boolean investment) {
        this.investment = investment;
    }

    public Date getInvestmentmaturitydate() {
        return investmentmaturitydate;
    }

    public void setInvestmentmaturitydate(Date investmentmaturitydate) {
        this.investmentmaturitydate = investmentmaturitydate;
    }

    public Boolean getAlsodisplayaccountnumber() {
        return alsodisplayaccountnumber;
    }

    public void setAlsodisplayaccountnumber(Boolean alsodisplayaccountnumber) {
        this.alsodisplayaccountnumber = alsodisplayaccountnumber;
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

    public Integer getMainaccountid() {
        return mainaccountid;
    }

    public void setMainaccountid(Integer mainaccountid) {
        this.mainaccountid = mainaccountid;
    }

    public Double getDramount() {
        return dramount;
    }

    public void setDramount(Double dramount) {
        this.dramount = dramount;
    }

    public Double getCramount() {
        return cramount;
    }

    public void setCramount(Double cramount) {
        this.cramount = cramount;
    }

    public Double getDrcurrencyamount() {
        return drcurrencyamount;
    }

    public void setDrcurrencyamount(Double drcurrencyamount) {
        this.drcurrencyamount = drcurrencyamount;
    }

    public Double getCrcurrencyamount() {
        return crcurrencyamount;
    }

    public void setCrcurrencyamount(Double crcurrencyamount) {
        this.crcurrencyamount = crcurrencyamount;
    }

    public Double getNumberoftransactions() {
        return numberoftransactions;
    }

    public void setNumberoftransactions(Double numberoftransactions) {
        this.numberoftransactions = numberoftransactions;
    }

    public Date getBalancedate() {
        return balancedate;
    }

    public void setBalancedate(Date balancedate) {
        this.balancedate = balancedate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList() {
        return operatoruserList;
    }

    public void setOperatoruserList(List<Operatoruser> operatoruserList) {
        this.operatoruserList = operatoruserList;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList1() {
        return operatoruserList1;
    }

    public void setOperatoruserList1(List<Operatoruser> operatoruserList1) {
        this.operatoruserList1 = operatoruserList1;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList2() {
        return operatoruserList2;
    }

    public void setOperatoruserList2(List<Operatoruser> operatoruserList2) {
        this.operatoruserList2 = operatoruserList2;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList3() {
        return operatoruserList3;
    }

    public void setOperatoruserList3(List<Operatoruser> operatoruserList3) {
        this.operatoruserList3 = operatoruserList3;
    }

    @XmlTransient
    public List<Saving> getSavingList() {
        return savingList;
    }

    public void setSavingList(List<Saving> savingList) {
        this.savingList = savingList;
    }

    @XmlTransient
    public List<Saving> getSavingList1() {
        return savingList1;
    }

    public void setSavingList1(List<Saving> savingList1) {
        this.savingList1 = savingList1;
    }

    @XmlTransient
    public List<Saving> getSavingList2() {
        return savingList2;
    }

    public void setSavingList2(List<Saving> savingList2) {
        this.savingList2 = savingList2;
    }

    @XmlTransient
    public List<Saving> getSavingList3() {
        return savingList3;
    }

    public void setSavingList3(List<Saving> savingList3) {
        this.savingList3 = savingList3;
    }

    @XmlTransient
    public List<Saving> getSavingList4() {
        return savingList4;
    }

    public void setSavingList4(List<Saving> savingList4) {
        this.savingList4 = savingList4;
    }

    @XmlTransient
    public List<Saving> getSavingList5() {
        return savingList5;
    }

    public void setSavingList5(List<Saving> savingList5) {
        this.savingList5 = savingList5;
    }

    @XmlTransient
    public List<Saving> getSavingList6() {
        return savingList6;
    }

    public void setSavingList6(List<Saving> savingList6) {
        this.savingList6 = savingList6;
    }

    @XmlTransient
    public List<Saving> getSavingList7() {
        return savingList7;
    }

    public void setSavingList7(List<Saving> savingList7) {
        this.savingList7 = savingList7;
    }

    public Masteroperational getMasteroperationalid() {
        return masteroperationalid;
    }

    public void setMasteroperationalid(Masteroperational masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Financialcategory getFcid() {
        return fcid;
    }

    public void setFcid(Financialcategory fcid) {
        this.fcid = fcid;
    }

    public Currency getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(Currency currencyid) {
        this.currencyid = currencyid;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    public Bankaccount getBankacountid() {
        return bankacountid;
    }

    public void setBankacountid(Bankaccount bankacountid) {
        this.bankacountid = bankacountid;
    }

    public Accounttype getAccounttypeid() {
        return accounttypeid;
    }

    public void setAccounttypeid(Accounttype accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public Accountcategory getAccountcategoryid() {
        return accountcategoryid;
    }

    public void setAccountcategoryid(Accountcategory accountcategoryid) {
        this.accountcategoryid = accountcategoryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chartofaccountid != null ? chartofaccountid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chartofaccount)) {
            return false;
        }
        Chartofaccount other = (Chartofaccount) object;
        if ((this.chartofaccountid == null && other.chartofaccountid != null) || (this.chartofaccountid != null && !this.chartofaccountid.equals(other.chartofaccountid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Chartofaccount[ chartofaccountid=" + chartofaccountid + " ]";
    }

}
