package myFinalProj;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {

	private int xCoor, yCoor, boxSize;


	public Apple(int xCoor, int yCoor, int boxSize) {

		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.boxSize = boxSize;
	}
	


	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int x) {
		this.xCoor = x;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int y) {
		this.yCoor = y;
	}


	public void draw(Graphics g){

		//Draw apple
		g.setColor(Color.RED);
		g.fillOval(xCoor * boxSize, yCoor * boxSize, boxSize, boxSize);
		
		//Draw leaf
		g.setColor(Color.GREEN);
		g.fillArc(xCoor * boxSize, yCoor * boxSize - 3, 10, 10, 90, -50 );

	}
}
