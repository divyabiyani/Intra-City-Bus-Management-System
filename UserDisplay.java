package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;

import javax.swing.border.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
public class UserDisplay extends JFrame implements ActionListener
{
	JComboBox<String> cb1;
	JRadioButton rb1,rb2,rb3;
	JButton b1,b2,back,home;
	JTextField t1,t2,t3,t4;
	JTextArea ta;
	JLabel hl,l1;
	ButtonGroup bg;
	Color c;
	Connection con;
	PreparedStatement stmt , stmt1;
	ResultSet rs , rs1;
	
	UserDisplay() throws SQLException
	{

		BufferedImage img = null,img1 = null,img2 = null,img4 = null,img5 = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\back.jpg"));	
			img1 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\home.jpg"));
			img2 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\bck.jpg"));
			img4 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\search.jpg"));
			img5 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\clear.jpg"));
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		Image dimg = img.getScaledInstance(500, 560,Image.SCALE_SMOOTH);
		Image dimg1 = img1.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg2 = img2.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg4 = img4.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg5 = img5.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		
		
		setTitle("City Bus Information");
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(500,500);
		pack();
		setLocationRelativeTo(null);
		
		Font f=new Font("Arial",Font.BOLD,15);
		
		c=new Color(127,127,150);
		
		Color c1=new Color(96,96,96);
		
		Font f1=new Font("Arial",Font.ITALIC,15);
		Font f2=new Font("Arial",Font.BOLD,30);
		
		hl=new JLabel("Search Bus Routes");
		hl.setBounds(100,10,300,40);
		hl.setFont(f2);
		//hl.setForeground(c1);
		add(hl);
		
		cb1=new JComboBox<String>();
		cb1.addItem("Info About ???");
		cb1.addItem("Bus");
		cb1.addItem("Stop");
		cb1.addItem("Route");
		
		
		cb1.setBounds(50,60,410,25);
		cb1.setForeground(c1);
		cb1.setFont(f);
		add(cb1);
		
		rb1=new JRadioButton("Bus");
		rb1.setBounds(50,100,100,20);
		rb1.setForeground(c1);
		rb1.setFont(f);
		add(rb1);
		
		t1=new JTextField(20);
		t1.setBounds(200,100,260,20);
		t1.setFont(f1);
		add(t1);
		
		rb2=new JRadioButton("Stop");
		rb2.setBounds(50,140,100,20);
		rb2.setForeground(c1);
		rb2.setFont(f);
		add(rb2);
		
		t2=new JTextField(20);
		t2.setBounds(200,140,120,20);
		t2.setFont(f1);
		add(t2);
		
		t3=new JTextField(20);
		t3.setBounds(340,140,120,20);
		t3.setFont(f1);
		add(t3);
		
		rb3=new JRadioButton("Route");
		rb3.setBounds(50,180,100,20);
		rb3.setForeground(c1);
		rb3.setFont(f);
		add(rb3);
		
		t4=new JTextField(20);
		t4.setBounds(200,180,260,20);
		t4.setFont(f1);
		add(t4);
		
		bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		l1=new JLabel("Result");
		l1.setBounds(50,220,100,20);
		l1.setFont(f);
		l1.setForeground(c1);
		add(l1);
		
		ta=new JTextArea(260,100);
		ta.setBounds(200,220,260,100);
		ta.setBorder(new LineBorder(Color.GRAY));
		add(ta);
		
		b1=new JButton();
		b1.setIcon(new ImageIcon(dimg4));
		b1.setBounds(150,340,70,50);
		b1.setBackground(c);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setBorder(null);
		add(b1);
		
		b2=new JButton();
		b2.setIcon(new ImageIcon(dimg5));
		b2.setBounds(260,340,70,50);
		b2.setBackground(c);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setBorder(null);
		add(b2);
		
		back=new JButton();
		back.setIcon(new ImageIcon(dimg2));
		back.setBounds(445,410,50,50);
		back.setBackground(c);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		add(back);
		
		home=new JButton();
		home.setIcon(new ImageIcon(dimg1));
		home.setBounds(0,410,50,50);
		home.setBackground(c);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		add(home);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(500,500);
		setSize(500,480);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		back.addActionListener(this);
		home.addActionListener(this);
		cb1.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		
		setVisible(true);
		setResizable(false);
		setSize(500,490);
		con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{	
			try
			{
				String x = String.valueOf(cb1.getSelectedItem());
				if(x.equals("Bus"))
				{
					if(rb2.isSelected()){
						String st = t2.getText(), nd = t3.getText();
						stmt=con.prepareStatement("select * from bus where rtno in (select rno from rtop where stop = ?) and rtno in (select rno from rtop where stop = ?)");
						stmt.setString(1 ,  st);
						stmt.setString(2 ,  nd);
						rs = stmt.executeQuery(); 
						ta.setText("");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						while(rs.next()) {
							Bus mn = new Bus(rs.getString("no"), rs.getInt("capacity"), rs.getInt("frequency"), rs.getInt("did"), rs.getInt("rtno"));
							ta.append(mn.toString());
						}
						con.close();
						stmt.close();
					}
					
					if(rb3.isSelected()){
						String rt = t4.getText();
						stmt=con.prepareStatement("select * from bus where rtno = ?");
						stmt.setString(1 ,  rt);
						rs = stmt.executeQuery(); 
						ta.setText("");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						while(rs.next()) {
							Bus mn = new Bus(rs.getString("no"), rs.getInt("capacity"), rs.getInt("frequency"), rs.getInt("did"), rs.getInt("rtno"));
							ta.append(mn.toString());
						}
						con.close();
						stmt.close();
					}
				}
				else if(x.equals("Stop"))
				{
					if(rb1.isSelected()){
						String bs = t1.getText();
						stmt=con.prepareStatement("select stop from rtop where rtno = (select rtno from bus where no = ?) order by pos");
						stmt.setString(1 ,  bs);
						rs = stmt.executeQuery(); 
						ta.setText("");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						while(rs.next()) {
							ta.append(rs.getString("stop"));
						}
						con.close();
						stmt.close();
					}
					
					if(rb3.isSelected()){
						String rt = t4.getText();
						stmt=con.prepareStatement("select stop from rtop where rno = ? order by pos");
						stmt.setString(1 ,  rt);
						rs = stmt.executeQuery(); 
						ta.setText("");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						while(rs.next()) {
							ta.append(rs.getString("stop")+"\n");
						}
						con.close();
						stmt.close();
					}
				}
				else if(x.equals("Route"))
				{
					if(rb1.isSelected()){
						String bs = t1.getText();
						stmt=con.prepareStatement("select * from route where no = (select rtno from bus where no = ?)");
						stmt.setString(1 ,  bs);
						rs = stmt.executeQuery();
						ta.setText("");
						
						if(rs.next()) {
							Route rt = new Route(rs.getInt("no")  , rs.getInt("fair") , rs.getString("color"));
							ta.append(rt.toString());
						}
						stmt=con.prepareStatement("select stop from rtop where rno = ? order by pos");
						stmt.setInt(1 , rs.getInt("no"));
						rs = stmt.executeQuery(); 
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						ta.setText("");
						while(rs.next()) {
							ta.append(rs.getString("stop"));
						}
						con.close();
						stmt.close();
					}
					
					
					if(rb2.isSelected()){
						String st = t2.getText(), nd = t3.getText();
						stmt=con.prepareStatement("select * from route where no in (select rno from rtop where stop = ?) and no in (select rno from rtop where stop = ?)");
						stmt.setString(1 ,  st);
						stmt.setString(2 ,  nd);
						rs = stmt.executeQuery();
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						ta.setText("");
						
						while(rs.next()) {
							Route rt = new Route(rs.getInt("no") , rs.getInt("fair") , rs.getString("color"));
							ta.append(rt.toString());
							stmt1=con.prepareStatement("select STOP from rtop where rno = ? ");
							stmt1.setInt(1 , rs.getInt("no"));
							rs1 = stmt.executeQuery(); 
//							while(rs1.next()) {
//								ta.append(rs1.getString("STOP"));
//							}
						}
						
						con.close();
						stmt.close();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Choose something to get info about!!! >:(");
				}
				//DBMS Connectivity
			}
			
			catch(SQLException e){
				
			}
		}
		else if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			ta.setText("");
			cb1.setSelectedItem(0);
		}
		else if(ae.getSource()==back)
		{
			new UserLogin();
			setVisible(false);
		}
		else if(ae.getSource()==home)
		{
			new Start();
			setVisible(false);
		}
		else if(ae.getSource() instanceof JRadioButton)
		{
			if(ae.getSource() == rb1){t1.setEnabled(true);t2.setEnabled(false);t3.setEnabled(false);t4.setEnabled(false);}
			else if(ae.getSource() == rb2){t1.setEnabled(false);t2.setEnabled(true);t3.setEnabled(true);t4.setEnabled(false);}
			else if(ae.getSource() == rb3){t1.setEnabled(false);t2.setEnabled(false);t3.setEnabled(false);t4.setEnabled(true);}
		}
		else 
		{
				JComboBox<String> comboBox = (JComboBox<String>) ae.getSource();
                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals("Bus"))
				{
					rb2.setEnabled(true);
					rb3.setEnabled(true);
					t2.setEnabled(true);
					t3.setEnabled(true);
					t4.setEnabled(true);
					rb1.setEnabled(false);
					t1.setEnabled(false);
				}
                else if(selected.toString().equals("Stop"))
				{
					rb2.setEnabled(false);
					rb3.setEnabled(true);
					t2.setEnabled(false);
					t3.setEnabled(false);
					t4.setEnabled(true);
					rb1.setEnabled(true);
					t1.setEnabled(true);
				}
				else
				{
					rb2.setEnabled(true);
					rb3.setEnabled(false);
					t2.setEnabled(true);
					t3.setEnabled(true);
					t4.setEnabled(false);
					rb1.setEnabled(true);
					t1.setEnabled(true);
				}
				
		}
	}
	
}