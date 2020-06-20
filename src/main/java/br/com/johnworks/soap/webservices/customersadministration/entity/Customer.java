package br.com.johnworks.soap.webservices.customersadministration.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer implements Serializable{
	private static final long serialVersionUID = -6024583717309061897L;
	
	private int id;
	private String name;
	private String phone;
	private String email;

}
