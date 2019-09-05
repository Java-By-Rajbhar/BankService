package com.ing.bank.service;

import com.ing.bank.dto.IbanRequestDto;
import com.ing.bank.dto.IbanResponseDto;

/**
 * @author Laxman
 *
 */
public interface IbanService {
	
	public IbanResponseDto getBankNameByIban(IbanRequestDto ibanRequestDto);

}
