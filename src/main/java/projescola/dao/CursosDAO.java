package projescola.dao;

import java.util.List;
import javax.persistence.EntityManager;
import projescola.dao.util.ConnectionFactory;
import projescola.model.Cursos;
import projescola.util.projescolaException;

public class CursosDAO {
	
	
	public void persist(Cursos cursos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(cursos);
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
	
	public void update(Cursos cursos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(cursos);
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
	
	public Cursos findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Cursos cursos;
		
		try {
			cursos = em.find(Cursos.class, id);
			em.close();
			return cursos;
		} catch (Exception e) {
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na busca. Verifique se os dados estão corretos.");
		}		
		
	}
	
	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Cursos curso = em.find(Cursos.class,id);
			
			if(curso != null)
				em.remove(curso);
			
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
	
	public List<Cursos> all(){
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Cursos> all = em.createQuery("from Cursos", Cursos.class).getResultList();
		em.close(); 
		return all;
	}
	
	public Cursos findByName(String nome) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Cursos c = em.createQuery("select m from Cursos c where c.nome = :nome", Cursos.class)
				.setParameter("nome", nome)
				.getSingleResult();
		em.close();
		return c;
	}
	
	public List<Cursos> findAllByName(String nome) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Cursos> all = em.createQuery("select c from Cursos c where lower(c.nome) like lower(:nome)", Cursos.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
		em.close();
		return all;
	}
}
