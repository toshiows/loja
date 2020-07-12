package br.com.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,
proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<ItemDoCarrinho, Integer> itens = new LinkedHashMap<>();
	
	public void add(ItemDoCarrinho itemDoCarrinho) {
		itens.put(itemDoCarrinho, getQuantidade(itemDoCarrinho) + 1);
		System.out.println(itemDoCarrinho.getProduto().getNome());
	}
	
	public Integer getQuantidade(ItemDoCarrinho itemDoCarrinho) {
		if(!itens.containsKey(itemDoCarrinho)) {
			itens.put(itemDoCarrinho, 0);
		}
			return itens.get(itemDoCarrinho);
		
	}
	
	public int getQuantidade() {
		return itens.values().stream().reduce(0, (proximo, acumulador) -> proximo + acumulador);
	}
	
	public Collection<ItemDoCarrinho> getItens() {
		return itens.keySet();
	}
	
	public BigDecimal getTotal(ItemDoCarrinho item) {
		return item.getTotal(getQuantidade(item));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(ItemDoCarrinho item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		
		return total;
	}
	
	public void remover(Long produtoId, TipoPreco tipoPreco) {
		Produto produto = new Produto();
		produto.setId(produtoId);
		itens.remove(new ItemDoCarrinho(produto, tipoPreco));
	}
	
}
