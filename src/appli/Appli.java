package appli;

import java.util.Scanner;

import platform.Carte;

public class Appli {

	public static void main(String[] args) {
		
		boolean quitter = false;
		int dp;
		
		Carte jeu = new Carte();
		jeu.initialiserCarte();
		jeu.afficherCarte();
		
		
		
		while (quitter == false) {
			Scanner sc = new Scanner(System.in);
			System.out.println("2 bas, 4 gauche, 8 haut, 6 droite ou sinon 0 pour quitter le jeu.");
			System.out.println("Veuillez saisir un numéro :");
			dp = sc.nextInt();
			quitter = jeu.deplacerPersonnage(dp);
			jeu.afficherCarte();
		}
		
		
	}

}
