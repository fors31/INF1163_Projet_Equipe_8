/* @class InterfaceC
 * 
 * Il s'agit de l'interface qui sert a ajouter des articles a la commande d'un client.
 * Les articles sont representes par des boutons. Ceux selectionnes seront ajoutes a 
 * la commande du client selectionne plus tot.
 */

package outils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTable;

public class InterfaceC extends JFrame {

	private JPanel contentPane;
	
	
	protected static ArrayList<Article> articlesChoisis = new ArrayList<Article>();  //Liste des articles a ajouter a la commande du client	
	
	// Fonction non appliquée pour l'instant
	
	public void retirerArticle(String s)
	{
		for(int i = 0; i < articlesChoisis.size()+1; i++)
		{
			if(articlesChoisis.get(i).nom.equals(s))
			{
				articlesChoisis.remove(i);
			}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceC frame = new InterfaceC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceC() {
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

		// Creation du bouton Retour qui amene l'utlisateur a l'interface B.

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

					new InterfaceB_1().setVisible(true);
				}

			}
		});
		
		/*
		 *  Menu. Chaque article du menu selectionne sera ajoute a la commande du client lors de
		 *  l'appui du bouton confirmer.
		 */

		JCheckBoxMenuItem menuSalade = new JCheckBoxMenuItem("Salade");
		menuSalade.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuSalade.setBounds(10, 121, 133, 24);
		contentPane.add(menuSalade);
		menuSalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuSalade.isSelected()) {
					menuSalade.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Salade);
				} else {
					menuSalade.setBackground(null);
					retirerArticle("Salade");					
				}
			}

		});

		JCheckBoxMenuItem menuSoupe = new JCheckBoxMenuItem("Soupe");
		menuSoupe.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuSoupe.setBounds(10, 194, 133, 24);
		contentPane.add(menuSoupe);
		menuSoupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuSoupe.isSelected()) {
					menuSoupe.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Soupe);
				} else {
					menuSoupe.setBackground(null);
					retirerArticle("Soupe");
				}
			}

		});

		JCheckBoxMenuItem menuBruschetta = new JCheckBoxMenuItem("Bruschetta");
		menuBruschetta.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBruschetta.setBounds(10, 270, 133, 24);
		contentPane.add(menuBruschetta);
		menuBruschetta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuBruschetta.isSelected()) {
					menuBruschetta.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Bruschetta);
				} else {
					menuBruschetta.setBackground(null);
					retirerArticle("Bruschetta");
				}
			}

		});

		JCheckBoxMenuItem MenuSaumon = new JCheckBoxMenuItem("Saumon aux herbes");
		MenuSaumon.setFont(new Font("Tahoma", Font.BOLD, 14));
		MenuSaumon.setBounds(153, 121, 178, 24);
		contentPane.add(MenuSaumon);
		MenuSaumon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MenuSaumon.isSelected()) {
					MenuSaumon.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Saumon);
				} else {
					MenuSaumon.setBackground(null);
					retirerArticle("Saumon");
					
				}
			}

		});

		JCheckBoxMenuItem menuPoulet = new JCheckBoxMenuItem("Poulet au citon");
		menuPoulet.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuPoulet.setBounds(153, 194, 178, 24);
		contentPane.add(menuPoulet);
		menuPoulet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuPoulet.isSelected()) {
					menuPoulet.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Poulet);
				} else {
					menuPoulet.setBackground(null);
					retirerArticle("Poulet");
				}
			}

		});

		JCheckBoxMenuItem menuBLT = new JCheckBoxMenuItem("BLT");
		menuBLT.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBLT.setBounds(153, 270, 178, 24);
		contentPane.add(menuBLT);
		menuBLT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuBLT.isSelected()) {
					menuBLT.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.BLT);
				} else {
					menuBLT.setBackground(null);
					retirerArticle("BLT");
				}
			}

		});

		JCheckBoxMenuItem menuTofu = new JCheckBoxMenuItem("Tofu Frit");
		menuTofu.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuTofu.setBounds(153, 348, 178, 24);
		contentPane.add(menuTofu);
		menuTofu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuTofu.isSelected()) {
					menuTofu.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Tofu);
				} else {
					menuTofu.setBackground(null);
					retirerArticle("Tofu");
				}
			}

		});

		JCheckBoxMenuItem menuSpaghetti = new JCheckBoxMenuItem("Spaghetti a l'encre");
		menuSpaghetti.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuSpaghetti.setBounds(341, 121, 189, 24);
		contentPane.add(menuSpaghetti);
		menuSpaghetti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuSpaghetti.isSelected()) {
					menuSpaghetti.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Spaghetti);
				} else {
					menuSpaghetti.setBackground(null);
					retirerArticle("Spaghetti");
				}
			}

		});

		JCheckBoxMenuItem menuRisotto = new JCheckBoxMenuItem("Risotto aux Champignons");
		menuRisotto.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuRisotto.setBounds(341, 194, 218, 24);
		contentPane.add(menuRisotto);
		menuRisotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuRisotto.isSelected()) {
					menuRisotto.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Risotto);
				} else {
					menuRisotto.setBackground(null);
					retirerArticle("Risotto");
				}
			}

		});

		JCheckBoxMenuItem menuHomard = new JCheckBoxMenuItem("Assiette Homard");
		menuHomard.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuHomard.setBounds(341, 270, 179, 24);
		contentPane.add(menuHomard);
		menuHomard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuHomard.isSelected()) {
					menuHomard.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Homard);
				} else {
					menuHomard.setBackground(null);
					retirerArticle("Homard");
				}
			}

		});

		JCheckBoxMenuItem menuBurger = new JCheckBoxMenuItem("Burger Vege");
		menuBurger.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuBurger.setBounds(341, 348, 179, 24);
		contentPane.add(menuBurger);
		menuBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuBurger.isSelected()) {
					menuBurger.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Burger);
				} else {
					menuBurger.setBackground(null);
					retirerArticle("Burger");
				}
			}

		});

		JCheckBoxMenuItem Cafe = new JCheckBoxMenuItem("Cafe");
		Cafe.setFont(new Font("Tahoma", Font.BOLD, 14));
		Cafe.setBounds(569, 121, 148, 24);
		contentPane.add(Cafe);
		Cafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Cafe.isSelected()) {
					Cafe.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Cafe);
				} else {
					Cafe.setBackground(null);
					retirerArticle("Cafe");
				}
			}

		});

		JCheckBoxMenuItem BoissonGazeuse = new JCheckBoxMenuItem("Boisson Gazeuse");
		BoissonGazeuse.setFont(new Font("Tahoma", Font.BOLD, 14));
		BoissonGazeuse.setBounds(569, 194, 153, 24);
		contentPane.add(BoissonGazeuse);
		BoissonGazeuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BoissonGazeuse.isSelected()) {
					BoissonGazeuse.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Soda);
				} else {
					BoissonGazeuse.setBackground(null);
					retirerArticle("Soda");
				}
			}

		});

		JCheckBoxMenuItem Limonade = new JCheckBoxMenuItem("Limonade");
		Limonade.setFont(new Font("Tahoma", Font.BOLD, 14));
		Limonade.setBounds(569, 270, 148, 24);
		contentPane.add(Limonade);
		Limonade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Limonade.isSelected()) {
					Limonade.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.Limonade);
				} else {
					Limonade.setBackground(null);
					retirerArticle("Limonade");
				}
			}

		});

		JCheckBoxMenuItem The = new JCheckBoxMenuItem("The");
		The.setFont(new Font("Tahoma", Font.BOLD, 14));
		The.setBounds(569, 348, 148, 24);
		contentPane.add(The);
		The.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (The.isSelected()) {
					The.setBackground(Color.LIGHT_GRAY);
					articlesChoisis.add(Article.The);
				} else {
					The.setBackground(null);
					retirerArticle("The");
				}
			}

		});

		// Creation du bouton annuler la commande, qui efface tout ce qu'il y a dans la
		// liste de la commande

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAnnuler.setBackground(new Color(50, 205, 50));
		btnAnnuler.setBounds(0, 359, 119, 52);
		DiviseurDroite.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("Annuler")) {
					menuSalade.setSelected(false);
					menuSoupe.setSelected(false);
					menuBruschetta.setSelected(false);
					MenuSaumon.setSelected(false);
					menuPoulet.setSelected(false);
					menuBLT.setSelected(false);
					menuTofu.setSelected(false);
					menuSpaghetti.setSelected(false);
					menuRisotto.setSelected(false);
					menuHomard.setSelected(false);
					menuBurger.setSelected(false);
					Cafe.setSelected(false);
					BoissonGazeuse.setSelected(false);
					Limonade.setSelected(false);
					The.setSelected(false);
					menuSalade.setBackground(null);
					menuSoupe.setBackground(null);
					menuBruschetta.setBackground(null);
					MenuSaumon.setBackground(null);
					menuPoulet.setBackground(null);
					menuSpaghetti.setBackground(null);
					menuRisotto.setBackground(null);
					menuHomard.setBackground(null);
					menuBurger.setBackground(null);
					Cafe.setBackground(null);
					BoissonGazeuse.setBackground(null);
					Limonade.setBackground(null);
					The.setBackground(null);
				}

			}

		});

		// Creation du bouton qui confirme le "panier" de la commande et qui retourne a
		// l'interface B_1

		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmer.setBackground(new Color(50, 205, 50));
		btnConfirmer.setBounds(0, 421, 119, 52);
		DiviseurDroite.add(btnConfirmer);
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("Confirmer")) {
					for(int i = 0; i < articlesChoisis.size(); i++) {
						articlesChoisis.get(i).quantite++;
					InterfaceB.clientChoisi.commande.add(articlesChoisis.get(i));
					}
					
					dispose();

					/*
					 *  Fonctions pour mettre a jour l'affichage de la commande du client. Remise a zero
					 *  de parametres qui seront reutilises pour d'autres clients.
					 */
					
					new InterfaceB_1().setVisible(true);				
					InterfaceB_1.displayArticles(InterfaceB_1.contentPane,InterfaceB.clientChoisi.commande.size());									
					InterfaceB_1.posY = 100;
					articlesChoisis.clear();
				}

			}
		});

		JButton btnModArticle = new JButton("Modifier Article");
		btnModArticle.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModArticle.setBackground(new Color(50, 205, 50));
		btnModArticle.setBounds(0, 150, 119, 52);
		DiviseurDroite.add(btnModArticle);


	}
}
