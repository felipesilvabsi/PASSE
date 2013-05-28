/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.schooladmin.dao;

import br.com.open.schooladmin.modelo.Cidade;
import java.util.HashMap;
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
public class CidadeDAOTest {
    
    Cidade cidade;
    CidadeDAO instance;
    
    public CidadeDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cidade = new Cidade();
        cidade.setNome("Teste");
        cidade.getEstado().setSigla("RN");
        instance = new CidadeDAO(true);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class CidadeDAO.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        assertEquals("Cadastrado com sucesso", 0, instance.save(cidade));
    }

    /**
     * Test of saveAll method, of class CidadeDAO.
     */
    @Test
    public void testSaveAll() throws Exception {
        System.out.println("saveAll - no implements");
    }

    /**
     * Test of update method, of class CidadeDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        cidade.setNome("Teste Update");
        instance.update(cidade);
    }

    /**
     * Test of delete method, of class CidadeDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        instance.delete(cidade);
    }

    /**
     * Test of deleteByParams method, of class CidadeDAO.
     */
    @Test
    public void testDeleteByParams() throws Exception {
        System.out.println("deleteByParams - no implements");
    }

    /**
     * Test of findAll method, of class CidadeDAO.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        List expResult = null;
        List result = instance.findAll();
    }

    /**
     * Test of findByParams method, of class CidadeDAO.
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
     * Test of findById method, of class CidadeDAO.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        long id = 0;
        Cidade expResult = null;
        Cidade result = instance.findById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of clean method, of class CidadeDAO.
     */
    @Test
    public void testClean() throws Exception {
        System.out.println("clean - no implements");
    }

    /**
     * Test of getCount method, of class CidadeDAO.
     */
    @Test
    public void testGetCount() throws Exception {
        System.out.println("getCount");
        assertTrue(instance.getCount() > 0);
    }
}