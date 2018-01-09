package mapElements;

import mapObjects.*;

import java.util.Random;


public class Carte {

	// Variable
	private MainObject[][] carte;
	private int longueur, hauteur;
	private Personnage joueur;
	private Random rn = new Random();

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
		this.longueur = 10;
		this.hauteur = 10;
		this.carte = new MainObject[this.hauteur][this.longueur];
		this.joueur = new Personnage();
	}

	// Méthodes
	public void initialiserCarte() {

		for (int i = 0; i < this.hauteur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				if (i == 0 && j == 0) {
					carte[i][j] = this.joueur;
					// carte[i][j].setVisible(true);
				} else {
				    carte[i][j] = new MainObject(i, j);
				}
			}
		}
        this.getRandomObj();
	}

	private void getRandomObj() {
	    int nbPorteCle = 1;
	    int nbPiece = 10;
	    int nbMonstre = 30;



        for (int l = 0; l < nbMonstre; l++) {
            setMonster();
        }
        for (int k = 0; k < nbPiece; k++) {
            setGold();
        }
        for (int j = 0; j < nbPorteCle; j++) {
            setDoors();
            setKey();
        }
    }

    private void setDoors() {
        int xAlea = rn.nextInt(longueur - 1);
        int yAlea = rn.nextInt(hauteur - 1);

        if(carte[xAlea][yAlea].getShape() == '_') {
            carte[xAlea][yAlea] = new Porte(xAlea, yAlea);
        } else {
            setDoors();
        }
    }

    private void setGold() {
        int xAlea = rn.nextInt(longueur - 1);
        int yAlea = rn.nextInt(hauteur - 1);

        if(carte[xAlea][yAlea].getShape() == '_') {
            carte[xAlea][yAlea] = new Or(xAlea, yAlea);
        } else {
            setGold();
        }
    }

    private void setKey() {
        int xAlea = rn.nextInt(longueur - 1);
        int yAlea = rn.nextInt(hauteur - 1);

        if(carte[xAlea][yAlea].getShape() == '_') {
            carte[xAlea][yAlea] = new Cle(xAlea, yAlea);
        } else {
            setKey();
        }
    }

	private void setMonster() {
		int xAlea = rn.nextInt(longueur - 1);
		int yAlea = rn.nextInt(hauteur - 1);

		if(carte[xAlea][yAlea].getShape() == '_') {
			carte[xAlea][yAlea] = new Monstre(xAlea, yAlea, 1);
		} else {
            setMonster();
		}
	}

	public void afficherCarte() {
		for (int i = 0; i < this.longueur; i++) {
			for (int j = 0; j < this.hauteur; j++) {
				System.out.print(carte[i][j].toString()  + " | ");
			}
			System.out.println();
		}
		System.out.println(this.joueur.montrerInfos());
	}

	public int deplacerPersonnage(int deplacement) {
        int playerX = this.joueur.getX();
        int playerY = this.joueur.getY();
		int rencontre = 0;
		switch (deplacement) {
		case 8:
			if (playerX - 1 >= 0) {
                rencontre = this.caseRencontrer(carte[playerX - 1][playerY]);
				if ( rencontre == 1) {
					carte[playerX][playerY] = new MainObject(playerX, playerY);
					joueur.setX(joueur.getX() - 1);
                    playerX = this.joueur.getX();
					carte[playerX][playerY] = joueur;
				}
			}
			break;
		case 4:
			if (playerY - 1 >= 0) {
			    rencontre = this.caseRencontrer(carte[playerX][playerY - 1]);
				if ( rencontre == 1) {
                    carte[playerX][playerY] = new MainObject(playerX, playerY);
					joueur.setY(joueur.getY() - 1);
                    playerY = this.joueur.getY();
                    carte[playerX][playerY] = joueur;

				}
			}
			break;
		case 2:
			if (playerX + 1 < this.hauteur) {
			    rencontre = this.caseRencontrer(carte[playerX + 1][playerY]);
				if ( rencontre == 1) {
                    carte[playerX][playerY] = new MainObject(playerX, playerY);
					joueur.setX(joueur.getX() + 1);
                    playerX = this.joueur.getX();
                    carte[playerX][playerY] = joueur;
				}
			}
			break;
		case 6:
			if (playerY + 1 < this.longueur) {
			    rencontre = this.caseRencontrer(carte[playerX][playerY + 1]);
				if ( rencontre == 1) {
                    carte[playerX][playerY] = new MainObject(playerX, playerY);
					joueur.setY(joueur.getY() + 1);
                    playerY = this.joueur.getY();
                    carte[playerX][playerY] = joueur;
				}
			}
			break;
		case 0:
			rencontre = 99;
			break;

		default:
			System.out.println("veuillez saisir un numéro dans les options ci dessous");
			break;
		}
		return rencontre;
	}

	private int caseRencontrer(MainObject c) {
		switch (c.getShape()) {
            case 0:
            case '_':
                return 1;
            case 'X':
                this.joueur.diminuerVie(1);
                if (this.joueur.getVie() <= 0){
                    return 8;
                }
                return 1;
            case 3:
                System.out.println("il y a un obstacle");
                return 0;
            case 'O':
                this.joueur.modifierOr(1);
                return 1;
            case 'K':
                this.joueur.modifierCle(1);
                return 1;
            case 8:
                this.joueur.diminuerVie(1);
                return 1;
            case 'P':
                if (this.joueur.getCles() > 0) {
                    this.joueur.modifierCle(-1);
                    return 9;
                } else {
                    System.out.println("tu n'as pas de clef pour ouvrir le cadena");
                    return 0;
                }
            default:
                return 0;
		}
	}

}
