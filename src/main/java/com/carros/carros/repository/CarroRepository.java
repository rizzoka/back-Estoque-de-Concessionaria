package com.carros.carros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.carros.carros.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
//so declarando isso acima, vc ja pode fazer o CRUD no service

	
	//nn poderia ser findbyName pq lá esta como NOME
	public List<Carro> findByNome(String nome);

}
