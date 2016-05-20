package myFinalProj;

import java.awt.Color;
import java.awt.Graphics;

public class Bomb {
	
	private int xCoor, yCoor, boxSize;

	public Bomb(int xCoor, int yCoor, int boxSize) {

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

		//Draw bomb
//		g.setColor(Color.BLACK);
//		g.fillRect(xCoor * boxSize, yCoor * boxSize, boxSize, boxSize);
//		
		//light brown
		g.setColor(new Color(205, 133, 63)); 
		g.fillRect(xCoor * boxSize + 1, yCoor * boxSize + 1, boxSize - 2, boxSize - 2);
		
		//medium brown
		g.setColor(new Color(160, 82, 45));
		g.fillRect(xCoor * boxSize + 2, yCoor * boxSize + 2, boxSize - 4, boxSize - 4);


	}
	
}
