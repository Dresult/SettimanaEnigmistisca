package anagramma.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import anagramma.model.Anagramma;
import anagramma.view.GUI;

public class Controller {
	private GUI guiAnag;
	private Anagramma anag;
	private int clic;
	
	public Controller(GUI guiAnag, Anagramma anag) {
		clic=0;
		this.anag=anag;
		guiAnag.getAnagramma().setText(anag.getAnagramma());
		this.guiAnag=guiAnag;
		initComponents();
	}
	
	public void initComponents() {
		
		ActionListener act1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(guiAnag.getTesto().getText().trim().toLowerCase().equals(anag.getSoluzione().toLowerCase())) {
					clic++;
					guiAnag.getRisultato().setForeground(Color.GREEN);
					guiAnag.getRisultato().setText("Risposta corretta! Ecco un'altra parola da indovinare...");
					guiAnag.getAnagramma().setText(anag.getAnagramma());
					anag.setPunteggio(clic);
					guiAnag.getP().setText(anag.getPunteggio());
					clic=0;
				}else {
					guiAnag.getRisultato().setForeground(Color.RED);
					guiAnag.getRisultato().setText("Risposta sbagliata! Prova ancora...");
					clic++;
				}
			}	
		};
		guiAnag.getVerifica().addActionListener(act1);
		
		ActionListener act2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Mi arrendo! :(")) {
					guiAnag.getRisultato().setText(anag.getSoluzione());
					guiAnag.getRisultato().setForeground(Color.GRAY);
					guiAnag.getAnagramma().setText(anag.getAnagramma());
				
				}
			
			}
		};
		guiAnag.getResa().addActionListener(act2);
		
		FocusListener foc1 = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				guiAnag.getTesto().setText("");
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
			
		};
		guiAnag.getTesto().addFocusListener(foc1);
	}
}
