package com.akgoyal.customer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> findAll(){
		return (List<Customer>) customerRepository.findAll();
	}
	
	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}
	
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
}
