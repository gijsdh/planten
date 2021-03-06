package com.example.planten.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.planten.domain.Bestelling;
import com.example.planten.domain.BestellingModel;
import com.example.planten.domain.Bestelregels;
import com.example.planten.domain.Leveranciers;
import com.example.planten.planten.services.BestelRegelsService;
import com.example.planten.planten.services.BestellingService;
import com.example.planten.planten.services.LeverancierService;
import com.example.planten.planten.services.PlantService;


/**
 * @author gijs.den.hollander
 *
 */
@Path("bestelling")
@Component
public class BestellingEndpoint {
	
	@Autowired
	private BestellingService bestelService;
	
	@Autowired
	private PlantService plantservice;
	
	@Autowired 
	private BestelRegelsService bestelRegelservice;
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Bestelling> bestellings = bestelService.findAll();
		
		
		return Response.ok(bestellings).build();
		
	}
	
	
	

	@GET
	@Path("striped")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stripedToId(){
		Iterable <Bestelling> bestellings = bestelService.findAll();
		List <BestellingModel> bestellingm = new ArrayList<>();
		for(Bestelling b:bestellings) {
			bestellingm.add(new BestellingModel(b));
		}
		return Response.ok(bestellingm).build();
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("leverancier/{naam}")
	public Response subSetLeveranciers(@PathParam("naam") String naam){
		Iterable <Bestelling> bestellingen = bestelService.findByLeveranciersNaam(naam);
		System.out.println("hallo");
		List <BestellingModel> bestellingm = new ArrayList<>();
		for(Bestelling b:bestellingen) {
			bestellingm.add(new BestellingModel(b));
		}
		return Response.ok(bestellingm).build();
		
		
	}
	
	
	
	
	
	
	
	/**
	 * This function only uses the ID (idBestelling) van een bestelling om de status aan te passen. 
	 * Hij toggelt hem zelf in de database.
	 * 
	 * @param bestelling
	 * @param id
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
	@Path("changeTodeliverd/{idBestelling}")
	public Response changeStatus(@RequestBody Bestelling bestelling,@PathParam("idBestelling") Integer id) {
		
		
		//System.out.println(heelobject.getBedrag());
		Bestelling dummie = bestelService.findByid(id);
		 
		if(dummie.getStatus().equals("C")) {
			dummie.setStatus("A");
		}
		else if(dummie.getStatus().equals("A")) {
			dummie.setStatus("C");
		}
		
		
		
		bestelService.saveChange(dummie);
		
		return Response.ok().build();
	
	}
	                                   
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
	@Path("adBestelRegel")
	public Response adBestelRegel(@RequestBody Bestelregels bestelregel) {
		
	
		Integer idBestelling = bestelService.findByid(bestelregel.getId().getBestelRegelId()).getId();
		Integer idArtikel = plantservice.findById(bestelregel.getId().getArtcodeID()).getId();
		
		if(bestelRegelservice.findByBothId(idBestelling, idArtikel) !=null) {
			
			
			System.out.println("already exist");
			return Response.status(Status.UNAUTHORIZED).build();
			
		}
		if(bestelService.findByid(bestelregel.getId().getBestelRegelId())==null || plantservice.findById(bestelregel.getId().getArtcodeID())==null )
		{			
			System.out.println("error in post");
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
		
		
		bestelRegelservice.saveNewBestelRegel(bestelregel);
		
		return Response.ok().build();
	
	}
	
	

}
