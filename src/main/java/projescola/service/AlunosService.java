package projescola.service;

import projescola.dao.AlunosDAO;
import projescola.model.Alunos;
import projescola.util.projescolaException;

public class AlunosService {
	
	private AlunosDAO alunosDAO = new AlunosDAO();

	public void create(Alunos alunos) {
		if(alunos.getNome() == null || alunos.getNome().trim().isEmpty()) {
			throw new projescolaException(2001, "Campo 'Nome' n�o preenchido.");
		}
		
		if(alunos.getDataNascimento() == null || alunos.getDataNascimento().trim().isEmpty()) {
			throw new projescolaException(2002, "Campo 'Data de Nascimento' n�o preenchido.");
		}
		
		if(alunos.getDataMatricula() == null || alunos.getDataMatricula().trim().isEmpty()) {
			throw new projescolaException(2003, "Campo 'Data de Matr�cula' n�o preenchido.");
		}
		
		if(alunos.getMatricula() == null || alunos.getMatricula().trim().isEmpty()) {
			throw new projescolaException(2004, "Campo 'Matr�cula' n�o preenchido.");
		}
		
		if(alunos.getCpf().length() < 11) {
			throw new projescolaException(2010, "CPF inv�lido!");
		}
		
		alunosDAO.persist(alunos);
	}
	
}
