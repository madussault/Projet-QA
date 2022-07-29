/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDateTime;
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
public class DateIT {
    
    public DateIT() {
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
    public void testConstructeur() throws ErreurDate {
        System.out.println("Test Constructeur Date");
        int annee = 2019;
        int mois = 4;
        int jour = 22;
        int heure = 22;
        int minute = 57;
        Date d = new Date(jour, mois, annee, heure, minute);
        
        assertEquals(annee, d.getAnnee());
        assertEquals(mois, d.getMois());
        assertEquals(jour, d.getJour());
        assertEquals(heure, d.getHeure());
        assertEquals(minute, d.getMinute());
    }
}
