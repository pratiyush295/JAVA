package Source;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Record extends JFrame implements ActionListener{
	
	
	JButton back=new JButton("Back");
	JLabel label=new JLabel("DATABASE");
	JLabel name=new JLabel("Show Records For : ");
	
	JButton submit=new JButton("Show");
	
	
	JTextArea display=new JTextArea();
	
	String tables[]= {"Donor Database","Collector Database"};
	JComboBox table=new JComboBox(tables);
	
	

	public Record() {
		// TODO Auto-generated constructor stub
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Blood Bank");
		this.getContentPane().setBackground(Color.white);
		this.setLayout(null);
		this.setResizable(false);
		
		
		
		
		back.setBounds(20, 20, 80, 30);
		back.setBackground(Color.LIGHT_GRAY);
		back.setFocusable(false);
		back.setForeground(Color.black);
		back.setOpaque(true);
		back.addActionListener(this);
		back.setBorder(BorderFactory.createLineBorder(Color.black,2));
		
		
		label.setBounds(270,50,300,50);
		label.setBackground(Color.white);
		label.setForeground(Color.black);
		label.setFont(new Font("Ariel",Font.ROMAN_BASELINE,45));
		label.setOpaque(true);

		
		
		
		name.setBounds(80,200,200,20);
		name.setFont(new Font("Arial",Font.BOLD,20));
		
		table.setBounds(320,195,150,30);
		table.setBackground(Color.gray);
		
		
		submit.setBounds(560, 194, 100, 30);
		submit.setFocusable(false);
		submit.setFont(new Font("Comic Sans",Font.BOLD,12));
		submit.setBorder(BorderFactory.createLineBorder(Color.black,2));
		submit.setForeground(Color.white);
		submit.setBackground(Color.gray);
		submit.setOpaque(true);
		submit.addActionListener(this);
		
		
		
		display.setBounds(120,250,530,400);
		display.setLineWrap(true);
		display.setText("No Record");
		display.setBorder(BorderFactory.createLineBorder(Color.black,2));
//		display.setEditable(false);
		display.setFont(new Font("Arial",Font.BOLD,15));
		
		
		
		
		this.add(back);
		this.add(label);
		this.add(name);
		this.add(table);
		this.add(submit);
		this.add(display);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String url="jdbc:mysql://localhost:3306/pbl";
		String uname="root";
		String pass="pratiyush";
		String query=null;
		
		String storage="\n";
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			String ch=(String) table.getSelectedItem();
			
			if(ch.equals("Donor Database")) {
				
				display.setText("");
				
				///////////////////////////////////////////////
				query="select * from donar";
				
				try {
//					Class.forName("com.myql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pass);
//					System.out.println("Connected...");
					
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					
					while(rs.next()) {
						String show="";
						for(int i=1;i<=7;i++) {
							show+=rs.getString(i)+" : ";
							
						}
//						show=rs.getString("bloodGroup");
						storage=storage+show+"\n\n";
						
						display.setText(storage);
					}
					
					
					
				}
				catch(Exception g) {
					g.printStackTrace();
				}
				
				
				
				/////////////////////////////////////////////
			}
			else {
				
				///////////////////////////////////////////////
				
				display.setText("");
				query="select * from bank";
				try {
//					Class.forName("com.myql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pass);
//					System.out.println("Connected...");
					
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					
					while(rs.next()) {
						String show="";
						for(int i=1;i<=4;i++) {
							show+=rs.getString(i)+" : ";
							
						}
//						show=rs.getString("bloodGroup");
						storage=storage+show+"\n\n";
						
						display.setText(storage);
					}
					
					
					
				}
				catch(Exception g) {
					g.printStackTrace();
				}
				
				
				/////////////////////////////////////////////
			}
				
				
				
				
				
				
				
		}
		if(e.getSource()==back) {
			new Frame();
			this.dispose();
		}
		
	}

}
