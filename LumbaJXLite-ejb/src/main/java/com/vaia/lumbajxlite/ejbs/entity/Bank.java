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
    @javax.persistence.NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @javax.persistence.NamedQuery(name = "Bank.findByBankid", query = "SELECT b FROM Bank b WHERE b.bankid = :bankid"),
    @javax.persistence.NamedQuery(name = "Bank.findByBankname", query = "SELECT b FROM Bank b WHERE b.bankname = :bankname"),
    @javax.persistence.NamedQuery(name = "Bank.findByAddress", query = "SELECT b FROM Bank b WHERE b.address = :address"),
    @javax.persistence.NamedQuery(name = "Bank.findByCreationdate", query = "SELECT b FROM Bank b WHERE b.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Bank.findByCreator", query = "SELECT b FROM Bank b WHERE b.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Bank.findByEditdate", query = "SELECT b FROM Bank b WHERE b.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Bank.findByEditor", query = "SELECT b FROM Bank b WHERE b.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Bank.findBySessiondate", query = "SELECT b FROM Bank b WHERE b.sessiondate = :sessiondate")})
public class Bank
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer bankid;
    @Size(max = 40)
    @Column(length = 40)
    private String bankname;
    @Size(max = 100)
    @Column(length = 100)
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
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(mappedBy = "bankid")
    private List<Bankaccount> bankaccountList;
    @OneToMany(cascade = {javax.persistence.CascadeType.ALL}, mappedBy = "bankid")
    private List<Bankbranch> bankbranchList;

    public Bank() {
    }

    public Bank(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getBankid() {
        return this.bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return this.bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
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

    @XmlTransient
    public List<Bankbranch> getBankbranchList() {
        return this.bankbranchList;
    }

    public void setBankbranchList(List<Bankbranch> bankbranchList) {
        this.bankbranchList = bankbranchList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.bankid != null ? this.bankid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if (((this.bankid == null) && (other.bankid != null)) || ((this.bankid != null) && (!this.bankid.equals(other.bankid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Bank[ bankid=" + this.bankid + " ]";
    }
}