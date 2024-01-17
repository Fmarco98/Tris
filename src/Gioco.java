import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Gioco extends JFrame {
	
	//variabili globali
	public static final Font FONT = new Font("Aria Black", Font.BOLD, 60); 
	public static final Color X = new Color(255, 0, 0);
	public static final Color O = new Color(0, 0, 255);
	
	//Istanza di se stesso
	private static Gioco self;
	
	//Attributi
	private  int turno=0;
	private TrisPanel trisPanel;
	private ActivitiesTextArea textArea;
	
	//Costruttore
	public Gioco() throws MalformedURLException, IOException {
		super("Tris");
		self = this;
		
		//Allocazione delle due parti
		trisPanel = new TrisPanel();
		textArea = new ActivitiesTextArea();
		
		//Impostazione di layout
		this.pagina();
	}
	
	//Metodi getter
	public ActivitiesTextArea getTextArea() {
		return this.textArea;
	}
	public TrisPanel getTrisPanel() {
		return trisPanel;
	}
	public int getTurno() {
		return turno;
	}
	
	//Funzione dedicata all'impostazione del pagina grafica
	private void pagina() throws MalformedURLException, IOException {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Imposto l'Immagine ico.png
		//Image icon = Toolkit.getDefaultToolkit().getImage("icon/ico.png");
		BufferedImage icon = ImageIO.read(new URL("https://cdn.discordapp.com/attachments/786569980405612564/1195417703641514116/ico.png?ex=65b3ea7e&is=65a1757e&hm=fb431645d4ce8254d4051650d56649fc2cff6e4e9ed478d82a4496761b012dc3&"));
		this.setIconImage(icon);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		this.add(trisPanel, BorderLayout.CENTER);
		this.add(textArea, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	//metodo per il turno successivo
	public void nextTurno() {
		if(turno >= 8) {
			trisPanel.stopGame();
			textArea.printPatta();
		} else {			
			if(trisPanel.gameCanContinue()) {
				turno++;
				textArea.printTurno();
			} else {
				trisPanel.stopGame();
				textArea.printVincitore(trisPanel.findWinner());
			}
		}
	}
	
	//Metodo globale per ritornare il gioco sesso
	public static Gioco getIstance() {
		return self;
	}
}