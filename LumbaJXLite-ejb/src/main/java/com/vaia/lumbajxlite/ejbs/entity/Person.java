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
    @javax.persistence.NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @javax.persistence.NamedQuery(name = "Person.findByPersonid", query = "SELECT p FROM Person p WHERE p.personid = :personid"),
    @javax.persistence.NamedQuery(name = "Person.findByPlaceofbirth", query = "SELECT p FROM Person p WHERE p.placeofbirth = :placeofbirth"),
    @javax.persistence.NamedQuery(name = "Person.findByDateofbirth", query = "SELECT p FROM Person p WHERE p.dateofbirth = :dateofbirth"),
    @javax.persistence.NamedQuery(name = "Person.findByBirthcertificatenumber", query = "SELECT p FROM Person p WHERE p.birthcertificatenumber = :birthcertificatenumber"),
    @javax.persistence.NamedQuery(name = "Person.findByBirthcertificatedate", query = "SELECT p FROM Person p WHERE p.birthcertificatedate = :birthcertificatedate"),
    @javax.persistence.NamedQuery(name = "Person.findByMaritalstatus", query = "SELECT p FROM Person p WHERE p.maritalstatus = :maritalstatus"),
    @javax.persistence.NamedQuery(name = "Person.findBySocialsecuritynumber", query = "SELECT p FROM Person p WHERE p.socialsecuritynumber = :socialsecuritynumber"),
    @javax.persistence.NamedQuery(name = "Person.findByStartdate", query = "SELECT p FROM Person p WHERE p.startdate = :startdate"),
    @javax.persistence.NamedQuery(name = "Person.findByEnddate", query = "SELECT p FROM Person p WHERE p.enddate = :enddate"),
    @javax.persistence.NamedQuery(name = "Person.findByDrivinglicencenumber", query = "SELECT p FROM Person p WHERE p.drivinglicencenumber = :drivinglicencenumber"),
    @javax.persistence.NamedQuery(name = "Person.findByNpwp", query = "SELECT p FROM Person p WHERE p.npwp = :npwp"),
    @javax.persistence.NamedQuery(name = "Person.findByPassportnumber", query = "SELECT p FROM Person p WHERE p.passportnumber = :passportnumber"),
    @javax.persistence.NamedQuery(name = "Person.findByPassportstartdate", query = "SELECT p FROM Person p WHERE p.passportstartdate = :passportstartdate"),
    @javax.persistence.NamedQuery(name = "Person.findByPassportenddate", query = "SELECT p FROM Person p WHERE p.passportenddate = :passportenddate"),
    @javax.persistence.NamedQuery(name = "Person.findByNumberofchildren", query = "SELECT p FROM Person p WHERE p.numberofchildren = :numberofchildren"),
    @javax.persistence.NamedQuery(name = "Person.findByMothermaiden", query = "SELECT p FROM Person p WHERE p.mothermaiden = :mothermaiden"),
    @javax.persistence.NamedQuery(name = "Person.findByLongsettled", query = "SELECT p FROM Person p WHERE p.longsettled = :longsettled"),
    @javax.persistence.NamedQuery(name = "Person.findByPhonenumberfamilyarea", query = "SELECT p FROM Person p WHERE p.phonenumberfamilyarea = :phonenumberfamilyarea"),
    @javax.persistence.NamedQuery(name = "Person.findByPhonenumberfamily", query = "SELECT p FROM Person p WHERE p.phonenumberfamily = :phonenumberfamily"),
    @javax.persistence.NamedQuery(name = "Person.findByCreationdate", query = "SELECT p FROM Person p WHERE p.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Person.findByEditdate", query = "SELECT p FROM Person p WHERE p.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Person.findByOccupationname", query = "SELECT p FROM Person p WHERE p.occupationname = :occupationname"),
    @javax.persistence.NamedQuery(name = "Person.findByLasteducation", query = "SELECT p FROM Person p WHERE p.lasteducation = :lasteducation"),
    @javax.persistence.NamedQuery(name = "Person.findBySessiondate", query = "SELECT p FROM Person p WHERE p.sessiondate = :sessiondate"),
    @javax.persistence.NamedQuery(name = "Person.findByStatusData", query = "SELECT p FROM Person p WHERE p.statusData = :statusData"),
    @javax.persistence.NamedQuery(name = "Person.findByCreator", query = "SELECT p FROM Person p WHERE p.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Person.findByEditor", query = "SELECT p FROM Person p WHERE p.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Person.findByGender", query = "SELECT p FROM Person p WHERE p.gender = :gender"),
    @javax.persistence.NamedQuery(name = "Person.findByBeginingcertificatenumber", query = "SELECT p FROM Person p WHERE p.beginingcertificatenumber = :beginingcertificatenumber"),
    @javax.persistence.NamedQuery(name = "Person.findByBeginingcertificatedate", query = "SELECT p FROM Person p WHERE p.beginingcertificatedate = :beginingcertificatedate"),
    @javax.persistence.NamedQuery(name = "Person.findByFinalcertificatenumber", query = "SELECT p FROM Person p WHERE p.finalcertificatenumber = :finalcertificatenumber"),
    @javax.persistence.NamedQuery(name = "Person.findByFinalcertificatedate", query = "SELECT p FROM Person p WHERE p.finalcertificatedate = :finalcertificatedate"),
    @javax.persistence.NamedQuery(name = "Person.findByTypeofbusiness", query = "SELECT p FROM Person p WHERE p.typeofbusiness = :typeofbusiness"),
    @javax.persistence.NamedQuery(name = "Person.findByTdp", query = "SELECT p FROM Person p WHERE p.tdp = :tdp")})
