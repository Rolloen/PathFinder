package appli;

import java.util.Scanner;

import mapElements.Carte;

public class Appli {

	public static void main(String[] args) {
		
		int quitter = 0;
		int dp;
		
		Carte jeu = new Carte();
		jeu.initialiserCarte();
		jeu.afficherCarte();

		while (quitter != 99) {
			Scanner sc = new Scanner(System.in);
			System.out.println("2 bas, 4 gauche, 8 haut, 6 droite ou sinon 0 pour quitter le jeu.");
			System.out.println("Veuillez saisir un numéro :");
			dp = sc.nextInt();
			quitter = jeu.deplacerPersonnage(dp);
			if (quitter == 9 ) {
                System.out.println("Félicitation vous avez gagner !");
                return;
            }
			if (quitter == 8 ) {
				System.out.println("Vous êtes mort :(");
				return;
			}
			jeu.afficherCarte();
		}

		
	}
}
