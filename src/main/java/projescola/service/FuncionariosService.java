package projescola.service;

import projescola.dao.FuncionariosDAO;
import projescola.model.Funcionarios;
import projescola.util.projescolaException;

public class FuncionariosService {
	
	private FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

	public void create(Funcionarios funcionarios) {
		if(funcionarios.getNome() == null || funcionarios.getNome().trim().isEmpty()) {
			throw new projescolaException(2001, "Campo 'Nome' não preenchido.");
		}
		
		if(funcionarios.getRg() == null || funcionarios.getRg().trim().isEmpty()) {
			throw new projescolaException(2002, "Campo 'RG' não preenchido.");
		}
		
		if(funcionarios.getEscolaridade() == null || funcionarios.getEscolaridade().trim().isEmpty()) {
			throw new projescolaException(2003, "Campo 'Escolaridade' não preenchido.");
		}
		
		if(funcionarios.getFuncao() == null || funcionarios.getFuncao().trim().isEmpty()) {
			throw new projescolaException(2004, "Campo 'Função' não preenchido.");
		}
		
		if(funcionarios.getCpf().length() < 11) {
			throw new projescolaException(2010, "CPF inválido!");
		}
		
		funcionariosDAO.persist(funcionarios);
	}
	
}
