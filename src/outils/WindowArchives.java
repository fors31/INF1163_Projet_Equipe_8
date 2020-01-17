package outils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class WindowArchives extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowArchives frame = new WindowArchives();
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
	public WindowArchives() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setForeground(Color.BLACK);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JPanel DiviseurDroite = new JPanel();
		DiviseurDroite.setBounds(727, 0, 119, 483);
		DiviseurDroite.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurDroite);
		DiviseurDroite.setLayout(null);

		// Creation d'un paneau qui contient des donnees relatives a l'utilisateur
		// actuel
		
		JPanel DiviseurHaut = new JPanel();
		DiviseurHaut.setBounds(0, 0, 728, 48);
		DiviseurHaut.setBackground(new Color(128, 128, 128));
		contentPane.add(DiviseurHaut);
		DiviseurHaut.setLayout(null);

		JPanel PaneauUtilisateur = new JPanel();
		PaneauUtilisateur.setBounds(0, 0, 119, 47);
		DiviseurDroite.add(PaneauUtilisateur);
		PaneauUtilisateur.setBackground(Color.YELLOW);
		PaneauUtilisateur.setLayout(null);

		// Creation d'un Label qui affiche ces informations

		JLabel boxUtilisateur = new JLabel("Utilisateur");
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
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRetour.setBackground(new Color(0, 0, 128));
		btnRetour.setBounds(7, 11, 94, 29);
		btnRetour.setBorder(null);
		DiviseurHaut.add(btnRetour);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 59, 100, 25);
		contentPane.add(panel);
		
		JLabel lblArticle = new JLabel("Article");
		panel.add(lblArticle);
		
		JLabel lblSalade = new JLabel("Salade");
		lblSalade.setBounds(20, 95, 90, 14);
		contentPane.add(lblSalade);
		
		JLabel lblSoupe = new JLabel("Soupe");
		lblSoupe.setBounds(20, 120, 90, 14);
		contentPane.add(lblSoupe);
		
		JLabel lblBruschetta = new JLabel("Bruschetta");
		lblBruschetta.setBounds(20, 145, 90, 14);
		contentPane.add(lblBruschetta);
		
		JLabel lblNewLabel_1 = new JLabel("Saumon");
		lblNewLabel_1.setBounds(20, 170, 90, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPoulet = new JLabel("Poulet");
		lblPoulet.setBounds(20, 195, 90, 14);
		contentPane.add(lblPoulet);
		
		JLabel lblBlt = new JLabel("BLT");
		lblBlt.setBounds(20, 220, 90, 14);
		contentPane.add(lblBlt);
		
		JLabel lblTofu = new JLabel("Tofu");
		lblTofu.setBounds(20, 245, 90, 14);
		contentPane.add(lblTofu);
		
		JLabel lblSpaghetti = new JLabel("Spaghetti");
		lblSpaghetti.setBounds(20, 270, 90, 14);
		contentPane.add(lblSpaghetti);
		
		JLabel lblRisotto = new JLabel("Risotto");
		lblRisotto.setBounds(20, 295, 90, 14);
		contentPane.add(lblRisotto);
		
		JLabel lblHomard = new JLabel("Homard");
		lblHomard.setBounds(20, 320, 90, 14);
		contentPane.add(lblHomard);
		
		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setBounds(20, 345, 90, 14);
		contentPane.add(lblBurger);
		
		JLabel lblCafe = new JLabel("Cafe");
		lblCafe.setBounds(20, 370, 90, 14);
		contentPane.add(lblCafe);
		
		JLabel lblSoda = new JLabel("Soda");
		lblSoda.setBounds(20, 395, 90, 14);
		contentPane.add(lblSoda);
		
		JLabel lblLimonade = new JLabel("Limonade");
		lblLimonade.setBounds(20, 421, 90, 14);
		contentPane.add(lblLimonade);
		
		JLabel lblThe = new JLabel("The");
		lblThe.setBounds(20, 446, 90, 14);
		contentPane.add(lblThe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(209, 59, 100, 25);
		contentPane.add(panel_1);
		
		JLabel lblQuantite = new JLabel("Quantite");
		panel_1.add(lblQuantite);
		
		JLabel QTSALADE = new JLabel(""+Article.Salade.quantite);
		QTSALADE.setBackground(Color.DARK_GRAY);
		QTSALADE.setBounds(234, 95, 46, 14);
		contentPane.add(QTSALADE);
		
		JLabel QTSOUPE = new JLabel(""+Article.Salade.quantite);
		QTSOUPE.setBackground(Color.DARK_GRAY);
		QTSOUPE.setBounds(234, 120, 46, 14);
		contentPane.add(QTSOUPE);
		
		JLabel QTBRUSCHETTA = new JLabel(""+Article.Bruschetta.quantite);
		QTBRUSCHETTA.setBackground(Color.DARK_GRAY);
		QTBRUSCHETTA.setBounds(234, 145, 46, 14);
		contentPane.add(QTBRUSCHETTA);
		
		JLabel QTSAUMON = new JLabel(""+Article.Saumon.quantite);
		QTSAUMON.setBackground(Color.DARK_GRAY);
		QTSAUMON.setBounds(234, 170, 46, 14);
		contentPane.add(QTSAUMON);
		
		JLabel QTPOULET = new JLabel(""+Article.Poulet.quantite);
		QTPOULET.setBackground(Color.DARK_GRAY);
		QTPOULET.setBounds(234, 195, 46, 14);
		contentPane.add(QTPOULET);
		
		JLabel QTBLT = new JLabel(""+Article.BLT.quantite);
		QTBLT.setBackground(Color.DARK_GRAY);
		QTBLT.setBounds(234, 220, 46, 14);
		contentPane.add(QTBLT);
		
		JLabel QTTOFU = new JLabel(""+Article.Tofu.quantite);
		QTTOFU.setBackground(Color.DARK_GRAY);
		QTTOFU.setBounds(234, 245, 46, 14);
		contentPane.add(QTTOFU);
		
		JLabel QTSPAGHETTI = new JLabel(""+Article.Spaghetti.quantite);
		QTSPAGHETTI.setBackground(Color.DARK_GRAY);
		QTSPAGHETTI.setBounds(234, 270, 46, 14);
		contentPane.add(QTSPAGHETTI);
		
		JLabel QTRISOTTO = new JLabel(""+Article.Risotto.quantite);
		QTRISOTTO.setBackground(Color.DARK_GRAY);
		QTRISOTTO.setBounds(234, 295, 46, 14);
		contentPane.add(QTRISOTTO);
		
		JLabel QTHOMARD = new JLabel(""+Article.Homard.quantite);
		QTHOMARD.setBackground(Color.DARK_GRAY);
		QTHOMARD.setBounds(234, 320, 46, 14);
		contentPane.add(QTHOMARD);
		
		JLabel QTBURGER = new JLabel(""+Article.Burger.quantite);
		QTBURGER.setBackground(Color.DARK_GRAY);
		QTBURGER.setBounds(234, 345, 46, 14);
		contentPane.add(QTBURGER);
		
		JLabel QTCAFE = new JLabel(""+Article.Cafe.quantite);
		QTCAFE.setBackground(Color.DARK_GRAY);
		QTCAFE.setBounds(234, 370, 46, 14);
		contentPane.add(QTCAFE);
		
		JLabel QTSODA = new JLabel(""+Article.Soda.quantite);
		QTSODA.setBackground(Color.DARK_GRAY);
		QTSODA.setBounds(234, 395, 46, 14);
		contentPane.add(QTSODA);
		
		JLabel QTLIMONADE = new JLabel(""+Article.Limonade.quantite);
		QTLIMONADE.setBackground(Color.DARK_GRAY);
		QTLIMONADE.setBounds(234, 420, 46, 14);
		contentPane.add(QTLIMONADE);
		
		JLabel QTTHE = new JLabel(""+Article.The.quantite);
		QTTHE.setBackground(Color.DARK_GRAY);
		QTTHE.setBounds(234, 445, 46, 14);
		contentPane.add(QTTHE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(483, 181, 176, 116);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTotalDesVentes = new JLabel("Total des ventes");
		lblTotalDesVentes.setBounds(10, 5, 156, 14);
		lblTotalDesVentes.setOpaque(true);
		lblTotalDesVentes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblTotalDesVentes);
		
		JLabel lblNewLabel_2 = new JLabel(""+(Archives.getTotal()));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(25, 41, 125, 51);
		panel_2.add(lblNewLabel_2);
		
		
		
		
		
		
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("RETOUR")) {
					dispose();
					Interface.btnsClients = false;

					new Interface().setVisible(true);
				}

			}
		});
		System.out.println(Article.Soupe.quantite);
	}
}
