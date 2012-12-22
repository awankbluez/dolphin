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
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findByBankid", query = "SELECT b FROM Bank b WHERE b.bankid = :bankid"),
    @NamedQuery(name = "Bank.findByBankname", query = "SELECT b FROM Bank b WHERE b.bankname = :bankname"),
    @NamedQuery(name = "Bank.findByAddress", query = "SELECT b FROM Bank b WHERE b.address = :address"),
    @NamedQuery(name = "Bank.findByCreationdate", query = "SELECT b FROM Bank b WHERE b.creationdate = :creationdate"),
    @NamedQuery(name = "Bank.findByCreator", query = "SELECT b FROM Bank b WHERE b.creator = :creator"),
    @NamedQuery(name = "Bank.findByEditdate", query = "SELECT b FROM Bank b WHERE b.editdate = :editdate"),
    @NamedQuery(name = "Bank.findByEditor", query = "SELECT b FROM Bank b WHERE b.editor = :editor"),
    @NamedQuery(name = "Bank.findBySessiondate", query = "SELECT b FROM Bank b WHERE b.sessiondate = :sessiondate")})
public class Bank implements Serializable {
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
    private List<BankAccount> bankaccountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankid")
    private List<BankBranch> bankbranchList;

    public Bank() {
    }

    public Bank(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    @XmlTransient
    public List<BankAccount> getBankaccountList() {
        return bankaccountList;
    }

    public void setBankaccountList(List<BankAccount> bankaccountList) {
        this.bankaccountList = bankaccountList;
    }

    @XmlTransient
    public List<BankBranch> getBankbranchList() {
        return bankbranchList;
    }

    public void setBankbranchList(List<BankBranch> bankbranchList) {
        this.bankbranchList = bankbranchList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankid != null ? bankid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.bankid == null && other.bankid != null) || (this.bankid != null && !this.bankid.equals(other.bankid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Bank[ bankid=" + bankid + " ]";
    }

}
