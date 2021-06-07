package projescola.dao;

import java.util.List;
import javax.persistence.EntityManager;
import projescola.dao.util.ConnectionFactory;
import projescola.model.Turmas;
import projescola.util.projescolaException;

public class TurmasDAO {
	public void persist(Turmas turmas) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(turmas);
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
	
	public void update(Turmas turmas) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(turmas);
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
	
	public Turmas findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Turmas turmas;
		
		try {
			turmas = em.find(Turmas.class, id);
			em.close();
			return turmas;
		} catch (Exception e) {
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na busca. Verifique se os dados estão corretos.");
		}		
		
	}
	
	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Turmas turma = em.find(Turmas.class,id);
			
			if(turma != null)
				em.remove(turma);
			
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
	
	public List<Turmas> all(){
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Turmas> all = em.createQuery("from Turmas", Turmas.class).getResultList();
		em.close(); 
		return all;
	}
	
	public Turmas findByName(String nome) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Turmas t = em.createQuery("select m from Turmas t where t.nome = :nome", Turmas.class)
				.setParameter("nome", nome)
				.getSingleResult();
		em.close();
		return t;
	}
	
	public List<Turmas> findAllByName(String nome) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Turmas> all = em.createQuery("select t from Turmas t where lower(t.nome) like lower(:nome)", Turmas.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
		em.close();
		return all;
	}
}
