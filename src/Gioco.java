import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Gioco extends JFrame {
	public static final Font FONT = new Font("Aria Black", Font.BOLD, 60); 
	public static final Color X = new Color(255, 0, 0);
	public static final Color O = new Color(0, 0, 255);
	
	private  int turno=0;
	private TrisPanel trisPanel;
	private ActivitiesTextArea textArea;
	
	private static Gioco self;
	
	public Gioco(String title) {
		super(title);
		self = this;
		
		trisPanel = new TrisPanel();
		textArea = new ActivitiesTextArea();
		
		this.pagina();
	}
	
	public int getTurno() {
		return turno;
	}
	
	private void pagina() {
		
		//Imposto l'Immagine ico.png
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./ico.png")));
		
		this.getContentPane().setLayout(new BorderLayout());
		
		this.add(trisPanel, BorderLayout.CENTER);
		this.add(textArea, BorderLayout.SOUTH);
	}
	
	public void nextTurno() {
		if(turno >= 8) {
			trisPanel.gameStops();
			textArea.printPatta();
		} else {			
			if(trisPanel.gameCanContinue()) {
				turno++;
				textArea.printTurno();
			} else {
				trisPanel.gameStops();
				textArea.printVincitore(trisPanel.findWinner());
			}
		}
	}
	
	public static Gioco getIstance() {
		return self;
	}
}