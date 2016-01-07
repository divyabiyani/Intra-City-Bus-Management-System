package labProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;


public class Bus {
	String no;
	int capacity , frequency , did , rtno;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getRtno() {
		return rtno;
	}
	public void setRtno(int rtno) {
		this.rtno = rtno;
	}
	// Bus constructor for all entries
	Bus(String no , int capacity , int frequency , int did , int rtno){
		this.no = no;
		this.capacity = capacity;
		this. frequency = frequency;
		this.did = did;
		this.rtno = rtno;
	}
	// Bus constructor if driver not assigned
	Bus(String no , int capacity , int frequency , int rtno){
		this.no = no;
		this.capacity = capacity;
		this. frequency = frequency;
		this.rtno = rtno;
	}
	// Bus constructor if brand new bus .. no driver .. no route ;-)
	Bus(String no , int capacity , int frequency ){
		this.no = no;
		this.capacity = capacity;
		this. frequency = frequency;
	}
	Bus(String no){
		this.no = no;
	}
	
	void regBus() throws SQLException{
		// code to register new bus into database
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("Insert into bus values(?,?,?,?,?)");
		stmt.setString(1, no);
		stmt.setInt(2,capacity);
		stmt.setInt(3,frequency);
		stmt.setInt(4,did);
		stmt.setInt(5,rtno);
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
		
	}
	
	public String toString(){
		//to display format
		return ("\nNo: "+no +"\nCapacity: "+capacity +"\nFrequency: "+frequency +"\nRoute No: "+ rtno+ "\n" );
	}
	
	public Bus search() throws SQLException{
		// Search for a bus and give it to form
		Bus mn;
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("select * from bus where no = ?");
		stmt.setString(1,no);
		ResultSet rs = stmt.executeQuery(); 
		if(rs.next() == true) 
			mn = new Bus(rs.getString("no"), rs.getInt("capacity"), rs.getInt("frequency"), rs.getInt("did"), rs.getInt("rtno"));
		else mn = null;
		
		con.close();
		stmt.close();
		return mn;
	}
	public void delete() throws SQLException{
		
		//delete bus ( may be bomb-blasted by terrorists) or drunk driver hit-n-run case
		Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		PreparedStatement stmt=con.prepareStatement("delete from bus where no = ?");
		stmt.setString(1, no.toLowerCase());
		stmt.executeUpdate();
		
		con.close();
		stmt.close();
	}
	
}
