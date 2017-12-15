package platform;


import comptage.Compteur;
import comptage.CompteurVie;

public class Personnage {

	// Variable
	private int x, y;
	private Compteur nbCLes,or;
	private CompteurVie vie;

	// Constructor
	public Personnage() {
		this.x=0;
		this.y=0;
		this.or = new Compteur();
		this.nbCLes = new Compteur();
		this.vie = new CompteurVie();
	}

	// Accessories
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Compteur getOr() {
		return or;
	}

	public void setOr(Compteur or) {
		this.or = or;
	}

	public CompteurVie getVie() {
		return vie;
	}

	public void setVie(CompteurVie vie) {
		this.vie = vie;
	}

	public Compteur getNbCLes() {
		return nbCLes;
	}

	public void setNbCLes(Compteur nbCLes) {
		this.nbCLes = nbCLes;
	}

}