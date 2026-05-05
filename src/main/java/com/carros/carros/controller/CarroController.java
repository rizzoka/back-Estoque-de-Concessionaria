package com.carros.carros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carros.carros.entity.Carro;
import com.carros.carros.service.CarroService;

@RestController
@RequestMapping("/api/carro")
@CrossOrigin("*") //libera a comunicação com o front, pra nn bloquear o cors. O * diz que qualquer porta pode, se tivesse 
				// um "http://localhost:8080, só a porta 8080 poderia acessar
public class CarroController {


	@Autowired
	private CarroService carroService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro) {
		try {
			String mensagem = this.carroService.save(carro);
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED); //deu certo para CRIAÇÃO
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable long id) {
		try {
			String mensagem = this.carroService.update(carro, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		try {
			String mensagem = this.carroService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasAuthority('ADMIN')") //proteger o back tambem, tem que ter autorização (forma 1)
	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll() {
		try {
			List<Carro> lista = this.carroService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Carro> findById(@PathVariable long id) {
		try {
			Carro carro = this.carroService.findById(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNome") //esse requestParam é pq eu mando o parametro
	public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome) {
		try {
			List<Carro> lista = this.carroService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
