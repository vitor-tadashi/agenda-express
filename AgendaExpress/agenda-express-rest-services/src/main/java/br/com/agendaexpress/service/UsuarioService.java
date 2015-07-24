package br.com.agendaexpress.service;

import java.util.ArrayList;
import java.util.List;

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

	public void delUsuario(Integer id) throws ExceptionDAO {
		usuarioDAO.deleteById(id);
	}

	public void updateUsuario(UsuarioBean usuarioBean) throws ExceptionDAO {
		UsuarioEntity usuarioEntity = usuarioDAO.findById(usuarioBean
				.getIdUsuario());
		if (usuarioEntity != null) {
			usuarioEntity = mapper.map(usuarioBean, UsuarioEntity.class);
			usuarioDAO.update(usuarioEntity);
		}
	}

	public List<UsuarioBean> findUsuarioByFilter(UsuarioBean usuarioBean)
			throws ExceptionDAO {
		if (usuarioBean.getIdUsuario() != null) {
			UsuarioEntity usuarioEntity = usuarioDAO.findById(usuarioBean
					.getIdUsuario());
			UsuarioBean bean = mapper.map(usuarioEntity, UsuarioBean.class);
			if (bean != null) {
				List<UsuarioBean> list = new ArrayList<UsuarioBean>();
				list.add(bean);
				return list;
			}
			return null;
		} else {
			UsuarioEntity usuarioEntity = mapper.map(usuarioBean,
					UsuarioEntity.class);
			List<UsuarioEntity> listUsuarios = usuarioDAO
					.findUsuario(usuarioEntity);
			return mapper.mapAsList(listUsuarios, UsuarioBean.class);
		}
	}

}
