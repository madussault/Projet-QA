/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class EvenementIT {
    
    public EvenementIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructeur() throws ErreurDate, ErreurEvenement {
        System.out.println("Test Constructeur Evenement");
        String nom = "Cirque";
        Date debut = new Date(18, 4, 2018, 13, 45);
        Date fin = new Date(19, 3, 2019, 12, 39);
        Evenement e = new Evenement(nom, debut, fin);
        
        assertEquals(nom, e.getNom());
        assertEquals(debut, e.getDebut());
        assertEquals(fin, e.getFin());
    }
}
