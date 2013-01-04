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
    @NamedQuery(name = "Loanapplication.findAll", query = "SELECT l FROM Loanapplication l"),
    @NamedQuery(name = "Loanapplication.findByLoanapplicationid", query = "SELECT l FROM Loanapplication l WHERE l.loanapplicationid = :loanapplicationid"),
    @NamedQuery(name = "Loanapplication.findByTransferto", query = "SELECT l FROM Loanapplication l WHERE l.transferto = :transferto"),
    @NamedQuery(name = "Loanapplication.findByUseinsurance", query = "SELECT l FROM Loanapplication l WHERE l.useinsurance = :useinsurance"),
    @NamedQuery(name = "Loanapplication.findByLoanreason", query = "SELECT l FROM Loanapplication l WHERE l.loanreason = :loanreason"),
    @NamedQuery(name = "Loanapplication.findByUseguarantor", query = "SELECT l FROM Loanapplication l WHERE l.useguarantor = :useguarantor"),
    @NamedQuery(name = "Loanapplication.findByRefinancereason", query = "SELECT l FROM Loanapplication l WHERE l.refinancereason = :refinancereason"),
    @NamedQuery(name = "Loanapplication.findByOpenbalance", query = "SELECT l FROM Loanapplication l WHERE l.openbalance = :openbalance"),
    @NamedQuery(name = "Loanapplication.findByClosebalance", query = "SELECT l FROM Loanapplication l WHERE l.closebalance = :closebalance"),
    @NamedQuery(name = "Loanapplication.findByRepayment", query = "SELECT l FROM Loanapplication l WHERE l.repayment = :repayment"),
    @NamedQuery(name = "Loanapplication.findByInitialissuedate", query = "SELECT l FROM Loanapplication l WHERE l.initialissuedate = :initialissuedate"),
    @NamedQuery(name = "Loanapplication.findByCalculateinitialpaymentdate", query = "SELECT l FROM Loanapplication l WHERE l.calculateinitialpaymentdate = :calculateinitialpaymentdate"),
    @NamedQuery(name = "Loanapplication.findByInitialpaymentdate", query = "SELECT l FROM Loanapplication l WHERE l.initialpaymentdate = :initialpaymentdate"),
    @NamedQuery(name = "Loanapplication.findByLoantermvalue", query = "SELECT l FROM Loanapplication l WHERE l.loantermvalue = :loantermvalue"),
    @NamedQuery(name = "Loanapplication.findByPeriodedefferedvalue", query = "SELECT l FROM Loanapplication l WHERE l.periodedefferedvalue = :periodedefferedvalue"),
    @NamedQuery(name = "Loanapplication.findByBalloonpaymenttype", query = "SELECT l FROM Loanapplication l WHERE l.balloonpaymenttype = :balloonpaymenttype"),
    @NamedQuery(name = "Loanapplication.findByBalloonpaymentvalue", query = "SELECT l FROM Loanapplication l WHERE l.balloonpaymentvalue = :balloonpaymentvalue"),
    @NamedQuery(name = "Loanapplication.findByDownpayment", query = "SELECT l FROM Loanapplication l WHERE l.downpayment = :downpayment"),
    @NamedQuery(name = "Loanapplication.findByUsecapitalization", query = "SELECT l FROM Loanapplication l WHERE l.usecapitalization = :usecapitalization"),
    @NamedQuery(name = "Loanapplication.findByInsuranceprovider", query = "SELECT l FROM Loanapplication l WHERE l.insuranceprovider = :insuranceprovider"),
    @NamedQuery(name = "Loanapplication.findByTotalscore", query = "SELECT l FROM Loanapplication l WHERE l.totalscore = :totalscore"),
    @NamedQuery(name = "Loanapplication.findByGrade", query = "SELECT l FROM Loanapplication l WHERE l.grade = :grade"),
    @NamedQuery(name = "Loanapplication.findByDefinitionrating", query = "SELECT l FROM Loanapplication l WHERE l.definitionrating = :definitionrating"),
    @NamedQuery(name = "Loanapplication.findByChecker", query = "SELECT l FROM Loanapplication l WHERE l.checker = :checker"),
    @NamedQuery(name = "Loanapplication.findByApproval", query = "SELECT l FROM Loanapplication l WHERE l.approval = :approval"),
    @NamedQuery(name = "Loanapplication.findByUsecollateral", query = "SELECT l FROM Loanapplication l WHERE l.usecollateral = :usecollateral"),
    @NamedQuery(name = "Loanapplication.findBySourceoffund", query = "SELECT l FROM Loanapplication l WHERE l.sourceoffund = :sourceoffund"),
    @NamedQuery(name = "Loanapplication.findBySourceoffundvalue", query = "SELECT l FROM Loanapplication l WHERE l.sourceoffundvalue = :sourceoffundvalue"),
    @NamedQuery(name = "Loanapplication.findByGroupid", query = "SELECT l FROM Loanapplication l WHERE l.groupid = :groupid"),
    @NamedQuery(name = "Loanapplication.findByLoanterm", query = "SELECT l FROM Loanapplication l WHERE l.loanterm = :loanterm"),
    @NamedQuery(name = "Loanapplication.findByMaturitydate", query = "SELECT l FROM Loanapplication l WHERE l.maturitydate = :maturitydate"),
    @NamedQuery(name = "Loanapplication.findByDaycountfraction", query = "SELECT l FROM Loanapplication l WHERE l.daycountfraction = :daycountfraction"),
    @NamedQuery(name = "Loanapplication.findByUserepaymentlevel", query = "SELECT l FROM Loanapplication l WHERE l.userepaymentlevel = :userepaymentlevel"),
    @NamedQuery(name = "Loanapplication.findByPeriodedeffered", query = "SELECT l FROM Loanapplication l WHERE l.periodedeffered = :periodedeffered"),
    @NamedQuery(name = "Loanapplication.findByCreationdate", query = "SELECT l FROM Loanapplication l WHERE l.creationdate = :creationdate"),
    @NamedQuery(name = "Loanapplication.findByEditdate", query = "SELECT l FROM Loanapplication l WHERE l.editdate = :editdate"),
    @NamedQuery(name = "Loanapplication.findByInsurancetype", query = "SELECT l FROM Loanapplication l WHERE l.insurancetype = :insurancetype"),
    @NamedQuery(name = "Loanapplication.findByPolisnumber", query = "SELECT l FROM Loanapplication l WHERE l.polisnumber = :polisnumber"),
    @NamedQuery(name = "Loanapplication.findByInsurancedate", query = "SELECT l FROM Loanapplication l WHERE l.insurancedate = :insurancedate"),
    @NamedQuery(name = "Loanapplication.findByInsurancevaluetype", query = "SELECT l FROM Loanapplication l WHERE l.insurancevaluetype = :insurancevaluetype"),
    @NamedQuery(name = "Loanapplication.findByInsurancevalue", query = "SELECT l FROM Loanapplication l WHERE l.insurancevalue = :insurancevalue"),
    @NamedQuery(name = "Loanapplication.findByMaturityinsurance", query = "SELECT l FROM Loanapplication l WHERE l.maturityinsurance = :maturityinsurance"),
    @NamedQuery(name = "Loanapplication.findByClaimdate", query = "SELECT l FROM Loanapplication l WHERE l.claimdate = :claimdate"),
    @NamedQuery(name = "Loanapplication.findByClaimvalue", query = "SELECT l FROM Loanapplication l WHERE l.claimvalue = :claimvalue"),
    @NamedQuery(name = "Loanapplication.findByClaimpaymentdate", query = "SELECT l FROM Loanapplication l WHERE l.claimpaymentdate = :claimpaymentdate"),
    @NamedQuery(name = "Loanapplication.findByDescription", query = "SELECT l FROM Loanapplication l WHERE l.description = :description"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationaccount", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationaccount = :capitalizationaccount"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationvalue", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationvalue = :capitalizationvalue"),
    @NamedQuery(name = "Loanapplication.findByDocument", query = "SELECT l FROM Loanapplication l WHERE l.document = :document"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationtype", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationtype = :capitalizationtype"),
    @NamedQuery(name = "Loanapplication.findByCreator", query = "SELECT l FROM Loanapplication l WHERE l.creator = :creator"),
    @NamedQuery(name = "Loanapplication.findByEditor", query = "SELECT l FROM Loanapplication l WHERE l.editor = :editor"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationpayment", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationpayment = :capitalizationpayment"),
    @NamedQuery(name = "Loanapplication.findByInterest", query = "SELECT l FROM Loanapplication l WHERE l.interest = :interest"),
    @NamedQuery(name = "Loanapplication.findByBalance", query = "SELECT l FROM Loanapplication l WHERE l.balance = :balance"),
    @NamedQuery(name = "Loanapplication.findByDramount", query = "SELECT l FROM Loanapplication l WHERE l.dramount = :dramount"),
    @NamedQuery(name = "Loanapplication.findByAccountofficer", query = "SELECT l FROM Loanapplication l WHERE l.accountofficer = :accountofficer"),
    @NamedQuery(name = "Loanapplication.findByLoanid", query = "SELECT l FROM Loanapplication l WHERE l.loanid = :loanid"),
    @NamedQuery(name = "Loanapplication.findByCustomerid", query = "SELECT l FROM Loanapplication l WHERE l.customerid = :customerid"),
    @NamedQuery(name = "Loanapplication.findByDisbrusmentstatus", query = "SELECT l FROM Loanapplication l WHERE l.disbrusmentstatus = :disbrusmentstatus"),
    @NamedQuery(name = "Loanapplication.findByStatus", query = "SELECT l FROM Loanapplication l WHERE l.status = :status"),
    @NamedQuery(name = "Loanapplication.findByRestructureid", query = "SELECT l FROM Loanapplication l WHERE l.restructureid = :restructureid"),
    @NamedQuery(name = "Loanapplication.findBySessiondate", query = "SELECT l FROM Loanapplication l WHERE l.sessiondate = :sessiondate"),
    @NamedQuery(name = "Loanapplication.findByTransfertomaker", query = "SELECT l FROM Loanapplication l WHERE l.transfertomaker = :transfertomaker"),
    @NamedQuery(name = "Loanapplication.findByUseinsurancemaker", query = "SELECT l FROM Loanapplication l WHERE l.useinsurancemaker = :useinsurancemaker"),
    @NamedQuery(name = "Loanapplication.findByLoanreasonmaker", query = "SELECT l FROM Loanapplication l WHERE l.loanreasonmaker = :loanreasonmaker"),
    @NamedQuery(name = "Loanapplication.findByUseguarantormaker", query = "SELECT l FROM Loanapplication l WHERE l.useguarantormaker = :useguarantormaker"),
    @NamedQuery(name = "Loanapplication.findByRefinancereasonmaker", query = "SELECT l FROM Loanapplication l WHERE l.refinancereasonmaker = :refinancereasonmaker"),
    @NamedQuery(name = "Loanapplication.findByOpenbalancemaker", query = "SELECT l FROM Loanapplication l WHERE l.openbalancemaker = :openbalancemaker"),
    @NamedQuery(name = "Loanapplication.findByClosebalancemaker", query = "SELECT l FROM Loanapplication l WHERE l.closebalancemaker = :closebalancemaker"),
    @NamedQuery(name = "Loanapplication.findByRepaymentmaker", query = "SELECT l FROM Loanapplication l WHERE l.repaymentmaker = :repaymentmaker"),
    @NamedQuery(name = "Loanapplication.findByInitialissuedatemaker", query = "SELECT l FROM Loanapplication l WHERE l.initialissuedatemaker = :initialissuedatemaker"),
    @NamedQuery(name = "Loanapplication.findByCalculateinitialpaymentdatemaker", query = "SELECT l FROM Loanapplication l WHERE l.calculateinitialpaymentdatemaker = :calculateinitialpaymentdatemaker"),
    @NamedQuery(name = "Loanapplication.findByInitialpaymentdatemaker", query = "SELECT l FROM Loanapplication l WHERE l.initialpaymentdatemaker = :initialpaymentdatemaker"),
    @NamedQuery(name = "Loanapplication.findByLoantermvaluemaker", query = "SELECT l FROM Loanapplication l WHERE l.loantermvaluemaker = :loantermvaluemaker"),
    @NamedQuery(name = "Loanapplication.findByPeriodedefferedvaluemaker", query = "SELECT l FROM Loanapplication l WHERE l.periodedefferedvaluemaker = :periodedefferedvaluemaker"),
    @NamedQuery(name = "Loanapplication.findByBalloonpaymenttypemaker", query = "SELECT l FROM Loanapplication l WHERE l.balloonpaymenttypemaker = :balloonpaymenttypemaker"),
    @NamedQuery(name = "Loanapplication.findByBalloonpaymentvaluemaker", query = "SELECT l FROM Loanapplication l WHERE l.balloonpaymentvaluemaker = :balloonpaymentvaluemaker"),
    @NamedQuery(name = "Loanapplication.findByDownpaymentmaker", query = "SELECT l FROM Loanapplication l WHERE l.downpaymentmaker = :downpaymentmaker"),
    @NamedQuery(name = "Loanapplication.findByUsecapitalizationmaker", query = "SELECT l FROM Loanapplication l WHERE l.usecapitalizationmaker = :usecapitalizationmaker"),
    @NamedQuery(name = "Loanapplication.findByInsuranceprovidermaker", query = "SELECT l FROM Loanapplication l WHERE l.insuranceprovidermaker = :insuranceprovidermaker"),
    @NamedQuery(name = "Loanapplication.findByTotalscoremaker", query = "SELECT l FROM Loanapplication l WHERE l.totalscoremaker = :totalscoremaker"),
    @NamedQuery(name = "Loanapplication.findByGrademaker", query = "SELECT l FROM Loanapplication l WHERE l.grademaker = :grademaker"),
    @NamedQuery(name = "Loanapplication.findByDefinitionratingmaker", query = "SELECT l FROM Loanapplication l WHERE l.definitionratingmaker = :definitionratingmaker"),
    @NamedQuery(name = "Loanapplication.findByCheckermaker", query = "SELECT l FROM Loanapplication l WHERE l.checkermaker = :checkermaker"),
    @NamedQuery(name = "Loanapplication.findByApprovalmaker", query = "SELECT l FROM Loanapplication l WHERE l.approvalmaker = :approvalmaker"),
    @NamedQuery(name = "Loanapplication.findByUsecollateralmaker", query = "SELECT l FROM Loanapplication l WHERE l.usecollateralmaker = :usecollateralmaker"),
    @NamedQuery(name = "Loanapplication.findBySourceoffundmaker", query = "SELECT l FROM Loanapplication l WHERE l.sourceoffundmaker = :sourceoffundmaker"),
    @NamedQuery(name = "Loanapplication.findBySourceoffundvaluemaker", query = "SELECT l FROM Loanapplication l WHERE l.sourceoffundvaluemaker = :sourceoffundvaluemaker"),
    @NamedQuery(name = "Loanapplication.findByGroupidmaker", query = "SELECT l FROM Loanapplication l WHERE l.groupidmaker = :groupidmaker"),
    @NamedQuery(name = "Loanapplication.findByLoantermmaker", query = "SELECT l FROM Loanapplication l WHERE l.loantermmaker = :loantermmaker"),
    @NamedQuery(name = "Loanapplication.findByMaturitydatemaker", query = "SELECT l FROM Loanapplication l WHERE l.maturitydatemaker = :maturitydatemaker"),
    @NamedQuery(name = "Loanapplication.findByDaycountfractionmaker", query = "SELECT l FROM Loanapplication l WHERE l.daycountfractionmaker = :daycountfractionmaker"),
    @NamedQuery(name = "Loanapplication.findByUserepaymentlevelmaker", query = "SELECT l FROM Loanapplication l WHERE l.userepaymentlevelmaker = :userepaymentlevelmaker"),
    @NamedQuery(name = "Loanapplication.findByPeriodedefferedmaker", query = "SELECT l FROM Loanapplication l WHERE l.periodedefferedmaker = :periodedefferedmaker"),
    @NamedQuery(name = "Loanapplication.findByCreationdatemaker", query = "SELECT l FROM Loanapplication l WHERE l.creationdatemaker = :creationdatemaker"),
    @NamedQuery(name = "Loanapplication.findByEditdatemaker", query = "SELECT l FROM Loanapplication l WHERE l.editdatemaker = :editdatemaker"),
    @NamedQuery(name = "Loanapplication.findByInsurancetypemaker", query = "SELECT l FROM Loanapplication l WHERE l.insurancetypemaker = :insurancetypemaker"),
    @NamedQuery(name = "Loanapplication.findByPolisnumbermaker", query = "SELECT l FROM Loanapplication l WHERE l.polisnumbermaker = :polisnumbermaker"),
    @NamedQuery(name = "Loanapplication.findByInsurancedatemaker", query = "SELECT l FROM Loanapplication l WHERE l.insurancedatemaker = :insurancedatemaker"),
    @NamedQuery(name = "Loanapplication.findByInsurancevaluetypemaker", query = "SELECT l FROM Loanapplication l WHERE l.insurancevaluetypemaker = :insurancevaluetypemaker"),
    @NamedQuery(name = "Loanapplication.findByInsurancevaluemaker", query = "SELECT l FROM Loanapplication l WHERE l.insurancevaluemaker = :insurancevaluemaker"),
    @NamedQuery(name = "Loanapplication.findByMaturityinsurancemaker", query = "SELECT l FROM Loanapplication l WHERE l.maturityinsurancemaker = :maturityinsurancemaker"),
    @NamedQuery(name = "Loanapplication.findByClaimdatemaker", query = "SELECT l FROM Loanapplication l WHERE l.claimdatemaker = :claimdatemaker"),
    @NamedQuery(name = "Loanapplication.findByClaimvaluemaker", query = "SELECT l FROM Loanapplication l WHERE l.claimvaluemaker = :claimvaluemaker"),
    @NamedQuery(name = "Loanapplication.findByClaimpaymentdatemaker", query = "SELECT l FROM Loanapplication l WHERE l.claimpaymentdatemaker = :claimpaymentdatemaker"),
    @NamedQuery(name = "Loanapplication.findByDescriptionmaker", query = "SELECT l FROM Loanapplication l WHERE l.descriptionmaker = :descriptionmaker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationaccountmaker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationaccountmaker = :capitalizationaccountmaker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationvaluemaker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationvaluemaker = :capitalizationvaluemaker"),
    @NamedQuery(name = "Loanapplication.findByDocumentmaker", query = "SELECT l FROM Loanapplication l WHERE l.documentmaker = :documentmaker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationtypemaker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationtypemaker = :capitalizationtypemaker"),
    @NamedQuery(name = "Loanapplication.findByCreatormaker", query = "SELECT l FROM Loanapplication l WHERE l.creatormaker = :creatormaker"),
    @NamedQuery(name = "Loanapplication.findByEditormaker", query = "SELECT l FROM Loanapplication l WHERE l.editormaker = :editormaker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationpaymentmaker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationpaymentmaker = :capitalizationpaymentmaker"),
    @NamedQuery(name = "Loanapplication.findByInterestmaker", query = "SELECT l FROM Loanapplication l WHERE l.interestmaker = :interestmaker"),
    @NamedQuery(name = "Loanapplication.findByBalancemaker", query = "SELECT l FROM Loanapplication l WHERE l.balancemaker = :balancemaker"),
    @NamedQuery(name = "Loanapplication.findByDramountmaker", query = "SELECT l FROM Loanapplication l WHERE l.dramountmaker = :dramountmaker"),
    @NamedQuery(name = "Loanapplication.findByAccountofficermaker", query = "SELECT l FROM Loanapplication l WHERE l.accountofficermaker = :accountofficermaker"),
    @NamedQuery(name = "Loanapplication.findByLoanidmaker", query = "SELECT l FROM Loanapplication l WHERE l.loanidmaker = :loanidmaker"),
    @NamedQuery(name = "Loanapplication.findByCustomeridmaker", query = "SELECT l FROM Loanapplication l WHERE l.customeridmaker = :customeridmaker"),
    @NamedQuery(name = "Loanapplication.findByDisbrusmentstatusmaker", query = "SELECT l FROM Loanapplication l WHERE l.disbrusmentstatusmaker = :disbrusmentstatusmaker"),
    @NamedQuery(name = "Loanapplication.findByStatusmaker", query = "SELECT l FROM Loanapplication l WHERE l.statusmaker = :statusmaker"),
    @NamedQuery(name = "Loanapplication.findByRestructureidmaker", query = "SELECT l FROM Loanapplication l WHERE l.restructureidmaker = :restructureidmaker"),
    @NamedQuery(name = "Loanapplication.findBySessiondatemaker", query = "SELECT l FROM Loanapplication l WHERE l.sessiondatemaker = :sessiondatemaker"),
    @NamedQuery(name = "Loanapplication.findByTransfertochecker", query = "SELECT l FROM Loanapplication l WHERE l.transfertochecker = :transfertochecker"),
    @NamedQuery(name = "Loanapplication.findByUseinsurancechecker", query = "SELECT l FROM Loanapplication l WHERE l.useinsurancechecker = :useinsurancechecker"),
    @NamedQuery(name = "Loanapplication.findByLoanreasonchecker", query = "SELECT l FROM Loanapplication l WHERE l.loanreasonchecker = :loanreasonchecker"),
    @NamedQuery(name = "Loanapplication.findByUseguarantorchecker", query = "SELECT l FROM Loanapplication l WHERE l.useguarantorchecker = :useguarantorchecker"),
    @NamedQuery(name = "Loanapplication.findByRefinancereasonchecker", query = "SELECT l FROM Loanapplication l WHERE l.refinancereasonchecker = :refinancereasonchecker"),
    @NamedQuery(name = "Loanapplication.findByOpenbalancechecker", query = "SELECT l FROM Loanapplication l WHERE l.openbalancechecker = :openbalancechecker"),
    @NamedQuery(name = "Loanapplication.findByClosebalancechecker", query = "SELECT l FROM Loanapplication l WHERE l.closebalancechecker = :closebalancechecker"),
    @NamedQuery(name = "Loanapplication.findByRepaymentchecker", query = "SELECT l FROM Loanapplication l WHERE l.repaymentchecker = :repaymentchecker"),
    @NamedQuery(name = "Loanapplication.findByInitialissuedatechecker", query = "SELECT l FROM Loanapplication l WHERE l.initialissuedatechecker = :initialissuedatechecker"),
    @NamedQuery(name = "Loanapplication.findByCalculateinitialpaymentdatechecker", query = "SELECT l FROM Loanapplication l WHERE l.calculateinitialpaymentdatechecker = :calculateinitialpaymentdatechecker"),
    @NamedQuery(name = "Loanapplication.findByInitialpaymentdatechecker", query = "SELECT l FROM Loanapplication l WHERE l.initialpaymentdatechecker = :initialpaymentdatechecker"),
    @NamedQuery(name = "Loanapplication.findByLoantermvaluechecker", query = "SELECT l FROM Loanapplication l WHERE l.loantermvaluechecker = :loantermvaluechecker"),
    @NamedQuery(name = "Loanapplication.findByPeriodedefferedvaluechecker", query = "SELECT l FROM Loanapplication l WHERE l.periodedefferedvaluechecker = :periodedefferedvaluechecker"),
    @NamedQuery(name = "Loanapplication.findByBalloonpaymenttypechecker", query = "SELECT l FROM Loanapplication l WHERE l.balloonpaymenttypechecker = :balloonpaymenttypechecker"),
    @NamedQuery(name = "Loanapplication.findByBalloonpaymentvaluechecker", query = "SELECT l FROM Loanapplication l WHERE l.balloonpaymentvaluechecker = :balloonpaymentvaluechecker"),
    @NamedQuery(name = "Loanapplication.findByDownpaymentchecker", query = "SELECT l FROM Loanapplication l WHERE l.downpaymentchecker = :downpaymentchecker"),
    @NamedQuery(name = "Loanapplication.findByUsecapitalizationchecker", query = "SELECT l FROM Loanapplication l WHERE l.usecapitalizationchecker = :usecapitalizationchecker"),
    @NamedQuery(name = "Loanapplication.findByInsuranceproviderchecker", query = "SELECT l FROM Loanapplication l WHERE l.insuranceproviderchecker = :insuranceproviderchecker"),
    @NamedQuery(name = "Loanapplication.findByTotalscorechecker", query = "SELECT l FROM Loanapplication l WHERE l.totalscorechecker = :totalscorechecker"),
    @NamedQuery(name = "Loanapplication.findByGradechecker", query = "SELECT l FROM Loanapplication l WHERE l.gradechecker = :gradechecker"),
    @NamedQuery(name = "Loanapplication.findByDefinitionratingchecker", query = "SELECT l FROM Loanapplication l WHERE l.definitionratingchecker = :definitionratingchecker"),
    @NamedQuery(name = "Loanapplication.findByCheckerchecker", query = "SELECT l FROM Loanapplication l WHERE l.checkerchecker = :checkerchecker"),
    @NamedQuery(name = "Loanapplication.findByApprovalchecker", query = "SELECT l FROM Loanapplication l WHERE l.approvalchecker = :approvalchecker"),
    @NamedQuery(name = "Loanapplication.findByUsecollateralchecker", query = "SELECT l FROM Loanapplication l WHERE l.usecollateralchecker = :usecollateralchecker"),
    @NamedQuery(name = "Loanapplication.findBySourceoffundchecker", query = "SELECT l FROM Loanapplication l WHERE l.sourceoffundchecker = :sourceoffundchecker"),
    @NamedQuery(name = "Loanapplication.findBySourceoffundvaluechecker", query = "SELECT l FROM Loanapplication l WHERE l.sourceoffundvaluechecker = :sourceoffundvaluechecker"),
    @NamedQuery(name = "Loanapplication.findByGroupidchecker", query = "SELECT l FROM Loanapplication l WHERE l.groupidchecker = :groupidchecker"),
    @NamedQuery(name = "Loanapplication.findByLoantermchecker", query = "SELECT l FROM Loanapplication l WHERE l.loantermchecker = :loantermchecker"),
    @NamedQuery(name = "Loanapplication.findByMaturitydatechecker", query = "SELECT l FROM Loanapplication l WHERE l.maturitydatechecker = :maturitydatechecker"),
    @NamedQuery(name = "Loanapplication.findByDaycountfractionchecker", query = "SELECT l FROM Loanapplication l WHERE l.daycountfractionchecker = :daycountfractionchecker"),
    @NamedQuery(name = "Loanapplication.findByUserepaymentlevelchecker", query = "SELECT l FROM Loanapplication l WHERE l.userepaymentlevelchecker = :userepaymentlevelchecker"),
    @NamedQuery(name = "Loanapplication.findByPeriodedefferedchecker", query = "SELECT l FROM Loanapplication l WHERE l.periodedefferedchecker = :periodedefferedchecker"),
    @NamedQuery(name = "Loanapplication.findByCreationdatechecker", query = "SELECT l FROM Loanapplication l WHERE l.creationdatechecker = :creationdatechecker"),
    @NamedQuery(name = "Loanapplication.findByEditdatechecker", query = "SELECT l FROM Loanapplication l WHERE l.editdatechecker = :editdatechecker"),
    @NamedQuery(name = "Loanapplication.findByInsurancetypechecker", query = "SELECT l FROM Loanapplication l WHERE l.insurancetypechecker = :insurancetypechecker"),
    @NamedQuery(name = "Loanapplication.findByPolisnumberchecker", query = "SELECT l FROM Loanapplication l WHERE l.polisnumberchecker = :polisnumberchecker"),
    @NamedQuery(name = "Loanapplication.findByInsurancedatechecker", query = "SELECT l FROM Loanapplication l WHERE l.insurancedatechecker = :insurancedatechecker"),
    @NamedQuery(name = "Loanapplication.findByInsurancevaluetypechecker", query = "SELECT l FROM Loanapplication l WHERE l.insurancevaluetypechecker = :insurancevaluetypechecker"),
    @NamedQuery(name = "Loanapplication.findByInsurancevaluechecker", query = "SELECT l FROM Loanapplication l WHERE l.insurancevaluechecker = :insurancevaluechecker"),
    @NamedQuery(name = "Loanapplication.findByMaturityinsurancechecker", query = "SELECT l FROM Loanapplication l WHERE l.maturityinsurancechecker = :maturityinsurancechecker"),
    @NamedQuery(name = "Loanapplication.findByClaimdatechecker", query = "SELECT l FROM Loanapplication l WHERE l.claimdatechecker = :claimdatechecker"),
    @NamedQuery(name = "Loanapplication.findByClaimvaluechecker", query = "SELECT l FROM Loanapplication l WHERE l.claimvaluechecker = :claimvaluechecker"),
    @NamedQuery(name = "Loanapplication.findByClaimpaymentdatechecker", query = "SELECT l FROM Loanapplication l WHERE l.claimpaymentdatechecker = :claimpaymentdatechecker"),
    @NamedQuery(name = "Loanapplication.findByDescriptionchecker", query = "SELECT l FROM Loanapplication l WHERE l.descriptionchecker = :descriptionchecker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationaccountchecker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationaccountchecker = :capitalizationaccountchecker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationvaluechecker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationvaluechecker = :capitalizationvaluechecker"),
    @NamedQuery(name = "Loanapplication.findByDocumentchecker", query = "SELECT l FROM Loanapplication l WHERE l.documentchecker = :documentchecker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationtypechecker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationtypechecker = :capitalizationtypechecker"),
    @NamedQuery(name = "Loanapplication.findByCreatorchecker", query = "SELECT l FROM Loanapplication l WHERE l.creatorchecker = :creatorchecker"),
    @NamedQuery(name = "Loanapplication.findByEditorchecker", query = "SELECT l FROM Loanapplication l WHERE l.editorchecker = :editorchecker"),
    @NamedQuery(name = "Loanapplication.findByCapitalizationpaymentchecker", query = "SELECT l FROM Loanapplication l WHERE l.capitalizationpaymentchecker = :capitalizationpaymentchecker"),
    @NamedQuery(name = "Loanapplication.findByInterestchecker", query = "SELECT l FROM Loanapplication l WHERE l.interestchecker = :interestchecker"),
    @NamedQuery(name = "Loanapplication.findByBalancechecker", query = "SELECT l FROM Loanapplication l WHERE l.balancechecker = :balancechecker"),
    @NamedQuery(name = "Loanapplication.findByDramountchecker", query = "SELECT l FROM Loanapplication l WHERE l.dramountchecker = :dramountchecker"),
    @NamedQuery(name = "Loanapplication.findByAccountofficerchecker", query = "SELECT l FROM Loanapplication l WHERE l.accountofficerchecker = :accountofficerchecker"),
    @NamedQuery(name = "Loanapplication.findByLoanidchecker", query = "SELECT l FROM Loanapplication l WHERE l.loanidchecker = :loanidchecker"),
    @NamedQuery(name = "Loanapplication.findByCustomeridchecker", query = "SELECT l FROM Loanapplication l WHERE l.customeridchecker = :customeridchecker"),
    @NamedQuery(name = "Loanapplication.findByDisbrusmentstatuschecker", query = "SELECT l FROM Loanapplication l WHERE l.disbrusmentstatuschecker = :disbrusmentstatuschecker"),
    @NamedQuery(name = "Loanapplication.findByStatuschecker", query = "SELECT l FROM Loanapplication l WHERE l.statuschecker = :statuschecker"),
    @NamedQuery(name = "Loanapplication.findByRestructureidchecker", query = "SELECT l FROM Loanapplication l WHERE l.restructureidchecker = :restructureidchecker"),
    @NamedQuery(name = "Loanapplication.findBySessiondatechecker", query = "SELECT l FROM Loanapplication l WHERE l.sessiondatechecker = :sessiondatechecker"),
    @NamedQuery(name = "Loanapplication.findByApprovaldate", query = "SELECT l FROM Loanapplication l WHERE l.approvaldate = :approvaldate")})
