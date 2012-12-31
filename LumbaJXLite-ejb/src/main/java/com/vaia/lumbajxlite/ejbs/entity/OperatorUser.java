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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MBS Development Team
 */
@Entity
@Table(catalog = "DB_LUMBA", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username", "email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operatoruser.findAll", query = "SELECT o FROM Operatoruser o"),
    @NamedQuery(name = "Operatoruser.findByUsernamePassword", query = "SELECT o FROM Operatoruser o WHERE o.username = :username AND o.password = :password"),
    @NamedQuery(name = "Operatoruser.findByUserid", query = "SELECT o FROM Operatoruser o WHERE o.userid = :userid"),
    @NamedQuery(name = "Operatoruser.findByUsername", query = "SELECT o FROM Operatoruser o WHERE o.username = :username"),
    @NamedQuery(name = "Operatoruser.findByPassword", query = "SELECT o FROM Operatoruser o WHERE o.password = :password"),
    @NamedQuery(name = "Operatoruser.findByEmployeeid", query = "SELECT o FROM Operatoruser o WHERE o.employeeid = :employeeid"),
    @NamedQuery(name = "Operatoruser.findByEmployeename", query = "SELECT o FROM Operatoruser o WHERE o.employeename = :employeename"),
    @NamedQuery(name = "Operatoruser.findByEmail", query = "SELECT o FROM Operatoruser o WHERE o.email = :email"),
    @NamedQuery(name = "Operatoruser.findByUserstatus", query = "SELECT o FROM Operatoruser o WHERE o.userstatus = :userstatus"),
    @NamedQuery(name = "Operatoruser.findByHelp", query = "SELECT o FROM Operatoruser o WHERE o.help = :help"),
    @NamedQuery(name = "Operatoruser.findByCreationdate", query = "SELECT o FROM Operatoruser o WHERE o.creationdate = :creationdate"),
    @NamedQuery(name = "Operatoruser.findByEditdate", query = "SELECT o FROM Operatoruser o WHERE o.editdate = :editdate"),
    @NamedQuery(name = "Operatoruser.findByCreator", query = "SELECT o FROM Operatoruser o WHERE o.creator = :creator"),
    @NamedQuery(name = "Operatoruser.findByEditor", query = "SELECT o FROM Operatoruser o WHERE o.editor = :editor"),
    @NamedQuery(name = "Operatoruser.findByCash", query = "SELECT o FROM Operatoruser o WHERE o.cash = :cash"),
    @NamedQuery(name = "Operatoruser.findBySessiondate", query = "SELECT o FROM Operatoruser o WHERE o.sessiondate = :sessiondate"),
    @NamedQuery(name = "Operatoruser.findByOveridesettlementamount", query = "SELECT o FROM Operatoruser o WHERE o.overidesettlementamount = :overidesettlementamount"),
    @NamedQuery(name = "Operatoruser.findByCreatorid", query = "SELECT o FROM Operatoruser o WHERE o.creatorid = :creatorid"),
    @NamedQuery(name = "Operatoruser.findByEditorid", query = "SELECT o FROM Operatoruser o WHERE o.editorid = :editorid")})
public class OperatorUser implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String USER_CHECK_LOGIN = "Operatoruser.findByUsernamePassword";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer userid;
    @Size(max = 50)
    @Column(length = 50, unique = true)
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(length = 40, unique = true)
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    private ChartOfAccount userterminalcontra;
    @JoinColumn(name = "userterminalsuspense", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private ChartOfAccount userterminalsuspense;
    @JoinColumn(name = "userterminalchequecontra", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private ChartOfAccount userterminalchequecontra;
    @JoinColumn(name = "userterminaldeficitsurplus", referencedColumnName = "chartofaccountid")
    @ManyToOne
    private ChartOfAccount userterminaldeficitsurplus;

    public OperatorUser() {
    }

    public OperatorUser(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Boolean userstatus) {
        this.userstatus = userstatus;
    }

    public Boolean getHelp() {
        return help;
    }

    public void setHelp(Boolean help) {
        this.help = help;
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

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Date getSessiondate() {
        return sessiondate;
    }

    public void setSessiondate(Date sessiondate) {
        this.sessiondate = sessiondate;
    }

    public Boolean getOveridesettlementamount() {
        return overidesettlementamount;
    }

    public void setOveridesettlementamount(Boolean overidesettlementamount) {
        this.overidesettlementamount = overidesettlementamount;
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public Integer getEditorid() {
        return editorid;
    }

    public void setEditorid(Integer editorid) {
        this.editorid = editorid;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Position getPositionid() {
        return positionid;
    }

    public void setPositionid(Position positionid) {
        this.positionid = positionid;
    }

    public Masteroperational getMasteroperationalid() {
        return masteroperationalid;
    }

    public void setMasteroperationalid(Masteroperational masteroperationalid) {
        this.masteroperationalid = masteroperationalid;
    }

    public Division getDivisionid() {
        return divisionid;
    }

    public void setDivisionid(Division divisionid) {
        this.divisionid = divisionid;
    }

    public Directorate getDirectorateid() {
        return directorateid;
    }

    public void setDirectorateid(Directorate directorateid) {
        this.directorateid = directorateid;
    }

    public ChartOfAccount getUserterminalcontra() {
        return userterminalcontra;
    }

    public void setUserterminalcontra(ChartOfAccount userterminalcontra) {
        this.userterminalcontra = userterminalcontra;
    }

    public ChartOfAccount getUserterminalsuspense() {
        return userterminalsuspense;
    }

    public void setUserterminalsuspense(ChartOfAccount userterminalsuspense) {
        this.userterminalsuspense = userterminalsuspense;
    }

    public ChartOfAccount getUserterminalchequecontra() {
        return userterminalchequecontra;
    }

    public void setUserterminalchequecontra(ChartOfAccount userterminalchequecontra) {
        this.userterminalchequecontra = userterminalchequecontra;
    }

    public ChartOfAccount getUserterminaldeficitsurplus() {
        return userterminaldeficitsurplus;
    }

    public void setUserterminaldeficitsurplus(ChartOfAccount userterminaldeficitsurplus) {
        this.userterminaldeficitsurplus = userterminaldeficitsurplus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperatorUser)) {
            return false;
        }
        OperatorUser other = (OperatorUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Operator user [id = %s, userName = %s, employeeName = %s, email = %s, userStatus = %s]", userid, username, employeename, email, userstatus);
    }
}
