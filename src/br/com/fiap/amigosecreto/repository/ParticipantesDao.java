package br.com.fiap.amigosecreto.repository;

import java.util.List;

import javax.persistence.Query;

import br.com.fiap.amigosecreto.entity.Participantes;

public class ParticipantesDao extends GenericDao<Participantes> {

	public ParticipantesDao() {
		super(Participantes.class);
	}
	
	public boolean sorteioRealizado(){
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Query query = em.createNativeQuery("select 1 from sorteio limit 1");
			boolean foiRealizado = !query.getResultList().isEmpty();
			em.getTransaction().commit();
			return foiRealizado;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	
	public String busqueAmigoSecreto(int id) {
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select p.destinatario.nome from Participantes p where remetente.id = :id");
			query.setParameter("id", id);
			List<String> result = query.getResultList();
			em.getTransaction().commit();
			return result.isEmpty() ? null : result.get(0);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}
}
