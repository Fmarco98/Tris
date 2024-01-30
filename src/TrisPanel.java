import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class TrisPanel extends JPanel{
	
	//Matrice di celle
	private Cella[][] celle;

	public TrisPanel() {
		//Layout a griglia di 3x3
		this.setLayout(new GridLayout(3,3));
		
		//Allocazione e inserimento delle celle
		this.celle = new Cella[3][3];
		for(int i=0; i < celle.length; i++) {			
			for(int j=0; j < celle[i].length; j++) {
				celle[i][j] = new Cella();

				this.add(celle[i][j]);
			}
		}
	}
	//Metodi getter e setter 
	public Cella[][] getCelle() {
		return celle;
	}
	public void setCelle(Cella[][] celle) {
		this.celle = celle;
	}
	
	//Metodo per vedere se il gioco può continuare
	public boolean gameCanContinue() {
		//Controllo se esiste un vincitore
		if(this.findWinner() == null) {
			return true;
		}
		return false;
	}
	
	//Metodo per trovare chi ha vinto fra X o O
	public String findWinner() {
		
		//controllo solo se turno ha superato il 4, quindi sono stati fatti 5 turni
		if(Gioco.getIstance().getTurno() >= 4) {
			String vincitore = "";
			boolean b;
			
			//Controllo orrizzontale
			for(int i=0; i < celle.length; i++) {
				vincitore = celle[i][0].getText();
				b=true;
				for(int j=1; j < celle[i].length; j++) {
					if(!celle[i][j].getText().equals(vincitore)) {
						b=false;
					}
				}
				if(b && !vincitore.equals("")) {
					return vincitore;
				}
			}
			
			//Controllo verticale
			for(int i=0; i < celle.length; i++) {
				vincitore = celle[0][i].getText();
				b=true;
				for(int j=1; j < celle[i].length; j++) {
					if(!celle[j][i].getText().equals(vincitore)) {
						b=false;
					}
				}
				if(b && !vincitore.equals("")) {
					return vincitore;
				}
			}
			
			//controllo 1a diagonale
			vincitore = celle[0][0].getText();
			b=true;
			for(int i=1; i < celle.length; i++) {
				if(!celle[i][i].getText().equals(vincitore)) {
					b = false;
				}
			}
			if(b && !vincitore.equals("")) {
				return vincitore;
			}
			
			//controllo 2a diagonale
			vincitore = celle[0][2].getText();
			b=true;
			for(int i=1; i < celle.length; i++) {
				if(!celle[i][celle.length-1-i].getText().equals(vincitore)) {
					b = false;
				}
			}
			if(b && !vincitore.equals("")) {
				return vincitore;
			}
			
		}
		return null;
	}
	
	//Metodo per fermare il gioco
	public void stopGame() {
		//DIsabilito la possibilità di utilizzare gli pulsanti non utilizzati
		for(int i=0; i < celle.length; i++) {
			for(int j=0; j < celle[i].length; j++) {
				celle[i][j].setEnabled(false);
				if(celle[i][j].getText().equals("")) {
					celle[i][j].setBackground(Color.DARK_GRAY);
				}
			}
		}
	}
	
	
}
