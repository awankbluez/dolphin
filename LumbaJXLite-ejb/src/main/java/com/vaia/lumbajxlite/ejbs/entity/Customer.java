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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @javax.persistence.NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid"),
    @javax.persistence.NamedQuery(name = "Customer.findByCustomercode", query = "SELECT c FROM Customer c WHERE c.customercode = :customercode"),
    @javax.persistence.NamedQuery(name = "Customer.findByCustomeraccount", query = "SELECT c FROM Customer c WHERE c.customeraccount = :customeraccount"),
    @javax.persistence.NamedQuery(name = "Customer.findByOpendate", query = "SELECT c FROM Customer c WHERE c.opendate = :opendate"),
    @javax.persistence.NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status"),
    @javax.persistence.NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @javax.persistence.NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname"),
    @javax.persistence.NamedQuery(name = "Customer.findByAliasname", query = "SELECT c FROM Customer c WHERE c.aliasname = :aliasname"),
    @javax.persistence.NamedQuery(name = "Customer.findByCitizen", query = "SELECT c FROM Customer c WHERE c.citizen = :citizen"),
    @javax.persistence.NamedQuery(name = "Customer.findByIsbank", query = "SELECT c FROM Customer c WHERE c.isbank = :isbank"),
    @javax.persistence.NamedQuery(name = "Customer.findByBankdetail", query = "SELECT c FROM Customer c WHERE c.bankdetail = :bankdetail"),
    @javax.persistence.NamedQuery(name = "Customer.findBySwiftid", query = "SELECT c FROM Customer c WHERE c.swiftid = :swiftid"),
    @javax.persistence.NamedQuery(name = "Customer.findByIspubliccompany", query = "SELECT c FROM Customer c WHERE c.ispubliccompany = :ispubliccompany"),
    @javax.persistence.NamedQuery(name = "Customer.findByCreationdate", query = "SELECT c FROM Customer c WHERE c.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Customer.findByEditdate", query = "SELECT c FROM Customer c WHERE c.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Customer.findByCompanynameInstitution", query = "SELECT c FROM Customer c WHERE c.companynameInstitution = :companynameInstitution"),
    @javax.persistence.NamedQuery(name = "Customer.findByMembertype", query = "SELECT c FROM Customer c WHERE c.membertype = :membertype"),
    @javax.persistence.NamedQuery(name = "Customer.findByDegreestatus", query = "SELECT c FROM Customer c WHERE c.degreestatus = :degreestatus"),
    @javax.persistence.NamedQuery(name = "Customer.findBySectoreconomy", query = "SELECT c FROM Customer c WHERE c.sectoreconomy = :sectoreconomy"),
    @javax.persistence.NamedQuery(name = "Customer.findByApprove", query = "SELECT c FROM Customer c WHERE c.approve = :approve"),
    @javax.persistence.NamedQuery(name = "Customer.findBySessiondate", query = "SELECT c FROM Customer c WHERE c.sessiondate = :sessiondate"),
    @javax.persistence.NamedQuery(name = "Customer.findByCreator", query = "SELECT c FROM Customer c WHERE c.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Customer.findByEditor", query = "SELECT c FROM Customer c WHERE c.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Customer.findByName1", query = "SELECT c FROM Customer c WHERE c.name1 = :name1"),
    @javax.persistence.NamedQuery(name = "Customer.findByName2", query = "SELECT c FROM Customer c WHERE c.name2 = :name2"),
    @javax.persistence.NamedQuery(name = "Customer.findByName3", query = "SELECT c FROM Customer c WHERE c.name3 = :name3"),
    @javax.persistence.NamedQuery(name = "Customer.findByName4", query = "SELECT c FROM Customer c WHERE c.name4 = :name4"),
    @javax.persistence.NamedQuery(name = "Customer.findByDegreedesc", query = "SELECT c FROM Customer c WHERE c.degreedesc = :degreedesc"),
    @javax.persistence.NamedQuery(name = "Customer.findByCustomertype", query = "SELECT c FROM Customer c WHERE c.customertype = :customertype"),
    @javax.persistence.NamedQuery(name = "Customer.findByPhotoid", query = "SELECT c FROM Customer c WHERE c.photoid = :photoid"),
    @javax.persistence.NamedQuery(name = "Customer.findBySignatureid", query = "SELECT c FROM Customer c WHERE c.signatureid = :signatureid")})
