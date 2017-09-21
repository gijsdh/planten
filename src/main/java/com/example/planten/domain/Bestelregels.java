package com.example.planten.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


@Entity
@Table(name = "bestelregels")
public class Bestelregels implements Serializable {
	
	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BestelRegelsId id;

	public BestelRegelsId getId() {
		return id;
	}
	public void setId(BestelRegelsId id) {
		this.id = id;
	}
	//@Id
	
	@JsonIgnore
	@ManyToOne
	@MapsId( "bestelnr")
	@JoinColumn(name =  "bestelnr")
	private Bestelling bestelling;
	
	@ManyToOne
	@MapsId( "artcode")
	@JoinColumn(name="artcode" )
	private Plant plant;
	
//	private int artcode;
	private int aantal;
	private BigDecimal bestelprijs;
	  
	
    public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public Bestelling getBestelling() {
		return bestelling;
	}
	public void setBestelling(Bestelling bestelling) {
		this.bestelling = bestelling;
	}

//	public int getArtcode() {
//		return artcode;
//	}
//	public void setArtcode(int artcode) {
//		this.artcode = artcode;
//	}
	public int getAantal() {
		return aantal;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public BigDecimal getBestelprijs() {
		return bestelprijs.setScale(2);
	}
	public void setBestelprijs(BigDecimal bestelprijs) {
		this.bestelprijs = bestelprijs;
	}
	
}
