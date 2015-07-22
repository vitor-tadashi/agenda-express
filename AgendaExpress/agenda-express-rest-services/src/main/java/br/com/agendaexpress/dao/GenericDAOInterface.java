package br.com.agendaexpress.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.agendaexpress.exceptions.ExceptionDAO;

/**
 * Generic Repository, providing basic CRUD operations
 *
 * @param <T> the entity type
 * @param <ID> the primary key type
 */
public interface GenericDAOInterface<T, ID extends Serializable> {
    //~ Methods ----------------------------------------------------------------

    /**
     * Get the Class of the entity.
     *
     * @return the class
     */
    Class<T> getEntityClass();

    /**
     * Find an entity by its primary key
     *
     * @param id the primary key
     * @return the entity
     */
    T findById(final ID id) throws ExceptionDAO;

    /**
     * Load all entities.
     *
     * @return the list of entities
     */
    List<T> findAll() throws ExceptionDAO;
    

    /**
     * Load all entities.
     *
     * @return the list of entities
     */
    List<T> findAll(String propertyOrder, Boolean isDesc) throws ExceptionDAO;


    /**
     * Find entities based on an example.
     *
     * @param exampleInstance the example
     * @return the list of entities
     */
    List<T> findByExample(final T exampleInstance) throws ExceptionDAO;

    /**
     * Find using a named query.
     *
     * @param queryName the name of the query
     * @param params the query parameters
     *
     * @return the list of entities
     */
    List<T> findByNamedQuery(
        final String queryName,
        Object... params
    ) throws ExceptionDAO;

    /**
     * Find using a named query.
     *
     * @param queryName the name of the query
     * @param params the query parameters
     *
     * @return the list of entities
     */
    List<T> findByNamedQueryAndNamedParams(
        final String queryName,
        final Map<String, ?extends Object> params
    ) throws ExceptionDAO;

    /**
     * Count all entities.
     *
     * @return the number of entities
     */
    Long countAll() throws ExceptionDAO;

    /**
     * Count entities based on an example.
     *
     * @param exampleInstance the search criteria
     * @return the number of entities
     */
    int countByExample(final T exampleInstance) throws ExceptionDAO;

    
    /**
     * save an entity. This can be either a INSERT or UPDATE in the database.
     * 
     * @param entity the entity to save
     * 
     * @return the saved entity
     */
    T save(final T entity) throws ExceptionDAO;

    /**
     * delete an entity from the database.
     * 
     * @param entity the entity to delete
     */
    void delete(final T entity) throws ExceptionDAO;
    
    /**
     * delete an entity list from the database.
     * 
     * @param entity the entity to delete
     */
	void delete(List<T> entities) throws ExceptionDAO;
    
    /**
     * Update only
     * 
     * @param entity
     * @return
     * @throws ExceptionDAO
     */
    public T update(T entity) throws ExceptionDAO;

}