package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Customer;
import com.vaia.lumbajxlite.ejbs.entity.Grouping;
import com.vaia.lumbajxlite.ejbs.entity.Groupmember;
import java.security.acl.Group;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface CustomerFacadeLocal {

    public abstract List<Customer> findExistingCustomer(Customer paramCustomer);

    boolean createIndividualCustomer(Customer customer) throws SQLException;

    boolean createCompanyCustoemr(Customer customer) throws SQLException;

    boolean createCommunityCustomer(Customer customer, Grouping grouping) throws SQLException;
}