package com.example.CRUDJava.ServiceTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.CRUDJava.DummyDomain.DummyClientDomain;
import com.example.CRUDJava.DummyModel.DummyClientModel;
import com.example.CRUDJava.Mapper.OrikaMapper;
import com.example.CRUDJava.Repository.ClientRepositoryImp;
import com.example.CRUDJava.Service.ClientServiceImp;

import ma.glasnost.orika.MapperFacade;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceTest {

	@Mock 
	ClientRepositoryImp repo;
	
	@Mock
	MapperFacade facade = new OrikaMapper();
	
	@InjectMocks
	ClientServiceImp service;
	
	DummyClientModel dummyM = new DummyClientModel();
	DummyClientDomain dummyD = new DummyClientDomain();
	
	@Test
	public void getClientsTest() {
		//List<ClientModel> clients = dummyM.getListDummyClientModel();
		when(repo.getClients()).thenReturn(dummyM.getListDummyClientModel());
		//assertThat(dummyM.getListDummyClientModel()).asList();
		//when(facade.map(dummyM.getListDummyClientModel(), Client.class)).thenReturn(dummyD.getDummyClientDomain());
		assertNotNull(service.getClients());
		
	}
	
	@Test
	public void getClientByIdTest() {
		when(repo.getClientById(Mockito.anyLong())).thenReturn(dummyM.getDummyClientModel());
		when(service.getClientById(Mockito.anyLong())).thenReturn(dummyD.getDummyClientDomain());
		//when(facade.map(clientModel, Client.class)).thenReturn(client);
		assertNotNull(service.getClients());
	}
}
