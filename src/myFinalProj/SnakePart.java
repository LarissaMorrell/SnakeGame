package myFinalProj;

import java.awt.Color;
import java.awt.Graphics;

public class SnakePart {
	
	private int xCoor, yCoor, boxSize;

	public SnakePart(int xCoor, int yCoor, int boxSize) {
		
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.boxSize = boxSize;
		
	}

	
	
	public int getxCoor() {
		return xCoor;
	}

	public void setxCoor(int x) {
		xCoor = x;
	}

	public int getyCoor() {
		return yCoor;
	}

	public void setyCoor(int y) {
		this.yCoor = y;
	}

	public void draw(Graphics g){
		
		//design the body of the snake
		g.setColor(Color.BLACK);
		g.fillRect(xCoor * boxSize, yCoor * boxSize, boxSize, boxSize);
		g.setColor(Color.green);
		g.fillRect(xCoor * boxSize + 2, yCoor * boxSize + 2, boxSize - 4, boxSize - 4);
//		g.fill3DRect(xCoor * boxSize, yCoor * boxSize, boxSize, boxSize, true);
//		g.fillOval(xCoor * boxSize, yCoor * boxSize, boxSize, boxSize);
		
	}

}
