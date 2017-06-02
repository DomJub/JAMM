package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Jub on 01/06/2017.
 */
public class PisteMusicale implements DataOeuvre{

    protected String nomPiste;
    protected String numPiste;

    public PisteMusicale(){}

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    public String getNomPiste(){
        return this.nomPiste;
    }

    public String getNumPiste(){
        return this.numPiste;
    }

    public void setNomPiste(String nomPiste){
        this.nomPiste = nomPiste;
    }

    public void setNumPiste(String numPiste){
        this.numPiste = numPiste;
    }

}
