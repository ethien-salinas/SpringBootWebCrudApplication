package com.ethien.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ethien.springboot.dao.CustomerRepository;
import com.ethien.springboot.model.Customer;

@Controller
public class GreetingController {

	@Autowired
	CustomerRepository customerRepository;
	
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/findOne")
    public String findOneCustomer(@RequestParam(value="id", required=false, defaultValue="1") int id, Model model) {
        model.addAttribute("name", customerRepository.findOne(id));
        return "greeting";
    }
    
    @RequestMapping("/findAll")
    public String findAllCustomers(Model model) {
        model.addAttribute("name", customerRepository.findAll());
        return "greeting";
    }
    
    @RequestMapping("/savechildren")
    public String saveCustomer(Model model) {
		// ***** Some objects to save *****
		Customer customer = new Customer();
		customer.setFirstname("Bar");
		customer.setLastname("Simpson");
		customer.setCity("Springfield");
		customer.setStreet("Evergreen Terrace");
		customerRepository.save(customer);
		
		customer.setFirstname("Lisa");
		customerRepository.save(customer);
		
		customer.setFirstname("Maggie");
		customerRepository.save(customer);
		
        model.addAttribute("name", "SAVED!!!");
        return "greeting";
    }

}
