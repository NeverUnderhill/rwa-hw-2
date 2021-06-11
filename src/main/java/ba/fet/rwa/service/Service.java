package ba.fet.rwa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Service<T> {
	protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("rwaPU");
	protected EntityManager em = emf.createEntityManager();
	
	public abstract List<T> getAll();
	
	public abstract T getById(int id);
}
