package br.com.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import br.com.hibernate.customs.TypeInstance;
import br.com.hibernate.dao.GenericDAO;
import br.com.hibernate.enums.OrderEnum;
import br.com.hibernate.exception.GenericDAOServiceException;

/**
 * Implement all generic methods of the GenericDAO.
 */
public abstract class HibernateDAOServiceImpl<T, PK extends Serializable> extends HibernateDaoSupport
		implements GenericDAO<T, PK> {

	/**
	 * Log4j.
	 * 
	 */
	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * Persistent.
	 */
	protected Class<T> persistentClass;

	/**
	 * @return current hibernate session
	 */
	protected Session getCurrentSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	/**
	 * @param sql
	 * @param clazz
	 * @return
	 */
	protected SQLQuery createSQLQuery(final String sql, final Class<?> clazz) {
		SQLQuery query = getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(clazz));
		return scalar(sql, query, clazz);
	}

	/**
	 * @param sql
	 * @param query
	 * @param clazz
	 * @return
	 */
	private SQLQuery scalar(final String sql, final SQLQuery query, Class<?> clazz) {

		final String queryAux = sql.substring(BigDecimal.ZERO.intValue(), sql.toLowerCase().indexOf("from"));
		ReflectionUtils.doWithFields(clazz, new FieldCallback() {
			public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
				if (!Modifier.isStatic(field.getModifiers())) {
					if (queryContaisAttribute(queryAux, field.getName())) {
						query.addScalar(field.getName(), TypeInstance.type(field.getType()));
					}
				}
			}
		});

		return query;
	}

	/**
	 * 
	 * 
	 */
	private Boolean queryContaisAttribute(final String query, final String attributeName) {
		final Pattern pattern = Pattern.compile("(.*)( |\")" + attributeName + "( |,|\")(.*)");
		if (pattern.matcher(query).matches()) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.company.genericDAO.model.GenericDAO#store(java.lang.Object)
	 */
	@Transactional
	public void create(T entity) throws GenericDAOServiceException {

		logger.debug("Saving data based on BEAN " + persistentClass + ".");

		if (entity == null) {
			throw new GenericDAOServiceException("Entity is empty.");
		}

		try {
			getHibernateTemplate().save(entity);
			getHibernateTemplate().flush();
			getHibernateTemplate().clear();
		} catch (Exception e) {
			throw new GenericDAOServiceException("Error - Persist entity.", e);
		}

		logger.debug("Data were saved.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#create(java.util.List)
	 */
	@Transactional
	public void create(List<T> entityList) throws GenericDAOServiceException {
		logger.debug("Saving data based on BEAN " + persistentClass + ".");

		if (entityList == null) {
			throw new GenericDAOServiceException("Entity is null.");
		}

		try {
			for (T entity : entityList)
				getHibernateTemplate().save(entity);

			getHibernateTemplate().flush();
			getHibernateTemplate().clear();

		} catch (Exception e) {
			throw new GenericDAOServiceException("Error - Persist entity.", e);
		}

		logger.debug("Data were saved.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.company.genericDAO.model.GenericDAO#update(java.lang.Object)
	 */
	@Transactional
	public void update(T entity) throws GenericDAOServiceException {

		if (entity == null) {
			throw new GenericDAOServiceException("Entity is empty.");
		}

		try {
			getHibernateTemplate().merge(entity);
			getHibernateTemplate().flush();
			getHibernateTemplate().clear();

		} catch (Exception e) {
			throw new GenericDAOServiceException("Error - Persist entity.", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.company.genericDAO.model.GenericDAO#update(java.lang.Object)
	 */
	@Transactional
	public void update(List<T> entityList) throws GenericDAOServiceException {
		if (entityList == null) {
			throw new GenericDAOServiceException("Entity is null.");
		}

		try {
			for (T entity : entityList)
				getHibernateTemplate().merge(entity);

			getHibernateTemplate().flush();
			getHibernateTemplate().clear();

		} catch (Exception e) {
			throw new GenericDAOServiceException("Error - Persist entity.", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.company.genericDAO.model.GenericDAO#remove(java.lang.Object)
	 */
	@Transactional
	public void remove(T entity) throws GenericDAOServiceException {

		if (entity == null) {
			throw new GenericDAOServiceException("Entity is empty.");
		}

		try {
			getHibernateTemplate().delete(entity);
			getHibernateTemplate().flush();
		} catch (Exception e) {
			throw new GenericDAOServiceException("Error trying to remove entity.", e);
		}

	}

	@Transactional
	public void remove(List<T> entityList) throws GenericDAOServiceException {
		logger.debug("Saving data based on BEAN " + persistentClass + ".");

		if (entityList == null) {
			throw new GenericDAOServiceException("Entity is null.");
		}

		try {
			for (T entity : entityList)
				getHibernateTemplate().delete(entity);

			getHibernateTemplate().flush();
			getHibernateTemplate().clear();

		} catch (Exception e) {
			throw new GenericDAOServiceException("Error - Persist entity.", e);
		}

		logger.debug("Data were deleted.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.company.genericDAO.model.GenericDAO#findById(java.io.Serializable)
	 */
	@Transactional(readOnly = true)
	public T findById(PK id) {
		logger.debug("Find " + persistentClass + "by id.");
		return (T) getHibernateTemplate().get(persistentClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.company.genericDAO.model.GenericDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll() {
		logger.debug("Find All" + persistentClass);
		return (List<T>) (getHibernateTemplate().find("from " + persistentClass.getName() + " x"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.company.genericDAO.model.GenericDAO#findAllAsc(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAllAsc(String propertyName) {

		logger.debug("Find All " + persistentClass + " order by ASC.");

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.addOrder(Order.asc(propertyName));
		return (List<T>) (getHibernateTemplate().findByCriteria(criteria));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.company.genericDAO.model.GenericDAO#findAllDesc(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAllDesc(String propertyName) {

		logger.debug("Find All " + persistentClass + " order by DESC.");

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.addOrder(Order.desc(propertyName));
		return (List<T>) (getHibernateTemplate().findByCriteria(criteria));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * boolean)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, boolean valueParam) {

		logger.debug("Find (boolean) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, Integer valueParam) {
		logger.debug("Find (Integer) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * java.lang.Integer, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, Integer valueParam, String order) {
		logger.debug("Find (Integer) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		criteria.addOrder(Order.desc(order));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * java.math.BigDecimal)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, BigDecimal valueParam) {
		logger.debug("Find (BigDecimal) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.finchsolucoes.dao.GenericDAO#findByNamedParamOrderByDesc(java.lang
	 * .String, java.lang.Integer, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParamOrderByDesc(String namedParam, Integer valueParam, String namedParamOrderBy) {
		logger.debug("Find (Integer) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		criteria.addOrder(Order.desc(namedParamOrderBy));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, Long valueParam) {
		logger.debug("Find (Integer) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, String valueParam) {
		logger.debug("Find (String) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * boolean, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, boolean valueParam, String propertyName) {

		logger.debug("Find (boolean) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		criteria.addOrder(Order.asc(propertyName));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * java.lang.Enum)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, @SuppressWarnings("rawtypes") Enum valueParam) {
		logger.debug("Find (Enum) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParam(java.lang.String,
	 * java.lang.Enum, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParam(String namedParam, @SuppressWarnings("rawtypes") Enum valueParam, String order) {
		logger.debug("Find (Enum) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		criteria.addOrder(Order.asc(order));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByParam(java.lang.String,
	 * java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T findByParam(final String namedParam, final Object valueParam) {

		logger.debug("Find (boolean) " + persistentClass.getName() + " by named param " + namedParam);

		Criteria criteria = getCurrentSession().createCriteria(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		return (T) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.finchsolucoes.dao.GenericDAO#findByNamedParamASC(java.lang.String,
	 * java.lang.Integer, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByNamedParamASC(String namedParam, Integer valueParam, String propertyName) {

		logger.debug("Find " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		criteria.addOrder(Order.asc(propertyName));
		return ((List<T>) getHibernateTemplate().findByCriteria(criteria));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.finchsolucoes.dao.GenericDAO#findByNamedParamOrderBy(java.lang.
	 * String, java.lang.Object, br.com.finchsolucoes.enums.OrderEnum,
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findByNamedParamOrderBy(String namedParam, Object valueParam, OrderEnum order, String columnOrder) {
		logger.debug("Find (Object) " + persistentClass.getName() + " by named param " + namedParam);

		DetachedCriteria criteria = DetachedCriteria.forClass(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));
		if (OrderEnum.ASC.equals(order))
			criteria.addOrder(Order.asc(columnOrder));
		else
			criteria.addOrder(Order.desc(columnOrder));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

}
