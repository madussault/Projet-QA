/**
 *
 * @author Marc-André Dussault Gr427
 */
class ErreurAgenda extends Exception {
    public ErreurAgenda()
    {
        super();
    }

    @Override
    public String getMessage(){
        return "Aucun évenement ne correspond à votre entrée.";
    }
}
