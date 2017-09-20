package com.example.planten.domain;

import javax.persistence.*;

@Entity
@Table(name ="goed_ontvangst")
public class GoedOntvangst {
	
	
	@Id
	@Column(name = "artcode", columnDefinition="int")
	private Integer id;
	

}
