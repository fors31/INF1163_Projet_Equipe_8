/* @class Table
 * Cette classe a pour but de storer des objets Client et leur Commande. Il s'agit
 * du conteneur final des autres classes. Chaque objet Table est identifiée par son @param numero
 * afin de faciliter sa manipulation.
 */

package outils;

import java.util.ArrayList;

public class Table {
	
	protected int numero;
	protected String etat = "Autre Serveur"; // État de la Table
	protected ArrayList<Client> clients = new ArrayList<Client>(); // Liste des Clients de la Table

}