package com.example.planten.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "planten")
public class Plant {
    
    @Id
    @Column(name = "artcode", columnDefinition="int")
    private Integer id;
    
    private String plantennaam;
    private String soort;
    private String kleur;
    private Integer hoogte;
    @Column(columnDefinition="int")
    private Integer bloeibeg;
    @Column(columnDefinition="int")
    private Integer bloeieind;
    private BigDecimal prijs;
    private Integer vrr_aantal;
    private Integer vrr_min;

    @Column(columnDefinition = "char")
    private String BTWtype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlantennaam() {
		return plantennaam;
	}
	public void setPlantennaam(String plantennaam) {
		this.plantennaam = plantennaam;
	}
	public String getSoort() {
		return soort;
	}
	public void setSoort(String soort) {
		this.soort = soort;
	}
	public String getKleur() {
		return kleur;
	}
	public void setKleur(String kleur) {
		this.kleur = kleur;
	}
	public Integer getHoogte() {
		return hoogte;
	}
	public void setHoogte(int hoogte) {
		this.hoogte = hoogte;
	}
	public Months getBloeibeg() {
		
		if(bloeibeg!=null) {
		return Months.values()[bloeibeg];
		}
		else {
		return Months.values()[12];
		}
		
	}
	public void setBloeibeg(int bloeibeg) {
		this.bloeibeg = bloeibeg;
	}
	public Months getBloeieind() {
		if(bloeieind!=null) {
			return Months.values()[bloeieind];
			}
			else {
			return Months.values()[12];
			}
	}
	public void setBloeieind(int bloeieind) {
		this.bloeieind = bloeieind;
	}
	public BigDecimal getPrijs() {
		if(prijs==null) {return null;}
		return prijs.setScale(2);
	}
	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}
	public Integer getVrr_aantal() {
		return vrr_aantal;
	}
	public void setVrr_aantal(int vrr_aantal) {
		this.vrr_aantal = vrr_aantal;
	}
	public Integer getVrr_min() {
		return vrr_min;
	}
	public void setVrr_min(int vrr_min) {
		this.vrr_min = vrr_min;
	}
	public String getBTWtype() {
		return BTWtype;
	}
	public void setBTWtype(String bTWtype) {
		BTWtype = bTWtype;
	}
    
    
       
}