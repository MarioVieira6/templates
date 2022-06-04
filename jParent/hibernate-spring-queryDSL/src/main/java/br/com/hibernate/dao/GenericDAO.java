package br.com.hibernate.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.hibernate.enums.OrderEnum;
import br.com.hibernate.exception.GenericDAOServiceException;

/**
 * Some functionalities of generic use for persistence.
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDAO<T, PK extends Serializable> {

	/**
	 * @throws GenericDAOServiceException.
	 */
	void create(T object) throws GenericDAOServiceException;

	/**
	 * @throws GenericDAOServiceException.
	 */
	void create(List<T> object) throws GenericDAOServiceException;

	/**
	 * @throws GenericDAOServiceException.
	 */
	void update(T object) throws GenericDAOServiceException;

	/**
	 * @throws GenericDAOServiceException.
	 */
	void update(List<T> object) throws GenericDAOServiceException;

	/**
	 * @throws GenericDAOServiceException.
	 */
	void remove(T object) throws GenericDAOServiceException;

	/**
	 * @param object
	 * @throws GenericDAOServiceException
	 */
	void remove(List<T> object) throws GenericDAOServiceException;

	/**
	 * @param id
	 *            id.
	 */
	T findById(final PK id);

	/**
	 * @return all.
	 */
	List<T> findAll();

	/**
	 * @param propertyName
	 *            propertyName.
	 */
	List<T> findAllAsc(String propertyName);

	/**
	 * @param propertyName
	 *            propertyName.
	 */
	List<T> findAllDesc(String propertyName);

	/**
	 * @param namedParam
	 *            namedParam.
	 * @param valueParam
	 *            valueParam.
	 */
	List<T> findByNamedParam(final String namedParam, final boolean valueParam);

	/**
	 * @param namedParam
	 *            namedParam.
	 * @param valueParam
	 *            valueParam.
	 */
	List<T> findByNamedParam(final String namedParam, final Integer valueParam);

	/**
	 * @param namedParam
	 * @param valueParam
	 * @return
	 */
	List<T> findByNamedParam(final String namedParam, final BigDecimal valueParam);

	/**
	 * @param namedParam
	 *            namedParam.
	 * @param valueParam
	 *            valueParam.
	 */
	List<T> findByNamedParamOrderByDesc(String namedParam, Integer valueParam, String namedParamOrderBy);

	/**
	 * @param namedParam
	 *            namedParam.
	 * @param valueParam
	 *            valueParam.
	 */
	List<T> findByNamedParam(final String namedParam, final Long valueParam);

	/**
	 * @param namedParam
	 *            namedParam.
	 * @param valueParam
	 *            valueParam.
	 */
	List<T> findByNamedParam(final String namedParam, final String valueParam);

	/**
	 * @param namedParam
	 *            namedParam.
	 * @param valueParam
	 *            valueParam.
	 */
	List<T> findByNamedParam(final String namedParam, final boolean valueParam, final String orderParam);

	/**
	 * @param namedParam
	 *            namedParam.
	 * @param valueParam
	 *            valueParam.
	 */
	List<T> findByNamedParam(final String namedParam, @SuppressWarnings("rawtypes") final Enum valueParam);

	/**
	 * 
	 * @param namedParam
	 * @param valueParam
	 * @param orderParam
	 * @return
	 */
	List<T> findByNamedParam(final String namedParam, @SuppressWarnings("rawtypes") final Enum valueParam,
			final String orderParam);

	/**
	 * @param namedParam
	 * @param valueParam
	 * @param order
	 * @return
	 */
	List<T> findByNamedParam(String namedParam, Integer valueParam, String order);

	/**
	 * @param namedParam
	 * @param valueParam
	 * @return
	 */
	T findByParam(String namedParam, Object valueParam);

	/**
	 * @param namedParam
	 * @param valueParam
	 * @param propertyName
	 * @return
	 */
	List<T> findByNamedParamASC(String namedParam, Integer valueParam, String propertyName);

	/**
	 * @param namedParam
	 * @param valueParam
	 * @param order
	 * @param columnOrder
	 * @return
	 */
	List<T> findByNamedParamOrderBy(String namedParam, Object valueParam, OrderEnum order, String columnOrder);

}
