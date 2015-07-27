package br.com.agendaexpress.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.agendaexpress.commons.util.FilterQueryUtil;
import br.com.agendaexpress.entity.UsuarioEntity;

@Repository
public class UsuarioDAO extends GenericDAO<UsuarioEntity, Integer> {

	public List<UsuarioEntity> findUsuario(UsuarioEntity usuarioEntity) {

		FilterQueryUtil<UsuarioEntity> filterUtil = new FilterQueryUtil<UsuarioEntity>("u");
		String queryStr = filterUtil.buildQueryFilter(usuarioEntity);
		TypedQuery<UsuarioEntity> query = em.createQuery(queryStr,
				UsuarioEntity.class);
		query = filterUtil.fillQueryParameters(query);
		List<UsuarioEntity> result = query.getResultList();
		if(result != null && result.isEmpty()){
			return null;
		}
		return result;
	}
}
