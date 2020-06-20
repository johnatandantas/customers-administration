package br.com.johnworks.soap.webservices.customersadministration.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDetail {

	private int id;
	private String name;
	private String phone;
	private String email;
}
