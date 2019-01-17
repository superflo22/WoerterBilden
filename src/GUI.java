import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI {

	private JFrame frame;
	private JPanel panel_3, panel_4;

	private JRadioButton rdbtnLckenFllen, rdbtnBuchstabenfllen;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private Steuerung steuerung;
	private JTextField tfName1, tfName2, textAntwort;
	private JLabel lblAktSpieler, lblAufgabe, lblPunkte1, lblPunkte2, lblMeldung;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					window.frame.setTitle("Wörter bilden");
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

	private void clickStart() {
		steuerung.gedruecktStart(tfName1.getText(), tfName2.getText());
	}
	
	private void clickFertig() {
		steuerung.gedruecktFertig(textAntwort.getText());
	}
	private void clickOk() {
		panel_3.setVisible(true);
		panel_4.setVisible(false);
		steuerung.gedruecktOK();
	}
	
	int gibSpielTyp() {
		final int modi;
		if (rdbtnLckenFllen.isSelected())modi = 1;
		else if (rdbtnBuchstabenfllen.isSelected())modi = 2;
		else modi = 0;

		return modi;
	}
	String leseLoesung() {
		return textAntwort.getText();
	}

	void anzeigenPunkte(int pPktSpieler1, int pPktSpieler2) {
		lblPunkte1.setText(String.valueOf(pPktSpieler1));
		lblPunkte2.setText(String.valueOf(pPktSpieler2));
	}

	void anzeigenAmZug(String aktuelerSpieler) {
		lblAktSpieler.setText(aktuelerSpieler);
	}
	void anzeigenMeldung(String Meldung) {
		panel_3.setVisible(false);
		panel_4.setVisible(true);

		lblMeldung.setText(Meldung);
	}

	void anzeigenAufgabe(String wortAufgabe) {
		lblAufgabe.setText(wortAufgabe);
	}

	void loescheLoeseung() {
		textAntwort.setText("");
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 500, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 464, 219);
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

		panel_4 = new JPanel();
		panel_4.setVisible(false);

		panel_3 = new JPanel();
		panel_3.setBounds(10, 112, 444, 97);
		panel.add(panel_3);
		panel_3.setBackground(Color.GRAY);
		panel_3.setBorder(blackline);
		panel_3.setLayout(null);

		JLabel lblAusahlTyp = new JLabel("Auswahl Typ");
		lblAusahlTyp.setBounds(10, 11, 80, 14);
		panel_3.add(lblAusahlTyp);

		rdbtnLckenFllen = new JRadioButton("1: L\u00FCcken f\u00FCllen");
		rdbtnLckenFllen.setBounds(20, 32, 150, 23);
		rdbtnLckenFllen.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnLckenFllen);
		panel_3.add(rdbtnLckenFllen);

		rdbtnBuchstabenfllen = new JRadioButton("2: Buchstabenpuzzle");
		rdbtnBuchstabenfllen.setBounds(250, 32, 150, 23);
		rdbtnBuchstabenfllen.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnBuchstabenfllen);
		panel_3.add(rdbtnBuchstabenfllen);

		JButton btnNewButton = new JButton("Starte neues Spiel");
		btnNewButton.setBounds(0, 66, 444, 31);
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickStart();
			}
		});
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(10, 112, 444, 55);
		panel.add(panel_4);
		panel_4.setLayout(null);

		lblMeldung = new JLabel("Meldung...");
		lblMeldung.setBounds(30, 11, 311, 33);
		panel_4.add(lblMeldung);
		lblMeldung.setBorder(blackline);

		JButton btnOK = new JButton("ok");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickOk();
			}
		});
		btnOK.setBounds(345, 16, 89, 23);
		panel_4.add(btnOK);

		lblAktSpieler = new JLabel("SpielerName");
		lblAktSpieler.setBounds(20, 241, 84, 14);
		frame.getContentPane().add(lblAktSpieler);

		JLabel lblIstAmZug = new JLabel("ist am Zug");
		lblIstAmZug.setBounds(148, 241, 84, 14);
		frame.getContentPane().add(lblIstAmZug);

		JLabel lbltxtAufgabe = new JLabel("Aufgabe:");
		lbltxtAufgabe.setBounds(10, 261, 80, 14);
		frame.getContentPane().add(lbltxtAufgabe);

		JLabel lblBildeEinWort = new JLabel("Bilde ein Wort aus:");
		lblBildeEinWort.setBounds(20, 286, 108, 14);
		frame.getContentPane().add(lblBildeEinWort);

		lblAufgabe = new JLabel("WortAufgabe");
		lblAufgabe.setBounds(138, 286, 148, 14);
		frame.getContentPane().add(lblAufgabe);

		JLabel lblDeineLsung = new JLabel("Deine L\u00F6sung:");
		lblDeineLsung.setBounds(20, 315, 95, 14);
		frame.getContentPane().add(lblDeineLsung);

		textAntwort = new JTextField();
		textAntwort.setBackground(Color.LIGHT_GRAY);
		textAntwort.setBounds(115, 312, 160, 20);
		frame.getContentPane().add(textAntwort);
		textAntwort.setColumns(10);

		JButton btnFertig = new JButton("Fertig");
		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clickFertig();
			}
		});
		btnFertig.setBounds(291, 311, 89, 23);
		frame.getContentPane().add(btnFertig);
	}
}
