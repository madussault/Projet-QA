/**
 *
 * @author Marc-André Dussault
 */

import java.time.LocalDateTime;

public class Date {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minute;
    
    public Date(int jour, int mois, int annee, int heure, int minute)throws ErreurDate {
        setJour(jour, mois, annee);
        setMois(mois);
        setAnnee(annee);
        setHeure(heure);
        setMinute(minute);
    }
    
    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public int getHeure() {
        return heure;
    }

    public int getMinute() {
        return minute;
    }
    
    public void setJour(int jour, int mois, int annee) throws ErreurDate {
        
        if (jour <= 28 && jour >=1)
            this.jour = jour;
        else
            if (mois == 1 ||  mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12)
                if(jour <= 31)
                    this.jour = jour;
                else
                    throw new ErreurDate();
            else if (mois == 4 ||  mois == 6 || mois == 9 || mois == 11)
                if(jour <= 30)
                    this.jour = jour;
                else
                    throw new ErreurDate();
            else if (mois == 2)
                if(isBissextile(annee) && jour <= 29)
                    this.jour = jour;
                else
                    throw new ErreurDate();
            else
                throw new ErreurDate();
    }

    public void setMois(int mois) throws ErreurDate {
        if (mois < 1 || mois > 12)
            throw new ErreurDate();
        this.mois = mois;
    }

    public void setAnnee(int annee) throws ErreurDate {
        if (annee > 2020)
            throw new ErreurDate();
        this.annee = annee;
    }

    public void setHeure(int heure) throws ErreurDate {
        if (heure < 0 || heure > 23)
            throw new ErreurDate();
        this.heure = heure;
    }

    public void setMinute(int minute) throws ErreurDate {
        if (minute <= 0 || minute >= 59)
            throw new ErreurDate();
        this.minute = minute;
    }
    
    public boolean isBissextile(int annee){
        if(annee%4==0 && annee%100!=0 || annee%400==00)
            return true;
        return false;
    }
    
    public LocalDateTime getLocaleDateTimeObj(){
        return LocalDateTime.of(
            getAnnee(), 
            getMois(), 
            getJour(), 
            getHeure(), 
            getMinute()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Date other = (Date) obj;
        if (this.jour != other.jour) {
            return false;
        }
        if (this.mois != other.mois) {
            return false;
        }
        if (this.annee != other.annee) {
            return false;
        }
        if (this.heure != other.heure) {
            return false;
        }
        if (this.minute != other.minute) {
            return false;
        }
        return true;
    }
    
    
}
