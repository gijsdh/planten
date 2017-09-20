package com.example.planten.confiq;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import com.example.planten.api.BestelRegelEndpoint;
import com.example.planten.api.BestellingEndpoint;
import com.example.planten.api.LeverancierEndpoint;
import com.example.planten.api.PlantEndpoint;



@Component
@ApplicationPath("/api")
public class JerseyConfiq extends ResourceConfig{

	public JerseyConfiq(){
		register(BestellingEndpoint.class);
		register(LeverancierEndpoint.class);
		register(BestelRegelEndpoint.class);
		register(PlantEndpoint.class);
		
	}
	
}


//import javax.ws.rs.ApplicationPath;
//
//import org.glassfish.jersey.server.ResourceConfig;
//import org.springframework.stereotype.Component;
//
//import com.example.demox.API.HardloperEndPoint;
//
//@Component
//@ApplicationPath("/API")
//public class JerseyConfiq extends ResourceConfig {
//	
//	public JerseyConfiq(){
//		register(HardloperEndPoint.class);
//	}
//}