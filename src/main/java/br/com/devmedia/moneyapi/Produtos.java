package br.com.devmedia.moneyapi;

import java.util.List;

public interface Produtos {

	void cadastra(Produto produto);

	List<Produto> getTodosOsProdutos();
	
}
