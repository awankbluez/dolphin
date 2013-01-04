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
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Address.findByAddress", query = "SELECT a FROM Address a WHERE a.address = :address"),
    @NamedQuery(name = "Address.findByPostcode", query = "SELECT a FROM Address a WHERE a.postcode = :postcode"),
    @NamedQuery(name = "Address.findByPhonenumbercode", query = "SELECT a FROM Address a WHERE a.phonenumbercode = :phonenumbercode"),
    @NamedQuery(name = "Address.findByPhonenumber", query = "SELECT a FROM Address a WHERE a.phonenumber = :phonenumber"),
    @NamedQuery(name = "Address.findByMobilephonenumber", query = "SELECT a FROM Address a WHERE a.mobilephonenumber = :mobilephonenumber"),
    @NamedQuery(name = "Address.findByFaximilearea", query = "SELECT a FROM Address a WHERE a.faximilearea = :faximilearea"),
    @NamedQuery(name = "Address.findByFaximilenumber", query = "SELECT a FROM Address a WHERE a.faximilenumber = :faximilenumber"),
    @NamedQuery(name = "Address.findByEmail", query = "SELECT a FROM Address a WHERE a.email = :email"),
    @NamedQuery(name = "Address.findByMailingaddress", query = "SELECT a FROM Address a WHERE a.mailingaddress = :mailingaddress"),
    @NamedQuery(name = "Address.findByCreationdate", query = "SELECT a FROM Address a WHERE a.creationdate = :creationdate"),
    @NamedQuery(name = "Address.findByEditdate", query = "SELECT a FROM Address a WHERE a.editdate = :editdate"),
    @NamedQuery(name = "Address.findByStatus", query = "SELECT a FROM Address a WHERE a.status = :status"),
    @NamedQuery(name = "Address.findBySessiondate", query = "SELECT a FROM Address a WHERE a.sessiondate = :sessiondate"),
    @NamedQuery(name = "Address.findByLinkId", query = "SELECT a FROM Address a WHERE a.linkId = :linkId"),
    @NamedQuery(name = "Address.findByStatusData", query = "SELECT a FROM Address a WHERE a.statusData = :statusData"),
    @NamedQuery(name = "Address.findByRtrw", query = "SELECT a FROM Address a WHERE a.rtrw = :rtrw"),
    @NamedQuery(name = "Address.findByCreator", query = "SELECT a FROM Address a WHERE a.creator = :creator"),
    @NamedQuery(name = "Address.findByEditor", query = "SELECT a FROM Address a WHERE a.editor = :editor"),
    @NamedQuery(name = "Address.findByVillage", query = "SELECT a FROM Address a WHERE a.village = :village"),
    @NamedQuery(name = "Address.findBySubdistrict", query = "SELECT a FROM Address a WHERE a.subdistrict = :subdistrict"),
    @NamedQuery(name = "Address.findByProvinceid", query = "SELECT a FROM Address a WHERE a.provinceid = :provinceid"),
    @NamedQuery(name = "Address.findByCountryid", query = "SELECT a FROM Address a WHERE a.countryid = :countryid"),
    @NamedQuery(name = "Address.findByOfficephonenumbercode", query = "SELECT a FROM Address a WHERE a.officephonenumbercode = :officephonenumbercode"),
    @NamedQuery(name = "Address.findByOfficephonenumber", query = "SELECT a FROM Address a WHERE a.officephonenumber = :officephonenumber"),
    @NamedQuery(name = "Address.findByWebsite", query = "SELECT a FROM Address a WHERE a.website = :website"),
    @NamedQuery(name = "Address.findByDistrictid", query = "SELECT a FROM Address a WHERE a.districtid = :districtid"),
    @NamedQuery(name = "Address.findByGroupingid", query = "SELECT a FROM Address a WHERE a.groupingid = :groupingid")})
public class Address implements Serializable {

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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
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
    @OneToMany(mappedBy = "addressAddressid")
    private List<Person> personList;
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
    @ManyToOne
    private Country country;
    @ManyToOne
    private Province province;
    @ManyToOne
    private District district;

    public Address() {
        country = new Country();
        province = new Province();
        district = new District();
    }

    public Address(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhonenumbercode() {
        return phonenumbercode;
    }

    public void setPhonenumbercode(String phonenumbercode) {
        this.phonenumbercode = phonenumbercode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMobilephonenumber() {
        return mobilephonenumber;
    }

    public void setMobilephonenumber(String mobilephonenumber) {
        this.mobilephonenumber = mobilephonenumber;
    }

    public String getFaximilearea() {
        return faximilearea;
    }

    public void setFaximilearea(String faximilearea) {
        this.faximilearea = faximilearea;
    }

    public String getFaximilenumber() {
        return faximilenumber;
    }

    public void setFaximilenumber(String faximilenumber) {
        this.faximilenumber = faximilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMailingaddress() {
        return mailingaddress;
    }

    public void setMailingaddress(Boolean mailingaddress) {
        this.mailingaddress = mailingaddress;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Character getStatusData() {
        return statusData;
    }

    public void setStatusData(Character statusData) {
        this.statusData = statusData;
    }

    public String getRtrw() {
        return rtrw;
    }

    public void setRtrw(String rtrw) {
        this.rtrw = rtrw;
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

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getSubdistrict() {
        return subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public String getOfficephonenumbercode() {
        return officephonenumbercode;
    }

    public void setOfficephonenumbercode(String officephonenumbercode) {
        this.officephonenumbercode = officephonenumbercode;
    }

    public String getOfficephonenumber() {
        return officephonenumber;
    }

    public void setOfficephonenumber(String officephonenumber) {
        this.officephonenumber = officephonenumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getGroupingid() {
        return groupingid;
    }

    public void setGroupingid(Integer groupingid) {
        this.groupingid = groupingid;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Village getVillageid() {
        return villageid;
    }

    public void setVillageid(Village villageid) {
        this.villageid = villageid;
    }

    public Person getPersonid() {
        return personid;
    }

    public void setPersonid(Person personid) {
        this.personid = personid;
    }

    public Customermanagement getCustomermanagementid() {
        return customermanagementid;
    }

    public void setCustomermanagementid(Customermanagement customermanagementid) {
        this.customermanagementid = customermanagementid;
    }

    public Addressstatus getAddressstatusid() {
        return addressstatusid;
    }

    public void setAddressstatusid(Addressstatus addressstatusid) {
        this.addressstatusid = addressstatusid;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Address[ addressid=" + addressid + " ]";
    }
}
