package anagramma.model;

import java.io.IOException;

import anagramma.control.Controller;
import anagramma.view.GUI;

public class StartAnagrammi {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			GUI gui = new GUI();
			Controller ctrl = new Controller(gui, new Anagramma("parole.data"));
			gui.setVisible(true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
