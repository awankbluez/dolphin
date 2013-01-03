package com.vaia.lumbajxlite.ejbs.ejb.facade;

import com.vaia.lumbajxlite.ejbs.dao.FactoryDAO;
import com.vaia.lumbajxlite.ejbs.dao.iface.CustomerDAO;
import com.vaia.lumbajxlite.ejbs.ejb.local.CustomerFacadeLocal;
import com.vaia.lumbajxlite.ejbs.entity.Customer;
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

    public List<Customer> findExistingCustomer(Customer customer) {
        return this.customerDAO.findExistingCustomer(customer);
    }
}