package com.springdemo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springdemo.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(String sortType) {

        Session currentSession = sessionFactory.getCurrentSession();

        if (sortType == null) sortType = "last_name"; //default to sorting by last name

        Query<Customer> query = currentSession.createQuery("from Customer order by " + sortType, Customer.class);

        List<Customer> customers = query.getResultList();

        return customers;

    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("ukladam: " + customer);
        /*if (customer.getID() == 0) session.save(customer);
        else session.update(customer);*/
        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomerById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int ID) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(currentSession.get(Customer.class,ID));
    }

    @Override
    public List<Customer> searchCustomers(String searchText) {
// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        //
        // only search by name if theSearchName is not empty
        //
        if (searchText != null && searchText.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(first_name) like :theName or lower(last_name) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + searchText.toLowerCase() + "%");
        }
        else {
            // theSearchName is empty ... so just get all customers
            System.out.println("empty search");
            theQuery = currentSession.createQuery("from Customer", Customer.class);
        }

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;    }


}
