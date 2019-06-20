package com.example.CRUDJava.ControllerTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.CRUDJava.Controller.ClientController;
import com.example.CRUDJava.DummyDomain.DummyClientDomain;
import com.example.CRUDJava.Service.ClientServiceImp;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientControllerTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock
	ClientServiceImp service;
	
	@InjectMocks
	ClientController controller;
	
	DummyClientDomain dummy = new DummyClientDomain();
	
	@Test
	public void getClientsTest() {
		when(service.getClients()).thenReturn(dummy.getListDummyClientDomain());
		assertNotNull(controller.getClients());	
	}
	
	@Test
	public void getClientByIdTest() {
		when(service.getClientById(Mockito.anyLong())).thenReturn(dummy.getDummyClientDomain());
		when(controller.getClientById(Mockito.anyLong())).thenReturn(dummy.getDummyClientDomain());
		assertNotNull(controller.getClientById(Mockito.anyLong()));
	}

}
