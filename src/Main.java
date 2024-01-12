import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		try {			
			Gioco g = new Gioco("Tris");
			g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			g.setBounds(200,100,500,600);
			
			g.setVisible(true);
			
		
		} catch(Exception e) {
			
			new ErrorFrame("Error:\n"+e.getMessage());
			
		}
		
	}
}