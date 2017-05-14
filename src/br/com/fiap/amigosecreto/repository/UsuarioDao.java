package br.com.fiap.amigosecreto.repository;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;

public class UsuarioDao extends GenericDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
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
	
	public List<Usuario> listarParticipantes(){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select u from Usuario u where perfil = :perfil");
			query.setParameter("perfil", Perfil.PARTICIPANTE);
			List<Usuario> result = query.getResultList();
			em.getTransaction().commit();
			return result;
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
