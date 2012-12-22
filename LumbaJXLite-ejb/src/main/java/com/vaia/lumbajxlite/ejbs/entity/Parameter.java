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
    @NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p"),
    @NamedQuery(name = "Parameter.findByParameterid", query = "SELECT p FROM Parameter p WHERE p.parameterid = :parameterid"),
    @NamedQuery(name = "Parameter.findByParametercode", query = "SELECT p FROM Parameter p WHERE p.parametercode = :parametercode"),
    @NamedQuery(name = "Parameter.findByName", query = "SELECT p FROM Parameter p WHERE p.name = :name"),
    @NamedQuery(name = "Parameter.findByCreationdate", query = "SELECT p FROM Parameter p WHERE p.creationdate = :creationdate"),
    @NamedQuery(name = "Parameter.findByEditdate", query = "SELECT p FROM Parameter p WHERE p.editdate = :editdate"),
    @NamedQuery(name = "Parameter.findByCreator", query = "SELECT p FROM Parameter p WHERE p.creator = :creator"),
    @NamedQuery(name = "Parameter.findByEditor", query = "SELECT p FROM Parameter p WHERE p.editor = :editor"),
    @NamedQuery(name = "Parameter.findBySessiondate", query = "SELECT p FROM Parameter p WHERE p.sessiondate = :sessiondate")})
public class Parameter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer parameterid;
    @Size(max = 22)
    @Column(length = 22)
    private String parametercode;
    @Size(max = 50)
    @Column(length = 50)
    private String name;
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
    @OneToMany(mappedBy = "companytype")
    private List<Customer> customerList;
    @OneToMany(mappedBy = "institution")
    private List<Customer> customerList1;
    @OneToMany(mappedBy = "othertypeinstitution")
    private List<Customer> customerList2;
    @OneToMany(mappedBy = "legal")
    private List<Customer> customerList3;

    public Parameter() {
    }

    public Parameter(Integer parameterid) {
        this.parameterid = parameterid;
    }

    public Integer getParameterid() {
        return parameterid;
    }

    public void setParameterid(Integer parameterid) {
        this.parameterid = parameterid;
    }

    public String getParametercode() {
        return parametercode;
    }

    public void setParametercode(String parametercode) {
        this.parametercode = parametercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public List<Customer> getCustomerList1() {
        return customerList1;
    }

    public void setCustomerList1(List<Customer> customerList1) {
        this.customerList1 = customerList1;
    }

    @XmlTransient
    public List<Customer> getCustomerList2() {
        return customerList2;
    }

    public void setCustomerList2(List<Customer> customerList2) {
        this.customerList2 = customerList2;
    }

    @XmlTransient
    public List<Customer> getCustomerList3() {
        return customerList3;
    }

    public void setCustomerList3(List<Customer> customerList3) {
        this.customerList3 = customerList3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parameterid != null ? parameterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        if ((this.parameterid == null && other.parameterid != null) || (this.parameterid != null && !this.parameterid.equals(other.parameterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Parameter[ parameterid=" + parameterid + " ]";
    }

}
