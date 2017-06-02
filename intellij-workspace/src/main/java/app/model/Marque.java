package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Philippe on 01/06/2017.
 */
public class Marque implements DataOeuvre {

    protected String nomMarque;

    public Marque(){

    }

    public Marque(String nomMarque){
        this.nomMarque = nomMarque;
    }

    @Override
    public String getName() {
        return this.nomMarque;
    }

    @Override
    public void setName(String name) {
        this.nomMarque = name;
    }
}
