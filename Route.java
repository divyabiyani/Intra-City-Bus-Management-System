package labProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Route {
	int no  , fair;
	String color;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getFair() {
		return fair;
	}
	public void setFair(int fair) {
		this.fair = fair;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	Route(int no ,int fair, String color){
		this.no = no;
		
		this.fair = fair;
		this.color = color;
	}
	
	
	Route(int no){
		this.no = no;
	}
	
	void regRoute() throws SQLException{
		// code to register new route into database
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("Insert into route values(?,?,?)");
		stmt.setInt(1, no);
		stmt.setInt(2,fair);
		stmt.setString(3,color);
		stmt.executeUpdate();

		con.close();
		stmt.close();
	}
	
	public String toString(){
		return ("\nNo: "+no +"\nFair: "+fair +"\nColor: "+ color+ "\n" );
	}	
	
	public Route search() throws SQLException{
		
		// route search based on no .... arre bus bi to dhundhni h!!
		Route mn;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("select * from route where no = ?");
		stmt.setInt(1, no);
		ResultSet rs = stmt.executeQuery(); 
		if(rs.next() == true) 
			mn = new Route(rs.getInt("no"), rs.getInt("fair"), rs.getString("color"));
		else mn = null;
		
		con.close();
		stmt.close();
		return mn;
	}
	
	public void delete() throws SQLException{
		
		// rasta band ho gya!! ... route delete karo
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("delete from route where no = ?");
		stmt.setInt(1, no);
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
	}
	
	
}
