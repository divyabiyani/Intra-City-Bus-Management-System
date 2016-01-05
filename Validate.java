package labProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;


public class Validate {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	HashMap<Integer , String> manMap , userMap;
	Validate(){
		try{
			
			//store data in hashmap for easy retreival 
			con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
			HashMap manMap = new HashMap();
			stmt=con.prepareStatement("select id , pass from manager");
			rs = stmt.executeQuery();
			while(rs.next()){
				manMap.put(rs.getInt("id"), rs.getString("pass"));				
			}
			
			HashMap userMap = new HashMap();
			stmt=con.prepareStatement("select id , pass from user");
			rs = stmt.executeQuery();
			while(rs.next()){
				userMap.put(rs.getInt("id"), rs.getString("pass"));				
			}
			
			con.close();
			stmt.close();
			rs.close();
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	// manager login validation
	int manager(int id , String pass) throws SQLException{
		int b = 0;
		String pa = manMap.get((Integer)id);
		if(pa != null) {
			b++;
			if(pa.equals(pass)) b++;	
		}
		
		return b;
	}
	// user login validation
	int user(int id , String pass) throws SQLException{
		int b = 0;
		String pa = userMap.get((Integer)id);
		if(pa != null) {
			b++;
			if(pa.equals(pass)) b++;	
		}
		return b;
	}
}
