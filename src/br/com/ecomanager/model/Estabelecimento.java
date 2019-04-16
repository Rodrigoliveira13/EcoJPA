package br.com.ecomanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeEstabelecimento;
	
	public Estabelecimento() {
		
	}

	public Estabelecimento(String nomeEstabelecimento) {
		super();
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}
	@Override
	public String toString() {
		return "Estabelecimento [Nome =" + nomeEstabelecimento + "]";
	
	}
}
