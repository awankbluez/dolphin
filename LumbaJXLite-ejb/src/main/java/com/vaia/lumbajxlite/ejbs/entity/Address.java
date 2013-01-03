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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @javax.persistence.NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @javax.persistence.NamedQuery(name = "Address.findByAddress", query = "SELECT a FROM Address a WHERE a.address = :address"),
    @javax.persistence.NamedQuery(name = "Address.findByPostcode", query = "SELECT a FROM Address a WHERE a.postcode = :postcode"),
    @javax.persistence.NamedQuery(name = "Address.findByPhonenumbercode", query = "SELECT a FROM Address a WHERE a.phonenumbercode = :phonenumbercode"),
    @javax.persistence.NamedQuery(name = "Address.findByPhonenumber", query = "SELECT a FROM Address a WHERE a.phonenumber = :phonenumber"),
    @javax.persistence.NamedQuery(name = "Address.findByMobilephonenumber", query = "SELECT a FROM Address a WHERE a.mobilephonenumber = :mobilephonenumber"),
    @javax.persistence.NamedQuery(name = "Address.findByFaximilearea", query = "SELECT a FROM Address a WHERE a.faximilearea = :faximilearea"),
    @javax.persistence.NamedQuery(name = "Address.findByFaximilenumber", query = "SELECT a FROM Address a WHERE a.faximilenumber = :faximilenumber"),
    @javax.persistence.NamedQuery(name = "Address.findByEmail", query = "SELECT a FROM Address a WHERE a.email = :email"),
    @javax.persistence.NamedQuery(name = "Address.findByMailingaddress", query = "SELECT a FROM Address a WHERE a.mailingaddress = :mailingaddress"),
    @javax.persistence.NamedQuery(name = "Address.findByCreationdate", query = "SELECT a FROM Address a WHERE a.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Address.findByEditdate", query = "SELECT a FROM Address a WHERE a.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Address.findByStatus", query = "SELECT a FROM Address a WHERE a.status = :status"),
    @javax.persistence.NamedQuery(name = "Address.findBySessiondate", query = "SELECT a FROM Address a WHERE a.sessiondate = :sessiondate"),
    @javax.persistence.NamedQuery(name = "Address.findByLinkId", query = "SELECT a FROM Address a WHERE a.linkId = :linkId"),
    @javax.persistence.NamedQuery(name = "Address.findByStatusData", query = "SELECT a FROM Address a WHERE a.statusData = :statusData"),
    @javax.persistence.NamedQuery(name = "Address.findByRtrw", query = "SELECT a FROM Address a WHERE a.rtrw = :rtrw"),
    @javax.persistence.NamedQuery(name = "Address.findByCreator", query = "SELECT a FROM Address a WHERE a.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Address.findByEditor", query = "SELECT a FROM Address a WHERE a.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Address.findByVillage", query = "SELECT a FROM Address a WHERE a.village = :village"),
    @javax.persistence.NamedQuery(name = "Address.findBySubdistrict", query = "SELECT a FROM Address a WHERE a.subdistrict = :subdistrict"),
    @javax.persistence.NamedQuery(name = "Address.findByProvinceid", query = "SELECT a FROM Address a WHERE a.provinceid = :provinceid"),
    @javax.persistence.NamedQuery(name = "Address.findByCountryid", query = "SELECT a FROM Address a WHERE a.countryid = :countryid"),
    @javax.persistence.NamedQuery(name = "Address.findByOfficephonenumbercode", query = "SELECT a FROM Address a WHERE a.officephonenumbercode = :officephonenumbercode"),
    @javax.persistence.NamedQuery(name = "Address.findByOfficephonenumber", query = "SELECT a FROM Address a WHERE a.officephonenumber = :officephonenumber"),
    @javax.persistence.NamedQuery(name = "Address.findByWebsite", query = "SELECT a FROM Address a WHERE a.website = :website"),
    @javax.persistence.NamedQuery(name = "Address.findByDistrictid", query = "SELECT a FROM Address a WHERE a.districtid = :districtid"),
    @javax.persistence.NamedQuery(name = "Address.findByGroupingid", query = "SELECT a FROM Address a WHERE a.groupingid = :groupingid")})
