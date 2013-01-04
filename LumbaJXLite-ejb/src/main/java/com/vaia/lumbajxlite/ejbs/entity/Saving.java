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
    @NamedQuery(name = "Saving.findAll", query = "SELECT s FROM Saving s"),
    @NamedQuery(name = "Saving.findBySavingid", query = "SELECT s FROM Saving s WHERE s.savingid = :savingid"),
    @NamedQuery(name = "Saving.findBySavingtype", query = "SELECT s FROM Saving s WHERE s.savingtype = :savingtype"),
    @NamedQuery(name = "Saving.findBySavingcode", query = "SELECT s FROM Saving s WHERE s.savingcode = :savingcode"),
    @NamedQuery(name = "Saving.findBySavingname", query = "SELECT s FROM Saving s WHERE s.savingname = :savingname"),
    @NamedQuery(name = "Saving.findBySavingstatus", query = "SELECT s FROM Saving s WHERE s.savingstatus = :savingstatus"),
    @NamedQuery(name = "Saving.findByDescription", query = "SELECT s FROM Saving s WHERE s.description = :description"),
    @NamedQuery(name = "Saving.findByStandingorderssupported", query = "SELECT s FROM Saving s WHERE s.standingorderssupported = :standingorderssupported"),
    @NamedQuery(name = "Saving.findByLinkingbetweenaccounttype", query = "SELECT s FROM Saving s WHERE s.linkingbetweenaccounttype = :linkingbetweenaccounttype"),
    @NamedQuery(name = "Saving.findByPayrollsupport", query = "SELECT s FROM Saving s WHERE s.payrollsupport = :payrollsupport"),
    @NamedQuery(name = "Saving.findByInteresttax", query = "SELECT s FROM Saving s WHERE s.interesttax = :interesttax"),
    @NamedQuery(name = "Saving.findByPaymentperiodevalue", query = "SELECT s FROM Saving s WHERE s.paymentperiodevalue = :paymentperiodevalue"),
    @NamedQuery(name = "Saving.findByGraceperiode", query = "SELECT s FROM Saving s WHERE s.graceperiode = :graceperiode"),
    @NamedQuery(name = "Saving.findByMinimumage", query = "SELECT s FROM Saving s WHERE s.minimumage = :minimumage"),
    @NamedQuery(name = "Saving.findByMaximumage", query = "SELECT s FROM Saving s WHERE s.maximumage = :maximumage"),
    @NamedQuery(name = "Saving.findByInitialminimumdeposit", query = "SELECT s FROM Saving s WHERE s.initialminimumdeposit = :initialminimumdeposit"),
    @NamedQuery(name = "Saving.findByInitialmaximumdeposit", query = "SELECT s FROM Saving s WHERE s.initialmaximumdeposit = :initialmaximumdeposit"),
    @NamedQuery(name = "Saving.findByMinimumbalanceheld", query = "SELECT s FROM Saving s WHERE s.minimumbalanceheld = :minimumbalanceheld"),
    @NamedQuery(name = "Saving.findByMinimumbalancetoearninterest", query = "SELECT s FROM Saving s WHERE s.minimumbalancetoearninterest = :minimumbalancetoearninterest"),
    @NamedQuery(name = "Saving.findByRequireddeposit", query = "SELECT s FROM Saving s WHERE s.requireddeposit = :requireddeposit"),
    @NamedQuery(name = "Saving.findByOverdraftlimit", query = "SELECT s FROM Saving s WHERE s.overdraftlimit = :overdraftlimit"),
    @NamedQuery(name = "Saving.findByExcesswithdrawal", query = "SELECT s FROM Saving s WHERE s.excesswithdrawal = :excesswithdrawal"),
    @NamedQuery(name = "Saving.findByAtmenable", query = "SELECT s FROM Saving s WHERE s.atmenable = :atmenable"),
    @NamedQuery(name = "Saving.findByDailylimit", query = "SELECT s FROM Saving s WHERE s.dailylimit = :dailylimit"),
    @NamedQuery(name = "Saving.findByNumberoffreewithdrawalinamonth", query = "SELECT s FROM Saving s WHERE s.numberoffreewithdrawalinamonth = :numberoffreewithdrawalinamonth"),
    @NamedQuery(name = "Saving.findByCalculationmethod", query = "SELECT s FROM Saving s WHERE s.calculationmethod = :calculationmethod"),
    @NamedQuery(name = "Saving.findByInterestpaymentmethod", query = "SELECT s FROM Saving s WHERE s.interestpaymentmethod = :interestpaymentmethod"),
    @NamedQuery(name = "Saving.findByMinimuminterestagelimit", query = "SELECT s FROM Saving s WHERE s.minimuminterestagelimit = :minimuminterestagelimit"),
    @NamedQuery(name = "Saving.findByMaximuminterestagelimit", query = "SELECT s FROM Saving s WHERE s.maximuminterestagelimit = :maximuminterestagelimit"),
    @NamedQuery(name = "Saving.findByAllowdormancy", query = "SELECT s FROM Saving s WHERE s.allowdormancy = :allowdormancy"),
    @NamedQuery(name = "Saving.findByDormanafter", query = "SELECT s FROM Saving s WHERE s.dormanafter = :dormanafter"),
    @NamedQuery(name = "Saving.findByDormanaftervalue", query = "SELECT s FROM Saving s WHERE s.dormanaftervalue = :dormanaftervalue"),
    @NamedQuery(name = "Saving.findByDormancyfee", query = "SELECT s FROM Saving s WHERE s.dormancyfee = :dormancyfee"),
    @NamedQuery(name = "Saving.findByTransactiontype", query = "SELECT s FROM Saving s WHERE s.transactiontype = :transactiontype"),
    @NamedQuery(name = "Saving.findByMinimumbalance", query = "SELECT s FROM Saving s WHERE s.minimumbalance = :minimumbalance"),
    @NamedQuery(name = "Saving.findByTermlimit", query = "SELECT s FROM Saving s WHERE s.termlimit = :termlimit"),
    @NamedQuery(name = "Saving.findByNointerestifclosedbeforeminimumterm", query = "SELECT s FROM Saving s WHERE s.nointerestifclosedbeforeminimumterm = :nointerestifclosedbeforeminimumterm"),
    @NamedQuery(name = "Saving.findByRolloverperiode", query = "SELECT s FROM Saving s WHERE s.rolloverperiode = :rolloverperiode"),
    @NamedQuery(name = "Saving.findByEarlyclosurepenaltytype", query = "SELECT s FROM Saving s WHERE s.earlyclosurepenaltytype = :earlyclosurepenaltytype"),
    @NamedQuery(name = "Saving.findByEarlyclosurepenaltyvalue", query = "SELECT s FROM Saving s WHERE s.earlyclosurepenaltyvalue = :earlyclosurepenaltyvalue"),
    @NamedQuery(name = "Saving.findByCreationdate", query = "SELECT s FROM Saving s WHERE s.creationdate = :creationdate"),
    @NamedQuery(name = "Saving.findByCreator", query = "SELECT s FROM Saving s WHERE s.creator = :creator"),
    @NamedQuery(name = "Saving.findByEditdate", query = "SELECT s FROM Saving s WHERE s.editdate = :editdate"),
    @NamedQuery(name = "Saving.findByEditor", query = "SELECT s FROM Saving s WHERE s.editor = :editor"),
    @NamedQuery(name = "Saving.findByTermofautomaticclosedpermanent", query = "SELECT s FROM Saving s WHERE s.termofautomaticclosedpermanent = :termofautomaticclosedpermanent"),
    @NamedQuery(name = "Saving.findByPenalty", query = "SELECT s FROM Saving s WHERE s.penalty = :penalty"),
    @NamedQuery(name = "Saving.findByIsusepaymentperiode", query = "SELECT s FROM Saving s WHERE s.isusepaymentperiode = :isusepaymentperiode"),
    @NamedQuery(name = "Saving.findByPaymentperiodemethod", query = "SELECT s FROM Saving s WHERE s.paymentperiodemethod = :paymentperiodemethod"),
    @NamedQuery(name = "Saving.findByMinimumbalanceofinteresttax", query = "SELECT s FROM Saving s WHERE s.minimumbalanceofinteresttax = :minimumbalanceofinteresttax"),
    @NamedQuery(name = "Saving.findByCalculateperiod", query = "SELECT s FROM Saving s WHERE s.calculateperiod = :calculateperiod"),
    @NamedQuery(name = "Saving.findByCalculatebased", query = "SELECT s FROM Saving s WHERE s.calculatebased = :calculatebased"),
    @NamedQuery(name = "Saving.findByGraceperiodpenalty", query = "SELECT s FROM Saving s WHERE s.graceperiodpenalty = :graceperiodpenalty"),
    @NamedQuery(name = "Saving.findByDeposit", query = "SELECT s FROM Saving s WHERE s.deposit = :deposit"),
    @NamedQuery(name = "Saving.findByBranchtransfer", query = "SELECT s FROM Saving s WHERE s.branchtransfer = :branchtransfer"),
    @NamedQuery(name = "Saving.findByWithdrawl", query = "SELECT s FROM Saving s WHERE s.withdrawl = :withdrawl"),
    @NamedQuery(name = "Saving.findByBaddebincomeplus", query = "SELECT s FROM Saving s WHERE s.baddebincomeplus = :baddebincomeplus"),
    @NamedQuery(name = "Saving.findByWithdrawalpenaltyexceedthetimelimitvalue", query = "SELECT s FROM Saving s WHERE s.withdrawalpenaltyexceedthetimelimitvalue = :withdrawalpenaltyexceedthetimelimitvalue"),
    @NamedQuery(name = "Saving.findByFormatingmaxid", query = "SELECT s FROM Saving s WHERE s.formatingmaxid = :formatingmaxid"),
    @NamedQuery(name = "Saving.findByIsuseaccumulated", query = "SELECT s FROM Saving s WHERE s.isuseaccumulated = :isuseaccumulated"),
    @NamedQuery(name = "Saving.findByChooseaccumulated", query = "SELECT s FROM Saving s WHERE s.chooseaccumulated = :chooseaccumulated"),
    @NamedQuery(name = "Saving.findBySessiondate", query = "SELECT s FROM Saving s WHERE s.sessiondate = :sessiondate"),
    @NamedQuery(name = "Saving.findByProductexpireddate", query = "SELECT s FROM Saving s WHERE s.productexpireddate = :productexpireddate"),
    @NamedQuery(name = "Saving.findByMinimumpaymentperiodvalue", query = "SELECT s FROM Saving s WHERE s.minimumpaymentperiodvalue = :minimumpaymentperiodvalue"),
    @NamedQuery(name = "Saving.findByMaximumpaymentperiodvalue", query = "SELECT s FROM Saving s WHERE s.maximumpaymentperiodvalue = :maximumpaymentperiodvalue"),
    @NamedQuery(name = "Saving.findByMinimumdeposit", query = "SELECT s FROM Saving s WHERE s.minimumdeposit = :minimumdeposit"),
    @NamedQuery(name = "Saving.findByMaximumdeposit", query = "SELECT s FROM Saving s WHERE s.maximumdeposit = :maximumdeposit")})
