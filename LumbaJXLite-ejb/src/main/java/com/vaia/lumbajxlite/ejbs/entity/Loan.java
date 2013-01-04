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
    @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l"),
    @NamedQuery(name = "Loan.findByLoanid", query = "SELECT l FROM Loan l WHERE l.loanid = :loanid"),
    @NamedQuery(name = "Loan.findByLoancode", query = "SELECT l FROM Loan l WHERE l.loancode = :loancode"),
    @NamedQuery(name = "Loan.findByLoanname", query = "SELECT l FROM Loan l WHERE l.loanname = :loanname"),
    @NamedQuery(name = "Loan.findByLoanstatus", query = "SELECT l FROM Loan l WHERE l.loanstatus = :loanstatus"),
    @NamedQuery(name = "Loan.findByDescription", query = "SELECT l FROM Loan l WHERE l.description = :description"),
    @NamedQuery(name = "Loan.findByMaximumnumberloan", query = "SELECT l FROM Loan l WHERE l.maximumnumberloan = :maximumnumberloan"),
    @NamedQuery(name = "Loan.findByLineofcredit", query = "SELECT l FROM Loan l WHERE l.lineofcredit = :lineofcredit"),
    @NamedQuery(name = "Loan.findByCloselineofcreditautomatically", query = "SELECT l FROM Loan l WHERE l.closelineofcreditautomatically = :closelineofcreditautomatically"),
    @NamedQuery(name = "Loan.findByAllowloantopups", query = "SELECT l FROM Loan l WHERE l.allowloantopups = :allowloantopups"),
    @NamedQuery(name = "Loan.findByAllowmultiplepartloans", query = "SELECT l FROM Loan l WHERE l.allowmultiplepartloans = :allowmultiplepartloans"),
    @NamedQuery(name = "Loan.findByAllowloanredraws", query = "SELECT l FROM Loan l WHERE l.allowloanredraws = :allowloanredraws"),
    @NamedQuery(name = "Loan.findByDefaulttolevelrepayment", query = "SELECT l FROM Loan l WHERE l.defaulttolevelrepayment = :defaulttolevelrepayment"),
    @NamedQuery(name = "Loan.findByAllowdeferredpayment", query = "SELECT l FROM Loan l WHERE l.allowdeferredpayment = :allowdeferredpayment"),
    @NamedQuery(name = "Loan.findByAllowballoonpayment", query = "SELECT l FROM Loan l WHERE l.allowballoonpayment = :allowballoonpayment"),
    @NamedQuery(name = "Loan.findByPaybysingleballoonpayment", query = "SELECT l FROM Loan l WHERE l.paybysingleballoonpayment = :paybysingleballoonpayment"),
    @NamedQuery(name = "Loan.findByAllowtransferfromsaving", query = "SELECT l FROM Loan l WHERE l.allowtransferfromsaving = :allowtransferfromsaving"),
    @NamedQuery(name = "Loan.findByDefaulttosingleschedulepayment", query = "SELECT l FROM Loan l WHERE l.defaulttosingleschedulepayment = :defaulttosingleschedulepayment"),
    @NamedQuery(name = "Loan.findByIsinsurancerequired", query = "SELECT l FROM Loan l WHERE l.isinsurancerequired = :isinsurancerequired"),
    @NamedQuery(name = "Loan.findByUsecollateral", query = "SELECT l FROM Loan l WHERE l.usecollateral = :usecollateral"),
    @NamedQuery(name = "Loan.findByFirstpaymentlimit", query = "SELECT l FROM Loan l WHERE l.firstpaymentlimit = :firstpaymentlimit"),
    @NamedQuery(name = "Loan.findByDefaultloanterm", query = "SELECT l FROM Loan l WHERE l.defaultloanterm = :defaultloanterm"),
    @NamedQuery(name = "Loan.findByMinimumloantermlimit", query = "SELECT l FROM Loan l WHERE l.minimumloantermlimit = :minimumloantermlimit"),
    @NamedQuery(name = "Loan.findByMaximumloantermlimit", query = "SELECT l FROM Loan l WHERE l.maximumloantermlimit = :maximumloantermlimit"),
    @NamedQuery(name = "Loan.findByMinimumbalancelimit", query = "SELECT l FROM Loan l WHERE l.minimumbalancelimit = :minimumbalancelimit"),
    @NamedQuery(name = "Loan.findByMaximumbalancelimit", query = "SELECT l FROM Loan l WHERE l.maximumbalancelimit = :maximumbalancelimit"),
    @NamedQuery(name = "Loan.findByMinimumplafonlimit", query = "SELECT l FROM Loan l WHERE l.minimumplafonlimit = :minimumplafonlimit"),
    @NamedQuery(name = "Loan.findByMaximumplafonlimit", query = "SELECT l FROM Loan l WHERE l.maximumplafonlimit = :maximumplafonlimit"),
    @NamedQuery(name = "Loan.findByMinimumage", query = "SELECT l FROM Loan l WHERE l.minimumage = :minimumage"),
    @NamedQuery(name = "Loan.findByMaximumage", query = "SELECT l FROM Loan l WHERE l.maximumage = :maximumage"),
    @NamedQuery(name = "Loan.findByMinimumcollateral", query = "SELECT l FROM Loan l WHERE l.minimumcollateral = :minimumcollateral"),
    @NamedQuery(name = "Loan.findByCapitalizationsavingvalue", query = "SELECT l FROM Loan l WHERE l.capitalizationsavingvalue = :capitalizationsavingvalue"),
    @NamedQuery(name = "Loan.findByMinimumgroupsize", query = "SELECT l FROM Loan l WHERE l.minimumgroupsize = :minimumgroupsize"),
    @NamedQuery(name = "Loan.findByMinimumcyclegroup", query = "SELECT l FROM Loan l WHERE l.minimumcyclegroup = :minimumcyclegroup"),
    @NamedQuery(name = "Loan.findByMaximumcyclegroup", query = "SELECT l FROM Loan l WHERE l.maximumcyclegroup = :maximumcyclegroup"),
    @NamedQuery(name = "Loan.findByUseloanapprovalgrouplimit", query = "SELECT l FROM Loan l WHERE l.useloanapprovalgrouplimit = :useloanapprovalgrouplimit"),
    @NamedQuery(name = "Loan.findByInterestmethod", query = "SELECT l FROM Loan l WHERE l.interestmethod = :interestmethod"),
    @NamedQuery(name = "Loan.findByPenaltyinterestratetype", query = "SELECT l FROM Loan l WHERE l.penaltyinterestratetype = :penaltyinterestratetype"),
    @NamedQuery(name = "Loan.findByPenaltyinterestratevalue", query = "SELECT l FROM Loan l WHERE l.penaltyinterestratevalue = :penaltyinterestratevalue"),
    @NamedQuery(name = "Loan.findByPenaltydays", query = "SELECT l FROM Loan l WHERE l.penaltydays = :penaltydays"),
    @NamedQuery(name = "Loan.findByUsescheduleinterest", query = "SELECT l FROM Loan l WHERE l.usescheduleinterest = :usescheduleinterest"),
    @NamedQuery(name = "Loan.findByCreationdate", query = "SELECT l FROM Loan l WHERE l.creationdate = :creationdate"),
    @NamedQuery(name = "Loan.findByCreator", query = "SELECT l FROM Loan l WHERE l.creator = :creator"),
    @NamedQuery(name = "Loan.findByEditdate", query = "SELECT l FROM Loan l WHERE l.editdate = :editdate"),
    @NamedQuery(name = "Loan.findByEditor", query = "SELECT l FROM Loan l WHERE l.editor = :editor"),
    @NamedQuery(name = "Loan.findByLoantype", query = "SELECT l FROM Loan l WHERE l.loantype = :loantype"),
    @NamedQuery(name = "Loan.findByFacility", query = "SELECT l FROM Loan l WHERE l.facility = :facility"),
    @NamedQuery(name = "Loan.findByUsecapitalization", query = "SELECT l FROM Loan l WHERE l.usecapitalization = :usecapitalization"),
    @NamedQuery(name = "Loan.findByCapitalizationvaluetype", query = "SELECT l FROM Loan l WHERE l.capitalizationvaluetype = :capitalizationvaluetype"),
    @NamedQuery(name = "Loan.findBySpecificprovisionexpenserestructured", query = "SELECT l FROM Loan l WHERE l.specificprovisionexpenserestructured = :specificprovisionexpenserestructured"),
    @NamedQuery(name = "Loan.findBySpecificprovisionexpense", query = "SELECT l FROM Loan l WHERE l.specificprovisionexpense = :specificprovisionexpense"),
    @NamedQuery(name = "Loan.findBySpecificprovisionrestructured", query = "SELECT l FROM Loan l WHERE l.specificprovisionrestructured = :specificprovisionrestructured"),
    @NamedQuery(name = "Loan.findBySpecificprovision", query = "SELECT l FROM Loan l WHERE l.specificprovision = :specificprovision"),
    @NamedQuery(name = "Loan.findByLoanfundsourceaccount", query = "SELECT l FROM Loan l WHERE l.loanfundsourceaccount = :loanfundsourceaccount"),
    @NamedQuery(name = "Loan.findByInterestrebatepayableaccount", query = "SELECT l FROM Loan l WHERE l.interestrebatepayableaccount = :interestrebatepayableaccount"),
    @NamedQuery(name = "Loan.findByGeneralprovisionexpenserestructured", query = "SELECT l FROM Loan l WHERE l.generalprovisionexpenserestructured = :generalprovisionexpenserestructured"),
    @NamedQuery(name = "Loan.findByGeneralprovisionexpense", query = "SELECT l FROM Loan l WHERE l.generalprovisionexpense = :generalprovisionexpense"),
    @NamedQuery(name = "Loan.findByGeneralprovisionrestructured", query = "SELECT l FROM Loan l WHERE l.generalprovisionrestructured = :generalprovisionrestructured"),
    @NamedQuery(name = "Loan.findByGeneralprovision", query = "SELECT l FROM Loan l WHERE l.generalprovision = :generalprovision"),
    @NamedQuery(name = "Loan.findByCreditbalanceloancontrolaccount", query = "SELECT l FROM Loan l WHERE l.creditbalanceloancontrolaccount = :creditbalanceloancontrolaccount"),
    @NamedQuery(name = "Loan.findByComplimentaryinterestincomeaccount", query = "SELECT l FROM Loan l WHERE l.complimentaryinterestincomeaccount = :complimentaryinterestincomeaccount"),
    @NamedQuery(name = "Loan.findByBaddebtincome", query = "SELECT l FROM Loan l WHERE l.baddebtincome = :baddebtincome"),
    @NamedQuery(name = "Loan.findByBaddebtexpense", query = "SELECT l FROM Loan l WHERE l.baddebtexpense = :baddebtexpense"),
    @NamedQuery(name = "Loan.findByFormatingmaxid", query = "SELECT l FROM Loan l WHERE l.formatingmaxid = :formatingmaxid"),
    @NamedQuery(name = "Loan.findBySettlementdiscountmethod", query = "SELECT l FROM Loan l WHERE l.settlementdiscountmethod = :settlementdiscountmethod"),
    @NamedQuery(name = "Loan.findByWriteoff", query = "SELECT l FROM Loan l WHERE l.writeoff = :writeoff"),
    @NamedQuery(name = "Loan.findByLoaninsurance", query = "SELECT l FROM Loan l WHERE l.loaninsurance = :loaninsurance"),
    @NamedQuery(name = "Loan.findByAccruedprincipal", query = "SELECT l FROM Loan l WHERE l.accruedprincipal = :accruedprincipal"),
    @NamedQuery(name = "Loan.findByDownpayment", query = "SELECT l FROM Loan l WHERE l.downpayment = :downpayment"),
    @NamedQuery(name = "Loan.findBySessiondate", query = "SELECT l FROM Loan l WHERE l.sessiondate = :sessiondate"),
    @NamedQuery(name = "Loan.findByUsedfor", query = "SELECT l FROM Loan l WHERE l.usedfor = :usedfor"),
    @NamedQuery(name = "Loan.findByPartialdeposit", query = "SELECT l FROM Loan l WHERE l.partialdeposit = :partialdeposit"),
    @NamedQuery(name = "Loan.findByPenaltycalculation", query = "SELECT l FROM Loan l WHERE l.penaltycalculation = :penaltycalculation")})
