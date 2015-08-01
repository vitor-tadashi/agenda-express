package br.com.agendaexpress.backofficeweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.agendaexpress.beans.UsuarioBean;

@Controller
public abstract class BaseController {
	
	private static final String INDEX_PAGE = "index";
	
	@Autowired
	UsuarioBean usuarioBean;
	
	@RequestMapping({"","/", "/home","/index","/hello"})
	public ModelAndView index(){
		return new ModelAndView(INDEX_PAGE);
	}
}
