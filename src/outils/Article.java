/* @class Article
 * 
 * Cette classe a pour but de représenter des articles alimentaires propres au restaurant. 
 * Il seront placés dans @param commande de @class Client.
 * 
 */

package outils;

public class Article {
	
	protected String nom;
	protected String completion; // État du complétion de l'article en cuisine. Modifiable seulement par les cuisiniers.
	protected int prix;
	protected int quantite;

	
	// Constructeur des articles du menu
	
	public Article(String s, int i, String c) {
		nom = s;
		prix = i;
		completion = c;
	}
	
	static Article Soupe = new Article("Soupe", 4, "Commandé");
	static Article Salade = new Article("Salade", 5, "Commandé");
	static Article Bruschetta = new Article("Bruschetta", 5, "Commandé");
	
	static Article Saumon = new Article("Saumon", 15, "Commandé");
	static Article Poulet = new Article("Poulet", 13, "Commandé");
	static Article BLT = new Article("BLT", 13, "Commandé");
	static Article Tofu = new Article("Tofu", 12, "Commandé");
	static Article Spaghetti = new Article("Spaghetti", 16, "Commandé");
	static Article Risotto = new Article("Risotto", 15, "Commandé");
	static Article Homard = new Article("Homard", 21, "Commandé");
	static Article Burger = new Article("Burger", 14, "Commandé");
	
	static Article Cafe = new Article("Cafe", 3, "Commandé");
	static Article Soda = new Article("Soda", 3, "Commandé");
	static Article Limonade = new Article("Limonade", 4, "Commandé");
	static Article The = new Article("The", 3, "Commandé");
	
}