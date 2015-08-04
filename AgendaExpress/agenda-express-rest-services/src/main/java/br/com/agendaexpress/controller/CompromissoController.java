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

import br.com.agendaexpress.Exception.RestException;
import br.com.agendaexpress.beans.TipoCompromissoBean;
import br.com.agendaexpress.exceptions.DAOException;
import br.com.agendaexpress.service.CompromissoService;

@Controller
@RequestMapping(name = "/compromisso")
public class CompromissoController {

	@Autowired
	CompromissoService compromissoService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Content-Type=application/json", consumes = "application/json", produces = "application/json")
	public @ResponseBody void addCompromisso(
			ModelMap modelMap,
			HttpServletResponse resp,
			HttpServletRequest request,
			@RequestBody(required = true) TipoCompromissoBean tipoCompromissoBean)
			throws RestException {
		try {
			compromissoService.addCompromisso(tipoCompromissoBean);
		} catch (DAOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Content-Type=application/json", consumes = "application/json", produces = "application/json")
	public @ResponseBody void deleteCompromisso(ModelMap modelMap,
			HttpServletResponse resp, HttpServletRequest request,
			@RequestBody(required = true) Integer id) throws RestException {
		try {
			compromissoService.deleteCompromisso(id);
		} catch (DAOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Content-Type=application/json", consumes = "application/json", produces = "application/json")
	public @ResponseBody void updateCompromisso(
			ModelMap modelMap,
			HttpServletResponse resp,
			HttpServletRequest request,
			@RequestBody(required = true) TipoCompromissoBean tipoCompromissoBean)
			throws RestException {
		try {
			compromissoService.updateCompromisso(tipoCompromissoBean);
		} catch (DAOException e) {
			throw new RestException(e.getMessage(), e.getCause());
		}
	}

}
