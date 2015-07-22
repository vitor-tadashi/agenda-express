package br.com.agendaexpress.commons.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

public class FilterQueryUtil<Entity> {

	private String alias;

	private List<Map<String, Object>> fieldsWithValues = new ArrayList<Map<String, Object>>();

	public FilterQueryUtil(String alias) {
		this.alias = alias;
	}

	public String buildQueryFilter(Entity entity) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("FROM ");
			sb.append(Class.forName(entity.getClass().getName()));
			sb.append(alias);
			sb.append(" WHERE 1=1");
			Field[] fields = Class.forName(entity.getClass().getName())
					.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(entity);
				if (value != null && !"serialVersionUID".equals(field.getName())) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("value", value);
					map.put("field", field.getName());
					fieldsWithValues.add(map);
					sb.append(" AND ");
					sb.append(alias);
					sb.append(".");
					sb.append(field.getName());
					sb.append("=:");
					sb.append(field.getName());
					sb.append(" ");
				}
			}
			return sb.toString();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	public TypedQuery<Entity> fillQueryParameters(TypedQuery<Entity> query) {
		for (Map<String, Object> map : fieldsWithValues) {
			query.setParameter((String) map.get("field"), map.get("value"));
		}
		return query;
	}

	public String getAlias() {
		return alias;
	}

}
