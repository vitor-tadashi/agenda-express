package br.com.agendaexpress.service;

import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendaexpress.beans.AvaliacaoBean;
import br.com.agendaexpress.dao.AvaliacaoDAO;
import br.com.agendaexpress.entity.AvaliacaoEntity;
import br.com.agendaexpress.exceptions.DAOException;

@Service
@Transactional
public class AvaliacaoService {

	@Autowired
	AvaliacaoDAO avaliacaoDAO;
	
	private MapperFacade mapper = new DefaultMapperFactory.Builder().build().getMapperFacade();
	
	public AvaliacaoService() {
	}
	
	public void addAvaliacao(AvaliacaoBean avaliacaoBean) throws DAOException {
		AvaliacaoEntity avaliacaoEntity = mapper.map(avaliacaoBean, AvaliacaoEntity.class);
		avaliacaoDAO.save(avaliacaoEntity);
	}
	
	public void updateAvaliacao(AvaliacaoBean avaliacaoBean) throws DAOException {
		AvaliacaoEntity avaliacaoEntity = mapper.map(avaliacaoBean, AvaliacaoEntity.class);
		avaliacaoDAO.update(avaliacaoEntity);
	}
	
	public void deleteAvaliacao(int id) throws DAOException {
		avaliacaoDAO.deleteById(id);
	}
	
	public List<AvaliacaoBean> findAvaliacao(AvaliacaoBean avaliacaoBean) throws DAOException {
		AvaliacaoEntity avaliacaoEntity = mapper.map(avaliacaoBean, AvaliacaoEntity.class);
		
		return mapper.mapAsList(avaliacaoDAO.findAvaliacao(avaliacaoEntity), AvaliacaoBean.class);
	}
}
