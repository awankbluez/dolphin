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
@Table(catalog = "DB_LUMBA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Masteroperational.findAll", query = "SELECT m FROM Masteroperational m"),
    @NamedQuery(name = "Masteroperational.findByMasteroperationalid", query = "SELECT m FROM Masteroperational m WHERE m.masteroperationalid = :masteroperationalid"),
    @NamedQuery(name = "Masteroperational.findByAddress", query = "SELECT m FROM Masteroperational m WHERE m.address = :address"),
    @NamedQuery(name = "Masteroperational.findByPhonenumber", query = "SELECT m FROM Masteroperational m WHERE m.phonenumber = :phonenumber"),
    @NamedQuery(name = "Masteroperational.findByCreationdate", query = "SELECT m FROM Masteroperational m WHERE m.creationdate = :creationdate"),
    @NamedQuery(name = "Masteroperational.findByEditdate", query = "SELECT m FROM Masteroperational m WHERE m.editdate = :editdate"),
    @NamedQuery(name = "Masteroperational.findByCreator", query = "SELECT m FROM Masteroperational m WHERE m.creator = :creator"),
    @NamedQuery(name = "Masteroperational.findByEditor", query = "SELECT m FROM Masteroperational m WHERE m.editor = :editor"),
    @NamedQuery(name = "Masteroperational.findByTypeoffice", query = "SELECT m FROM Masteroperational m WHERE m.typeoffice = :typeoffice"),
    @NamedQuery(name = "Masteroperational.findBySessiondate", query = "SELECT m FROM Masteroperational m WHERE m.sessiondate = :sessiondate")})
public class Masteroperational implements Serializable {
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
    private List<OperatorUser> operatoruserList;
    @JoinColumn(name = "villageid", referencedColumnName = "villageid")
    @ManyToOne
    private Village villageid;
    @JoinColumn(name = "subbranchunitcoid", referencedColumnName = "subbranchunitcoid")
    @ManyToOne
    private SubBranchUnitCo subbranchunitcoid;
    @JoinColumn(name = "regionid", referencedColumnName = "regionid")
    @ManyToOne
    private Region regionid;
    @JoinColumn(name = "headofficeid", referencedColumnName = "headofficeid")
    @ManyToOne
    private HeadOffice headofficeid;
    @JoinColumn(name = "branchid", referencedColumnName = "branchid")
    @ManyToOne
    private Branch branchid;
    @OneToMany(mappedBy = "masteroperationalid")
    private List<Account> accountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masteroperationalid")
    private List<ChartOfAccount> chartofaccountList;

    public Masteroperational() {
    }

    public Masteroperational(Integer masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Integer getMasteroperationalid() {
        return masteroperationalid;
    }

    public void setMasteroperationalid(Integer masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTypeoffice() {
        return typeoffice;
    }

    public void setTypeoffice(String typeoffice) {
        this.typeoffice = typeoffice;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlTransient
    public List<OperatorUser> getOperatoruserList() {
        return operatoruserList;
    }

    public void setOperatoruserList(List<OperatorUser> operatoruserList) {
        this.operatoruserList = operatoruserList;
    }

    public Village getVillageid() {
        return villageid;
    }

    public void setVillageid(Village villageid) {
        this.villageid = villageid;
    }

    public SubBranchUnitCo getSubbranchunitcoid() {
        return subbranchunitcoid;
    }

    public void setSubbranchunitcoid(SubBranchUnitCo subbranchunitcoid) {
        this.subbranchunitcoid = subbranchunitcoid;
    }

    public Region getRegionid() {
        return regionid;
    }

    public void setRegionid(Region regionid) {
        this.regionid = regionid;
    }

    public HeadOffice getHeadofficeid() {
        return headofficeid;
    }

    public void setHeadofficeid(HeadOffice headofficeid) {
        this.headofficeid = headofficeid;
    }

    public Branch getBranchid() {
        return branchid;
    }

    public void setBranchid(Branch branchid) {
        this.branchid = branchid;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @XmlTransient
    public List<ChartOfAccount> getChartofaccountList() {
        return chartofaccountList;
    }

    public void setChartofaccountList(List<ChartOfAccount> chartofaccountList) {
        this.chartofaccountList = chartofaccountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masteroperationalid != null ? masteroperationalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Masteroperational)) {
            return false;
        }
        Masteroperational other = (Masteroperational) object;
        if ((this.masteroperationalid == null && other.masteroperationalid != null) || (this.masteroperationalid != null && !this.masteroperationalid.equals(other.masteroperationalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Masteroperational[ masteroperationalid=" + masteroperationalid + " ]";
    }

}
