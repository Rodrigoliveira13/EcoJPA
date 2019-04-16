package br.com.ecomanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Consumo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private float kwh;
	@Temporal(TemporalType.DATE)
	private Date dataHoraCaptura;

	
	@ManyToOne
	private Estabelecimento estabelecimento;
	@ManyToOne
	private Predio predio;
	@ManyToOne
	private Sala sala;
	
	public Consumo() {
		
	}

	public Consumo(Integer id, float kwh, Date dataHoraCaptura, Estabelecimento estabelecimento,
			Predio predio, Sala sala) {
		super();
		this.id = id;
		this.kwh = kwh;
		this.dataHoraCaptura = dataHoraCaptura;
		this.estabelecimento = estabelecimento;
		this.predio = predio;
		this.sala = sala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getKwh() {
		return kwh;
	}

	public void setKwh(float kwh) {
		this.kwh = kwh;
	}

	public Date getDataHoraCaptura() {
		return dataHoraCaptura;
	}

	public void setDataCaptura(Date dataHoraCaptura) {
		this.dataHoraCaptura = dataHoraCaptura;
	}

	

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Predio getPredio() {
		return predio;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	

}
