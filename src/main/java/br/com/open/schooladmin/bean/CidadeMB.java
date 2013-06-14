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
public class CidadeMB implements Serializable{

    private SchoolAdminFacade schoolAdminFacade;
    private Cidade cidade = new Cidade();
    private List<Cidade> listaCidades;
    /**
     * Creates a new instance of CidadeMB
     */
    public CidadeMB() {
        this.schoolAdminFacade = new SchoolAdminFacade();
    }
    
    public void salvarCidade(){
        try {
            schoolAdminFacade.salvarCidade(cidade);
            initCidade();
            initListaCidades();
        } catch (SchoolAdminException ex) {
            Logger.getLogger(CidadeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluirCidade(){
        try {
            schoolAdminFacade.exlcuirCidade(cidade);
            initCidade();
            initListaCidades();
        } catch (SchoolAdminException ex) {
            Logger.getLogger(CidadeMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cidade> recuperarTodasCidades(){
        if (listaCidades == null){
            listaCidades = schoolAdminFacade.recuperarTodasCidades();
        }
        return listaCidades;
    }
    
    public String retornarPaginaInicial(){
        cidade = new Cidade();
        
        return "/paginaInicial.xhtml?faces-redirect=true";
    }
    
    public void initCidade(){
        cidade = new Cidade();
    }
    
    public void initListaCidades(){
        listaCidades = null;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
