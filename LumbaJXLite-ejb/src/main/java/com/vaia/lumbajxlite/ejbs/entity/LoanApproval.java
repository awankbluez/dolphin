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
@Table(schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loanapproval.findAll", query = "SELECT l FROM Loanapproval l"),
    @NamedQuery(name = "Loanapproval.findByLoanapprovalid", query = "SELECT l FROM Loanapproval l WHERE l.loanapprovalid = :loanapprovalid"),
    @NamedQuery(name = "Loanapproval.findByLoanapprovalgroup", query = "SELECT l FROM Loanapproval l WHERE l.loanapprovalgroup = :loanapprovalgroup"),
    @NamedQuery(name = "Loanapproval.findByMinimumloanlimit", query = "SELECT l FROM Loanapproval l WHERE l.minimumloanlimit = :minimumloanlimit"),
    @NamedQuery(name = "Loanapproval.findByMaximumloanlimit", query = "SELECT l FROM Loanapproval l WHERE l.maximumloanlimit = :maximumloanlimit"),
    @NamedQuery(name = "Loanapproval.findByCreationdate", query = "SELECT l FROM Loanapproval l WHERE l.creationdate = :creationdate"),
    @NamedQuery(name = "Loanapproval.findByEditdate", query = "SELECT l FROM Loanapproval l WHERE l.editdate = :editdate"),
    @NamedQuery(name = "Loanapproval.findByCreator", query = "SELECT l FROM Loanapproval l WHERE l.creator = :creator"),
    @NamedQuery(name = "Loanapproval.findByEditor", query = "SELECT l FROM Loanapproval l WHERE l.editor = :editor"),
    @NamedQuery(name = "Loanapproval.findBySessiondate", query = "SELECT l FROM Loanapproval l WHERE l.sessiondate = :sessiondate")})
public class Loanapproval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer loanapprovalid;
    @Size(max = 10)
    @Column(length = 10)
    private String loanapprovalgroup;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 17)
    private Double minimumloanlimit;
    @Column(precision = 17, scale = 17)
    private Double maximumloanlimit;
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
    @OneToMany(mappedBy = "loanapprovalid")
    private List<Loan> loanList;

    public Loanapproval() {
    }

    public Loanapproval(Integer loanapprovalid) {
        this.loanapprovalid = loanapprovalid;
    }

    public Integer getLoanapprovalid() {
        return loanapprovalid;
    }

    public void setLoanapprovalid(Integer loanapprovalid) {
        this.loanapprovalid = loanapprovalid;
    }

    public String getLoanapprovalgroup() {
        return loanapprovalgroup;
    }

    public void setLoanapprovalgroup(String loanapprovalgroup) {
        this.loanapprovalgroup = loanapprovalgroup;
    }

    public Double getMinimumloanlimit() {
        return minimumloanlimit;
    }

    public void setMinimumloanlimit(Double minimumloanlimit) {
        this.minimumloanlimit = minimumloanlimit;
    }

    public Double getMaximumloanlimit() {
        return maximumloanlimit;
    }

    public void setMaximumloanlimit(Double maximumloanlimit) {
        this.maximumloanlimit = maximumloanlimit;
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
    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanapprovalid != null ? loanapprovalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loanapproval)) {
            return false;
        }
        Loanapproval other = (Loanapproval) object;
        if ((this.loanapprovalid == null && other.loanapprovalid != null) || (this.loanapprovalid != null && !this.loanapprovalid.equals(other.loanapprovalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Loanapproval[ loanapprovalid=" + loanapprovalid + " ]";
    }

}
