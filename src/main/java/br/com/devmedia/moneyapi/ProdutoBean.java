package br.com.devmedia.moneyapi;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
