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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private Steuerung steuerung;
	private JTextField tfName1;
	private JTextField tfName2;
	private JTextField textAntwort;
	private JLabel lblAktSpieler, lblAufgabe;
	
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
	
	void updateLbL(String aktuelerSpieler, String wortAufgabe){
		lblAktSpieler.setText(aktuelerSpieler);
		lblAufgabe.setText(wortAufgabe);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 450);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(239, 11, 215, 134);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(blackline);
	
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 156, 444, 57);
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
		tfName1.setBounds(70, 32, 135, 20);
		panel_1.add(tfName1);
		tfName1.setColumns(10);

		JLabel lblPunkte_1 = new JLabel("Punkte");
		lblPunkte_1.setBounds(15, 85, 46, 14);
		panel_1.add(lblPunkte_1);

		JLabel lblPunkte1 = new JLabel("0");
		lblPunkte1.setBounds(93, 85, 46, 14);
		panel_1.add(lblPunkte1);

		
		JLabel lblSpieler2 = new JLabel("Spieler 2");
		lblSpieler2.setBounds(5, 5, 94, 14);
		panel_2.add(lblSpieler2);

		JLabel lblName2 = new JLabel("Name");
		lblName2.setBounds(15, 35, 46, 14);
		panel_2.add(lblName2);

		tfName2 = new JTextField();
		tfName2.setColumns(10);
		tfName2.setBounds(70, 32, 135, 20);
		panel_2.add(tfName2);

		JLabel lblPunkte_2 = new JLabel("Punkte");
		lblPunkte_2.setBounds(15, 85, 46, 14);
		panel_2.add(lblPunkte_2);

		JLabel lblPunkte2 = new JLabel("0");
		lblPunkte2.setBounds(93, 85, 46, 14);
		panel_2.add(lblPunkte2);


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
				steuerung.gedruecktStart(tfName1.getText(), tfName2.getText(), rdbtnBuchstabenfllen.isSelected());
			}
		});
		btnNewButton.setBounds(10, 224, 444, 31);
		panel.add(btnNewButton);
		
		lblAktSpieler = new JLabel("SpielerNr");
		lblAktSpieler.setBounds(357, 300, 23, 14);
		frame.getContentPane().add(lblAktSpieler);
		
		JLabel lblIstAmZug = new JLabel("ist am Zug");
		lblIstAmZug.setBounds(390, 300, 84, 14);
		frame.getContentPane().add(lblIstAmZug);
		
		JLabel lbltxtAufgabe = new JLabel("Aufgabe:");
		lbltxtAufgabe.setBounds(10, 320, 80, 14);
		frame.getContentPane().add(lbltxtAufgabe);
		
		JLabel lblBildeEinWort = new JLabel("Bilde ein Wort aus:");
		lblBildeEinWort.setBounds(20, 345, 125, 14);
		frame.getContentPane().add(lblBildeEinWort);
		
		lblAufgabe = new JLabel("Aufgabe");
		lblAufgabe.setBounds(152, 345, 46, 14);
		frame.getContentPane().add(lblAufgabe);
		
		JLabel lblDeineLsung = new JLabel("Deine L\u00F6sung ");
		lblDeineLsung.setBounds(15, 374, 90, 14);
		frame.getContentPane().add(lblDeineLsung);
		
		textAntwort = new JTextField();
		textAntwort.setBounds(115, 371, 147, 20);
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
		
		JLabel lblSpieler_1 = new JLabel("Spieler");
		lblSpieler_1.setBounds(314, 300, 46, 14);
		frame.getContentPane().add(lblSpieler_1);

	}
}
