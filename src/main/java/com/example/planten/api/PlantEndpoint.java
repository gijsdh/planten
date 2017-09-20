package com.example.planten.api;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.planten.domain.Plant;
import com.example.planten.planten.services.PlantService;
	
@Path("planten")
@Component
public class PlantEndpoint {
	
	@Autowired
	private PlantService plantenService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Plant> result = plantenService.findAll();
		return Response.ok(result).build();
	}
	
	/**
	 * GET one Question with specified id. The format must be specified behind the id. There are 
	 * three choices: exam, examreview and basic. <br>
	 * Path = 'api/questions/{id}/{format}'
	 * @param id the id of the requested Question
	 * @param format the format in which the Question must be sent: 'exam', 'examreview' or 'basic'
	 * @return 200 + JSON if there is data, 400 if the format is not specified correctly, otherwise 404 (Not Found)
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getPlantById(@PathParam("id") Long id) {
		Plant plant = this.plantenService.findById(id);
		System.out.println(plant);
		if (plant != null) {
//			this.questionService.deleteById(id);
			return Response.ok(plant).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postHardloper(Bestelling bestelling){
		Bestelling result = bestellingService.save(bestelling);
		return Response.accepted(result.getId()).build();	
	}*/

}