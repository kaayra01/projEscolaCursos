package projescola.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cursos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_cursos")
	@SequenceGenerator(initialValue = 5, allocationSize = 1, name = "gen_cursos", sequenceName = "seq_cursos")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAtCursos;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Double valor;

	@Column(nullable = false)
	private Integer cargaHoraria;

	public Cursos() {
		super();
	}

	public Cursos(String nome, Double valor, Integer cargaHoraria) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.cargaHoraria = cargaHoraria;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
}
