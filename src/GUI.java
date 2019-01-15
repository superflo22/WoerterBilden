import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private Steuerung steuerung;
	private JTextField tfName1, tfName2, textAntwort;
	private JLabel lblAktSpieler, lblAufgabe, lblPunkte1, lblPunkte2;

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

	public GUI() {
		initialize();
		steuerung = new Steuerung(this);

	}

	void updateLbL(String aktuelerSpieler, String wortAufgabe) {
		lblAktSpieler.setText(aktuelerSpieler);
		lblAufgabe.setText(wortAufgabe);
		lblPunkte1.setText(String.valueOf(steuerung.spieler[0].getPunkte()));
		lblPunkte2.setText(String.valueOf(steuerung.spieler[1].getPunkte()));

	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 464, 269);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(blackline);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 11, 215, 90);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(blackline);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(238, 11, 215, 90);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(blackline);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.GRAY);
		panel_3.setBounds(10, 110, 444, 57);
		panel.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBorder(blackline);

		JLabel lblSpieler1 = new JLabel("Spieler 1");
		lblSpieler1.setBounds(5, 5, 84, 14);
		panel_1.add(lblSpieler1);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(15, 35, 46, 14);
		panel_1.add(lblName);

		tfName1 = new JTextField();
		tfName1.setBackground(Color.LIGHT_GRAY);
		tfName1.setBounds(70, 32, 135, 20);
		panel_1.add(tfName1);
		tfName1.setColumns(10);

		JLabel lblPunkte_1 = new JLabel("Punkte");
		lblPunkte_1.setBounds(15, 60, 46, 14);
		panel_1.add(lblPunkte_1);

		lblPunkte1 = new JLabel("0");
		lblPunkte1.setBounds(93, 60, 46, 14);
		panel_1.add(lblPunkte1);

		JLabel lblSpieler2 = new JLabel("Spieler 2");
		lblSpieler2.setBounds(5, 5, 94, 14);
		panel_2.add(lblSpieler2);

		JLabel lblName2 = new JLabel("Name");
		lblName2.setBounds(15, 35, 46, 14);
		panel_2.add(lblName2);

		tfName2 = new JTextField();
		tfName2.setBackground(Color.LIGHT_GRAY);
		tfName2.setColumns(10);
		tfName2.setBounds(70, 32, 135, 20);
		panel_2.add(tfName2);

		JLabel lblPunkte_2 = new JLabel("Punkte");
		lblPunkte_2.setBounds(15, 60, 46, 14);
		panel_2.add(lblPunkte_2);

		lblPunkte2 = new JLabel("0");
		lblPunkte2.setBounds(93, 60, 46, 14);
		panel_2.add(lblPunkte2);

		JLabel lblAusahlTyp = new JLabel("Auswahl Typ");
		lblAusahlTyp.setBounds(10, 11, 80, 14);
		panel_3.add(lblAusahlTyp);

		final JRadioButton rdbtnLckenFllen = new JRadioButton("1: L\u00FCcken f\u00FCllen");
		rdbtnLckenFllen.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnLckenFllen);
		rdbtnLckenFllen.setBounds(20, 32, 150, 23);
		panel_3.add(rdbtnLckenFllen);

		JRadioButton rdbtnBuchstabenfllen = new JRadioButton("2: Buchstabenf\u00FCllen");
		rdbtnBuchstabenfllen.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnBuchstabenfllen);
		rdbtnBuchstabenfllen.setBounds(250, 32, 150, 23);
		panel_3.add(rdbtnBuchstabenfllen);

		JButton btnNewButton = new JButton("Starte neues Spiel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int modi;
				if (rdbtnLckenFllen.isSelected())
					modi = 1;
				else
					modi = 2;

				steuerung.gedruecktStart(tfName1.getText(), tfName2.getText(), modi);
			}
		});
		btnNewButton.setBounds(10, 224, 444, 31);
		panel.add(btnNewButton);

		lblAktSpieler = new JLabel("SpielerName");
		lblAktSpieler.setBounds(94, 300, 84, 14);
		frame.getContentPane().add(lblAktSpieler);

		JLabel lblIstAmZug = new JLabel("am Zug");
		lblIstAmZug.setBounds(208, 300, 84, 14);
		frame.getContentPane().add(lblIstAmZug);

		JLabel lbltxtAufgabe = new JLabel("Aufgabe:");
		lbltxtAufgabe.setBounds(10, 320, 80, 14);
		frame.getContentPane().add(lbltxtAufgabe);

		JLabel lblBildeEinWort = new JLabel("Bilde ein Wort aus:");
		lblBildeEinWort.setBounds(20, 345, 108, 14);
		frame.getContentPane().add(lblBildeEinWort);

		lblAufgabe = new JLabel("WortAufgabe");
		lblAufgabe.setBounds(138, 345, 148, 14);
		frame.getContentPane().add(lblAufgabe);

		JLabel lblDeineLsung = new JLabel("Deine L\u00F6sung:");
		lblDeineLsung.setBounds(20, 374, 95, 14);
		frame.getContentPane().add(lblDeineLsung);

		textAntwort = new JTextField();
		textAntwort.setBackground(Color.LIGHT_GRAY);
		textAntwort.setBounds(115, 371, 160, 20);
		frame.getContentPane().add(textAntwort);
		textAntwort.setColumns(10);

		JButton btnFertig = new JButton("Fertig");
		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String antwort;
				antwort = textAntwort.getText();
				textAntwort.setText("");
				steuerung.zugFertig(antwort);
			}
		});
		btnFertig.setBounds(291, 370, 89, 23);
		frame.getContentPane().add(btnFertig);

		JLabel lblSpieler_1 = new JLabel("Gerade ist");
		lblSpieler_1.setBounds(20, 300, 85, 14);
		frame.getContentPane().add(lblSpieler_1);

	}
}
