package com.example.planten.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class BestelRegelsId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="bestelnr")
	private Integer bestelRegelId; 
	
	
	
	@Column(name="artcode")
	private Integer artcodeID;
	
	
	
	public Integer getArtcodeID() {
		return artcodeID;
	}

	public void setArtcodeID(Integer artcodeID) {
		this.artcodeID = artcodeID;
	}

	public BestelRegelsId() {
		
	}
	
	public BestelRegelsId(Integer bestelRegelId, Integer artcodeID) {
    
		this.bestelRegelId=bestelRegelId;
		this.artcodeID=artcodeID;
	}

	
	

	public Integer getBestelRegelId() {
		return bestelRegelId;
	}


	public void setBestelRegelId(Integer bestelRegelId) {
		this.bestelRegelId = bestelRegelId;
	}
   
}