public class Saving implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer savingid;
    @Size(max = 20)
    @Column(length = 20)
    private String savingtype;
    @Size(max = 5)
    @Column(length = 5)
    private String savingcode;
    @Size(max = 50)
    @Column(length = 50)
    private String savingname;
    @Size(max = 10)
    @Column(length = 10)
    private String savingstatus;
    @Size(max = 100)
    @Column(length = 100)
    private String description;
    private Boolean standingorderssupported;
    private Boolean linkingbetweenaccounttype;
    private Boolean payrollsupport;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double interesttax;
    private Integer paymentperiodevalue;
    private Integer graceperiode;
    private Integer minimumage;
    private Integer maximumage;
    @Column(precision = 17, scale = 17)
    private Double initialminimumdeposit;
    @Column(precision = 17, scale = 17)
    private Double initialmaximumdeposit;
    @Column(precision = 17, scale = 17)
    private Double minimumbalanceheld;
    @Column(precision = 17, scale = 17)
    private Double minimumbalancetoearninterest;
    @Column(precision = 17, scale = 17)
    private Double requireddeposit;
    @Column(precision = 17, scale = 17)
    private Double overdraftlimit;
    @Column(precision = 17, scale = 17)
    private Double excesswithdrawal;
    private Boolean atmenable;
    @Column(precision = 17, scale = 17)
    private Double dailylimit;
    private Integer numberoffreewithdrawalinamonth;
    @Size(max = 30)
    @Column(length = 30)
    private String calculationmethod;
    @Size(max = 10)
    @Column(length = 10)
    private String interestpaymentmethod;
    private Integer minimuminterestagelimit;
    private Integer maximuminterestagelimit;
    private Boolean allowdormancy;
    @Size(max = 10)
    @Column(length = 10)
    private String dormanafter;
    private Integer dormanaftervalue;
    @Column(precision = 17, scale = 17)
    private Double dormancyfee;
    @Size(max = 50)
    @Column(length = 50)
    private String transactiontype;
    @Column(precision = 17, scale = 17)
    private Double minimumbalance;
    private Integer termlimit;
    private Boolean nointerestifclosedbeforeminimumterm;
    private Integer rolloverperiode;
    @Size(max = 20)
    @Column(length = 20)
    private String earlyclosurepenaltytype;
    @Column(precision = 17, scale = 17)
    private Double earlyclosurepenaltyvalue;
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
    private Integer termofautomaticclosedpermanent;
    @Column(precision = 17, scale = 17)
    private Double penalty;
    private Boolean isusepaymentperiode;
    @Size(max = 10)
    @Column(length = 10)
    private String paymentperiodemethod;
    @Column(precision = 17, scale = 17)
    private Double minimumbalanceofinteresttax;
    private Boolean calculateperiod;
    private Boolean calculatebased;
    private Integer graceperiodpenalty;
    private Boolean deposit;
    private Boolean branchtransfer;
    private Boolean withdrawl;
    private Integer baddebincomeplus;
    @Column(precision = 17, scale = 17)
    private Double withdrawalpenaltyexceedthetimelimitvalue;
    private Integer formatingmaxid;
    private Boolean isuseaccumulated;
    private Integer chooseaccumulated;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @Temporal(TemporalType.DATE)
    private Date productexpireddate;
    @Column(precision = 17, scale = 17)
    private Double minimumpaymentperiodvalue;
    @Column(precision = 17, scale = 17)
    private Double maximumpaymentperiodvalue;
    @Column(precision = 17, scale = 17)
    private Double minimumdeposit;
    @Column(precision = 17, scale = 17)
    private Double maximumdeposit;
    @OneToMany(mappedBy = "savingid")
    private List<Account> accountList;
    @JoinColumn(name = "currencyid", referencedColumnName = "currencyid")
    @ManyToOne
    private Currency currencyid;
    @JoinColumn(name = "savinginterestdevidedtaxpayable", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount savinginterestdevidedtaxpayable;
    @JoinColumn(name = "savinginterestdevidedpayable", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount savinginterestdevidedpayable;
    @JoinColumn(name = "savinginterestdevidedexpense", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount savinginterestdevidedexpense;
    @JoinColumn(name = "productcontrolaccountnormal", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount productcontrolaccountnormal;
    @JoinColumn(name = "overdraftcontrolaccountnormal", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount overdraftcontrolaccountnormal;
    @JoinColumn(name = "baddebtincome", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount baddebtincome;
    @JoinColumn(name = "baddebtexpense", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount baddebtexpense;
    @JoinColumn(name = "savingstaxwithheld", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount savingstaxwithheld;

    public Saving() {
    }

    public Saving(Integer savingid) {
        this.savingid = savingid;
    }

    public Integer getSavingid() {
        return savingid;
    }

    public void setSavingid(Integer savingid) {
        this.savingid = savingid;
    }

    public String getSavingtype() {
        return savingtype;
    }

    public void setSavingtype(String savingtype) {
        this.savingtype = savingtype;
    }

    public String getSavingcode() {
        return savingcode;
    }

    public void setSavingcode(String savingcode) {
        this.savingcode = savingcode;
    }

    public String getSavingname() {
        return savingname;
    }

    public void setSavingname(String savingname) {
        this.savingname = savingname;
    }

    public String getSavingstatus() {
        return savingstatus;
    }

    public void setSavingstatus(String savingstatus) {
        this.savingstatus = savingstatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStandingorderssupported() {
        return standingorderssupported;
    }

    public void setStandingorderssupported(Boolean standingorderssupported) {
        this.standingorderssupported = standingorderssupported;
    }

    public Boolean getLinkingbetweenaccounttype() {
        return linkingbetweenaccounttype;
    }

    public void setLinkingbetweenaccounttype(Boolean linkingbetweenaccounttype) {
        this.linkingbetweenaccounttype = linkingbetweenaccounttype;
    }

    public Boolean getPayrollsupport() {
        return payrollsupport;
    }

    public void setPayrollsupport(Boolean payrollsupport) {
        this.payrollsupport = payrollsupport;
    }

    public Double getInteresttax() {
        return interesttax;
    }

    public void setInteresttax(Double interesttax) {
        this.interesttax = interesttax;
    }

    public Integer getPaymentperiodevalue() {
        return paymentperiodevalue;
    }

    public void setPaymentperiodevalue(Integer paymentperiodevalue) {
        this.paymentperiodevalue = paymentperiodevalue;
    }

    public Integer getGraceperiode() {
        return graceperiode;
    }

    public void setGraceperiode(Integer graceperiode) {
        this.graceperiode = graceperiode;
    }

    public Integer getMinimumage() {
        return minimumage;
    }

    public void setMinimumage(Integer minimumage) {
        this.minimumage = minimumage;
    }

    public Integer getMaximumage() {
        return maximumage;
    }

    public void setMaximumage(Integer maximumage) {
        this.maximumage = maximumage;
    }

    public Double getInitialminimumdeposit() {
        return initialminimumdeposit;
    }

    public void setInitialminimumdeposit(Double initialminimumdeposit) {
        this.initialminimumdeposit = initialminimumdeposit;
    }

    public Double getInitialmaximumdeposit() {
        return initialmaximumdeposit;
    }

    public void setInitialmaximumdeposit(Double initialmaximumdeposit) {
        this.initialmaximumdeposit = initialmaximumdeposit;
    }

    public Double getMinimumbalanceheld() {
        return minimumbalanceheld;
    }

    public void setMinimumbalanceheld(Double minimumbalanceheld) {
        this.minimumbalanceheld = minimumbalanceheld;
    }

    public Double getMinimumbalancetoearninterest() {
        return minimumbalancetoearninterest;
    }

    public void setMinimumbalancetoearninterest(Double minimumbalancetoearninterest) {
        this.minimumbalancetoearninterest = minimumbalancetoearninterest;
    }

    public Double getRequireddeposit() {
        return requireddeposit;
    }

    public void setRequireddeposit(Double requireddeposit) {
        this.requireddeposit = requireddeposit;
    }

    public Double getOverdraftlimit() {
        return overdraftlimit;
    }

    public void setOverdraftlimit(Double overdraftlimit) {
        this.overdraftlimit = overdraftlimit;
    }

    public Double getExcesswithdrawal() {
        return excesswithdrawal;
    }

    public void setExcesswithdrawal(Double excesswithdrawal) {
        this.excesswithdrawal = excesswithdrawal;
    }

    public Boolean getAtmenable() {
        return atmenable;
    }

    public void setAtmenable(Boolean atmenable) {
        this.atmenable = atmenable;
    }

    public Double getDailylimit() {
        return dailylimit;
    }

    public void setDailylimit(Double dailylimit) {
        this.dailylimit = dailylimit;
    }

    public Integer getNumberoffreewithdrawalinamonth() {
        return numberoffreewithdrawalinamonth;
    }

    public void setNumberoffreewithdrawalinamonth(Integer numberoffreewithdrawalinamonth) {
        this.numberoffreewithdrawalinamonth = numberoffreewithdrawalinamonth;
    }

    public String getCalculationmethod() {
        return calculationmethod;
    }

    public void setCalculationmethod(String calculationmethod) {
        this.calculationmethod = calculationmethod;
    }

    public String getInterestpaymentmethod() {
        return interestpaymentmethod;
    }

    public void setInterestpaymentmethod(String interestpaymentmethod) {
        this.interestpaymentmethod = interestpaymentmethod;
    }

    public Integer getMinimuminterestagelimit() {
        return minimuminterestagelimit;
    }

    public void setMinimuminterestagelimit(Integer minimuminterestagelimit) {
        this.minimuminterestagelimit = minimuminterestagelimit;
    }

    public Integer getMaximuminterestagelimit() {
        return maximuminterestagelimit;
    }

    public void setMaximuminterestagelimit(Integer maximuminterestagelimit) {
        this.maximuminterestagelimit = maximuminterestagelimit;
    }

    public Boolean getAllowdormancy() {
        return allowdormancy;
    }

    public void setAllowdormancy(Boolean allowdormancy) {
        this.allowdormancy = allowdormancy;
    }

    public String getDormanafter() {
        return dormanafter;
    }

    public void setDormanafter(String dormanafter) {
        this.dormanafter = dormanafter;
    }

    public Integer getDormanaftervalue() {
        return dormanaftervalue;
    }

    public void setDormanaftervalue(Integer dormanaftervalue) {
        this.dormanaftervalue = dormanaftervalue;
    }

    public Double getDormancyfee() {
        return dormancyfee;
    }

    public void setDormancyfee(Double dormancyfee) {
        this.dormancyfee = dormancyfee;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public Double getMinimumbalance() {
        return minimumbalance;
    }

    public void setMinimumbalance(Double minimumbalance) {
        this.minimumbalance = minimumbalance;
    }

    public Integer getTermlimit() {
        return termlimit;
    }

    public void setTermlimit(Integer termlimit) {
        this.termlimit = termlimit;
    }

    public Boolean getNointerestifclosedbeforeminimumterm() {
        return nointerestifclosedbeforeminimumterm;
    }

    public void setNointerestifclosedbeforeminimumterm(Boolean nointerestifclosedbeforeminimumterm) {
        this.nointerestifclosedbeforeminimumterm = nointerestifclosedbeforeminimumterm;
    }

    public Integer getRolloverperiode() {
        return rolloverperiode;
    }

    public void setRolloverperiode(Integer rolloverperiode) {
        this.rolloverperiode = rolloverperiode;
    }

    public String getEarlyclosurepenaltytype() {
        return earlyclosurepenaltytype;
    }

    public void setEarlyclosurepenaltytype(String earlyclosurepenaltytype) {
        this.earlyclosurepenaltytype = earlyclosurepenaltytype;
    }

    public Double getEarlyclosurepenaltyvalue() {
        return earlyclosurepenaltyvalue;
    }

    public void setEarlyclosurepenaltyvalue(Double earlyclosurepenaltyvalue) {
        this.earlyclosurepenaltyvalue = earlyclosurepenaltyvalue;
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

    public Integer getTermofautomaticclosedpermanent() {
        return termofautomaticclosedpermanent;
    }

    public void setTermofautomaticclosedpermanent(Integer termofautomaticclosedpermanent) {
        this.termofautomaticclosedpermanent = termofautomaticclosedpermanent;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public Boolean getIsusepaymentperiode() {
        return isusepaymentperiode;
    }

    public void setIsusepaymentperiode(Boolean isusepaymentperiode) {
        this.isusepaymentperiode = isusepaymentperiode;
    }

    public String getPaymentperiodemethod() {
        return paymentperiodemethod;
    }

    public void setPaymentperiodemethod(String paymentperiodemethod) {
        this.paymentperiodemethod = paymentperiodemethod;
    }

    public Double getMinimumbalanceofinteresttax() {
        return minimumbalanceofinteresttax;
    }

    public void setMinimumbalanceofinteresttax(Double minimumbalanceofinteresttax) {
        this.minimumbalanceofinteresttax = minimumbalanceofinteresttax;
    }

    public Boolean getCalculateperiod() {
        return calculateperiod;
    }

    public void setCalculateperiod(Boolean calculateperiod) {
        this.calculateperiod = calculateperiod;
    }

    public Boolean getCalculatebased() {
        return calculatebased;
    }

    public void setCalculatebased(Boolean calculatebased) {
        this.calculatebased = calculatebased;
    }

    public Integer getGraceperiodpenalty() {
        return graceperiodpenalty;
    }

    public void setGraceperiodpenalty(Integer graceperiodpenalty) {
        this.graceperiodpenalty = graceperiodpenalty;
    }

    public Boolean getDeposit() {
        return deposit;
    }

    public void setDeposit(Boolean deposit) {
        this.deposit = deposit;
    }

    public Boolean getBranchtransfer() {
        return branchtransfer;
    }

    public void setBranchtransfer(Boolean branchtransfer) {
        this.branchtransfer = branchtransfer;
    }

    public Boolean getWithdrawl() {
        return withdrawl;
    }

    public void setWithdrawl(Boolean withdrawl) {
        this.withdrawl = withdrawl;
    }

    public Integer getBaddebincomeplus() {
        return baddebincomeplus;
    }

    public void setBaddebincomeplus(Integer baddebincomeplus) {
        this.baddebincomeplus = baddebincomeplus;
    }

    public Double getWithdrawalpenaltyexceedthetimelimitvalue() {
        return withdrawalpenaltyexceedthetimelimitvalue;
    }

    public void setWithdrawalpenaltyexceedthetimelimitvalue(Double withdrawalpenaltyexceedthetimelimitvalue) {
        this.withdrawalpenaltyexceedthetimelimitvalue = withdrawalpenaltyexceedthetimelimitvalue;
    }

    public Integer getFormatingmaxid() {
        return formatingmaxid;
    }

    public void setFormatingmaxid(Integer formatingmaxid) {
        this.formatingmaxid = formatingmaxid;
    }

    public Boolean getIsuseaccumulated() {
        return isuseaccumulated;
    }

    public void setIsuseaccumulated(Boolean isuseaccumulated) {
        this.isuseaccumulated = isuseaccumulated;
    }

    public Integer getChooseaccumulated() {
        return chooseaccumulated;
    }

    public void setChooseaccumulated(Integer chooseaccumulated) {
        this.chooseaccumulated = chooseaccumulated;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Date getProductexpireddate() {
        return productexpireddate;
    }

    public void setProductexpireddate(Date productexpireddate) {
        this.productexpireddate = productexpireddate;
    }

    public Double getMinimumpaymentperiodvalue() {
        return minimumpaymentperiodvalue;
    }

    public void setMinimumpaymentperiodvalue(Double minimumpaymentperiodvalue) {
        this.minimumpaymentperiodvalue = minimumpaymentperiodvalue;
    }

    public Double getMaximumpaymentperiodvalue() {
        return maximumpaymentperiodvalue;
    }

    public void setMaximumpaymentperiodvalue(Double maximumpaymentperiodvalue) {
        this.maximumpaymentperiodvalue = maximumpaymentperiodvalue;
    }

    public Double getMinimumdeposit() {
        return minimumdeposit;
    }

    public void setMinimumdeposit(Double minimumdeposit) {
        this.minimumdeposit = minimumdeposit;
    }

    public Double getMaximumdeposit() {
        return maximumdeposit;
    }

    public void setMaximumdeposit(Double maximumdeposit) {
        this.maximumdeposit = maximumdeposit;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Currency getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(Currency currencyid) {
        this.currencyid = currencyid;
    }

    public Chartofaccount getSavinginterestdevidedtaxpayable() {
        return savinginterestdevidedtaxpayable;
    }

    public void setSavinginterestdevidedtaxpayable(Chartofaccount savinginterestdevidedtaxpayable) {
        this.savinginterestdevidedtaxpayable = savinginterestdevidedtaxpayable;
    }

    public Chartofaccount getSavinginterestdevidedpayable() {
        return savinginterestdevidedpayable;
    }

    public void setSavinginterestdevidedpayable(Chartofaccount savinginterestdevidedpayable) {
        this.savinginterestdevidedpayable = savinginterestdevidedpayable;
    }

    public Chartofaccount getSavinginterestdevidedexpense() {
        return savinginterestdevidedexpense;
    }

    public void setSavinginterestdevidedexpense(Chartofaccount savinginterestdevidedexpense) {
        this.savinginterestdevidedexpense = savinginterestdevidedexpense;
    }

    public Chartofaccount getProductcontrolaccountnormal() {
        return productcontrolaccountnormal;
    }

    public void setProductcontrolaccountnormal(Chartofaccount productcontrolaccountnormal) {
        this.productcontrolaccountnormal = productcontrolaccountnormal;
    }

    public Chartofaccount getOverdraftcontrolaccountnormal() {
        return overdraftcontrolaccountnormal;
    }

    public void setOverdraftcontrolaccountnormal(Chartofaccount overdraftcontrolaccountnormal) {
        this.overdraftcontrolaccountnormal = overdraftcontrolaccountnormal;
    }

    public Chartofaccount getBaddebtincome() {
        return baddebtincome;
    }

    public void setBaddebtincome(Chartofaccount baddebtincome) {
        this.baddebtincome = baddebtincome;
    }

    public Chartofaccount getBaddebtexpense() {
        return baddebtexpense;
    }

    public void setBaddebtexpense(Chartofaccount baddebtexpense) {
        this.baddebtexpense = baddebtexpense;
    }

    public Chartofaccount getSavingstaxwithheld() {
        return savingstaxwithheld;
    }

    public void setSavingstaxwithheld(Chartofaccount savingstaxwithheld) {
        this.savingstaxwithheld = savingstaxwithheld;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (savingid != null ? savingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saving)) {
            return false;
        }
        Saving other = (Saving) object;
        if ((this.savingid == null && other.savingid != null) || (this.savingid != null && !this.savingid.equals(other.savingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Saving[ savingid=" + savingid + " ]";
    }

}
