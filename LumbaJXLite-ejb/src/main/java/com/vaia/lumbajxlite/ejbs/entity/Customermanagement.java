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
    @javax.persistence.NamedQuery(name = "Customermanagement.findAll", query = "SELECT c FROM Customermanagement c"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByCustomermanagementid", query = "SELECT c FROM Customermanagement c WHERE c.customermanagementid = :customermanagementid"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByManagementname", query = "SELECT c FROM Customermanagement c WHERE c.managementname = :managementname"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByShare", query = "SELECT c FROM Customermanagement c WHERE c.share = :share"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByDescription", query = "SELECT c FROM Customermanagement c WHERE c.description = :description"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByCreationdate", query = "SELECT c FROM Customermanagement c WHERE c.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByEditdate", query = "SELECT c FROM Customermanagement c WHERE c.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByCreator", query = "SELECT c FROM Customermanagement c WHERE c.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByEditor", query = "SELECT c FROM Customermanagement c WHERE c.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByGender", query = "SELECT c FROM Customermanagement c WHERE c.gender = :gender"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findBySocialsecuritynumber", query = "SELECT c FROM Customermanagement c WHERE c.socialsecuritynumber = :socialsecuritynumber"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByDrivinglicencenumber", query = "SELECT c FROM Customermanagement c WHERE c.drivinglicencenumber = :drivinglicencenumber"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByPassportnumber", query = "SELECT c FROM Customermanagement c WHERE c.passportnumber = :passportnumber"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByStatus", query = "SELECT c FROM Customermanagement c WHERE c.status = :status"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findBySessiondate", query = "SELECT c FROM Customermanagement c WHERE c.sessiondate = :sessiondate"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByLinkId", query = "SELECT c FROM Customermanagement c WHERE c.linkId = :linkId"),
    @javax.persistence.NamedQuery(name = "Customermanagement.findByStatusData", query = "SELECT c FROM Customermanagement c WHERE c.statusData = :statusData")})
public class Customermanagement
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer customermanagementid;
    @Size(max = 100)
    @Column(length = 100)
    private String managementname;
    @Column(precision = 17, scale = 17)
    private Double share;
    @Size(max = 200)
    @Column(length = 200)
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 40)
    @Column(length = 40)
    private String creator;
    @Size(max = 40)
    @Column(length = 40)
    private String editor;
    private Character gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String socialsecuritynumber;
    @Size(max = 30)
    @Column(length = 30)
    private String drivinglicencenumber;
    @Size(max = 30)
    @Column(length = 30)
    private String passportnumber;
    private Boolean status;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @Column(name = "link_id")
    private Integer linkId;
    @Column(name = "status_data")
    private Character statusData;
    @JoinColumn(name = "position", referencedColumnName = "parameterid")
    @ManyToOne
    private Parameter position;
    @JoinColumn(name = "customerid", referencedColumnName = "customerid", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerid;
    @OneToMany(mappedBy = "customermanagementid")
    private List<Address> addressList;

    public Customermanagement() {
    }

    public Customermanagement(Integer customermanagementid) {
        this.customermanagementid = customermanagementid;
    }

    public Customermanagement(Integer customermanagementid, String socialsecuritynumber) {
        this.customermanagementid = customermanagementid;
        this.socialsecuritynumber = socialsecuritynumber;
    }

    public Integer getCustomermanagementid() {
        return this.customermanagementid;
    }

    public void setCustomermanagementid(Integer customermanagementid) {
        this.customermanagementid = customermanagementid;
    }

    public String getManagementname() {
        return this.managementname;
    }

    public void setManagementname(String managementname) {
        this.managementname = managementname;
    }

    public Double getShare() {
        return this.share;
    }

    public void setShare(Double share) {
        this.share = share;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Character getGender() {
        return this.gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getSocialsecuritynumber() {
        return this.socialsecuritynumber;
    }

    public void setSocialsecuritynumber(String socialsecuritynumber) {
        this.socialsecuritynumber = socialsecuritynumber;
    }

    public String getDrivinglicencenumber() {
        return this.drivinglicencenumber;
    }

    public void setDrivinglicencenumber(String drivinglicencenumber) {
        this.drivinglicencenumber = drivinglicencenumber;
    }

    public String getPassportnumber() {
        return this.passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
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

    public Parameter getPosition() {
        return this.position;
    }

    public void setPosition(Parameter position) {
        this.position = position;
    }

    public Customer getCustomerid() {
        return this.customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
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
        hash += (this.customermanagementid != null ? this.customermanagementid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Customermanagement)) {
            return false;
        }
        Customermanagement other = (Customermanagement) object;
        if (((this.customermanagementid == null) && (other.customermanagementid != null)) || ((this.customermanagementid != null) && (!this.customermanagementid.equals(other.customermanagementid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Customermanagement[ customermanagementid=" + this.customermanagementid + " ]";
    }
}