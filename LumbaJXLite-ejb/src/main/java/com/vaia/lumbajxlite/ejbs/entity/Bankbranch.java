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
    @javax.persistence.NamedQuery(name = "Bankbranch.findAll", query = "SELECT b FROM Bankbranch b"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByBankbranchid", query = "SELECT b FROM Bankbranch b WHERE b.bankbranchid = :bankbranchid"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByBankbranchcode", query = "SELECT b FROM Bankbranch b WHERE b.bankbranchcode = :bankbranchcode"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByBankbranchname", query = "SELECT b FROM Bankbranch b WHERE b.bankbranchname = :bankbranchname"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByAddress", query = "SELECT b FROM Bankbranch b WHERE b.address = :address"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByCreationdate", query = "SELECT b FROM Bankbranch b WHERE b.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByCreator", query = "SELECT b FROM Bankbranch b WHERE b.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByEditdate", query = "SELECT b FROM Bankbranch b WHERE b.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByEditor", query = "SELECT b FROM Bankbranch b WHERE b.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByChequeclearancepersonal", query = "SELECT b FROM Bankbranch b WHERE b.chequeclearancepersonal = :chequeclearancepersonal"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findByChequeclearancethirdparty", query = "SELECT b FROM Bankbranch b WHERE b.chequeclearancethirdparty = :chequeclearancethirdparty"),
    @javax.persistence.NamedQuery(name = "Bankbranch.findBySessiondate", query = "SELECT b FROM Bankbranch b WHERE b.sessiondate = :sessiondate")})
public class Bankbranch
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer bankbranchid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(nullable = false, length = 5)
    private String bankbranchcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String bankbranchname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String address;
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
    @Column(precision = 17, scale = 17)
    private Double chequeclearancepersonal;
    @Column(precision = 17, scale = 17)
    private Double chequeclearancethirdparty;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "bankbranchid")
    private List<Bankaccount> bankaccountList;
    @JoinColumn(name = "bankid", referencedColumnName = "bankid", nullable = false)
    @ManyToOne(optional = false)
    private Bank bankid;

    public Bankbranch() {
    }

    public Bankbranch(Integer bankbranchid) {
        this.bankbranchid = bankbranchid;
    }

    public Bankbranch(Integer bankbranchid, String bankbranchcode, String bankbranchname, String address) {
        this.bankbranchid = bankbranchid;
        this.bankbranchcode = bankbranchcode;
        this.bankbranchname = bankbranchname;
        this.address = address;
    }

    public Integer getBankbranchid() {
        return this.bankbranchid;
    }

    public void setBankbranchid(Integer bankbranchid) {
        this.bankbranchid = bankbranchid;
    }

    public String getBankbranchcode() {
        return this.bankbranchcode;
    }

    public void setBankbranchcode(String bankbranchcode) {
        this.bankbranchcode = bankbranchcode;
    }

    public String getBankbranchname() {
        return this.bankbranchname;
    }

    public void setBankbranchname(String bankbranchname) {
        this.bankbranchname = bankbranchname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getEditdate() {
        return this.editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Double getChequeclearancepersonal() {
        return this.chequeclearancepersonal;
    }

    public void setChequeclearancepersonal(Double chequeclearancepersonal) {
        this.chequeclearancepersonal = chequeclearancepersonal;
    }

    public Double getChequeclearancethirdparty() {
        return this.chequeclearancethirdparty;
    }

    public void setChequeclearancethirdparty(Double chequeclearancethirdparty) {
        this.chequeclearancethirdparty = chequeclearancethirdparty;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<Bankaccount> getBankaccountList() {
        return this.bankaccountList;
    }

    public void setBankaccountList(List<Bankaccount> bankaccountList) {
        this.bankaccountList = bankaccountList;
    }

    public Bank getBankid() {
        return this.bankid;
    }

    public void setBankid(Bank bankid) {
        this.bankid = bankid;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.bankbranchid != null ? this.bankbranchid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Bankbranch)) {
            return false;
        }
        Bankbranch other = (Bankbranch) object;
        if (((this.bankbranchid == null) && (other.bankbranchid != null)) || ((this.bankbranchid != null) && (!this.bankbranchid.equals(other.bankbranchid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Bankbranch[ bankbranchid=" + this.bankbranchid + " ]";
    }
}