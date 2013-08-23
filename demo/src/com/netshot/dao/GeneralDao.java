package com.netshot.dao;

import java.util.List;

public interface GeneralDao {

	public String save(Object object);

	public void attachDirty(Object object);

	public void delete(Object object);

	public Object merge(Object object);

	public List<Object> findByExample(Object object);

	public List<Object> findByProperty(String className, String propertyName,
			Object value);

	public List<Object> findByPropertys(String className,
			String[] propertyNames, Object[] values);

	public Object findById(String objectName, String id);

	public List<Object> findAll(String objectName);
}