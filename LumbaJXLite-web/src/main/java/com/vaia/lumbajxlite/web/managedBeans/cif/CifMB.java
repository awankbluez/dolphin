package com.vaia.lumbajxlite.web.managedBeans.cif;

import com.vaia.lumbajxlite.ejbs.ejb.local.CountryFacadeLocal;
import com.vaia.lumbajxlite.ejbs.ejb.local.CustomerFacadeLocal;
import com.vaia.lumbajxlite.ejbs.ejb.local.DistrictFacadeLocal;
import com.vaia.lumbajxlite.ejbs.ejb.local.ParameterFacadeLocal;
import com.vaia.lumbajxlite.ejbs.ejb.local.ProvinceFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Country;
import com.vaia.lumbajxlite.ejbs.entity.Customer;
import com.vaia.lumbajxlite.ejbs.entity.District;
import com.vaia.lumbajxlite.ejbs.entity.Grouping;
import com.vaia.lumbajxlite.ejbs.entity.Groupmember;
import com.vaia.lumbajxlite.ejbs.entity.Parameter;
import com.vaia.lumbajxlite.ejbs.entity.Province;
import com.vaia.lumbajxlite.web.managedBeans.AbstractManagedBean;
import com.vaia.lumbajxlite.web.managedBeans.applicationBean.UserSessionMB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "cifBean")
@ViewScoped
public class CifMB extends AbstractManagedBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(CifMB.class);
    private final Integer CUST_TYPE_INDV = Integer.valueOf(12);
    private final Integer CUST_TYPE_COMP = Integer.valueOf(13);
    private final Integer CUST_TYPE_COMM = Integer.valueOf(14);
    private final Integer STATUS_CREATE = Integer.valueOf(4);
    private final Integer STATUS_FOUND = Integer.valueOf(3);
    private final Integer STATUS_NOT_FOUND = Integer.valueOf(2);
    private final Integer STATUS_SEARCH = Integer.valueOf(1);
    private final Integer GENDER_MALE = Integer.valueOf(15);
    private final Integer GENDER_FEMALE = Integer.valueOf(16);
    @EJB
    private ParameterFacadeLocal parameterService;
    @EJB
    private CustomerFacadeLocal customerService;
    @EJB
    private CountryFacadeLocal countryService;
    @EJB
    private ProvinceFacadeLocal provinceService;
    @EJB
    private DistrictFacadeLocal districtSerice;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionMB userSessionMB;
    private Customer selectedCustomer;
    private Customer findCustomer;
    private String findCustomerName;
    private List<Customer> customerList;
    private List<Groupmember> groupMembers;
    private Grouping customerGrouping;
    private List<Parameter> customerType;
    private List<Parameter> genders;
    private List<Parameter> degreeStatus;
    private List<Parameter> degreeStatusDesc;
    private Integer status;
    private List<Country> countrys;
    private List<Province> provinces;
    private List<District> districts;

    @PostConstruct
    private void initialize() {
        this.selectedCustomer = new Customer();
        this.findCustomer = new Customer();
        this.customerList = new ArrayList();
        this.customerType = new ArrayList();
        this.status = this.STATUS_SEARCH;
        customerGrouping = new Grouping();
        populateBasicData();
    }

    private void populateBasicData() {
        this.customerType = this.parameterService.findByCode("tipe nasabah");
        this.genders = this.parameterService.findByCode("jenis kelamin");
        degreeStatus = parameterService.findByCode("status/gelar");
        degreeStatusDesc = parameterService.findByCode("keterangan status/gelar");
        countrys = countryService.findAll();
    }

    public void searchCustomer() {
        this.customerList = this.customerService.findExistingCustomer(this.findCustomer);

        if (this.customerList.isEmpty()) {
            this.status = this.STATUS_NOT_FOUND;
        } else {
            this.status = this.STATUS_FOUND;
        }
    }

    public void populateProvince() {
        if (this.selectedCustomer.getPerson().getAddress().getCountry().getCountryid() != null) {
            provinces = provinceService.retrieveAllByCountry(selectedCustomer.getPerson().getAddress().getCountry());
        } else {
            provinces = new ArrayList<>();
        }
    }

    public void populateDistrict() {
        if (this.selectedCustomer.getPerson().getAddress().getProvince().getProvinceid() != null) {
            districts = districtSerice.retrieveAllByProvince(selectedCustomer.getPerson().getAddress().getProvince());
        } else {
            districts = new ArrayList<>();
        }
    }

    public void createCustomer() throws SQLException {
        boolean statuscreate = false;

        selectedCustomer.setCreator(userSessionMB.getAuthenticatedUser().getUserid());

        if (selectedCustomer.getCustomertype().equals(CUST_TYPE_INDV)) {
            statuscreate = customerService.createIndividualCustomer(selectedCustomer);
        } else if (selectedCustomer.getCustomertype().equals(CUST_TYPE_COMP)) {
        } else if (selectedCustomer.getCustomertype().equals(CUST_TYPE_COMM)) {
        }

        if (statuscreate) {
            initialize();
            displayInfoMessageToUser("Successfull create customer.");
        } else {
            displayErrorMessageToUser("Failed create customer.");
        }
    }

    /**
     * Getter Setter -----------------------------------------------------------
     */
    public Customer getSelectedCustomer() {
        return this.selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public Customer getFindCustomer() {
        return this.findCustomer;
    }

    public void setFindCustomer(Customer findCustomer) {
        this.findCustomer = findCustomer;
    }

    public String getFindCustomerName() {
        return this.findCustomerName;
    }

    public void setFindCustomerName(String findCustomerName) {
        this.findCustomerName = findCustomerName;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Parameter> getCustomerType() {
        return this.customerType;
    }

    public void setCustomerType(List<Parameter> customerType) {
        this.customerType = customerType;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCUST_TYPE_INDV() {
        return this.CUST_TYPE_INDV;
    }

    public Integer getCUST_TYPE_COMP() {
        return this.CUST_TYPE_COMP;
    }

    public Integer getCUST_TYPE_COMM() {
        return this.CUST_TYPE_COMM;
    }

    public Integer getSTATUS_CREATE() {
        return this.STATUS_CREATE;
    }

    public Integer getSTATUS_FOUND() {
        return this.STATUS_FOUND;
    }

    public Integer getSTATUS_NOT_FOUND() {
        return this.STATUS_NOT_FOUND;
    }

    public Integer getSTATUS_SEARCH() {
        return this.STATUS_SEARCH;
    }

    public List<Parameter> getGenders() {
        return this.genders;
    }

    public void setGenders(List<Parameter> genders) {
        this.genders = genders;
    }

    public Integer getGENDER_MALE() {
        return this.GENDER_MALE;
    }

    public Integer getGENDER_FEMALE() {
        return this.GENDER_FEMALE;
    }

    public List<Parameter> getDegreeStatus() {
        return this.degreeStatus;
    }

    public void setDegreeStatus(List<Parameter> degreeStatus) {
        this.degreeStatus = degreeStatus;
    }

    public List<Parameter> getDegreeStatusDesc() {
        return this.degreeStatusDesc;
    }

    public void setDegreeStatusDesc(List<Parameter> degreeStatusDesc) {
        this.degreeStatusDesc = degreeStatusDesc;
    }

    public List<Country> getCountrys() {
        return this.countrys;
    }

    public void setCountrys(List<Country> countrys) {
        this.countrys = countrys;
    }

    public List<Province> getProvinces() {
        return this.provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public List<District> getDistricts() {
        return this.districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<Groupmember> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<Groupmember> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Grouping getCustomerGrouping() {
        return customerGrouping;
    }

    public void setCustomerGrouping(Grouping customerGrouping) {
        this.customerGrouping = customerGrouping;
    }

    public UserSessionMB getUserSessionMB() {
        return userSessionMB;
    }

    public void setUserSessionMB(UserSessionMB userSessionMB) {
        this.userSessionMB = userSessionMB;
    }
}