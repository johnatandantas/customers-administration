package br.com.johnworks.soap.webservices.customersadministration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.johnworks.soap.webservices.customersadministration.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
