package com.springdemo.service;

import com.springdemo.DAO.CustomerDAO;
import com.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;


@Service
@Qualifier("customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers(String sortType) {
        List<Customer> customerList = customerDAO.getCustomers(sortType);
        /*customerList.sort(Comparator.comparing(Customer::getLast_name));*/
        return customerList;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {

        return customerDAO.getCustomerById(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int ID) {
        customerDAO.deleteCustomer(ID);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchText) {

        return customerDAO.searchCustomers(searchText);
    }


}
