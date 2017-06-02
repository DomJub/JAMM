package app.model;

import java.util.ArrayList;

/**
 * Created by Jub on 12/05/2017.
 */
public class CD extends Oeuvre {

    protected ArrayList<PisteMusicale> listePiste ;

    public ArrayList<PisteMusicale> getListePiste() {
        return this.listePiste;
    }

    public void setListePiste(ArrayList<PisteMusicale> listePiste) {
        this.listePiste = listePiste;
    }



    public CD(String nom, String auteur, String libelle_auteur, String origine_acquisition, String support, int note, String commentaire, ArrayList<PisteMusicale> listePiste) {
        super(nom, auteur, libelle_auteur, origine_acquisition, support, note, commentaire);
        this.listePiste = listePiste;
    }

    public CD() {
        super();
        this.listePiste = new ArrayList<PisteMusicale>();
    }
}
