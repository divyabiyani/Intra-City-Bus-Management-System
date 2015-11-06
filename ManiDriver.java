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
public class ManiDriver extends JFrame implements ActionListener
{
	JComboBox<String> cb1;
	JLabel l1,l2,l3,l4,l5,l8,hl;
	JButton b1,b2,home,back;
	JTextField t1,t2,t3,t4,t5;
	Color c;
	Image dimg3,dimg4,dimg6;
	
	ManiDriver()
	{
		BufferedImage img = null,img1 = null,img2 = null,img3 = null,img4 = null,img5 = null,img6 = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\back.jpg"));	
			img1 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\home.jpg"));
			img2 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\bck.jpg"));
			img3 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\search.jpg"));
			img4 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\add.jpg"));
			img5 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\clear.jpg"));
			img6 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\delete.jpg"));
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		Image dimg = img.getScaledInstance(500, 560,Image.SCALE_SMOOTH);
		Image dimg1 = img1.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg2 = img2.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		dimg3 = img3.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		dimg4 = img4.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg5 = img5.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		dimg6 = img6.getScaledInstance(40, 40,Image.SCALE_SMOOTH);
		
		setTitle("Manager Driver Manipulation");
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
		
		hl=new JLabel("Driver Data");
		hl.setBounds(150,10,300,40);
		hl.setFont(f2);
		//hl.setForeground(c1);
		add(hl);
		
		cb1=new JComboBox<String>();
		cb1.addItem("Choose Action");
		cb1.addItem("Add");
		cb1.addItem("Search");
		cb1.addItem("Delete");		
		cb1.setBounds(80,60,350,25);
		cb1.setForeground(c1);
		cb1.setFont(f);
		add(cb1);
		
		l1=new JLabel("User ID");
		l1.setBounds(80,120,100,20);
		l1.setFont(f);
		l1.setForeground(c1);
		add(l1);
		
		t1=new JTextField(20);
		t1.setBounds(230,120,200,20);
		t1.setFont(f1);
		add(t1);
		
		
		l2=new JLabel("Name");
		l2.setBounds(80,160,100,20);
		l2.setFont(f);
		l2.setForeground(c1);
		add(l2);
		
		t2=new JTextField(20);
		t2.setBounds(230,160,200,20);
		t2.setFont(f);
		add(t2);
		
		l3=new JLabel("Phone");
		l3.setBounds(80,200,100,20);
		l3.setFont(f);
		l3.setForeground(c1);
		add(l3);
		
		t3=new JTextField(20);
		t3.setBounds(230,200,200,20);
		t3.setFont(f);
		add(t3);
		
		l4=new JLabel("Gender");
		l4.setBounds(80,240,100,20);
		l4.setFont(f);
		l4.setForeground(c1);
		add(l4);
		
		t4=new JTextField(20);
		t4.setBounds(230,240,200,20);
		t4.setFont(f);
		add(t4);
		
		l5=new JLabel("Address");
		l5.setBounds(80,280,100,20);
		l5.setFont(f);
		l5.setForeground(c1);
		add(l5);
		
		t5=new JTextField(20);
		t5.setBounds(230,280,200,20);
		t5.setFont(f);
		add(t5);	
		
		b1=new JButton();
		b1.setIcon(new ImageIcon(dimg4));
		b1.setBounds(150,330,70,50);
		b1.setBackground(c);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setBorder(null);
		add(b1);
		
		b2=new JButton();
		b2.setIcon(new ImageIcon(dimg5));
		b2.setBounds(260,330,70,50);
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
		cb1.addActionListener(this);
		back.addActionListener(this);
		home.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String x = String.valueOf(cb1.getSelectedItem());
		if(ae.getSource()==b1)
		{				
			if(x.equals("Add"))
			{
				if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Please Fill all the required fields");
				}	
				else
				{	
					int id = Integer.parseInt(t1.getText());
					String name = t2.getText();
					int phone = Integer.parseInt(t3.getText());
					char sex = t4.getText().charAt(0);
					String address = t5.getText();
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					Driver u = new Driver(name , id , phone , sex , address);
					try {
						u.regDriver();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					JOptionPane.showMessageDialog(this , "Entry Successful");
				}
			}
		
			else if(x.equals("Search"))
			{
				if(t1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Please Fill all the required fields");
				}	
				else
				{	
					Driver m = new Driver(Integer.parseInt(t1.getText()));
					try {
						m = m.search();
					} catch (NumberFormatException | SQLException e) {
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					
					if(m != null){
						t1.setText(m.id+"");
						t2.setText(m.name);
						t3.setText(m.ph+"");
						t4.setText(String.valueOf(m.sex));
						t5.setText(m.address);
					}
					else JOptionPane.showMessageDialog(this, "This user doesnt exist");
				}
			}
			else if(x.equals("Delete"))
			{
				if(t1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Please Fill all the required fields");
				}	
				else
				{	
					Driver m = new Driver(Integer.parseInt(t1.getText()));
					try {
						m.delete();
					} catch (NumberFormatException | SQLException e) {
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					JOptionPane.showMessageDialog(this , "Delete Successful");
				}
			}
			
			else {
				JOptionPane.showMessageDialog(this , "Choose Action !");
			}
		}
		else if(ae.getSource()==back)
		{
			new ManDisplay();
			setVisible(false);
		}
		else if(ae.getSource()==home)
		{
			new Start();
			setVisible(false);
		}
		else if(ae.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			//t6.setText("");
			//p1.setText("");
		}
		else
		{
				JComboBox comboBox = (JComboBox) ae.getSource();
                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals("Add"))
				{
                	t1.setText("");
        			t2.setText("");
        			t3.setText("");
        			t4.setText("");
        			t5.setText("");
        			try {
	                	Connection con = DriverManager.getConnection("jdbc:db2://localhost:50000/project","MEDHA", "student163");
	            		PreparedStatement stmt=con.prepareStatement("select drivercount from summary");
	            		
						ResultSet rs = stmt.executeQuery();
						if(rs.next()) {t1.setText(""+rs.getInt("drivercount"));
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
					//p1.setEnabled(true);
					t3.setEnabled(true);
					t4.setEnabled(true);
					t5.setEnabled(true);
					//t6.setEnabled(true);
					t2.setEnabled(true);
					l3.setEnabled(true);
					l4.setEnabled(true);
					l5.setEnabled(true);
					//t6.setEnabled(true);
					l2.setEnabled(true);
					b1.setIcon(new ImageIcon(dimg4));
				}
                else if(selected.toString().equals("Search"))
				{
                	t1.setText("");
        			t2.setText("");
        			t3.setText("");
        			t4.setText("");
        			t5.setText("");
					t3.setEnabled(false);
					t4.setEnabled(false);
					t5.setEnabled(false);
					//t6.setEnabled(false);
					t2.setEnabled(false);
					l3.setEnabled(false);
					l4.setEnabled(false);
					l5.setEnabled(false);
					l2.setEnabled(false);
					t1.setDisabledTextColor(c);
					t2.setDisabledTextColor(c);
					t3.setDisabledTextColor(c);
					t4.setDisabledTextColor(c);
					t5.setDisabledTextColor(c);
					b1.setIcon(new ImageIcon(dimg3));
				}
				else if(selected.toString().equals("Delete"))
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t3.setEnabled(false);
					t4.setEnabled(false);
					t5.setEnabled(false);
					t2.setEnabled(false);
					l3.setEnabled(false);
					l4.setEnabled(false);
					l5.setEnabled(false);
					l2.setEnabled(false);
					b1.setIcon(new ImageIcon(dimg6));
				}
				
		}
	}
}
		
		