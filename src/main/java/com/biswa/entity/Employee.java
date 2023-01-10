package com.biswa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private int ID;

	@Column(name = "first_name", length = 100)
	private String fname;

	@Column(name = "last_name", length = 100)
	private String lname;

	@Column(name = "mail_id", length = 100, unique = true)
	private String mailId;

	@Column(name = "mobile", length = 100, unique = true)
	private String mobile;
	

	@Column(name = "password", length = 100)
	private String password;
	
	@Column(name = "gender", length = 10)
	private String gender;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime updateDateTime;
	
	@Column(insertable = false, updatable = false)
	private Integer address_id;
}
