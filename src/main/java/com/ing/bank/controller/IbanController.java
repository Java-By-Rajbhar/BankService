package com.ing.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.IbanRequestDto;
import com.ing.bank.dto.IbanResponseDto;
import com.ing.bank.service.IbanService;

/**
 * @author Laxman
 *
 */
@RestController
@RequestMapping("/api")
public class IbanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IbanController.class);
    @Autowired
    IbanService ibanService;
    
	@GetMapping("/bankApi")
	public ResponseEntity<String> callBankApi(){
		
		LOGGER.info("IbanController :: callBankApi --");
		return new ResponseEntity<String>("Hello! Bank Api is Up", HttpStatus.OK);
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<IbanResponseDto> getBankName(@RequestBody IbanRequestDto ibanRequestDto)
	{
		IbanResponseDto response = ibanService.getBankNameByIban(ibanRequestDto);
		
		return new ResponseEntity<IbanResponseDto>(response, HttpStatus.OK);
		
	}
}
