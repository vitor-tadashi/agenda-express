package br.com.agendaexpress.backofficeweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.agendaexpress.beans.Heroe;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;


@Service
public class TesteRestService {

	public List<Heroe> listHeroes() {
		List<Heroe> heroes = new ArrayList<Heroe>();
		heroes.add(new Heroe(1L, "Thresh"));
		heroes.add(new Heroe(2L, "Blitz"));
		heroes.add(new Heroe(3L, "Sejuani"));
		heroes.add(new Heroe(4L, "VI"));
		return heroes;
	}

}
