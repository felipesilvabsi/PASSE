/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.bean;

import br.com.open.schooladmin.facade.SchoolAdminFacade;
import br.com.open.schooladmin.modelo.Estado;
import br.com.open.schooladmin.util.SchoolAdminException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Felipe Silva
 */
@ManagedBean
@RequestScoped
public class EstadoMB {

    SchoolAdminFacade schoolAdminFacade;
    Estado estado;
    List<Estado> estados;

    /**
     * Creates a new instance of EstadoMB
     */
    public EstadoMB() {
        schoolAdminFacade = new SchoolAdminFacade();
    }

    public void salvarEstado() {
        try {
            schoolAdminFacade.salvarEstado(estado);
            initEstado();
            initEstados();
        } catch (SchoolAdminException ex) {
            Logger.getLogger(EstadoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exlcuirEstado() {
        try {
            schoolAdminFacade.excluirEstado(estado);
            initEstado();
            initEstados();
        } catch (SchoolAdminException ex) {
            Logger.getLogger(EstadoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initEstado() {
        estado = new Estado();
    }

    public void initEstados() {
        estados = null;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        estados = schoolAdminFacade.recuperarTodosEstados();
        return estados;
    }
}
