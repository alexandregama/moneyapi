package br.com.devmedia.moneyapi;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	
	private Produtos produtos;
	
	private List<Produto> lista;
	
	private String moeda;
	
	@Inject
	public ProdutoBean(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public ProdutoBean() {
	}
	
	public void salva() {
		produtos.cadastra(produto);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro com sucesso"));
		this.produto = new Produto();
		this.lista = null;
	}
	
	public List<Produto> getLista() {
		if (lista == null) {
			lista = produtos.getTodosOsProdutos();
		}
		return lista;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	
}
