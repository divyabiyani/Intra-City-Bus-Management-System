package labProject;

import java.sql.*;

public class User {
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
	
	User(String name, int id, int ph, char sex, String mail, String address, String pass){
		this.name = name;
		this.id = id;
		this.ph = ph;
		this.sex = sex;
		this.mail = mail;
		this.address = address;
		this.pass = pass;
	}
	User(int id){
		this.id = id;
	}
	
	void regUser() throws SQLException{
		// code to insert user into database
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("Insert into user values(?,?,?,?,?,?,?)");
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
	
	
	public User search() throws SQLException{
		// search user ... 
		User mn;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("select * from user where id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery(); 
		if(rs.next() == true) 
			mn = new User(rs.getString("name"), rs.getInt("id"), rs.getInt("phone"), rs.getString("sex").charAt(0), rs.getString("mail"), rs.getString("address"), rs.getString("pass"));
		else mn = null;
		con.close();
		stmt.close();
		return mn;
	}
	
	public void delete() throws SQLException{
		// delete user .. he/she doesnt uses ur service
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("delete from user where id = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
	}
}
