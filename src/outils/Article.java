/* @class Article
 * 
 * Cette classe a pour but de repr�senter des articles alimentaires propres au restaurant. 
 * Il seront plac�s dans @param commande de @class Client.
 * 
 */

package outils;

public class Article {
	
	protected String nom;
	protected String completion; // �tat du compl�tion de l'article en cuisine. Modifiable seulement par les cuisiniers.
	protected int prix;
	protected int quantite;

	
	// Constructeur des articles du menu
	
	public Article(String s, int i, String c) {
		nom = s;
		prix = i;
		completion = c;
	}
	
	static Article Soupe = new Article("Soupe", 4, "Command�");
	static Article Salade = new Article("Salade", 5, "Command�");
	static Article Bruschetta = new Article("Bruschetta", 5, "Command�");
	
	static Article Saumon = new Article("Saumon", 15, "Command�");
	static Article Poulet = new Article("Poulet", 13, "Command�");
	static Article BLT = new Article("BLT", 13, "Command�");
	static Article Tofu = new Article("Tofu", 12, "Command�");
	static Article Spaghetti = new Article("Spaghetti", 16, "Command�");
	static Article Risotto = new Article("Risotto", 15, "Command�");
	static Article Homard = new Article("Homard", 21, "Command�");
	static Article Burger = new Article("Burger", 14, "Command�");
	
	static Article Cafe = new Article("Cafe", 3, "Command�");
	static Article Soda = new Article("Soda", 3, "Command�");
	static Article Limonade = new Article("Limonade", 4, "Command�");
	static Article The = new Article("The", 3, "Command�");
	
}