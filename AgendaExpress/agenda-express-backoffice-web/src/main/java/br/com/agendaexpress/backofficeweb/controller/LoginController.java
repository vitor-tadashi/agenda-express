package br.com.agendaexpress.backofficeweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{
	
	private static final String LOGIN_PAGE = "login";
	
	@RequestMapping("/login")
	public ModelAndView login(String login, String password) {
		usuarioBean.setLogin(login);
		usuarioBean.setSenha(password);
		return new ModelAndView(LOGIN_PAGE);
	}
}
