package com.atm.controllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.atm.Service.ATMService;
import com.atm.controller.ATMController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ATMControllerIntegrationTest {
	
@LocalServerPort
private int port;

@Autowired
private TestRestTemplate testRest;
	
	
	@Test
	public void testDispenseAmount() throws Exception {
		String url = "http://localhost:"+port+"/atm/getAmount/20";
		
		UriComponents builder  = UriComponentsBuilder.fromHttpUrl(url).build();
		
		HttpEntity<String> requestEntity = new HttpEntity<>(null,null);
		ResponseEntity<String> res = testRest.withBasicAuth("admin","admin").
				exchange(builder.toString(),HttpMethod.GET,requestEntity,String.class);
		
	
		System.out.println("Inside test :" + res.getBody());
		assertEquals("Successfull Transaction of Amount: $20",res.getBody());


			}

}
