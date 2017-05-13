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
	
	public Usuario buscarUsuario(String nome, String senha){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select u from Usuario u where nome = :nome and senha = :senha");
			query.setParameter("nome", nome);
			query.setParameter("senha", senha);
			Usuario usuario = (Usuario) query.getSingleResult();
			em.getTransaction().commit();
			return usuario;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

}
