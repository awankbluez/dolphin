package com.vaia.lumbajxlite.ejbs.dao.impl;

import com.vaia.lumbajxlite.ejbs.dao.DAOUtil;
import com.vaia.lumbajxlite.ejbs.dao.iface.CustomerDAO;
import com.vaia.lumbajxlite.ejbs.entity.Address;
import com.vaia.lumbajxlite.ejbs.entity.Customer;
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