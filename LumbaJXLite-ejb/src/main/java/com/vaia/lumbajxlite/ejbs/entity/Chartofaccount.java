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
    @javax.persistence.NamedQuery(name = "Chartofaccount.findAll", query = "SELECT c FROM Chartofaccount c"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByChartofaccountid", query = "SELECT c FROM Chartofaccount c WHERE c.chartofaccountid = :chartofaccountid"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByGeneralaccountnumber", query = "SELECT c FROM Chartofaccount c WHERE c.generalaccountnumber = :generalaccountnumber"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByChartofaccountname", query = "SELECT c FROM Chartofaccount c WHERE c.chartofaccountname = :chartofaccountname"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByNormallycredit", query = "SELECT c FROM Chartofaccount c WHERE c.normallycredit = :normallycredit"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByInvestment", query = "SELECT c FROM Chartofaccount c WHERE c.investment = :investment"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByInvestmentmaturitydate", query = "SELECT c FROM Chartofaccount c WHERE c.investmentmaturitydate = :investmentmaturitydate"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByAlsodisplayaccountnumber", query = "SELECT c FROM Chartofaccount c WHERE c.alsodisplayaccountnumber = :alsodisplayaccountnumber"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByCreationdate", query = "SELECT c FROM Chartofaccount c WHERE c.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByCreator", query = "SELECT c FROM Chartofaccount c WHERE c.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByEditdate", query = "SELECT c FROM Chartofaccount c WHERE c.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByEditor", query = "SELECT c FROM Chartofaccount c WHERE c.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByMainaccountid", query = "SELECT c FROM Chartofaccount c WHERE c.mainaccountid = :mainaccountid"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByDramount", query = "SELECT c FROM Chartofaccount c WHERE c.dramount = :dramount"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByCramount", query = "SELECT c FROM Chartofaccount c WHERE c.cramount = :cramount"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByDrcurrencyamount", query = "SELECT c FROM Chartofaccount c WHERE c.drcurrencyamount = :drcurrencyamount"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByCrcurrencyamount", query = "SELECT c FROM Chartofaccount c WHERE c.crcurrencyamount = :crcurrencyamount"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByNumberoftransactions", query = "SELECT c FROM Chartofaccount c WHERE c.numberoftransactions = :numberoftransactions"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByBalancedate", query = "SELECT c FROM Chartofaccount c WHERE c.balancedate = :balancedate"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByStatus", query = "SELECT c FROM Chartofaccount c WHERE c.status = :status"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByBalance", query = "SELECT c FROM Chartofaccount c WHERE c.balance = :balance"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByFlag", query = "SELECT c FROM Chartofaccount c WHERE c.flag = :flag"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findByLevel", query = "SELECT c FROM Chartofaccount c WHERE c.level = :level"),
    @javax.persistence.NamedQuery(name = "Chartofaccount.findBySessiondate", query = "SELECT c FROM Chartofaccount c WHERE c.sessiondate = :sessiondate")})
