package be.vdab.services;

import javax.persistence.EntityManager;

import be.vdab.filters.JPAFilter;

public abstract class AbstractService {
	protected EntityManager getEntityManager() {
		return JPAFilter.getEntityManager();
	}
	void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}
	void commit() {
		getEntityManager().getTransaction().commit();
	}
	void rollback() {
		getEntityManager().getTransaction().rollback();
	}
}
