package br.com.agendaexpress.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.agendaexpress.commons.util.FilterQueryUtil;
import br.com.agendaexpress.entity.AvaliacaoEntity;

public class AvaliacaoDAO extends GenericDAO<AvaliacaoEntity, Integer>{
	
	public List<AvaliacaoEntity> findAvaliacao(AvaliacaoEntity avaliacaoEntity) {
		FilterQueryUtil<AvaliacaoEntity> filterUtil = new FilterQueryUtil<AvaliacaoEntity>("u");
		String queryStr = filterUtil.buildQueryFilter(avaliacaoEntity);
		TypedQuery<AvaliacaoEntity> query = em.createQuery(queryStr,
				AvaliacaoEntity.class);
		query = filterUtil.fillQueryParameters(query);

		return query.getResultList();
	}
}
