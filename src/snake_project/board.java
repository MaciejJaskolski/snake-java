package snake_project;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class board {
	private snake s = new snake();
	private Apple a = new Apple();
	private Direction curDir = Direction.DOWN;
	
	//draws snake
	public void drawSnake(Graphics g) {
		int x, y;
		for(tile t : s) {
			x = t.getX() * Constants.TILE_SIZE;
			y = t.getY() * Constants.TILE_SIZE;
			
			g.setColor(Constants.snakeColor);
			g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
		}
	}
	
	public void goUp() {
		curDir = Direction.UP;
	}
}
