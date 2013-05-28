/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.dao;

import br.com.open.schooladmin.modelo.Estado;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe Silva
 */
public class EstadoDAOTest {

    EstadoDAO instance;
    Estado estado;

    public EstadoDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new EstadoDAO(true);
        estado = new Estado();
        estado.setSigla("TS");
        estado.setNome("Teste");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class EstadoDAO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        long expResult = 0;
        long result = instance.save(estado);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveAll method, of class EstadoDAO.
     */
    @Test
    public void testSaveAll() throws Exception {
        System.out.println("saveAll - no implaments");
    }

    /**
     * Test of update method, of class EstadoDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        estado.setNome("Teste Update");
        instance.update(estado);
    }

    /**
     * Test of delete method, of class EstadoDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        instance.delete(estado);
    }

    /**
     * Test of deleteByParams method, of class EstadoDAO.
     */
    @Test
    public void testDeleteByParams() throws Exception {
        System.out.println("deleteByParams - no implaments");
    }

    /**
     * Test of findAll method, of class EstadoDAO.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        List result = instance.findAll();
        assertNotNull("Arquivo diferente de nullo" + result.size(), result);
    }

    /**
     * Test of findByParams method, of class EstadoDAO.
     */
    @Test
    public void testFindByParams() throws Exception {
        /*System.out.println("findByParams");
        HashMap<String, Object> params = null;
        List expResult = null;
        List result = instance.findByParams(params);
        assertEquals(expResult, result);*/
    }

    /**
     * Test of findById method, of class EstadoDAO.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById - no implaments");
    }
    
    /**
     * Test of findById method, of class EstadoDAO.
     */
    @Test
    public void testFindBySigla() throws Exception {
        System.out.println("findBySigla");
        String sigla = "RN";
        Estado expResult = null;
        Estado result = instance.findBySigla(sigla);
        assertNotNull("Sucesso - " + result.getSigla() + " - " + result.getNome(),result);
    }

    /**
     * Test of clean method, of class EstadoDAO.
     */
    @Test
    public void testClean() throws Exception {
        System.out.println("clean - no implaments");
    }

    /**
     * Test of getCount method, of class EstadoDAO.
     */
    @Test
    public void testGetCount() throws Exception {
        System.out.println("getCount");
        assertTrue(instance.getCount() > 0);
    }
}