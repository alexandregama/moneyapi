package br.com.devmedia.moneyapi;

import java.io.Serializable;

import javax.money.MonetaryAmount;

public class Produto implements Serializable {

	private static final long serialVersionUID = 7450393829018761120L;

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private MonetaryAmount preco;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", preco=" + preco + "]";
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

	public MonetaryAmount getPreco() {
		return preco;
	}
	
	public void setPreco(MonetaryAmount preco) {
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
