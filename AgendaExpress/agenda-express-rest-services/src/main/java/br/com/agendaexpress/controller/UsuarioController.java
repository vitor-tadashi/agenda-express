package br.com.agendaexpress.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.agendaexpress.beans.UsuarioBean;
import br.com.agendaexpress.commons.util.SpringContextHolder;
import br.com.agendaexpress.exceptions.ExceptionDAO;
import br.com.agendaexpress.service.UsuarioService;

@Path("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuario(UsuarioBean usuarioBean) {
		try {
			usuarioService.addUsuario(usuarioBean);
		} catch (ExceptionDAO e) {
			e.printStackTrace();// TODO
		}
		return Response.status(200).entity("success").build();
	}

	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUsuario(Integer id) {
		try {
			usuarioService.delUsuario(id);
		} catch (ExceptionDAO e) {
			e.printStackTrace();// TODO
		}
		return Response.status(200).entity("success").build();
	}

	@GET
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUsuario(UsuarioBean usuarioBean) {
		try {
			usuarioService.updateUsuario(usuarioBean);
		} catch (ExceptionDAO e) {
			e.printStackTrace();// TODO
		}
		return Response.status(200).entity("success").build();
	}

	@POST
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response get(UsuarioBean usuarioBean) {

		System.out.println(usuarioBean);
		List<UsuarioBean> usuario = null;
		try {
			UsuarioService usuarioService = SpringContextHolder
					.getApplicationContext().getBean(UsuarioService.class);
			usuario = usuarioService.findUsuarioByFilter(usuarioBean);
		} catch (ExceptionDAO e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(usuario).build();
	}
}
