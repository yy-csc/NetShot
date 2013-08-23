package com.netshot.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.netshot.dao.GeneralDao;

public class GeneralDaoHibernate implements GeneralDao {

	private static final Log log = LogFactory.getLog(GeneralDaoHibernate.class);
	List<Object> results;
	org.hibernate.Session session;
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	private Class<T> persistentClass;
	protected HibernateTemplate hibernateTemplate;
	protected SessionFactory sessionFactory;
	private SimpleJdbcTemplate jdbcTemplate;

	public GeneralDaoHibernate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that takes in a class to see which type of entity to persist.
	 * Use this constructor when subclassing.
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
	public GeneralDaoHibernate(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Constructor that takes in a class and sessionFactory for easy creation of
	 * DAO.
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 * @param sessionFactory
	 *            the pre-configured Hibernate SessionFactory
	 */
	public GeneralDaoHibernate(final Class<T> persistentClass,
			SessionFactory sessionFactory) {
		this.persistentClass = persistentClass;
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.setCacheQueries(true);
		this.jdbcTemplate = new SimpleJdbcTemplate(
				SessionFactoryUtils.getDataSource(sessionFactory));
	}

	public HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Autowired
	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.setCacheQueries(true);
		this.jdbcTemplate = new SimpleJdbcTemplate(
				SessionFactoryUtils.getDataSource(sessionFactory));
	}

	@Override
	public String save(Object object) {
		log.debug("invoke save() in OsmGeneralDAO");
		try {
			String objectId = getHibernateTemplate().save(object).toString();
			log.debug("save successful");
			return objectId;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			return null;
		}
	}

	@Override
	public void attachDirty(Object object) {
		log.debug("invoke attachDirty() in OsmGeneralDAO");
		try {
			getHibernateTemplate().saveOrUpdate(object);
			getHibernateTemplate().flush();
			getHibernateTemplate().evict(object);
			log.debug("attachDirty successful");
		} catch (RuntimeException re) {
			log.error("attachDirty failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Object object) {
		log.debug("invoke delete() in OsmGeneralDAO");
		try {
			getHibernateTemplate().delete(object);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Object merge(Object object) {
		log.debug("invoke merge() in  OsmGeneralDAO");
		try {
			Object object2 = getHibernateTemplate().merge(object);
			getHibernateTemplate().flush();
			getHibernateTemplate().evict(object);
			log.debug("merge successful");
			return object2;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public List<Object> findByExample(Object object) {
		log.debug("invoke findByExample() in OsmGeneralDAO");
		System.out.println("----------invoke findByExample() in OsmGeneralDAO");
		try {
			results = getHibernateTemplate().findByExample(object);
			System.out.println("in OsmGeneralDAO class:[" + results.size()
					+ "]");
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String className, String propertyName,
			Object value) {
		log.debug("invoke findByProperty() in OsmGeneralDAO with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from " + className + " as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property failed", re);
			throw re;
		}
	}

	public List findByPropertys(String className, String[] propertyNames,
			Object[] values) {
		log.debug("invoke findByPropertys() in OsmGeneralDAO with property: "
				+ propertyNames[0] + ", value: " + values[0]);
		try {
			if (propertyNames.length == 0 || values.length == 0) {
				return null;
			}

			String queryString = "from " + className + " as model where model."
					+ propertyNames[0] + "= ?";

			for (int i = 1; i < propertyNames.length; i++) {
				log.debug("property: " + propertyNames[i] + ", value: "
						+ values[i]);
				queryString += " and model." + propertyNames[i] + "= ?";
			}
			return getHibernateTemplate().find(queryString, values);
		} catch (RuntimeException re) {
			log.error("find by property failed", re);
			throw re;
		}
	}

	public List findByPropertys(String className, String[] propertyNames,
			Object[] values, String orderString, boolean isAsc) {
		log.debug("invoke findByPropertys() in OsmGeneralDAO with property: "
				+ propertyNames[0] + ", value: " + values[0]);
		try {
			if (propertyNames.length == 0 || values.length == 0) {
				return null;
			}

			String queryString = "from " + className + " as model where model."
					+ propertyNames[0] + "= ?";

			for (int i = 1; i < propertyNames.length; i++) {
				log.debug("property: " + propertyNames[i] + ", value: "
						+ values[i]);
				queryString += " and model." + propertyNames[i] + "= ?";
			}
			if (orderString != null && orderString.length() > 0) {
				queryString += " order by ";
				queryString += orderString;
				if (isAsc) {
					queryString += " ASC";
				} else {
					queryString += " DESC";
				}
			}
			return getHibernateTemplate().find(queryString, values);
		} catch (RuntimeException re) {
			log.error("find by property failed", re);
			throw re;
		}
	}

	@Override
	public Object findById(String objectName, String id) {
		log.debug("invoke findById() in OsmGeneralDAO with id: " + id);
		try {
			Object instance = getHibernateTemplate().get(objectName, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findAll(String objectName) {

		log.debug("invoke findAll() in OsmGeneralDAO");
		try {
			String queryString = "from " + objectName;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public void flush() {
		getSessionFactory().getCurrentSession().flush();
	}

}
