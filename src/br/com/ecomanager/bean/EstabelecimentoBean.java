package br.com.ecomanager.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ecomanager.dao.EstabelecimentoDAO;
import br.com.ecomanager.model.Estabelecimento;

@ManagedBean
public class EstabelecimentoBean {
	EstabelecimentoDAO eDao;
	private Estabelecimento estabelecimento = new Estabelecimento();
	private List<Estabelecimento>estabelecimentos;
	
	
	public EstabelecimentoBean(EstabelecimentoDAO eDao, Estabelecimento estabelecimento,
			List<Estabelecimento> estabelecimentos) {
		super();
		this.eDao = eDao;
		this.estabelecimento = estabelecimento;
		this.estabelecimentos = estabelecimentos;
	}
	public EstabelecimentoBean() {
		
	}


	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}


	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}
	
	public void cadastrarEstabelecimento() {
		eDao = new EstabelecimentoDAO();
		eDao.salvar(estabelecimento);
		estabelecimento = new Estabelecimento();
		FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Estabelecimento cadastrado"));
	}
	public void buscarPoId() {
		eDao = new EstabelecimentoDAO();
		Estabelecimento eBusca = eDao.buscarPorId(estabelecimento.getId());
		if (eBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Estabelecimento não encontrado"));
		}
	}
	public void removerEstabelecimento() {
		eDao = new EstabelecimentoDAO();
		Estabelecimento eBusca = eDao.buscarPorId(estabelecimento.getId());
		estabelecimento = eBusca;
		if (eBusca == null) {
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Estabelecimento não encontrado"));
		}else {
			eDao.remover(estabelecimento.getId());
			FacesContext.getCurrentInstance().addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Estabelecimento removido"));
		}
	}

}
