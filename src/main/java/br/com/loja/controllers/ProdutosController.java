package br.com.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.loja.daos.ProdutoDAO;
import br.com.loja.models.Produto;
import br.com.loja.models.TipoPreco;

@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("produtos/formulario");
		mv.addObject("tipos", TipoPreco.values());
		return mv;
	}
	
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		
		dao.gravar(produto);
		return "produtos/ok";
	}
	
	
}
