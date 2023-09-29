package br.com.mgsystems.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="velocidade", nullable = false)
	private Double valocidade;
	
	@Column(name="nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name="numero_passageiros", length = 2, nullable = false)
	private Integer numPassageiros;
	
	@ManyToOne
	@JoinColumn(name= "id_marca_fk", foreignKey = @ForeignKey(name= "fk_marca_carro"), referencedColumnName = "id", nullable = false)
	private Marca marca;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "tb_carro_acessorio",
			joinColumns = @JoinColumn(name= "id_carro_fk"),
			inverseJoinColumns = @JoinColumn(name="id_acessorio_fk")
		)
	List<Acessorio> acessorios = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValocidade() {
		return valocidade;
	}

	public void setValocidade(Double valocidade) {
		this.valocidade = valocidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(Integer numPassageiros) {
		this.numPassageiros = numPassageiros;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void addAcessorio(Acessorio acessorio) {
		acessorios.add(acessorio);
	}
	
}
