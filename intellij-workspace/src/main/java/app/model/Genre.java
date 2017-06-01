package app.model;

import app.repository.DataOeuvre;

/**
 * Created by Jub on 31/05/2017.
 */
public class Genre implements DataOeuvre {

    protected String nomGenre;

    public Genre(){}

    public Genre(String nomGenre){
        this.nomGenre = nomGenre;
    }

    @Override
    public String getName() {
        return this.nomGenre;
    }

    @Override
    public void setName(String name) {
        this.nomGenre = name;
    }
}