public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer loanid;
    @Size(max = 5)
    @Column(length = 5)
    private String loancode;
    @Size(max = 50)
    @Column(length = 50)
    private String loanname;
    @Size(max = 10)
    @Column(length = 10)
    private String loanstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String description;
    private Integer maximumnumberloan;
    private Boolean lineofcredit;
    private Boolean closelineofcreditautomatically;
    private Boolean allowloantopups;
    private Boolean allowmultiplepartloans;
    private Boolean allowloanredraws;
    private Boolean defaulttolevelrepayment;
    private Boolean allowdeferredpayment;
    private Boolean allowballoonpayment;
    private Boolean paybysingleballoonpayment;
    private Boolean allowtransferfromsaving;
    private Boolean defaulttosingleschedulepayment;
    private Boolean isinsurancerequired;
    private Boolean usecollateral;
    private Integer firstpaymentlimit;
    @Size(max = 10)
    @Column(length = 10)
    private String defaultloanterm;
    private Integer minimumloantermlimit;
    private Integer maximumloantermlimit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double minimumbalancelimit;
    @Column(precision = 17, scale = 17)
    private Double maximumbalancelimit;
    @Column(precision = 17, scale = 17)
    private Double minimumplafonlimit;
    @Column(precision = 17, scale = 17)
    private Double maximumplafonlimit;
    private Integer minimumage;
    private Integer maximumage;
    @Column(precision = 17, scale = 17)
    private Double minimumcollateral;
    @Column(precision = 17, scale = 17)
    private Double capitalizationsavingvalue;
    private Integer minimumgroupsize;
    @Column(precision = 17, scale = 17)
    private Double minimumcyclegroup;
    @Column(precision = 17, scale = 17)
    private Double maximumcyclegroup;
    private Boolean useloanapprovalgrouplimit;
    @Size(max = 10)
    @Column(length = 10)
    private String interestmethod;
    @Size(max = 20)
    @Column(length = 20)
    private String penaltyinterestratetype;
    @Column(precision = 17, scale = 17)
    private Double penaltyinterestratevalue;
    private Integer penaltydays;
    private Boolean usescheduleinterest;
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
    @Size(max = 20)
    @Column(length = 20)
    private String loantype;
    private Boolean facility;
    private Boolean usecapitalization;
    @Size(max = 10)
    @Column(length = 10)
    private String capitalizationvaluetype;
    private Integer specificprovisionexpenserestructured;
    private Integer specificprovisionexpense;
    private Integer specificprovisionrestructured;
    private Integer specificprovision;
    private Integer loanfundsourceaccount;
    private Integer interestrebatepayableaccount;
    private Integer generalprovisionexpenserestructured;
    private Integer generalprovisionexpense;
    private Integer generalprovisionrestructured;
    private Integer generalprovision;
    private Integer creditbalanceloancontrolaccount;
    private Integer complimentaryinterestincomeaccount;
    private Integer baddebtincome;
    private Integer baddebtexpense;
    private Integer formatingmaxid;
    private Integer settlementdiscountmethod;
    private Integer writeoff;
    private Integer loaninsurance;
    private Integer accruedprincipal;
    private Integer downpayment;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    private Boolean usedfor;
    private Integer partialdeposit;
    @Size(max = 30)
    @Column(length = 30)
    private String penaltycalculation;
    @JoinColumn(name = "loancategory", referencedColumnName = "loancategoryid")
    @ManyToOne
    private Loancategory loancategory;
    @JoinColumn(name = "loanapprovalid", referencedColumnName = "loanapprovalid")
    @ManyToOne
    private Loanapproval loanapprovalid;
    @JoinColumn(name = "currencyid", referencedColumnName = "currencyid")
    @ManyToOne
    private Currency currencyid;
    @OneToMany(mappedBy = "loanid")
    private List<Account> accountList;

    public Loan() {
    }

    public Loan(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public String getLoancode() {
        return loancode;
    }

    public void setLoancode(String loancode) {
        this.loancode = loancode;
    }

    public String getLoanname() {
        return loanname;
    }

    public void setLoanname(String loanname) {
        this.loanname = loanname;
    }

    public String getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(String loanstatus) {
        this.loanstatus = loanstatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaximumnumberloan() {
        return maximumnumberloan;
    }

    public void setMaximumnumberloan(Integer maximumnumberloan) {
        this.maximumnumberloan = maximumnumberloan;
    }

    public Boolean getLineofcredit() {
        return lineofcredit;
    }

    public void setLineofcredit(Boolean lineofcredit) {
        this.lineofcredit = lineofcredit;
    }

    public Boolean getCloselineofcreditautomatically() {
        return closelineofcreditautomatically;
    }

    public void setCloselineofcreditautomatically(Boolean closelineofcreditautomatically) {
        this.closelineofcreditautomatically = closelineofcreditautomatically;
    }

    public Boolean getAllowloantopups() {
        return allowloantopups;
    }

    public void setAllowloantopups(Boolean allowloantopups) {
        this.allowloantopups = allowloantopups;
    }

    public Boolean getAllowmultiplepartloans() {
        return allowmultiplepartloans;
    }

    public void setAllowmultiplepartloans(Boolean allowmultiplepartloans) {
        this.allowmultiplepartloans = allowmultiplepartloans;
    }

    public Boolean getAllowloanredraws() {
        return allowloanredraws;
    }

    public void setAllowloanredraws(Boolean allowloanredraws) {
        this.allowloanredraws = allowloanredraws;
    }

    public Boolean getDefaulttolevelrepayment() {
        return defaulttolevelrepayment;
    }

    public void setDefaulttolevelrepayment(Boolean defaulttolevelrepayment) {
        this.defaulttolevelrepayment = defaulttolevelrepayment;
    }

    public Boolean getAllowdeferredpayment() {
        return allowdeferredpayment;
    }

    public void setAllowdeferredpayment(Boolean allowdeferredpayment) {
        this.allowdeferredpayment = allowdeferredpayment;
    }

    public Boolean getAllowballoonpayment() {
        return allowballoonpayment;
    }

    public void setAllowballoonpayment(Boolean allowballoonpayment) {
        this.allowballoonpayment = allowballoonpayment;
    }

    public Boolean getPaybysingleballoonpayment() {
        return paybysingleballoonpayment;
    }

    public void setPaybysingleballoonpayment(Boolean paybysingleballoonpayment) {
        this.paybysingleballoonpayment = paybysingleballoonpayment;
    }

    public Boolean getAllowtransferfromsaving() {
        return allowtransferfromsaving;
    }

    public void setAllowtransferfromsaving(Boolean allowtransferfromsaving) {
        this.allowtransferfromsaving = allowtransferfromsaving;
    }

    public Boolean getDefaulttosingleschedulepayment() {
        return defaulttosingleschedulepayment;
    }

    public void setDefaulttosingleschedulepayment(Boolean defaulttosingleschedulepayment) {
        this.defaulttosingleschedulepayment = defaulttosingleschedulepayment;
    }

    public Boolean getIsinsurancerequired() {
        return isinsurancerequired;
    }

    public void setIsinsurancerequired(Boolean isinsurancerequired) {
        this.isinsurancerequired = isinsurancerequired;
    }

    public Boolean getUsecollateral() {
        return usecollateral;
    }

    public void setUsecollateral(Boolean usecollateral) {
        this.usecollateral = usecollateral;
    }

    public Integer getFirstpaymentlimit() {
        return firstpaymentlimit;
    }

    public void setFirstpaymentlimit(Integer firstpaymentlimit) {
        this.firstpaymentlimit = firstpaymentlimit;
    }

    public String getDefaultloanterm() {
        return defaultloanterm;
    }

    public void setDefaultloanterm(String defaultloanterm) {
        this.defaultloanterm = defaultloanterm;
    }

    public Integer getMinimumloantermlimit() {
        return minimumloantermlimit;
    }

    public void setMinimumloantermlimit(Integer minimumloantermlimit) {
        this.minimumloantermlimit = minimumloantermlimit;
    }

    public Integer getMaximumloantermlimit() {
        return maximumloantermlimit;
    }

    public void setMaximumloantermlimit(Integer maximumloantermlimit) {
        this.maximumloantermlimit = maximumloantermlimit;
    }

    public Double getMinimumbalancelimit() {
        return minimumbalancelimit;
    }

    public void setMinimumbalancelimit(Double minimumbalancelimit) {
        this.minimumbalancelimit = minimumbalancelimit;
    }

    public Double getMaximumbalancelimit() {
        return maximumbalancelimit;
    }

    public void setMaximumbalancelimit(Double maximumbalancelimit) {
        this.maximumbalancelimit = maximumbalancelimit;
    }

    public Double getMinimumplafonlimit() {
        return minimumplafonlimit;
    }

    public void setMinimumplafonlimit(Double minimumplafonlimit) {
        this.minimumplafonlimit = minimumplafonlimit;
    }

    public Double getMaximumplafonlimit() {
        return maximumplafonlimit;
    }

    public void setMaximumplafonlimit(Double maximumplafonlimit) {
        this.maximumplafonlimit = maximumplafonlimit;
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

    public Double getMinimumcollateral() {
        return minimumcollateral;
    }

    public void setMinimumcollateral(Double minimumcollateral) {
        this.minimumcollateral = minimumcollateral;
    }

    public Double getCapitalizationsavingvalue() {
        return capitalizationsavingvalue;
    }

    public void setCapitalizationsavingvalue(Double capitalizationsavingvalue) {
        this.capitalizationsavingvalue = capitalizationsavingvalue;
    }

    public Integer getMinimumgroupsize() {
        return minimumgroupsize;
    }

    public void setMinimumgroupsize(Integer minimumgroupsize) {
        this.minimumgroupsize = minimumgroupsize;
    }

    public Double getMinimumcyclegroup() {
        return minimumcyclegroup;
    }

    public void setMinimumcyclegroup(Double minimumcyclegroup) {
        this.minimumcyclegroup = minimumcyclegroup;
    }

    public Double getMaximumcyclegroup() {
        return maximumcyclegroup;
    }

    public void setMaximumcyclegroup(Double maximumcyclegroup) {
        this.maximumcyclegroup = maximumcyclegroup;
    }

    public Boolean getUseloanapprovalgrouplimit() {
        return useloanapprovalgrouplimit;
    }

    public void setUseloanapprovalgrouplimit(Boolean useloanapprovalgrouplimit) {
        this.useloanapprovalgrouplimit = useloanapprovalgrouplimit;
    }

    public String getInterestmethod() {
        return interestmethod;
    }

    public void setInterestmethod(String interestmethod) {
        this.interestmethod = interestmethod;
    }

    public String getPenaltyinterestratetype() {
        return penaltyinterestratetype;
    }

    public void setPenaltyinterestratetype(String penaltyinterestratetype) {
        this.penaltyinterestratetype = penaltyinterestratetype;
    }

    public Double getPenaltyinterestratevalue() {
        return penaltyinterestratevalue;
    }

    public void setPenaltyinterestratevalue(Double penaltyinterestratevalue) {
        this.penaltyinterestratevalue = penaltyinterestratevalue;
    }

    public Integer getPenaltydays() {
        return penaltydays;
    }

    public void setPenaltydays(Integer penaltydays) {
        this.penaltydays = penaltydays;
    }

    public Boolean getUsescheduleinterest() {
        return usescheduleinterest;
    }

    public void setUsescheduleinterest(Boolean usescheduleinterest) {
        this.usescheduleinterest = usescheduleinterest;
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

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public Boolean getFacility() {
        return facility;
    }

    public void setFacility(Boolean facility) {
        this.facility = facility;
    }

    public Boolean getUsecapitalization() {
        return usecapitalization;
    }

    public void setUsecapitalization(Boolean usecapitalization) {
        this.usecapitalization = usecapitalization;
    }

    public String getCapitalizationvaluetype() {
        return capitalizationvaluetype;
    }

    public void setCapitalizationvaluetype(String capitalizationvaluetype) {
        this.capitalizationvaluetype = capitalizationvaluetype;
    }

    public Integer getSpecificprovisionexpenserestructured() {
        return specificprovisionexpenserestructured;
    }

    public void setSpecificprovisionexpenserestructured(Integer specificprovisionexpenserestructured) {
        this.specificprovisionexpenserestructured = specificprovisionexpenserestructured;
    }

    public Integer getSpecificprovisionexpense() {
        return specificprovisionexpense;
    }

    public void setSpecificprovisionexpense(Integer specificprovisionexpense) {
        this.specificprovisionexpense = specificprovisionexpense;
    }

    public Integer getSpecificprovisionrestructured() {
        return specificprovisionrestructured;
    }

    public void setSpecificprovisionrestructured(Integer specificprovisionrestructured) {
        this.specificprovisionrestructured = specificprovisionrestructured;
    }

    public Integer getSpecificprovision() {
        return specificprovision;
    }

    public void setSpecificprovision(Integer specificprovision) {
        this.specificprovision = specificprovision;
    }

    public Integer getLoanfundsourceaccount() {
        return loanfundsourceaccount;
    }

    public void setLoanfundsourceaccount(Integer loanfundsourceaccount) {
        this.loanfundsourceaccount = loanfundsourceaccount;
    }

    public Integer getInterestrebatepayableaccount() {
        return interestrebatepayableaccount;
    }

    public void setInterestrebatepayableaccount(Integer interestrebatepayableaccount) {
        this.interestrebatepayableaccount = interestrebatepayableaccount;
    }

    public Integer getGeneralprovisionexpenserestructured() {
        return generalprovisionexpenserestructured;
    }

    public void setGeneralprovisionexpenserestructured(Integer generalprovisionexpenserestructured) {
        this.generalprovisionexpenserestructured = generalprovisionexpenserestructured;
    }

    public Integer getGeneralprovisionexpense() {
        return generalprovisionexpense;
    }

    public void setGeneralprovisionexpense(Integer generalprovisionexpense) {
        this.generalprovisionexpense = generalprovisionexpense;
    }

    public Integer getGeneralprovisionrestructured() {
        return generalprovisionrestructured;
    }

    public void setGeneralprovisionrestructured(Integer generalprovisionrestructured) {
        this.generalprovisionrestructured = generalprovisionrestructured;
    }

    public Integer getGeneralprovision() {
        return generalprovision;
    }

    public void setGeneralprovision(Integer generalprovision) {
        this.generalprovision = generalprovision;
    }

    public Integer getCreditbalanceloancontrolaccount() {
        return creditbalanceloancontrolaccount;
    }

    public void setCreditbalanceloancontrolaccount(Integer creditbalanceloancontrolaccount) {
        this.creditbalanceloancontrolaccount = creditbalanceloancontrolaccount;
    }

    public Integer getComplimentaryinterestincomeaccount() {
        return complimentaryinterestincomeaccount;
    }

    public void setComplimentaryinterestincomeaccount(Integer complimentaryinterestincomeaccount) {
        this.complimentaryinterestincomeaccount = complimentaryinterestincomeaccount;
    }

    public Integer getBaddebtincome() {
        return baddebtincome;
    }

    public void setBaddebtincome(Integer baddebtincome) {
        this.baddebtincome = baddebtincome;
    }

    public Integer getBaddebtexpense() {
        return baddebtexpense;
    }

    public void setBaddebtexpense(Integer baddebtexpense) {
        this.baddebtexpense = baddebtexpense;
    }

    public Integer getFormatingmaxid() {
        return formatingmaxid;
    }

    public void setFormatingmaxid(Integer formatingmaxid) {
        this.formatingmaxid = formatingmaxid;
    }

    public Integer getSettlementdiscountmethod() {
        return settlementdiscountmethod;
    }

    public void setSettlementdiscountmethod(Integer settlementdiscountmethod) {
        this.settlementdiscountmethod = settlementdiscountmethod;
    }

    public Integer getWriteoff() {
        return writeoff;
    }

    public void setWriteoff(Integer writeoff) {
        this.writeoff = writeoff;
    }

    public Integer getLoaninsurance() {
        return loaninsurance;
    }

    public void setLoaninsurance(Integer loaninsurance) {
        this.loaninsurance = loaninsurance;
    }

    public Integer getAccruedprincipal() {
        return accruedprincipal;
    }

    public void setAccruedprincipal(Integer accruedprincipal) {
        this.accruedprincipal = accruedprincipal;
    }

    public Integer getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(Integer downpayment) {
        this.downpayment = downpayment;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Boolean getUsedfor() {
        return usedfor;
    }

    public void setUsedfor(Boolean usedfor) {
        this.usedfor = usedfor;
    }

    public Integer getPartialdeposit() {
        return partialdeposit;
    }

    public void setPartialdeposit(Integer partialdeposit) {
        this.partialdeposit = partialdeposit;
    }

    public String getPenaltycalculation() {
        return penaltycalculation;
    }

    public void setPenaltycalculation(String penaltycalculation) {
        this.penaltycalculation = penaltycalculation;
    }

    public Loancategory getLoancategory() {
        return loancategory;
    }

    public void setLoancategory(Loancategory loancategory) {
        this.loancategory = loancategory;
    }

    public Loanapproval getLoanapprovalid() {
        return loanapprovalid;
    }

    public void setLoanapprovalid(Loanapproval loanapprovalid) {
        this.loanapprovalid = loanapprovalid;
    }

    public Currency getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(Currency currencyid) {
        this.currencyid = currencyid;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanid != null ? loanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.loanid == null && other.loanid != null) || (this.loanid != null && !this.loanid.equals(other.loanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Loan[ loanid=" + loanid + " ]";
    }

}
