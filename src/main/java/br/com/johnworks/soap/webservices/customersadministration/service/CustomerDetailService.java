package br.com.johnworks.soap.webservices.customersadministration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.johnworks.soap.webservices.customersadministration.entity.Customer;
import br.com.johnworks.soap.webservices.customersadministration.entity.enumerations.Status;
import br.com.johnworks.soap.webservices.customersadministration.repository.CustomerRepository;

@Service
public class CustomerDetailService {
	
	private CustomerRepository repository;

	public CustomerDetailService(CustomerRepository customerRepository) {
		super();
		this.repository = customerRepository;
	}
	
	public Status insert(Customer customer) {
		try {
			repository.save(customer);
			return Status.SUCESS;
		}catch (Exception e) {
			return Status.FAILURE;
		}
	}
	
	public Status delete(Integer id) {
		try {
			repository.deleteById(id);
			return Status.SUCESS;
		}catch (Exception e) {
			return Status.FAILURE;
		}
	}
	
	public Optional<Customer> findById(Integer id) {
		Optional<Customer> customer = repository.findById(id);
		return customer;
	}
	
	public List<Customer> findAll() {
		List<Customer> customers = repository.findAll();
		return customers;
	}
	
}
