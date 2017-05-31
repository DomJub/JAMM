package app.model;

/**
 * Created by Jub on 31/05/2017.
 */
public class Auteur {

    protected String nomAuteur;

    public Auteur(){}

    public Auteur(String nomAuteur){
        this.nomAuteur = nomAuteur;
    }

    public String getNomAuteur() {
        return this.nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }
}
