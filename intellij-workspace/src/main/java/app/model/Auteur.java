package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Jub on 31/05/2017.
 */
public class Auteur implements DataOeuvre {

    protected String nomAuteur;

    public Auteur(){}

    public Auteur(String nomAuteur){
        this.nomAuteur = nomAuteur;
    }

    @Override
    public String getName() {
        return this.nomAuteur;
    }

    @Override
    public void setName(String name) {
        this.nomAuteur = name;
    }
}
