package labProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Rtop {
	int routeNo;
	HashSet<String> stops;
	String[] s;
	
	Rtop(int rtno , String st) throws SQLException{
		int i;
		routeNo = rtno;
		stops = new HashSet<String>();
		//System.out.println(st);
		s = st.split(",");
		//System.out.print(st);
//		for(i=0;i<s.length;i++){System.out.print(s[i]);
//			stops.add(s[i]);}
		i=0;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("Insert into rtop values(?,?,?)");
		//Iterator<String> itr = stops.iterator();
		for(i=0;i<s.length;i++){
			stmt.setInt(2, routeNo);
			stmt.setString(1, s[i].trim());
			stmt.setInt(3,i+1);
			stmt.executeUpdate();
		}
			con.close();
			stmt.close();
		
		
	}
	
}
