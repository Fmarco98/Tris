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
		
		//Ricerca del vincitore
		for(int i=0; i < celle.length; i++) {
			for(int j=0; j < celle[i].length; j++) {
				if(!celle[i][j].getText().equals("")) {
					
					//orrizzontali
					try {
						if(celle[i][j].getText().equals(celle[i][j-1].getText()) && celle[i][j].getText().equals(celle[i][j+1].getText())) {
							return celle[i][j].getText();
						}
					} catch(Exception e) {}
					
					//Verticali
					try {
						if(celle[i][j].getText().equals(celle[i-1][j].getText()) && celle[i][j].getText().equals(celle[i+1][j].getText())) {
							return celle[i][j].getText();
						}
					} catch(Exception e) {}
					
					//Diagonale normale
					try {
						if(celle[i][j].getText().equals(celle[i-1][j-1].getText()) && celle[i][j].getText().equals(celle[i+1][j+1].getText())) {
							return celle[i][j].getText();
						}
					} catch(Exception e) {}
					
					//Diagonale inversa
					try {
						if(celle[i][j].getText().equals(celle[i+1][j-1].getText()) && celle[i][j].getText().equals(celle[i-1][j+1].getText())) {
							return celle[i][j].getText();
						}
					} catch(Exception e) {}
				}
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
