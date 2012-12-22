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
    @NamedQuery(name = "Loancategory.findAll", query = "SELECT l FROM Loancategory l"),
    @NamedQuery(name = "Loancategory.findByLoancategoryid", query = "SELECT l FROM Loancategory l WHERE l.loancategoryid = :loancategoryid"),
    @NamedQuery(name = "Loancategory.findByLoancategoryname", query = "SELECT l FROM Loancategory l WHERE l.loancategoryname = :loancategoryname"),
    @NamedQuery(name = "Loancategory.findByMaximumloannumber", query = "SELECT l FROM Loancategory l WHERE l.maximumloannumber = :maximumloannumber"),
    @NamedQuery(name = "Loancategory.findByStartdate", query = "SELECT l FROM Loancategory l WHERE l.startdate = :startdate"),
    @NamedQuery(name = "Loancategory.findByEditdate", query = "SELECT l FROM Loancategory l WHERE l.editdate = :editdate"),
    @NamedQuery(name = "Loancategory.findByDescribe", query = "SELECT l FROM Loancategory l WHERE l.describe = :describe"),
    @NamedQuery(name = "Loancategory.findByUsescoring", query = "SELECT l FROM Loancategory l WHERE l.usescoring = :usescoring"),
    @NamedQuery(name = "Loancategory.findByMaximumloanactive", query = "SELECT l FROM Loancategory l WHERE l.maximumloanactive = :maximumloanactive"),
    @NamedQuery(name = "Loancategory.findBySessiondate", query = "SELECT l FROM Loancategory l WHERE l.sessiondate = :sessiondate"),
    @NamedQuery(name = "Loancategory.findByCreator", query = "SELECT l FROM Loancategory l WHERE l.creator = :creator"),
    @NamedQuery(name = "Loancategory.findByEditor", query = "SELECT l FROM Loancategory l WHERE l.editor = :editor")})
public class LoanCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer loancategoryid;
    @Size(max = 20)
    @Column(length = 20)
    private String loancategoryname;
    private Integer maximumloannumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdate;
    @Size(max = 100)
    @Column(length = 100)
    private String describe;
    private Boolean usescoring;
    private Integer maximumloanactive;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    private Integer creator;
    private Integer editor;
    @OneToMany(mappedBy = "loancategory")
    private List<Loan> loanList;

    public LoanCategory() {
    }

    public LoanCategory(Integer loancategoryid) {
        this.loancategoryid = loancategoryid;
    }

    public Integer getLoancategoryid() {
        return loancategoryid;
    }

    public void setLoancategoryid(Integer loancategoryid) {
        this.loancategoryid = loancategoryid;
    }

    public String getLoancategoryname() {
        return loancategoryname;
    }

    public void setLoancategoryname(String loancategoryname) {
        this.loancategoryname = loancategoryname;
    }

    public Integer getMaximumloannumber() {
        return maximumloannumber;
    }

    public void setMaximumloannumber(Integer maximumloannumber) {
        this.maximumloannumber = maximumloannumber;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Boolean getUsescoring() {
        return usescoring;
    }

    public void setUsescoring(Boolean usescoring) {
        this.usescoring = usescoring;
    }

    public Integer getMaximumloanactive() {
        return maximumloanactive;
    }

    public void setMaximumloanactive(Integer maximumloanactive) {
        this.maximumloanactive = maximumloanactive;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getEditor() {
        return editor;
    }

    public void setEditor(Integer editor) {
        this.editor = editor;
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
        hash += (loancategoryid != null ? loancategoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanCategory)) {
            return false;
        }
        LoanCategory other = (LoanCategory) object;
        if ((this.loancategoryid == null && other.loancategoryid != null) || (this.loancategoryid != null && !this.loancategoryid.equals(other.loancategoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Loancategory[ loancategoryid=" + loancategoryid + " ]";
    }

}
