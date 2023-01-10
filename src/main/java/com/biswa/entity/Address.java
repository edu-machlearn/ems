package com.biswa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer ID;
	private String address1;
	private String address2;
	private String country;
	private String state;
	private String dist;
	private String pin;
	private String primary_mobile;
	private String secondary_mobile;

}
