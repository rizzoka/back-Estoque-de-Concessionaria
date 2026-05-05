package com.carros.carros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carros.carros.entity.Marca;
import com.carros.carros.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public String save(Marca marca) {

		this.marcaRepository.save(marca);
		return marca.getNome() + " salvo com sucesso.";
	}

	public String update(Marca marca, long id) {

		marca.setId(id);
		this.marcaRepository.save(marca);
		return "Marca atualizada com sucesso.";
	}

	public String delete(long id) {
		this.marcaRepository.deleteById(id);
		return "Marca deletada.";
	}

	public List<Marca> findAll() {
		List<Marca> lista = this.marcaRepository.findAll();
		return lista;
	}

	public Marca findById(long id) {
		Marca marca = this.marcaRepository.findById(id).get();
		return marca;
	}

}
