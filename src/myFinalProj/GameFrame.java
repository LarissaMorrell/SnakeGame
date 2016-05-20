package myFinalProj;

/**
 * @author Larissa Morrell
 * April 26, 2016
 * Snake Game 
 * Copyright (C) 2016 Larissa Morrell - All Rights Reserved
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class GameFrame extends JFrame{

	public GameFrame() {


		setTitle("Snake Game");
		setResizable(false);
		this.setSize(600, 650);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initGame();
	}




	public void initGame(){

		//		setLayout(new GridLayout(2,1,0,0));
		////		setLayout(new GridLayout(1,1,0,0));
		//		add(new SetupPanel(), 0);
		//		
		//		SnakePanel snakePnl = new SnakePanel();
		//		
		//		add(snakePnl, 1);
		////		add(snakePnl);


		this.setLayout(new BorderLayout());


		//When line SetupPanel is added, the keyListeners 
		//are no longer triggered
		
		this.add(new SetupPanel(), BorderLayout.NORTH);
		
		SnakePanel snakePanel = new SnakePanel();
		this.add(snakePanel, BorderLayout.SOUTH);



		setLocationRelativeTo(null);

		setVisible(true);
		snakePanel.requestFocusInWindow();  //MH Added this line
		
	}



	public static void main(String[] args) {
		new GameFrame();

	}




}
