package org.heastie.controller;

import org.heastie.dao.CustomerDAO;
import org.heastie.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        //Get customers from the dao
        List<Customer> customers = customerDAO.getCustomers();

        //Add customers to model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
