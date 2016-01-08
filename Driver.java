package labProject;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {
	String name , address;
	int id , ph;
	char sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
	Driver(String name, int id, int ph, char sex, String address){
		this.name = name;
		this.id = id;
		this.ph = ph;
		this.sex = sex;
		this.address = address;
		
	}
	
	// new driver for delete and search purpose
	Driver(int id){
		this.id = id;
	}
	void regDriver() throws SQLException{
		// code to insert driver into database
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("Insert into driver values(?,?,?,?,?)");
		stmt.setString(1, name);
		stmt.setInt(2,id);
		stmt.setInt(3,ph);
		stmt.setString(4,String.valueOf(sex));
		stmt.setString(5,address);
		
		stmt.executeUpdate();

		con.close();
		stmt.close();
	}
	
	public Driver search() throws SQLException{
		
		// search for a driver ( dont marry him) 
		Driver mn;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("select * from driver where id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery(); 
		if(rs.next() == true) 
			mn = new Driver(rs.getString("name"), rs.getInt("id"), rs.getInt("phone"), rs.getString("sex").charAt(0), rs.getString("address"));
		else mn = null;
		
		con.close();
		stmt.close();
		return mn;
	}
	
	public void delete() throws SQLException{
		
		// driver dead or retired or ill ...ammm .. anyways fire him(may be her)
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("delete from driver where id = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
	}
}
