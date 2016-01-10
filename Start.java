package labProject;


import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;
public class Start extends JFrame implements ActionListener
{
	JLabel pl;
	JButton b1,b2,b3,b4;
	Color c;
	
	Start()
	{
		
		BufferedImage img = null,img1 = null,img2 = null,img3 = null,img4 = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\back.jpg"));
			img1 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\bus.jpg"));
			img2 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\welcome.png"));
			img3 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\manager.jpg"));
			img4 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\user.jpg"));
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		Image dimg = img.getScaledInstance(500, 500,Image.SCALE_SMOOTH);
		Image dimg1 = img1.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
		Image dimg2 = img2.getScaledInstance(300, 100,Image.SCALE_SMOOTH);
		Image dimg3 = img3.getScaledInstance(100, 100,Image.SCALE_SMOOTH);
		Image dimg4 = img4.getScaledInstance(100, 100,Image.SCALE_SMOOTH);
		
		
		setTitle("Jaipur Local Bus Route");		
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
		
		b3=new JButton();
		b3.setIcon(new ImageIcon(dimg2));
		b3.setBounds(100,10,300,100);
		b3.setBackground(c);
		b3.setOpaque(false);
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		add(b3);
				
		b4=new JButton();
		b4.setIcon(new ImageIcon(dimg1));
		b4.setBounds(10,150,250,250);
		b4.setBackground(c);
		b4.setOpaque(false);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		add(b4);
		
		b1=new JButton();
		b1.setIcon(new ImageIcon(dimg3));
		b1.setBounds(300,150,100,100);
		b1.setBackground(c);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		add(b1);
		
		b2=new JButton();
		b2.setIcon(new ImageIcon(dimg4));
		b2.setBounds(300,300,100,100);
		b2.setBackground(c);
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		add(b2);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b4.addActionListener(this);
		
		setSize(500,500);
		setSize(500,500);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			new ManLogin();
			setVisible(false);
		}
		else if(ae.getSource()==b2)
		{
			new UserLogin();
			setVisible(false);
		}
		else if(ae.getSource()==b4)
		{
			new Map();
			
		}
	}
}