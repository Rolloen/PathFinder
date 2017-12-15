package comptage;

public class Compteur {
	private int valeur;

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	// constructeur
	public Compteur() {
		valeur = 0;
	}

	public Compteur(int valeur) {
		this.valeur = valeur;
	}

	// Méthodes
	public void incrementer() {
		valeur++;
	}

	public void decrementer() {
		if (valeur == 0)
			return;
		else
			valeur--;
	}

	@Override
	public String toString() {
		String v = Integer.toString(valeur);
		return v;
	}

}
