/* @class Table
 * Cette classe a pour but de storer des objets Client et leur Commande. Il s'agit
 * du conteneur final des autres classes. Chaque objet Table est identifi�e par son @param numero
 * afin de faciliter sa manipulation.
 */

package outils;

import java.util.ArrayList;

public class Table {
	
	protected int numero;
	protected String etat = "Autre Serveur"; // �tat de la Table
	protected ArrayList<Client> clients = new ArrayList<Client>(); // Liste des Clients de la Table

}