package Source;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

public class SQLT {

	public SQLT() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/pbl";
		String uname="root";
		String pass="pratiyush";
		String query="select * from donar";
		
		
		
		
		
		try {
//			Class.forName("com.myql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
			System.out.println("Connected...");
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				String show="";
//				for(int i=1;i<=6;i++) {
//					show+=rs.getString(i)+" : ";
//				}
				show=rs.getString("bloodGroup");
				System.out.println(show);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		 
				
		
	}

}
