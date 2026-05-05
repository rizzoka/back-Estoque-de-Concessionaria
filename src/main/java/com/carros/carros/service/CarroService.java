package com.carros.carros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.carros.entity.Carro;
import com.carros.carros.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public String save(Carro carro) {
		
		this.carroRepository.save(carro);
		return carro.getNome() + " salvo com sucesso.";
	}
	
	
	public String update(Carro carro, long id) {
		
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Carro atualizado com sucesso.";
	}
	
	public String delete(long id) {
		this.carroRepository.deleteById(id);
		return "Carro deletado.";
	}
	
	public List<Carro> findAll(){
		List<Carro> lista = this.carroRepository.findAll();
		return lista;
	}
	
	public Carro findById(long id) {
		Carro carro = this.carroRepository.findById(id).get();
		return carro;
	}
	
	public List<Carro> findByNome(String nome){
		return this.carroRepository.findByNome(nome);
	}

}
