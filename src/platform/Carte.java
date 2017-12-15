package platform;

import java.util.Random;
import java.util.ArrayList;

public class Carte {

	// Variable
	Case[][] carte;
	int longueur, hauteur;
	Personnage joueur;
	Random rn = new Random();

	// Accessories
	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	// Constructor
	public Carte() {
		this.longueur = 20;
		this.hauteur = 20;
		this.carte = new Case[this.hauteur][this.longueur];
		this.joueur = new Personnage();
	}

	// Méthodes
	public void initialiserCarte() {
		ArrayList<Integer> vC = this.setCase();
		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				if (i == 0 && j == 0) {
					joueur.setX(0);
					joueur.setY(0);
					carte[i][j] = new Case();
					carte[i][j].setValeur(9);
					// carte[i][j].setVisible(true);
				} else {
					int nbAleatoire = rn.nextInt(vC.size());
					carte[i][j] = new Case(vC.get(nbAleatoire));
					vC.remove(nbAleatoire);
				}
			}
		}
	}

	public ArrayList<Integer> setCase() {
		ArrayList<Integer> valeurCase = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			valeurCase.add(1);
		}
		for (int i = 0; i < 5; i++) {
			valeurCase.add(2);
		}
		for (int i = 0; i < 10; i++) {
			valeurCase.add(3);
		}
		for (int i = 0; i < 3; i++) {
			valeurCase.add(4);
			valeurCase.add(6);
		}
		for (int i = 0; i < 20; i++) {
			valeurCase.add(5);
		}
		for (int i = 0; i < 10; i++) {
			valeurCase.add(7);
		}
		for (int i = 0; i < 15; i++) {
			valeurCase.add(8);
		}
		for (int i = 0; i < 329; i++) {
			valeurCase.add(0);
		}

		return valeurCase;

	}

	public void afficherCarte() {
		for (int i = 0; i < this.longueur; i++) {
			for (int j = 0; j < this.hauteur; j++) {
				if (this.carte[i][j].getValeur() == 9) {
					System.out.print("X ");
				} else {
					System.out.print(this.carte[i][j].getValeur() + " ");
				}
			}
			System.out.println();
		}
	}

	public boolean deplacerPersonnage(int deplacement) {

		boolean bool = false;
		switch (deplacement) {
		case 8:
			if (this.joueur.getX() - 1 >= 0) {
				if ("immobile" != this.caseRencontrer(carte[this.joueur.getX() - 1][this.joueur.getY()])) {
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(0);
					joueur.setX(joueur.getX() - 1);
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(9);
				}
			}
			break;
		case 4:
			if (this.joueur.getY() - 1 >= 0) {
				if ("immobile" != this.caseRencontrer(carte[this.joueur.getX()][this.joueur.getY() - 1])) {
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(0);
					joueur.setY(joueur.getY() - 1);
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(9);

				}
			}
			break;
		case 2:
			if (this.joueur.getX() + 1 < this.hauteur) {
				if ("immobile" != this.caseRencontrer(carte[this.joueur.getX() + 1][this.joueur.getY()])) {
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(0);
					joueur.setX(joueur.getX() + 1);
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(9);
				}
			}
			break;
		case 6:
			if (this.joueur.getY() + 1 < this.longueur) {
				if ("immobile" != this.caseRencontrer(carte[this.joueur.getX()][this.joueur.getY() + 1])) {
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(0);
					joueur.setY(joueur.getY() + 1);
					carte[this.joueur.getX()][this.joueur.getY()].setValeur(9);
				}
			}
			break;
		case 0:
			bool = true;
			break;

		default:
			System.out.println("veuillez saisir un numéro dans les options ci dessous");
			break;
		}
		return bool;
	}

	public String caseRencontrer(Case c) {
		switch (c.getValeur()) {
		case 0:
		case 1:
			return "deplace";
		case 2:
		case 3:
			System.out.println("il y a un obstacle");
			return "immobile";
		case 4:
			this.joueur.getOr().incrementer();
			this.joueur.getOr().incrementer();
			this.joueur.getNbCLes().incrementer();
			return "deplace";
		case 5:
			this.joueur.getOr().incrementer();
			return "deplace";
		case 6:
			if (this.joueur.getNbCLes().getValeur() > 0) {
				this.joueur.getNbCLes().decrementer();
				return "deplace";
			} else {
				System.out.println("tu n'as pas de clef pour ouvrir le cadena");
				return "immobile";
			}
		case 7:
			this.joueur.getVie().decrementer();
			return "deplace";
		case 8:
			this.joueur.getVie().decrementer();
			this.joueur.getVie().decrementer();
			return "deplace";

		default:
			return "immobile";
		}
	}

}
