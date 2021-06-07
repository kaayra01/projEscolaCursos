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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Turmas {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_turmas")
	@SequenceGenerator(initialValue = 100, allocationSize = 1, name = "gen_turmas", sequenceName = "seq_turmas")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAtTurmas;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String sala;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Alunos aluno;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Funcionarios funcionario;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Cursos curso;
	
	public Turmas() {
		super();
	}


	public Turmas(String nome, String sala) {
		super();
		this.nome = nome;
		this.sala = sala;
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


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	
	
}
