/* @class Archives
 * 
 * Il s'agit de la classe qui prend note du nombre de ventes effectuées par le restaurant.
 * Cela tient donc compte du nombre d'Articles vendus, ainsi que tu total des ventes.
 * 
 */
package outils;

public class Archives {
	
	static double ventesTotales;
	
	public static double getTotal() {
		ventesTotales = 0;
		for(int i = 0; i < Application.listeTables.size(); i++) {
			
			for(int j = 0; j < Application.listeTables.get(i).clients.size(); j++) {
				
				for(int k = 0; k < Application.listeTables.get(i).clients.get(j).commande.size(); k++) {
					ventesTotales += Application.listeTables.get(i).clients.get(j).commande.get(k).prix;
				}
							
			}
			
		}
		
		return ventesTotales;
	}

}

