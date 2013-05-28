/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.facade;

import br.com.open.schooladmin.dao.CidadeDAO;
import br.com.open.schooladmin.dao.EstadoDAO;
import br.com.open.schooladmin.modelo.Cidade;
import br.com.open.schooladmin.modelo.Estado;
import br.com.open.schooladmin.persistencia.DaoException;
import br.com.open.schooladmin.util.SchoolAdminException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe Silva
 */
public class SchoolAdminFacade {
    private CidadeDAO cidadeDAO;
    private EstadoDAO estadoDAO;

    public SchoolAdminFacade() {
        this.cidadeDAO = new CidadeDAO(true);
        this.estadoDAO = new EstadoDAO(true);
    }
    
    public void salvarCidade(Cidade cidade) throws SchoolAdminException{
        try {
            if (cidade.getCodigo() != 0) {
                cidadeDAO.update(cidade);
            } else {
                cidadeDAO.save(cidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SchoolAdminException(e.getMessage());
        }
    }
    
    public void exlcuirCidade(Cidade cidade) throws SchoolAdminException{
        try {
            cidadeDAO.delete(cidade);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SchoolAdminException(e.getMessage());
        }
    }
    
    public List<Cidade> recuperarTodasCidades(){
        try {
            return cidadeDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SchoolAdminFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Estado> recuperarTodosEstados(){
        try {
            return estadoDAO.findAll();
        } catch (DaoException ex) {
            Logger.getLogger(SchoolAdminFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
