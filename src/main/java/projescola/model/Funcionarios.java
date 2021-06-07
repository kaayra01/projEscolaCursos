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
public class Funcionarios{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_funcionarios")
	@SequenceGenerator(initialValue = 100, allocationSize = 1, name = "gen_funcionarios", sequenceName = "seq_funcionarios")
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAtFuncionarios;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String rg;

	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private String escolaridade;

	@Column(nullable = false)
	private String funcao;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Enderecos endereco;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Contatos contato;
	


	public Funcionarios() {
		super();
	}

	public Funcionarios(String nome, String rg, String cpf, String escolaridade, String funcao) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.escolaridade = escolaridade;
		this.funcao = funcao;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
}
