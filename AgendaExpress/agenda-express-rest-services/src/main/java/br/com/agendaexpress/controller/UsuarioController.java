package br.com.agendaexpress.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agendaexpress.beans.UsuarioBean;
import br.com.agendaexpress.exceptions.ExceptionDAO;
import br.com.agendaexpress.service.UsuarioService;

@Controller
@RequestMapping(name = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Content-Type=application/json", consumes = "application/json", produces = "application/json")
	public @ResponseBody void addPerson(ModelMap modelMap,
			HttpServletResponse resp, HttpServletRequest request,
			@RequestBody(required = true) UsuarioBean usuarioBean){
		try {
			usuarioService.addUsuario(usuarioBean);
		} catch (ExceptionDAO e) {
			e.printStackTrace();//TODO
		}
	}
}
