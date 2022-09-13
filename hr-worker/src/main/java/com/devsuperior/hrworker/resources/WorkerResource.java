package com.devsuperior.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

//Para funcionar como um webservice que vai disponibilizar os endpoints é preciso criar a anotação @RestController
@RestController
@RequestMapping(value = "/workers") //dizer qual será o caminho
public class WorkerResource {
	
	//Injetar uma dependência do nosso repositorio para acessar o BD
	@Autowired
	private WorkerRepository repository;
	
	//Encapsula uma resposta HTTP
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll(); //Vai no Banco de Dados e retorna tudo em uma lista
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}") //Capturar um id específico da requisição digitada
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker obj = repository.findById(id).get(); //Vai no Banco de Dados e retorna tudo em uma lista
		return ResponseEntity.ok(obj);
	}
	

}
