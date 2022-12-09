package Source;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Add extends JFrame implements ActionListener{

	
	
	JLabel label=new JLabel("BLOOD BANK");
	
	JPanel entry=new JPanel();
	
	JLabel name=new JLabel("Name ");
	JLabel contact=new JLabel("Contact No.");
	JLabel age=new JLabel("Age ");
	JLabel gender=new JLabel("Gender ");
	JLabel bg=new JLabel("Blood Group ");
	JLabel freez=new JLabel("Freezer No ");
	
	JTextField namet=new JTextField();
	JTextField contactt=new JTextField();
	JTextField aget=new JTextField();
	JTextField freezt=new JTextField();
	
	
	String genders[]= {"M","F"};
	String bgs[]= {"A","B","AB","O","A+","B+","AB+","O+","O-"};
	JComboBox genderc=new JComboBox(genders);
	JComboBox bgc=new JComboBox(bgs);
	
	
	JButton submit=new JButton("SUBMIT");
	JButton back=new JButton("Back");
	
	public Add() {
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
		label.setBackground(Color.LIGHT_GRAY);
		label.setForeground(Color.black);
		label.setFont(new Font("Ariel",Font.ROMAN_BASELINE,45));
		label.setOpaque(true);
		
		
		
		name.setBounds(10,30,120,20);
		name.setFont(new Font("Arial",Font.BOLD,20));
		
		contact.setBounds(10,80,120,20);
		contact.setFont(new Font("Arial",Font.BOLD,20));
		
		age.setBounds(10,130,120,20);
		age.setFont(new Font("Arial",Font.BOLD,20));
		
		gender.setBounds(10,180,120,20);
		gender.setFont(new Font("Arial",Font.BOLD,20));
		
		bg.setBounds(10,230,130,20);
		bg.setFont(new Font("Arial",Font.BOLD,20));
		
		namet.setBounds(150,30,250,30);
		contactt.setBounds(150,80,250,30);
		aget.setBounds(150,130,250,30);
		genderc.setBounds(150,180,150,30);
		bgc.setBounds(150,230,150,30);

		
		freez.setBounds(10,280,120,20);
		freez.setFont(new Font("Arial",Font.BOLD,20));
		
		freezt.setBounds(150,280,250,30);
		
		submit.setBounds(180, 340, 100, 40);
		submit.setFocusable(false);
		submit.setFont(new Font("Comic Sans",Font.BOLD,12));
		submit.setBorder(BorderFactory.createLineBorder(Color.black,2));
		submit.setForeground(Color.white);
		submit.setBackground(Color.gray);
		submit.setOpaque(true);
		submit.addActionListener(this);
		
		
		entry.setBounds(180,180,450,400);
		entry.setBorder(BorderFactory.createLineBorder(Color.black,2));
		entry.setLayout(null);
		
		
		
		
		entry.add(age);
		entry.add(aget);
		entry.add(contact);
		entry.add(contactt);
		entry.add(name);
		entry.add(namet);
		entry.add(gender);
		entry.add(bg);
		entry.add(genderc);
		entry.add(bgc);
		entry.add(freez);
		entry.add(freezt);
		entry.add(submit);
		
		
		this.add(back);
		this.add(label);
		this.add(entry);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==submit) {
			String strname="null";
			strname=namet.getText();
			String strcontact=contactt.getText();
			String strage=aget.getText();
			String strfreez=freezt.getText();
			String strgender=(String) genderc.getSelectedItem();
			String strbg=(String) bgc.getSelectedItem();
			
			
			if((strname.length()==0 || strcontact.length()==0 || strage.length()==0||strfreez.length()==0)) {
				JOptionPane.showMessageDialog(null, "Fill All Fields","Empty Field",JOptionPane.PLAIN_MESSAGE);
				
			}
			
			
			
			else {
				
				String url="jdbc:mysql://localhost:3306/pbl";
				String uname="root";
				String pass="pratiyush";
				String query;
				
//				System.out.println(query);
				try {
					String count = null;
//					Class.forName("com.myql.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,uname,pass);
					System.out.println("Connected...");
					query="select count(SrNo) from bank";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					
					while(rs.next()) {
						count=rs.getString(1);
					}
					int dup=Integer.parseInt(count);
					dup+=1;
					count=Integer.toString(dup);
//					
					query="insert into donar values("+'"'+count+'"'+","+'"'+strname+'"'+","+'"'+strcontact+'"'+","+'"'+strage+'"'+","+'"'+strgender+'"'+","+'"'+strbg+'"'+","+'"'+strfreez+'"'+")";
////					
					st.executeUpdate(query);
					
					query="insert into bank values("+'"'+count+'"'+","+'"'+"NULL"+'"'+","+'"'+"NULL"+'"'+","+'"'+strfreez+'"'+")";
					st.executeUpdate(query);
					System.out.println(query);
					JOptionPane.showMessageDialog(null, "DATA ENTERED","RECORD ADDED",JOptionPane.PLAIN_MESSAGE);
					
				}
				catch(Exception g) {
					g.printStackTrace();
				}

			}
			
			

			
			
			
		
	}
		if(e.getSource()==back) {
			this.dispose();
			new Frame();
		}

}
}
