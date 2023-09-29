package br.com.mgsystems;

import org.junit.Assert;
import org.junit.Test;

import br.com.mgsystems.dao.CarroDAO;
import br.com.mgsystems.dao.ICarroDAO;
import br.com.mgsystems.dao.IMarcaDAO;
import br.com.mgsystems.dao.MarcaDAO;
import br.com.mgsystems.domain.Acessorio;
import br.com.mgsystems.domain.Carro;
import br.com.mgsystems.domain.Marca;

public class CarroTest {
	
	private ICarroDAO carroDAO;
	private IMarcaDAO marcaDAO;
	
	public CarroTest() {
		carroDAO = new CarroDAO();
		marcaDAO = new MarcaDAO();
	}
	
	@Test
	public void cadastrar() {
		
		Carro carro= new Carro();
		Marca marca = criarMarca("Ford", "F01");
		Acessorio acessorio1= criarAcessorio("SA16", "Roda Liga Leve Volcano Para Sprinter Aro 16 Tala 7 - 6x130", "Roda Liga Leve");
		Acessorio acessorio2= criarAcessorio("AFG1","Aerofólio Ford Fusion G1 Sel - Com Brakelight Led", "Aerofólio Ford Fusion");
		
		carro.setNome("Ford Fusion");
		carro.setNumPassageiros(4);
		carro.setValocidade(180.0);
		carro.setMarca(marca);
		carro.addAcessorio(acessorio1);
		carro.addAcessorio(acessorio2);
		
		carro = carroDAO.cadastrar(carro);
		
		Assert.assertNotNull(carro);
		Assert.assertNotNull(carro.getId());
		
	}
	
	public Marca criarMarca(String nome, String codigo) {
		
		Marca marca= new Marca();
		marca.setNome(nome);
		marca.setCodigo(codigo);
		return marcaDAO.cadastrar(marca);
		
	}
	
	public Acessorio criarAcessorio(String codigo, String descricao, String nome ) {
		
		Acessorio acessorio= new Acessorio();
		acessorio.setCodigo(codigo);
		acessorio.setNome(nome);
		acessorio.setDescricao(descricao);
		
		return acessorio;
	}

}
