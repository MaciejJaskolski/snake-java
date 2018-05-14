package snake_project;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;

public class Apple extends Canvas{
	
	boolean redraw = true;
	public int lastX, lastY;
	
	@Override
	public void paint(Graphics g) {
		//randomizing apple's position
		//Random r = new Random();
		if(redraw) {
			lastX = randomizeAppleX();
			lastY = randomizeAppleY();
			redraw = false;
		}
		g.setColor(Constants.appleColor);
		g.fillOval(lastX + 5, lastY + 5, (int)(Constants.TILE_SIZE * 0.8), (int)(Constants.TILE_SIZE * 0.8));		
	}
	
	Apple(){
		lastX = randomizeAppleX();
		lastY = randomizeAppleY();
		redraw = false;
	}
	
	private int randomizeAppleX() {
		Random r = new Random();
		int rW = r.nextInt(Constants.TILE_HORIZONTAL);
		return rW * Constants.TILE_SIZE;
	}
	
	private int randomizeAppleY() {
		Random r = new Random();
		int rH = r.nextInt(Constants.TILE_VERTICAL);
		return rH * Constants.TILE_SIZE;
	}
	
	public void redraw() {
		this.redraw = !redraw;
	}
	
	public boolean shouldRedraw() {
		return redraw;
	}
	
	public int getX() {
		return (lastX / Constants.TILE_SIZE);
	}
	
	public int getY() {
		return (lastY / Constants.TILE_SIZE);
	}
}
