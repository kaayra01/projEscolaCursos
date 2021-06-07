package projescola.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Aulas {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_aulas")
	@SequenceGenerator(initialValue = 100, allocationSize = 1, name = "gen_aulas", sequenceName = "seq_aulas")
	private Integer id;
	
	@Column(nullable = false)
	private String horario;
	
	@Column(nullable = false)
	private String data;

	@Column(nullable = false)
	private String turno;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Funcionarios funcionario;

	public Aulas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aulas(String horario, String data, String turno) {
		super();
		this.horario = horario;
		this.data = data;
		this.turno = turno;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	
}
