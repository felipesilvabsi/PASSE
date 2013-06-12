/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.bean;

import br.com.open.schooladmin.facade.SchoolAdminFacade;
import br.com.open.schooladmin.modelo.Cidade;
import br.com.open.schooladmin.util.ConsultarCEPWS;
import br.com.open.schooladmin.util.SchoolAdminException;
import java.io.Serializable;
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
public class CidadeMB implements Serializable{

    private SchoolAdminFacade schoolAdminFacade;
    private Cidade cidade = new Cidade();
    /**
     * Creates a new instance of CidadeMB
     */
    public CidadeMB() {
        this.schoolAdminFacade = new SchoolAdminFacade();
    }
    
    public void salvarCidade(){
        try {
            schoolAdminFacade.salvarCidade(cidade);
        } catch (SchoolAdminException ex) {
            Logger.getLogger(CidadeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirCidade(){
        try {
            schoolAdminFacade.exlcuirCidade(cidade);
        } catch (SchoolAdminException ex) {
            Logger.getLogger(CidadeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String retornarPaginaInicial(){
        cidade = new Cidade();
        
        return "/paginaInicial.xhtml?faces-redirect=true";
    }
    
    public void initCidade(){
        cidade = new Cidade();
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
