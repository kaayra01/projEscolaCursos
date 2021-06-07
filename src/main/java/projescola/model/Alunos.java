package projescola.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alunos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_alunos")
	@SequenceGenerator(initialValue = 100, allocationSize = 1, name = "gen_alunos", sequenceName = "seq_alunos")
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAtAlunos;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cpf;

	private String rg;

	@Column(nullable = false)
	private String dataNascimento;

	@Column(nullable = false)
	private String dataMatricula;

	@Column(nullable = false)
	private String matricula;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Enderecos endereco;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Contatos contato;

	public Alunos() {
		super();
	}

	public Alunos(Integer id, String nome, String cpf, String rg, String dataNascimento, String dataMatricula,
			String matricula) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.dataMatricula = dataMatricula;
		this.matricula = matricula;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
