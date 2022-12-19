package com.springdemo.controllers;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import com.springdemo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springdemo.DAO.CustomerDAO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


@RequestMapping("/list")
public String listCustomers(@RequestParam(value = "sort", required = false)String sortType, Model model){


    List<Customer> customerList = customerService.getCustomers(sortType);
    model.addAttribute("customerList", customerList );

    return "customer-list";
    }

@RequestMapping("/addCustomer")
    public String addCustomer(Model model){
    Customer customer = new Customer();
    model.addAttribute("customer",customer);
    return "add-customer-form";
    }

@RequestMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

    System.out.println(customer);
    customerService.saveCustomer(customer);
    return "redirect:/customer/list";
    }

@RequestMapping("/updateCustomer")
    public String updateCustomer(@RequestParam int ID, Model model ) {

    Customer customer = customerService.getCustomerById(ID);
    model.addAttribute("customer", customer);
    return "add-customer-form";
    }

    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int ID ){

        customerService.deleteCustomer(ID);

        return "redirect:/customer/list";
    }

    @RequestMapping("/search")
    public String searchCustomers(@RequestParam("searchText") String searchText, Model model ){

        List<Customer> customerList = customerService.searchCustomers(searchText);
        model.addAttribute("customerList", customerList );



        return "customer-list";
    }



}
