package br.com.ecomanager.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import br.com.ecomanager.model.Estabelecimento;
import br.com.ecomanager.util.JPAUtil;

public class EstabelecimentoDAO implements GenericDAO<Estabelecimento> {

	@Override
	public void salvar(Estabelecimento entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			em.getTransaction().begin();
			if(entidade.getId() == null) {
				em.persist(entidade);
			}else {
				em.merge(entidade);
			}
			em.getTransaction().commit();
		}finally {
			em.close();
		}
	}

	@Override
	public void remover(int id) {
	EntityManager em = JPAUtil.getEntityManager();
	try {
		em.getTransaction().begin();
		Estabelecimento estabelecimento = em.find(Estabelecimento.class, id);
		em.remove(estabelecimento);
		em.getTransaction().commit();
	}finally {
		em.close();
	}
		
	}

	@Override
	public Estabelecimento buscarPorId(int id) {
	EntityManager em = JPAUtil.getEntityManager();
	try {
		return em.find(Estabelecimento.class, id);
	}finally {
		em.close();
	}
	}

	@Override
	public List<Estabelecimento> listar() {
	List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
	EntityManager em = JPAUtil.getEntityManager();
	try {
		estabelecimentos = em.createQuery("From"+ Estabelecimento.class.getSimpleName(), Estabelecimento.class).getResultList();
		return estabelecimentos;
	}finally {
		em.close();
	}
	}

}
