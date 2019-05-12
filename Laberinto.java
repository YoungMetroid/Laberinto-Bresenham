package com.elizalde.laberinto;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.elizalde.laberinto.panels.labyrinthPanel;
import com.elizalde.laberinto.userinterface.UserInterface;

public class Laberinto extends JFrame implements Runnable,ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 270;
	public static int height = 170;
	public static int scale = 4;
	public static Dimension size = new Dimension(width*scale,height*scale);
	
	//The width and the height are the same for the labyrinth
	public static Dimension mainLabyrinthSize  = new Dimension((int)(size.getHeight()),
												(int) size.getHeight());
	public static Dimension mainInterfaceSize = new Dimension((int)(size.getWidth()-size.getHeight()),
												(int)size.getHeight());
	private JPanel mainPanel;
	private labyrinthPanel lp;
	private UserInterface interfaces;

	public Thread thread;
	boolean running = false;
	boolean  learningMethod = false;
	
	int values[];
	final int Mombo = 1;
	final int Pirolo = 2;
	final int Lucas = 3;
	public static String title = "Laberinto";
	public Laberinto()
	{

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		setPreferredSize(size);
	
		mainPanel = new JPanel(null);
		mainPanel.setVisible(true);
		add(mainPanel);
		/*labyrinthHolder = new JPanel(new GridLayout());
		labyrinthHolder.setVisible(true);
		
		labyrinthHolder.setBounds(0, 0, (int)mainPanelSize.getWidth(),(int)mainPanelSize.getHeight());
		
		JButton button = new JButton("Test");
		button.setBounds(0, 0, 100, 100);
		button.setVisible(true);
		labyrinthHolder.add(button);
		mainPanel.add(labyrinthHolder);	
		*/
		interfaces = new UserInterface((int)mainInterfaceSize.getWidth(),
				(int)mainInterfaceSize.getHeight());
		mainPanel.add(interfaces);
		startListening();
		
	}
	public synchronized void startListening()
	{
		running = true;
		thread = new Thread(this,"Results");
		thread.start();
	}
	public static void main(String[] args)
	{
		Laberinto laberinto = new Laberinto();
		laberinto.setResizable(false);
		laberinto.setTitle(Laberinto.title);
		laberinto.pack();
		laberinto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		laberinto.setLocationRelativeTo(null);
		laberinto.setVisible(true);
	}	
	public void printSizes()
	{
		System.out.println("Frame size: " + this.getWidth() + " " + this.getHeight());
		System.out.println("MainPanel size: " + mainPanel.getWidth() + " " + mainPanel.getHeight());
		System.out.println("JPanel size: " + lp.getWidth() + " " + lp.getHeight());;
	}
	

	public void run()
	{
		
		while(running)
		{
			try {
				// TimeUnit.SECONDS.sleep(0.5);
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if(interfaces.getButtons()[0] == true)
			{
				lp = new labyrinthPanel(interfaces.getInterfaceValues(),
						(int)mainLabyrinthSize.getHeight(),interfaces);
				mainPanel.add(lp);
				lp.loadGrid();
				interfaces.getButtons()[0] = false;
			}
			
			if(interfaces.getButtons()[1] == true)
			{
				lp.setLinkImage();
				interfaces.getButtons()[1] = false;
			}
			if(interfaces.getButtons()[2] == true)
			{
				lp.setPotImage();
				
					try {
						// TimeUnit.SECONDS.sleep(0.5);
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(lp.potLocation >= 0)
					{
						lp.entrenamiento(Mombo, true);
						for(int i = 0; i < 1000;i++)
						{
							lp.entrenamiento(Mombo,false);
							if(i < 999)
							{
								lp.linkFound();
							}
						}
						
						lp.entrenamiento(Pirolo,true);
						for(int i = 0; i < 1000;i++)
						{
							lp.entrenamiento(Pirolo,false);
							if(i < 999)
							{
								lp.linkFound();
							}
						}
						lp.entrenamiento(Lucas,true);
						for(int i = 0; i < 1000;i++)
						{
							lp.entrenamiento(Lucas,false);
							if(i < 999)
							{
								lp.linkFound();
							}
						}
						System.out.println("Dijkstra");
						lp.calculateDijstra();
						lp.printGridValues();
						learningMethod = true;
						interfaces.getButtons()[2] = false;
						
					}
				
			}
			if(interfaces.getButtons()[2] == false  && learningMethod == true)
			{
				if(lp.getDijkstraClick())
				{
					lp.dijkstra();
				}
			}
			if(interfaces.getButtons()[3] == true)
			{
				System.out.println("Button 3 Active");
				lp.clearAll();
				try {
					// TimeUnit.SECONDS.sleep(0.5);
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				learningMethod = false;
				lp.removeAll();
				interfaces.getButtons()[3] = false;
			}
			 
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}	
}
