package mapObjects;


import java.util.HashMap;
import java.util.Map;

public class Personnage extends MainObject {

	// Variable
	private int x, y;
	private Map<String, Integer> inventaire;
	private int vie;

	// Constructor
	public Personnage() {
		super(0,0,'I');
        this.inventaire = new HashMap<String, Integer>();
        this.inventaire.put("or", 0);
        this.inventaire.put("cle", 0);
        this.vie = 5;
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


	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public void augmenterVie(int valeur) {
	    this.vie += valeur;
    }

    public void diminuerVie(int valeur) {
        this.vie -= valeur;
    }

    public int getOr() {
        return this.inventaire.get("or");
    }

    public void setOr(int or) {
        this.inventaire.put("or", or += or);
    }

    public void modifierOr(int nb) {
	    int orActuelle = this.inventaire.get("or");
        this.inventaire.put("or", orActuelle += nb);
    }

	public int getCles() {
        return this.inventaire.get("cle");
	}

	public void setCle(int cle) {
        this.inventaire.put("cle", cle);
	}

    public void modifierCle(int nb) {
        int cleActuelle = this.inventaire.get("cle");
        this.inventaire.put("cle", cleActuelle += nb);
    }

    public String montrerInfos() {
        return "Vie : " + this.vie + " / Or : " + this.getOr() + " / Cle : " + this.getCles();
    }
}