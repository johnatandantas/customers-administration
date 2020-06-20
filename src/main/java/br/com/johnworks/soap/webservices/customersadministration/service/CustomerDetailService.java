package br.com.johnworks.soap.webservices.customersadministration.service;

import org.springframework.stereotype.Service;

import br.com.johnworks.soap.webservices.customersadministration.repository.CustomerRepository;

@Service
public class CustomerDetailService {
	
	private CustomerRepository repository;

	public CustomerDetailService(CustomerRepository customerRepository) {
		super();
		this.repository = customerRepository;
	}
	
	

}
