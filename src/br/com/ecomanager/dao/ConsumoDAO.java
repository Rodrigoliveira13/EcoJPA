package br.com.ecomanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import br.com.ecomanager.model.Consumo;
import br.com.ecomanager.util.JPAUtil;

public class ConsumoDAO implements GenericDAO<Consumo> {

	@Override
	public void salvar(Consumo entidade) {
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
			Consumo consumo = em.find(Consumo.class, id);
			em.remove(consumo);
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
	}

	@Override
	public Consumo buscarPorId(int id) {
	EntityManager em = JPAUtil.getEntityManager();
	try {
		return em.find(Consumo.class, id);
	}finally {
		em.close();
	}
	}
	@Override
	public List<Consumo> listar() {
	List<Consumo> consumos = new ArrayList<Consumo>();
	EntityManager em = JPAUtil.getEntityManager();
	try {
		consumos = em.createQuery(Consumo.class.getSimpleName(), Consumo.class).getResultList();
		return consumos;
	}finally {
		em.close();
	}
	}

}
