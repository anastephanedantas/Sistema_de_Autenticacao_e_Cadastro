package projeto.ifsol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import projeto.ifsol.repository.ProdutoRepository;
import projeto.ifsol.model.Produtos;

@Controller
public class ProdutorController {
	@Autowired
	private ProdutoRepository pr;
	
	@RequestMapping (value="/cadastrarProduto", method=RequestMethod.GET)
	public String adicionarProduto() {
		return "produtores/formProdutos";
		
	}
	
	@RequestMapping (value="/cadastrarProduto", method= RequestMethod.POST)
	public String adicionarProduto(Produtos produtos) {
		pr.save(produtos);
		return "redirect:/cadastrarProduto";
		
	}
	@RequestMapping("/listaProdutos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("produtores/listaProdutos");
		Iterable<Produtos> produtos = pr.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}
	
	@RequestMapping("/detelar")
	public String deletarProduto(long id) {
		Produtos produtos = pr.findById(id);
		pr.delete(produtos);
		return "redirect:/listaProdutos";
	}
}
