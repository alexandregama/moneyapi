package br.com.devmedia.moneyapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutosEmMemoria implements Produtos, Serializable {

	private static final long serialVersionUID = -8272280326281942350L;
	
	private static final Map<Long, Produto> banco = new HashMap<>();
	private Long id = 1l;
	
	@Override
	public void cadastra(Produto produto) {
		produto.setId(++id);
		banco.put(id, produto);
	}

	@Override
	public List<Produto> getTodosOsProdutos() {
		List<Produto> produtos = new ArrayList<>(banco.values());
		
		return produtos;
	}

}
