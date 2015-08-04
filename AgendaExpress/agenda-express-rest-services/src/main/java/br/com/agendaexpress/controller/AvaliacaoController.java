package br.com.agendaexpress.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.agendaexpress.Exception.RestException;
import br.com.agendaexpress.beans.AvaliacaoBean;
import br.com.agendaexpress.exceptions.DAOException;
import br.com.agendaexpress.service.AvaliacaoService;

@Path("/avaliacao")
public class AvaliacaoController {

	@Autowired
	AvaliacaoService avaliacaoService;
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAvaliacao(ModelMap modelMap, HttpServletResponse resp, HttpServletRequest request, AvaliacaoBean avaliacaoBean) throws RestException{
		try {
			avaliacaoService.addAvaliacao(avaliacaoBean);
		} catch (DAOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}
	
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAvaliacao(ModelMap modelMap, HttpServletResponse resp, HttpServletRequest request, AvaliacaoBean avaliacaoBean) throws RestException{
		try {
			avaliacaoService.updateAvaliacao(avaliacaoBean);
		} catch (DAOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}
	
	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAvaliacao(ModelMap modelMap, HttpServletResponse resp, HttpServletRequest request, Integer id) throws RestException{
		try {
			avaliacaoService.deleteAvaliacao(id);
		} catch (DAOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getAvaliacao(ModelMap modelMap, HttpServletResponse resp, HttpServletRequest request, AvaliacaoBean avaliacaoBean) throws RestException{
		try {
			avaliacaoService.findAvaliacao(avaliacaoBean);
		} catch (DAOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}
}
