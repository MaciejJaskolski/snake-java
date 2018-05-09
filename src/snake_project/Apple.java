package snake_project;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;

public class Apple extends Canvas{
	@Override
	public void paint(Graphics g) {
		//randomizing apple's position
		Random r = new Random();
		int rW = randomizeAppleX();
		int rH = randomizeAppleY();
		g.setColor(Constants.appleColor);
		g.fillOval(rW + 5, rH + 5, (int)(Constants.TILE_SIZE * 0.8), (int)(Constants.TILE_SIZE * 0.8));		
	}
	
	public int randomizeAppleX() {
		Random r = new Random();
		int rW = r.nextInt(Constants.TILE_HORIZONTAL);
		return rW * Constants.TILE_SIZE;
	}
	
	public int randomizeAppleY() {
		Random r = new Random();
		int rH = r.nextInt(Constants.TILE_VERTICAL);
		return rH * Constants.TILE_SIZE;
	}
	
}
