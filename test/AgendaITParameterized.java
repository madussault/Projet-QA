import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Marc-André Dussault Gr427
 */
@RunWith(Parameterized.class)
public class AgendaITParameterized {
    
    private String nom;
    private Date debut;
    private Date fin;
    private Evenement evenement;
    Date dateRechercher;
    
    public AgendaITParameterized(String nom, Date debut, Date fin, Date dateRechercher) throws ErreurDate, ErreurEvenement {
        this.nom = nom;
        this.debut = debut;
        this.fin = fin;
        this.dateRechercher = dateRechercher;
        evenement = new Evenement(this.nom, this.debut, this.fin);
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
    
    @Parameterized.Parameters
    public static List<Object[]> ArrOfEvenements() throws ErreurDate {
    List<Object[]> list = new ArrayList<Object[]>();

        list.add(new Object[] {"Cirque", 
            new Date(18, 4, 2017, 13, 45), 
            new Date(19, 3, 2019, 12, 39),
            new Date(19, 3, 2018, 12, 39)
        });
        
        list.add(new Object[] {"Concert", 
            new Date(1, 1, 2018, 1, 1), 
            new Date(1, 1, 2019, 1, 1),
            new Date(2, 2, 2018, 2, 2)
        });

        return list;
    }

    @Test
    public void testChercherEvenementParametrized() throws ErreurDate, ErreurEvenement {
        System.out.println("Test méthode chercherEvenement parametrized");
        Agenda a = new Agenda();
        a.ajouter(evenement);
        
        String expResult = nom;
        String result = a.chercherEvenement(dateRechercher);
        assertEquals(expResult, result);
    }

    @Test
    public void testDateDebutParametrized() throws ErreurDate, ErreurEvenement, ErreurAgenda {
        System.out.println("Test méthode dateDebut parametrized");
        Agenda a = new Agenda();
        a.ajouter(evenement);
        
        Date expResult = debut;
        Date result = a.dateDebut(nom);
        assertEquals(expResult, result);
    }

    @Test
    public void testDateFinParametrized() throws ErreurDate, ErreurEvenement, ErreurAgenda {
        System.out.println("Test méthode dateFin parametrized");
        Agenda a = new Agenda();
        a.ajouter(evenement);
        
        Date expResult = fin;
        Date result = a.dateFin(nom);
        assertEquals(expResult, result);
    }
}
