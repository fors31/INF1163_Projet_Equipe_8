/* @class InterfaceB
 * 
 * Il s'agit de la classe qui traite de l'interface relative aux clients d'une table.
 * C'est a partir de cette interface qu'on peut ajouter ou retirer les client d'une table,
 * de proceder au paiement et de passer a la modification des commandes.
 */

package outils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class InterfaceB extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceB frame = new InterfaceB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static boolean client1 = false;
	private static boolean client2 = false;
	private static boolean client3 = false;
	private static boolean client4 = false;
	private static boolean client5 = false;
	private static boolean client6 = false;
	
	protected static Client clientChoisi; // Client pour lequel on modifiera la commande.

	public InterfaceB() {

		// Creation de la fenetre de l'application.

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 522);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Creation de la baniere du haut.

		JPanel DiviseurHaut = new JPanel();
		DiviseurHaut.setBounds(0, 0, 728, 48);
		DiviseurHaut.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);

		// Creation de la baniere de droite

		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBounds(727, 0, 119, 483);
		DiviseurDroite.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);

		// Creation d'un paneau qui contient des donnees relatives a l'utilisateur
		// actuel

		JPanel PaneauUtilisateur = new JPanel();
		PaneauUtilisateur.setBounds(0, 0, 119, 47);
		DiviseurDroite.add(PaneauUtilisateur);
		PaneauUtilisateur.setBackground(Color.YELLOW);
		PaneauUtilisateur.setLayout(null);

		// Creation d'un Label qui affiche ces informations

		JLabel boxUtilisateur = new JLabel(Interface.boxUtilisateurNom);
		boxUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		boxUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 11));
		boxUtilisateur.setBounds(10, 11, 99, 25);
		PaneauUtilisateur.add(boxUtilisateur);

		// Image utilisee pour le paneau utilisateur.

		JLabel imgUtilisateur = new JLabel("");
		imgUtilisateur.setVerticalAlignment(SwingConstants.TOP);
		imgUtilisateur.setBounds(0, 0, 119, 47);
		PaneauUtilisateur.add(imgUtilisateur);
		imgUtilisateur.setIcon(new ImageIcon(Interface.class.getResource("/imgs/Banner2.PNG")));

		// Creation d'un paneau oe sont affichees les informations relatives au temps.

		JPanel PaneauTemps = new JPanel();
		PaneauTemps.setBackground(Color.PINK);
		PaneauTemps.setBounds(0, 47, 119, 71);
		DiviseurDroite.add(PaneauTemps);
		PaneauTemps.setLayout(null);

		// Creation d'un objet qui prend en compte les donnees relatives au temps actuel
		// (synchronisation a l'ordinateur).

		LocalDateTime dateHeure = LocalDateTime.now();

		// Creation d'un Label qui afficher le temps actuel selon un format mois, jour
		// et annee.

		DateTimeFormatter dtfJour = DateTimeFormatter.ofPattern("MMM dd, 2019");
		JLabel boxTempsJour = new JLabel("" + dtfJour.format(dateHeure));
		boxTempsJour.setFont(new Font("Tahoma", Font.BOLD, 13));
		boxTempsJour.setBounds(12, 11, 99, 29);
		PaneauTemps.add(boxTempsJour);

		// Creation d'une metion de la table choisie pour les modification a apporter.

		JButton btnTableSaisie = new JButton("Table#"+Interface.tableChoisie.numero);
		btnTableSaisie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTableSaisie.setBounds(637, 12, 81, 30);
		btnTableSaisie.setMargin(new Insets(0, 0, 0, 0));
		btnTableSaisie.setBorder(null);
		btnTableSaisie.setContentAreaFilled(false);
		btnTableSaisie.setOpaque(true);
		btnTableSaisie.setBackground(Color.LIGHT_GRAY);
		DiviseurHaut.add(btnTableSaisie);

		// Creation d'une Label qui affiche le temps actuel selon un format heure et
		// minutes.

		DateTimeFormatter dtfHeure = DateTimeFormatter.ofPattern("hh:mm");
		JLabel lblNewLabel = new JLabel("" + dtfHeure.format(dateHeure));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(37, 35, 46, 14);
		PaneauTemps.add(lblNewLabel);

		// Image utilisee pour la baniere du temps.

		JLabel imgTemps = new JLabel("");
		imgTemps.setBounds(0, 0, 119, 71);
		PaneauTemps.add(imgTemps);
		imgTemps.setIcon(new ImageIcon(Interface.class.getResource("/imgs/bane3.PNG")));

		// Creation d'un bouton pour faire le paiement/imprimer une facture
		JButton BtnPayement = new JButton("Paiement");
		BtnPayement.setForeground(Color.BLACK);
		BtnPayement.setFont(new Font("Tahoma", Font.BOLD, 11));
		BtnPayement.setBackground(new Color(50, 205, 50));
		BtnPayement.setBounds(0, 379, 119, 71);
		DiviseurDroite.add(BtnPayement);

		// Creation du bouton Retour qui amene l'utlisateur a l'interface A.

		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRetour.setBackground(new Color(0, 0, 128));
		btnRetour.setBounds(7, 11, 94, 29);
		btnRetour.setBorder(null);
		DiviseurHaut.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("RETOUR")) {
					dispose();
					Interface.btnsClients = false;
					clientChoisi = null;

					new Interface().setVisible(true);
				}

			}
		});

		/*
		 * Creation des six boutons des clients possible a la table selectionnee a cote
		 * de chaque client, il y a une option de supprimer le client ou de l'ajouter a
		 * la liste d'une table
		 */

		// Client 1

		JRadioButton Client1 = new JRadioButton("Client 1");
		Client1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client1.setBounds(78, 96, 99, 38);
		Client1.setVisible(client1);
		contentPane.add(Client1);
		
		Client1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientChoisi = Interface.tableChoisie.clients.get(0);
			}
		});

		// Bouton qui permet d'ajouter le client 1
		JButton Ajouter1 = new JButton("+");
		Ajouter1.setForeground(Color.RED);
		Ajouter1.setVerticalAlignment(SwingConstants.TOP);
		Ajouter1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter1.setBounds(183, 96, 52, 35);
		Ajouter1.setVisible(!client1);
		contentPane.add(Ajouter1);

		// Bouton qui permet de soustraire le client 1
		JButton Soustraire1 = new JButton("-");
		Soustraire1.setVerticalAlignment(SwingConstants.TOP);
		Soustraire1.setForeground(Color.RED);
		Soustraire1.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire1.setBounds(245, 96, 52, 35);
		contentPane.add(Soustraire1);
		Soustraire1.setVisible(client1);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client1 = true;
				Client1.setVisible(true);
				Ajouter1.setVisible(false);
				Soustraire1.setVisible(true);

			}
		});
		Soustraire1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client1 = false;
				Client1.setVisible(false);
				Ajouter1.setVisible(true);
				Soustraire1.setVisible(false);
				clientChoisi = null;

			}

		});

		// Client 2
		JRadioButton Client2 = new JRadioButton("Client 2");
		Client2.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client2.setBounds(78, 156, 95, 38);
		Client2.setVisible(client2);
		contentPane.add(Client2);
		Client2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientChoisi = Interface.tableChoisie.clients.get(1);
			}
		});

		// Bouton qui permet d'ajouter le client 2
		JButton Ajouter2 = new JButton("+");
		Ajouter2.setVerticalAlignment(SwingConstants.TOP);
		Ajouter2.setForeground(Color.RED);
		Ajouter2.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter2.setBounds(183, 156, 52, 35);
		contentPane.add(Ajouter2);
		Ajouter2.setVisible(!client2);

		// Bouton qui permet de soustraire le client 2
		JButton Soustraire2 = new JButton("-");
		Soustraire2.setVerticalAlignment(SwingConstants.TOP);
		Soustraire2.setForeground(Color.RED);
		Soustraire2.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire2.setBounds(245, 156, 52, 35);
		Soustraire2.setVisible(client2);
		contentPane.add(Soustraire2);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client2 = true;
				Client2.setVisible(true);
				Ajouter2.setVisible(false);
				Soustraire2.setVisible(true);
			}
		});
		Soustraire2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client2 = false;
				Client2.setVisible(false);
				Ajouter2.setVisible(true);
				Soustraire2.setVisible(false);
				clientChoisi = null;
				
			}

		});

		// Client 3
		JRadioButton Client3 = new JRadioButton("Client 3");
		Client3.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client3.setBounds(78, 216, 95, 38);
		Client3.setVisible(client3);
		contentPane.add(Client3);
		Client3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientChoisi = Interface.tableChoisie.clients.get(2);
			}
		});

		// Bouton qui permet d'ajouter le client 3
		JButton Ajouter3 = new JButton("+");
		Ajouter3.setVerticalAlignment(SwingConstants.TOP);
		Ajouter3.setForeground(Color.RED);
		Ajouter3.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter3.setBounds(183, 216, 52, 35);
		contentPane.add(Ajouter3);
		Ajouter3.setVisible(!client3);

		// Bouton qui permet de soustraire le client 3
		JButton Soustraire3 = new JButton("-");
		Soustraire3.setVerticalAlignment(SwingConstants.TOP);
		Soustraire3.setForeground(Color.RED);
		Soustraire3.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire3.setBounds(245, 216, 52, 35);
		Soustraire3.setVisible(client3);
		contentPane.add(Soustraire3);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client3 = true;
				Client3.setVisible(true);
				Ajouter3.setVisible(false);
				Soustraire3.setVisible(true);
			}
		});
		Soustraire3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client3 = false;
				Client3.setVisible(false);
				Ajouter3.setVisible(true);
				Soustraire3.setVisible(false);
				clientChoisi = null;
			}

		});

		// Client 4
		JRadioButton Client4 = new JRadioButton("Client 4");
		Client4.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client4.setBounds(78, 276, 95, 38);
		Client4.setVisible(client4);
		contentPane.add(Client4);
		Client4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientChoisi = Interface.tableChoisie.clients.get(3);
			}
		});

		// Bouton qui permet d'ajouter le client 4
		JButton Ajouter4 = new JButton("+");
		Ajouter4.setVerticalAlignment(SwingConstants.TOP);
		Ajouter4.setForeground(Color.RED);
		Ajouter4.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter4.setBounds(183, 276, 52, 35);
		contentPane.add(Ajouter4);
		Ajouter4.setVisible(!client3);

		// Bouton qui permet de soustraire le client 4
		JButton Soustraire4 = new JButton("-");
		Soustraire4.setVerticalAlignment(SwingConstants.TOP);
		Soustraire4.setForeground(Color.RED);
		Soustraire4.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire4.setBounds(245, 276, 52, 35);
		Soustraire4.setVisible(client3);
		contentPane.add(Soustraire4);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client4 = true;
				Client4.setVisible(true);
				Ajouter4.setVisible(false);
				Soustraire4.setVisible(true);
				clientChoisi = null;
			}
		});
		Soustraire4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client4 = false;
				Client4.setVisible(false);
				Ajouter4.setVisible(true);
				Soustraire4.setVisible(false);
			}

		});

		// Client 5
		JRadioButton Client5 = new JRadioButton("Client 5");
		Client5.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client5.setBounds(78, 336, 95, 38);
		Client5.setVisible(client5);
		contentPane.add(Client5);
		Client5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientChoisi = Interface.tableChoisie.clients.get(4);
			}
		});

		// Bouton qui permet d'ajouter le client 5
		JButton Ajouter5 = new JButton("+");
		Ajouter5.setVerticalAlignment(SwingConstants.TOP);
		Ajouter5.setForeground(Color.RED);
		Ajouter5.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter5.setBounds(183, 336, 52, 35);
		contentPane.add(Ajouter5);
		Ajouter5.setVisible(!client5);

		// Bouton qui permet de soustraire le client 5
		JButton Soustraire5 = new JButton("-");
		Soustraire5.setVerticalAlignment(SwingConstants.TOP);
		Soustraire5.setForeground(Color.RED);
		Soustraire5.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire5.setBounds(245, 336, 52, 35);
		Soustraire5.setVisible(client5);
		contentPane.add(Soustraire5);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client5 = true;
				Client5.setVisible(true);
				Ajouter5.setVisible(false);
				Soustraire5.setVisible(true);
				clientChoisi = null;
			}
		});
		Soustraire5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client5 = false;
				Client5.setVisible(false);
				Ajouter5.setVisible(true);
				Soustraire5.setVisible(false);
			}

		});

		// Client 6
		JRadioButton Client6 = new JRadioButton("Client 6");
		Client6.setFont(new Font("Tahoma", Font.BOLD, 16));
		Client6.setBounds(78, 396, 95, 38);
		Client6.setVisible(client6);
		contentPane.add(Client6);
		Client6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientChoisi = Interface.tableChoisie.clients.get(5);
			}
		});

		// Bouton qui permet d'ajouter le client 6
		JButton Ajouter6 = new JButton("+");
		Ajouter6.setVerticalAlignment(SwingConstants.TOP);
		Ajouter6.setForeground(Color.RED);
		Ajouter6.setFont(new Font("Tahoma", Font.BOLD, 18));
		Ajouter6.setBounds(183, 396, 52, 35);
		contentPane.add(Ajouter6);
		Ajouter6.setVisible(!client6);

		// Bouton qui permet de soustraire le client 6
		JButton Soustraire6 = new JButton("-");
		Soustraire6.setVerticalAlignment(SwingConstants.TOP);
		Soustraire6.setForeground(Color.RED);
		Soustraire6.setFont(new Font("Tahoma", Font.BOLD, 20));
		Soustraire6.setBounds(245, 396, 52, 35);
		Soustraire6.setVisible(client6);
		contentPane.add(Soustraire6);

		// fonctions qui permet de faire fonctionner les boutons "ajouter" et
		// "soustraire"
		Ajouter6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client6 = true;
				Client6.setVisible(true);
				Ajouter6.setVisible(false);
				Soustraire6.setVisible(true);
				clientChoisi = null;
			}
		});
		Soustraire6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client6 = false;
				Client6.setVisible(false);
				Ajouter6.setVisible(true);
				Soustraire6.setVisible(false);
			}

		});

		// Cration d'un groupe de bouton. Cela permet a un seul client d'ettre traite a la fois.
		
		ButtonGroup groupeClients = new ButtonGroup();
		groupeClients.add(Client1);
		groupeClients.add(Client2);
		groupeClients.add(Client3);
		groupeClients.add(Client4);
		groupeClients.add(Client5);
		groupeClients.add(Client6);
		
		// Creation d'un bouton permettant de modifier la commande d'un client
		JButton btnModClients = new JButton("Commande client");
		btnModClients.setForeground(Color.BLACK);
		btnModClients.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnModClients.setBackground(new Color(50, 205, 50));
		btnModClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Client1.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client2.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client3.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client4.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client5.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				} else if (Client6.isSelected()) {
					dispose();
					new InterfaceB_1().setVisible(true);

				}
				
					// Fonction d'affichage de la commande du client. Remise a zero de parametres reutilises.
					
					InterfaceB_1.displayArticles(InterfaceB_1.contentPane,InterfaceB.clientChoisi.commande.size());									
					InterfaceB_1.posY = 100;
					InterfaceC.articlesChoisis.clear();
			}
		});
		btnModClients.setBounds(0, 151, 119, 71);
		DiviseurDroite.add(btnModClients);

		BtnPayement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showOptionDialog(contentPane,
					      "Voulez-vous imprimer le reçu?", 
					      "Reçu?", 
					      JOptionPane.YES_NO_OPTION, 
					      JOptionPane.QUESTION_MESSAGE, 
					      null, null, null);
				if (choice == JOptionPane.YES_OPTION)
				  {
					clientChoisi.afficherCommande();
					clientChoisi.afficherCommandePopUp(contentPane);
				  }
				
			}});
		
		// Creation d'un background general
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(Interface.class.getResource("/imgs/FondClients.png")));
		Background.setBackground(new Color(220, 220, 220));
		Background.setBounds(0, 47, 728, 436);
		contentPane.add(Background);
		Background.setVisible(false);

	}
}
