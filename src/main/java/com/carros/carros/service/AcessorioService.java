package com.carros.carros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.carros.entity.Acessorio;
import com.carros.carros.repository.AcessorioRepository;

@Service
public class AcessorioService {

	@Autowired
	private AcessorioRepository acessorioRepository;

	public String save(Acessorio acessorio) {

		this.acessorioRepository.save(acessorio);
		return acessorio.getNome() + " salvo com sucesso.";
	}

	public String update(Acessorio acessorio, long id) {

		acessorio.setId(id);
		this.acessorioRepository.save(acessorio);
		return "Marca atualizada com sucesso.";
	}

	public String delete(long id) {
		this.acessorioRepository.deleteById(id);
		return "Acessório deletado.";
	}

	public List<Acessorio> findAll() {
		List<Acessorio> lista = this.acessorioRepository.findAll();
		return lista;
	}

	public Acessorio findById(long id) {
		Acessorio acessorio = this.acessorioRepository.findById(id).get();
		return acessorio;
	}

	
}
