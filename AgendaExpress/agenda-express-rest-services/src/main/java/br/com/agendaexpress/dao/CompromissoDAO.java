package br.com.agendaexpress.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.agendaexpress.commons.util.FilterQueryUtil;
import br.com.agendaexpress.entity.TipoCompromissoEntity;
@Repository
public class CompromissoDAO extends GenericDAO<TipoCompromissoEntity, Integer>{
	
	public List<TipoCompromissoEntity> findCompromisso(TipoCompromissoEntity tipoCompromissoEntity) {
		FilterQueryUtil<TipoCompromissoEntity> filterUtil = new FilterQueryUtil<TipoCompromissoEntity>("u");
		String queryStr = filterUtil.buildQueryFilter(tipoCompromissoEntity);
		TypedQuery<TipoCompromissoEntity> query = em.createQuery(queryStr,
				TipoCompromissoEntity.class);
		query = filterUtil.fillQueryParameters(query);

		return query.getResultList();
	}
}
