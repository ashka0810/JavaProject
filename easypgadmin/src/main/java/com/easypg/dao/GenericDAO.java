package com.easypg.dao;

import java.util.List;

import org.hibernate.Criteria;

public interface GenericDAO<T> {

	public List<T> getAll(Class<T> T);
	public T getById(Class<T> T, long id);
	public List<T> getByFieldName(Class<T> T, String fieldName, Object value);
	public T saveUpdateObject(T objectToSave);
	public T saveObject(T objectToSave);
	public Boolean deleteObject(T objectToDelete);
	public T updateObject(T objectToUpdate);
	public List<?> getByQuery(final String query);
	public List<?> getByCriteria(Criteria criteria);
	public List<T> saveAllObjects(List<T> objects);
	public List<T> updateAllObjects(List<T> objects);
	public int deleteByQuery(String query);
	public int updateByQuery(String query);

}
