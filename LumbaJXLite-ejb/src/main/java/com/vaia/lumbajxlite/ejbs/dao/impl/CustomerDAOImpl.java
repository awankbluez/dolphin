package com.vaia.lumbajxlite.ejbs.dao.impl;

import com.vaia.lumbajxlite.ejbs.dao.DAOUtil;
import static com.vaia.lumbajxlite.ejbs.dao.DAOUtil.*;
import com.vaia.lumbajxlite.ejbs.dao.iface.CustomerDAO;
import com.vaia.lumbajxlite.ejbs.entity.Address;
import com.vaia.lumbajxlite.ejbs.entity.Customer;
import com.vaia.lumbajxlite.ejbs.entity.Grouping;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDAOImpl
        implements CustomerDAO {

    private static final long serialVersionUID = 1L;
    private Connection connection;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDAOImpl.class);
    private static final String SP_CIF_MANAGEMENT_SEARCH = "{call cif_management_search(?,?,?,?)}";
    private static final String SP_CREATE_CIF_INDIVIDUAL_ANALISYS = "{call cif_management_individual_analysis_insert()}";
    private static final String SP_CREATE_CIF_INDIVIDUAL = "{call cif_management_individual_personaldatacustomeraddress_insert(?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?,?,?,"
            + "?,?)}";

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Customer> findExistingCustomer(Customer customer) {
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        List customers = new ArrayList();
        Object[] parameters = {customer.getCustomercode(), customer.getPerson().getSocialsecuritynumber(), customer.getName1(), customer.getPerson().getMothermaiden()};
        try {
            callableStatement = DAOUtil.callableStatement(this.connection, "{call cif_management_search(?,?,?,?)}", parameters);
            resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                Customer returnedCustomer = map(resultSet);
                customers.add(returnedCustomer);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            DAOUtil.close(callableStatement, resultSet);
        }

        return customers;
    }

    @Override
    public boolean createIndividualCustomer(Customer customer) throws SQLException {
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        boolean status = false;

        try {
            connection.setAutoCommit(false);
            Object[] parameterIndividu = {
                customer.getCustomertype(),
                customer.getDegreestatus(),
                customer.getDegreedesc(),
                customer.getName1(),
                customer.getName2(),
                customer.getName3(),
                customer.getName4(),
                customer.getAliasname(),
                customer.getPhotoid(),
                customer.getSignatureid(),
                customer.getPerson().getGender(),
                customer.getPerson().getMothermaiden(),
                customer.getPerson().getSocialsecuritynumber(),
                customer.getPerson().getPassportnumber(),
                customer.getPerson().getNpwp(),
                customer.getPerson().getPlaceofbirth(),
                toSqlDate(customer.getPerson().getDateofbirth()),
                customer.getPerson().getAddress().getAddress(),
                customer.getPerson().getAddress().getPostcode(),
                customer.getPerson().getAddress().getVillage(),
                customer.getPerson().getAddress().getSubdistrict(),
                customer.getPerson().getAddress().getDistrict().getDistrictid(),
                customer.getPerson().getAddress().getProvince().getProvinceid(),
                customer.getPerson().getAddress().getCountry().getCountryid(),
                customer.getPerson().getAddress().getMobilephonenumber(),
                customer.getPerson().getAddress().getPhonenumbercode(),
                customer.getPerson().getAddress().getPhonenumber(),
                customer.getPerson().getAddress().getOfficephonenumbercode(),
                customer.getPerson().getAddress().getOfficephonenumber(),
                customer.getPerson().getAddress().getWebsite(),
                customer.getPerson().getAddress().getEmail(),
                customer.getCreator()
            };

            try {
                callableStatement = DAOUtil.callableStatement(connection, SP_CREATE_CIF_INDIVIDUAL, parameterIndividu);
                resultSet = callableStatement.executeQuery();
                status = true;
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.error(e.getMessage());
            }

//            if(){}

            connection.commit();
            
        } catch (SQLException e) {
            connection.rollback();
            LOGGER.error(e.getMessage());
        } finally {
            connection.setAutoCommit(true);
            DAOUtil.close(callableStatement, resultSet);
        }

        return status;
    }

    @Override
    public boolean createCompanyCustoemr(Customer customer) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean createCommunityCustomer(Customer customer, Grouping grouping) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static Customer map(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomercode(resultSet.getString("customercode"));
        customer.setName1(resultSet.getString("name1"));
        customer.setName2(resultSet.getString("name2"));
        customer.setName3(resultSet.getString("name3"));
        customer.setName4(resultSet.getString("name4"));
        customer.getPerson().setGender(Integer.valueOf(resultSet.getInt("gender")));
        customer.getPerson().setMothermaiden(resultSet.getString("mothermaiden"));

        Address address = new Address();
        address.setAddress(resultSet.getString("address"));
        customer.getPerson().setAddress(address);

        return customer;
    }
}
