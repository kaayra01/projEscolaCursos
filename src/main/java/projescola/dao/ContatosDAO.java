package projescola.dao;

import java.util.List;

import javax.persistence.EntityManager;

import projescola.dao.util.ConnectionFactory;
import projescola.model.Contatos;
import projescola.util.projescolaException;

public class ContatosDAO {
	
	public void persist(Contatos contatos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(contatos);
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

	public void update(Contatos contatos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(contatos);
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

	public Contatos findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Contatos contatos;
		
		try {
			contatos = em.find(Contatos.class, id);
			em.close();
			return contatos;
		} catch (Exception e) {
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na busca. Verifique se os dados estão corretos.");
		}		
		
	}

	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Contatos contato = em.find(Contatos.class,id);
			
			if(contato != null)
				em.remove(contato);
			
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

	public List<Contatos> all(){
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Contatos> all = em.createQuery("from Contatos", Contatos.class).getResultList();
		em.close(); 
		return all;
	}
	
	public List<Contatos> findAllByTelefone(String telefone) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Contatos> all = em.createQuery("select a from Contatos c where lower(c.telefone) like lower(:telefone)", Contatos.class)
				.setParameter("telefone", "%" + telefone + "%")
				.getResultList();
		em.close();
		return all;
	}
}
