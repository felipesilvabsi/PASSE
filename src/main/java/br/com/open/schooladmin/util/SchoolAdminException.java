/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.util;

/**
 *
 * @author Felipe Silva
 */
public class SchoolAdminException extends Exception{

    public SchoolAdminException() {
    }

    public SchoolAdminException(String message) {
        super(message);
    }

    public SchoolAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public SchoolAdminException(Throwable cause) {
        super(cause);
    }
}
