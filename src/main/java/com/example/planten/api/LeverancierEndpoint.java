package com.example.planten.api;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.planten.domain.Bestelling;
import com.example.planten.domain.Leveranciers;
import com.example.planten.planten.services.BestellingService;
import com.example.planten.planten.services.LeverancierService;

@Path("leveranciers")
@Component
public class LeverancierEndpoint {
	

	
	@Autowired
	private LeverancierService leverancierService;


	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public Response listleveranciers(){
		Iterable <Leveranciers> leveranciers = leverancierService.findAll();
		return Response.ok(leveranciers).build();
		
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response subSetLeveranciers(@PathParam("id") long id){
		Iterable <Leveranciers> leveranciers = leverancierService.findSet(id);
		return Response.ok(leveranciers).build();
		
	}
	
	

}
