package anagramma.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Anagramma {
	private ArrayList<String> arrayParole;
	private String soluzione;
	private Integer punteggio;
	
	public Anagramma(String nomeFile) throws IOException {
		arrayParole = new ArrayList<>();
		popolaArray(nomeFile);
		punteggio=0;
	}
	
	public String getAnagramma() {
		int random = (int)(Math.random()*arrayParole.size());
		soluzione = arrayParole.get(random);
		char[] parola = soluzione.toCharArray();
		
		StringBuilder p = new StringBuilder();
		for(int i=0; i<parola.length; i++) {
			int ran = (int)(i+Math.random()*(parola.length-i));
			scambia(i, ran, parola);
			p.append(parola[i]);
		}
		return p.toString();
	}
	
	private void scambia(int i, int ran, char[] array) {
		char tmp = array[i];
		array[i]=array[ran];
		array[ran]=tmp;
	}

	public String getSoluzione() {
		return soluzione;
	}
	
	public void popolaArray(String nomeFile) throws IOException {
		BufferedReader inFile = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(nomeFile)));
		String riga;
		while((riga=inFile.readLine())!=null) {
			arrayParole.add(riga);
		}
		inFile.close();
		arrayParole.trimToSize();
	}

	public String getPunteggio() {
		return punteggio.toString();
	}

	public void setPunteggio(int clic) {
		if(clic==1)
			punteggio += 5;
		else if(clic==2)
			punteggio +=3;
		else
			punteggio +=1;
	}
	
	
}
