package com.elizalde.laberinto.userinterface;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class  UserInterface extends JPanel implements ActionListener,ChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int width;
	private int height;
	private JLabel [] labels = new JLabel[6];
	private JSlider[] sliders = new JSlider[5];
	private JButton[] buttons = new JButton[4];
	private JPanel[] panels = new JPanel[6];
	private JCheckBox verEntrenamiento = new JCheckBox();
	private int[] values = {10,0,0,0,0,0,0,0};
	private boolean[] buttonValues = {false,false,false,false};
	private int gridSize;
	public UserInterface(int width,int height)
	{
		this.width = width;
		this.height = height;
		setLayout(new GridLayout(7,1,0,0));
		//setSize(this.width,this.height);		
		setBounds((int)(height),0,width,height);
		setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		//Tamaño del Laberinto
		
		//Label0
		labels[0] = new JLabel("Ajuste el Tamaño el Laberinto:");
		labels[0].setHorizontalAlignment(JLabel.CENTER);
		
		//Slider 0
		sliders[0] = new JSlider(SwingConstants.HORIZONTAL,10,40,10);
		sliders[0].setMajorTickSpacing(1);
		sliders[0].setPaintTicks(true);
		sliders[0].addChangeListener(this);
		
		//Panel 0
		panels[0] = new JPanel(new GridLayout(1,2,5,5));
		panels[0].add(labels[0]);
		panels[0].add(sliders[0]);
		add(panels[0]);
		
		//Label 1
		labels[1] = new JLabel("Agua");
		labels[1].setHorizontalAlignment(JLabel.CENTER);
		
		//Slider 1
		sliders[1] = new JSlider(SwingConstants.HORIZONTAL,0,30,0);
		sliders[1].setMajorTickSpacing(3);
		sliders[1].setPaintTicks(true);
		sliders[1].addChangeListener(this);
		
		//Panel 1
		panels[1] = new JPanel(new GridLayout(1,2,5,5));
		panels[1].add(labels[1]);
		panels[1].add(sliders[1]);
		add(panels[1]);
		
		//Label 2
		labels[2] = new JLabel("Piedras");
		labels[2].setHorizontalAlignment(JLabel.CENTER);
	
		//Slider 2
		sliders[2] = new JSlider(SwingConstants.HORIZONTAL,0,30,0);
		sliders[2].setMajorTickSpacing(3);
		sliders[2].setPaintTicks(true);
		sliders[2].addChangeListener(this);
		
		//Panel 2
		panels[2] = new JPanel(new GridLayout(1,2,5,5));
		panels[2].add(labels[2]);
		panels[2].add(sliders[2]);
		add(panels[2]);
		
		//Label 3
		labels[3] = new JLabel("Montaña");
		labels[3].setHorizontalAlignment(JLabel.CENTER);
		
		//Slider 3
		sliders[3] = new JSlider(SwingConstants.HORIZONTAL,0,30,0);
		sliders[3].setMajorTickSpacing(1);
		sliders[3].setPaintTicks(true);
		sliders[3].addChangeListener(this);
		
		//Panel 3
		panels[3] = new JPanel(new GridLayout(1,2,5,5));
		panels[3].add(labels[3]);
		panels[3].add(sliders[3]);
		add(panels[3]);
		
		
		labels[4] = new JLabel("Baranco");
		labels[4].setHorizontalAlignment(JLabel.CENTER);
		
		sliders[4] = new JSlider(SwingConstants.HORIZONTAL,0,30,0);
		sliders[4].setMajorTickSpacing(1);
		sliders[4].setPaintTicks(true);
		sliders[4].addChangeListener(this);
		
		panels[4] = new JPanel(new GridLayout(1,2,5,5));
		panels[4].add(labels[4]);
		panels[4].add(sliders[4]);
		add(panels[4]);
		
		
		labels[5] = new JLabel("Ver Entrenamiento");
		labels[5].setHorizontalAlignment(JLabel.CENTER);
		
		verEntrenamiento.setSelected(true);
		verEntrenamiento.addChangeListener(this);
		
		panels[5] = new JPanel(new GridLayout(1,2,5,5));
		panels[5].add(labels[5]);
		panels[5].add(verEntrenamiento);
		add(panels[5]);
		
		
		
		
		
		//Container for Buttons
		JPanel buttonContainer = new JPanel(new GridLayout(1,3,5,5));
		buttons[0] = new JButton("Generar Laberinto");
		buttons[1] = new JButton("Link");
		buttons[2] = new JButton("Dungeon");
		buttons[3] = new JButton("Reset");
		
		buttons[1].setEnabled(false);
		buttons[2].setEnabled(false);
		buttons[3].setEnabled(false);
		
		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		buttons[2].addActionListener(this);
		buttons[3].addActionListener(this);
		
		for(int i = 0; i < buttons.length;i++)
		buttonContainer.add(buttons[i]);
		
		add(buttonContainer);
		printSizes();
	}
	public void printSizes()
	{
		System.out.println("Start Location of UserInterface: " + width);
		System.out.println("Size of the UserInterface: " + width + " :  " + height);
	}
	int getGridSize()
	{
		return gridSize;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		if(arg0.getSource() == buttons[0])
		{
			if(buttonValues[0] == true)
			{
				buttonValues[0] = false;
			}
			else
			{
				buttonValues[0] = true;
			}
			buttons[0].setEnabled(false);
			buttons[1].setEnabled(true);
			buttons[3].setEnabled(true);
		}
		if(arg0.getSource() == buttons[1])
		{
			if(buttonValues[1] == true)
				buttonValues[1] = false;
			else{buttonValues[1] = true;}
			buttons[1].setEnabled(false);
			buttons[2].setEnabled(true);
		}
		if(arg0.getSource() == buttons[2])
		{
			if(buttonValues[2] == true)
				buttonValues[2] = false;
			else{buttonValues[2] = true;}
			buttons[2].setEnabled(false);
		}
		if(arg0.getSource() == buttons[3])
		{
			if(buttonValues[3] == true)
				buttonValues[3] = false;
			else{buttonValues[3] = true;}
			buttons[3].setEnabled(false);
			buttons[0].setEnabled(true);
			buttons[1].setEnabled(false);
			buttons[2].setEnabled(false);
		}
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		if(arg0.getSource() == sliders[0])
		{	
			values[0] = (sliders[0].getValue());
		}
		if(arg0.getSource() == sliders[1])
		{
			
			values[1] = (sliders[1].getValue());
		}
		if(arg0.getSource() == sliders[2])
		{
			
			values[2] = (sliders[2].getValue());
		}
		if(arg0.getSource() == sliders[3])
		{
			
			values[3] = (sliders[3].getValue());
		}
		if(arg0.getSource() == sliders[4])
		{
			values[4] = (sliders[4]).getValue();
		}
	}
	public int[] getInterfaceValues()
	{
		return values;
	}
	public boolean[] getButtons()
	{
		return buttonValues;
	}
	public boolean getCheck()
	{
		return verEntrenamiento.isSelected();
		
	}
}
