package Source;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Alert extends JFrame implements ActionListener {

	JButton back=new JButton("Back");
	JLabel label=new JLabel("BLOOD BANK");
	
	JButton smsd=new JButton("Inspire Donar");
	JButton smsa=new JButton("Acceptor Assigned");
	
	
	public Alert() {
		// TODO Auto-generated constructor stub
		
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Add Donar-Blood Bank");
		this.getContentPane().setBackground(Color.white);
		this.setLayout(null);
		
		
		back.setBounds(20, 20, 80, 30);
		back.setBackground(Color.white);
		back.setFocusable(false);
		back.setForeground(Color.black);
		back.setOpaque(true);
		back.addActionListener(this);
		
		
		label.setBounds(270,50,300,50);
		label.setBackground(Color.white);
		label.setForeground(Color.black);
		label.setFont(new Font("Ariel",Font.ROMAN_BASELINE,45));
		label.setOpaque(true);
		
		
		
		smsd.setBounds(130, 350, 200, 50);
		smsd.setFocusable(false);
		smsd.setFont(new Font("Comic Sans",Font.BOLD,14));
		smsd.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		smsd.setForeground(Color.white);
		smsd.setBackground(Color.black);
		smsd.setOpaque(true);
		smsd.addActionListener(this);
		
		
		smsa.setBounds(450, 350, 200, 50);
		smsa.setFocusable(false);
		smsa.setFont(new Font("Comic Sans",Font.BOLD,14));
		smsa.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		smsa.setForeground(Color.white);
		smsa.setBackground(Color.black);
		smsa.setOpaque(true);
		smsa.addActionListener(this);
		
		
		
		
		
		
		
		this.add(back);
		this.add(label);
		this.add(smsd);
		this.add(smsa);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		if(e.getSource()==back) {
			this.dispose();
			new Frame();
		}
		if(e.getSource()==smsd) {
			JOptionPane.showMessageDialog(null, "Sending Message...","SMS ALERT",JOptionPane.PLAIN_MESSAGE);

			
			
			 try
		        {

		            Process process = Runtime.getRuntime().exec("python D:\\JAVA\\DBMS\\sms_3month.py");
	
		        }
		        catch (IOException g) 
		        { 
		            g.printStackTrace(); 
		        } 
			
			
			
		}
		if(e.getSource()==smsa) {
			JOptionPane.showMessageDialog(null, "Sending Message...","SMS ALERT",JOptionPane.PLAIN_MESSAGE);
			
			try
	        {

	            Process process = Runtime.getRuntime().exec("python D:\\JAVA\\DBMS\\sms_blood_used.py");
	           
	        }
	        catch (IOException g) 
	        { 
	            g.printStackTrace(); 
	        } 

			
			
		}
		
	}

}
