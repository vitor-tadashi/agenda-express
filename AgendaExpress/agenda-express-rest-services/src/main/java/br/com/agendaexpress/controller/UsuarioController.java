package br.com.agendaexpress.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.agendaexpress.Exception.RestException;
import br.com.agendaexpress.beans.SeguirBean;
import br.com.agendaexpress.beans.UsuarioBean;
import br.com.agendaexpress.commons.util.SpringContextHolder;
import br.com.agendaexpress.exceptions.BusinessException;
import br.com.agendaexpress.exceptions.DAOException;
import br.com.agendaexpress.service.UsuarioService;

@Path("/usuario")
public class UsuarioController {

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUsuario(UsuarioBean usuarioBean) {
		try {
			UsuarioService usuarioService = SpringContextHolder
					.getApplicationContext().getBean(UsuarioService.class);
			usuarioService.addUsuario(usuarioBean);
		} catch (DAOException e) {
			return Response.status(500)
					.entity(new RestException(e.getMessage())).build();
		} catch (BusinessException e) {
			return Response.status(500)
					.entity(new RestException(e.getMessage())).build();
		}
		return Response.status(200).entity("success").build();
	}

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUsuario(Integer id) {
		try {
			UsuarioService usuarioService = SpringContextHolder
					.getApplicationContext().getBean(UsuarioService.class);
			usuarioService.delUsuario(id);
		} catch (DAOException e) {
			return Response.status(500)
					.entity(new RestException(e.getMessage())).build();
		}
		return Response.status(200).entity("success").build();
	}

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUsuario(UsuarioBean usuarioBean) {
		try {
			UsuarioService usuarioService = SpringContextHolder
					.getApplicationContext().getBean(UsuarioService.class);
			usuarioService.updateUsuario(usuarioBean);
		} catch (DAOException e) {
			return Response.status(500)
					.entity(new RestException(e.getMessage())).build();
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
		} catch (DAOException e) {
			return Response.status(500)
					.entity(new RestException(e.getMessage())).build();
		}
		return Response.status(200).entity(usuario).build();
	}

	@POST
	@Path("/seguir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response seguir(SeguirBean seguir) {
		List<UsuarioBean> usuario = null;
		try {
			UsuarioService usuarioService = SpringContextHolder
					.getApplicationContext().getBean(UsuarioService.class);
			usuarioService.seguir(seguir.getIdUsuarioSeguidor(),
					seguir.getIdUsuario());
		} catch (DAOException e) {
			e.printStackTrace();
			return Response.status(500)
					.entity(new RestException(e.getMessage())).build();
		} catch (BusinessException e) {
			return Response.status(500)
					.entity(new RestException(e.getMessage())).build();
		}
		return Response.status(200).entity(usuario).build();
	}

	/*
	 * var usuario = new Object(); var pessoa = new Object(); var pessoaFisica =
	 * new Object();
	 * 
	 * pessoaFisica.cpf=37009779805; pessoaFisica.nome="Alexandre Genka";
	 * 
	 * pessoa.pessoaFisica = pessoaFisica;
	 * 
	 * usuario.email="xande.genka@gmail.com"; usuario.login="difosal";
	 * usuario.senha="senha"; usuario.pessoaBean=pessoa;
	 * JSON.stringify(usuario);
	 */

}
