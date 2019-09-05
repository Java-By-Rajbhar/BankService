package com.ing.bank.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.bank.dto.IbanRequestDto;
import com.ing.bank.dto.IbanResponseDto;
import com.ing.bank.service.IbanServiceImpl;

/**
 * 
 * @author Sushil
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class IbanControllerTest {

	@Mock
	IbanServiceImpl ibanServiceImpl;
	
	@InjectMocks
	IbanController ibanController;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(ibanController).build();
	}
	
	@Test
	public void getBankNameTest() throws JsonProcessingException, Exception
	{
		IbanRequestDto requestdto = new IbanRequestDto();
		requestdto.setIban("ES21123498765");
		IbanResponseDto responseDto = new IbanResponseDto();
		responseDto.setBankName("Tokio Bank");
		responseDto.setStatusCode(200);
		Mockito.when(ibanServiceImpl.getBankNameByIban(Mockito.any())).thenReturn(responseDto);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/accounts").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(new ObjectMapper().writeValueAsString(requestdto))).andReturn();
		
		ResponseEntity<IbanResponseDto> response = ibanController.getBankName(requestdto);
		
		assertEquals(200, response.getStatusCodeValue());
	}
}
