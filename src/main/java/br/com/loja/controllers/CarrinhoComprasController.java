package br.com.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.daos.ProdutoDAO;
import br.com.loja.models.CarrinhoCompras;
import br.com.loja.models.ItemDoCarrinho;
import br.com.loja.models.Produto;
import br.com.loja.models.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

	@Autowired
	private ProdutoDAO dao;
	
	@Autowired
	private CarrinhoCompras carrinhoCompras;
	
	@RequestMapping("/add")
	public ModelAndView add(Long id, TipoPreco tipoPreco) {
		ModelAndView mv = new ModelAndView("redirect:/carrinho");
		ItemDoCarrinho itemDoCarrinho = criaItem(id, tipoPreco);
		
		carrinhoCompras.add(itemDoCarrinho);
		
		return mv;
	}
	
	
	private ItemDoCarrinho criaItem(Long id, TipoPreco tipoPreco) {
		Produto produto = dao.find(id);
		ItemDoCarrinho itemDoCarrinho = new ItemDoCarrinho(produto, tipoPreco);
		
		return itemDoCarrinho;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens() {
		return new ModelAndView("carrinho/itens");
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Long id, TipoPreco tipoPreco) {
		carrinhoCompras.remover(id, tipoPreco);
		return new ModelAndView("redirect:/carrinho");
	}
	
}
