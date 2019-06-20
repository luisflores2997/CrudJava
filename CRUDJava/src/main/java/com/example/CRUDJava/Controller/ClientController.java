package com.example.CRUDJava.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDJava.Domain.Client;
import com.example.CRUDJava.Model.ClientModel;
import com.example.CRUDJava.Service.ClientService;

@RestController // Mapping web requests, base URI
@RequestMapping(value = "/crud")
@Validated
public class ClientController {

	@Autowired
	private ClientService service;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/Clients")
	public List<ClientModel> findAllClients(){

		return service.getAllClients();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/Clients/{id}")
	public Client findClientById(@PathVariable("id") int id) {
		return service.getClientById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/Clients/add")
	@ResponseBody
	public Client createUser(@RequestParam(value = "Name") String Name,
			@RequestParam(value = "LastName") String LastName,
			@RequestParam(value = "Age") int Age,
			@RequestParam(value = "Email") String Email) {

		ClientModel userResources = new ClientModel();
		userResources.setName(Name);
		userResources.setLastName(LastName);
		userResources.setAge(Age);
		userResources.setEmail(Email);

		Client userResponse = service.CreateClient(userResources);

		return userResponse;

	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value="Clients/edit")
	public Client editClient(@RequestParam(value="Id") int Id,
			@RequestParam(value="Name") String Name,
			@RequestParam(value="LastName") String LastName,
			@RequestParam(value="Age") int Age,
			@RequestParam(value="Email") String Email) {
		
		ClientModel updateClient = new ClientModel();
		
		updateClient.setId(Id);
		updateClient.setName(Name);
		updateClient.setLastName(LastName);
		updateClient.setAge(Age);
		updateClient.setEmail(Email);
		
		Client userResponse = service.editClient(updateClient);
		
		return userResponse;
	}
}

