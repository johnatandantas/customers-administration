package br.com.johnworks.soap.webservices.customersadministration.endpoint;

import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.johnatandantas.CustomerDetail;
import br.com.johnatandantas.GetCustomerDetailRequest;
import br.com.johnatandantas.GetCustomerDetailResponse;

public class CustomerDetailEndpoint {
	
    private static final String NAMESPACE_URI = "http://johnatandantas.com.br";
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse getStudent(@RequestPayload GetCustomerDetailRequest request) {
    	GetCustomerDetailResponse response = new GetCustomerDetailResponse();
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(1);
        customerDetail.setName("Johnatan Dantas");
        customerDetail.setEmail("dantas.johnatan@email.com");
        customerDetail.setPhone("99999999999");
        response.setCustomerDetail(customerDetail);
        return response;
    }
}