public class Person
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer personid;
    @Size(max = 50)
    @Column(length = 50)
    private String placeofbirth;
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Size(max = 30)
    @Column(length = 30)
    private String birthcertificatenumber;
    @Temporal(TemporalType.DATE)
    private Date birthcertificatedate;
    private Character maritalstatus;
    @Size(max = 50)
    @Column(length = 50)
    private String socialsecuritynumber;
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Size(max = 30)
    @Column(length = 30)
    private String drivinglicencenumber;
    @Size(max = 20)
    @Column(length = 20)
    private String npwp;
    @Size(max = 30)
    @Column(length = 30)
    private String passportnumber;
    @Temporal(TemporalType.DATE)
    private Date passportstartdate;
    @Temporal(TemporalType.DATE)
    private Date passportenddate;
    private Integer numberofchildren;
    @Size(max = 30)
    @Column(length = 30)
    private String mothermaiden;
    private Integer longsettled;
    @Size(max = 4)
    @Column(length = 4)
    private String phonenumberfamilyarea;
    @Size(max = 15)
    @Column(length = 15)
    private String phonenumberfamily;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 50)
    @Column(length = 50)
    private String occupationname;
    private Integer lasteducation;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @Column(name = "status_data")
    private Character statusData;
    private Integer creator;
    private Integer editor;
    private Integer gender;
    @Size(max = 20)
    @Column(length = 20)
    private String beginingcertificatenumber;
    @Temporal(TemporalType.DATE)
    private Date beginingcertificatedate;
    @Size(max = 20)
    @Column(length = 20)
    private String finalcertificatenumber;
    @Temporal(TemporalType.DATE)
    private Date finalcertificatedate;
    private Integer typeofbusiness;
    @Size(max = 20)
    @Column(length = 20)
    private String tdp;
    @JoinColumn(name = "residencecustomerid", referencedColumnName = "residencecustomerid")
    @ManyToOne
    private Residencecustomer residencecustomerid;
    @JoinColumn(name = "religiid", referencedColumnName = "religiid")
    @ManyToOne
    private Religi religiid;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    @ManyToOne
    private Customer customerid;
    @OneToMany(mappedBy = "personid")
    private List<Address> addressList;
    @OneToOne
    private Address address;

    public Person() {
    }

    public Person(Integer personid) {
        this.personid = personid;
    }

    public Integer getPersonid() {
        return this.personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    public String getPlaceofbirth() {
        return this.placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public Date getDateofbirth() {
        return this.dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getBirthcertificatenumber() {
        return this.birthcertificatenumber;
    }

    public void setBirthcertificatenumber(String birthcertificatenumber) {
        this.birthcertificatenumber = birthcertificatenumber;
    }

    public Date getBirthcertificatedate() {
        return this.birthcertificatedate;
    }

    public void setBirthcertificatedate(Date birthcertificatedate) {
        this.birthcertificatedate = birthcertificatedate;
    }

    public Character getMaritalstatus() {
        return this.maritalstatus;
    }

    public void setMaritalstatus(Character maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getSocialsecuritynumber() {
        return this.socialsecuritynumber;
    }

    public void setSocialsecuritynumber(String socialsecuritynumber) {
        this.socialsecuritynumber = socialsecuritynumber;
    }

    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getDrivinglicencenumber() {
        return this.drivinglicencenumber;
    }

    public void setDrivinglicencenumber(String drivinglicencenumber) {
        this.drivinglicencenumber = drivinglicencenumber;
    }

    public String getNpwp() {
        return this.npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getPassportnumber() {
        return this.passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public Date getPassportstartdate() {
        return this.passportstartdate;
    }

    public void setPassportstartdate(Date passportstartdate) {
        this.passportstartdate = passportstartdate;
    }

    public Date getPassportenddate() {
        return this.passportenddate;
    }

    public void setPassportenddate(Date passportenddate) {
        this.passportenddate = passportenddate;
    }

    public Integer getNumberofchildren() {
        return this.numberofchildren;
    }

    public void setNumberofchildren(Integer numberofchildren) {
        this.numberofchildren = numberofchildren;
    }

    public String getMothermaiden() {
        return this.mothermaiden;
    }

    public void setMothermaiden(String mothermaiden) {
        this.mothermaiden = mothermaiden;
    }

    public Integer getLongsettled() {
        return this.longsettled;
    }

    public void setLongsettled(Integer longsettled) {
        this.longsettled = longsettled;
    }

    public String getPhonenumberfamilyarea() {
        return this.phonenumberfamilyarea;
    }

    public void setPhonenumberfamilyarea(String phonenumberfamilyarea) {
        this.phonenumberfamilyarea = phonenumberfamilyarea;
    }

    public String getPhonenumberfamily() {
        return this.phonenumberfamily;
    }

    public void setPhonenumberfamily(String phonenumberfamily) {
        this.phonenumberfamily = phonenumberfamily;
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

    public String getOccupationname() {
        return this.occupationname;
    }

    public void setOccupationname(String occupationname) {
        this.occupationname = occupationname;
    }

    public Integer getLasteducation() {
        return this.lasteducation;
    }

    public void setLasteducation(Integer lasteducation) {
        this.lasteducation = lasteducation;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Character getStatusData() {
        return this.statusData;
    }

    public void setStatusData(Character statusData) {
        this.statusData = statusData;
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

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBeginingcertificatenumber() {
        return this.beginingcertificatenumber;
    }

    public void setBeginingcertificatenumber(String beginingcertificatenumber) {
        this.beginingcertificatenumber = beginingcertificatenumber;
    }

    public Date getBeginingcertificatedate() {
        return this.beginingcertificatedate;
    }

    public void setBeginingcertificatedate(Date beginingcertificatedate) {
        this.beginingcertificatedate = beginingcertificatedate;
    }

    public String getFinalcertificatenumber() {
        return this.finalcertificatenumber;
    }

    public void setFinalcertificatenumber(String finalcertificatenumber) {
        this.finalcertificatenumber = finalcertificatenumber;
    }

    public Date getFinalcertificatedate() {
        return this.finalcertificatedate;
    }

    public void setFinalcertificatedate(Date finalcertificatedate) {
        this.finalcertificatedate = finalcertificatedate;
    }

    public Integer getTypeofbusiness() {
        return this.typeofbusiness;
    }

    public void setTypeofbusiness(Integer typeofbusiness) {
        this.typeofbusiness = typeofbusiness;
    }

    public String getTdp() {
        return this.tdp;
    }

    public void setTdp(String tdp) {
        this.tdp = tdp;
    }

    public Residencecustomer getResidencecustomerid() {
        return this.residencecustomerid;
    }

    public void setResidencecustomerid(Residencecustomer residencecustomerid) {
        this.residencecustomerid = residencecustomerid;
    }

    public Religi getReligiid() {
        return this.religiid;
    }

    public void setReligiid(Religi religiid) {
        this.religiid = religiid;
    }

    public Customer getCustomerid() {
        return this.customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return this.addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.personid != null ? this.personid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if (((this.personid == null) && (other.personid != null)) || ((this.personid != null) && (!this.personid.equals(other.personid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Person[ personid=" + this.personid + " ]";
    }
}