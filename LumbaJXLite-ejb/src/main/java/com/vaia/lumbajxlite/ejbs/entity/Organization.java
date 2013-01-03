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
    @javax.persistence.NamedQuery(name = "Organization.findAll", query = "SELECT o FROM Organization o"),
    @javax.persistence.NamedQuery(name = "Organization.findByOrganizationid", query = "SELECT o FROM Organization o WHERE o.organizationid = :organizationid"),
    @javax.persistence.NamedQuery(name = "Organization.findByOrganizationname", query = "SELECT o FROM Organization o WHERE o.organizationname = :organizationname"),
    @javax.persistence.NamedQuery(name = "Organization.findByCreationdate", query = "SELECT o FROM Organization o WHERE o.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Organization.findByEditdate", query = "SELECT o FROM Organization o WHERE o.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Organization.findByCreator", query = "SELECT o FROM Organization o WHERE o.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Organization.findByEditor", query = "SELECT o FROM Organization o WHERE o.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Organization.findBySessiondate", query = "SELECT o FROM Organization o WHERE o.sessiondate = :sessiondate")})
public class Organization
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer organizationid;
    @Size(max = 50)
    @Column(length = 50)
    private String organizationname;
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
    @OneToMany(mappedBy = "organizationid")
    private List<Customer> customerList;

    public Organization() {
    }

    public Organization(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public Integer getOrganizationid() {
        return this.organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public String getOrganizationname() {
        return this.organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
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
    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.organizationid != null ? this.organizationid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) object;
        if (((this.organizationid == null) && (other.organizationid != null)) || ((this.organizationid != null) && (!this.organizationid.equals(other.organizationid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Organization[ organizationid=" + this.organizationid + " ]";
    }
}