package br.com.agendaexpress.backofficeweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.agendaexpress.beans.Heroe;


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
