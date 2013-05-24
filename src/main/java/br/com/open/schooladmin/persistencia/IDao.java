/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.persistencia;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Felipe Silva
 */
public interface IDao<T> {
    
    long save(T obj) throws DaoException;
	
    void saveAll(List<T> objs) throws DaoException;
	
    void update(T obj) throws DaoException;

    void delete(T obj) throws DaoException;
	
    void deleteByParams(HashMap<String, Object> params) throws DaoException;

    List<T> findAll() throws DaoException;

    List<T> findByParams(HashMap<String,Object> params) throws DaoException;

    T findById(long id) throws DaoException;
	
    void clean() throws DaoException;
    
    int getCount() throws DaoException;
}
