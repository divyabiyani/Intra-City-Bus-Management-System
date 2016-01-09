package labProject;

import java.sql.*;

import javax.swing.JOptionPane;

public class Manager {
	String name , mail , address , pass;
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
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPh() {
		return ph;
	}
	public void setPh(Integer ph) {
		this.ph = ph;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	Manager(String name, int id, int ph, char sex, String mail, String address, String pass){
		this.name = name;
		this.id = id;
		this.ph = ph;
		this.sex = sex;
		this.mail = mail;
		this.address = address; 
		this.pass = pass;
	}
	// constructor for delete and search purpose
	Manager(int id){
		this.id = id;
	}
	
	void regManager() throws SQLException{
		// code to insert manager into database
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("Insert into manager values(?,?,?,?,?,?,?)");
		stmt.setString(1, name);
		stmt.setInt(2,id);
		stmt.setInt(3,ph);
		stmt.setString(4,String.valueOf(sex));
		stmt.setString(5,mail);
		stmt.setString(6,address);
		stmt.setString(7,pass);
		stmt.executeUpdate();
		con.close();
		stmt.close();
		
		
	}
	
	public Manager search() throws SQLException{
		
		// search foe a manager ( govt job h ... shaadi kr lo )
		Manager mn;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("select * from manager where id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery(); 
		if(rs.next()) 
			 mn = new Manager(rs.getString("name"), rs.getInt("id"), rs.getInt("phone"), rs.getString("sex").charAt(0), rs.getString("mail"), rs.getString("address"), rs.getString("pass"));
		else mn = null;
		con.close();
		stmt.close();
		return mn;
	}
	
	public void delete() throws SQLException{
		
		// manager retired ... delete him ( her ;-) )
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("delete from manager where id = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
	}
	
	
	
}
