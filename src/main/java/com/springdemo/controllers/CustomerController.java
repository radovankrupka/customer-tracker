package com.springdemo.controllers;

import com.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springdemo.DAO.CustomerDAO;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;


@RequestMapping("/list")
public String listCustomers(Model model){


    List<Customer> customerList = customerDAO.getCustomers();
    model.addAttribute("customerList", customerList );
    System.out.println("customer list");
    return "customer-list";

}

}