public class Address
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer addressid;
    @Size(max = 100)
    @Column(length = 100)
    private String address;
    @Size(max = 5)
    @Column(length = 5)
    private String postcode;
    @Size(max = 4)
    @Column(length = 4)
    private String phonenumbercode;
    @Size(max = 15)
    @Column(length = 15)
    private String phonenumber;
    @Size(max = 15)
    @Column(length = 15)
    private String mobilephonenumber;
    @Size(max = 4)
    @Column(length = 4)
    private String faximilearea;
    @Size(max = 15)
    @Column(length = 15)
    private String faximilenumber;
    @Size(max = 50)
    @Column(length = 50)
    private String email;
    private Boolean mailingaddress;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    private Boolean status;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @Column(name = "link_id")
    private Integer linkId;
    @Column(name = "status_data")
    private Character statusData;
    @Size(max = 10)
    @Column(length = 10)
    private String rtrw;
    private Integer creator;
    private Integer editor;
    @Size(max = 20)
    @Column(length = 20)
    private String village;
    @Size(max = 20)
    @Column(length = 20)
    private String subdistrict;
    private Integer provinceid;
    private Integer countryid;
    @Size(max = 5)
    @Column(length = 5)
    private String officephonenumbercode;
    @Size(max = 10)
    @Column(length = 10)
    private String officephonenumber;
    @Size(max = 50)
    @Column(length = 50)
    private String website;
    private Integer districtid;
    private Integer groupingid;
    @JoinColumn(name = "villageid", referencedColumnName = "villageid")
    @ManyToOne
    private Village villageid;
    @JoinColumn(name = "personid", referencedColumnName = "personid")
    @ManyToOne
    private Person personid;
    @JoinColumn(name = "customermanagementid", referencedColumnName = "customermanagementid")
    @ManyToOne
    private Customermanagement customermanagementid;
    @JoinColumn(name = "addressstatusid", referencedColumnName = "addressstatusid")
    @ManyToOne
    private Addressstatus addressstatusid;

    public Address() {
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getAddressid() {
        return this.addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhonenumbercode() {
        return this.phonenumbercode;
    }

    public void setPhonenumbercode(String phonenumbercode) {
        this.phonenumbercode = phonenumbercode;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMobilephonenumber() {
        return this.mobilephonenumber;
    }

    public void setMobilephonenumber(String mobilephonenumber) {
        this.mobilephonenumber = mobilephonenumber;
    }

    public String getFaximilearea() {
        return this.faximilearea;
    }

    public void setFaximilearea(String faximilearea) {
        this.faximilearea = faximilearea;
    }

    public String getFaximilenumber() {
        return this.faximilenumber;
    }

    public void setFaximilenumber(String faximilenumber) {
        this.faximilenumber = faximilenumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMailingaddress() {
        return this.mailingaddress;
    }

    public void setMailingaddress(Boolean mailingaddress) {
        this.mailingaddress = mailingaddress;
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

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Integer getLinkId() {
        return this.linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Character getStatusData() {
        return this.statusData;
    }

    public void setStatusData(Character statusData) {
        this.statusData = statusData;
    }

    public String getRtrw() {
        return this.rtrw;
    }

    public void setRtrw(String rtrw) {
        this.rtrw = rtrw;
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

    public String getVillage() {
        return this.village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getSubdistrict() {
        return this.subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public Integer getProvinceid() {
        return this.provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCountryid() {
        return this.countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public String getOfficephonenumbercode() {
        return this.officephonenumbercode;
    }

    public void setOfficephonenumbercode(String officephonenumbercode) {
        this.officephonenumbercode = officephonenumbercode;
    }

    public String getOfficephonenumber() {
        return this.officephonenumber;
    }

    public void setOfficephonenumber(String officephonenumber) {
        this.officephonenumber = officephonenumber;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getDistrictid() {
        return this.districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getGroupingid() {
        return this.groupingid;
    }

    public void setGroupingid(Integer groupingid) {
        this.groupingid = groupingid;
    }

    public Village getVillageid() {
        return this.villageid;
    }

    public void setVillageid(Village villageid) {
        this.villageid = villageid;
    }

    public Person getPersonid() {
        return this.personid;
    }

    public void setPersonid(Person personid) {
        this.personid = personid;
    }

    public Customermanagement getCustomermanagementid() {
        return this.customermanagementid;
    }

    public void setCustomermanagementid(Customermanagement customermanagementid) {
        this.customermanagementid = customermanagementid;
    }

    public Addressstatus getAddressstatusid() {
        return this.addressstatusid;
    }

    public void setAddressstatusid(Addressstatus addressstatusid) {
        this.addressstatusid = addressstatusid;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.addressid != null ? this.addressid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if (((this.addressid == null) && (other.addressid != null)) || ((this.addressid != null) && (!this.addressid.equals(other.addressid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Address[ addressid=" + this.addressid + " ]";
    }
}