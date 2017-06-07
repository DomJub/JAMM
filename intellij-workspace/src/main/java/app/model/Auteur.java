package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Jub on 31/05/2017.
 */
public class Auteur implements DataOeuvre {

    protected String name;

    public Auteur(){}

    public Auteur(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
