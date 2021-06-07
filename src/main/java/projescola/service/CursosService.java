package projescola.service;

import projescola.dao.CursosDAO;
import projescola.model.Cursos;
import projescola.util.projescolaException;

public class CursosService {
	
	private CursosDAO cursosDAO = new CursosDAO();

	public void create(Cursos cursos) {
		if(cursos.getNome() == null || cursos.getNome().trim().isEmpty()) {
			throw new projescolaException(2001, "Campo 'Nome' n�o preenchido.");
		}
		
		if(cursos.getCargaHoraria() < 40) {
			throw new projescolaException(2030, "Carga hor�ria de curso abaixo da permitida!");
		}
		
		cursosDAO.persist(cursos);
	}
	
}
