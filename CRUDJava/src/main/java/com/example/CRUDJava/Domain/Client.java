package com.example.CRUDJava.Domain;

import lombok.Data;

@Data
public class Client {

	private long Id;
	private String Name;
	private String LastName;
	private int Age;
	private String Email;
}
