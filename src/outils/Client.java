/* @class Client
 * Il s'agit d'objets qui seront placés en @param clients dans @class Table.
 * Les objets Client possèdent une attribut @param commande, qui tient compte de tous les articles
 * commandés par celui-ci.
 */

package outils;

import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Client {
	
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	protected String nom;
	protected ArrayList<Article> commande = new ArrayList<Article>(); // Liste d'objets Article commandées
	protected int total; // Total des @param prix des objets Article
	
	
	/*
	 *  Cette méthode sert à déterminer le total d'une commande d'un client. On parcours la liste entière
	 *  en cumulant les @param prix des objets Article.
	 */

	
	public Client(String s)
	{
		this.nom = s;
	}
	
	public void afficherCommande() {
		
		System.out.println("Nom du Restaurant");
		System.out.println();
		
        Date date = new Date();
        System.out.println(sdf.format(date));
		System.out.println();
		
		System.out.println("Table : " + Interface.tableChoisie.numero);
		System.out.println();
		
		System.out.println("Articles");
		System.out.println("------------------------------");
		
		int total = 0;
		
		for (int i = 0; i < commande.size(); i++)
		{
			System.out.println(commande.get(i).nom + " - " + commande.get(i).prix);
			total += commande.get(i).prix;
		}
		
		double taxes = total * 0.15;
		
		System.out.println();
		System.out.println("Total avant taxes : " + getTotal());
		System.out.println("Taxes : " + taxes);
		System.out.println();
		System.out.println("Total : " + (total + taxes));
		System.out.println();
		System.out.println();
		System.out.println("MERCI!");
		
	}
	
	public void afficherCommandePopUp(JPanel contentPane) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(sdf.format(date));
        
        String articles = "";
		int total = 0;
        
		for (int i = 0; i < commande.size(); i++)
		{
			articles = articles + commande.get(i).nom + " - " + commande.get(i).prix + "\n";
			total += commande.get(i).prix;
		}
		
		double taxes = total * 0.15;
        
		JOptionPane.showMessageDialog(contentPane, "Nom du Restaurant\n\n" + sdf.format(date) + "\n" +  "Table : " + Interface.tableChoisie.numero + "\n" +
		"Articles\n" + "------------------------------\n\n" + articles + "\n\nTotal avant taxes : " + total + "\nTaxes : " + taxes + "\n\nTotal : " + (total + taxes) + 
		"\n\n\nMERCI!");
	  }
	
	
	public int getTotal()
	{
		for(int i = 0; i < commande.size(); i++)
		{
			total+= commande.get(i).prix;
		}
		
		return total;
	}

}