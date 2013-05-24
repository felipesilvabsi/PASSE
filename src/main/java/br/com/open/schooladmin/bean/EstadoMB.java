/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.bean;

import br.com.open.schooladmin.facade.SchoolAdminFacade;
import br.com.open.schooladmin.modelo.Estado;
import java.util.ArrayList;
import java.util.List;
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
        estados = new ArrayList<Estado>();
    }
    
    public List<Estado> getTodosEstados(){
        estados = schoolAdminFacade.recuperarTodosEstados();
        return estados;
    }
}
