package com.vaia.lumbajxlite.ejbs.dao.iface;

import com.vaia.lumbajxlite.ejbs.dao.BaseDAO;
import com.vaia.lumbajxlite.ejbs.entity.Customer;
import java.util.List;

public abstract interface CustomerDAO extends BaseDAO {

    public abstract List<Customer> findExistingCustomer(Customer paramCustomer);
}