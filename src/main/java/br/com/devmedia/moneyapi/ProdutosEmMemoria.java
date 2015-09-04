package br.com.devmedia.moneyapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutosEmMemoria implements Produtos {

	private Map<Long, Produto> banco = new HashMap<>();
	private Long id = 1l;
	
	@Override
	public void cadastra(Produto produto) {
		produto.setId(id);
		banco.put(id, produto);
	}

	@Override
	public List<Produto> getTodosOsProdutos() {
		List<Produto> produtos = new ArrayList<>(banco.values());
		
		return produtos;
	}

}
