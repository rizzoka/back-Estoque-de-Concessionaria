package com.carros.carros.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity //o spring vai criar essa tabela (vai virar uma entidade no banco)
public class Carro {
	
//esses valores vao virar colunas no banco	
	@Id //pra dizer que é um id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //autoincremente pra o id
	private Long id;
	private String nome;
	
	@ManyToOne //cria a comunicação
	private Marca marca; //já que uma marca pode ter vários carros mas um carro só tem uma marca many to one
	
	@ManyToMany
	@JoinTable(name="carro_acessorio")
	private List<Acessorio> acessorios;
	
	//SEMPRE LEMBRA DE FAZER O GET E O SET PQ SE NAO ELE NAO SALVA!!!!!!!!
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
}
