package com.example.CRUDJava.Service;

import java.util.List;

import com.example.CRUDJava.Domain.Client;
import com.example.CRUDJava.Model.ClientModel;

public interface ClientService {

	public List<ClientModel> getAllClients();
	
	public Client getClientById(int id);
	
	public Client CreateClient(ClientModel userResources);
	
	public Client editClient(ClientModel userResources);
}
