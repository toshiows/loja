package br.com.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loja.models.Produto;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/formulario";
	}
	
	@RequestMapping("produtos")
	public String gravar(Produto produto) {
		System.out.println(produto.getNome());
		System.out.println(produto.getDescricao());
		System.out.println(produto.getMarca());
		
		return "produtos/ok";
	}
}
