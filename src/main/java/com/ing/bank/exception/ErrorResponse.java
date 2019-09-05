package com.ing.bank.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Laxman
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private String message;
	private int statusCode;
	private String status;
}
