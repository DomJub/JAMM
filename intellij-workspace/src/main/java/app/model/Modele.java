package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Philippe on 01/06/2017.
 */
public class Modele implements DataOeuvre {

    protected String nomModele;

    public Modele(){

    }

    public Modele(String nomModele){
        this.nomModele = nomModele;
    }

    @Override
    public String getName() {
        return this.nomModele;
    }

    @Override
    public void setName(String name) {
        this.nomModele = name;
    }
}
