package projescola.dao;

import java.util.List;
import javax.persistence.EntityManager;
import projescola.dao.util.ConnectionFactory;
import projescola.model.Enderecos;
import projescola.util.projescolaException;

public class EnderecosDAO {
	
	public void persist(Enderecos enderecos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(enderecos);
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

	public void update(Enderecos enderecos) {
		EntityManager em = ConnectionFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(enderecos);
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

	public Enderecos findById(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		Enderecos enderecos;
		
		try {
			enderecos = em.find(Enderecos.class, id);
			em.close();
			return enderecos;
		} catch (Exception e) {
			em.close();
			throw new projescolaException(400, "Ocorreu um erro ao persistir na busca. Verifique se os dados estão corretos.");
		}		
		
	}

	public void remove(Integer id) {
		EntityManager em = ConnectionFactory.createEntityManager();
		
		try {
			em.getTransaction().begin();
			Enderecos endereco = em.find(Enderecos.class,id);
			
			if(endereco != null)
				em.remove(endereco);
			
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

	public List<Enderecos> all(){
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Enderecos> all = em.createQuery("from Enderecos", Enderecos.class).getResultList();
		em.close(); 
		return all;
	}
	
	public List<Enderecos> findAllByLogradouro(String logradouro) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Enderecos> all = em.createQuery("select e from Enderecos e where lower(e.logradouro) like lower(:logradouro)", Enderecos.class)
				.setParameter("logradouro", "%" + logradouro + "%")
				.getResultList();
		em.close();
		return all;
	}
	
	public List<Enderecos> findAllByBairro(String bairro) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Enderecos> all = em.createQuery("select e from Enderecos e where lower(e.bairro) like lower(:bairro)", Enderecos.class)
				.setParameter("bairro", "%" + bairro + "%")
				.getResultList();
		em.close();
		return all;
	}
	
	public List<Enderecos> findAllByCidade(String cidade) {
		EntityManager em = ConnectionFactory.createEntityManager();
		List<Enderecos> all = em.createQuery("select e from Enderecos e where lower(e.cidade) like lower(:cidade)", Enderecos.class)
				.setParameter("cidade", "%" + cidade + "%")
				.getResultList();
		em.close();
		return all;
	}
}
