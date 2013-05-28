/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.modelo;

/**
 *
 * @author Felipe Silva
 */
public class Perfil {
    
    long codigo;
    String descricao;
    int nivel;
    String role;

    public Perfil() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
