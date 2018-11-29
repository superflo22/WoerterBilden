import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI {

	private JFrame frame;
	private JTextField tfName1;
	private JTextField tfName2;
	Steuerung steuerung;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textAntwort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		steuerung = new Steuerung();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 464, 269);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(blackline);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 215, 134);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(blackline);

		JLabel lblNewLabel = new JLabel("Spieler 1");
		lblNewLabel.setBounds(5, 5, 84, 14);
		panel_1.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(15, 35, 46, 14);
		panel_1.add(lblName);

		tfName1 = new JTextField();
		tfName1.setBounds(70, 32, 135, 20);
		panel_1.add(tfName1);
		tfName1.setColumns(10);

		JLabel lblPunkte = new JLabel("Punkte");
		lblPunkte.setBounds(15, 85, 46, 14);
		panel_1.add(lblPunkte);

		JLabel lblPunkte1 = new JLabel("0");
		lblPunkte1.setBounds(93, 85, 46, 14);
		panel_1.add(lblPunkte1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(239, 11, 215, 134);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(blackline);

		JLabel lblSpieler = new JLabel("Spieler 2");
		lblSpieler.setBounds(5, 5, 94, 14);
		panel_2.add(lblSpieler);

		JLabel label = new JLabel("Name");
		label.setBounds(15, 35, 46, 14);
		panel_2.add(label);

		tfName2 = new JTextField();
		tfName2.setColumns(10);
		tfName2.setBounds(70, 32, 135, 20);
		panel_2.add(tfName2);

		JLabel label_1 = new JLabel("Punkte");
		label_1.setBounds(15, 85, 46, 14);
		panel_2.add(label_1);

		JLabel lblPunkte2 = new JLabel("0");
		lblPunkte2.setBounds(93, 85, 46, 14);
		panel_2.add(lblPunkte2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 156, 444, 57);
		panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(blackline);

		JLabel lblAusahlTyp = new JLabel("Auswahl Typ");
		lblAusahlTyp.setBounds(10, 11, 80, 14);
		panel_3.add(lblAusahlTyp);

		JRadioButton rdbtnLckenFllen = new JRadioButton("1: L\u00FCcken f\u00FCllen");
		buttonGroup.add(rdbtnLckenFllen);
		rdbtnLckenFllen.setBounds(20, 32, 168, 23);
		panel_3.add(rdbtnLckenFllen);

		final JRadioButton rdbtnBuchstabenfllen = new JRadioButton("2: Buchstabenf\u00FCllen");
		buttonGroup.add(rdbtnBuchstabenfllen);
		rdbtnBuchstabenfllen.setBounds(230, 32, 155, 23);
		panel_3.add(rdbtnBuchstabenfllen);

		JButton btnNewButton = new JButton("Starte neues Spiel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				steuerung.gedruecktStart(tfName1.getText(), tfName2.getText(), this.getModi()

				);
			}

			private int getModi() {
				if (rdbtnBuchstabenfllen.isSelected())
					return 1;
				else
					return 0;
			}
		});
		btnNewButton.setBounds(10, 224, 444, 31);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(20, 300, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblIstAmZug = new JLabel("ist am Zug");
		lblIstAmZug.setBounds(162, 300, 84, 14);
		frame.getContentPane().add(lblIstAmZug);
		
		JLabel lblAufgabe = new JLabel("Aufgabe:");
		lblAufgabe.setBounds(20, 351, 46, 14);
		frame.getContentPane().add(lblAufgabe);
		
		JLabel lblBildeEinWort = new JLabel("Bilde ein Wort aus:");
		lblBildeEinWort.setBounds(30, 376, 125, 14);
		frame.getContentPane().add(lblBildeEinWort);
		
		JLabel lblWort = new JLabel("WortLol");
		lblWort.setBounds(162, 376, 46, 14);
		frame.getContentPane().add(lblWort);
		
		JLabel lblDeineLsung = new JLabel("Deine L\u00F6sung ");
		lblDeineLsung.setBounds(31, 431, 90, 14);
		frame.getContentPane().add(lblDeineLsung);
		
		textAntwort = new JTextField();
		textAntwort.setBounds(131, 428, 147, 20);
		frame.getContentPane().add(textAntwort);
		textAntwort.setColumns(10);
		
		JButton btnFertig = new JButton("Fertig");
		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				steuerung.zugFertig(textAntwort.getText());
			}
		});
		btnFertig.setBounds(307, 427, 89, 23);
		frame.getContentPane().add(btnFertig);

	}
}
