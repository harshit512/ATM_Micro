package com.atm.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.atm.Service.ATMService;
import com.atm.controller.ATMController;


public class ATMServiceUnitTest {
	
	
	@Test
	public void testDebitAmnt() throws Exception {
		
		ATMService atm = new ATMService();
System.out.println("Inside test");

assertEquals("Successfull Transaction of Amount: $20",atm.debitAmnt(20).getBody());
		
	}

}
