package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;

import javax.swing.border.*;
public class ManiRoute extends JFrame implements ActionListener
{
	JComboBox<String> cb1;
	JLabel l1,l2,l3,l4,hl,l5;
	JTextField t1,t2,t3,t4;
	Color c;
	JButton b1,b2,back,home;
	JTextArea ta1;
	Image dimg3,dimg4,dimg6;
	
	ManiRoute()
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
		
		setTitle("Manage Routes");
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
		
		hl=new JLabel("Route Data");
		hl.setBounds(150,10,300,40);
		hl.setFont(f2);
		//hl.setForeground(c1);
		add(hl);
		
		cb1=new JComboBox<String>();
		cb1.addItem("Choose any action");
		cb1.addItem("Add");
		//cb1.addItem("Modify");
		cb1.addItem("Search");
		cb1.addItem("Delete");		
		cb1.setBounds(80,60,350,25);
		cb1.setForeground(c1);
		cb1.setFont(f);
		add(cb1);
		
		l1=new JLabel("No.");
		l1.setBounds(80,120,100,20);
		l1.setFont(f);
		l1.setForeground(c1);
		add(l1);
		
		t1=new JTextField(20);
		t1.setBounds(230,120,200,20);
		t1.setFont(f1);
		add(t1);
		
		l3=new JLabel("Fair");
		l3.setBounds(80,160,100,20);
		l3.setFont(f);
		l3.setForeground(c1);
		add(l3);
		
		t3=new JTextField(20);
		t3.setBounds(230,160,200,20);
		t3.setFont(f);
		add(t3);
		
		l4=new JLabel("Color");
		l4.setBounds(80,200,100,20);
		l4.setFont(f);
		l4.setForeground(c1);
		add(l4);
		
		t4=new JTextField(20);
		t4.setBounds(230,200,200,20);
		t4.setFont(f);
		add(t4);
		
		l5=new JLabel("Stops");
		l5.setBounds(80,240,100,20);
		l5.setFont(f);
		l5.setForeground(c1);
		add(l5);
		
		ta1=new JTextArea();
		ta1.setPreferredSize(new Dimension(200,100));
		ta1.setBounds(230,240,200,100);
		ta1.setBorder(new LineBorder(Color.GRAY));
		add(ta1);
		
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
		back.setBounds(445,430,50,50);
		back.setBackground(c);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		add(back);
		
		home=new JButton();
		home.setIcon(new ImageIcon(dimg1));
		home.setBounds(0,430,50,50);
		home.setBackground(c);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		add(home);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(500,500);
		setSize(500,510);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		back.addActionListener(this);
		home.addActionListener(this);
		cb1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String x = String.valueOf(cb1.getSelectedItem());
			if(x.equals("Add"))
			{/////// disable ratings
				//t2.setEnabled(false);
				if(t1.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||ta1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Please Fill all the required fields");
				}
				else
				{
					int no = Integer.parseInt(t1.getText());
					int fair = Integer.parseInt(t3.getText());
					String color = t4.getText();
					String stList = ta1.getText();
					
					t1.setText("");
					//t2.setText("");
					t3.setText("");
					t4.setText("");
					Route u = new Route(no, fair , color);
					try {
						u.regRoute();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					
					try {
						new Rtop(no , stList);
						JOptionPane.showMessageDialog(this , "Entry Successful");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					
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
					Route m = new Route(Integer.parseInt(t1.getText()));
					try {
						m = m.search();
					} catch (NumberFormatException | SQLException e) {
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					if(m != null){
						t1.setText(m.no+"");
						//t2.setText(m.ratings+"");
						t3.setText(m.fair+"");
						t4.setText(m.color+"");
					}
					else JOptionPane.showMessageDialog(this, "This Route doesnt exist");
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
					Route m = new Route(Integer.parseInt(t1.getText()));
					try {
						m.delete();
					} catch (NumberFormatException | SQLException e) {
						JOptionPane.showMessageDialog(this, e.getMessage());
					}
					JOptionPane.showMessageDialog(this , "Delete Successful");	
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Choose any action");
			}
			//DBMS Connectivity
			//Add it to user table
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
		}
		else
		{
				JComboBox comboBox = (JComboBox) ae.getSource();
                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals("Add"))
				{
					//l2.setEnabled(true);
					l3.setEnabled(true);
					//t2.setEnabled(true);
					t3.setEnabled(true);
					l4.setEnabled(true);
					ta1.setEnabled(true);
					b1.setIcon(new ImageIcon(dimg4));
				}
                else if(selected.toString().equals("Search"))
				{
					//l2.setEnabled(false);
					l3.setEnabled(false);
					//t2.setEnabled(false);
					t3.setEnabled(false);
					l4.setEnabled(false);
					ta1.setEnabled(false);
					b1.setIcon(new ImageIcon(dimg3));
				}
				else
				{
					//l2.setEnabled(false);
					l3.setEnabled(false);
					//t2.setEnabled(false);
					t3.setEnabled(false);
					l4.setEnabled(false);
					ta1.setEnabled(false);
					b1.setIcon(new ImageIcon(dimg6));
					t1.setDisabledTextColor(c);
					//t2.setDisabledTextColor(c);
					t3.setDisabledTextColor(c);
					ta1.setDisabledTextColor(c);;
				}
				
		}
	}
}
		
		