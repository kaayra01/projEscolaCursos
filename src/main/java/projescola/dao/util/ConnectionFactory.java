package projescola.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-escolaCursos");
	
	private ConnectionFactory() {
	}
	
	public static EntityManager createEntityManager() {
		if(emf == null || !emf.isOpen())
			emf = Persistence.createEntityManagerFactory("unit-escolaCursos");
		return emf.createEntityManager();
	}
	
	public static void close() {
		if(emf != null && emf.isOpen())
			emf.close();
	}
}
