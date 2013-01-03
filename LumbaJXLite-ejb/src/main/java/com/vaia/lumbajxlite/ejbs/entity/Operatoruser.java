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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(schema = "public", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Operatoruser.findAll", query = "SELECT o FROM Operatoruser o"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByUserid", query = "SELECT o FROM Operatoruser o WHERE o.userid = :userid"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByUsername", query = "SELECT o FROM Operatoruser o WHERE o.username = :username"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByPassword", query = "SELECT o FROM Operatoruser o WHERE o.password = :password"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByEmployeeid", query = "SELECT o FROM Operatoruser o WHERE o.employeeid = :employeeid"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByEmployeename", query = "SELECT o FROM Operatoruser o WHERE o.employeename = :employeename"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByEmail", query = "SELECT o FROM Operatoruser o WHERE o.email = :email"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByUserstatus", query = "SELECT o FROM Operatoruser o WHERE o.userstatus = :userstatus"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByHelp", query = "SELECT o FROM Operatoruser o WHERE o.help = :help"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByCreationdate", query = "SELECT o FROM Operatoruser o WHERE o.creationdate = :creationdate"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByEditdate", query = "SELECT o FROM Operatoruser o WHERE o.editdate = :editdate"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByCreator", query = "SELECT o FROM Operatoruser o WHERE o.creator = :creator"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByEditor", query = "SELECT o FROM Operatoruser o WHERE o.editor = :editor"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByCash", query = "SELECT o FROM Operatoruser o WHERE o.cash = :cash"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findBySessiondate", query = "SELECT o FROM Operatoruser o WHERE o.sessiondate = :sessiondate"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByOveridesettlementamount", query = "SELECT o FROM Operatoruser o WHERE o.overidesettlementamount = :overidesettlementamount"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByCreatorid", query = "SELECT o FROM Operatoruser o WHERE o.creatorid = :creatorid"),
    @javax.persistence.NamedQuery(name = "Operatoruser.findByEditorid", query = "SELECT o FROM Operatoruser o WHERE o.editorid = :editorid")})
public class Operatoruser
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer userid;
    @Size(max = 50)
    @Column(length = 50)
    private String username;
    @Size(max = 100)
    @Column(length = 100)
    private String password;
    @Size(max = 40)
    @Column(length = 40)
    private String employeeid;
    @Size(max = 100)
    @Column(length = 100)
    private String employeename;
    @Size(max = 40)
    @Column(length = 40)
    private String email;
    private Boolean userstatus;
    private Boolean help;
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
    @Column(precision = 17, scale = 17)
    private Double cash;
    @Temporal(TemporalType.DATE)
    private Date sessiondate;
    private Boolean overidesettlementamount;
    private Integer creatorid;
    private Integer editorid;
    @OneToMany(mappedBy = "userid")
    private List<Customer> customerList;
    @JoinColumn(name = "positionid", referencedColumnName = "positionid")
    @ManyToOne
    private Position positionid;
    @JoinColumn(name = "masteroperationalid", referencedColumnName = "masteroperationalid")
    @ManyToOne
    private Masteroperational masteroperationalid;
    @JoinColumn(name = "divisionid", referencedColumnName = "divisionid")
    @ManyToOne
    private Division divisionid;
    @JoinColumn(name = "directorateid", referencedColumnName = "directorateid")
    @ManyToOne
    private Directorate directorateid;
    @JoinColumn(name = "userterminalcontra", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount userterminalcontra;
    @JoinColumn(name = "userterminalsuspense", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount userterminalsuspense;
    @JoinColumn(name = "userterminalchequecontra", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount userterminalchequecontra;
    @JoinColumn(name = "userterminaldeficitsurplus", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private Chartofaccount userterminaldeficitsurplus;

    public Operatoruser() {
    }

    public Operatoruser(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return this.employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getUserstatus() {
        return this.userstatus;
    }

    public void setUserstatus(Boolean userstatus) {
        this.userstatus = userstatus;
    }

    public Boolean getHelp() {
        return this.help;
    }

    public void setHelp(Boolean help) {
        this.help = help;
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

    public Double getCash() {
        return this.cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Date getSessiondate() {
        return this.sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Boolean getOveridesettlementamount() {
        return this.overidesettlementamount;
    }

    public void setOveridesettlementamount(Boolean overidesettlementamount) {
        this.overidesettlementamount = overidesettlementamount;
    }

    public Integer getCreatorid() {
        return this.creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public Integer getEditorid() {
        return this.editorid;
    }

    public void setEditorid(Integer editorid) {
        this.editorid = editorid;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Position getPositionid() {
        return this.positionid;
    }

    public void setPositionid(Position positionid) {
        this.positionid = positionid;
    }

    public Masteroperational getMasteroperationalid() {
        return this.masteroperationalid;
    }

    public void setMasteroperationalid(Masteroperational masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Division getDivisionid() {
        return this.divisionid;
    }

    public void setDivisionid(Division divisionid) {
        this.divisionid = divisionid;
    }

    public Directorate getDirectorateid() {
        return this.directorateid;
    }

    public void setDirectorateid(Directorate directorateid) {
        this.directorateid = directorateid;
    }

    public Chartofaccount getUserterminalcontra() {
        return this.userterminalcontra;
    }

    public void setUserterminalcontra(Chartofaccount userterminalcontra) {
        this.userterminalcontra = userterminalcontra;
    }

    public Chartofaccount getUserterminalsuspense() {
        return this.userterminalsuspense;
    }

    public void setUserterminalsuspense(Chartofaccount userterminalsuspense) {
        this.userterminalsuspense = userterminalsuspense;
    }

    public Chartofaccount getUserterminalchequecontra() {
        return this.userterminalchequecontra;
    }

    public void setUserterminalchequecontra(Chartofaccount userterminalchequecontra) {
        this.userterminalchequecontra = userterminalchequecontra;
    }

    public Chartofaccount getUserterminaldeficitsurplus() {
        return this.userterminaldeficitsurplus;
    }

    public void setUserterminaldeficitsurplus(Chartofaccount userterminaldeficitsurplus) {
        this.userterminaldeficitsurplus = userterminaldeficitsurplus;
    }

    public int hashCode() {
        int hash = 0;
        hash += (this.userid != null ? this.userid.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Operatoruser)) {
            return false;
        }
        Operatoruser other = (Operatoruser) object;
        if (((this.userid == null) && (other.userid != null)) || ((this.userid != null) && (!this.userid.equals(other.userid)))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "com.vaia.lumbajxlite.ejbs.entity.Operatoruser[ userid=" + this.userid + " ]";
    }
}