import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class TrisPanel extends JPanel{
	
	private Cella[][] celle;

	public TrisPanel() {
		this.celle = new Cella[3][3];

		this.setLayout(new GridLayout(3,3));
		
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
		boolean giocoContinua=true;

		for(int i=0; i < celle.length; i++) {
			for(int j=0; j < celle[i].length; j++) {
				if(!celle[i][j].getText().equals("")) {
					
					//orrizzontali
					try {
						if(celle[i][j].getText().equals(celle[i][j-1].getText()) && celle[i][j].getText().equals(celle[i][j+1].getText())) {
							giocoContinua = false;
							break;
						}
					} catch(Exception e) {}
					
					//Verticali
					try {
						if(celle[i][j].getText().equals(celle[i-1][j].getText()) && celle[i][j].getText().equals(celle[i+1][j].getText())) {
							giocoContinua = false;
							break;
						}
					} catch(Exception e) {}
					
					//Diagonale normale
					try {
						if(celle[i][j].getText().equals(celle[i-1][j-1].getText()) && celle[i][j].getText().equals(celle[i+1][j+1].getText())) {
							giocoContinua = false;
							break;
						}
					} catch(Exception e) {}
					
					//Diagonale inversa
					try {
						if(celle[i][j].getText().equals(celle[i+1][j-1].getText()) && celle[i][j].getText().equals(celle[i-1][j+1].getText())) {
							giocoContinua = false;
							break;
						}
					} catch(Exception e) {}
				}
			}
			if(!giocoContinua) break;
		}
		
		return giocoContinua;
	}
	
	public String findWinner() {
		boolean find=false;
		String vincitore="";
		
		for(int i=0; i < celle.length; i++) {
			for(int j=0; j < celle[i].length; j++) {
				if(!celle[i][j].getText().equals("")) {
					
					//orrizzontali
					try {
						if(celle[i][j].getText().equals(celle[i][j-1].getText()) && celle[i][j].getText().equals(celle[i][j+1].getText())) {
							find = true;
							vincitore = celle[i][j].getText();
							break;
						}
					} catch(Exception e) {}
					
					//Verticali
					try {
						if(celle[i][j].getText().equals(celle[i-1][j].getText()) && celle[i][j].getText().equals(celle[i+1][j].getText())) {
							vincitore = celle[i][j].getText();
							find = true;
							break;
						}
					} catch(Exception e) {}
					
					//Diagonale normale
					try {
						if(celle[i][j].getText().equals(celle[i-1][j-1].getText()) && celle[i][j].getText().equals(celle[i+1][j+1].getText())) {
							vincitore = celle[i][j].getText();
							find = true;
							break;
						}
					} catch(Exception e) {}
					
					//Diagonale inversa
					try {
						if(celle[i][j].getText().equals(celle[i+1][j-1].getText()) && celle[i][j].getText().equals(celle[i-1][j+1].getText())) {
							vincitore = celle[i][j].getText();
							find = true;
							break;
						}
					} catch(Exception e) {}
				}
			}
			if(find) break;
		}
		return vincitore;
	}
	
	public void gameStops() {
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
