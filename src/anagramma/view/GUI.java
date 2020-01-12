package anagramma.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private JLabel risultato, anagramma, p;
	private JTextField testo;
	private JButton verifica, resa;
	
	public GUI() {
		genGUI();
	}
	public void genGUI() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		setSize(350,230);
		setTitle("Settimana enigmistica");
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(toolkit.getImage(GUI.class.getResource("icon.png")));
		
		JPanel pannelloSup = new JPanel(new GridLayout(3,1));
		anagramma = new JLabel();
		anagramma.setBorder(BorderFactory.createTitledBorder("Anagramma"));
		pannelloSup.add(anagramma);
		risultato = new JLabel(" ");
		risultato.setBorder(BorderFactory.createTitledBorder("Risultato"));
		pannelloSup.add(risultato);
		testo = new JTextField();
		testo.setBorder(BorderFactory.createTitledBorder("Prova a risolverlo:"));
		pannelloSup.add(testo);
		
		add(pannelloSup, BorderLayout.NORTH);

		JPanel southPanel = new JPanel(new GridLayout(2,1));
		JPanel buttonPanel = new JPanel(new FlowLayout());
		verifica = new JButton("Verifica");
		buttonPanel.add(verifica);
		resa = new JButton("Mi arrendo! :(");
		buttonPanel.add(resa);
		
		southPanel.add(buttonPanel);
		JPanel label = new JPanel(new FlowLayout());
		JLabel punt = new JLabel("Punteggio: ");
		p = new JLabel("0");
		label.add(punt);
		label.add(p);
		southPanel.add(label);
		
		
		add(southPanel, BorderLayout.SOUTH);
	}
	public JLabel getRisultato() {
		return risultato;
	}
	public JLabel getAnagramma() {
		return anagramma;
	}
	public JTextField getTesto() {
		return testo;
	}
	public JButton getVerifica() {
		return verifica;
	}
	public JButton getResa() {
		return resa;
	}
	public JLabel getP() {
		return p;
	}

}
