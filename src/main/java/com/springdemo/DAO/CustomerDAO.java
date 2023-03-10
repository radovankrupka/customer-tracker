package com.springdemo.DAO;

import com.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers(String sortType);

    public void saveCustomer(Customer customer);

    Customer getCustomerById(int id);

    void deleteCustomer(int ID);

    List<Customer> searchCustomers(String searchText);
}
