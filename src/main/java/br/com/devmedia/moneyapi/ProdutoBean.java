package br.com.devmedia.moneyapi;

import java.math.BigDecimal;
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
	
	private BigDecimal totalEmReal = BigDecimal.ZERO;
	
	private BigDecimal totalEmDolar  = BigDecimal.ZERO;
	
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
			
			if (lista != null) {
				for (Produto produto : lista) {
					if (produto.getMoeda().getCurrencyCode().equals("BRL")) {
						totalEmReal = totalEmReal.add(produto.getPreco());
					}
					else if (produto.getMoeda().getCurrencyCode().equals("USD")) {
						totalEmDolar = totalEmDolar.add(produto.getPreco());
					}
				}
			}
		}
		return lista;
	}
	
	public BigDecimal getTotalEmReal() {
		return totalEmReal;
	}
	
	public BigDecimal getTotalEmDolar() {
		return totalEmDolar;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
