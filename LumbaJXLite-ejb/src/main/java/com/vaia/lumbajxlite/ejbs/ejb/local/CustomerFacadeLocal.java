package com.vaia.lumbajxlite.ejbs.ejb.local;

import com.vaia.lumbajxlite.ejbs.entity.Customer;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface CustomerFacadeLocal {

    public abstract List<Customer> findExistingCustomer(Customer paramCustomer);
}