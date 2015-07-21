package br.com.agendaexpress.backofficeweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agendaexpress.beans.Heroe;

@Controller
@RequestMapping("/lol/heroes")
public class TesteRest {

	@Autowired
	private TesteRestService testeRestService;

	@RequestMapping(value = "/listHeroes", method = RequestMethod.GET)
	public @ResponseBody List<Heroe> getHeros() {
		return testeRestService.listHeroes();
	}

	
}
