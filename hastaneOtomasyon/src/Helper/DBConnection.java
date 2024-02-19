package Helper;

import java.sql.*;

public class DBConnection
{


	
	/*
	public static void main(String[] args) {
	
			
			
			 try {
					
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
			
			 if (con!=null) {
				
				 System.out.println("veritbanı bağlandı");
			}
				
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated method stub

	}

*/
	
	
		Connection c=null;
		
		public DBConnection() {}
	
		public Connection connDb()
		{
			try {
				this.c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
			
			
				return c;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
		}

	
	
	
	}






		
		
	


