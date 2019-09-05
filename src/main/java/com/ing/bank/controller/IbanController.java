package com.ing.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Laxman
 *
 */
@RestController
@RequestMapping("/api")
public class IbanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IbanController.class);

	@GetMapping("/bankApi")
	public ResponseEntity<String> callBankApi(){
		
		LOGGER.info("IbanController :: callBankApi --");
		return new ResponseEntity<String>("Hello! Bank Api is Up", HttpStatus.OK);
	}
}