public class Chartofaccount
        implements Serializable {

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
        return this.chartofaccountid;
    }

    public void setChartofaccountid(Integer chartofaccountid) {
        this.chartofaccountid = chartofaccountid;
    }

    public String getGeneralaccountnumber() {
        return this.generalaccountnumber;
    }

    public void setGeneralaccountnumber(String generalaccountnumber) {
        this.generalaccountnumber = generalaccountnumber;
    }

    public String getChartofaccountname() {
        return this.chartofaccountname;
    }

    public void setChartofaccountname(String chartofaccountname) {
        this.chartofaccountname = chartofaccountname;
    }

    public Boolean getNormallycredit() {
        return this.normallycredit;
    }

    public void setNormallycredit(Boolean normallycredit) {
        this.normallycredit = normallycredit;
    }

    public Boolean getInvestment() {
        return this.investment;
    }

    public void setInvestment(Boolean investment) {
        this.investment = investment;
    }

    public Date getInvestmentmaturitydate() {
        return this.investmentmaturitydate;
    }

    public void setInvestmentmaturitydate(Date investmentmaturitydate) {
        this.investmentmaturitydate = investmentmaturitydate;
    }

    public Boolean getAlsodisplayaccountnumber() {
        return this.alsodisplayaccountnumber;
    }

    public void setAlsodisplayaccountnumber(Boolean alsodisplayaccountnumber) {
        this.alsodisplayaccountnumber = alsodisplayaccountnumber;
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

    public Integer getMainaccountid() {
        return this.mainaccountid;
    }

    public void setMainaccountid(Integer mainaccountid) {
        this.mainaccountid = mainaccountid;
    }

    public Double getDramount() {
        return this.dramount;
    }

    public void setDramount(Double dramount) {
        this.dramount = dramount;
    }

    public Double getCramount() {
        return this.cramount;
    }

    public void setCramount(Double cramount) {
        this.cramount = cramount;
    }

    public Double getDrcurrencyamount() {
        return this.drcurrencyamount;
    }

    public void setDrcurrencyamount(Double drcurrencyamount) {
        this.drcurrencyamount = drcurrencyamount;
    }

    public Double getCrcurrencyamount() {
        return this.crcurrencyamount;
    }

    public void setCrcurrencyamount(Double crcurrencyamount) {
        this.crcurrencyamount = crcurrencyamount;
    }

    public Double getNumberoftransactions() {
        return this.numberoftransactions;
    }

    public void setNumberoftransactions(Double numberoftransactions) {
        this.numberoftransactions = numberoftransactions;
    }

    public Date getBalancedate() {
        return this.balancedate;
    }

    public void setBalancedate(Date balancedate) {
        this.balancedate = balancedate;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList() {
        return this.operatoruserList;
    }

    public void setOperatoruserList(List<Operatoruser> operatoruserList) {
        this.operatoruserList = operatoruserList;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList1() {
        return this.operatoruserList1;
    }

    public void setOperatoruserList1(List<Operatoruser> operatoruserList1) {
        this.operatoruserList1 = operatoruserList1;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList2() {
        return this.operatoruserList2;
    }

    public void setOperatoruserList2(List<Operatoruser> operatoruserList2) {
        this.operatoruserList2 = operatoruserList2;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList3() {
        return this.operatoruserList3;
    }

    public void setOperatoruserList3(List<Operatoruser> operatoruserList3) {
        this.operatoruserList3 = operatoruserList3;
    }

    public Masteroperational getMasteroperationalid() {
        return this.masteroperationalid;
    }

    public void setMasteroperationalid(Masteroperational masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Financialcategory getFcid() {
        return this.fcid;
    }

    public void setFcid(Financialcategory fcid) {
        this.fcid = fcid;
    }

    public Currency getCurrencyid() {
        return this.currencyid;
    }

    public void setCurrencyid(Currency currencyid) {
        this.currencyid = currencyid;
    }

    public Category getCategoryid() {
        return this.categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    public Bankaccount getBankacountid() {
        return this.bankacountid;
    }

    public void setBankacountid(Bankaccount bankacountid) {
        this.bankacountid = bankacountid;
    }

    public Accounttype getAccounttypeid() {
        return this.accounttypeid;
    }

    public void setAccounttypeid(Accounttype accounttypeid) {
        this.accounttypeid = accounttypeid;
    }

    public Accountcategory getAccountcategoryid() {
        return this.accountcategoryid;
    }

    public void setAccountcategoryid(Accountcategory accountcategoryid) {
        this.accountcategoryid = accountcategoryid;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.chartofaccountid != null ? this.chartofaccountid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Chartofaccount)) {
            return false;
        }
        Chartofaccount other = (Chartofaccount) object;
        if (((this.chartofaccountid == null) && (other.chartofaccountid != null)) || ((this.chartofaccountid != null) && (!this.chartofaccountid.equals(other.chartofaccountid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Chartofaccount[ chartofaccountid=" + this.chartofaccountid + " ]";
    }
}