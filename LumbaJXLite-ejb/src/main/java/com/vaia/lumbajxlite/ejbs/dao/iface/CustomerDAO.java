package com.vaia.lumbajxlite.ejbs.dao.iface;

import com.vaia.lumbajxlite.ejbs.dao.BaseDAO;
import com.vaia.lumbajxlite.ejbs.entity.Customer;
import com.vaia.lumbajxlite.ejbs.entity.Grouping;
import java.sql.SQLException;
import java.util.List;

public abstract interface CustomerDAO extends BaseDAO {

    public abstract List<Customer> findExistingCustomer(Customer paramCustomer);

    boolean createIndividualCustomer(Customer customer) throws SQLException;

    boolean createCompanyCustoemr(Customer customer) throws SQLException;

    boolean createCommunityCustomer(Customer customer, Grouping grouping) throws SQLException;
}