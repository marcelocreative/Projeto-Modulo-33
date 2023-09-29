package br.com.mgsystems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.mgsystems.domain.Carro;

public class CarroDAO implements ICarroDAO {

	@Override
	public Carro cadastrar(Carro carro) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return carro;
	}

}
