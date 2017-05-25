package app.model;

/**
 * Created by Jub on 12/05/2017.
 */
public abstract class Oeuvre {
    protected String titre;
    protected String auteur;
    protected String libelle_auteur;
    protected String origine;
    protected String support;
    protected int note;
    protected String commentaire;

    public Oeuvre() {
        this.titre = "";
        this.auteur = "";
        this.libelle_auteur = "";
        this.origine = "";
        this.support = "";
        this.note = 0;
        this.commentaire = "";
    }

    public Oeuvre(String titre, String auteur, String libelle_auteur, String origine, String support, int note, String commentaire) {
        this.titre = titre;
        this.auteur = auteur;
        this.libelle_auteur = libelle_auteur;
        this.origine = origine;
        this.support = support;
        this.note = note;
        this.commentaire = commentaire;
    }

    public String getTitre() {
        return titre;
    }

    public Oeuvre setTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getLibelle_auteur() {
        return libelle_auteur;
    }

    public void setLibelle_auteur(String libelle_auteur) {
        this.libelle_auteur = libelle_auteur;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


}
