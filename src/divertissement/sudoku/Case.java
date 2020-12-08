package divertissement.sudoku;

/**
 * Gestion de cases dans un jeu de sudoku. Ces cases sont toutes disposées dans une grille suivant
 * un système de coordonées et possède une valeur contenue dans un ensemble de valeurs possibles.
 *
 * @author  Clément MAURIN
 * @version 1.0
 */

public class Case {
    private int valeur;
    public int coordonneeX;
    public int coordonneeY;
    public int[] valeurs_possibles;

    /**
     * Permet de créer un point avec une valeur
     * @param coordonnesX Coordonnées de la case sur une ligne
     * @param coordonnesY Coordonnées de la case sur une colonne
     * @param valeur Valeur de la case (0 si non renseigné)
     * @param valeurs_possibles Ensemble des valeurs possible pour l'utilisateur
     */
    public Case(int coordonnesX,int coordonnesY, int valeur, int[] valeurs_possibles) {
        this.coordonneeX = coordonnesX;
        this.coordonneeY = coordonnesY;
        this.valeur = valeur;
        this.valeurs_possibles = valeurs_possibles;
    }

    /**
     * Permet de créer yn point sans valeur
     * @param coordonnesX Coordonnées de la case sur une ligne
     * @param coordonnesY Coordonnées de la case sur une colonne
     */
    public Case(int coordonnesX,int coordonnesY) {
        this.coordonneeX = coordonnesX;
        this.coordonneeY = coordonnesY;
    }

    /**
     * Récupère le valeur de la case courante
     * @return une valeur numérique inscrite dans la case courante
     */
    public int getValeur() {
        return this.valeur;
    }
}
