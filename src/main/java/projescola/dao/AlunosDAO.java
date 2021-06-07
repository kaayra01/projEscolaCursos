package projescola.dao;

import java.util.List;
import projescola.model.Alunos;
import javax.persistence.EntityManager;
import projescola.dao.util.ConnectionFactory;
import projescola.util.projescolaException;

public class AlunosDAO {
	
	public void persist(Alunos alunos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(alunos);
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

	public void update(Alunos alunos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(alunos);
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

	public Alunos findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Alunos alunos;
		
		try {
			alunos = em.find(Alunos.class, id);
			em.close();
			return alunos;
		} catch (Exception e) {
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na busca. Verifique se os dados estão corretos.");
		}		
		
	}

	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Alunos aluno = em.find(Alunos.class,id);
			
			if(aluno != null)
				em.remove(aluno);
			
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

	public List<Alunos> all(){
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Alunos> all = em.createQuery("from Alunos", Alunos.class).getResultList();
		em.close(); 
		return all;
	}
	
	public List<Alunos> findAllByName(String nome) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Alunos> all = em.createQuery("select a from Alunos a where lower(a.nome) like lower(:nome)", Alunos.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
		em.close();
		return all;
	}
}
