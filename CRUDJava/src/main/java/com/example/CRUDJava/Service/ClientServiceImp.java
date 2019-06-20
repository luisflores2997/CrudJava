package com.example.CRUDJava.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUDJava.Domain.Client;
import com.example.CRUDJava.Exceptions.UserNotFoundException;
import com.example.CRUDJava.Model.ClientModel;
import com.example.CRUDJava.Repository.ClientRepository;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@Service
public class ClientServiceImp implements ClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientModel.class);
	
	@Autowired // Inject
	private ClientRepository repo;
	
	
	// Instantiate Orika Mapper (mapper of beans)
	//private MapperFacade facade = new OrikaMapper();
	
	@Override
	public List<ClientModel> getAllClients() {
		List<ClientModel> userResources = repo.findAll();
		
		logger.debug("UserResources found {}", userResources);
		if (userResources.toString() == "[]") {
			throw new UserNotFoundException("No users exist in the database");
		}
		//List<Client> clientDomain = new ArrayList<Client>();
		// stream - To process collections of objects: for each element(variable) (->)
		// do that sequence
		//responseEntity.stream().forEach((clientD) -> {
			//clientDomain.add(facade.map(clientD, Client.class)); // Adding every element to domain response
		//});
		return userResources;
	}
	
	@Override
	public Client getClientById(int id) {
		Client userResponse = new Client();
		ClientModel userResources = repo.findById(id);
		
		logger.debug("UserResources found {}", userResources);
		if (userResources.toString() == "[]") {
			throw new UserNotFoundException("The user doesn't exist in the database");
		}
		
		userResponse.setId(userResources.getId());
		userResponse.setName(userResources.getName());
		userResponse.setLastName(userResources.getLastName());
		userResponse.setAge(userResources.getAge());
		userResponse.setEmail(userResources.getEmail());
		//Client clientDomain = new Client();
		//clientModel = repo.getClientById(id);
		//clientDomain = facade.map(clientModel, Client.class);
		return userResponse;
		
	}
	
	@Override
	public Client CreateClient(ClientModel userResources) {
		Client userResponse = new Client();	
		ClientModel newUserResources = repo.save(userResources);
		
		logger.debug("UserResources found {}", userResources);
		if(newUserResources == null) {
			throw new UserNotFoundException("The user couldn't be created");
		}

		userResponse.setId(newUserResources.getId());
		userResponse.setName(newUserResources.getName());
		userResponse.setLastName(newUserResources.getLastName());
		userResponse.setEmail(newUserResources.getEmail());

		return userResponse;

	}
	
	@Override
	public Client editClient(ClientModel userResources) {
		Client userResponse = new Client();
		ClientModel validateClient = repo.findById(userResources.getId());
		
		logger.debug("UserResources found {}", validateClient);
		if (validateClient == null ) {
			throw new UserNotFoundException("The client doesn't exist");
		}
		
		ClientModel newUserResources = repo.save(userResources);
		
		userResponse.setId(newUserResources.getId());
		userResponse.setName(newUserResources.getName());
		userResponse.setLastName(newUserResources.getLastName());
		userResponse.setAge(newUserResources.getAge());
		userResponse.setEmail(newUserResources.getEmail());
		
		return userResponse;
	}

}
