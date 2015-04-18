package com.ethien.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ethien.springboot.dao.CustomerRepository;
import com.ethien.springboot.model.Customer;

@SpringBootApplication
public class SpringBootWebCrudApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository customerRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebCrudApplication.class, args);
    }
    
    @Override
    public void run(String... strings) throws Exception {
		// ***** Some objects to save at startup *****
    	Customer customer = new Customer();
		customer.setFirstname("Homer");
		customer.setLastname("Simpson");
		customer.setCity("Springfield");
		customer.setStreet("Evergreen Terrace");
		customerRepository.save(customer);

		Customer customer2 = new Customer();
		customer2.setFirstname("Marge");
		customer2.setLastname("Bubie");
		customer2.setCity("Springfield");
		customer2.setStreet("Evergreen Terrace");
		customerRepository.save(customer2);
				
		// ***** List the objects stored in the database at the moment *****
		System.out.println("***** findAll() *****");
		for (Customer c : customerRepository.findAll()) {
            System.out.println(c);
        }
		
		// ***** Update of one entity *****
		customer2.setLastname("Simpson");
		customerRepository.save(customer2);
		// ***** List the objects stored in the database at the moment *****
		System.out.println("***** findAll() *****");
		for (Customer c : customerRepository.findAll()) {
            System.out.println(c);
        }
		
		// ***** Deletion of on entity *****
		customerRepository.delete(customer2);
		// ***** List the objects stored in the database at the moment *****
		System.out.println("***** findAll() *****");
		for (Customer c : customerRepository.findAll()) {
            System.out.println(c);
        }
    }

}
