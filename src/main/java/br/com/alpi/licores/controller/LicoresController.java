package br.com.alpi.licores.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alpi.licores.model.Licor;
import br.com.alpi.licores.model.SaborLicor;
import br.com.alpi.licores.repository.Licores;

@Controller
@RequestMapping("/licores")
public class LicoresController {
	
	@Autowired
	private Licores licores;
	
    @DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
	licores.delete(id);
	
	attributes.addFlashAttribute("mensagem", "Licor removido com sucesso");
	 return "redirect:/licores";
	}
	
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("licores/lista-licores");
		modelAndView.addObject("licores", licores.findAll());
		
		return modelAndView;
	
	}

	@GetMapping("/novo")
	public ModelAndView novo(Licor licor) {
		ModelAndView modelAndView = new ModelAndView("licores/cadastro-licor");
		
		modelAndView.addObject(licor);
		modelAndView.addObject("sabores", SaborLicor.values());
		
		return modelAndView;
	}
	
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Licor licor, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(licor);
		}
		licores.save(licor);
		attributes.addFlashAttribute("mensagem","Licor salvo com sucesso!");
		
		return new ModelAndView("redirect:/licores/novo");
	}
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(licores.findOne(id));
	}
}

