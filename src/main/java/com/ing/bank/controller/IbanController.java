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
	/**
	 * This method is use to get bank name based on iban number
	 * @param ibanRequestDto
	 * @return ResponseEntity<IbanResponseDto>
	 */
	@PostMapping("/accounts")
	public ResponseEntity<IbanResponseDto> getBankName(@RequestBody IbanRequestDto ibanRequestDto)
	{
		LOGGER.info("Inside getBankName method of IbanController class");
		IbanResponseDto response = ibanService.getBankNameByIban(ibanRequestDto);
		
		return new ResponseEntity<IbanResponseDto>(response, HttpStatus.OK);
		
	}
}
