package com.atm.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atm.customExceptions.InvalidAmountException;

@Service
public class ATMService {
	
	public ResponseEntity<Object> debitAmnt(int amnt)
	{
		if (amnt == 50 || amnt == 20 || amnt == 10)
		{
			
		      return new ResponseEntity<>("Successfull Transaction of Amount: $" + amnt, HttpStatus.OK);

		}
		else
		{
			
			throw new InvalidAmountException();
			
		}
	}
	
	

}
