package projescola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Enderecos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_enderecos")
	@SequenceGenerator(initialValue = 10, allocationSize = 1, name = "gen_enderecos", sequenceName = "seq_enderecos")
	private Integer id;

	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private Integer numero;

	@Column(nullable = false)
	private String bairro;

	private Integer cep;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String estado;

	private String complemento;
	
	

	public Enderecos() {
		super();
	}

	public Enderecos(String logradouro, Integer numero, String bairro, Integer cep, String cidade, String estado,
			String complemento) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	
	
}
