
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Marc-André Dussault Gr427
 */
public class Agenda {
    
    private ArrayList<Evenement> evenements;
    
    public Agenda(){
        evenements = new ArrayList<Evenement>();
    }

    public ArrayList<Evenement> getEvenements() {
        return evenements;
    }
    
    public boolean ajouter(Evenement e){
        // Vérifie qu'aucun évenement avec le même nom existe déjà
        if (prevu(e.getNom()))
            return false;
        
        // Vérifie que l'évenement ne chevauche pas un évenement existant - validateur 1:
        // On s'assure que la dates de début OU de fin de l'évennement ne soient pas incluse dans un autre évenement
        if (!chercherEvenement(e.getDebut()).equals("") || !chercherEvenement(e.getFin()).equals(""))
            return false;
            
        // Vérifie que l'évenement ne chevauche pas un évenement existant - validateur 2:
        // On s'assure que les dates de début ET de fin d'un évenement existant ne soient pas comprises à l'intérieur du nouvel évenement.
        LocalDateTime newLocalDateTimeDebut = e.getLocaleDateTimeDebutObj();
        LocalDateTime newLocalDateTimeFin = e.getLocaleDateTimeFinObj();
        for (Evenement evenement : evenements) {
            LocalDateTime existingLocalDateTimeDebut = evenement.getLocaleDateTimeDebutObj();
            LocalDateTime existingLocalDateTimeFin = evenement.getLocaleDateTimeFinObj();
            if (existingLocalDateTimeDebut.isAfter(newLocalDateTimeDebut) && existingLocalDateTimeFin.isBefore(newLocalDateTimeFin))              
                return false;
        }
        
        evenements.add(e);
        return true;
        
    }
    
    public boolean supprimer(String nom){
        return evenements.removeIf(o -> o.getNom().equals(nom));
    }
    
    public String chercherEvenement(Date d){
        LocalDateTime localDateTimeEvenement = d.getLocaleDateTimeObj();
        for (Evenement e : evenements) { 		      
            LocalDateTime localDateTimeDebut = e.getLocaleDateTimeDebutObj();
            LocalDateTime localDateTimeFin = e.getLocaleDateTimeFinObj();
            if (localDateTimeEvenement.isAfter(localDateTimeDebut) && localDateTimeEvenement.isBefore(localDateTimeFin))
                return e.getNom();
            if (d.equals(e.getDebut()) || d.equals(e.getFin()))
                return e.getNom();
        }
        return "";
    }
    
    public Date dateDebut(String nom)throws ErreurAgenda {
        Evenement e = evenements.stream().filter(o -> o.getNom().equals(nom)).findFirst().orElse(null);
        if (e == null)
            throw new ErreurAgenda();
        return e.getDebut();
    }
    
    public Date dateFin(String nom)throws ErreurAgenda{
        Evenement e = evenements.stream().filter(o -> o.getNom().equals(nom)).findFirst().orElse(null);
        if (e == null)
            throw new ErreurAgenda();
        return e.getFin();
    }
    
    public boolean prevu(String nom){
        Evenement e = evenements.stream().filter(o -> o.getNom().equals(nom)).findFirst().orElse(null);
        if (e == null)
            return false;
        return true;
    }
}
