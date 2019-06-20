package com.example.CRUDJava.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CLIENTS")
public class ClientModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@NotNull
	@Column(name = "NAME")
	private String Name;
	
	@NotNull
	@Column(name = "LAST_NAME")
	private String LastName;
	
	@NotNull
	@Column(name = "AGE")
	private int Age;
	
	@Column(name = "EMAIL")
	private String Email;
}
