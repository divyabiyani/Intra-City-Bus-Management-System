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
public class UserSignUp extends JFrame implements ActionListener,KeyListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,hl;
	JButton b1,b2,back,home;
	JTextField t1,t2,t3,t4,t5,t6;
	JPasswordField p1;
	Color c;
	UserSignUp()
	{		
		BufferedImage img = null,img1 = null,img2 = null,img4 = null,img5 = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\back.jpg"));	
			img1 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\home.jpg"));
			img2 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\bck.jpg"));
			img4 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\login.jpg"));
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
		
		
		setTitle("User SignUp Page");
		
		
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
		
		hl=new JLabel("User SignUp");
		hl.setBounds(150,10,300,40);
		hl.setFont(f2);
		//hl.setForeground(c1);
		add(hl);
		
		l1=new JLabel("User ID");
		l1.setBounds(80,80,100,20);
		l1.setFont(f);
		l1.setForeground(c1);
		add(l1);
		
		t1=new JTextField(20);
		t1.setBounds(230,80,200,20);
		t1.setFont(f1);
		add(t1);
		
		l2=new JLabel("Password");
		l2.setBounds(80,120,100,20);
		l2.setFont(f);
		l2.setForeground(c1);
		add(l2);
		
		p1=new JPasswordField(20);
		p1.setBounds(230,120,200,20);
		p1.setFont(f);
		add(p1);
		
		l3=new JLabel("Name");
		l3.setBounds(80,160,100,20);
		l3.setFont(f);
		l3.setForeground(c1);
		add(l3);
		
		t2=new JTextField(20);
		t2.setBounds(230,160,200,20);
		t2.setFont(f);
		add(t2);
		
		l4=new JLabel("Phone");
		l4.setBounds(80,200,100,20);
		l4.setFont(f);
		l4.setForeground(c1);
		add(l4);
		
		t3=new JTextField(20);
		t3.setBounds(230,200,200,20);
		t3.setFont(f);
		add(t3);
		
		l5=new JLabel("Gender");
		l5.setBounds(80,240,100,20);
		l5.setFont(f);
		l5.setForeground(c1);
		add(l5);
		
		t4=new JTextField(20);
		t4.setBounds(230,240,200,20);
		t4.setFont(f);
		add(t4);
		
		l6=new JLabel("Email");
		l6.setBounds(80,280,100,20);
		l6.setFont(f);
		l6.setForeground(c1);
		add(l6);
		
		t5=new JTextField(20);
		t5.setBounds(230,280,200,20);
		t5.setFont(f);
		add(t5);
		
		l7=new JLabel("Address");
		l7.setBounds(80,320,100,20);
		l7.setFont(f);
		l7.setForeground(c1);
		add(l7);
		
		t6=new JTextField(20);
		t6.setBounds(230,320,200,20);
		t6.setFont(f);
		add(t6);
		
		b1=new JButton();
		b1.setIcon(new ImageIcon(dimg4));
		b1.setBounds(150,360,70,50);
		b1.setBackground(c);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setBorder(null);
		add(b1);
		
		b2=new JButton();
		b2.setIcon(new ImageIcon(dimg5));
		b2.setBounds(260,360,70,50);
		b2.setBackground(c);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setBorder(null);
		add(b2);
		
		back=new JButton();
		back.setIcon(new ImageIcon(dimg2));
		back.setBounds(440,420,50,50);
		back.setBackground(c);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		add(back);
		
		home=new JButton();
		home.setIcon(new ImageIcon(dimg1));
		home.setBounds(0,420,50,50);
		home.setBackground(c);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		add(home);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(499,499);
		setSize(500,500);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		back.addActionListener(this);
		home.addActionListener(this);
		
		t1.addKeyListener(this);
		
		try {
        	Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
    		PreparedStatement stmt=con.prepareStatement("select usercount from summary");
    		
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {t1.setText(""+rs.getInt("usercount"));
			t1.setEnabled(false);
			l1.setEnabled(false);
			}
			
			con.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			int id = Integer.parseInt(t1.getText());
			String pass = new String(p1.getPassword());
			String name = t2.getText();
			int phone = Integer.parseInt(t3.getText());
			char sex = t4.getText().charAt(0);
			String mail = t5.getText();
			String address = t6.getText();
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			p1.setText("");
			User u = new User(name , id , phone , sex , mail , address , pass);
			try {
				u.regUser();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			//DBMS Connectivity
			//Add it to user table
		}
		else if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			p1.setText("");
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
	}
	
	public void keyPressed(KeyEvent ke)
	{
		
		//if(ke.getSource()==t1)
		//check database
		//if user id available
		//l8.setBackground(Color.GREEN);
		//else
		//l8.setBackground(Color.RED);
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
}