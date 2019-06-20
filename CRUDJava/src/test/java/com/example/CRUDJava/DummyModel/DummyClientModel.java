package com.example.CRUDJava.DummyModel;

import java.util.ArrayList;
import java.util.List;

import com.example.CRUDJava.Model.ClientModel;

public class DummyClientModel {
	
	private List<ClientModel> clientsModel = new ArrayList<ClientModel>();
	
	
	public List<ClientModel> getListDummyClientModel() {
		ClientModel client = new ClientModel();
		clientsModel.add(client);
		
		client.setId(1);
		client.setName("Luis");
		client.setLastName("Flores");
		client.setAge(22);
		client.setEmail("luis.flores@4thsource.com");
		
		return clientsModel;
	}
	
	public ClientModel getDummyClientModel() {
		ClientModel client = new ClientModel();
		
		client.setId(1);
		client.setName("Luis R");
		client.setLastName("Flores R");
		client.setAge(22);
		client.setEmail("luis.flores@4thsource.com");
		
		return client;
	}

}
