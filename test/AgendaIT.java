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
public class AgendaIT {
    
    public AgendaIT() {
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
        System.out.println("Test Constructeur Agenda");
        Agenda a = new Agenda();
        
        assertTrue(a.getEvenements().isEmpty());
    }
    
    @Test
    public void testAjouter() throws ErreurDate, ErreurEvenement {
        System.out.println("Test méthode ajouter");
        String nom1 = "Cirque";
        Date debut1 = new Date(1, 1, 2017, 1, 1);
        Date fin1 = new Date(3, 3, 2017, 3, 3);
        Evenement e1 = new Evenement(nom1, debut1, fin1);
        String nom2 = "Concert";
        Date debut2 = new Date(2, 2, 2018, 2, 2);
        Date fin2 = new Date(1, 1, 2019, 1, 1);
        Evenement e2 = new Evenement(nom2, debut2, fin2);
        
        Agenda a = new Agenda();
        a.ajouter(e1);
        boolean expResult = true;
        boolean result = a.ajouter(e2);
        
        assertEquals(expResult, result);
    }

    @Test
    public void testSupprimer() throws ErreurDate, ErreurEvenement {
        System.out.println("Test méthode supprimer");
        String nom = "Cirque";
        Date debut = new Date(18, 4, 2018, 13, 45);
        Date fin = new Date(19, 3, 2019, 12, 39);
        Evenement e = new Evenement(nom, debut, fin);
        
        Agenda a = new Agenda();
        a.ajouter(e);
        
        assertTrue(a.supprimer("Cirque"));
    }

    @Test
    public void testChercherEvenement() throws ErreurDate, ErreurEvenement {
        System.out.println("Test méthode chercherEvenement");
        String nom = "Cirque";
        Date debut = new Date(18, 4, 2017, 13, 45);
        Date fin = new Date(19, 3, 2019, 12, 39);
        Evenement e = new Evenement(nom, debut, fin);
        Agenda a = new Agenda();
        a.ajouter(e);
        Date dateRechercher = new Date(19, 3, 2018, 12, 39);
        
        String expResult = "Cirque";
        String result = a.chercherEvenement(dateRechercher);
        assertEquals(expResult, result);
    }

    @Test
    public void testDateDebut() throws ErreurDate, ErreurEvenement, ErreurAgenda {
        System.out.println("Test méthode dateDebut");
        String nom = "Cirque";
        Date debut = new Date(18, 4, 2017, 13, 45);
        Date fin = new Date(19, 3, 2019, 12, 39);
        Evenement e = new Evenement(nom, debut, fin);
        Agenda a = new Agenda();
        a.ajouter(e);
        
        Date expResult = debut;
        Date result = a.dateDebut(nom);
        assertEquals(expResult, result);
    }
    
    @Test(expected = ErreurAgenda.class )
    public void testDateDebutAvecException() throws ErreurDate, ErreurEvenement, ErreurAgenda {
        System.out.println("Test méthode dateDebut avec exception");
        String nom = "Cirque";
        Date debut = new Date(18, 4, 2017, 13, 45);
        Date fin = new Date(19, 3, 2019, 12, 39);
        Evenement e = new Evenement(nom, debut, fin);
        Agenda a = new Agenda();
        a.ajouter(e);
        
        Date expResult = debut;
        Date result = a.dateDebut("test");
        assertEquals(expResult, result);
    }

    @Test
    public void testDateFin() throws ErreurDate, ErreurEvenement, ErreurAgenda {
        System.out.println("Test méthode dateFin");
        String nom = "Cirque";
        Date debut = new Date(18, 4, 2017, 13, 45);
        Date fin = new Date(19, 3, 2019, 12, 39);
        Evenement e = new Evenement(nom, debut, fin);
        Agenda a = new Agenda();
        a.ajouter(e);
        
        Date expResult = fin;
        Date result = a.dateFin("Cirque");
        assertEquals(expResult, result);
    }

    @Test
    public void testPrevu() throws ErreurDate, ErreurEvenement {
        System.out.println("Test méthode prevu");
        String nom = "Cirque";
        Date debut = new Date(18, 4, 2017, 13, 45);
        Date fin = new Date(19, 3, 2019, 12, 39);
        Evenement e = new Evenement(nom, debut, fin);
        Agenda a = new Agenda();
        a.ajouter(e);
        
        boolean expResult = true;
        boolean result = a.prevu(nom);
        assertEquals(expResult, result);
    }
    
}
