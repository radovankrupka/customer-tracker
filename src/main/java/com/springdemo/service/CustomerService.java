package com.springdemo.service;

import com.springdemo.entity.Customer;
import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers(String sortType);

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void deleteCustomer(int ID);

    List<Customer> searchCustomers(String searchText);
}
