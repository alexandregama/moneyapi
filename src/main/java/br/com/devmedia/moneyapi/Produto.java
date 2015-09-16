package br.com.devmedia.moneyapi;

import java.io.Serializable;
import java.util.Locale;

import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQuery;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.format.CurrencyStyle;

public class Produto implements Serializable {

	private static final long serialVersionUID = 7450393829018761120L;

	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private MonetaryAmount preco;
	
	private String precoFormatadoComCode;
	
	private String precoFormatadoComSimbolo;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", preco=" + preco + "]";
	}
	
	public String getPrecoFormatadoComCode() {
		if (preco != null) {
			MonetaryAmountFormat formatador = MonetaryFormats.getAmountFormat(new Locale("pt", "BR"));
			precoFormatadoComCode = formatador.format(preco);
		}
		
		return precoFormatadoComCode;
	}
	
	public String getPrecoFormatadoComSimbolo() {
		Locale brasil = new Locale("pt", "BR");
		AmountFormatQuery query = AmountFormatQueryBuilder.of(brasil).set(CurrencyStyle.SYMBOL).build();
		MonetaryAmountFormat formatador = MonetaryFormats.getAmountFormat(query);
		precoFormatadoComSimbolo = formatador.format(preco);
		
		return precoFormatadoComSimbolo;
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
