package br.com.ecomanager.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManagerFactory instance;
	
	static {
		if (instance == null) {
			instance = Persistence.createEntityManagerFactory ("ecomanager-mysql");
		}
	}
	public static EntityManager getEntityManager () {
		return instance.createEntityManager();
			
		
	}
}
