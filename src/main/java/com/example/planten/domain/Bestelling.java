package com.example.planten.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "bestellingen")

public class Bestelling implements Serializable{

	
	@Id
	@Column(name = "bestelnr", columnDefinition= "int default 100")
	private Integer id;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id.bestelRegelId")
	List <Bestelregels> bestelregels = new ArrayList<>();
	
	private Date besteldat;
	private Date leverdat;
	private BigDecimal bedrag;
	@Column(columnDefinition = "char")
	private String status;

	
	
	@ManyToOne 
	@JoinColumn(name="levcode")
	private Leveranciers leverancier;

	
	
	
	
	public List<Bestelregels> getBestelregels() {
		return bestelregels;
	}
	public void setBestelregels(List<Bestelregels> bestelregels) {
		this.bestelregels = bestelregels;
	}
	public Leveranciers getLeverancier() {
		return leverancier;
	}
	public void setLeverancier(Leveranciers leverancier) {
		this.leverancier = leverancier;
	}
	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBesteldat() {
		return besteldat;
	}
	public void setBesteldat(Date besteldat) {
		this.besteldat = besteldat;
	}
	public Date getLeverdat() {
		return leverdat;
	}
	public void setLeverdat(Date leverdat) {
		this.leverdat = leverdat;
	}
	public BigDecimal getBedrag() {
		return bedrag;
	}
	public void setBedrag(BigDecimal bedrag) {
		this.bedrag = bedrag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
	
}
