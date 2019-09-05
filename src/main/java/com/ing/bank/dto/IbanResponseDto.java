package com.ing.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Sushil
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class IbanResponseDto {
	
	private String message;
	private String status;
	private int statusCode;
	private String bankName;

}
