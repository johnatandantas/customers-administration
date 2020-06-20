package br.com.johnworks.soap.webservices.customersadministration.endpoint.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6791322182496481532L;

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
