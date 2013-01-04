/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.lumbajxlite.ejbs.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid"),
    @NamedQuery(name = "Customer.findByCustomercode", query = "SELECT c FROM Customer c WHERE c.customercode = :customercode"),
    @NamedQuery(name = "Customer.findByCustomeraccount", query = "SELECT c FROM Customer c WHERE c.customeraccount = :customeraccount"),
    @NamedQuery(name = "Customer.findByOpendate", query = "SELECT c FROM Customer c WHERE c.opendate = :opendate"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Customer.findByAliasname", query = "SELECT c FROM Customer c WHERE c.aliasname = :aliasname"),
    @NamedQuery(name = "Customer.findByCitizen", query = "SELECT c FROM Customer c WHERE c.citizen = :citizen"),
    @NamedQuery(name = "Customer.findByIsbank", query = "SELECT c FROM Customer c WHERE c.isbank = :isbank"),
    @NamedQuery(name = "Customer.findByBankdetail", query = "SELECT c FROM Customer c WHERE c.bankdetail = :bankdetail"),
    @NamedQuery(name = "Customer.findBySwiftid", query = "SELECT c FROM Customer c WHERE c.swiftid = :swiftid"),
    @NamedQuery(name = "Customer.findByIspubliccompany", query = "SELECT c FROM Customer c WHERE c.ispubliccompany = :ispubliccompany"),
    @NamedQuery(name = "Customer.findByCreationdate", query = "SELECT c FROM Customer c WHERE c.creationdate = :creationdate"),
    @NamedQuery(name = "Customer.findByEditdate", query = "SELECT c FROM Customer c WHERE c.editdate = :editdate"),
    @NamedQuery(name = "Customer.findByCompanynameInstitution", query = "SELECT c FROM Customer c WHERE c.companynameInstitution = :companynameInstitution"),
    @NamedQuery(name = "Customer.findByDegreestatus", query = "SELECT c FROM Customer c WHERE c.degreestatus = :degreestatus"),
    @NamedQuery(name = "Customer.findBySectoreconomy", query = "SELECT c FROM Customer c WHERE c.sectoreconomy = :sectoreconomy"),
    @NamedQuery(name = "Customer.findByApprove", query = "SELECT c FROM Customer c WHERE c.approve = :approve"),
    @NamedQuery(name = "Customer.findBySessiondate", query = "SELECT c FROM Customer c WHERE c.sessiondate = :sessiondate"),
    @NamedQuery(name = "Customer.findByCreator", query = "SELECT c FROM Customer c WHERE c.creator = :creator"),
    @NamedQuery(name = "Customer.findByEditor", query = "SELECT c FROM Customer c WHERE c.editor = :editor"),
    @NamedQuery(name = "Customer.findByName1", query = "SELECT c FROM Customer c WHERE c.name1 = :name1"),
    @NamedQuery(name = "Customer.findByName2", query = "SELECT c FROM Customer c WHERE c.name2 = :name2"),
    @NamedQuery(name = "Customer.findByName3", query = "SELECT c FROM Customer c WHERE c.name3 = :name3"),
    @NamedQuery(name = "Customer.findByName4", query = "SELECT c FROM Customer c WHERE c.name4 = :name4"),
    @NamedQuery(name = "Customer.findByDegreedesc", query = "SELECT c FROM Customer c WHERE c.degreedesc = :degreedesc"),
    @NamedQuery(name = "Customer.findByCustomertype", query = "SELECT c FROM Customer c WHERE c.customertype = :customertype"),
    @NamedQuery(name = "Customer.findByPhotoid", query = "SELECT c FROM Customer c WHERE c.photoid = :photoid"),
    @NamedQuery(name = "Customer.findBySignatureid", query = "SELECT c FROM Customer c WHERE c.signatureid = :signatureid"),
    @NamedQuery(name = "Customer.findByMembertype", query = "SELECT c FROM Customer c WHERE c.membertype = :membertype"),
    @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer customerid;
    @Size(max = 12)
    @Column(length = 12)
    private String customercode;
    @Size(max = 12)
    @Column(length = 12)
    private String customeraccount;
    @Temporal(TemporalType.DATE)
    private Date opendate;
    @Size(max = 50)
    @Column(length = 50)
    private String firstname;
    @Size(max = 50)
    @Column(length = 50)
    private String lastname;
    @Size(max = 50)
    @Column(length = 50)
    private String aliasname;
    private Character citizen;
    private Boolean isbank;
    private Boolean bankdetail;
    @Size(max = 8)
    @Column(length = 8)
    private String swiftid;
    private Boolean ispubliccompany;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 50)
    @Column(name = "companyname_institution", length = 50)
    private String companynameInstitution;
    private Integer degreestatus;
    private Integer sectoreconomy;
    private Boolean approve;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    private Integer creator;
    private Integer editor;
    @Size(max = 20)
    @Column(length = 20)
    private String name1;
    @Size(max = 20)
    @Column(length = 20)
    private String name2;
    @Size(max = 20)
    @Column(length = 20)
    private String name3;
    @Size(max = 20)
    @Column(length = 20)
    private String name4;
    private Integer degreedesc;
    private Integer customertype;
    private Integer photoid;
    private Integer signatureid;
    private Character membertype;
    private Boolean status;
    @OneToOne(mappedBy = "customerid")
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Customermanagement> customermanagementList;
    @JoinColumn(name = "companytype", referencedColumnName = "parameterid")
    @ManyToOne
    private Parameter companytype;
    @JoinColumn(name = "institution", referencedColumnName = "parameterid")
    @ManyToOne
    private Parameter institution;
    @JoinColumn(name = "othertypeinstitution", referencedColumnName = "parameterid")
    @ManyToOne
    private Parameter othertypeinstitution;
    @JoinColumn(name = "legal", referencedColumnName = "parameterid")
    @ManyToOne
    private Parameter legal;
    @JoinColumn(name = "organizationid", referencedColumnName = "organizationid")
    @ManyToOne
    private Organization organizationid;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private Operatoruser userid;
    @JoinColumn(name = "masteroperationalid", referencedColumnName = "masteroperationalid")
    @ManyToOne
    private Masteroperational masteroperationalid;
    @JoinColumn(name = "countryid", referencedColumnName = "countryid")
    @ManyToOne
    private Country countryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Account> accountList;

    public Customer() {
        companytype = new Parameter();
        countryid = new Country();
        institution = new Parameter();
        legal = new Parameter();
        masteroperationalid = new Masteroperational();
        organizationid = new Organization();
        othertypeinstitution = new Parameter();
        person = new Person();
        userid = new Operatoruser();
    }

    public Customer(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode;
    }

    public String getCustomeraccount() {
        return customeraccount;
    }

    public void setCustomeraccount(String customeraccount) {
        this.customeraccount = customeraccount;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public Character getCitizen() {
        return citizen;
    }

    public void setCitizen(Character citizen) {
        this.citizen = citizen;
    }

    public Boolean getIsbank() {
        return isbank;
    }

    public void setIsbank(Boolean isbank) {
        this.isbank = isbank;
    }

    public Boolean getBankdetail() {
        return bankdetail;
    }

    public void setBankdetail(Boolean bankdetail) {
        this.bankdetail = bankdetail;
    }

    public String getSwiftid() {
        return swiftid;
    }

    public void setSwiftid(String swiftid) {
        this.swiftid = swiftid;
    }

    public Boolean getIspubliccompany() {
        return ispubliccompany;
    }

    public void setIspubliccompany(Boolean ispubliccompany) {
        this.ispubliccompany = ispubliccompany;
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

    public String getCompanynameInstitution() {
        return companynameInstitution;
    }

    public void setCompanynameInstitution(String companynameInstitution) {
        this.companynameInstitution = companynameInstitution;
    }

    public Integer getDegreestatus() {
        return degreestatus;
    }

    public void setDegreestatus(Integer degreestatus) {
        this.degreestatus = degreestatus;
    }

    public Integer getSectoreconomy() {
        return sectoreconomy;
    }

    public void setSectoreconomy(Integer sectoreconomy) {
        this.sectoreconomy = sectoreconomy;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
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

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public Integer getDegreedesc() {
        return degreedesc;
    }

    public void setDegreedesc(Integer degreedesc) {
        this.degreedesc = degreedesc;
    }

    public Integer getCustomertype() {
        return customertype;
    }

    public void setCustomertype(Integer customertype) {
        this.customertype = customertype;
    }

    public Integer getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public Integer getSignatureid() {
        return signatureid;
    }

    public void setSignatureid(Integer signatureid) {
        this.signatureid = signatureid;
    }

    public Character getMembertype() {
        return membertype;
    }

    public void setMembertype(Character membertype) {
        this.membertype = membertype;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public List<Customermanagement> getCustomermanagementList() {
        return customermanagementList;
    }

    public void setCustomermanagementList(List<Customermanagement> customermanagementList) {
        this.customermanagementList = customermanagementList;
    }

    public Parameter getCompanytype() {
        return companytype;
    }

    public void setCompanytype(Parameter companytype) {
        this.companytype = companytype;
    }

    public Parameter getInstitution() {
        return institution;
    }

    public void setInstitution(Parameter institution) {
        this.institution = institution;
    }

    public Parameter getOthertypeinstitution() {
        return othertypeinstitution;
    }

    public void setOthertypeinstitution(Parameter othertypeinstitution) {
        this.othertypeinstitution = othertypeinstitution;
    }

    public Parameter getLegal() {
        return legal;
    }

    public void setLegal(Parameter legal) {
        this.legal = legal;
    }

    public Organization getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Organization organizationid) {
        this.organizationid = organizationid;
    }

    public Operatoruser getUserid() {
        return userid;
    }

    public void setUserid(Operatoruser userid) {
        this.userid = userid;
    }

    public Masteroperational getMasteroperationalid() {
        return masteroperationalid;
    }

    public void setMasteroperationalid(Masteroperational masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
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
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Customer[ customerid=" + customerid + " ]";
    }
}