public class Customer
        implements Serializable {

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
    private Character status;
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
    private Character membertype;
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
    @OneToOne(mappedBy = "customerid")
    private Person person;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "customerid")
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

    public Customer() {
        this.companytype = new Parameter();
        this.countryid = new Country();
        this.institution = new Parameter();
        this.masteroperationalid = new Masteroperational();
        this.legal = new Parameter();
        this.organizationid = new Organization();
        this.userid = new Operatoruser();
        this.person = new Person();
    }

    public Customer(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getCustomerid() {
        return this.customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomercode() {
        return this.customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode;
    }

    public String getCustomeraccount() {
        return this.customeraccount;
    }

    public void setCustomeraccount(String customeraccount) {
        this.customeraccount = customeraccount;
    }

    public Date getOpendate() {
        return this.opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public Character getStatus() {
        return this.status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAliasname() {
        return this.aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public Character getCitizen() {
        return this.citizen;
    }

    public void setCitizen(Character citizen) {
        this.citizen = citizen;
    }

    public Boolean getIsbank() {
        return this.isbank;
    }

    public void setIsbank(Boolean isbank) {
        this.isbank = isbank;
    }

    public Boolean getBankdetail() {
        return this.bankdetail;
    }

    public void setBankdetail(Boolean bankdetail) {
        this.bankdetail = bankdetail;
    }

    public String getSwiftid() {
        return this.swiftid;
    }

    public void setSwiftid(String swiftid) {
        this.swiftid = swiftid;
    }

    public Boolean getIspubliccompany() {
        return this.ispubliccompany;
    }

    public void setIspubliccompany(Boolean ispubliccompany) {
        this.ispubliccompany = ispubliccompany;
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

    public String getCompanynameInstitution() {
        return this.companynameInstitution;
    }

    public void setCompanynameInstitution(String companynameInstitution) {
        this.companynameInstitution = companynameInstitution;
    }

    public Character getMembertype() {
        return this.membertype;
    }

    public void setMembertype(Character membertype) {
        this.membertype = membertype;
    }

    public Integer getDegreestatus() {
        return this.degreestatus;
    }

    public void setDegreestatus(Integer degreestatus) {
        this.degreestatus = degreestatus;
    }

    public Integer getSectoreconomy() {
        return this.sectoreconomy;
    }

    public void setSectoreconomy(Integer sectoreconomy) {
        this.sectoreconomy = sectoreconomy;
    }

    public Boolean getApprove() {
        return this.approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Integer getCreator() {
        return this.creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getEditor() {
        return this.editor;
    }

    public void setEditor(Integer editor) {
        this.editor = editor;
    }

    public String getName1() {
        return this.name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return this.name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return this.name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return this.name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public Integer getDegreedesc() {
        return this.degreedesc;
    }

    public void setDegreedesc(Integer degreedesc) {
        this.degreedesc = degreedesc;
    }

    public Integer getCustomertype() {
        return this.customertype;
    }

    public void setCustomertype(Integer customertype) {
        this.customertype = customertype;
    }

    public Integer getPhotoid() {
        return this.photoid;
    }

    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    public Integer getSignatureid() {
        return this.signatureid;
    }

    public void setSignatureid(Integer signatureid) {
        this.signatureid = signatureid;
    }

    @XmlTransient
    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public List<Customermanagement> getCustomermanagementList() {
        return this.customermanagementList;
    }

    public void setCustomermanagementList(List<Customermanagement> customermanagementList) {
        this.customermanagementList = customermanagementList;
    }

    public Parameter getCompanytype() {
        return this.companytype;
    }

    public void setCompanytype(Parameter companytype) {
        this.companytype = companytype;
    }

    public Parameter getInstitution() {
        return this.institution;
    }

    public void setInstitution(Parameter institution) {
        this.institution = institution;
    }

    public Parameter getOthertypeinstitution() {
        return this.othertypeinstitution;
    }

    public void setOthertypeinstitution(Parameter othertypeinstitution) {
        this.othertypeinstitution = othertypeinstitution;
    }

    public Parameter getLegal() {
        return this.legal;
    }

    public void setLegal(Parameter legal) {
        this.legal = legal;
    }

    public Organization getOrganizationid() {
        return this.organizationid;
    }

    public void setOrganizationid(Organization organizationid) {
        this.organizationid = organizationid;
    }

    public Operatoruser getUserid() {
        return this.userid;
    }

    public void setUserid(Operatoruser userid) {
        this.userid = userid;
    }

    public Masteroperational getMasteroperationalid() {
        return this.masteroperationalid;
    }

    public void setMasteroperationalid(Masteroperational masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Country getCountryid() {
        return this.countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.customerid != null ? this.customerid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if (((this.customerid == null) && (other.customerid != null)) || ((this.customerid != null) && (!this.customerid.equals(other.customerid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Customer[ customerid=" + this.customerid + " ]";
    }
}