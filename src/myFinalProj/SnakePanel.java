package myFinalProj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


public class SnakePanel extends JPanel implements Runnable{

	public static final long serialVersionUID = 1L;

	public static final int WIDTH = 600, HEIGHT = 600;

	private Thread thread;
	private boolean running = false;

	private SnakePart b;
	private ArrayList<SnakePart> snake;

	private Apple apple;
	private ArrayList<Apple> apples;

	private int xCoor, yCoor, size;
	private int ticker; //count for move()

	private Directions dir;

	private Random r;


	/**
	 * Constructor sets the size of panel, generates a 
	 * default snake, an apple, and sets keyListeners. 
	 * Starts movement of the snake.
	 */
	public SnakePanel() {

		setFocusable(true); //Focus on this panel or snake won't move

		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		r = new Random();
		ticker = 0;

		snake = new ArrayList<SnakePart>();
		defaultSnake();

		apples = new ArrayList<Apple>();

		this.setBackground(Color.DARK_GRAY);

		this.addKeyListener(new Key());

		startMoving();
	}





	/**
	 * Set placement of the snake and its start size 
	 * when the game starts
	 */
	private void defaultSnake(){

		//start off placement
		xCoor = 15;
		yCoor = 15;

		//initial size of snake
		size = 8;

		dir = Directions.RIGHT;

	}





	/**
	 * 
	 */
	private void move(){

		if(snake.size() == 0){
			//make a new body part & add it to the body
			b = new SnakePart(xCoor, yCoor, 10);
			snake.add(b);
		}

		//place an apple in a random place on the grid
		if(apples.size() == 0){
			int xCoor = r.nextInt(59);
			int yCoor = r.nextInt(59);

			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}


		for(int i = 0; i < apples.size(); i++){

			if(xCoor == apples.get(i).getxCoor() 
					&& yCoor == apples.get(i).getyCoor()){
				size++;
				apples.remove(i);
				i--;
			}
		}

		
		

		
		//Check to see if the snake runs into itself
		for(int i = 0; i < snake.size(); i++){

			//if the xCoor and yCoor are present in the snake ArrayList
			if(xCoor == snake.get(i).getxCoor() && 
					yCoor == snake.get(i).getyCoor()){

				//if 2 different snake parts are in the same space
				//skip checking the head against the head
				if(i != snake.size() - 1){	
					stopMoving();
				}
			}
		}

		//Game is over when snake goes off the grid
		if(xCoor < 0 || xCoor > 59 || yCoor < 0 || yCoor > 59){
			stopMoving();
		}


		ticker++;

		//slow down the snake so that it is at a manageable speed
		if(ticker > 800000){

			if(dir == Directions.RIGHT) xCoor++;
			if(dir == Directions.LEFT) xCoor--;
			if(dir == Directions.UP) yCoor--;
			if(dir == Directions.DOWN) yCoor++;

			//reset the ticker
			ticker = 0;

			//add a new body part
			b = new SnakePart(xCoor, yCoor, 10);
			snake.add(b);

			//Keep the snake at a constant size variable
			//by removing the head
			if(snake.size() > size){
				snake.remove(0);
			}
		}



	}




	
	/**
	 * Starts movement of the snake by instantiating 
	 * a new thread
	 */
	private void startMoving(){
		running = true;
		thread = new Thread(this, "snake movement");
		thread.start();
	}





	/**
	 * Stops movement of the snake. 
	 */
	private void stopMoving(){
		running = false;
		try {
			thread.join();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}





	/**
	 * When the thread is running the move method is called
	 * and then the snake is repainted.
	 */
	@Override
	public void run() {
		while(running){
			move();
			repaint();
		}
	}





	/**
	 * Draws the grid & sets its colors. Adds the snake
	 * to the grid and the apple to the grid.
	 * @param g
	 */
	public void paint(Graphics g){

		g.setColor(Color.BLACK);

		//draw grid rows
		for(int i = 0; i < HEIGHT/10; i++){
			g.drawLine(0, i * 10, WIDTH, i * 10);
		}

		//draw grid columns
		for(int i = 0; i < WIDTH/10; i++){
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}


		//draw the snake
		for(int i = 0; i < snake.size(); i++){
			snake.get(i).draw(g);
		}

		//draw the apple
		for(int i = 0; i < apples.size(); i++){
			apples.get(i).draw(g);
		}

	}





	/**
	 * When the arrow keys are pressed, the snake will move
	 * in the given direction by setting bool values
	 * @author Larissa
	 *
	 */
	private class Key implements KeyListener{


		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			//right arrow is pressed but snake isn't already
			//traveling left. Otherwise, the snake would back
			//up onto itself and game would be over.
			if(key == e.VK_RIGHT && dir != Directions.LEFT){
				dir = Directions.RIGHT;
			}

			if(key == e.VK_LEFT && dir != Directions.RIGHT){
				dir = Directions.LEFT;
			}

			if(key == e.VK_UP && dir != Directions.DOWN){
				dir = Directions.UP;
			}

			if(key == e.VK_DOWN && dir != Directions.UP){
				dir = Directions.DOWN;
			}


		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}