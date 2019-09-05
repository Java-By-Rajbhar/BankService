package com.ing.bank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.IbanRequestDto;
import com.ing.bank.dto.IbanResponseDto;
import com.ing.bank.entity.IbanCode;
import com.ing.bank.exception.InvalidIbanCodeException;
import com.ing.bank.repository.IbanRepository;

/**
 * @author Laxman
 *
 */
@Service
public class IbanServiceImpl implements IbanService{

	private static final Logger LOGGER = LoggerFactory.getLogger(IbanServiceImpl.class);
	@Autowired
	IbanRepository ibanRepository;
    /**
     * This method is use to get bank name by using iban 
     * @param iban ,not null
     * @return IbanResponseDto ,not null
     * @exception InvalidIbanCodeException throws if iban code does not exist
     */
	@Override
	public IbanResponseDto getBankNameByIban(IbanRequestDto ibanRequestDto) {
		LOGGER.info("inside getBankNameByIban method of IbanServiceImpl class");
		Integer code = getBankName(ibanRequestDto.getIban());
		IbanCode ibanCode = ibanRepository.findByIbanCode(code);
		if(ibanCode!=null)
		{
			IbanResponseDto responseDto = new IbanResponseDto();
			responseDto.setBankName(ibanCode.getBankName());
			responseDto.setMessage("Bank available");
			responseDto.setStatus("success");
			responseDto.setStatusCode(HttpStatus.OK.value());
			
			return responseDto;
		}
		else
		{
			LOGGER.error("code does not exist with iban ={}",ibanRequestDto.getIban());
			throw new InvalidIbanCodeException("iban does not exist");
		}
		
	}
	private int getBankName(String iban) {
		LOGGER.info("iban data={}",iban);
		String result = iban.substring(4, 8);
		LOGGER.info("substring data={}",result);
		
		return Integer.parseInt(result);
	}
	
}
