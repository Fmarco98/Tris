import java.awt.Color;

import javax.swing.JTextField;

public class ActivitiesTextArea extends JTextField{
	
	public ActivitiesTextArea() {
		this.setEditable(false);
		this.setFont(Gioco.FONT);
		this.setHorizontalAlignment(JTextField.CENTER);
		
		this.setText("Turno di: X");
		this.setBackground(Gioco.X);
	}
	
	public void printTurno() {
		char turno=' ';
		if((Gioco.getIstance().getTurno() % 2)==0){
			turno = 'X';
			this.setBackground(Gioco.X);
		} else {
			turno = 'O';
			this.setBackground(Gioco.O);
		}
	
		this.setText("Turno di: "+ turno);
	}
	
	public void printVincitore(String vincitore) {
		this.setText("VINCITORE: "+ vincitore);
		this.setBackground(new Color(205, 164, 52));
	}
	
	public void printPatta() {
		this.setText("PAREGGIO");
		this.setBackground(Color.GRAY);
	}
}
