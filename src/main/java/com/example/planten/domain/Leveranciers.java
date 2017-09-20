package com.example.planten.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="leveranciers")
public class Leveranciers {
	

	@Id
	@Column(name ="levcode", columnDefinition="int default 1000")
	//@OneToMany
	private long id;
	
	private String levnaam;
	private String adres;
	private String woonplaats;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLevnaam() {
		return levnaam;
	}

	public void setLevnaam(String levnaam) {
		this.levnaam = levnaam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	
	

}
