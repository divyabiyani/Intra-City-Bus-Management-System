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
public class ManiStop extends JFrame implements ActionListener
{
	JComboBox<String> cb1;
	JLabel l1,l2,hl;
	JTextField t1,t2;
	Color c;
	JButton b1,b2,back,home;
	Image dimg3,dimg4,dimg6;
	
	ManiStop()
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
		
		setTitle("Manager Stop Manipulation");
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
		
		hl=new JLabel("Stop Data");
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
		
		
		l1=new JLabel("Name");
		l1.setBounds(80,120,100,20);
		l1.setFont(f);
		l1.setForeground(c1);
		add(l1);
		
		t1=new JTextField(20);
		t1.setBounds(230,120,200,20);
		t1.setFont(f1);
		add(t1);
		
		l2=new JLabel("No of Routes");
		l2.setBounds(80,160,100,20);
		l2.setFont(f);
		l2.setForeground(c1);
		add(l2);
		
		t2=new JTextField(20);
		t2.setBounds(230,160,200,20);
		t2.setFont(f);
		add(t2);
		
		b1=new JButton();
		b1.setIcon(new ImageIcon(dimg4));
		b1.setBounds(150,210,70,50);
		b1.setBackground(c);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setBorder(null);
		add(b1);
		
		b2=new JButton();
		b2.setIcon(new ImageIcon(dimg5));
		b2.setBounds(260,210,70,50);
		b2.setBackground(c);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setBorder(null);
		add(b2);
		
		back=new JButton();
		back.setIcon(new ImageIcon(dimg2));
		back.setBounds(445,280,50,50);
		back.setBackground(c);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		add(back);
		
		home=new JButton();
		home.setIcon(new ImageIcon(dimg1));
		home.setBounds(0,280,50,50);
		home.setBackground(c);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		add(home);

		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300,300);
		setSize(500,360);
		
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
				{
					if(t1.getText().equals("")||t2.getText().equals(""))
					{
						JOptionPane.showMessageDialog(this, "Please Fill all the required fields");
					}
					else
					{
						String name = t1.getText();
						
						t1.setText("");
						t2.setText("");
						Stop u = new Stop(name);
						try {
							u.regStop();
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
						Stop m = new Stop(t1.getText());
						try {
							m = m.search();
						} catch (NumberFormatException | SQLException e) {
							JOptionPane.showMessageDialog(this, e.getMessage());
						}
						if(m != null){
							t1.setText(m.name);
							t2.setText(m.noOfRoutes+"");
						}
						else JOptionPane.showMessageDialog(this, "This Stop doesnt exist");
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
						Stop m = new Stop(t1.getText());
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
					JOptionPane.showMessageDialog(this, "Please choose any action!");
				}
		}
		else if(ae.getSource()==b2)
		{
			t1.setText("");
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
		else
		{
				JComboBox<String> comboBox = (JComboBox<String>) ae.getSource();
                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals("Add"))
				{
					l2.setEnabled(false);
					//l3.setEnabled(false);
					t2.setEnabled(false);
					//t3.setEnabled(false);
					b1.setIcon(new ImageIcon(dimg4));
				}
                else if(selected.toString().equals("Search"))
				{
					l2.setEnabled(false);
					//l3.setEnabled(false);
					t2.setEnabled(false);
					//t3.setEnabled(false);
					b1.setIcon(new ImageIcon(dimg3));
					t1.setDisabledTextColor(c);
					t2.setDisabledTextColor(c);
					//t3.setDisabledTextColor(c);
				}
				else
				{
					l2.setEnabled(false);
					//l3.setEnabled(false);
					t2.setEnabled(false);
					//t3.setEnabled(false);
					b1.setIcon(new ImageIcon(dimg6));
				}
				
		}
	}
}
		
		