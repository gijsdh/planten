package com.example.planten.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class BestellingModel {

	private Bestelling bestelling;
	
	
    public BestellingModel(Bestelling bestelling) {
		
		this.bestelling=bestelling;
	}
	
	
    public long getId() {
		return bestelling.getId();
	}
    
    public String getLeverancier() {
		return bestelling.getLeverancier().getLevnaam();
	}
     
    public Date getBesteldat() {
		return bestelling.getBesteldat();
	}
    
    public Date getLeverdat() {
		return bestelling.getLeverdat();
	}
    
    public BigDecimal getBedrag() {
		return bestelling.getBedrag();
	}
    
    public String getStatus() {
		return bestelling.getStatus();
	}
    
}
