package com.cesi.jamm;

/**
 * Created by Jub on 12/05/2017.
 */
public class CD extends Oeuvre {

    protected String liste_piste;

    public CD(){
        this.liste_piste = "";
    }

    public CD(String liste_piste) {
        this.liste_piste = liste_piste;
    }

}
