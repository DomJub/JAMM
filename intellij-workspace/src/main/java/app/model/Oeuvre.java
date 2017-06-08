package app.model;

/**
 * Created by Jub on 12/05/2017.
 */
public abstract class Oeuvre {
    protected String titre;
    protected Auteur auteur;
    protected String libelle_auteur;
    protected String origine;
    protected String support;
    protected int note;
    protected String commentaire;
    protected String categorie;
    protected int achevement;
    protected String marque;
    protected String modele;
    protected int id_oeuvre;

    public int getId_oeuvre() {
        return id_oeuvre;
    }

    public void setId_oeuvre(int id_oeuvre) {
        this.id_oeuvre = id_oeuvre;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    protected String langue;

    public int getAchevement() {
        return achevement;
    }

    public void setAchevement(int achevement) {
        this.achevement = achevement;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Oeuvre() {
        this.titre = "";
        this.auteur = new Auteur();
        this.libelle_auteur = "";
        this.origine = "";
        this.support = "";
        this.note = 0;
        this.commentaire = "";
        this.categorie = "";
    }

    public Oeuvre(String titre, String auteur, String libelle_auteur, String origine, String support, int note, String commentaire) {
        this.titre = titre;
        this.auteur = new Auteur();
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

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
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
