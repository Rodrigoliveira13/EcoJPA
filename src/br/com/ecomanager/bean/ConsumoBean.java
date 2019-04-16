package br.com.ecomanager.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.ecomanager.dao.ConsumoDAO;
import br.com.ecomanager.model.Consumo;

@ManagedBean
@RequestScoped
public class ConsumoBean {
	ConsumoDAO cDao;
	private Consumo consumo = new Consumo();
	private List<Consumo> consumos;
	
	
	public ConsumoBean(ConsumoDAO cDao, Consumo consumo, List<Consumo> consumos) {
		super();
		this.cDao = cDao;
		this.consumo = consumo;
		this.consumos = consumos;
	}
	public ConsumoBean(){
		
	}


	public Consumo getConsumo() {
		return consumo;
	}


	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}


	public List<Consumo> getConsumos() {
		return consumos;
	}


	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}
	
	public void cadastrarConsumo() {
		cDao = new ConsumoDAO();
		cDao.salvar(consumo);
		consumo = new Consumo();
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Consumo cadastrado"));
	}
	
	public void buscarPorId() {
		cDao = new ConsumoDAO();
		Consumo cBusca = cDao.buscarPorId(consumo.getId());
		if(cBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Consumo não encontrado"));
	}
	}
	public void removerConsumo() {
		cDao = new ConsumoDAO();
		Consumo cBusca = cDao.buscarPorId(consumo.getId());
		consumo = cBusca;
		if (cBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Consumo não encontrado"));
		}else {
			cDao.remover(consumo.getId());
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Consumo removido"));
	}
		
	}

}

