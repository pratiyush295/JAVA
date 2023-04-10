package Source;
import javax.swing.*;
import java.sql.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Book extends JFrame implements ActionListener{

	JLabel label=new JLabel("BLOOD BANK");
	JPanel entry=new JPanel();
	
	JLabel name=new JLabel("Name ");
	JLabel contact =new JLabel("Contact No.");
	JLabel bg=new JLabel("Blood Needed");
	JLabel age=new JLabel("Age ");
	
	JTextField namet=new JTextField();
	JTextField contactt=new JTextField();
	JTextField aget=new JTextField();

	String bgs[]= {"A","B","AB","O","A+","B+","AB+","O+","O-"};
	
	JComboBox bgc=new JComboBox(bgs);
	JButton submit=new JButton("SUBMIT");
	JButton back=new JButton("Back");
	
	public Book() {
		// TODO Auto-generated constructor stub
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Book Blood-Blood Bank");
		this.getContentPane().setBackground(Color.white);
		this.setLayout(null);
		
		
		
		
		back.setBounds(20, 20, 80, 30);
		back.setBackground(Color.white);
		back.setFocusable(false);
		back.setForeground(Color.black);
		back.setOpaque(true);
		back.addActionListener(this);
		
		
		label.setBounds(270,50,300,50);
		label.setBackground(Color.LIGHT_GRAY);
		label.setForeground(Color.black);
		label.setFont(new Font("Ariel",Font.ROMAN_BASELINE,45));
		label.setOpaque(true);
		
		
		
		
		
		name.setBounds(10,30,120,20);
		name.setFont(new Font("Arial",Font.BOLD,20));
		
		contact.setBounds(10,100,120,20);
		contact.setFont(new Font("Arial",Font.BOLD,20));
		
		
		bg.setBounds(10,225,140,20);
		bg.setFont(new Font("Arial",Font.BOLD,19));
		
		age.setBounds(10,160,120,20);
		age.setFont(new Font("Arial",Font.BOLD,20));
		
		
		namet.setBounds(150,30,250,30);
		contactt.setBounds(150,100,250,30);
		aget.setBounds(150,160,250,30);

		
		bgc.setBounds(150,220,150,30);
		
		
		submit.setBounds(180, 300, 100, 40);
		submit.setFocusable(false);
		submit.setFont(new Font("Comic Sans",Font.BOLD,12));
		submit.setBorder(BorderFactory.createLineBorder(Color.black,2));
		submit.setForeground(Color.white);
		submit.setBackground(Color.gray);
		submit.setOpaque(true);
		submit.addActionListener(this);
		
//		entry.setBackground(Color.LIGHT_GRAY);
		entry.setBounds(180,180,450,400);
		entry.setBorder(BorderFactory.createLineBorder(Color.black,2));
		entry.setLayout(null);
		
		
		entry.add(bg);
		entry.add(bgc);
		entry.add(contact);
		entry.add(contactt);
		entry.add(name);
		entry.add(namet);
		entry.add(submit);
		entry.add(age);
		entry.add(aget);
		
		this.add(entry);
		this.add(back);
		this.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String blood=(String) bgc.getSelectedItem();
		String strname=namet.getText();
		String strcontact=contactt.getText();
		String strage=aget.getText();
		// TODO Auto-generated method stub
		if(e.getSource()==back) {
			this.dispose();
			new Frame();
		}
		if(e.getSource()==submit) {
			
			
			
			if(strname.length()==0||strcontact.length()==0||strage.length()==0) {
				JOptionPane.showMessageDialog(null, "Fill All Fields","Empty Field",JOptionPane.PLAIN_MESSAGE);
			}
			else {
				
			
			int ch=JOptionPane.showConfirmDialog(null, "PROCEED...?","BLOOD BANK",JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(ch==0) {
				//yes
				
				/////////////////////////////////////
				
				
				
				
				
				
				
				
				
				
				String url="jdbc:mysql://localhost:3306/pbl";
				String uname="root";
				String pass="pratiyush";
				String query="select count(SrNo) from bank";
				
				
				try {
					String count = null;
					Connection con=DriverManager.getConnection(url,uname,pass);
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					
					while(rs.next()) {
						count=rs.getString(1);
					}
					
					
					query="select * from donar,bank where donar.bloodGroup="+'"'+blood+'"'+" and bank.acceptor="+'"'+"NULL"+'"';
					System.out.println(query+count);
					
					String outputfreez=null;
					String outputsrno=null;
					
					ResultSet rs=st.executeQuery(query);
					
				}
				catch(Exception g) {
					g.printStackTrace();
				}
				
			}
			
			}
		}
	}
}
			