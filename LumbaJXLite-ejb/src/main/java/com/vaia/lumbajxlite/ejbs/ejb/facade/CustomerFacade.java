package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.FactoryDAO;
import com.vaia.lumbajxlite.ejbs.dao.iface.CustomerDAO;
import com.vaia.lumbajxlite.ejbs.ejb.local.CustomerFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Customer;
import com.vaia.lumbajxlite.ejbs.entity.Grouping;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class CustomerFacade
        implements CustomerFacadeLocal {

    private CustomerDAO customerDAO;

    @PostConstruct
    private void initialize() {
        this.customerDAO = ((CustomerDAO) FactoryDAO.getDAOImpl(CustomerDAO.class));
    }

    @Override
    public List<Customer> findExistingCustomer(Customer customer) {
        return this.customerDAO.findExistingCustomer(customer);
    }

    @Override
    public boolean createIndividualCustomer(Customer customer) throws SQLException {
        return customerDAO.createIndividualCustomer(customer);
    }

    @Override
    public boolean createCompanyCustoemr(Customer customer) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean createCommunityCustomer(Customer customer, Grouping grouping) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}