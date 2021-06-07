package projescola.dao;

import java.util.List;
import javax.persistence.EntityManager;
import projescola.dao.util.ConnectionFactory;
import projescola.model.Funcionarios;
import projescola.util.projescolaException;

public class FuncionariosDAO {
	
	public void persist(Funcionarios funcionarios) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(funcionarios);
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
	
	public void update(Funcionarios funcionarios) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(funcionarios);
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
	
	public Funcionarios findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Funcionarios funcionarios;
		
		try {
			funcionarios = em.find(Funcionarios.class, id);
			em.close();
			return funcionarios;
		} catch (Exception e) {
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na busca. Verifique se os dados estão corretos.");
		}		
		
	}
	
	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Funcionarios funcionarios = em.find(Funcionarios.class,id);
			
			if(funcionarios != null)
				em.remove(funcionarios);
			
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
	
	public List<Funcionarios> all(){
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Funcionarios> all = em.createQuery("from Funcionarios", Funcionarios.class).getResultList();
		em.close(); 
		return all;
	}
	
	public Funcionarios findByName(String nome) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Funcionarios f = em.createQuery("select m from Funcionarios f where f.nome = :nome", Funcionarios.class)
				.setParameter("nome", nome)
				.getSingleResult();
		em.close();
		return f;
	}
	
	public List<Funcionarios> findAllByName(String nome) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Funcionarios> all = em.createQuery("select f from Funcionarios f where lower(f.nome) like lower(:nome)", Funcionarios.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
		em.close();
		return all;
	}
}
