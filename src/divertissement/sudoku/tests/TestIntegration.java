package divertissement.sudoku.tests;

import divertissement.sudoku.Case;
import divertissement.sudoku.Grille;

import java.util.Scanner;

public class TestIntegration {

    public static void main(String[] args) {
        int taille = 4;
        int [] valeurs_possibles = { 1, 2, 3, 4 };

        Grille grilleTest = Grille.initGrille(taille);

        // Valeur d'initialisation de notre jeu de test
        grilleTest.setValeur(1,0, 0, valeurs_possibles);
        grilleTest.setValeur(2,2, 1, valeurs_possibles);
        grilleTest.setValeur(3,1, 3, valeurs_possibles);
        grilleTest.setValeur(4,3, 3, valeurs_possibles);

        grilleTest.AfficherGrille();

        Scanner scanner = new Scanner (System.in);
        boolean finish = false;
        int cooX, cooY, valeur;
        while (!finish) {  //Boucle tant que l'utlisateur entre des valeurs
            System.out.print("Dans quelle ligne souhaitez vous écrire ? ");
            if (scanner.hasNextInt()) {  //si l'utilisateur entre un entier : le récupère
                cooY = scanner.nextInt();
            } else {  // Sinon s'arrête
                cooY = 0;
                finish = true;
            }
            System.out.print("Dans quelle colonne souhaitez vous écrire ? ");
            if (scanner.hasNextInt()) {  //si l'utilisateur entre un entier : le récupère
                cooX = scanner.nextInt();
            } else {  // Sinon s'arrête
                cooX = 0;
                finish = true;
            }
            System.out.print("Quelle valeur souhaitez vous écrire ? ");
            if (scanner.hasNextInt()) {  //si l'utilisateur entre un entier : le récupère
                valeur = scanner.nextInt();
            } else {  // Sinon s'arrête
                valeur = 0;
                finish = true;
            }
            if (!finish) {
                // Ajoute la valeur dans la case sélectionnée par l'utilisateur
                grilleTest.setValeur(valeur, cooX, cooY, valeurs_possibles);
                // Affiche la grille mise à jour
                grilleTest.AfficherGrille();
            }
        }

    }

}
