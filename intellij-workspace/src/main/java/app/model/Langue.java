package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Jub on 31/05/2017.
 */
public class Langue implements DataOeuvre {

    protected String nomLangue;

    public Langue(){}

    public Langue(String nomLangue){
        this.nomLangue = nomLangue;
    }

    @Override
    public String getName() {
        return this.nomLangue;
    }

    @Override
    public void setName(String name) {
        this.nomLangue = name;
    }
}
