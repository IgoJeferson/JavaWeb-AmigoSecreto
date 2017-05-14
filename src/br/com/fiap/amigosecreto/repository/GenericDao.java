package br.com.fiap.amigosecreto.repository;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;

	protected GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	public void adicionar(T entidade) {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	
	@Override
	public void adicionar(List<T> entidades) {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			for (T entidade : entidades) {
				em.persist(entidade);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			List<T> result = em.createQuery("From " + classe.getSimpleName()).getResultList();
			em.getTransaction().commit();
			return result;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public T buscar(int id) {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			T entidade = em.find(classe, id);
			em.getTransaction().commit();
			return entidade;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
}
