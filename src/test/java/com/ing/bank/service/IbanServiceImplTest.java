package com.ing.bank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.ing.bank.dto.IbanRequestDto;
import com.ing.bank.dto.IbanResponseDto;
import com.ing.bank.entity.IbanCode;
import com.ing.bank.repository.IbanRepository;

/**
 * 
 * @author Sushil
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class IbanServiceImplTest {

	@Mock
	IbanRepository ibanRepository;
	
	@InjectMocks
	IbanServiceImpl ibanServiceImpl;
	
	@Test
	public void getBankNameByIbanTest()
	{
		IbanRequestDto ibanRequestDto = new  IbanRequestDto();
		ibanRequestDto.setIban("ES2112349876");
		
		IbanCode ibanCode = new IbanCode();
		ibanCode.setBankName("Tokio Bank");
		ibanCode.setIbanId(11);
		
		Mockito.when(ibanRepository.findByIbanCode(Mockito.anyInt())).thenReturn(ibanCode);
		IbanResponseDto response = ibanServiceImpl.getBankNameByIban(ibanRequestDto);
		
		assertEquals(200, response.getStatusCode());
		
		
	}
}
