package br.com.agendaexpress.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.agendaexpress.exceptions.DAOException;



/**
 * JPA implementation of the GenericRepository. Note that this implementation also expects Hibernate as JPA
 * implementation. That's because we like the Criteria API.
 * 
 * @param <T>
 *            The persistent type
 * @param <ID>
 *            The primary key type
 */
public abstract class GenericDAO<T, ID extends Serializable> implements GenericDAOInterface<T, ID> {

    // ~ Instance fields
    // --------------------------------------------------------
    private final Class<T> persistentClass;

    @PersistenceContext
    protected EntityManager em;

    // ~ Constructors
    // -----------------------------------------------------------

    @SuppressWarnings("unchecked")
    public GenericDAO() {

        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public GenericDAO(final Class<T> persistentClass) {
        super();
        this.persistentClass = persistentClass;
    }

    // ~ Methods
    // ----------------------------------------------------------------

    @Override
    public Class<T> getEntityClass() {
        return persistentClass;
    }

    @Override
    public Long countAll() throws DAOException {
    	Long ret;
        try {
            ret = countByCriteria();
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ret;
    }

    @Override
    public int countByExample(final T exampleInstance) throws DAOException {
        Criteria crit = null;
        try {
            Session session = (Session) em.getDelegate();
            crit = session.createCriteria(getEntityClass());
            crit.setProjection(Projections.rowCount());
            crit.add(Example.create(exampleInstance));
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return (Integer) crit.list().get(0);
    }

    @Override
    public List<T> findAll() throws DAOException {
        List<T> ret = null;
        try {
            ret = findByCriteria();
        } catch (Exception e) {
            throw new DAOException(e);
        }

        return ret;
    }
    
    public List<T> findAllOrdened( String orderColumn , boolean isDesc ) throws DAOException {
        List<T> ret = null;
        try {
            ret = findByCriteriaOrdened( orderColumn, isDesc );
            
        } catch (Exception e) {
            throw new DAOException(e);
        }
        
        return ret;
    }

    @Override
    public List<T> findAll(String propertyOrder, Boolean isDesc) throws DAOException {
        List<T> ret = null;
        try {
            ret = findByCriteria(propertyOrder, isDesc);
        } catch (Exception e) {
            throw new DAOException(e);
        }

        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByExample(final T exampleInstance) throws DAOException {
        List<T> result = null;
        try {
            Session session = (Session) em.getDelegate();
            Criteria crit = session.createCriteria(getEntityClass());
            crit.add(Example.create(exampleInstance));
            result = crit.list();
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return result;
    }

    @Override
    public T findById(final ID id) throws DAOException {
        T result = null;
        try {
            result = em.find(persistentClass, id);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByNamedQuery(final String name, Object... params) throws DAOException {
        List<T> result = null;

        try {
            javax.persistence.Query query = em.createNamedQuery(name);

            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByNamedQueryAndNamedParams(final String name, final Map<String, ? extends Object> params)
            throws DAOException {
        List<T> result = null;
        try {
            javax.persistence.Query query = em.createNamedQuery(name);

            for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
                query.setParameter(param.getKey(), param.getValue());
            }
            result = (List<T>) query.getResultList();
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return result;
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    protected List<T> findByCriteria(final Criterion... criterion) throws DAOException {
        List<T> ret = null;
        try {
            ret = findByCriteria(null, null, -1, -1, criterion);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ret;
    }
    
    /**
     * Use this inside subclasses as a convenience method.
     */
    protected List<T> findByCriteriaOrdened(String orderColumn , boolean isDesc, final Criterion... criterion) throws DAOException {
        List<T> ret = null;
        try {
            ret = findByCriteria(orderColumn, isDesc, -1, -1, criterion);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ret;
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    protected List<T> findByCriteria(String propertyOrder, Boolean isDesc, final Criterion... criterion) throws DAOException {
        List<T> ret = null;
        try {
            ret = findByCriteria(propertyOrder, isDesc, -1, -1, criterion);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ret;
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(String propertyOrder, Boolean isDesc, final int firstResult, final int maxResults,
            final Criterion... criterion) throws DAOException {
        List<T> result = null;

        try {
            Session session = (Session) em.getDelegate();
            Criteria crit = session.createCriteria(getEntityClass());

            for (final Criterion c : criterion) {
                crit.add(c);
            }

            if (firstResult > 0) {
                crit.setFirstResult(firstResult);
            }

            if (maxResults > 0) {
                crit.setMaxResults(maxResults);
            }

            if (propertyOrder != null && !propertyOrder.isEmpty()) {
                if (isDesc) {
                    crit.addOrder(Order.desc(propertyOrder));
                } else {
                    crit.addOrder(Order.asc(propertyOrder));
                }
            }

            result = crit.list();
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return result;
    }

    protected Long countByCriteria(Criterion... criterion) throws DAOException {

        Long ret = null;
        try {
            Session session = (Session) em.getDelegate();
            Criteria crit = session.createCriteria(getEntityClass());
            crit.setProjection(Projections.rowCount());

            for (final Criterion c : criterion) {
                crit.add(c);
            }
            ret = (Long) crit.list().get(0);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return ret;
    }

    @Override
    public void delete(T entity) throws DAOException {
        try {
            em.remove(entity);
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }
    
    @Override
    public void delete(List<T> entities) throws DAOException {
        try {
        	for(T t : entities){
        		em.remove(t);
        	}
        } catch (Exception e) {
            throw new DAOException(e);
        }
    }

    @Override
    public T save(T entity) throws DAOException {
        try {
            em.persist(entity);
        } catch (Exception e) {
            throw new DAOException(e);
        }
        return entity;
    }

    @Override
    public T update(T entity) throws DAOException {
        try {
            em.merge(entity);
        } catch (Exception e) {
        	System.out.println("GenericDAO.update(): " + e);
            throw new DAOException(e);
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteriaName(String criteriaName, long indivUniqId) throws DAOException {

        Session session = (Session) em.getDelegate();
        List<T> entityList = session.createCriteria(getEntityClass()).add(Restrictions.eq(criteriaName, indivUniqId)).list();

        return entityList;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByCriteriaNameList(ArrayList<String> criteriaName, ArrayList<Object> values) throws DAOException {
        
        List<T> entityList = null;
        
        if ( criteriaName != null && values != null && criteriaName.size() == values.size() ){
        
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(getEntityClass());
    
            for (int i = 0; i < values.size(); i++) {
                criteria.add( Restrictions.eq( criteriaName.get( i ), values.get( i ) ) );
            }
            
            entityList = criteria.list();
            
        }            
        return entityList;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByIdParameter(long id, String collum) throws DAOException {

        Session session = (Session) em.getDelegate();
        List<T> entityList = session.createCriteria(getEntityClass()).add(Restrictions.eq("id." + collum, id)).list();

        return entityList;
    }

    public void deleteByCriteriaName(String criteriaName, long indivUniqId) throws DAOException {
        List<T> entityList = findByCriteriaName(criteriaName, indivUniqId);
        if (entityList != null) {
            for (T entity : entityList) {
                delete(entity);
            }
        }
    }

    public void deleteById(final ID id) throws DAOException {
        T entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }
    
    public Long generateSequenceID(String table, String column) {
        
        String query = "SELECT nvl(max(tb." + column + ")+1, 1) FROM " + table + " tb";            
        Query q = em.createNativeQuery(query);
        BigDecimal retorno  = (BigDecimal) q.getSingleResult();
        Long sequenceId = retorno.longValue();
        return sequenceId;
    }
	
	
    public void deleteByIndivUniqIdCriteria(long indivUniqId) throws DAOException {
        List<T> entityList = findByIndivUniqIdCriteria(indivUniqId);
        if (entityList != null) {
            for (T entity : entityList) {
                delete(entity);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByIndivUniqIdCriteria(long indivUniqId) throws DAOException {

        Session session = (Session) em.getDelegate();
        List<T> entityList = session.createCriteria(getEntityClass()).add(Restrictions.eq("id.indivUniqId", indivUniqId)).list();

        return entityList;
    }

    public void detach(Object entity) {
        Session session = (Session) em.getDelegate();
        session.evict(entity);
    }
    
	
}
