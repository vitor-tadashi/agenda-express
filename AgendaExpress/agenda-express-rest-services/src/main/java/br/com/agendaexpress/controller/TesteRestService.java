package br.com.agendaexpress.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendaexpress.beans.Heroe;

@RestController
@RequestMapping("/testeHeroesService")
public class TesteRestService {

	@ResponseBody
	@RequestMapping(value = "/listHeroes", method = RequestMethod.GET)
	public List<Heroe> listHeroes(HttpServletRequest req,
			HttpServletResponse resp) {

		List<Heroe> heroes = new ArrayList<Heroe>();
		heroes.add(new Heroe(1L, "Thresh"));
		heroes.add(new Heroe(2L, "Blitz"));
		heroes.add(new Heroe(3L, "Sejuani"));
		heroes.add(new Heroe(4L, "VI"));
		return heroes;
	}

}