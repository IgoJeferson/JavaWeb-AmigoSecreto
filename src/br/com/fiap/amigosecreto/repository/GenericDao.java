package br.com.fiap.amigosecreto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.amigosecreto.entity.Usuario;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	private EntityManager em;

	public GenericDao(Class<T> classe) {
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
	
	public Usuario buscarUsuario(String login, String senha){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select u from Usuario u where login = :login and senha = :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			List<Usuario> result = query.getResultList();
			em.getTransaction().commit();
			return result.isEmpty() ? null : result.get(0);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	
	public boolean existe(String login){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select u from Usuario u where login = :login");
			query.setParameter("login", login);
			boolean existe = !query.getResultList().isEmpty();
			em.getTransaction().commit();
			return existe;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

}
