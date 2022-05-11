package projeto.ifsol.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import projeto.ifsol.repository.ProdutoRepository;
import projeto.ifsol.model.Produtos;

@Controller
public class ServidorController {
	@Autowired
	private ProdutoRepository pr;
	
	@RequestMapping ("/listaProdutosServidores")
	public ModelAndView ListaProdutos() {
		
		ModelAndView mv = new ModelAndView("servidores/indexServidores");
		Iterable<Produtos> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/reservaProdutos")
	public String reservaProdutos(long id) {
		Produtos produtos = pr.findById(id);
		pr.delete(produtos);
		return "redirect:/listaProdutosServidores";
	
	}
}