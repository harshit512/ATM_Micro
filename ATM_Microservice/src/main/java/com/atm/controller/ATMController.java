package com.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.Service.ATMService;
import com.atm.customExceptions.InvalidAmountException;

@RestController
@RequestMapping("/atm")
public class ATMController {
	
	@Autowired
	ATMService atmService;
	
	@GetMapping("/getAmount/{amnt}")
	public ResponseEntity<Object> dispenseAmount(@PathVariable int amnt) throws InvalidAmountException,Exception
	{
		
			return atmService.debitAmnt(amnt);
		
		
	}
	
	@ExceptionHandler(value ={Exception.class})
	public ResponseEntity<Object> generalException ()
	{
	      return new ResponseEntity<>("There is a issue with your request. Please try again", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value ={InvalidAmountException.class})
	public ResponseEntity<Object> amountNotAllowed ()
	{
	      return new ResponseEntity<>("Amount cannot be dispensed", HttpStatus.BAD_REQUEST);

	}
	
	

}
