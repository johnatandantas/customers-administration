package br.com.johnworks.soap.webservices.customersadministration.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.johnatandantas.CustomerDetail;
import br.com.johnatandantas.DeleteCustomerRequest;
import br.com.johnatandantas.DeleteCustomerResponse;
import br.com.johnatandantas.GetAllCustomerDetailRequest;
import br.com.johnatandantas.GetAllCustomerDetailResponse;
import br.com.johnatandantas.GetCustomerDetailRequest;
import br.com.johnatandantas.GetCustomerDetailResponse;
import br.com.johnatandantas.InsertCustomerRequest;
import br.com.johnatandantas.InsertCustomerResponse;
import br.com.johnatandantas.StatusResponse;
import br.com.johnworks.soap.webservices.customersadministration.endpoint.exception.CustomerNotFoundException;
import br.com.johnworks.soap.webservices.customersadministration.entity.Customer;
import br.com.johnworks.soap.webservices.customersadministration.entity.enumerations.Status;
import br.com.johnworks.soap.webservices.customersadministration.service.CustomerDetailService;

@Endpoint
public class CustomerDetailEndpoint {
	
    private static final String NAMESPACE_URI = "http://johnatandantas.com.br";
    
    private CustomerDetailService customerDetailService;
    
    public CustomerDetailEndpoint(CustomerDetailService customerDetailService) {
		this.customerDetailService = customerDetailService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse processGetCustomerDetailResponse(@RequestPayload GetCustomerDetailRequest request) throws Exception {
    	Customer customer = new Customer();
    	if(customer == null) {
    		throw new CustomerNotFoundException("Invalid Customer id " + customer.getId());
    	}
        return convertToGetCustomerDetailResponse(customer);
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCustomerDetailRequest")
    @ResponsePayload
    public GetAllCustomerDetailResponse processGetAllCustomerDetailRequest(@RequestPayload GetAllCustomerDetailRequest request) throws Exception {
    	List<Customer> customer = new ArrayList<Customer>();
        return convertToGetAllCustomerDetailResponse(customer);
    }
    
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteCustomerRequest")
    @ResponsePayload
    public DeleteCustomerResponse processDeleteCustomerRequest(@RequestPayload DeleteCustomerRequest request) throws Exception {
    	DeleteCustomerResponse response = new DeleteCustomerResponse();
    	StatusResponse statusResponse = convertToStatusResponse(Status.SUCESS);
    	response.setStatusResponse(statusResponse);
        return response;
    }
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertCustomerRequest")
    @ResponsePayload
    public InsertCustomerResponse processInsertCustomerRequest(@RequestPayload InsertCustomerRequest request) throws Exception {
		InsertCustomerResponse response = new InsertCustomerResponse();
		convertCustomer(request.getCustomerDetail());
    	StatusResponse statusResponse = convertToStatusResponse(Status.SUCESS);
    	response.setStatusResponse(statusResponse);
        return response;
    }
	
	
	private GetCustomerDetailResponse convertToGetCustomerDetailResponse(Customer customer) {
		GetCustomerDetailResponse response = new GetCustomerDetailResponse();
		response.setCustomerDetail(convertToCustomerDetail(customer));
        return response;
	}
	
	private GetAllCustomerDetailResponse convertToGetAllCustomerDetailResponse(List<Customer> customer) {
		GetAllCustomerDetailResponse response = new GetAllCustomerDetailResponse();
		customer.stream().forEach(c -> response.getCustomerDetail().add(convertToCustomerDetail(c)));
        return response;
	}
	
	private CustomerDetail convertToCustomerDetail(Customer customer) {
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(customer.getId());
        customerDetail.setName(customer.getName());
        customerDetail.setEmail(customer.getEmail());
        customerDetail.setPhone(customer.getPhone());
        return customerDetail;
	}
	
	private Customer convertCustomer(CustomerDetail customerDetail) {
		Customer customer = new Customer();
		customer.setId(customerDetail.getId());
		customer.setName(customerDetail.getName());
		customer.setEmail(customerDetail.getEmail());
		customer.setPhone(customerDetail.getPhone());
        return customer;
	}
	
	private StatusResponse convertToStatusResponse(Status status) {
        if(status == Status.FAILURE) {
        	return StatusResponse.FAILURE;
        }
        return StatusResponse.SUCESSO;
	}
}
