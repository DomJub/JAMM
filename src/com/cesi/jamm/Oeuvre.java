package com.cesi.jamm;

/**
 * Created by Jub on 12/05/2017.
 */
abstract class Oeuvre implements CRUDOeuvre {
    protected String nom;
    protected String auteur;
    protected String libelle_auteur;
    protected String origine_acquisition;
    protected String support;
    protected int note;
    protected String commentaire;

    public Oeuvre() {
        this.nom = "";
        this.auteur = "";
        this.libelle_auteur = "";
        this.origine_acquisition = "";
        this.support = "";
        this.note = 0;
        this.commentaire = "";
    }

    public Oeuvre(String nom, String auteur, String libelle_auteur, String origine_acquisition, String support, int note, String commentaire) {
        this.nom = nom;
        this.auteur = auteur;
        this.libelle_auteur = libelle_auteur;
        this.origine_acquisition = origine_acquisition;
        this.support = support;
        this.note = note;
        this.commentaire = commentaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getOrigine_acquisition() {
        return origine_acquisition;
    }

    public void setOrigine_acquisition(String origine_acquisition) {
        this.origine_acquisition = origine_acquisition;
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

    @Override
    public void seReferencer() {

    }

    @Override
    public void etreMisAJour() {

    }

    @Override
    public void etreSupprime() {

    }
}
