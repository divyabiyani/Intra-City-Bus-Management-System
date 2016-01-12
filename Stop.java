package labProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stop {
	String name;
	int noOfRoutes ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfRoutes() {
		return noOfRoutes;
	}
	public void setNoOfRoutes(int noOfRoutes) {
		this.noOfRoutes = noOfRoutes;
	}
	
	
	Stop(String name ){
		this.name = name;
		this.noOfRoutes = 0;
	}
	
	// naya naya stop 
	Stop(String name , int nor ){
		this.name = name;
		this.noOfRoutes = nor;
	}
	
	void regStop() throws SQLException{
		// code to register new stop into database
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("Insert into stop values(?,?)");
		stmt.setString(1, name);
		stmt.setInt(2, noOfRoutes);
		stmt.executeUpdate();

		con.close();
		stmt.close();

	}
	
	public Stop search() throws SQLException{
		// stop search .. 
		Stop mn;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("select * from stop where name = ?");
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery(); 
		if(rs.next() == true) 
			mn = new Stop(rs.getString("name"), rs.getInt("nor"));
		else mn = null;
		
		con.close();
		stmt.close();
		return mn;
	}
	
	public void delete() throws SQLException{
		// delete stop .. log ni ate waha
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("delete from stop where name = ?");
		stmt.setString(1, name.toLowerCase());
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
	}
}
