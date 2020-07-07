package br.com.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loja.daos.ProdutoDAO;
import br.com.loja.models.Produto;
import br.com.loja.models.TipoPreco;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("form")
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView("produtos/formulario");
		mv.addObject("tipos", TipoPreco.values());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:produtos");
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		dao.gravar(produto); //completar RedAttr
		
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("produtos/lista");
		List<Produto> produtos = dao.listar();
		mv.addObject("produtos", produtos);
		
		return mv;
	}
	
	
}
