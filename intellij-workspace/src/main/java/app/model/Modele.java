package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Philippe on 01/06/2017.
 */
public class Modele implements DataOeuvre {

    protected String nomModele;

    public Modele(){

    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
}