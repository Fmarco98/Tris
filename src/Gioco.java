import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Gioco extends JFrame {
	public static final Font FONT = new Font("Aria Black", Font.BOLD, 60); 
	public static final Color X = new Color(255, 0, 0);
	public static final Color O = new Color(0, 0, 255);
	
	private  int turno=0;
	private TrisPanel trisPanel;
	private ActivitiesTextArea textArea;
	
	private static Gioco self;
	
	public Gioco(String title) throws MalformedURLException, IOException {
		super(title);
		self = this;
		
		trisPanel = new TrisPanel();
		textArea = new ActivitiesTextArea();
		
		this.pagina();
	}
	
	public int getTurno() {
		return turno;
	}
	
	private void pagina() throws MalformedURLException, IOException {
		
		//Imposto l'Immagine ico.png
		BufferedImage icon = ImageIO.read(new URL("https://cdn.discordapp.com/attachments/786569980405612564/1195417703641514116/ico.png?ex=65b3ea7e&is=65a1757e&hm=fb431645d4ce8254d4051650d56649fc2cff6e4e9ed478d82a4496761b012dc3&"));
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./ico.png")));
		this.setIconImage(icon);
		
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