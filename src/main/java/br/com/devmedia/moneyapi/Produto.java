package br.com.devmedia.moneyapi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

public class Produto implements Serializable {

	private static final long serialVersionUID = 7450393829018761120L;

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal preco;
	
	private Currency moeda;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", preco=" + preco + ", moeda=" + moeda + "]";
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Currency getMoeda() {
		return moeda;
	}

	public void setMoeda(Currency moeda) {
		this.moeda = moeda;
	}
	
}
