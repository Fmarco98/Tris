import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		try {
			//Frame di gioco
			Gioco g = new Gioco();
			g.setBounds(200,100,500,600);
		} catch(Exception e) {
			//Frame pop-up per mostrare l'errore
			new ErrorFrame("Error:\n"+e.getMessage());
		}
	}
}