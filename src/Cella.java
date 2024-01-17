
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cella extends JButton{
	
	//Costruttore
	public Cella() {
		super("");
		this.setFont(Gioco.FONT);
		
		this.funzione();
	}
	
	//Funzione dedicata alla scrittura delle operazione del pulsante
	private void funzione() {
		Cella c = this;
		
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if((Gioco.getIstance().getTurno()%2)==0) {
					c.setText("X");
				} else {
					c.setText("O");					
				}
				c.setEnabled(false);
			
				Gioco.getIstance().nextTurno();
			}
		});
	}
}
