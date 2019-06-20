package com.example.CRUDJava.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDJava.Model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

	ClientModel findById(@Valid @NotBlank int id);
}
