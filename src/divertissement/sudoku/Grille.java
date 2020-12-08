package divertissement.sudoku;

import java.util.Arrays;

/**
 * Gestion d'une grille de sudoku (affichage, complétion, réinitialisation...)
 *
 * @author  Clément MAURIN
 * @version 1.0
 */

public class Grille {

    /* Taille de la grille de sudoku (générée en *taille x taille* carrée) */
    private static int taille;

    /* Liste de toutes les cases de la grille (avec coordonnées, valeurs et valeurs possibles) */
    private final Case[][] cases;

    /**
     * Permet la création d'une grille de sudoku initilisée ou non par des valeurs dans ces cases
     * @param taille Taille totale de la grille
     * @param cases Liste des cases initilisées de la grilles
     */
    public Grille(int taille, Case[][] cases) {
        this.taille = taille;
        this.cases = cases;
    }

    /**
     * Permet l'affichage de la grille de sudoku au format texte dans la console
     */
    public void AfficherGrille() {
        for (int i = 0; i < taille; i++) {
            System.out.println(Arrays.toString(this.getLigne(i)));
        }
    }

    /**
     * Permet de récupérer une ligne entière sous la forme d'un tableau
     * @param num_ligne Numéro de la ligne que l'on veut récupérer
     * @return Un tableau de toutes les valeurs présentes dans la ligne demandée
     */
    public int[] getLigne(int num_ligne) {
        int [] result = new int[taille]; // Créer un tableau de la taille (en longueur) du tableau
        for (int i = 0; i < taille; i++) {
            Case caseCourante = this.cases[num_ligne][i];
            result[i] = caseCourante.getValeur();
        }
        return result;
    }

    /**
     * Permet de récupérer une colonne entière sous la forme d'un tableau
     * @param num_colonne Numéro de la colonne que l'on veut récupérer
     * @return Un tableau de toutes les valeurs présentes dans la colonne demandée
     */
    public int[] getColonne(int num_colonne) {
        int [] result = new int[taille]; // Créer un tableau de la taille (en hauteur) du tableau
        return result;
    }

    /**
     * Permet de récupérer une région entière sous la forme d'un tableau
     * @param num_region Numéro de la région que l'on veut récupérer (régions indéxées en Z order : de gauche a droite
     *                                                                                          puis de haut en bas)
     * @return Un tableau de toutes les valeurs présentes dans la région demandée
     */
    public int[] getRegion(int num_region) {
        int [] result = new int[taille]; // Créer un tableau de la taille du tableau (car tailleRegion = tailleLigne)
        return result;
    }

    /**
     * Permet l'initialisation de la grille avec des valeurs dans certaines cases.
     * Attention, l'inialisation doit générer les valeurs sans erreurs (pas de doublon sur un ligne...)
     * @param taille Taille de la grille à générer
     */
    public static Grille initGrille(int taille) {
        Case[][] cases = new Case[taille][taille];
        for (int i = 0; i < taille; i++) {
            //On parcours les lignes pour tout remplir
            for (int j = 0; j < taille; j++) {
                // On parcours les colonnes pour tout remplir
                Case caseCourante = new Case(j, i, 0, null);
                cases[i][j] = caseCourante;
            }
        }
        return new Grille(taille, cases);
    }

    /**
     * Permet de supprimer toutes les valeurs de la grille pour avoir une grille vide
     */
    private static void clearGrille() {}

    public void setValeur(int valeur, int coordonneesX, int coordonneeY, int[] valeurs_possibles) {
        if (this.cases[coordonneeY][coordonneesX].getValeur() == 0) {  // Vérifie que la case est vide
            this.cases[coordonneeY][coordonneesX] = new Case(coordonneesX, coordonneeY, valeur, valeurs_possibles);
        } else {
            System.err.println("Erreur : Vous ne pouvez pas modifier le contenu d'une case déjà initialisé.");
        }
    }
}
