package com.elizalde.laberinto.panels;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.elizalde.laberinto.userinterface.UserInterface;

import javax.swing.JLabel;

public class labyrinthPanel extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static String waterPath1 ="/textures/water1.png";
	
	
	private static String baranco = "/textures/Baranco.png";
	private static String mountain_0 = "/textures/Mountain_3.png";
	private static String mountain_1 = "/textures/Mountain_4.png";
	
	private static String brickPath = "/textures/brick.png";
	private static String grassPath = "/textures/grass.png";
	private static String desertGrassPath = "/textures/desertGrass.png";
	private static String startPath = "/textures/start.png";
	private static String potPath = "/textures/pot.png";
	private static String linkPath = "/textures/link.png";
	private static String blueLinkPath = "/textures/blueLink.png";
	private static String redLinkPath = "/textures/redLink.png";
	
	//Images
	
	private BufferedImage startBefore;
	private BufferedImage startAfter;
	
	private BufferedImage water1Before;
	private BufferedImage water1After;
	
	private BufferedImage brickBefore;
	private BufferedImage brickAfter;
	
	private BufferedImage grassBefore;
	private BufferedImage grassAfter;
	private BufferedImage desGrassBefore;
	private BufferedImage desGrassAfter;
	
	private BufferedImage linkBefore;
	private BufferedImage linkAfter;
	
	private BufferedImage blueLinkBefore;
	private BufferedImage blueLinkAfter;
	
	private BufferedImage redLinkBefore;
	private BufferedImage redLinkAfter;
	
	private BufferedImage linkWater;
	private BufferedImage linkMountain;
	private BufferedImage linkBaranco;
	private BufferedImage linkdesertGrass;
	private BufferedImage linkStart;
	private BufferedImage linkPot;
	
	private BufferedImage redLinkWater;
	private BufferedImage redLinkMountain;
	private BufferedImage redLinkBaranco;
	private BufferedImage redLinkDesert;
	private BufferedImage redLinkStart;
	private BufferedImage redLinkPot;
	
	private BufferedImage blueLinkWater;
	private BufferedImage blueLinkMountain;
	private BufferedImage blueLinkBaranco;
	private BufferedImage blueLinkDesert;
	private BufferedImage blueLinkStart;
	private BufferedImage blueLinkPot;
	
	private BufferedImage potBefore;
	private BufferedImage potAfter;
	private BufferedImage barancoBefore;
	private BufferedImage barancoAfter;
	private BufferedImage mountain_0_Before;
	private BufferedImage mountain_0_After;
	private BufferedImage mountain_1_Before;
	private BufferedImage mountain_1_After;
	
	private ImageIcon startIcon;
	private ImageIcon waterIcon;
	private ImageIcon brickIcon;
	private ImageIcon grassIcon;
	private ImageIcon desGrassIcon;
	private ImageIcon linkIcon;
	private ImageIcon linkwIcon;
	private ImageIcon linkdesIcon;
	private ImageIcon linkMountainIcon;
	private ImageIcon linkBarancoIcon;
	private ImageIcon linkStartIcon;
	private ImageIcon linkPotIcon;
	
	
	private ImageIcon redLinkIcon;
	private ImageIcon redLinkDIcon;
	private ImageIcon redLinkWIcon;
	private ImageIcon redLinkMIcon;
	private ImageIcon redLinkBIcon;
	private ImageIcon redLinkStartIcon;
	private ImageIcon redLinkPotIcon;
	
	private ImageIcon blueLinkIcon;
	private ImageIcon blueLinkDIcon;
	private ImageIcon blueLinkWIcon;
	private ImageIcon blueLinkMIcon;
	private ImageIcon blueLinkBIcon;
	private ImageIcon blueLinkStartIcon;
	private ImageIcon blueLinkPotIcon;
	
	private ImageIcon potIcon;
	private ImageIcon barancoIcon;
	private ImageIcon mountain_0_Icon;
	private ImageIcon mountain_1_Icon;
	
	BufferedImage bImage;
	ImageIcon image;
	private int laberinthSize;
	private int[] obstacleValues;
	private static JLabel[] labels;
	private Vector<Long> info;   
	public boolean running; 
	// Contains the type of terrain for every character  and if it has been visited
	// 0. Terrain
	// 1. Mombo weight
	// 2. Pirolo weight
	// 3. Lucas weight
	// 4. Flag if visited	
	// Have to make all the visited positions false again
	// 
	
	
	private Vector<Vector<Long>> row;
	private Vector<Vector<Vector<Long>>> column;
	
	private Vector<Double>Mombo;  //Contains weigth for the terrain and cost
	private Vector<Double>Pirolo;
	private Vector<Double>Lucas;
	
	private Vector<Integer> coordinates;
	private Vector<Vector<Integer>> visitedList;
	private Vector<Vector<Integer>> lastPosition;
	
	private int linkRow = 0, linkColumn = 0;
	private int staticlinkR = 0, staticlinkC = 0;
	
	private Vector <Integer>randomSelection,randomCorner,randomSide;

	private int[] terrainValues;
	private boolean placeLink = false;
	private boolean placePot = false;
	
	private int linkLocation = -1;
	public int potLocation = -1;
	
	//BootStrap Variables
	private int sleeptime = 0;
	private int looptime = 5;
	private double media = 0;
	private double lowestValue = 0;
	private double highestValue = 0;
	private  Vector<Vector<Vector<Long>>> columnDijkstra;
	private Vector<Vector<Long>> rowDijkstra;
	private Vector<Long> infoDijkstra;
	
	private int [][] distanceMatrixMombo;
	private int [][] distanceMatrixPirolo;
	private int [][] distanceMatrixLucas;
	
	private String [][] previousMatrixMombo;
	private String [][] previousMatrixPirolo;
	private String [][] previousMatrixLucas;
	
	private boolean [][] MomboList;
	private boolean [][] PiroloList;
	private boolean [][] LucasList;
	
	private Vector<Vector<Integer>> MomboQueue;
	private Vector<Vector<Integer>> PiroloQueue;
	private Vector<Vector<Integer>> LucasQueue;
	
	private Vector<Vector<Vector<Integer>>> MomboTreePath;
	private Vector<Vector<Vector<Integer>>> PiroloTreePath;
	private Vector<Vector<Vector<Integer>>> LucasTreePath;
	
	private Vector<Integer>tempInfo;
	
	private boolean DijkstraClick = true;
	private UserInterface UI;
	
	
	//private long initialPonderation = 100000;
	private long initialPonderation = Integer.MAX_VALUE/2;
	
	//BooStrap Variables End
	
	
	
	public enum ids{
		grass(1),
		grassDes(2),
		rock(10),
		mountain(4),
		terrainType(0),
		valley(3),
		visited(4),
		water(5),
		weight(1);
		private final int value;
		
		ids(final int newValue)
		{
			value =  newValue;
		}
		
		public int getValue(){return value;}
		
	} 
	public enum terrains{
		moutain(1),
		water(2),
		valley(3),
		plain(4);
		
		private final int value;
		
		terrains(final int newValue)
		{
			value = newValue;
		}
		
		public int getValue(){ return value;}
		
	}
	
	public labyrinthPanel(int obstacleValuess[],int laberinthSizes, UserInterface interfaces)
	{	
		UI = interfaces;
		System.out.println("Generated");
		obstacleValues = obstacleValuess;
		laberinthSize = laberinthSizes;
		setLayout(new GridLayout(obstacleValues[0],obstacleValues[0],0,0));
		setSize(laberinthSize,laberinthSize);
		labels = new JLabel[obstacleValues[0]*obstacleValues[0]];
		info = new Vector<Long>();
		row  = new Vector<Vector<Long>>();
		column = new Vector<Vector<Vector<Long>>>();
		terrainValues = new int[obstacleValues[0]*obstacleValues[0]];
		
		Mombo  = new Vector<Double>();
		Pirolo  = new Vector<Double>();
		Lucas  = new Vector<Double>();
		
		
		Mombo.addElement(0.0);
		Mombo.addElement(2.5);
		Mombo.addElement(0.3);
		Mombo.addElement(1.5);
		Mombo.addElement(1.0);
		Mombo.addElement(0.0);
		
		Pirolo.addElement(0.0);
		Pirolo.addElement(0.3);
		Pirolo.addElement(2.5);
		Pirolo.addElement(1.0);
		Pirolo.addElement(1.5);
		Pirolo.addElement(0.0);
		
		Lucas.addElement(0.0);
		Lucas.addElement(1.5);
		Lucas.addElement(1.0);
		Lucas.addElement(2.5);
		Lucas.addElement(0.3);
		Lucas.addElement(0.0);
		
		System.out.println("OB:  " + obstacleValues[2]);
	}
	
	public void setLayout(int gridSize)
	{
		setLayout(new GridLayout(this.obstacleValues[0],this.obstacleValues[0],0,0));
	}
	public void generateTerrain()
	{
		
	}
	public void loadGrid()
	{
		try {
			water1Before = ImageIO.read(labyrinthPanel.class.getResource(waterPath1));
			brickBefore = ImageIO.read(labyrinthPanel.class.getResource(brickPath));
			grassBefore = ImageIO.read(labyrinthPanel.class.getResource(grassPath));
			desGrassBefore = ImageIO.read(labyrinthPanel.class.getResource(desertGrassPath));
			linkBefore = ImageIO.read(labyrinthPanel.class.getResource(linkPath));
			blueLinkBefore = ImageIO.read(labyrinthPanel.class.getResource(blueLinkPath));
			redLinkBefore = ImageIO.read(labyrinthPanel.class.getResource(redLinkPath));
			potBefore = ImageIO.read(labyrinthPanel.class.getResource(potPath));
			barancoBefore = ImageIO.read(labyrinthPanel.class.getResource(baranco));
			mountain_0_Before = ImageIO.read(labyrinthPanel.class.getResource(mountain_0));
			mountain_1_Before = ImageIO.read(labyrinthPanel.class.getResource(mountain_1));
			
			startBefore = ImageIO.read(labyrinthPanel.class.getResource(startPath));
			
			startIcon = new ImageIcon();
			waterIcon = new ImageIcon();
			brickIcon = new ImageIcon();
			grassIcon = new ImageIcon();
			desGrassIcon = new ImageIcon();
			
			linkIcon = new ImageIcon();
			linkwIcon = new ImageIcon();
			linkdesIcon = new ImageIcon();
			linkMountainIcon = new ImageIcon();
			linkBarancoIcon = new ImageIcon();
			linkStartIcon = new ImageIcon();
			linkPotIcon = new ImageIcon();
			
			redLinkIcon = new ImageIcon();
			redLinkDIcon = new ImageIcon();
			redLinkMIcon = new ImageIcon();
			redLinkWIcon = new ImageIcon();
			redLinkBIcon = new ImageIcon();
			redLinkIcon = new ImageIcon();
			redLinkStartIcon = new ImageIcon();
			redLinkPotIcon = new ImageIcon();
			
			blueLinkIcon = new ImageIcon();
			blueLinkDIcon = new ImageIcon();
			blueLinkMIcon = new ImageIcon();
			blueLinkWIcon = new ImageIcon();
			blueLinkBIcon = new ImageIcon();
			blueLinkStartIcon = new ImageIcon();
			blueLinkPotIcon = new ImageIcon();
			
			potIcon = new ImageIcon();
			barancoIcon = new ImageIcon();
			mountain_0_Icon = new ImageIcon();
			mountain_1_Icon = new ImageIcon();
			
			int w = (int)(laberinthSize/obstacleValues[0]);
			int h = w;
			
			startAfter = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			water1After = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			brickAfter = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			grassAfter = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			desGrassAfter = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			linkAfter = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			linkWater = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			linkdesertGrass = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			linkMountain = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			linkBaranco = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			linkStart = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			linkPot = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			
			
			redLinkAfter =  new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			redLinkWater =  new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			redLinkMountain = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			redLinkBaranco = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			redLinkDesert = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			redLinkStart = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			redLinkPot = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			
			blueLinkAfter =  new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			blueLinkWater =  new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			blueLinkMountain = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			blueLinkBaranco = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			blueLinkDesert = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			blueLinkStart = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			blueLinkPot = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			
			
			potAfter = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			barancoAfter = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			mountain_0_After = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			mountain_1_After = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			
			Graphics2D startGrph = startAfter.createGraphics();
			Graphics2D waterGrph = water1After.createGraphics();
			Graphics2D brickGrph = brickAfter.createGraphics();
			Graphics2D grassGrph = grassAfter.createGraphics();
			Graphics2D desGrassGrph = desGrassAfter.createGraphics();
			Graphics2D barancoGrph = barancoAfter.createGraphics();
			Graphics2D mountain_0_Grph = mountain_0_After.createGraphics();
			Graphics2D mountain_1_Grph = mountain_1_After.createGraphics();
			
			
			Graphics2D linkGrph = linkAfter.createGraphics();
			Graphics2D linkwGrph = linkWater.createGraphics();
			Graphics2D linkdgGrph = linkdesertGrass.createGraphics();
			Graphics2D linkBGrph = linkBaranco.createGraphics();
			Graphics2D linkMGrph = linkMountain.createGraphics();
			Graphics2D linkStartGrph = linkStart.createGraphics();
			Graphics2D linkPotGrph = linkPot.createGraphics();
			
			Graphics2D blueLinkGrph = blueLinkAfter.createGraphics();
			Graphics2D blueLinkWGrph = blueLinkWater.createGraphics();
			Graphics2D blueLinkDGrph = blueLinkDesert.createGraphics();
			Graphics2D blueLinkBGrph = blueLinkBaranco.createGraphics();
			Graphics2D blueLinkMGrph = blueLinkMountain.createGraphics();
			Graphics2D blueLinkStartGrph = blueLinkStart.createGraphics();
			Graphics2D blueLinkPotGrph = blueLinkPot.createGraphics();
			
			Graphics2D redLinkGrph = redLinkAfter.createGraphics();
			Graphics2D redLinkWGrph = redLinkWater.createGraphics();
			Graphics2D redLinkDGrph = redLinkDesert.createGraphics();
			Graphics2D redLinkBGrph = redLinkBaranco.createGraphics();
			Graphics2D redLinkMGrph = redLinkMountain.createGraphics();
			Graphics2D redLinkStartGrph = redLinkStart.createGraphics();
			Graphics2D redLinkPotGrph = redLinkPot.createGraphics();
			
			
			Graphics2D potGrph = potAfter.createGraphics();
			
			
			startGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			startGrph.drawImage(startBefore, 0, 0, w,h,null);
			startGrph.dispose();
			
			waterGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			waterGrph.drawImage(water1Before,0,0,w,h,null);
			waterGrph.dispose();
			
			brickGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			brickGrph.drawImage(brickBefore,0,0,w,h,null);
			brickGrph.dispose();
			
			grassGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			grassGrph.drawImage(grassBefore,0,0,w,h,null);
			grassGrph.dispose();
			
			desGrassGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			desGrassGrph.drawImage(desGrassBefore,0,0,w,h,null);
			desGrassGrph.dispose();
			
			barancoGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			barancoGrph.drawImage(barancoBefore,0,0,w,h,null);
			barancoGrph.dispose();
			
			mountain_0_Grph.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			mountain_0_Grph.drawImage(mountain_0_Before, 0, 0, w,h,null);
			mountain_0_Grph.dispose();
			
			mountain_1_Grph.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			mountain_1_Grph.drawImage(mountain_1_Before, 0, 0, w,h,null);
			mountain_1_Grph.dispose();
			
			linkGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkGrph.drawImage(grassBefore,0,0,w,h,null);
			linkGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkGrph.drawImage(linkBefore,0,0,w,h,null);
			linkGrph.dispose();
			
			linkwGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkwGrph.drawImage(water1Before,0,0,w,h,null);
			linkwGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkwGrph.drawImage(linkBefore,0,0,w,h,null);
			linkwGrph.dispose();
			
			linkdgGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkdgGrph.drawImage(desGrassBefore,0,0,w,h,null);
			linkdgGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkdgGrph.drawImage(linkBefore,0,0,w,h,null);
			linkdgGrph.dispose();
			
			linkMGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkMGrph.drawImage(mountain_0_Before,0,0,w,h,null);
			linkMGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkMGrph.drawImage(linkBefore, 0, 0, w, h, null);
			linkMGrph.dispose();
			
			linkBGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkBGrph.drawImage(barancoBefore,0,0,w,h,null);
			linkBGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkBGrph.drawImage(linkBefore, 0, 0, w, h, null);
			linkBGrph.dispose();
			
			linkStartGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkStartGrph.drawImage(startBefore,0,0,w,h,null);
			linkStartGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkStartGrph.drawImage(linkBefore, 0, 0, w, h, null);
			linkStartGrph.dispose();
			
			linkPotGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkPotGrph.drawImage(potBefore,0,0,w,h,null);
			linkPotGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			linkPotGrph.drawImage(linkBefore,0,0,w,h,null);
			linkPotGrph.dispose();
			
			//Red Link
			redLinkGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkGrph.drawImage(grassBefore,0,0,w,h,null);
			redLinkGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkGrph.drawImage(redLinkBefore,0,0,w,h,null);	
			redLinkGrph.dispose();
			
			redLinkWGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkWGrph.drawImage(water1Before,0,0,w,h,null);
			redLinkWGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkWGrph.drawImage(redLinkBefore,0,0,w,h,null);	
			redLinkWGrph.dispose();
			
			redLinkMGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkMGrph.drawImage(mountain_0_Before,0,0,w,h,null);
			redLinkMGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkMGrph.drawImage(redLinkBefore,0,0,w,h,null);	
			redLinkMGrph.dispose();
			
			redLinkBGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkBGrph.drawImage(barancoBefore,0,0,w,h,null);
			redLinkBGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkBGrph.drawImage(redLinkBefore,0,0,w,h,null);	
			redLinkBGrph.dispose();
			
			redLinkDGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkDGrph.drawImage(desGrassBefore,0,0,w,h,null);
			redLinkDGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkDGrph.drawImage(redLinkBefore,0,0,w,h,null);	
			redLinkDGrph.dispose();
			
			redLinkStartGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkStartGrph.drawImage(startBefore,0,0,w,h,null);
			redLinkStartGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkStartGrph.drawImage(redLinkBefore, 0, 0, w, h, null);
			redLinkStartGrph.dispose();
			
			redLinkPotGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkPotGrph.drawImage(potBefore,0,0,w,h,null);
			redLinkPotGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			redLinkPotGrph.drawImage(redLinkBefore,0,0,w,h,null);
			redLinkPotGrph.dispose();
			
			//Blue Link
			
			blueLinkGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkGrph.drawImage(grassBefore,0,0,w,h,null);
			blueLinkGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkGrph.drawImage(blueLinkBefore,0,0,w,h,null);	
			blueLinkGrph.dispose();
			
			blueLinkWGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkWGrph.drawImage(water1Before,0,0,w,h,null);
			blueLinkWGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkWGrph.drawImage(blueLinkBefore,0,0,w,h,null);	
			blueLinkWGrph.dispose();
			
			blueLinkMGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkMGrph.drawImage(mountain_0_Before,0,0,w,h,null);
			blueLinkMGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkMGrph.drawImage(blueLinkBefore,0,0,w,h,null);	
			blueLinkMGrph.dispose();
			
			blueLinkBGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkBGrph.drawImage(barancoBefore,0,0,w,h,null);
			blueLinkBGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkBGrph.drawImage(blueLinkBefore,0,0,w,h,null);	
			blueLinkBGrph.dispose();
			
			blueLinkDGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkDGrph.drawImage(desGrassBefore,0,0,w,h,null);
			blueLinkDGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkDGrph.drawImage(blueLinkBefore,0,0,w,h,null);	
			blueLinkDGrph.dispose();
			
			blueLinkStartGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkStartGrph.drawImage(startBefore,0,0,w,h,null);
			blueLinkStartGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkStartGrph.drawImage(blueLinkBefore, 0, 0, w, h, null);
			blueLinkStartGrph.dispose();
			
			blueLinkPotGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkPotGrph.drawImage(potBefore,0,0,w,h,null);
			blueLinkPotGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			blueLinkPotGrph.drawImage(blueLinkBefore,0,0,w,h,null);
			blueLinkPotGrph.dispose();
			
			potGrph.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			potGrph.drawImage(potBefore,0,0,w,h,null);
			potGrph.dispose();
			
			
			startIcon.setImage(startAfter);
			
			
			waterIcon.setImage(water1After);
			brickIcon.setImage(brickAfter);
			grassIcon.setImage(grassAfter);
			desGrassIcon.setImage(desGrassAfter);
			linkIcon.setImage(linkAfter);
			linkwIcon.setImage(linkWater);
			linkdesIcon.setImage(linkdesertGrass);
			linkMountainIcon.setImage(linkMountain);
			linkBarancoIcon.setImage(linkBaranco);
			linkStartIcon.setImage(linkStart);
			linkPotIcon.setImage(linkPot);
			
			blueLinkIcon.setImage(blueLinkAfter);
			blueLinkWIcon.setImage(blueLinkWater);
			blueLinkBIcon.setImage(blueLinkBaranco);
			blueLinkMIcon.setImage(blueLinkMountain);
			blueLinkDIcon.setImage(blueLinkDesert);
			blueLinkStartIcon.setImage(blueLinkStart);
			blueLinkPotIcon.setImage(blueLinkPot);
			
			redLinkIcon.setImage(redLinkAfter);
			redLinkWIcon.setImage(redLinkWater);
			redLinkBIcon.setImage(redLinkBaranco);
			redLinkMIcon.setImage(redLinkMountain);
			redLinkDIcon.setImage(redLinkDesert);
			redLinkStartIcon.setImage(redLinkStart);
			redLinkPotIcon.setImage(redLinkPot);
			
			potIcon.setImage(potAfter);
			barancoIcon.setImage(barancoAfter);
			mountain_0_Icon.setImage(mountain_0_After);
			mountain_1_Icon.setImage(mountain_1_After);
			
		
			int counter = 0;
			float brickValue = (float)25/20*obstacleValues[2];
			float waterValue = (float)30/30*obstacleValues[1];
			float mountainValue = (float)30/30*obstacleValues[3];
			float barancoValue = (float)30/30*obstacleValues[4];
			System.out.println("BrickValue: " + brickValue);
			System.out.println("waterValue: " + waterValue);
			System.out.println("mountainValue: " + mountainValue);
			System.out.println("barancoValue: " + barancoValue);
			for(int i = 0 ; i < obstacleValues[0]*obstacleValues[0];i++)
			{
				
				Random randomGenerator = new Random();
				
				int var1;			
				var1 = randomGenerator.nextInt(130-01+1)+01;
				int terrain = 0;
			
				labels[i] = new JLabel();
				if(var1 >= 131-(brickValue))
				{
					terrain = 10;
					labels[i].setIcon(brickIcon);
				}
				else if(var1 >100-waterValue && var1 < 100)
				{
					terrain = 5;
					labels[i].setIcon(waterIcon);
				}
				else if(var1 > 75-mountainValue && var1 < 75)
				{
					terrain = 4;
					labels[i].setIcon(mountain_0_Icon);
				}
				else if(var1 > 50-barancoValue && var1 < 50)
				{
					System.out.println(barancoValue);
					terrain = 3;
					labels[i].setIcon(barancoIcon);
				}
				else{
					
					Random random = new Random();
					int var2 = random.nextInt(10-01+1)+1;
					if(var2 > 6)
						{
						labels[i].setIcon(desGrassIcon);
						terrain = 2;
						}
					else {
						labels[i].setIcon(grassIcon);
						terrain = 1;
						}
				}
				
				if(counter < obstacleValues[0])
				{
					
					info.addElement((long) terrain);
					info.addElement((long) (initialPonderation));
					info.addElement((long) (initialPonderation));
					info.addElement((long) (initialPonderation));
					info.addElement((long)0);
					row.add(info);
					info = new Vector<Long>();
					counter++;
				}
				else
				{
					counter = 1;
					column.addElement(row);
					row = new Vector<Vector<Long>>();
					info.addElement((long)terrain);
					info.addElement((long) (initialPonderation));
					info.addElement((long) (initialPonderation));
					info.addElement((long) (initialPonderation));
					info.addElement((long)0);
					row.addElement(info);
					info = new Vector<Long>();
				}
				
				labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				add(labels[i]);
				labels[i].addMouseListener(this);
				terrainValues[i] = terrain;
			}
			column.addElement(row);
			printGridValues();
			System.out.println(column.get(0).get(0).get(0));
			System.out.println(column.get(1).get(0).get(0));
			System.out.println(column.get(0).get(1).get(0));
			System.out.println(column.get(1).get(1).get(0));
			validate();
			System.out.println("Row * Column: " + row.size() + " " +column.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	public void printGridValues()
	{
		for(int i = 0; i < column.size();i++)
		{
			for(int j = 0; j < column.get(i).size();j++)
				{for(int k = 0; k < column.get(i).get(j).size(); k++)
					{System.out.print(column.get(i).get(j).get(k) + " ");}
				}
			System.out.println();				
		}
	}
	public void clearAll()
	{
		for(int i = 0; i < labels.length;i++)
		{
			labels[i].setIcon(null);
			labels[i].setBorder(null);
		}
		//removeAll();
	}
	public void setLinkImage()
	{
		placeLink = true;
	}
	public void setPotImage()
	{
		placePot = true;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(placeLink == true)
		{
				for(int i = 0; i < labels.length;i++)
			if(arg0.getSource() == labels[i])
			{
				if(labels[i].getIcon() != brickIcon)
				{
					labels[i].setIcon(blueLinkStartIcon);
					placeLink = false;
					linkLocation = i;
					break;
				}
				
			}			
		}
		if(placePot == true) 
		{
			for(int i = 0; i < labels.length;i++)
			if(arg0.getSource() == labels[i])
			{
				if(labels[i].getIcon() != blueLinkWIcon &&
				labels[i].getIcon() != blueLinkIcon  &&
				labels[i].getIcon() != blueLinkDIcon && 
				labels[i].getIcon() != blueLinkMIcon &&
				labels[i].getIcon() != blueLinkBIcon)
				{
					labels[i].setIcon(potIcon);
					placePot = false;
					potLocation = i;		
				}
			}
		}
		if(DijkstraClick == false)
		{
			for(int i = 0; i < labels.length;i++)
				if(arg0.getSource() == labels[i])
				{
					if(labels[i].getIcon() != brickIcon)
					{
						DijkstraClick = true;
						staticlinkR = linkLocation / obstacleValues[0];
						staticlinkC = linkLocation - obstacleValues[0]* staticlinkR;
						Long terrain = column.get(staticlinkR).get(staticlinkC).get(ids.terrainType.getValue());
						switch(terrain.intValue())
						{
						case 1:
							labels[linkLocation].setIcon(grassIcon);
							break;
						case 2:
							labels[linkLocation].setIcon(desGrassIcon);
							break;
						case 3:
							labels[linkLocation].setIcon(barancoIcon);
							break;
						case 4:
							labels[linkLocation].setIcon(mountain_0_Icon);
							break;
						case 5:
							labels[linkLocation].setIcon(waterIcon);
							break;
						}
						linkLocation = i;
						staticlinkR = linkLocation /obstacleValues[0];
						staticlinkC = linkLocation-(obstacleValues[0] * staticlinkR);
						break;
					}
				}	
		}
	}
	//@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	//@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void entrenamiento(final int monoSelect,boolean doBootStrap)
	{
		
		linkRow = linkLocation /obstacleValues[0];
		linkColumn = linkLocation-(obstacleValues[0] * linkRow);
		
		staticlinkR = linkRow;
		staticlinkC = linkColumn;
		int potRow = potLocation /obstacleValues[0];
		int potColumn = potLocation -(obstacleValues[0] * potRow);
		
		
	
			
		
		boolean found = false;
		visitedList = new Vector<Vector<Integer>>();
		lastPosition = new Vector<Vector<Integer>>();
		coordinates = new Vector<Integer>();
		
		
		coordinates.add(linkRow);
		coordinates.add(linkColumn);
		visitedList.add(coordinates);
		lastPosition.add(coordinates);
		Random random = new Random();
		int direction;
		int cycle = 0;
		setRandomSelection();
		setRandomSide();
		setRandomCorner();
		while(!found)
		{	
			if(UI.getCheck())
			{
				looptime = 2;
			}
			else 
			{
				looptime = 0;
			}
			try {
				TimeUnit.MILLISECONDS.sleep(looptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			if(lastPosition.isEmpty())
			{
				found = true;
				System.out.print("VisitedList");
				for(int i = 0; i < visitedList.size();i++)
				{
					System.out.println(visitedList.get(i));
				}
				System.out.println(linkRow);
				System.out.println(linkColumn);
				System.out.println("Press Any Key To Continue...");
		        new java.util.Scanner(System.in).nextLine();
				break;
			}
			 
			if(linkRow > 0 && linkColumn > 0 &&
					linkRow < obstacleValues[0]-1 && linkColumn < obstacleValues[0]-1)
			{
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				//System.out.println("RandomSelection Size:" + randomSelection.size());
				while(foundDirection == false)
				{
					//System.out.println(randomSelection.size());
					if(randomSelection.size() != 0)
					 direction = randomSelection.get(random.nextInt(randomSelection.size()));
					else direction = -1;
					switch(direction)
					{
					case 0:
						//NorthWest
						if(Direction(-1,-1,monoSelect))
						{setRandomSelection(); foundDirection = true;}
						else removeRandomSelection(0);
						break;
					case 1:
						//North
						if(Direction(-1,0,monoSelect))
							{setRandomSelection(); foundDirection = true;}
						else removeRandomSelection(1);
						break;
					case 2:
						//NorthEast
						if(Direction(-1,1,monoSelect)){
							{setRandomSelection(); foundDirection = true;}
						}
						else
							removeRandomSelection(2);
						break;
					case 3:
						//East
						if(Direction(0,1,monoSelect))
							{setRandomSelection(); foundDirection = true;}
						else
							removeRandomSelection(3);
						break;
					case 4:
						//SouthEast
						if(Direction(1,1,monoSelect)){
							{setRandomSelection(); foundDirection = true;}
						}
						else
							removeRandomSelection(4);
						break;
					case 5:
						//South
						if(Direction(1,0,monoSelect)){
							{setRandomSelection(); foundDirection = true;}
						}
						else
							removeRandomSelection(5);
						break;
					case 6:
						//SouthWest
						if(Direction(1,-1,monoSelect)){
							{setRandomSelection(); foundDirection = true;}
						}
						else
							removeRandomSelection(6);
						break;
					case 7:
						//West
						if(Direction(0,-1,monoSelect)){
							{setRandomSelection(); foundDirection = true;}
						}
						else
							removeRandomSelection(7);
						break;
						default:
							if(!lastPosition.isEmpty())
							{
							column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long) 1);
							linkRow = lastPosition.lastElement().get(0);
							linkColumn = lastPosition.lastElement().get(1);
					
							clearLink(linkColumn,linkRow,monoSelect);
							
							lastPosition.remove(lastPosition.size()-1);
							}
							setRandomSelection();
							foundDirection = true;
							break;
					}
				}
			}
			else if(linkRow == 0 && linkColumn == 0)
			{	
				//Top left corner
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{
					if(randomCorner.size() != 0)
					 direction= randomCorner.get(random.nextInt(randomCorner.size()));
					else direction = -1;
					
					switch(direction)
					{
						case 0:
							if(Direction(0,1,monoSelect)){
								
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(0);
							break;
						case 1:
							if(Direction(1,1,monoSelect)){	
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(1);
							break;
						case 2:
							if(Direction(1,0,monoSelect)){	
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(2);
							break;
							default:
								if(!lastPosition.isEmpty())
								{
								column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
								linkRow = lastPosition.lastElement().get(0);
								linkColumn = lastPosition.lastElement().get(1);
								clearLink(linkColumn,linkRow,monoSelect);
								
								lastPosition.remove(lastPosition.size()-1);
								}
								setRandomCorner();
								foundDirection = true;
								break;
					}
				}
			}
			else if(linkRow == 0 && linkColumn == obstacleValues[0]-1)
			{
				//Top right corner
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{
					if(randomCorner.size() != 0)
					{
					    direction= randomCorner.get(random.nextInt(randomCorner.size()));
					}
					else direction = -1;
				
					switch(direction)
					{
						case 0:
							if(Direction(0,-1,monoSelect)){			
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(0);
							break;
						case 1:
							if(Direction(1,-1,monoSelect)){	
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(1);
							break;
						case 2:
							if(Direction(1,0,monoSelect)){
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(2);
							break;
							default:
								if(!lastPosition.isEmpty())
								{
								
								column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
								linkRow = lastPosition.lastElement().get(0);
								linkColumn = lastPosition.lastElement().get(1);
						
								clearLink(linkColumn,linkRow,monoSelect);
								
								lastPosition.remove(lastPosition.size()-1);
								}
								setRandomCorner();
								foundDirection = true;
								break;
					}
				}
			}
			else if(linkRow == obstacleValues[0]-1 && linkColumn == obstacleValues[0]-1)
			{
				//Bottom right corner
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{
					if(randomCorner.size() != 0)
						direction= randomCorner.get(random.nextInt(randomCorner.size()));
						else direction = -1;
					
					switch(direction)
					{
						case 0:
							if(Direction(0,-1,monoSelect)){
								
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(0);
							break;
						case 1:
							if(Direction(-1,-1,monoSelect)){	
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(1);
							break;
						case 2:
							if(Direction(-1,0,monoSelect)){		
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(2);
							break;
						default:
							if(!lastPosition.isEmpty())
							{
							column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
							linkRow = lastPosition.lastElement().get(0);
							linkColumn = lastPosition.lastElement().get(1);			
							clearLink(linkColumn,linkRow,monoSelect);
							
							lastPosition.remove(lastPosition.size()-1);
							}
							setRandomCorner();
							foundDirection = true;
							break;
					}
				}
			}
			else if(linkRow == obstacleValues[0]-1 && linkColumn == 0)
			{
				//Bottom left corner
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{
					if(randomCorner.size() != 0)
						direction= randomCorner.get(random.nextInt(randomCorner.size()));
						else direction = -1;
					
					switch(direction)
					{
						case 0:
							if(Direction(0,1,monoSelect)){
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(0);
							break;
						case 1:
							if(Direction(-1,1,monoSelect)){	
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(1);
							break;
						case 2:
							if(Direction(-1,0,monoSelect)){	
								setRandomCorner();
								foundDirection = true;
							}
							else
								removeRandomCorner(2);
							break;
						default:
							if(!lastPosition.isEmpty())
							{
							column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
							linkRow = lastPosition.lastElement().get(0);
							linkColumn = lastPosition.lastElement().get(1);		
							clearLink(linkColumn,linkRow,monoSelect);
							
							lastPosition.remove(lastPosition.size()-1);
							}
							setRandomCorner();
							foundDirection = true;
							break;
					}
				}
			}	
			else if(linkRow == 0 && linkColumn > 0 && linkColumn < obstacleValues[0]-1)
			{
				//Top Side
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{
					if(randomSide.size() != 0)
					{
					    direction= randomSide.get(random.nextInt(randomSide.size()));
					}
					else direction = -1;
					
					switch(direction)
					{
						case 0:
							if(Direction(0,1,monoSelect))
								{setRandomSide();foundDirection = true;}
							else
								removeRandomSide(0);
							break;
						case 1:
							if(Direction(1,1,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(1);
							break;
						case 2:
							if(Direction(1,0,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(2);
							break;
						case 3:
							if(Direction(1,-1,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(3);
							break;
						case 4:
							if(Direction(0,-1,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(4);
							break;
							default:
								if(!lastPosition.isEmpty())
								{
								column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
								linkRow = lastPosition.lastElement().get(0);
								linkColumn = lastPosition.lastElement().get(1);
						
								clearLink(linkColumn,linkRow,monoSelect);
								
								lastPosition.remove(lastPosition.size()-1);
							
								}
								setRandomSide();
								foundDirection = true;
								break;
					}
				}
			}
			else if(linkRow == obstacleValues[0]-1 && linkColumn > 0 && linkColumn < obstacleValues[0]-1)
			{
				//Bottom Side
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{	
					
					if(randomSide.size() != 0)
						direction= randomSide.get(random.nextInt(randomSide.size()));
						else direction = -1;
					
					switch(direction)
					{
						case 0:
							//NorthWest
							if(Direction(-1,-1,monoSelect))
							{
								setRandomSide();
								foundDirection = true;
							}
							else removeRandomSide(0);
							break;
						case 1:
							//North
							if(Direction(-1,0,monoSelect))
							{
								setRandomSide();
								foundDirection = true;
							}
							else removeRandomSide(1);
							break;
						case 2:
							//NorthEast
							if(Direction(-1,1,monoSelect)){
								setRandomSide();
								foundDirection = true;
							}
							else
								removeRandomSide(2);
							break;
						case 3:
							//East
							if(Direction(0,1,monoSelect))
							{
								setRandomSide();
								foundDirection = true;
							}
							else
								removeRandomSide(3);
							break;
						case 4:
							//West
							if(Direction(0,-1,monoSelect))
							{
								setRandomSide();
								foundDirection = true;
							}
							else
								removeRandomSide(4);
							break;
							default:
								if(!lastPosition.isEmpty())
								{
								column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
								linkRow = lastPosition.lastElement().get(0);
								linkColumn = lastPosition.lastElement().get(1);
						
								clearLink(linkColumn,linkRow,monoSelect);
								
								lastPosition.remove(lastPosition.size()-1);
						
								}
								setRandomSide();
								foundDirection = true;
								break;
					}
				}
			}
			else if(linkRow > 0 && linkRow < obstacleValues[0]-1 && linkColumn == 0)
			{
				//Left Side
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{	
			
					if(randomSide.size() != 0)
						direction= randomSide.get(random.nextInt(randomSide.size()));
						else direction = -1;
					
					switch(direction)
					{
						case 0:
							//North
							if(Direction(-1,0,monoSelect))
								{setRandomSide();foundDirection = true;}
							else removeRandomSide(0);
							break;
						case 1:
							//NorthEast
							if(Direction(-1,1,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(1);
							break;
						case 2:
							//East
							if(Direction(0,1,monoSelect))
								{setRandomSide();foundDirection = true;}
							else
								removeRandomSide(2);
							break;
						case 3:
							//SouthEast
							if(Direction(1,1,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(3);
							break;
						case 4:
							//System.out.println("S");
							
							if(Direction(1,0,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(4);
							break;
						default:
								if(!lastPosition.isEmpty())
								{
								column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
								linkRow = lastPosition.lastElement().get(0);
								linkColumn = lastPosition.lastElement().get(1);
						
								clearLink(linkColumn,linkRow,monoSelect);
								
								lastPosition.remove(lastPosition.size()-1);
							
								}
								setRandomSide();
								foundDirection = true;
								break;
					}
				}
			}
			else if(linkRow > 0 && linkRow < obstacleValues[0]-1 && linkColumn == obstacleValues[0]-1)
			{
				//Right Side
				random = new Random();
				direction = -1;
				coordinates = new Vector<Integer>();
				boolean foundDirection = false;
				while(foundDirection == false)
				{
				
					if(randomSide.size() != 0)
						direction= randomSide.get(random.nextInt(randomSide.size()));
						else direction = -1;
					
					switch(direction)
					{
						case 0:
							//North
							if(Direction(-1,0,monoSelect))
								{setRandomSide();foundDirection = true;}
							else removeRandomSide(0);
							break;
						case 1:
							//NorthWest
							if(Direction(-1,-1,monoSelect))
								{setRandomSide();foundDirection = true;}
							else removeRandomSide(1);
							break;
						
						case 2:
							//West
							if(Direction(0,-1,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(2);
							break;
						case 3:
							//SouthWest
							if(Direction(1,-1,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(3);
							break;
						case 4:
							if(Direction(1,0,monoSelect)){
								{setRandomSide();foundDirection = true;}
							}
							else
								removeRandomSide(4);
							break;
							default:
								if(!lastPosition.isEmpty())
								{
								column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long)1);
								linkRow = lastPosition.lastElement().get(0);
								linkColumn = lastPosition.lastElement().get(1);
							
								clearLink(linkColumn,linkRow,monoSelect);
								
								lastPosition.remove(lastPosition.size()-1);
							
								}
								setRandomSide();
								foundDirection = true;
								break;
					}
				}
			}
			else
			{
				System.out.println("Stuck");
				break;
			}
			if(linkRow == potRow && linkColumn == potColumn)
			{
				found = true;
				resetVisited();
				labels[potColumn+potRow*obstacleValues[0]].setIcon(potIcon);
			}
			cycle++;
			
		}
		switch(monoSelect)
		{
		case 1:
			if(!doBootStrap)
			{
			    ponderacion(Mombo,1);
			}
			else
				bootStrap(Mombo,1);
			break;
		case 2:
			if(!doBootStrap)
			{
			    ponderacion(Pirolo,2);
			}
			else
				bootStrap(Pirolo,2);
			break;
		case 3:
			if(!doBootStrap)
			{
			    ponderacion(Lucas,3);
			}
			else
				bootStrap(Lucas,3);
			break;
			default:
				System.out.println("Player Selected does not exist");
				break;
		}
	}

	public void resetVisited()
	{
		for(int i = 0; i < visitedList.size();i++)
		{
			int y = visitedList.get(i).get(0);
			int x = visitedList.get(i).get(1);
			
			column.get(y).get(x).set(4, (long) 0);
		}
	}
	public void ponderacion(Vector<Double> mono,int ponderacion)
	{
		int divisor = visitedList.size();
		
		for(int i = 0; i < visitedList.size();i++)
		{
			int y = visitedList.get(i).get(0);
			int x = visitedList.get(i).get(1);
			
			Long originalPonderacion = column.get(y).get(x).get(ponderacion);
			Long terrain = column.get(y).get(x).get(ids.terrainType.getValue());
			mono.setElementAt(mono.elementAt(0)+(/*originalPonderacion**/mono.elementAt(terrain_to_index(terrain))), 0);
			//System.out.println("Time it took: " + originalPonderacion*mono.elementAt(terrain_to_index(terrain)));	
		}
		double esfuerzo  = mono.get(0);	
		double promedio = (highestValue + lowestValue) / 2;	
		if(esfuerzo < promedio  && esfuerzo > lowestValue)
		{
			Long ajuste = (long)  (esfuerzo - promedio)/*/1000000*/;
			for(int i = 0; i < visitedList.size();i++)
			{
				int y = visitedList.get(i).get(0);
				int x = visitedList.get(i).get(1);
				
				Long originalPonderacion = column.get(y).get(x).get(ponderacion);
				//System.out.println("Before: " + column.get(y).get(x).get(ponderacion));
				column.get(y).get(x).set(ponderacion, (long) (originalPonderacion + (long)ajuste));
				//System.out.println("After: " +column.get(y).get(x).get(ponderacion));
			}			
			System.out.println("Premio: " + ajuste);
			
		}
		else if(esfuerzo < promedio && esfuerzo < lowestValue)
		{
			Long ajuste = (long)  ((esfuerzo - promedio)/*/1000000*/);
			
			for(int i = 0; i < visitedList.size();i++)
			{
				int y = visitedList.get(i).get(0);
				int x = visitedList.get(i).get(1);
				
				Long originalPonderacion = column.get(y).get(x).get(ponderacion);
				
				//System.out.println("Before: " + column.get(y).get(x).get(ponderacion));
				column.get(y).get(x).set(ponderacion, (long) (originalPonderacion + (long)ajuste));
				//System.out.println("After: " +column.get(y).get(x).get(ponderacion));
			}
			lowestValue = (esfuerzo+highestValue)/2;
			
			System.out.println("Premio: " + ajuste);
			
		}
		else if(esfuerzo > promedio && esfuerzo < highestValue)
		{			
			Long ajuste = (long)(esfuerzo - promedio)/*/1000000*/;
			for(int i = 0; i < visitedList.size();i++)
			{
				int y = visitedList.get(i).get(0);
				int x = visitedList.get(i).get(1);
				
				Long originalPonderacion = column.get(y).get(x).get(ponderacion);
				
				
				//System.out.println("Before: " + column.get(y).get(x).get(ponderacion));
				column.get(y).get(x).set(ponderacion, (long) (originalPonderacion + (long)ajuste));
				//System.out.println("After: " +column.get(y).get(x).get(ponderacion));
			}
			System.out.println("Castigo: " + ajuste);
		}
		else if(esfuerzo > promedio && esfuerzo > highestValue)
		{
			
			Long ajuste = (long)  ((esfuerzo-promedio)/*/1000000*/);
			for(int i = 0; i < visitedList.size();i++)
			{
				int y = visitedList.get(i).get(0);
				int x = visitedList.get(i).get(1);
				
				Long originalPonderacion = column.get(y).get(x).get(ponderacion);
				
				//System.out.println("Before: " + column.get(y).get(x).get(ponderacion));
				column.get(y).get(x).set(ponderacion, (long) (originalPonderacion + (long)ajuste));
				//System.out.println("After: " +column.get(y).get(x).get(ponderacion));
			}
			
			highestValue = (esfuerzo+lowestValue)/2;
			
			System.out.println("Castigo: " + ajuste);
		}

		mono.set(0,(double)0);
	}
	void bootStrap(Vector<Double> mono,int ponderacion)
	{	
		for(int i = 0; i < visitedList.size();i++)
		{
			int y = visitedList.get(i).get(0);
			int x = visitedList.get(i).get(1);
			
			Long originalPonderacion = column.get(y).get(x).get(ponderacion);
			Long terrain = column.get(y).get(x).get(ids.terrainType.getValue());
			mono.setElementAt(mono.elementAt(0)+(/*originalPonderacion**/mono.elementAt(terrain_to_index(terrain))), 0);
		}
		lowestValue = highestValue = media  = mono.get(0);
		mono.set(0,(double)0);	
	}

	public int terrain_to_index(Long terrain)
	{
		switch(terrain.intValue())
		{
		case 1:
			//System.out.println("Terrain: " + terrain);
			return terrains.plain.getValue();	
		case 2:
			//System.out.println("Terrain: " + terrain);
			return terrains.plain.getValue();	
		case 3:
			//System.out.println("Terrain: " + terrain);
			return terrains.valley.getValue();
		case 4:
			//System.out.println("Terrain: " + terrain);
			return terrains.moutain.getValue();
		case 5:
			//System.out.println("Terrain: " + terrain);
			return terrains.water.getValue();
		case 10:
			//System.out.println("\n\n!!!!!Error Wall visited !!!!\n\n");
			return 1;
			default:
				//System.out.println("Error not the a valid terrain:  " + terrain);
				return 1;
			
			
		}
	}
	public boolean Direction(int rowDirection, int columnDirection,int mono)
	{
		if(column.get(linkRow+rowDirection).get(linkColumn+columnDirection).get(0) != ids.rock.getValue() 
				&& column.get(linkRow+rowDirection).get(linkColumn+columnDirection).get(4) != 1)
				{
					coordinates.add(linkRow+rowDirection);
					coordinates.add(linkColumn+columnDirection);
					visitedList.add(coordinates);
					lastPosition.add(coordinates);
					//System.out.println("Regular Column: " + linkColumn + " Row: " + linkRow);
					iconRedraw(linkColumn,linkRow,linkColumn+columnDirection,linkRow+rowDirection,mono);
					column.get(linkRow).get(linkColumn).set(ids.visited.getValue(),(long) 1);
					linkColumn += columnDirection;
					linkRow += rowDirection;
					return true;
				}
		return false;
	}
	public void removeRandomSelection(int directionNotValid)
	{
		
		for(int i = 0; i < randomSelection.size(); i++)
		{
			if(randomSelection.get(i) == directionNotValid)
			{
				randomSelection.remove(i);
				break;
			}
		}
		
	}
	public void removeRandomCorner(int directionNotValid)
	{
		for(int i = 0; i < randomCorner.size(); i++)
		{
			if(randomCorner.get(i) == directionNotValid)
			{
				randomCorner.remove(i);
				break;
			}
		}
	}
	public void removeRandomSide(int directionNotValid)
	{
		for(int i = 0; i < randomSide.size(); i++)
		{
			if(randomSide.get(i) == directionNotValid)
			{
				randomSide.remove(i);
				break;
			}
		}
	}
	public void setRandomSelection()
	{
		randomSelection = new Vector<Integer>();
		randomSelection.add(0);
		randomSelection.add(1);
		randomSelection.add(2);
		randomSelection.add(3);
		randomSelection.add(4);
		randomSelection.add(5);
		randomSelection.add(6);
		randomSelection.add(7);
		
	}
	public void setRandomCorner()
	{
		randomCorner = new Vector<Integer>();
		randomCorner.add(0);
		randomCorner.add(1);
		randomCorner.add(2);
	}
	public void setRandomSide()
	{
		randomSide = new Vector<Integer>();
		randomSide.add(0);
		randomSide.add(1);
		randomSide.add(2);
		randomSide.add(3);
		randomSide.add(4);
	}
	
	public void iconRedraw(int OldX, int OldY, int newX, int newY, int mono)
	{
		
		//Deletes Link from his current location
		switch(mono)
		{
			case 1:
						if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(grassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkWIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(waterIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkDIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(desGrassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkMIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(mountain_0_Icon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkBIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(barancoIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkStartIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(startIcon);
						}
							
						/// Draw Link in the new position
						if(newY == potLocation / obstacleValues[0] &&
								newX == potLocation - (obstacleValues[0]) * (potLocation / obstacleValues[0]))
						{
							labels[((newX + newY * obstacleValues[0]))].setIcon(blueLinkPotIcon);
							sleepFunction();
							return;
						}
						
						//Draw Link on pot and return;
						if(terrainValues[newX + newY * obstacleValues[0]] == 1)
						{
							labels[((newX + newY * obstacleValues[0]))].setIcon(blueLinkIcon);
							
						}
						else if(terrainValues[newX + newY * obstacleValues[0]] == 2)
						{
							labels[((newX + newY * obstacleValues[0]))].setIcon(blueLinkDIcon);
							
						}
						else if(terrainValues[newX + newY * obstacleValues[0]] == 3)
						{
							labels[((newX + newY * obstacleValues[0]))].setIcon(blueLinkBIcon);
						}
						else if(terrainValues[newX + newY * obstacleValues[0]] == 4)
						{
							labels[((newX + newY * obstacleValues[0]))].setIcon(blueLinkMIcon);
						}
						else if(terrainValues[newX + newY * obstacleValues[0]] == 5)
						{
							labels[((newX + newY * obstacleValues[0]))].setIcon(blueLinkWIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == startIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(blueLinkStartIcon);
						}
						
						sleepFunction();
			break;
			case 2:
				if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(grassIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkWIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(waterIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkDIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(desGrassIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkMIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(mountain_0_Icon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkBIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(barancoIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkStartIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(startIcon);
				}
			
		
				/// Draw Link in the new position
				if(newY == potLocation / obstacleValues[0] &&
						newX == potLocation - (obstacleValues[0]) * (potLocation / obstacleValues[0]))
				{

					labels[((newX + newY * obstacleValues[0]))].setIcon(redLinkPotIcon);
					sleepFunction();
					return;
				}
				if(terrainValues[newX + newY * obstacleValues[0]] == 1)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(redLinkIcon);
					
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 2)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(redLinkDIcon);
					
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 3)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(redLinkBIcon);
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 4)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(redLinkMIcon);
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 5)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(redLinkWIcon);	
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == startIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(redLinkStartIcon);
				}
				sleepFunction();
			break;
			case 3:
				if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(grassIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkwIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(waterIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkdesIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(desGrassIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkMountainIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(mountain_0_Icon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkBarancoIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(barancoIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkStartIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(startIcon);
				}
				
				/// Draw Link in the new position
				if(newY == potLocation / obstacleValues[0] &&
						newX == potLocation - (obstacleValues[0]) * (potLocation / obstacleValues[0]))
				{

					labels[((newX + newY * obstacleValues[0]))].setIcon(linkPotIcon);
					sleepFunction();
					return;
				}
				if(terrainValues[newX + newY * obstacleValues[0]] == 1)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(linkIcon);
					
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 2)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(linkdesIcon);
					
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 3)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(linkBarancoIcon);
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 4)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(linkMountainIcon);
				}
				else if(terrainValues[newX + newY * obstacleValues[0]] == 5)
				{
					labels[((newX + newY * obstacleValues[0]))].setIcon(linkwIcon);
				}
				else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == startIcon)
				{
					labels[((OldX + OldY * obstacleValues[0]))].setIcon(linkStartIcon);
				}
				
				sleepFunction();
			break;
		}

		
	}
	
	public void linkFound()
	{
		labels[potLocation].setIcon(potIcon);
	}
	public void sleepFunction()
	{
		try {
			TimeUnit.MILLISECONDS.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clearLink(int OldX, int OldY,int mono)
	{

		switch(mono)
		{
			case 1:
						if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(grassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkWIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(waterIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkDIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(desGrassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkMIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(mountain_0_Icon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == blueLinkBIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(barancoIcon);
						}
			break;
			case 2:
						if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(grassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkWIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(waterIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkDIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(desGrassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkMIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(mountain_0_Icon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == redLinkBIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(barancoIcon);
						}
			break;
			case 3:
						if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(grassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkwIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(waterIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkdesIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(desGrassIcon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkMountainIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(mountain_0_Icon);
						}
						else if(labels[((OldX + OldY * obstacleValues[0]))].getIcon() == linkBarancoIcon)
						{
							labels[((OldX + OldY * obstacleValues[0]))].setIcon(barancoIcon);
						}
			break;
		}
		
	}
	void addSurroundingPositions(int x, int y)
	{
		if( x > 0 && y > 0 && 
				x < obstacleValues[0]-1 &&  
				y < obstacleValues[0]-1 )
		{
			//NorthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y-1));
			//North
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y-1));
			//NorthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y-1));
			//East
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y));
			//SouthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y+1));
			//South
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y+1));
			//SouthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y+1));
			//West
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y));
		}
		else if(x == 0 && y == 0)
		{
			//East
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y));
			//SouthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y+1));
			//South
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y+1));
		}
		else if(x == obstacleValues[0]-1 && y == 0)
		{
			//South
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y+1));
			//SouthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y+1));
			//West
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y));
			
		}
		else if (x == obstacleValues[0]-1 && y == obstacleValues[0]-1)
		{
			//North
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y-1));
			//NorthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y-1));
			//West
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y));
		}
		else if(x == 0 && y == obstacleValues[0]-1)
		{
			//North
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y-1));
			//NorthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y-1));
			//East
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y));
		}
		else if(x > 0 && x < obstacleValues[0]-1 && y == 0)
		{
			//West
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y));
			//SouthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y+1));
			//South
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y+1));
			//SouthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y+1));
			//East
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y));
		}
		else if(x > 0 && x < obstacleValues[0]-1 && y == obstacleValues[0]-1)
		{
			//West
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y));
			//NorthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y-1));
			//North
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y-1));
			//NorthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y-1));
			//East
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y));
		}
		else if(x == 0 && y > 0 && y < obstacleValues[0]-1)
		{
			//North
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y-1));
			//NorthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y-1));
			//East
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y));
			//SouthEast
			infoDijkstra.addElement((long) (x+1));
			infoDijkstra.addElement((long) (y+1));
			//South
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y+1));
		}
		else if(x == obstacleValues[0]-1 && y > 0 && y < obstacleValues[0]-1)
		{
			//North
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y-1));
			//NorthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y-1));
			//West
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y));
			//SouthWest
			infoDijkstra.addElement((long) (x-1));
			infoDijkstra.addElement((long) (y+1));
			//South
			infoDijkstra.addElement((long) (x));
			infoDijkstra.addElement((long) (y+1));
		}
	}
	void ruta()
	{
		
		distanceMatrixMombo = new int [obstacleValues[0]][obstacleValues[0]];
		distanceMatrixPirolo = new int [obstacleValues[0]][obstacleValues[0]];
		distanceMatrixLucas = new int [obstacleValues[0]][obstacleValues[0]];
		
		MomboList = new boolean [obstacleValues[0]][obstacleValues[0]];
		PiroloList = new boolean [obstacleValues[0]][obstacleValues[0]];
		LucasList = new boolean [obstacleValues[0]][obstacleValues[0]];
		
		previousMatrixMombo = new String [obstacleValues[0]][obstacleValues[0]];
		previousMatrixPirolo = new String [obstacleValues[0]][obstacleValues[0]];
		previousMatrixLucas = new String [obstacleValues[0]][obstacleValues[0]];
		for(int y = 0; y < obstacleValues[0];y++)
		{
			for(int x = 0; x < obstacleValues[0];x++)
			{		
				distanceMatrixMombo[y][x] = -10;
				distanceMatrixPirolo[y][x] = -10;
				distanceMatrixLucas[y][x] = -10;
				
				MomboList[y][x] = false;
				PiroloList[y][x] = false;
				LucasList[y][x] = false;
								
				previousMatrixMombo[y][x] = "-1";
				previousMatrixPirolo[y][x] = "-1";
				previousMatrixLucas[y][x] = "-1";
			}
		}
	}
	void sortQueue(Vector<Integer> tempInfo,Vector<Vector<Integer>> queue)
	{
		for(int x = 0; x< queue.size();x++)
		{
			if(queue.get(x).get(2) > tempInfo.get(2))
			{
				queue.add(x,tempInfo);
				return;
			}		
		}
		queue.add(tempInfo);
	}
	public void calculateDijstra()
	{
		System.out.println("Dijkstra");
		ruta();
		columnDijkstra = new Vector<Vector<Vector<Long>>>();
		for(int x = 0; x < column.size();x++)
		{
			rowDijkstra = new Vector<Vector<Long>>();
			for(int y = 0; y < column.get(x).size();y++)
			{
				if(column.get(x).get(y).get(0) != 10)
				{
					infoDijkstra = new Vector<Long>();
					infoDijkstra.addElement(column.get(x).get(y).get(0));
					infoDijkstra.addElement(column.get(x).get(y).get(1));
					infoDijkstra.addElement(column.get(x).get(y).get(2));
					infoDijkstra.addElement(column.get(x).get(y).get(3));
					addSurroundingPositions(x,y);
				}
				else
				{
					infoDijkstra = new Vector<Long>();
					infoDijkstra.add((long) 10);
				}
				rowDijkstra.addElement(infoDijkstra);
			}
			columnDijkstra.addElement(rowDijkstra);
		}
		
		MomboQueue = new Vector<Vector<Integer>>();
		PiroloQueue = new Vector<Vector<Integer>>();
		LucasQueue = new Vector<Vector<Integer>>();
		tempInfo = new Vector<Integer>();
		
		tempInfo.add(linkRow);
		tempInfo.add(linkColumn);
		tempInfo.add(0);
		
		MomboQueue.add(tempInfo);
		PiroloQueue.add(tempInfo);
		LucasQueue.add(tempInfo);
		while(!MomboQueue.isEmpty())
		{
			int currentX = MomboQueue.get(0).get(0);
			int currentY = MomboQueue.get(0).get(1);
			MomboQueue.remove(0);
			if(MomboList[currentX][currentY] == false)
			{
				MomboList[currentX][currentY] = true;
				//Get the number of conections it has
				// Since columnDijkstra has the terrain type and 3 diferent weights
				// I eliminate subtract those leaving me only the conections 
				// The conection are in pairs which is why i divide by 2 to either get
				// connections 8,5,3 IN the Middle , Side or the corner
				int conections = (columnDijkstra.get(currentX).get(currentY).size()-4)/2;
				for(int i = 0; i < conections;i++)
				{
					//Get Peso for the direction selected
					Long newX = columnDijkstra.get(currentX).get(currentY).get(4+2*i);
					Long newY = columnDijkstra.get(currentX).get(currentY).get(5+2*i);
					Long originalPonderacion = column.get(newX.intValue()).get(newY.intValue()).get(1);
					Long terrain = column.get(newX.intValue()).get(newY.intValue()).get(ids.terrainType.getValue());
					Long peso = (long) (originalPonderacion* Mombo.elementAt(terrain_to_index(terrain)));
					
					if(column.get(newX.intValue()).get(newY.intValue()).get(0)!= 10 &&
							MomboList[newX.intValue()][newY.intValue()] == false)
					{
						relajacionMombo(currentX,currentY,newX.intValue(),newY.intValue(),peso);
					}
				}
			}
			
		}
		while(!PiroloQueue.isEmpty())
		{
			int currentX = PiroloQueue.get(0).get(0);
			int currentY = PiroloQueue.get(0).get(1);
			PiroloQueue.remove(0);
			if(PiroloList[currentX][currentY] == false)
			{
				PiroloList[currentX][currentY] = true;
				int conections = (columnDijkstra.get(currentX).get(currentY).size()-4)/2;
				for(int i = 0; i < conections;i++)
				{
					//Get Peso for the direction selected
					Long newX = columnDijkstra.get(currentX).get(currentY).get(4+2*i);
					Long newY = columnDijkstra.get(currentX).get(currentY).get(5+2*i);
					Long originalPonderacion = column.get(newX.intValue()).get(newY.intValue()).get(1);
					Long terrain = column.get(newX.intValue()).get(newY.intValue()).get(ids.terrainType.getValue());
					Long peso = (long) (originalPonderacion* Pirolo.elementAt(terrain_to_index(terrain)));
					
					if(column.get(newX.intValue()).get(newY.intValue()).get(0)!= 10 &&
							PiroloList[newX.intValue()][newY.intValue()] == false)
					{
						relajacionPirolo(currentX,currentY,newX.intValue(),newY.intValue(),peso);
					}
				}
			}
			
		}
		while(!LucasQueue.isEmpty())
		{
			int currentX = LucasQueue.get(0).get(0);
			int currentY = LucasQueue.get(0).get(1);
			LucasQueue.remove(0);
			if(LucasList[currentX][currentY] == false)
			{
				LucasList[currentX][currentY] = true;
				int conections = (columnDijkstra.get(currentX).get(currentY).size()-4)/2;
				for(int i = 0; i < conections;i++)
				{
					//Get Peso for the direction selected
					Long newX = columnDijkstra.get(currentX).get(currentY).get(4+2*i);
					Long newY = columnDijkstra.get(currentX).get(currentY).get(5+2*i);
					Long originalPonderacion = column.get(newX.intValue()).get(newY.intValue()).get(1);
					Long terrain = column.get(newX.intValue()).get(newY.intValue()).get(ids.terrainType.getValue());
					Long peso = (long) (originalPonderacion* Lucas.elementAt(terrain_to_index(terrain)));
					
					if(column.get(newX.intValue()).get(newY.intValue()).get(0)!= 10 &&
							LucasList[newX.intValue()][newY.intValue()] == false)
					{
						relajacionLucas(currentX,currentY,newX.intValue(),newY.intValue(),peso);
					}
				}
			}
			
		}
		
		System.out.println("Mombos Dijkstra Routing Table");
		for(int i= 0; i < previousMatrixMombo.length;i++)
		{
			System.out.print("(");
			for(int j = 0; j < previousMatrixMombo[i].length;j++)
			{
				System.out.print(previousMatrixMombo[i][j] + " ");
			}
			System.out.print(")");
			System.out.println();
		}
		System.out.println();
		System.out.println("Pirolos Dijkstra Routing Table");
		for(int i= 0; i < previousMatrixPirolo.length;i++)
		{
			System.out.print("(");
			for(int j = 0; j < previousMatrixPirolo[i].length;j++)
			{
				System.out.print(previousMatrixPirolo[i][j] + " ");
			}
			System.out.print(")");
			System.out.println();
		}
		System.out.println();
		System.out.println("Lucas Dijkstra Routing Table");
		for(int i= 0; i < previousMatrixPirolo.length;i++)
		{
			System.out.print("(");
			for(int j = 0; j < previousMatrixPirolo[i].length;j++)
			{
				System.out.print(previousMatrixPirolo[i][j] + " ");
			}
			System.out.print(")");
			System.out.println();
		}
		InitializeTreePath();
		sleeptime = 700;
		dijkstra();
		
	}
	public void dijkstra()
	{
		int startC = staticlinkC;
		int startR = staticlinkR;
		int columnBefore = staticlinkC;
		int rowBefore = staticlinkR;
		int tempR;
		int tempC;
	
		labels[((startC+startR*obstacleValues[0]))].setIcon(blueLinkStartIcon);
		tempR = MomboTreePath.get(staticlinkR).get(staticlinkC).get(0);
		tempC = MomboTreePath.get(staticlinkR).get(staticlinkC).get(1);
		staticlinkR = tempR;
		staticlinkC = tempC;
		sleepFunction();
		
		while(MomboTreePath.get(staticlinkR).get(staticlinkC).get(0) != -1)
		{
			iconRedraw(columnBefore,rowBefore,staticlinkC,staticlinkR,1);
			columnBefore = staticlinkC;
			rowBefore = staticlinkR;
			tempR = MomboTreePath.get(staticlinkR).get(staticlinkC).get(0);
			tempC = MomboTreePath.get(staticlinkR).get(staticlinkC).get(1);
			staticlinkR = tempR;
			staticlinkC = tempC;
		}
		iconRedraw(columnBefore,rowBefore,staticlinkC,staticlinkR,1);
		linkFound();
		staticlinkC = startC;
		staticlinkR = startR;
		columnBefore = staticlinkC;
		rowBefore = staticlinkR;
		labels[startC+startR*obstacleValues[0]].setIcon(redLinkStartIcon);
		tempR = PiroloTreePath.get(staticlinkR).get(staticlinkC).get(0);
		tempC = PiroloTreePath.get(staticlinkR).get(staticlinkC).get(1);
		staticlinkR = tempR;
		staticlinkC = tempC;
		sleepFunction();
		
		while(PiroloTreePath.get(staticlinkR).get(staticlinkC).get(0) != -1)
		{	
			iconRedraw(columnBefore,rowBefore,staticlinkC,staticlinkR,2);
			columnBefore = staticlinkC;
			rowBefore = staticlinkR;
			tempR = PiroloTreePath.get(staticlinkR).get(staticlinkC).get(0);
			tempC = PiroloTreePath.get(staticlinkR).get(staticlinkC).get(1);
			staticlinkR = tempR;
			staticlinkC = tempC;	
		}
		iconRedraw(columnBefore,rowBefore,staticlinkC,staticlinkR,2);
		linkFound();
		staticlinkC = startC;
		staticlinkR = startR;
		columnBefore = staticlinkC;
		rowBefore = staticlinkR;
		labels[startC+startR*obstacleValues[0]].setIcon(linkStartIcon);
		tempR = LucasTreePath.get(staticlinkR).get(staticlinkC).get(0);
		tempC = LucasTreePath.get(staticlinkR).get(staticlinkC).get(1);
		staticlinkR = tempR;
		staticlinkC = tempC;
		sleepFunction();
		
		while(LucasTreePath.get(staticlinkR).get(staticlinkC).get(0) != -1)
		{		
			iconRedraw(columnBefore,rowBefore,staticlinkC,staticlinkR,3);
			columnBefore = staticlinkC;
			rowBefore = staticlinkR;
			tempR = LucasTreePath.get(staticlinkR).get(staticlinkC).get(0);
			tempC = LucasTreePath.get(staticlinkR).get(staticlinkC).get(1);
			staticlinkR = tempR;
			staticlinkC = tempC;		
		}
		iconRedraw(columnBefore,rowBefore,staticlinkC,staticlinkR,3);
		linkFound();
		DijkstraClick = false;
	}
	void relajacionMombo(int currentX,int currentY,int newX,int newY,Long peso)
	{
		if(distanceMatrixMombo[currentX][currentY] + peso < distanceMatrixMombo[newX][newY]
				|| distanceMatrixMombo[newX][newY] == -10)
		{
			distanceMatrixMombo[newX][newY] = (int) (distanceMatrixMombo[currentX][currentY] + peso);
			previousMatrixMombo[newX][newY] = Integer.toString(currentX) + "," + Integer.toString(currentY);
			tempInfo = new Vector<Integer>();
			tempInfo.add(newX);
			tempInfo.add(newY);
			tempInfo.add(distanceMatrixMombo[newX][newY]);
			sortQueue(tempInfo,MomboQueue);
		}
	}
	void relajacionPirolo(int currentX,int currentY,int newX,int newY,Long peso)
	{
		if(distanceMatrixPirolo[currentX][currentY] + peso < distanceMatrixPirolo[newX][newY] || distanceMatrixPirolo[newX][newY] == -10)
		{
			distanceMatrixPirolo[newX][newY] = (int) (distanceMatrixPirolo[currentX][currentY] + peso);
			previousMatrixPirolo[newX][newY] = Integer.toString(currentX) + "," + Integer.toString(currentY);
			tempInfo = new Vector<Integer>();
			tempInfo.add(newX);
			tempInfo.add(newY);
			tempInfo.add(distanceMatrixPirolo[newX][newY]);
			sortQueue(tempInfo,PiroloQueue);
		}
	}
	void relajacionLucas(int currentX,int currentY,int newX,int newY,Long peso)
	{
		if(distanceMatrixLucas[currentX][currentY] + peso < distanceMatrixLucas[newX][newY] || distanceMatrixLucas[newX][newY] == -10)
		{
			distanceMatrixLucas[newX][newY] = (int) (distanceMatrixLucas[currentX][currentY] + peso);
			previousMatrixLucas[newX][newY] = Integer.toString(currentX) + "," + Integer.toString(currentY);
			tempInfo = new Vector<Integer>();
			tempInfo.add(newX);
			tempInfo.add(newY);
			tempInfo.add(distanceMatrixLucas[newX][newY]);
			sortQueue(tempInfo,LucasQueue);
		}
	}
	void InitializeTreePath()
	{
		MomboTreePath = new Vector<Vector<Vector<Integer>>>();
		PiroloTreePath = new Vector<Vector<Vector<Integer>>>();
		LucasTreePath = new Vector<Vector<Vector<Integer>>>();
			for(int y = 0; y < obstacleValues[0];y++)
			{
				Vector<Vector<Integer>> cM,cP,cL;
				cM = new Vector<Vector<Integer>>();
				cP = new Vector<Vector<Integer>>(); 
				cL = new Vector<Vector<Integer>>(); 
				for(int x = 0; x < obstacleValues[0];x++)
				{
					Vector<Integer>  M,P,L;
					M = new Vector<Integer>();
					P = new Vector<Integer>();
					L = new Vector<Integer>();
					String coordinatesM = previousMatrixMombo[y][x];
					String coordinatesP = previousMatrixPirolo[y][x];
					String coordinatesL = previousMatrixLucas[y][x];
					int newY;
					int newX;
					int splitM = coordinatesM.indexOf(',');
					int splitP = coordinatesP.indexOf(',');
					int splitL = coordinatesL.indexOf(',');
					if(splitM > 0)
					{
						newY = Integer.parseInt(coordinatesM.substring(0, splitM));
						newX = Integer.parseInt(coordinatesM.substring(splitM+1,coordinatesM.length()));
						M.add(newY);
						M.add(newX);
						
						newY = Integer.parseInt(coordinatesP.substring(0, splitP));
						newX = Integer.parseInt(coordinatesP.substring(splitP+1,coordinatesP.length()));
						P.add(newY);
						P.add(newX);
						
						newY = Integer.parseInt(coordinatesL.substring(0, splitL));
						newX = Integer.parseInt(coordinatesL.substring(splitL+1,coordinatesL.length()));
						L.add(newY);
						L.add(newX);
							
					}
					else
					{
						M.add(-1);
						P.add(-1);
						L.add(-1);
					}
					cM.add(M);
					cP.add(P);
					cL.add(L);
					
				}
				MomboTreePath.add(cM);
				PiroloTreePath.add(cP);
				LucasTreePath.add(cL);
			}
	}
	public Boolean getDijkstraClick()
	{
		return DijkstraClick;
	}
}

