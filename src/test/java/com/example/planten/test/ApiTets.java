package com.example.planten.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.example.planten.api.BestellingEndpoint;
import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class ApiTets {
	
	@Test
	public void test() {
		
		
		BestellingEndpoint bestellingEndpoint = new BestellingEndpoint();
		
		
		Response actual = bestellingEndpoint.subSetLeveranciers("SPITMAN EN ZN.");
		
		//String expected leverancier.;	
		//assertEquals(, actual);
		
		
		
	}
	
	
}
