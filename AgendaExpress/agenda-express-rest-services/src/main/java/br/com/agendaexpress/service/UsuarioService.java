package br.com.agendaexpress.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendaexpress.beans.UsuarioBean;
import br.com.agendaexpress.dao.UsuarioDAO;
import br.com.agendaexpress.entity.UsuarioEntity;
import br.com.agendaexpress.exceptions.ExceptionDAO;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	private MapperFacade mapper = new DefaultMapperFactory.Builder().build()
			.getMapperFacade();

	public UsuarioService() {
	}

	public void addUsuario(UsuarioBean usuarioBean) throws ExceptionDAO {
		UsuarioEntity usuarioEntity = mapper.map(usuarioBean,
				UsuarioEntity.class);
		usuarioDAO.save(usuarioEntity);
	}
}
