/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
class ErreurEvenement extends Exception {
    public ErreurEvenement()
    {
        super();
    }

    @Override
    public String getMessage(){
        return "Évenement invalide.";
    }
}
