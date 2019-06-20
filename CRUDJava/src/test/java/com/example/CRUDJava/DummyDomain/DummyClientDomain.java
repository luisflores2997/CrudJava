package com.example.CRUDJava.DummyDomain;

import java.util.ArrayList;
import java.util.List;

import com.example.CRUDJava.Domain.Client;

public class DummyClientDomain {
	
	private List<Client> clientsDomain = new ArrayList<Client>();
	
	public List<Client> getListDummyClientDomain() {
		Client client = new Client();
		clientsDomain.add(client);
		
		client.setId(1);
		client.setName("Ricardo");
		client.setLastName("Romero");
		client.setAge(21);
		client.setEmail("ricardo.romero@4thsource.com");
		
		return clientsDomain;
	}
	
	public Client getDummyClientDomain() {
		Client client = new Client();
		
		client.setId(1);
		client.setName("Ricardo L");
		client.setLastName("Romero F");
		client.setAge(21);
		client.setEmail("ricardo.romero@4thsource.com");
		
		return client;
	}

}
