package com.ethien.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.ethien.springboot.model.Customer;
import java.lang.String;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	List<Customer> findByLastname(String lastname);

}
