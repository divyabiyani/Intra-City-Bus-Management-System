package labProject;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.awt.image.*;

import javax.imageio.*;

import java.awt.image.BufferedImage.*;

import javax.swing.border.*;
public class ManDisplay extends JFrame implements ActionListener , MouseListener
{
	JButton b1,b2,b3,b4,b5,b6,back,home;
	Color c,c1;
	Border br;
	JLabel l1;
	Font f;
	
	ManDisplay()
	{
		BufferedImage img = null,img1 = null,img2 = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\back.jpg"));	
			img1 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\home.jpg"));
			img2 = ImageIO.read(new File("C:\\Users\\user\\workspace_ide\\BusManagement\\src\\labProject\\bck.jpg"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(300, 380,Image.SCALE_SMOOTH);
		Image dimg1 = img1.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		Image dimg2 = img2.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(dimg)));
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setSize(300,300);
		setTitle("Manager Toggle Page");
		pack();
		setLocationRelativeTo(null);
		
		c=new Color(224,224,224);
		
		c1=new Color(96,96,96);
		
		br=new EmptyBorder(15, 10, 15, 10);
		f = new Font("Arial", Font.BOLD,20);
		
		Font f2=new Font("Arial",Font.BOLD,30);
		
//		hl=new JLabel("Manager Login");
//		hl.setBounds(130,50,300,40);
//		hl.setFont(f2);
//		//hl.setForeground(c1);
//		add(hl);
		
		l1=new JLabel("Manipulate Entities");
		l1.setBounds(10,10,300,40);
		l1.setFont(f2);
		add(l1);
				
		b1=new JButton("User");
		b1.setBounds(30,100,100,30);
		b1.setBackground(c);
		b1.setBorder(br);
		b1.setOpaque(false);
		b1.setFont(f);
		b1.setForeground(c1);
		add(b1);
		
		b2=new JButton("Driver");
		b2.setBounds(170,100,100,30);
		b2.setBackground(c);
		b2.setBorder(br);
		b2.setOpaque(false);
		b2.setFont(f);
		b2.setForeground(c1);
		add(b2);
		
		b3=new JButton("Manager");
		b3.setBounds(30,170,120,30);
		b3.setBackground(c);
		b3.setBorder(br);
		b3.setOpaque(false);
		b3.setFont(f);
		b3.setForeground(c1);
		add(b3);
		
		b4=new JButton("Bus");
		b4.setBounds(170,170,100,30);
		b4.setBackground(c);
		b4.setBorder(br);
		b4.setOpaque(false);
		b4.setFont(f);
		b4.setForeground(c1);
		add(b4);
		
		b5=new JButton("Stop");
		b5.setBounds(30,240,100,30);
		b5.setBackground(c);
		b5.setBorder(br);
		b5.setOpaque(false);
		b5.setFont(f);
		b5.setForeground(c1);
		add(b5);
		
		b6=new JButton("Route");
		b6.setBounds(170,240,100,30);
		b6.setBackground(c);
		b6.setBorder(br);
		b6.setOpaque(false);
		b6.setFont(f);
		b6.setForeground(c1);
		add(b6);
		
		back=new JButton();
		back.setIcon(new ImageIcon(dimg2));
		back.setBounds(245,300,50,50);
		back.setBackground(c);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		add(back);
		
		home=new JButton();
		home.setIcon(new ImageIcon(dimg1));
		home.setBounds(0,300,50,50);
		home.setBackground(c);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		add(home);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300,380);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		b1.addMouseListener(this);
		b2.addMouseListener(this);
		b3.addMouseListener(this);
		b4.addMouseListener(this);
		b5.addMouseListener(this);
		b6.addMouseListener(this);
		
		back.addActionListener(this);
		home.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			new ManiUser();
		}
		else if(ae.getSource()==b2)
		{
			new ManiDriver();
		}
		else if(ae.getSource()==b3)
		{
			new ManiManager();
		}
		else if(ae.getSource()==b4)
		{
			new ManiBus();
		}
		else if(ae.getSource()==b5)
		{
			new ManiStop();
		}
		else if(ae.getSource()==b6)
		{
			new ManiRoute();
		}
		else if(ae.getSource()==back)
		{
			new ManLogin();
			
		}
		else if(ae.getSource()==home)
		{
			new Start();
		}
		setVisible(false);
	}

//    public void mouseMoved(MouseEvent evt)
//    {
//    	if(evt.getSource()==b1)
//			b1.setForeground(Color.BLACK);
//		else if(evt.getSource()==b2)
//			b2.setForeground(Color.BLACK);
//		else if(evt.getSource()==b3)
//			b3.setForeground(Color.BLACK);
//		else if(evt.getSource()==b4)
//			b4.setForeground(Color.BLACK);
//		else if(evt.getSource()==b5)
//			b5.setForeground(Color.BLACK);
//		else if(evt.getSource()==b6)
//			b6.setForeground(Color.BLACK);
//    }

    public void mouseEntered(MouseEvent evt)
    {
    	if(evt.getSource()==b1)
			b1.setForeground(Color.BLACK);
		else if(evt.getSource()==b2)
			b2.setForeground(Color.BLACK);
		else if(evt.getSource()==b3)
			b3.setForeground(Color.BLACK);
		else if(evt.getSource()==b4)
			b4.setForeground(Color.BLACK);
		else if(evt.getSource()==b5)
			b5.setForeground(Color.BLACK);
		else if(evt.getSource()==b6)
			b6.setForeground(Color.BLACK);
    }
    public void mouseExited(MouseEvent evt)
    {
    	if(evt.getSource()==b1)
			b1.setForeground(c1);
		else if(evt.getSource()==b2)
			b2.setForeground(c1);
		else if(evt.getSource()==b3)
			b3.setForeground(c1);
		else if(evt.getSource()==b4)
			b4.setForeground(c1);
		else if(evt.getSource()==b5)
			b5.setForeground(c1);
		else if(evt.getSource()==b6)
			b6.setForeground(c1);
    }
    public void mouseDragged(java.awt.event.MouseEvent evt)
    {}
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
    
	
}