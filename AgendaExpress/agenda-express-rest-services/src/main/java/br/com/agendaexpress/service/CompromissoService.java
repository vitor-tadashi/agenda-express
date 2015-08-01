package br.com.agendaexpress.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendaexpress.beans.TipoCompromissoBean;
import br.com.agendaexpress.dao.CompromissoDAO;
import br.com.agendaexpress.entity.TipoCompromissoEntity;
import br.com.agendaexpress.exceptions.DAOException;

@Service
@Transactional
public class CompromissoService {

	@Autowired
	CompromissoDAO compromissoDAO;
	
	private MapperFacade mapper = new DefaultMapperFactory.Builder().build().getMapperFacade();
	
	public CompromissoService() {
	}
	
	public void addCompromisso(TipoCompromissoBean tipoCompromissoBean) throws DAOException {
		TipoCompromissoEntity tipoCompromissoEntity = mapper.map(tipoCompromissoBean, TipoCompromissoEntity.class);
		compromissoDAO.save(tipoCompromissoEntity);
	}
	
	public void deleteCompromisso(Integer id) throws DAOException {
		compromissoDAO.deleteById(id);
	}
	
	public void updateCompromisso(TipoCompromissoBean tipoCompromissoBean) throws DAOException {
		TipoCompromissoEntity tipoCompromissoEntity = compromissoDAO.findById(tipoCompromissoBean.getIdTipoCompromisso());
		if (tipoCompromissoEntity != null) {
			tipoCompromissoEntity = mapper.map(tipoCompromissoBean, TipoCompromissoEntity.class);
			compromissoDAO.update(tipoCompromissoEntity);
		}
	}
	
	public TipoCompromissoBean findCompromisso(TipoCompromissoBean tipoCompromissoBean) throws DAOException {
		if (tipoCompromissoBean.getIdTipoCompromisso() != null) {
			TipoCompromissoEntity tipoCompromissoEntity = compromissoDAO.findById(tipoCompromissoBean.getIdTipoCompromisso());
			return mapper.map(tipoCompromissoEntity, TipoCompromissoBean.class);
		} else {
			TipoCompromissoEntity tipoCompromissoEntity = mapper.map(tipoCompromissoBean, TipoCompromissoEntity.class);
			return mapper.map(compromissoDAO.findCompromisso(tipoCompromissoEntity), TipoCompromissoBean.class);
		}
	}
}
