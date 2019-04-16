package br.com.ecomanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.ecomanager.model.Sala;
import br.com.ecomanager.util.JPAUtil;

public class SalaDAO implements GenericDAO <Sala> {

	@Override
	public void salvar(Sala entidade) {
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
		Sala sala = em.find(Sala.class, id);
		em.remove(sala);
		em.getTransaction().commit();
	
		}finally {
			em.close();
		}
	}

	@Override
	public Sala buscarPorId(int id) {
	EntityManager em = JPAUtil.getEntityManager();
	try {
		return em.find(Sala.class, id);
	} finally {
		em.close();
		}
	}

	@Override
	public List<Sala> listar() {
	List<Sala> salas = new ArrayList<Sala>();
	EntityManager em = JPAUtil.getEntityManager();
	{
		try {
			salas = em.createQuery("From" + Sala.class.getSimpleName(), Sala.class).getResultList();
			return salas;
		} finally {
			em.close();
		}
		
	}
	}

}
