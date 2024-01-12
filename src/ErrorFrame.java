import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ErrorFrame extends JFrame{
	
	private String errorMsg;
	
	public ErrorFrame(String msg) {
		super("Error Message");
		this.errorMsg = msg;
		
		this.setBounds(300, 500, 400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		this.getContentPane().add(this.setMsgField(), BorderLayout.CENTER);
		this.getContentPane().add(this.setCloseButton(), BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	private JPanel setCloseButton() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		
		JButton b = new JButton("    Ok    ");
		b.setFocusable(false);
		
		ErrorFrame f = this;
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		
		p.add(b);
		return p;
	}
	
	private JTextArea setMsgField() {
		JTextArea txt = new JTextArea();
		
		txt.setText(errorMsg);
		txt.setEditable(false);
		txt.setFont(new Font("Arial", Font.PLAIN, 20));
		
		return txt;
	}
}
