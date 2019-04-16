package br.com.ecomanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ecomanager.model.Predio;
import br.com.ecomanager.util.JPAUtil;

public class PredioDAO implements GenericDAO <Predio> {

	@Override
	public void salvar(Predio entidade) {
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
		Predio predio = em.find(Predio.class, id);
		em.remove(predio);
		em.getTransaction().commit();
			
		}finally{
			em.close();
		}
}

	@Override
	public Predio buscarPorId(int id) {
	EntityManager em = JPAUtil.getEntityManager();
	try {
		return em.find(Predio.class, id);
	}finally {
		em.close();
	}
}

	@Override
	public List<Predio> listar() {
	List<Predio> predios = new ArrayList<Predio>();
	EntityManager em = JPAUtil.getEntityManager();
	try {
		predios = em.createQuery("From" + Predio.class.getSimpleName(), Predio.class).getResultList();
		return predios;
	}finally {
		em.close();
	}
	}

}
