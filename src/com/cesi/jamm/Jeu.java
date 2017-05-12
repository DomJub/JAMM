package com.cesi.jamm;

/**
 * Created by Jub on 12/05/2017.
 */
public class Jeu extends Oeuvre implements CRUDOeuvre {

    protected String console;

    public Jeu() {
        this.console = "";
    }

    public Jeu(String console) {
        this.console = console;
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
