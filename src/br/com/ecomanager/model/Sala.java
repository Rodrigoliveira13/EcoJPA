package br.com.ecomanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeSala;
	
	@ManyToOne
	private Predio predio;
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	
	public Sala(Integer id, String nomeSala, Predio predio, Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.nomeSala = nomeSala;
		this.predio = predio;
		this.estabelecimento = estabelecimento;
	}
	
	public Sala() {

}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public Predio getPredio() {
		return predio;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}