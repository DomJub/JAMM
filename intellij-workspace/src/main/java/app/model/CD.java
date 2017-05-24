package app.model;

/**
 * Created by Jub on 12/05/2017.
 */
public class CD extends Oeuvre {

    public String getListe_piste() {
        return liste_piste;
    }

    public void setListe_piste(String liste_piste) {
        this.liste_piste = liste_piste;
    }

    protected String liste_piste;

    public CD(String nom, String auteur, String libelle_auteur, String origine_acquisition, String support, int note, String commentaire, String liste_piste) {
        super(nom, auteur, libelle_auteur, origine_acquisition, support, note, commentaire);
        this.liste_piste = liste_piste;
    }

    public CD() {
        super();
        this.liste_piste = "";
    }
}
