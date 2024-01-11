
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cella extends JButton{
	
	public Cella() {
		super("");
		this.setFont(Gioco.FONT);
		
		this.funzione();
	}
	
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
