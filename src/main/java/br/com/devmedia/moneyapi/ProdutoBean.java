package br.com.devmedia.moneyapi;

import static org.javamoney.moneta.function.MonetaryFunctions.sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.function.MonetaryFunctions;

@Named
@RequestScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	
	private Produtos produtos;
	
	private List<Produto> lista;
	
	private String moeda;
	
	private BigDecimal valorTotalReal = BigDecimal.ZERO;
	
	private BigDecimal valorTotalDolar = BigDecimal.ZERO;
	
	@Inject
	public ProdutoBean(Produtos produtos) {
		this.produtos = produtos;
	}
	
	public ProdutoBean() {
	}
	
	public BigDecimal getValorTotalReal() {
		CurrencyUnit real = Monetary.getCurrency("BRL");
		valorTotalReal = somaValorTotalPelaMoeda(real);
		return valorTotalReal;
	}
	
	public BigDecimal getValorTotalDolar() {
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		valorTotalDolar = somaValorTotalPelaMoeda(dolar);
		return valorTotalDolar;
	}
	
	private BigDecimal somaValorTotalPelaMoeda(CurrencyUnit moeda) {
		BigDecimal total = BigDecimal.ZERO;
		if (lista != null) {
			List<MonetaryAmount> moneys = new ArrayList<>();
			for (Produto produto : lista) {
				moneys.add(produto.getPreco());
			}
			
			Optional<MonetaryAmount> somaOptional = moneys.stream().filter(MonetaryFunctions.isCurrency(moeda)).reduce(sum());
			if (somaOptional.isPresent()) {
				MonetaryAmount soma = somaOptional.get();
				total = new BigDecimal(soma.getNumber().toString());
			}
		}
		return total;
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
