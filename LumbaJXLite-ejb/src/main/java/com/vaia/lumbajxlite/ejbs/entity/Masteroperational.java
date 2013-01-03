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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Masteroperational.findAll", query = "SELECT m FROM Masteroperational m"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByMasteroperationalid", query = "SELECT m FROM Masteroperational m WHERE m.masteroperationalid = :masteroperationalid"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByAddress", query = "SELECT m FROM Masteroperational m WHERE m.address = :address"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByPhonenumber", query = "SELECT m FROM Masteroperational m WHERE m.phonenumber = :phonenumber"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByCreationdate", query = "SELECT m FROM Masteroperational m WHERE m.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByEditdate", query = "SELECT m FROM Masteroperational m WHERE m.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByCreator", query = "SELECT m FROM Masteroperational m WHERE m.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByEditor", query = "SELECT m FROM Masteroperational m WHERE m.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findByTypeoffice", query = "SELECT m FROM Masteroperational m WHERE m.typeoffice = :typeoffice"),
    @javax.persistence.NamedQuery(name = "Masteroperational.findBySessiondate", query = "SELECT m FROM Masteroperational m WHERE m.sessiondate = :sessiondate")})
public class Masteroperational
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer masteroperationalid;
    @Size(max = 100)
    @Column(length = 100)
    private String address;
    @Size(max = 15)
    @Column(length = 15)
    private String phonenumber;
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
    @Size(max = 30)
    @Column(length = 30)
    private String typeoffice;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(mappedBy = "masteroperationalid")
    private List<Customer> customerList;
    @OneToMany(mappedBy = "masteroperationalid")
    private List<Operatoruser> operatoruserList;
    @JoinColumn(name = "villageid", referencedColumnName = "villageid")
    @ManyToOne
    private Village villageid;
    @JoinColumn(name = "subbranchunitcoid", referencedColumnName = "subbranchunitcoid")
    @ManyToOne
    private Subbranchunitco subbranchunitcoid;
    @JoinColumn(name = "regionid", referencedColumnName = "regionid")
    @ManyToOne
    private Region regionid;
    @JoinColumn(name = "headofficeid", referencedColumnName = "headofficeid")
    @ManyToOne
    private Headoffice headofficeid;
    @JoinColumn(name = "branchid", referencedColumnName = "branchid")
    @ManyToOne
    private Branch branchid;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "masteroperationalid")
    private List<Chartofaccount> chartofaccountList;

    public Masteroperational() {
    }

    public Masteroperational(Integer masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Integer getMasteroperationalid() {
        return this.masteroperationalid;
    }

    public void setMasteroperationalid(Integer masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public String getTypeoffice() {
        return this.typeoffice;
    }

    public void setTypeoffice(String typeoffice) {
        this.typeoffice = typeoffice;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlTransient
    public List<Operatoruser> getOperatoruserList() {
        return this.operatoruserList;
    }

    public void setOperatoruserList(List<Operatoruser> operatoruserList) {
        this.operatoruserList = operatoruserList;
    }

    public Village getVillageid() {
        return this.villageid;
    }

    public void setVillageid(Village villageid) {
        this.villageid = villageid;
    }

    public Subbranchunitco getSubbranchunitcoid() {
        return this.subbranchunitcoid;
    }

    public void setSubbranchunitcoid(Subbranchunitco subbranchunitcoid) {
        this.subbranchunitcoid = subbranchunitcoid;
    }

    public Region getRegionid() {
        return this.regionid;
    }

    public void setRegionid(Region regionid) {
        this.regionid = regionid;
    }

    public Headoffice getHeadofficeid() {
        return this.headofficeid;
    }

    public void setHeadofficeid(Headoffice headofficeid) {
        this.headofficeid = headofficeid;
    }

    public Branch getBranchid() {
        return this.branchid;
    }

    public void setBranchid(Branch branchid) {
        this.branchid = branchid;
    }

    @XmlTransient
    public List<Chartofaccount> getChartofaccountList() {
        return this.chartofaccountList;
    }

    public void setChartofaccountList(List<Chartofaccount> chartofaccountList) {
        this.chartofaccountList = chartofaccountList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.masteroperationalid != null ? this.masteroperationalid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Masteroperational)) {
            return false;
        }
        Masteroperational other = (Masteroperational) object;
        if (((this.masteroperationalid == null) && (other.masteroperationalid != null)) || ((this.masteroperationalid != null) && (!this.masteroperationalid.equals(other.masteroperationalid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Masteroperational[ masteroperationalid=" + this.masteroperationalid + " ]";
    }
}