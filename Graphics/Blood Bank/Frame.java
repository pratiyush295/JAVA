package Source;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Frame extends JFrame implements ActionListener{
	
	
	int winx=500,winy=600;
	
	JLabel label=new JLabel("Blood Bank");
	
	JButton add=new JButton();
	JButton book=new JButton();
	JButton ins=new JButton();
	JButton records=new JButton();

	
	JPanel panel1=new JPanel();

	public Frame() {
		// TODO Auto-generated constructor stub
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Blood Bank");
		this.getContentPane().setBackground(Color.gray);
		this.setLayout(null);
		this.setResizable(false);
		
		
		label.setForeground(Color.black);
		label.setOpaque(true);
		label.setBounds(270,50,300,50);
		label.setBackground(Color.cyan);
		label.setFont(new Font("Ariel",Font.ROMAN_BASELINE,45));
		
		
		add.setBounds(50, 350, 100, 50);
		add.setText("ADD DONAR");
		add.setFocusable(false);
		add.setFont(new Font("Comic Sans",Font.BOLD,11));
		add.setBorder(BorderFactory.createLineBorder(Color.white,2));
		add.setForeground(Color.white);
		add.setBackground(Color.black);
		add.setOpaque(true);
		add.addActionListener(this);
		
		
		
		book.setBounds(230, 350, 100, 50);
		book.setText("GET BLOOD");
		book.setFocusable(false);
		book.setFont(new Font("Comic Sans",Font.BOLD,12));
		book.setBorder(BorderFactory.createLineBorder(Color.white,2));
		book.setForeground(Color.white);
		book.setBackground(Color.black);
		book.setOpaque(true);
		book.addActionListener(this);
		
		
		
		records.setBounds(430, 350, 100, 50);
		records.setText("DATABASE");
		records.setFocusable(false);
		records.setFont(new Font("Comic Sans",Font.BOLD,12));
		records.setBorder(BorderFactory.createLineBorder(Color.white,2));
		records.setForeground(Color.white);
		records.setBackground(Color.black);
		records.setOpaque(true);
		records.addActionListener(this);
		
		
		
		
		ins.setBounds(630, 350, 100, 50);
		ins.setText("Alert ");
		ins.setFocusable(false);
		ins.setFont(new Font("Comic Sans",Font.BOLD,12));
		ins.setBorder(BorderFactory.createLineBorder(Color.white,2));
		ins.setForeground(Color.white);
		ins.setBackground(Color.black);
		ins.setOpaque(true);
		ins.addActionListener(this);

		
	
		panel1.setBounds(0, 0, 800, 700);
		panel1.setBackground(Color.CYAN);
		panel1.setLayout(null);
		
		panel1.add(add);
		panel1.add(book);
		panel1.add(label);
		panel1.add(ins);
		panel1.add(records);
		
		
		
		this.add(panel1);
		
	}
	public static void window() {
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		new Frame();
		
		
		

 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add) {
			//connects add button to Add class
			new Add();
			this.dispose();
		}
		if(e.getSource()==records) {
			new Record();
			this.dispose();
			
		}
		if(e.getSource()==ins) {
			this.dispose();
			new Alert();
		}
		if(e.getSource()==book) {
			this.dispose();
			new Book();
		}
		
	}

}
