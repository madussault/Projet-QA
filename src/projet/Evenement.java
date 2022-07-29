/**
 *
 * @author Marc-André Dussault
 */

import java.time.LocalDateTime;
import java.util.Objects;

public class Evenement {
    
    private String nom; 
    private Date debut; 
    private Date fin;
    
    public Evenement(String nom, Date debut, Date fin)throws ErreurEvenement{
        setNom(nom);
        setDebut(debut, fin);
        setFin(debut, fin);
    }

    public String getNom() {
        return nom;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }
    
    public void setNom(String nom) throws ErreurEvenement {
        if (nom.isEmpty())
            throw new ErreurEvenement();
        this.nom = nom;
    }

    public void setDebut(Date debut, Date fin) throws ErreurEvenement {
        if (debut == null)
            throw new ErreurEvenement();
        
        LocalDateTime localDateTimeDebut = debut.getLocaleDateTimeObj();
        LocalDateTime localDateTimeFin = fin.getLocaleDateTimeObj();
        if (localDateTimeDebut.isAfter(localDateTimeFin))
            throw new ErreurEvenement();
        
        this.debut = debut;
    }

    public void setFin(Date debut, Date fin) throws ErreurEvenement {
        if (fin == null)
            throw new ErreurEvenement();
        
        LocalDateTime localDateTimeDebut = debut.getLocaleDateTimeObj();
        LocalDateTime localDateTimeFin = fin.getLocaleDateTimeObj();
        if (localDateTimeDebut.isAfter(localDateTimeFin))
            throw new ErreurEvenement();
        
        this.fin = fin;
    }
    
    public LocalDateTime getLocaleDateTimeDebutObj(){
        return debut.getLocaleDateTimeObj();
    }
    
    public LocalDateTime getLocaleDateTimeFinObj(){
        return fin.getLocaleDateTimeObj();
    }
}
