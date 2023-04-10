package Source;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Panel1 extends JPanel {

	public Panel1() throws InterruptedException {
		// TODO Auto-generated constructor stub
		JProgressBar bar=new JProgressBar();
		
		
		
		this.setSize(400,300);
		this.setBackground(Color.pink);
		
		
		bar.setBounds(0,250,400,50);
		
		bar.setValue(35);
		bar.setStringPainted(true);
		
		
		
		
		
		this.add(bar);
		
		
		
		
		
		
	}

}
