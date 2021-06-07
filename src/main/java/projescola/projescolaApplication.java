package projescola;

import projescola.dao.CursosDAO;
import projescola.dao.util.ConnectionFactory;
import projescola.model.Cursos;
import projescola.service.CursosService;

public class projescolaApplication {

	public static void main(String[] args) {			
			
				
				CursosDAO cursosDAO = new CursosDAO();
				
				
				Cursos cr = new Cursos("Informatica", 300.00, 100);
				
				cursosDAO.persist(new Cursos("INGLES", 216.00, 80));
				
				
				Cursos cursos = cursosDAO.findById(10);
				
				cursosDAO.remove(cursos.getId());
				
				for (Cursos c : cursosDAO.all()) {
					System.out.println(c.getId() + " - " + c.getNome());
				}
				

				ConnectionFactory.close();
				
				
	}

}
