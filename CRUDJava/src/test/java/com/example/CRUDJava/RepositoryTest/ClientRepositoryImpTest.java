package com.example.CRUDJava.RepositoryTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.CRUDJava.DummyModel.DummyClientModel;
import com.example.CRUDJava.Model.ClientModel;
import com.example.CRUDJava.Repository.ClientRepositoryImp;
import com.example.CRUDJava.Repository.JPAClients;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientRepositoryImpTest {
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Mock JPAClients jPAClients;
	
	@InjectMocks
	ClientRepositoryImp repo;
	
	DummyClientModel dummy = new DummyClientModel();
	private Optional<ClientModel> oPclient = Optional.of(dummy.getDummyClientModel());
	
	@Test
	public void getClients() {
		when(jPAClients.findAll()).thenReturn(dummy.getListDummyClientModel());
		assertNotNull(repo.getClients());
	}
	
	@Test
	public void getClientById() {
		when(jPAClients.findById(Mockito.anyLong())).thenReturn(oPclient);
		assertNotNull(repo.getClientById(Mockito.anyLong()));
	}

}
