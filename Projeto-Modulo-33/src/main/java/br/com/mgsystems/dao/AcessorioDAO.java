package br.com.mgsystems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.mgsystems.domain.Acessorio;

public class AcessorioDAO implements IAcessorioDAO {

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(acessorio);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return acessorio;
	}

}
