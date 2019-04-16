package br.com.ecomanager.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ecomanager.model.Usuario;
import br.com.ecomanager.util.JPAUtil;

public class UsuarioDAO implements GenericDAO <Usuario> {

	@Override
	public void salvar(Usuario entidade) {
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
			
			Usuario usuario = em.find(Usuario.class, id);
			
			em.remove(usuario);
			
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
	 }
		

	@Override
	public Usuario buscarPorId(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			return em.find(Usuario.class, id);
		}finally {
			em.close();
		}
		}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		EntityManager em = JPAUtil.getEntityManager();
		{
			try {
				usuarios = em.createQuery("from " + Usuario.class.getSimpleName(), Usuario.class).getResultList();
				return usuarios;
		}finally {
			em.close();
		}
	}
		

	}
	public Usuario realizarLogin(Usuario u) {
		EntityManager em = JPAUtil.getEntityManager();
		Usuario usuario = null;
		String jpql = "select u from Usuario u where u.login = :login and u.senha = :senha";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setParameter("login", u.getLogin());
		query.setParameter("senha", u.getSenha());
		
		try {
			usuario = query.getSingleResult();
		}catch (Exception e) {
			usuario = null;
			
		}
		return usuario;
	}
	
}
		
