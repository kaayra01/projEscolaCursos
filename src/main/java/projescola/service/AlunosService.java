package projescola.service;

import projescola.dao.AlunosDAO;
import projescola.model.Alunos;
import projescola.util.projescolaException;

public class AlunosService {
	
	private AlunosDAO alunosDAO = new AlunosDAO();

	public void create(Alunos alunos) {
		if(alunos.getNome() == null || alunos.getNome().trim().isEmpty()) {
			throw new projescolaException(2001, "Campo 'Nome' não preenchido.");
		}
		
		if(alunos.getDataNascimento() == null || alunos.getDataNascimento().trim().isEmpty()) {
			throw new projescolaException(2002, "Campo 'Data de Nascimento' não preenchido.");
		}
		
		if(alunos.getDataMatricula() == null || alunos.getDataMatricula().trim().isEmpty()) {
			throw new projescolaException(2003, "Campo 'Data de Matrícula' não preenchido.");
		}
		
		if(alunos.getMatricula() == null || alunos.getMatricula().trim().isEmpty()) {
			throw new projescolaException(2004, "Campo 'Matrícula' não preenchido.");
		}
		
		if(alunos.getCpf().length() < 11) {
			throw new projescolaException(2010, "CPF inválido!");
		}
		
		alunosDAO.persist(alunos);
	}
	
}
