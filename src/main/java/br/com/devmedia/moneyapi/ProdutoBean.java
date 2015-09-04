package br.com.devmedia.moneyapi;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	
	private Produtos produtos = new ProdutosEmMemoria();
	
	private List<Produto> lista;
	
	public void salva() {
		produtos.cadastra(produto);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro com sucesso"));
		this.produto = new Produto();
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
	
}
