package br.com.ecomanager.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ecomanager.dao.EstabelecimentoDAO;
import br.com.ecomanager.dao.PredioDAO;
import br.com.ecomanager.model.Estabelecimento;
import br.com.ecomanager.model.Predio;

@ManagedBean
public class PredioBean {
	PredioDAO pDao;
	private Predio predio = new Predio();
	private List<Predio> predios;
	private Estabelecimento estabelecimento;
	
	
	
	public PredioBean(PredioDAO pDao, Predio predio, List<Predio> predios, Estabelecimento estabelecimento, EstabelecimentoDAO eDao) {
		super();
		this.pDao = pDao;
		this.predio = predio;
		this.predios = predios;
		this.estabelecimento= estabelecimento;
	}
	public PredioBean() {
		
	}


	public Predio getPredio() {
		return predio;
	}


	public void setPredio(Predio predio) {
		this.predio = predio;
	}


	public List<Predio> getPredios() {
		return predios;
	}


	public void setPredios(List<Predio> predios) {
		this.predios = predios;
	}
	
	public void cadastrarPredio() {
		pDao = new PredioDAO();
		pDao.salvar(predio);
		predio = new Predio();
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Predio cadastrado"));
	}
	
	public void buscarPorId() {
		pDao = new PredioDAO();
		Predio pBusca = pDao.buscarPorId(predio.getId());
		if (pBusca == null ) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES,new FacesMessage("Predio não encontrado"));
		}
		
	}
	public void removerPorId() {
		pDao = new PredioDAO();
		Predio pBusca = pDao.buscarPorId(predio.getId());
		predio = pBusca;
		if(pBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Predio não encontrado"));
		}else {
			pDao.remover(predio.getId());
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Predio removido)"));
		}
			
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
