package org.heastie.dao;

import org.heastie.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Customer> getCustomers() {

        //Get hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //Create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

        //Execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        //Return the results
        return customers;
    }
}
