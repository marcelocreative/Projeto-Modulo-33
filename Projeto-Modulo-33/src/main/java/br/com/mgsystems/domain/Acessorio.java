package br.com.mgsystems.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio")
public class Acessorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo", length = 5, nullable = false)
	private String codigo;
	
	@Column(name="nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "descricao", length = 100, nullable = false)
	private String descricao;
	
	@ManyToMany(mappedBy = "acessorios")
	private List<Carro> carros = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void addCarros(Carro carro) {
		carros.add(carro);
	}

	
}