public class Loanapplication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer loanapplicationid;
    private Integer transferto;
    private Boolean useinsurance;
    private Integer loanreason;
    private Boolean useguarantor;
    private Integer refinancereason;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double openbalance;
    @Column(precision = 17, scale = 17)
    private Double closebalance;
    @Column(precision = 17, scale = 17)
    private Double repayment;
    @Temporal(TemporalType.DATE)
    private Date initialissuedate;
    private Boolean calculateinitialpaymentdate;
    @Temporal(TemporalType.DATE)
    private Date initialpaymentdate;
    private Integer loantermvalue;
    private Integer periodedefferedvalue;
    @Size(max = 10)
    @Column(length = 10)
    private String balloonpaymenttype;
    @Column(precision = 17, scale = 17)
    private Double balloonpaymentvalue;
    @Column(precision = 17, scale = 17)
    private Double downpayment;
    private Boolean usecapitalization;
    private Integer insuranceprovider;
    private Integer totalscore;
    @Size(max = 2)
    @Column(length = 2)
    private String grade;
    @Size(max = 100)
    @Column(length = 100)
    private String definitionrating;
    @Size(max = 50)
    @Column(length = 50)
    private String checker;
    @Size(max = 50)
    @Column(length = 50)
    private String approval;
    private Boolean usecollateral;
    @Size(max = 20)
    @Column(length = 20)
    private String sourceoffund;
    private Integer sourceoffundvalue;
    private Integer groupid;
    @Size(max = 10)
    @Column(length = 10)
    private String loanterm;
    @Temporal(TemporalType.DATE)
    private Date maturitydate;
    @Size(max = 20)
    @Column(length = 20)
    private String daycountfraction;
    private Boolean userepaymentlevel;
    private Character periodedeffered;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 50)
    @Column(length = 50)
    private String insurancetype;
    @Size(max = 50)
    @Column(length = 50)
    private String polisnumber;
    @Temporal(TemporalType.DATE)
    private Date insurancedate;
    @Size(max = 10)
    @Column(length = 10)
    private String insurancevaluetype;
    @Column(precision = 17, scale = 17)
    private Double insurancevalue;
    @Temporal(TemporalType.DATE)
    private Date maturityinsurance;
    @Temporal(TemporalType.DATE)
    private Date claimdate;
    @Column(precision = 17, scale = 17)
    private Double claimvalue;
    @Temporal(TemporalType.DATE)
    private Date claimpaymentdate;
    @Size(max = 100)
    @Column(length = 100)
    private String description;
    private Integer capitalizationaccount;
    @Column(precision = 17, scale = 17)
    private Double capitalizationvalue;
    @Size(max = 50)
    @Column(length = 50)
    private String document;
    @Size(max = 10)
    @Column(length = 10)
    private String capitalizationtype;
    private Integer creator;
    private Integer editor;
    @Size(max = 25)
    @Column(length = 25)
    private String capitalizationpayment;
    @Column(precision = 17, scale = 17)
    private Double interest;
    @Column(precision = 17, scale = 17)
    private Double balance;
    @Column(precision = 17, scale = 17)
    private Double dramount;
    private Integer accountofficer;
    private Integer loanid;
    private Integer customerid;
    private Boolean disbrusmentstatus;
    @Size(max = 4)
    @Column(length = 4)
    private String status;
    private Integer restructureid;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    private Integer transfertomaker;
    private Boolean useinsurancemaker;
    private Integer loanreasonmaker;
    private Boolean useguarantormaker;
    private Integer refinancereasonmaker;
    @Column(precision = 17, scale = 17)
    private Double openbalancemaker;
    @Column(precision = 17, scale = 17)
    private Double closebalancemaker;
    @Column(precision = 17, scale = 17)
    private Double repaymentmaker;
    @Temporal(TemporalType.DATE)
    private Date initialissuedatemaker;
    private Boolean calculateinitialpaymentdatemaker;
    @Temporal(TemporalType.DATE)
    private Date initialpaymentdatemaker;
    private Integer loantermvaluemaker;
    private Integer periodedefferedvaluemaker;
    @Size(max = 10)
    @Column(length = 10)
    private String balloonpaymenttypemaker;
    @Column(precision = 17, scale = 17)
    private Double balloonpaymentvaluemaker;
    @Column(precision = 17, scale = 17)
    private Double downpaymentmaker;
    private Boolean usecapitalizationmaker;
    private Integer insuranceprovidermaker;
    private Integer totalscoremaker;
    @Size(max = 2)
    @Column(length = 2)
    private String grademaker;
    @Size(max = 100)
    @Column(length = 100)
    private String definitionratingmaker;
    @Size(max = 50)
    @Column(length = 50)
    private String checkermaker;
    @Size(max = 50)
    @Column(length = 50)
    private String approvalmaker;
    private Boolean usecollateralmaker;
    @Size(max = 20)
    @Column(length = 20)
    private String sourceoffundmaker;
    private Integer sourceoffundvaluemaker;
    private Integer groupidmaker;
    @Size(max = 10)
    @Column(length = 10)
    private String loantermmaker;
    @Temporal(TemporalType.DATE)
    private Date maturitydatemaker;
    @Size(max = 20)
    @Column(length = 20)
    private String daycountfractionmaker;
    private Boolean userepaymentlevelmaker;
    private Character periodedefferedmaker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdatemaker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdatemaker;
    @Size(max = 50)
    @Column(length = 50)
    private String insurancetypemaker;
    @Size(max = 50)
    @Column(length = 50)
    private String polisnumbermaker;
    @Temporal(TemporalType.DATE)
    private Date insurancedatemaker;
    @Size(max = 10)
    @Column(length = 10)
    private String insurancevaluetypemaker;
    @Column(precision = 17, scale = 17)
    private Double insurancevaluemaker;
    @Temporal(TemporalType.DATE)
    private Date maturityinsurancemaker;
    @Temporal(TemporalType.DATE)
    private Date claimdatemaker;
    @Column(precision = 17, scale = 17)
    private Double claimvaluemaker;
    @Temporal(TemporalType.DATE)
    private Date claimpaymentdatemaker;
    @Size(max = 100)
    @Column(length = 100)
    private String descriptionmaker;
    private Integer capitalizationaccountmaker;
    @Column(precision = 17, scale = 17)
    private Double capitalizationvaluemaker;
    @Size(max = 50)
    @Column(length = 50)
    private String documentmaker;
    @Size(max = 10)
    @Column(length = 10)
    private String capitalizationtypemaker;
    private Integer creatormaker;
    private Integer editormaker;
    @Size(max = 25)
    @Column(length = 25)
    private String capitalizationpaymentmaker;
    @Column(precision = 17, scale = 17)
    private Double interestmaker;
    @Column(precision = 17, scale = 17)
    private Double balancemaker;
    @Column(precision = 17, scale = 17)
    private Double dramountmaker;
    private Integer accountofficermaker;
    private Integer loanidmaker;
    private Integer customeridmaker;
    private Boolean disbrusmentstatusmaker;
    @Size(max = 4)
    @Column(length = 4)
    private String statusmaker;
    private Integer restructureidmaker;
    @Temporal(TemporalType.DATE)
    private Date sessiondatemaker;
    private Integer transfertochecker;
    private Boolean useinsurancechecker;
    private Integer loanreasonchecker;
    private Boolean useguarantorchecker;
    private Integer refinancereasonchecker;
    @Column(precision = 17, scale = 17)
    private Double openbalancechecker;
    @Column(precision = 17, scale = 17)
    private Double closebalancechecker;
    @Column(precision = 17, scale = 17)
    private Double repaymentchecker;
    @Temporal(TemporalType.DATE)
    private Date initialissuedatechecker;
    private Boolean calculateinitialpaymentdatechecker;
    @Temporal(TemporalType.DATE)
    private Date initialpaymentdatechecker;
    private Integer loantermvaluechecker;
    private Integer periodedefferedvaluechecker;
    @Size(max = 10)
    @Column(length = 10)
    private String balloonpaymenttypechecker;
    @Column(precision = 17, scale = 17)
    private Double balloonpaymentvaluechecker;
    @Column(precision = 17, scale = 17)
    private Double downpaymentchecker;
    private Boolean usecapitalizationchecker;
    private Integer insuranceproviderchecker;
    private Integer totalscorechecker;
    @Size(max = 2)
    @Column(length = 2)
    private String gradechecker;
    @Size(max = 100)
    @Column(length = 100)
    private String definitionratingchecker;
    @Size(max = 50)
    @Column(length = 50)
    private String checkerchecker;
    @Size(max = 50)
    @Column(length = 50)
    private String approvalchecker;
    private Boolean usecollateralchecker;
    @Size(max = 20)
    @Column(length = 20)
    private String sourceoffundchecker;
    private Integer sourceoffundvaluechecker;
    private Integer groupidchecker;
    @Size(max = 10)
    @Column(length = 10)
    private String loantermchecker;
    @Temporal(TemporalType.DATE)
    private Date maturitydatechecker;
    @Size(max = 20)
    @Column(length = 20)
    private String daycountfractionchecker;
    private Boolean userepaymentlevelchecker;
    private Character periodedefferedchecker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdatechecker;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdatechecker;
    @Size(max = 50)
    @Column(length = 50)
    private String insurancetypechecker;
    @Size(max = 50)
    @Column(length = 50)
    private String polisnumberchecker;
    @Temporal(TemporalType.DATE)
    private Date insurancedatechecker;
    @Size(max = 10)
    @Column(length = 10)
    private String insurancevaluetypechecker;
    @Column(precision = 17, scale = 17)
    private Double insurancevaluechecker;
    @Temporal(TemporalType.DATE)
    private Date maturityinsurancechecker;
    @Temporal(TemporalType.DATE)
    private Date claimdatechecker;
    @Column(precision = 17, scale = 17)
    private Double claimvaluechecker;
    @Temporal(TemporalType.DATE)
    private Date claimpaymentdatechecker;
    @Size(max = 100)
    @Column(length = 100)
    private String descriptionchecker;
    private Integer capitalizationaccountchecker;
    @Column(precision = 17, scale = 17)
    private Double capitalizationvaluechecker;
    @Size(max = 50)
    @Column(length = 50)
    private String documentchecker;
    @Size(max = 10)
    @Column(length = 10)
    private String capitalizationtypechecker;
    private Integer creatorchecker;
    private Integer editorchecker;
    @Size(max = 25)
    @Column(length = 25)
    private String capitalizationpaymentchecker;
    @Column(precision = 17, scale = 17)
    private Double interestchecker;
    @Column(precision = 17, scale = 17)
    private Double balancechecker;
    @Column(precision = 17, scale = 17)
    private Double dramountchecker;
    private Integer accountofficerchecker;
    private Integer loanidchecker;
    private Integer customeridchecker;
    private Boolean disbrusmentstatuschecker;
    @Size(max = 4)
    @Column(length = 4)
    private String statuschecker;
    private Integer restructureidchecker;
    @Temporal(TemporalType.DATE)
    private Date sessiondatechecker;
    @Temporal(TemporalType.DATE)
    private Date approvaldate;
    @OneToMany(mappedBy = "loanapplicationid")
    private List<Account> accountList;

    public Loanapplication() {
    }

    public Loanapplication(Integer loanapplicationid) {
        this.loanapplicationid = loanapplicationid;
    }

    public Integer getLoanapplicationid() {
        return loanapplicationid;
    }

    public void setLoanapplicationid(Integer loanapplicationid) {
        this.loanapplicationid = loanapplicationid;
    }

    public Integer getTransferto() {
        return transferto;
    }

    public void setTransferto(Integer transferto) {
        this.transferto = transferto;
    }

    public Boolean getUseinsurance() {
        return useinsurance;
    }

    public void setUseinsurance(Boolean useinsurance) {
        this.useinsurance = useinsurance;
    }

    public Integer getLoanreason() {
        return loanreason;
    }

    public void setLoanreason(Integer loanreason) {
        this.loanreason = loanreason;
    }

    public Boolean getUseguarantor() {
        return useguarantor;
    }

    public void setUseguarantor(Boolean useguarantor) {
        this.useguarantor = useguarantor;
    }

    public Integer getRefinancereason() {
        return refinancereason;
    }

    public void setRefinancereason(Integer refinancereason) {
        this.refinancereason = refinancereason;
    }

    public Double getOpenbalance() {
        return openbalance;
    }

    public void setOpenbalance(Double openbalance) {
        this.openbalance = openbalance;
    }

    public Double getClosebalance() {
        return closebalance;
    }

    public void setClosebalance(Double closebalance) {
        this.closebalance = closebalance;
    }

    public Double getRepayment() {
        return repayment;
    }

    public void setRepayment(Double repayment) {
        this.repayment = repayment;
    }

    public Date getInitialissuedate() {
        return initialissuedate;
    }

    public void setInitialissuedate(Date initialissuedate) {
        this.initialissuedate = initialissuedate;
    }

    public Boolean getCalculateinitialpaymentdate() {
        return calculateinitialpaymentdate;
    }

    public void setCalculateinitialpaymentdate(Boolean calculateinitialpaymentdate) {
        this.calculateinitialpaymentdate = calculateinitialpaymentdate;
    }

    public Date getInitialpaymentdate() {
        return initialpaymentdate;
    }

    public void setInitialpaymentdate(Date initialpaymentdate) {
        this.initialpaymentdate = initialpaymentdate;
    }

    public Integer getLoantermvalue() {
        return loantermvalue;
    }

    public void setLoantermvalue(Integer loantermvalue) {
        this.loantermvalue = loantermvalue;
    }

    public Integer getPeriodedefferedvalue() {
        return periodedefferedvalue;
    }

    public void setPeriodedefferedvalue(Integer periodedefferedvalue) {
        this.periodedefferedvalue = periodedefferedvalue;
    }

    public String getBalloonpaymenttype() {
        return balloonpaymenttype;
    }

    public void setBalloonpaymenttype(String balloonpaymenttype) {
        this.balloonpaymenttype = balloonpaymenttype;
    }

    public Double getBalloonpaymentvalue() {
        return balloonpaymentvalue;
    }

    public void setBalloonpaymentvalue(Double balloonpaymentvalue) {
        this.balloonpaymentvalue = balloonpaymentvalue;
    }

    public Double getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(Double downpayment) {
        this.downpayment = downpayment;
    }

    public Boolean getUsecapitalization() {
        return usecapitalization;
    }

    public void setUsecapitalization(Boolean usecapitalization) {
        this.usecapitalization = usecapitalization;
    }

    public Integer getInsuranceprovider() {
        return insuranceprovider;
    }

    public void setInsuranceprovider(Integer insuranceprovider) {
        this.insuranceprovider = insuranceprovider;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDefinitionrating() {
        return definitionrating;
    }

    public void setDefinitionrating(String definitionrating) {
        this.definitionrating = definitionrating;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public Boolean getUsecollateral() {
        return usecollateral;
    }

    public void setUsecollateral(Boolean usecollateral) {
        this.usecollateral = usecollateral;
    }

    public String getSourceoffund() {
        return sourceoffund;
    }

    public void setSourceoffund(String sourceoffund) {
        this.sourceoffund = sourceoffund;
    }

    public Integer getSourceoffundvalue() {
        return sourceoffundvalue;
    }

    public void setSourceoffundvalue(Integer sourceoffundvalue) {
        this.sourceoffundvalue = sourceoffundvalue;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getLoanterm() {
        return loanterm;
    }

    public void setLoanterm(String loanterm) {
        this.loanterm = loanterm;
    }

    public Date getMaturitydate() {
        return maturitydate;
    }

    public void setMaturitydate(Date maturitydate) {
        this.maturitydate = maturitydate;
    }

    public String getDaycountfraction() {
        return daycountfraction;
    }

    public void setDaycountfraction(String daycountfraction) {
        this.daycountfraction = daycountfraction;
    }

    public Boolean getUserepaymentlevel() {
        return userepaymentlevel;
    }

    public void setUserepaymentlevel(Boolean userepaymentlevel) {
        this.userepaymentlevel = userepaymentlevel;
    }

    public Character getPeriodedeffered() {
        return periodedeffered;
    }

    public void setPeriodedeffered(Character periodedeffered) {
        this.periodedeffered = periodedeffered;
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

    public String getInsurancetype() {
        return insurancetype;
    }

    public void setInsurancetype(String insurancetype) {
        this.insurancetype = insurancetype;
    }

    public String getPolisnumber() {
        return polisnumber;
    }

    public void setPolisnumber(String polisnumber) {
        this.polisnumber = polisnumber;
    }

    public Date getInsurancedate() {
        return insurancedate;
    }

    public void setInsurancedate(Date insurancedate) {
        this.insurancedate = insurancedate;
    }

    public String getInsurancevaluetype() {
        return insurancevaluetype;
    }

    public void setInsurancevaluetype(String insurancevaluetype) {
        this.insurancevaluetype = insurancevaluetype;
    }

    public Double getInsurancevalue() {
        return insurancevalue;
    }

    public void setInsurancevalue(Double insurancevalue) {
        this.insurancevalue = insurancevalue;
    }

    public Date getMaturityinsurance() {
        return maturityinsurance;
    }

    public void setMaturityinsurance(Date maturityinsurance) {
        this.maturityinsurance = maturityinsurance;
    }

    public Date getClaimdate() {
        return claimdate;
    }

    public void setClaimdate(Date claimdate) {
        this.claimdate = claimdate;
    }

    public Double getClaimvalue() {
        return claimvalue;
    }

    public void setClaimvalue(Double claimvalue) {
        this.claimvalue = claimvalue;
    }

    public Date getClaimpaymentdate() {
        return claimpaymentdate;
    }

    public void setClaimpaymentdate(Date claimpaymentdate) {
        this.claimpaymentdate = claimpaymentdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapitalizationaccount() {
        return capitalizationaccount;
    }

    public void setCapitalizationaccount(Integer capitalizationaccount) {
        this.capitalizationaccount = capitalizationaccount;
    }

    public Double getCapitalizationvalue() {
        return capitalizationvalue;
    }

    public void setCapitalizationvalue(Double capitalizationvalue) {
        this.capitalizationvalue = capitalizationvalue;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCapitalizationtype() {
        return capitalizationtype;
    }

    public void setCapitalizationtype(String capitalizationtype) {
        this.capitalizationtype = capitalizationtype;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getEditor() {
        return editor;
    }

    public void setEditor(Integer editor) {
        this.editor = editor;
    }

    public String getCapitalizationpayment() {
        return capitalizationpayment;
    }

    public void setCapitalizationpayment(String capitalizationpayment) {
        this.capitalizationpayment = capitalizationpayment;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
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

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Boolean getDisbrusmentstatus() {
        return disbrusmentstatus;
    }

    public void setDisbrusmentstatus(Boolean disbrusmentstatus) {
        this.disbrusmentstatus = disbrusmentstatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getTransfertomaker() {
        return transfertomaker;
    }

    public void setTransfertomaker(Integer transfertomaker) {
        this.transfertomaker = transfertomaker;
    }

    public Boolean getUseinsurancemaker() {
        return useinsurancemaker;
    }

    public void setUseinsurancemaker(Boolean useinsurancemaker) {
        this.useinsurancemaker = useinsurancemaker;
    }

    public Integer getLoanreasonmaker() {
        return loanreasonmaker;
    }

    public void setLoanreasonmaker(Integer loanreasonmaker) {
        this.loanreasonmaker = loanreasonmaker;
    }

    public Boolean getUseguarantormaker() {
        return useguarantormaker;
    }

    public void setUseguarantormaker(Boolean useguarantormaker) {
        this.useguarantormaker = useguarantormaker;
    }

    public Integer getRefinancereasonmaker() {
        return refinancereasonmaker;
    }

    public void setRefinancereasonmaker(Integer refinancereasonmaker) {
        this.refinancereasonmaker = refinancereasonmaker;
    }

    public Double getOpenbalancemaker() {
        return openbalancemaker;
    }

    public void setOpenbalancemaker(Double openbalancemaker) {
        this.openbalancemaker = openbalancemaker;
    }

    public Double getClosebalancemaker() {
        return closebalancemaker;
    }

    public void setClosebalancemaker(Double closebalancemaker) {
        this.closebalancemaker = closebalancemaker;
    }

    public Double getRepaymentmaker() {
        return repaymentmaker;
    }

    public void setRepaymentmaker(Double repaymentmaker) {
        this.repaymentmaker = repaymentmaker;
    }

    public Date getInitialissuedatemaker() {
        return initialissuedatemaker;
    }

    public void setInitialissuedatemaker(Date initialissuedatemaker) {
        this.initialissuedatemaker = initialissuedatemaker;
    }

    public Boolean getCalculateinitialpaymentdatemaker() {
        return calculateinitialpaymentdatemaker;
    }

    public void setCalculateinitialpaymentdatemaker(Boolean calculateinitialpaymentdatemaker) {
        this.calculateinitialpaymentdatemaker = calculateinitialpaymentdatemaker;
    }

    public Date getInitialpaymentdatemaker() {
        return initialpaymentdatemaker;
    }

    public void setInitialpaymentdatemaker(Date initialpaymentdatemaker) {
        this.initialpaymentdatemaker = initialpaymentdatemaker;
    }

    public Integer getLoantermvaluemaker() {
        return loantermvaluemaker;
    }

    public void setLoantermvaluemaker(Integer loantermvaluemaker) {
        this.loantermvaluemaker = loantermvaluemaker;
    }

    public Integer getPeriodedefferedvaluemaker() {
        return periodedefferedvaluemaker;
    }

    public void setPeriodedefferedvaluemaker(Integer periodedefferedvaluemaker) {
        this.periodedefferedvaluemaker = periodedefferedvaluemaker;
    }

    public String getBalloonpaymenttypemaker() {
        return balloonpaymenttypemaker;
    }

    public void setBalloonpaymenttypemaker(String balloonpaymenttypemaker) {
        this.balloonpaymenttypemaker = balloonpaymenttypemaker;
    }

    public Double getBalloonpaymentvaluemaker() {
        return balloonpaymentvaluemaker;
    }

    public void setBalloonpaymentvaluemaker(Double balloonpaymentvaluemaker) {
        this.balloonpaymentvaluemaker = balloonpaymentvaluemaker;
    }

    public Double getDownpaymentmaker() {
        return downpaymentmaker;
    }

    public void setDownpaymentmaker(Double downpaymentmaker) {
        this.downpaymentmaker = downpaymentmaker;
    }

    public Boolean getUsecapitalizationmaker() {
        return usecapitalizationmaker;
    }

    public void setUsecapitalizationmaker(Boolean usecapitalizationmaker) {
        this.usecapitalizationmaker = usecapitalizationmaker;
    }

    public Integer getInsuranceprovidermaker() {
        return insuranceprovidermaker;
    }

    public void setInsuranceprovidermaker(Integer insuranceprovidermaker) {
        this.insuranceprovidermaker = insuranceprovidermaker;
    }

    public Integer getTotalscoremaker() {
        return totalscoremaker;
    }

    public void setTotalscoremaker(Integer totalscoremaker) {
        this.totalscoremaker = totalscoremaker;
    }

    public String getGrademaker() {
        return grademaker;
    }

    public void setGrademaker(String grademaker) {
        this.grademaker = grademaker;
    }

    public String getDefinitionratingmaker() {
        return definitionratingmaker;
    }

    public void setDefinitionratingmaker(String definitionratingmaker) {
        this.definitionratingmaker = definitionratingmaker;
    }

    public String getCheckermaker() {
        return checkermaker;
    }

    public void setCheckermaker(String checkermaker) {
        this.checkermaker = checkermaker;
    }

    public String getApprovalmaker() {
        return approvalmaker;
    }

    public void setApprovalmaker(String approvalmaker) {
        this.approvalmaker = approvalmaker;
    }

    public Boolean getUsecollateralmaker() {
        return usecollateralmaker;
    }

    public void setUsecollateralmaker(Boolean usecollateralmaker) {
        this.usecollateralmaker = usecollateralmaker;
    }

    public String getSourceoffundmaker() {
        return sourceoffundmaker;
    }

    public void setSourceoffundmaker(String sourceoffundmaker) {
        this.sourceoffundmaker = sourceoffundmaker;
    }

    public Integer getSourceoffundvaluemaker() {
        return sourceoffundvaluemaker;
    }

    public void setSourceoffundvaluemaker(Integer sourceoffundvaluemaker) {
        this.sourceoffundvaluemaker = sourceoffundvaluemaker;
    }

    public Integer getGroupidmaker() {
        return groupidmaker;
    }

    public void setGroupidmaker(Integer groupidmaker) {
        this.groupidmaker = groupidmaker;
    }

    public String getLoantermmaker() {
        return loantermmaker;
    }

    public void setLoantermmaker(String loantermmaker) {
        this.loantermmaker = loantermmaker;
    }

    public Date getMaturitydatemaker() {
        return maturitydatemaker;
    }

    public void setMaturitydatemaker(Date maturitydatemaker) {
        this.maturitydatemaker = maturitydatemaker;
    }

    public String getDaycountfractionmaker() {
        return daycountfractionmaker;
    }

    public void setDaycountfractionmaker(String daycountfractionmaker) {
        this.daycountfractionmaker = daycountfractionmaker;
    }

    public Boolean getUserepaymentlevelmaker() {
        return userepaymentlevelmaker;
    }

    public void setUserepaymentlevelmaker(Boolean userepaymentlevelmaker) {
        this.userepaymentlevelmaker = userepaymentlevelmaker;
    }

    public Character getPeriodedefferedmaker() {
        return periodedefferedmaker;
    }

    public void setPeriodedefferedmaker(Character periodedefferedmaker) {
        this.periodedefferedmaker = periodedefferedmaker;
    }

    public Date getCreationdatemaker() {
        return creationdatemaker;
    }

    public void setCreationdatemaker(Date creationdatemaker) {
        this.creationdatemaker = creationdatemaker;
    }

    public Date getEditdatemaker() {
        return editdatemaker;
    }

    public void setEditdatemaker(Date editdatemaker) {
        this.editdatemaker = editdatemaker;
    }

    public String getInsurancetypemaker() {
        return insurancetypemaker;
    }

    public void setInsurancetypemaker(String insurancetypemaker) {
        this.insurancetypemaker = insurancetypemaker;
    }

    public String getPolisnumbermaker() {
        return polisnumbermaker;
    }

    public void setPolisnumbermaker(String polisnumbermaker) {
        this.polisnumbermaker = polisnumbermaker;
    }

    public Date getInsurancedatemaker() {
        return insurancedatemaker;
    }

    public void setInsurancedatemaker(Date insurancedatemaker) {
        this.insurancedatemaker = insurancedatemaker;
    }

    public String getInsurancevaluetypemaker() {
        return insurancevaluetypemaker;
    }

    public void setInsurancevaluetypemaker(String insurancevaluetypemaker) {
        this.insurancevaluetypemaker = insurancevaluetypemaker;
    }

    public Double getInsurancevaluemaker() {
        return insurancevaluemaker;
    }

    public void setInsurancevaluemaker(Double insurancevaluemaker) {
        this.insurancevaluemaker = insurancevaluemaker;
    }

    public Date getMaturityinsurancemaker() {
        return maturityinsurancemaker;
    }

    public void setMaturityinsurancemaker(Date maturityinsurancemaker) {
        this.maturityinsurancemaker = maturityinsurancemaker;
    }

    public Date getClaimdatemaker() {
        return claimdatemaker;
    }

    public void setClaimdatemaker(Date claimdatemaker) {
        this.claimdatemaker = claimdatemaker;
    }

    public Double getClaimvaluemaker() {
        return claimvaluemaker;
    }

    public void setClaimvaluemaker(Double claimvaluemaker) {
        this.claimvaluemaker = claimvaluemaker;
    }

    public Date getClaimpaymentdatemaker() {
        return claimpaymentdatemaker;
    }

    public void setClaimpaymentdatemaker(Date claimpaymentdatemaker) {
        this.claimpaymentdatemaker = claimpaymentdatemaker;
    }

    public String getDescriptionmaker() {
        return descriptionmaker;
    }

    public void setDescriptionmaker(String descriptionmaker) {
        this.descriptionmaker = descriptionmaker;
    }

    public Integer getCapitalizationaccountmaker() {
        return capitalizationaccountmaker;
    }

    public void setCapitalizationaccountmaker(Integer capitalizationaccountmaker) {
        this.capitalizationaccountmaker = capitalizationaccountmaker;
    }

    public Double getCapitalizationvaluemaker() {
        return capitalizationvaluemaker;
    }

    public void setCapitalizationvaluemaker(Double capitalizationvaluemaker) {
        this.capitalizationvaluemaker = capitalizationvaluemaker;
    }

    public String getDocumentmaker() {
        return documentmaker;
    }

    public void setDocumentmaker(String documentmaker) {
        this.documentmaker = documentmaker;
    }

    public String getCapitalizationtypemaker() {
        return capitalizationtypemaker;
    }

    public void setCapitalizationtypemaker(String capitalizationtypemaker) {
        this.capitalizationtypemaker = capitalizationtypemaker;
    }

    public Integer getCreatormaker() {
        return creatormaker;
    }

    public void setCreatormaker(Integer creatormaker) {
        this.creatormaker = creatormaker;
    }

    public Integer getEditormaker() {
        return editormaker;
    }

    public void setEditormaker(Integer editormaker) {
        this.editormaker = editormaker;
    }

    public String getCapitalizationpaymentmaker() {
        return capitalizationpaymentmaker;
    }

    public void setCapitalizationpaymentmaker(String capitalizationpaymentmaker) {
        this.capitalizationpaymentmaker = capitalizationpaymentmaker;
    }

    public Double getInterestmaker() {
        return interestmaker;
    }

    public void setInterestmaker(Double interestmaker) {
        this.interestmaker = interestmaker;
    }

    public Double getBalancemaker() {
        return balancemaker;
    }

    public void setBalancemaker(Double balancemaker) {
        this.balancemaker = balancemaker;
    }

    public Double getDramountmaker() {
        return dramountmaker;
    }

    public void setDramountmaker(Double dramountmaker) {
        this.dramountmaker = dramountmaker;
    }

    public Integer getAccountofficermaker() {
        return accountofficermaker;
    }

    public void setAccountofficermaker(Integer accountofficermaker) {
        this.accountofficermaker = accountofficermaker;
    }

    public Integer getLoanidmaker() {
        return loanidmaker;
    }

    public void setLoanidmaker(Integer loanidmaker) {
        this.loanidmaker = loanidmaker;
    }

    public Integer getCustomeridmaker() {
        return customeridmaker;
    }

    public void setCustomeridmaker(Integer customeridmaker) {
        this.customeridmaker = customeridmaker;
    }

    public Boolean getDisbrusmentstatusmaker() {
        return disbrusmentstatusmaker;
    }

    public void setDisbrusmentstatusmaker(Boolean disbrusmentstatusmaker) {
        this.disbrusmentstatusmaker = disbrusmentstatusmaker;
    }

    public String getStatusmaker() {
        return statusmaker;
    }

    public void setStatusmaker(String statusmaker) {
        this.statusmaker = statusmaker;
    }

    public Integer getRestructureidmaker() {
        return restructureidmaker;
    }

    public void setRestructureidmaker(Integer restructureidmaker) {
        this.restructureidmaker = restructureidmaker;
    }

    public Date getSessiondatemaker() {
        return sessiondatemaker;
    }

    public void setSessiondatemaker(Date sessiondatemaker) {
        this.sessiondatemaker = sessiondatemaker;
    }

    public Integer getTransfertochecker() {
        return transfertochecker;
    }

    public void setTransfertochecker(Integer transfertochecker) {
        this.transfertochecker = transfertochecker;
    }

    public Boolean getUseinsurancechecker() {
        return useinsurancechecker;
    }

    public void setUseinsurancechecker(Boolean useinsurancechecker) {
        this.useinsurancechecker = useinsurancechecker;
    }

    public Integer getLoanreasonchecker() {
        return loanreasonchecker;
    }

    public void setLoanreasonchecker(Integer loanreasonchecker) {
        this.loanreasonchecker = loanreasonchecker;
    }

    public Boolean getUseguarantorchecker() {
        return useguarantorchecker;
    }

    public void setUseguarantorchecker(Boolean useguarantorchecker) {
        this.useguarantorchecker = useguarantorchecker;
    }

    public Integer getRefinancereasonchecker() {
        return refinancereasonchecker;
    }

    public void setRefinancereasonchecker(Integer refinancereasonchecker) {
        this.refinancereasonchecker = refinancereasonchecker;
    }

    public Double getOpenbalancechecker() {
        return openbalancechecker;
    }

    public void setOpenbalancechecker(Double openbalancechecker) {
        this.openbalancechecker = openbalancechecker;
    }

    public Double getClosebalancechecker() {
        return closebalancechecker;
    }

    public void setClosebalancechecker(Double closebalancechecker) {
        this.closebalancechecker = closebalancechecker;
    }

    public Double getRepaymentchecker() {
        return repaymentchecker;
    }

    public void setRepaymentchecker(Double repaymentchecker) {
        this.repaymentchecker = repaymentchecker;
    }

    public Date getInitialissuedatechecker() {
        return initialissuedatechecker;
    }

    public void setInitialissuedatechecker(Date initialissuedatechecker) {
        this.initialissuedatechecker = initialissuedatechecker;
    }

    public Boolean getCalculateinitialpaymentdatechecker() {
        return calculateinitialpaymentdatechecker;
    }

    public void setCalculateinitialpaymentdatechecker(Boolean calculateinitialpaymentdatechecker) {
        this.calculateinitialpaymentdatechecker = calculateinitialpaymentdatechecker;
    }

    public Date getInitialpaymentdatechecker() {
        return initialpaymentdatechecker;
    }

    public void setInitialpaymentdatechecker(Date initialpaymentdatechecker) {
        this.initialpaymentdatechecker = initialpaymentdatechecker;
    }

    public Integer getLoantermvaluechecker() {
        return loantermvaluechecker;
    }

    public void setLoantermvaluechecker(Integer loantermvaluechecker) {
        this.loantermvaluechecker = loantermvaluechecker;
    }

    public Integer getPeriodedefferedvaluechecker() {
        return periodedefferedvaluechecker;
    }

    public void setPeriodedefferedvaluechecker(Integer periodedefferedvaluechecker) {
        this.periodedefferedvaluechecker = periodedefferedvaluechecker;
    }

    public String getBalloonpaymenttypechecker() {
        return balloonpaymenttypechecker;
    }

    public void setBalloonpaymenttypechecker(String balloonpaymenttypechecker) {
        this.balloonpaymenttypechecker = balloonpaymenttypechecker;
    }

    public Double getBalloonpaymentvaluechecker() {
        return balloonpaymentvaluechecker;
    }

    public void setBalloonpaymentvaluechecker(Double balloonpaymentvaluechecker) {
        this.balloonpaymentvaluechecker = balloonpaymentvaluechecker;
    }

    public Double getDownpaymentchecker() {
        return downpaymentchecker;
    }

    public void setDownpaymentchecker(Double downpaymentchecker) {
        this.downpaymentchecker = downpaymentchecker;
    }

    public Boolean getUsecapitalizationchecker() {
        return usecapitalizationchecker;
    }

    public void setUsecapitalizationchecker(Boolean usecapitalizationchecker) {
        this.usecapitalizationchecker = usecapitalizationchecker;
    }

    public Integer getInsuranceproviderchecker() {
        return insuranceproviderchecker;
    }

    public void setInsuranceproviderchecker(Integer insuranceproviderchecker) {
        this.insuranceproviderchecker = insuranceproviderchecker;
    }

    public Integer getTotalscorechecker() {
        return totalscorechecker;
    }

    public void setTotalscorechecker(Integer totalscorechecker) {
        this.totalscorechecker = totalscorechecker;
    }

    public String getGradechecker() {
        return gradechecker;
    }

    public void setGradechecker(String gradechecker) {
        this.gradechecker = gradechecker;
    }

    public String getDefinitionratingchecker() {
        return definitionratingchecker;
    }

    public void setDefinitionratingchecker(String definitionratingchecker) {
        this.definitionratingchecker = definitionratingchecker;
    }

    public String getCheckerchecker() {
        return checkerchecker;
    }

    public void setCheckerchecker(String checkerchecker) {
        this.checkerchecker = checkerchecker;
    }

    public String getApprovalchecker() {
        return approvalchecker;
    }

    public void setApprovalchecker(String approvalchecker) {
        this.approvalchecker = approvalchecker;
    }

    public Boolean getUsecollateralchecker() {
        return usecollateralchecker;
    }

    public void setUsecollateralchecker(Boolean usecollateralchecker) {
        this.usecollateralchecker = usecollateralchecker;
    }

    public String getSourceoffundchecker() {
        return sourceoffundchecker;
    }

    public void setSourceoffundchecker(String sourceoffundchecker) {
        this.sourceoffundchecker = sourceoffundchecker;
    }

    public Integer getSourceoffundvaluechecker() {
        return sourceoffundvaluechecker;
    }

    public void setSourceoffundvaluechecker(Integer sourceoffundvaluechecker) {
        this.sourceoffundvaluechecker = sourceoffundvaluechecker;
    }

    public Integer getGroupidchecker() {
        return groupidchecker;
    }

    public void setGroupidchecker(Integer groupidchecker) {
        this.groupidchecker = groupidchecker;
    }

    public String getLoantermchecker() {
        return loantermchecker;
    }

    public void setLoantermchecker(String loantermchecker) {
        this.loantermchecker = loantermchecker;
    }

    public Date getMaturitydatechecker() {
        return maturitydatechecker;
    }

    public void setMaturitydatechecker(Date maturitydatechecker) {
        this.maturitydatechecker = maturitydatechecker;
    }

    public String getDaycountfractionchecker() {
        return daycountfractionchecker;
    }

    public void setDaycountfractionchecker(String daycountfractionchecker) {
        this.daycountfractionchecker = daycountfractionchecker;
    }

    public Boolean getUserepaymentlevelchecker() {
        return userepaymentlevelchecker;
    }

    public void setUserepaymentlevelchecker(Boolean userepaymentlevelchecker) {
        this.userepaymentlevelchecker = userepaymentlevelchecker;
    }

    public Character getPeriodedefferedchecker() {
        return periodedefferedchecker;
    }

    public void setPeriodedefferedchecker(Character periodedefferedchecker) {
        this.periodedefferedchecker = periodedefferedchecker;
    }

    public Date getCreationdatechecker() {
        return creationdatechecker;
    }

    public void setCreationdatechecker(Date creationdatechecker) {
        this.creationdatechecker = creationdatechecker;
    }

    public Date getEditdatechecker() {
        return editdatechecker;
    }

    public void setEditdatechecker(Date editdatechecker) {
        this.editdatechecker = editdatechecker;
    }

    public String getInsurancetypechecker() {
        return insurancetypechecker;
    }

    public void setInsurancetypechecker(String insurancetypechecker) {
        this.insurancetypechecker = insurancetypechecker;
    }

    public String getPolisnumberchecker() {
        return polisnumberchecker;
    }

    public void setPolisnumberchecker(String polisnumberchecker) {
        this.polisnumberchecker = polisnumberchecker;
    }

    public Date getInsurancedatechecker() {
        return insurancedatechecker;
    }

    public void setInsurancedatechecker(Date insurancedatechecker) {
        this.insurancedatechecker = insurancedatechecker;
    }

    public String getInsurancevaluetypechecker() {
        return insurancevaluetypechecker;
    }

    public void setInsurancevaluetypechecker(String insurancevaluetypechecker) {
        this.insurancevaluetypechecker = insurancevaluetypechecker;
    }

    public Double getInsurancevaluechecker() {
        return insurancevaluechecker;
    }

    public void setInsurancevaluechecker(Double insurancevaluechecker) {
        this.insurancevaluechecker = insurancevaluechecker;
    }

    public Date getMaturityinsurancechecker() {
        return maturityinsurancechecker;
    }

    public void setMaturityinsurancechecker(Date maturityinsurancechecker) {
        this.maturityinsurancechecker = maturityinsurancechecker;
    }

    public Date getClaimdatechecker() {
        return claimdatechecker;
    }

    public void setClaimdatechecker(Date claimdatechecker) {
        this.claimdatechecker = claimdatechecker;
    }

    public Double getClaimvaluechecker() {
        return claimvaluechecker;
    }

    public void setClaimvaluechecker(Double claimvaluechecker) {
        this.claimvaluechecker = claimvaluechecker;
    }

    public Date getClaimpaymentdatechecker() {
        return claimpaymentdatechecker;
    }

    public void setClaimpaymentdatechecker(Date claimpaymentdatechecker) {
        this.claimpaymentdatechecker = claimpaymentdatechecker;
    }

    public String getDescriptionchecker() {
        return descriptionchecker;
    }

    public void setDescriptionchecker(String descriptionchecker) {
        this.descriptionchecker = descriptionchecker;
    }

    public Integer getCapitalizationaccountchecker() {
        return capitalizationaccountchecker;
    }

    public void setCapitalizationaccountchecker(Integer capitalizationaccountchecker) {
        this.capitalizationaccountchecker = capitalizationaccountchecker;
    }

    public Double getCapitalizationvaluechecker() {
        return capitalizationvaluechecker;
    }

    public void setCapitalizationvaluechecker(Double capitalizationvaluechecker) {
        this.capitalizationvaluechecker = capitalizationvaluechecker;
    }

    public String getDocumentchecker() {
        return documentchecker;
    }

    public void setDocumentchecker(String documentchecker) {
        this.documentchecker = documentchecker;
    }

    public String getCapitalizationtypechecker() {
        return capitalizationtypechecker;
    }

    public void setCapitalizationtypechecker(String capitalizationtypechecker) {
        this.capitalizationtypechecker = capitalizationtypechecker;
    }

    public Integer getCreatorchecker() {
        return creatorchecker;
    }

    public void setCreatorchecker(Integer creatorchecker) {
        this.creatorchecker = creatorchecker;
    }

    public Integer getEditorchecker() {
        return editorchecker;
    }

    public void setEditorchecker(Integer editorchecker) {
        this.editorchecker = editorchecker;
    }

    public String getCapitalizationpaymentchecker() {
        return capitalizationpaymentchecker;
    }

    public void setCapitalizationpaymentchecker(String capitalizationpaymentchecker) {
        this.capitalizationpaymentchecker = capitalizationpaymentchecker;
    }

    public Double getInterestchecker() {
        return interestchecker;
    }

    public void setInterestchecker(Double interestchecker) {
        this.interestchecker = interestchecker;
    }

    public Double getBalancechecker() {
        return balancechecker;
    }

    public void setBalancechecker(Double balancechecker) {
        this.balancechecker = balancechecker;
    }

    public Double getDramountchecker() {
        return dramountchecker;
    }

    public void setDramountchecker(Double dramountchecker) {
        this.dramountchecker = dramountchecker;
    }

    public Integer getAccountofficerchecker() {
        return accountofficerchecker;
    }

    public void setAccountofficerchecker(Integer accountofficerchecker) {
        this.accountofficerchecker = accountofficerchecker;
    }

    public Integer getLoanidchecker() {
        return loanidchecker;
    }

    public void setLoanidchecker(Integer loanidchecker) {
        this.loanidchecker = loanidchecker;
    }

    public Integer getCustomeridchecker() {
        return customeridchecker;
    }

    public void setCustomeridchecker(Integer customeridchecker) {
        this.customeridchecker = customeridchecker;
    }

    public Boolean getDisbrusmentstatuschecker() {
        return disbrusmentstatuschecker;
    }

    public void setDisbrusmentstatuschecker(Boolean disbrusmentstatuschecker) {
        this.disbrusmentstatuschecker = disbrusmentstatuschecker;
    }

    public String getStatuschecker() {
        return statuschecker;
    }

    public void setStatuschecker(String statuschecker) {
        this.statuschecker = statuschecker;
    }

    public Integer getRestructureidchecker() {
        return restructureidchecker;
    }

    public void setRestructureidchecker(Integer restructureidchecker) {
        this.restructureidchecker = restructureidchecker;
    }

    public Date getSessiondatechecker() {
        return sessiondatechecker;
    }

    public void setSessiondatechecker(Date sessiondatechecker) {
        this.sessiondatechecker = sessiondatechecker;
    }

    public Date getApprovaldate() {
        return approvaldate;
    }

    public void setApprovaldate(Date approvaldate) {
        this.approvaldate = approvaldate;
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
        hash += (loanapplicationid != null ? loanapplicationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loanapplication)) {
            return false;
        }
        Loanapplication other = (Loanapplication) object;
        if ((this.loanapplicationid == null && other.loanapplicationid != null) || (this.loanapplicationid != null && !this.loanapplicationid.equals(other.loanapplicationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Loanapplication[ loanapplicationid=" + loanapplicationid + " ]";
    }

}
