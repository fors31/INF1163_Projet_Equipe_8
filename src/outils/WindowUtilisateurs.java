package outils;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class WindowUtilisateurs {

	public static void main(String[] args) {
		afficherUtil();
	}
	
	public static void afficherUtil() {
		JFrame frameUtil = new JFrame("Choisir un Utilisateur");
		frameUtil.setBounds(100,100,151,183);
		frameUtil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUtil.getContentPane().setLayout(null);
		
		JButton btnServeur = new JButton("Serveur");
		btnServeur.setBounds(10, 11, 115, 23);
		frameUtil.getContentPane().add(btnServeur);
		btnServeur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.boxUtilisateurNom = "Serveur";
				Interface.boxUtilisateur.setText("Serveur");
				Interface.btnClientsTable.setVisible(true);
				Interface.btnModTable.setVisible(true);
				Interface.btnArchive.setVisible(false);
				Interface.cuisinierChoisi = false;
				frameUtil.dispose();
			}
		});
		
		JButton btnBusBoy = new JButton("Bus boy");
		btnBusBoy.setBounds(10, 45, 115, 23);
		frameUtil.getContentPane().add(btnBusBoy);
		btnBusBoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.boxUtilisateurNom = "Bus boy";
				Interface.boxUtilisateur.setText("Bus boy");
				Interface.btnClientsTable.setVisible(false);
				Interface.btnModTable.setVisible(true);
				Interface.btnArchive.setVisible(false);
				Interface.cuisinierChoisi = false;
				frameUtil.dispose();
			}
		});
		
		JButton btnACuisinier = new JButton("Cuisinier");
		btnACuisinier.setBounds(10, 79, 115, 23);
		frameUtil.getContentPane().add(btnACuisinier);
		btnACuisinier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.boxUtilisateurNom = "Cuisinier";
				Interface.boxUtilisateur.setText("Cuisinier");
				Interface.btnClientsTable.setVisible(true);
				Interface.btnModTable.setVisible(false);
				Interface.btnArchive.setVisible(false);
				Interface.cuisinierChoisi = true;
				frameUtil.dispose();
			}
		});
		
		JButton btnGerant = new JButton("Gérant");
		btnGerant.setBounds(10, 110, 115, 23);
		frameUtil.getContentPane().add(btnGerant);
		btnGerant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface.boxUtilisateurNom = "Gérant";
				Interface.boxUtilisateur.setText("Gérant");
				Interface.btnClientsTable.setVisible(false);
				Interface.btnModTable.setVisible(false);
				Interface.btnArchive.setVisible(true);
				frameUtil.dispose();
			}
		});
		
		frameUtil.setVisible(true);
	}
}
