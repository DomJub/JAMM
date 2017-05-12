package com.cesi.jamm;

/**
 * Created by Jub on 12/05/2017.
 */
public class CD extends Oeuvre implements CRUDOeuvre{

    private String liste_piste;

    public CD(String liste_piste) {
        this.liste_piste = liste_piste;
    }

    @Override
    public void seRéférencer() {

    }

    @Override
    public void etreMisAJour() {

    }

    @Override
    public void etreSupprime() {

    }
}
