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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"villagecode"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Village.findAll", query = "SELECT v FROM Village v"),
    @NamedQuery(name = "Village.findByVillageid", query = "SELECT v FROM Village v WHERE v.villageid = :villageid"),
    @NamedQuery(name = "Village.findByVillagecode", query = "SELECT v FROM Village v WHERE v.villagecode = :villagecode"),
    @NamedQuery(name = "Village.findByVillagename", query = "SELECT v FROM Village v WHERE v.villagename = :villagename"),
    @NamedQuery(name = "Village.findByCreationdate", query = "SELECT v FROM Village v WHERE v.creationdate = :creationdate"),
    @NamedQuery(name = "Village.findByEditdate", query = "SELECT v FROM Village v WHERE v.editdate = :editdate"),
    @NamedQuery(name = "Village.findByCreator", query = "SELECT v FROM Village v WHERE v.creator = :creator"),
    @NamedQuery(name = "Village.findByEditor", query = "SELECT v FROM Village v WHERE v.editor = :editor"),
    @NamedQuery(name = "Village.findBySessiondate", query = "SELECT v FROM Village v WHERE v.sessiondate = :sessiondate")})
public class Village implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer villageid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String villagecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String villagename;
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
    @JoinColumn(name = "subdistrictid", referencedColumnName = "subdistrictid")
    @ManyToOne
    private Subdistrict subdistrictid;
    @OneToMany(mappedBy = "villageid")
    private List<Masteroperational> masteroperationalList;
    @OneToMany(mappedBy = "villageid")
    private List<Address> addressList;

    public Village() {
    }

    public Village(Integer villageid) {
        this.villageid = villageid;
    }

    public Village(Integer villageid, String villagecode, String villagename) {
        this.villageid = villageid;
        this.villagecode = villagecode;
        this.villagename = villagename;
    }

    public Integer getVillageid() {
        return villageid;
    }

    public void setVillageid(Integer villageid) {
        this.villageid = villageid;
    }

    public String getVillagecode() {
        return villagecode;
    }

    public void setVillagecode(String villagecode) {
        this.villagecode = villagecode;
    }

    public String getVillagename() {
        return villagename;
    }

    public void setVillagename(String villagename) {
        this.villagename = villagename;
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

    public Subdistrict getSubdistrictid() {
        return subdistrictid;
    }

    public void setSubdistrictid(Subdistrict subdistrictid) {
        this.subdistrictid = subdistrictid;
    }

    @XmlTransient
    public List<Masteroperational> getMasteroperationalList() {
        return masteroperationalList;
    }

    public void setMasteroperationalList(List<Masteroperational> masteroperationalList) {
        this.masteroperationalList = masteroperationalList;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (villageid != null ? villageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Village)) {
            return false;
        }
        Village other = (Village) object;
        if ((this.villageid == null && other.villageid != null) || (this.villageid != null && !this.villageid.equals(other.villageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Village[ villageid=" + villageid + " ]";
    }

}
