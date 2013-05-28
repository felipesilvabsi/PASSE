/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.dao;

import br.com.open.schooladmin.modelo.Perfil;
import br.com.open.schooladmin.persistencia.AbstractDao;
import br.com.open.schooladmin.persistencia.DaoException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Felipe Silva
 */
public class PerfilDAO extends AbstractDao<Perfil>{

    public PerfilDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(Perfil obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll(List<Perfil> objs) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Perfil obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Perfil obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Perfil> findAll() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Perfil> findByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfil findById(long id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clean() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
