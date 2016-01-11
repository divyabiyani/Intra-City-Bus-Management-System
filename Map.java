package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;

public class Map extends JFrame implements ActionListener{
	JButton b1;
	Map()
	{
		BufferedImage img = null,img1=null;
		try {

			img = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\map.jpg"));
			img1 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\clear.jpg"));
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		Image dimg = img.getScaledInstance(650, 650,Image.SCALE_SMOOTH);
		Image dimg1 = img1.getScaledInstance(25, 25,Image.SCALE_SMOOTH);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		setVisible(true);
		setResizable(false);
		//setSize(300,300);
		setTitle("Map Display");
		pack();
		setLocationRelativeTo(null);
		
		b1=new JButton();
		b1.setIcon(new ImageIcon(dimg1));
		b1.setBounds(610,10,25,25);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		add(b1);
		
		b1.addActionListener(this);
		
		
		setSize(650,680);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			setVisible(false);
		}
	}

}
