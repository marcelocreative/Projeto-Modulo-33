package br.com.mgsystems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.mgsystems.domain.Marca;

public class MarcaDAO implements IMarcaDAO {

	@Override
	public Marca cadastrar(Marca marca) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(marca);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return marca;
	}

}
