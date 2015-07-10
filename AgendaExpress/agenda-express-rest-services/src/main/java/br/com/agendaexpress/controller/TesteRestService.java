package br.com.agendaexpress.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendaexpress.beans.Heroe;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

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