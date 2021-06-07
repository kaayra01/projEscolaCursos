package projescola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Contatos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_contatos")
	@SequenceGenerator(initialValue = 10, allocationSize = 1, name = "gen_contatos", sequenceName = "seq_contatos")
	private Integer id;

	@Column(nullable = false)
	private String telefone;
	
	private String email;

	private String celular;

	public Contatos() {
		super();

	}

	public Contatos(String telefone, String email, String celular) {
		super();
		this.telefone = telefone;
		this.email = email;
		this.celular = celular;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}
