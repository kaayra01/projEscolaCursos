package projescola.dao;

import java.util.List;

import javax.persistence.EntityManager;

import projescola.dao.util.ConnectionFactory;
import projescola.model.Aulas;
import projescola.util.projescolaException;

public class AulasDAO {

	public void persist(Aulas aulas) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(aulas);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			if(em.isOpen() && em.getTransaction().isActive());{
				em.getTransaction().rollback();
			}
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir. Verifique se os dados estão corretos.");
		}
		
	}

	public void update(Aulas aulas) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(aulas);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			if(em.isOpen() && em.getTransaction().isActive());{
				em.getTransaction().rollback();
			}
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na atualização. Verifique se os dados estão corretos.");
		}
	}

	public Aulas findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Aulas aulas;
		
		try {
			aulas = em.find(Aulas.class, id);
			em.close();
			return aulas;
		} catch (Exception e) {
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na busca. Verifique se os dados estão corretos.");
		}		
		
	}

	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Aulas aulas = em.find(Aulas.class,id);
			
			if(aulas != null)
				em.remove(aulas);
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			if(em.isOpen() && em.getTransaction().isActive());{
				em.getTransaction().rollback();
			}
			em.close();
			throw new projescolaException(400, "Ocorreu um erro na remoção. Verifique se os dados estão corretos.");
		}
	}

	public List<Aulas> all(){
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Aulas> all = em.createQuery("from Aulas", Aulas.class).getResultList();
		em.close(); 
		return all;
	}
	
	public List<Aulas> findAllByTurno(String turno) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Aulas> all = em.createQuery("select a from Aulas a where lower(a.turno) like lower(:turno)", Aulas.class)
				.setParameter("turno", "%" + turno + "%")
				.getResultList();
		em.close();
		return all;
	}
}
