/* @class Application
 * 
 * Fonction MAIN du programme. Sert a le lancer.
 */

package outils;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Application {

	protected static ArrayList<Table> listeTables = new ArrayList<Table>();

	public static void main(String[] args) {

		// Creation de la liste des tables.

		for (int i = 1; i < 25; i++) {
			Table t = new Table();
			for (int j = 1; j < 7; j++) {
				t.clients.add(new Client("Client" + j));
				t.numero = i;
			}
			
			listeTables.add(t);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}