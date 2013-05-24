/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.persistencia;

/**
 *
 * @author Felipe Silva
 */
public class DaoException extends Exception {

    private static final long serialVersionUID = 1L;

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
