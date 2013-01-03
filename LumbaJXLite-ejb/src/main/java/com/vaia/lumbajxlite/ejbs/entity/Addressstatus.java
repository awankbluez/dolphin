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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"addressstatuscode"})})
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Addressstatus.findAll", query = "SELECT a FROM Addressstatus a"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findByAddressstatusid", query = "SELECT a FROM Addressstatus a WHERE a.addressstatusid = :addressstatusid"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findByAddressstatuscode", query = "SELECT a FROM Addressstatus a WHERE a.addressstatuscode = :addressstatuscode"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findByAddressstatusdescribe", query = "SELECT a FROM Addressstatus a WHERE a.addressstatusdescribe = :addressstatusdescribe"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findByCreationdate", query = "SELECT a FROM Addressstatus a WHERE a.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findByEditdate", query = "SELECT a FROM Addressstatus a WHERE a.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findByCreator", query = "SELECT a FROM Addressstatus a WHERE a.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findByEditor", query = "SELECT a FROM Addressstatus a WHERE a.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Addressstatus.findBySessiondate", query = "SELECT a FROM Addressstatus a WHERE a.sessiondate = :sessiondate")})
public class Addressstatus
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer addressstatusid;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private char addressstatuscode;
    @Size(max = 100)
    @Column(length = 100)
    private String addressstatusdescribe;
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
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    @OneToMany(mappedBy = "addressstatusid")
    private List<Address> addressList;

    public Addressstatus() {
    }

    public Addressstatus(Integer addressstatusid) {
        this.addressstatusid = addressstatusid;
    }

    public Addressstatus(Integer addressstatusid, char addressstatuscode) {
        this.addressstatusid = addressstatusid;
        this.addressstatuscode = addressstatuscode;
    }

    public Integer getAddressstatusid() {
        return this.addressstatusid;
    }

    public void setAddressstatusid(Integer addressstatusid) {
        this.addressstatusid = addressstatusid;
    }

    public char getAddressstatuscode() {
        return this.addressstatuscode;
    }

    public void setAddressstatuscode(char addressstatuscode) {
        this.addressstatuscode = addressstatuscode;
    }

    public String getAddressstatusdescribe() {
        return this.addressstatusdescribe;
    }

    public void setAddressstatusdescribe(String addressstatusdescribe) {
        this.addressstatusdescribe = addressstatusdescribe;
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

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
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
        hash += (this.addressstatusid != null ? this.addressstatusid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Addressstatus)) {
            return false;
        }
        Addressstatus other = (Addressstatus) object;
        if (((this.addressstatusid == null) && (other.addressstatusid != null)) || ((this.addressstatusid != null) && (!this.addressstatusid.equals(other.addressstatusid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Addressstatus[ addressstatusid=" + this.addressstatusid + " ]";
    }
}