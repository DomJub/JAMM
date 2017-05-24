package app.model;

/**
 * Created by Jub on 12/05/2017.
 */
public class Jeu extends Oeuvre {

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    protected String console;

    public Jeu(String nom, String auteur, String libelle_auteur, String origine_acquisition, String support, int note, String commentaire, String console) {
        super(nom, auteur, libelle_auteur, origine_acquisition, support, note, commentaire);
        this.console = console;
    }

    public Jeu() {
        super();
        this.console = "";
    }

}
