package br.com.ecomanager.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.ecomanager.dao.SalaDAO;
import br.com.ecomanager.model.Sala;


@ManagedBean
public class SalaBean {
	SalaDAO sDao;
	private List<Sala>salas;
	private Sala sala = new Sala();
	
	
	public SalaBean(SalaDAO sDao, Sala sala, List<Sala> salas) {
		super();
		this.sDao = sDao;
		this.sala = sala;
		this.salas = salas;
	}
	public SalaBean() {
		
	}
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	public void cadastrarSala() {
		sDao = new SalaDAO();
		sDao.salvar(sala);
		sala = new Sala();
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Sala cadastrada"));
		
	}
	public void buscarPorId() {
		sDao = new SalaDAO();
		Sala sBusca = sDao.buscarPorId(sala.getId());
		sala = sBusca;
		if(sBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Sala não encontrada"));
	}
	}
	public void removerPorId() {
		sDao = new SalaDAO();
		Sala sBusca = sDao.buscarPorId(sala.getId());
		sala = sBusca;
		if (sBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Sala não existe"));
		}else {
			sDao.remover(sala.getId());
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Sala removida"));
		
	}

	
}
}
