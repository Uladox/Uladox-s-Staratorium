package Main;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Menu extends JFrame{

	public JButton AF;
	public Rectangle rAF;
	private JPanel window;
	public Menu(){
		setSize(600, 300);
		window = new JPanel();
		setContentPane(window);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawfeatures();
		this.setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		window.setLayout(null);
		setTitle("'Uladox's Staratorium");
	}
	public void drawfeatures(){
		AF = new JButton("Angle Finder");
		rAF = new Rectangle((600/2) - (150/2) + 250, 450, 150, 70);
		AF.setBounds(rAF);
		window.add(AF);
	
	AF.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			AngleFinder f = new AngleFinder();
			close();
		}
	});
		


	
	
	
	this.addWindowListener(new java.awt.event.WindowAdapter() {
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	        if (JOptionPane.showConfirmDialog(window, 
	            "Are you sure to close this window?", "Really Closing?", 
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	            System.exit(0);
	        }
	    }
	});
}
	
	
public void close(){
	this.dispose();
}
}

