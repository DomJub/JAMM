package app.model;

/**
 * Created by Philippe on 24/05/2017.
 */
public class OeuvreLite extends Oeuvre {


    @Override
    public String getTitre() {
        return super.getTitre();
    }

    @Override
    public String getOrigine() {
        return super.getOrigine();
    }

    @Override
    public String getCategorie(){ return super.getCategorie();}

    @Override
    public Auteur getAuteur(){
        return super.getAuteur();
    }

    @Override
    public int getNote() {
        return super.getNote();
    }

    public OeuvreLite() {

    }
}
