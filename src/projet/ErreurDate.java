/**
 *
 * @author Marc-André Dussault Gr427
 */
class ErreurDate extends Exception {
    public ErreurDate()
    {
        super();
    }

    @Override
    public String getMessage(){
        return "Date invalide";
    }
}
