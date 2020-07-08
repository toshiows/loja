package br.com.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loja.daos.ProdutoDAO;
import br.com.loja.infra.FileSaver;
import br.com.loja.models.Produto;
import br.com.loja.models.TipoPreco;
import br.com.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO dao;
	
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}
	
	@RequestMapping("form")
	public ModelAndView form(Produto produto) {
		ModelAndView mv = new ModelAndView("produtos/formulario");
		mv.addObject("tipos", TipoPreco.values());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(MultipartFile arquivo, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return form(produto);
		}
		
		String path = fileSaver.write("resources/imagens", arquivo);
		produto.setArquivoPath(path);
		
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
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("produtos/detalhe");
		Produto produto = dao.find(id);
		mv.addObject("produto", produto);
		
		return mv;
		
	}
	
	
}
