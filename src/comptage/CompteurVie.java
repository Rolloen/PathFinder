package comptage;

public class CompteurVie extends Compteur {
	int valeurMax;

	public CompteurVie() {
		super(10);
		this.valeurMax = 0;
	}

	public void decrementer() {
		if (this.getValeur() == valeurMax) {
			System.out.println("Vous n'avez plus de vie");
		} else
			this.setValeur(this.getValeur() - 1);
	}

	@Override
	public String toString() {
		if (this.getValeur() > 1) {
			String s = "Tu as " + this.getValeur() + "vies";
			return s;
		} else {
			String s = "Fais attention tu n'as plus que " + this.getValeur() + "vie !";
			return s;
		}
	}

}
