package app.model;

/**
 * Created by Philippe on 24/05/2017.
 */
public class OeuvreLite extends Oeuvre {

	/*
	 * final private SimpleStringProperty titre; final private
	 * SimpleStringProperty note; final private SimpleStringProperty origine;
	 */
	@Override
	public String getTitre() {
		return super.getTitre();
	}

	@Override
	public String getOrigine() {
		return super.getOrigine();
	}

	@Override
	public int getNote() {
		return super.getNote();
	}

	/*
	 * public OeuvreLite(String titre, Integer note, String origine){
	 * 
	 * this.note = new SimpleStringProperty(); this.titre = new
	 * SimpleStringProperty(); this.origine = new SimpleStringProperty(); }
	 */
	public OeuvreLite() {

	}
}
