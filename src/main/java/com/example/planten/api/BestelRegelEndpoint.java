package com.example.planten.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.planten.domain.BestelRegelsId;
import com.example.planten.domain.Bestelling;
import com.example.planten.domain.BestellingModel;
import com.example.planten.domain.Bestelregels;
import com.example.planten.planten.services.BestelRegelsService;
import com.example.planten.planten.services.BestellingService;



@Path("bestelregels")
@Component
public class BestelRegelEndpoint {

	@Autowired
	private BestelRegelsService bestelRegelsService;
	
	@Autowired
	private BestellingService bestellingService;
	

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findonId/{id}")
	public Response hallo(@PathParam("id") Integer id){
		
		
		
		Iterable <Bestelregels> bestelRegels  = bestellingService.findByidBestelregels(id);
		//System.out.println(bestelRegels);
	
		return Response.ok(bestelRegels).build();
	}
	
	
	
	
	
     
	
}
