package snake_project;

import java.awt.Canvas;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.Timer;

import snake_project.tile.TYPE;

public class gameboard extends JComponent implements ActionListener{
	private snake s;
	private Apple a;
	private Direction curDir;
	private boolean isGameOver;
	Timer timer;
	
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
	
	gameboard(){
		curDir = Direction.DOWN;
		isGameOver = false;
		a = new Apple();
		s = new snake();
		timer = new Timer(Constants.BASE_GAME_SPEED, this);
		timer.start();
	}
	
	public void reset() {
		curDir = Direction.DOWN;
		isGameOver = false;
		s = new snake();
	}
	
	public void speedUp() {
		Constants.BASE_GAME_SPEED -= Constants.SPEED_CHANGE;
		if(Constants.BASE_GAME_SPEED < Constants.FASTEST_SPEED)
			Constants.BASE_GAME_SPEED = Constants.FASTEST_SPEED;
		//System.out.println(Constants.BASE_GAME_SPEED);
	}
	
	public void speedDown() {
		Constants.BASE_GAME_SPEED += Constants.SPEED_CHANGE;
		if(Constants.BASE_GAME_SPEED > Constants.SLOWEST_SPEED)
			Constants.BASE_GAME_SPEED = Constants.SLOWEST_SPEED; 
		//System.out.println(Constants.BASE_GAME_SPEED);
	}
	
	@Override	
	public void paintComponent(Graphics g) {	
		super.paint(g);
		if(!isGameOver) {
			g.setColor(Constants.backgroundColor);
			g.fillRect(0, 0, Constants.TILE_SIZE*Constants.TILE_HORIZONTAL ,  Constants.TILE_SIZE*Constants.TILE_VERTICAL);
			a.paint(g);
			drawSnake(g);
		}
		else {
			g.drawString("Game over!", 170, 300);
		}
	}
	
	void goUp() {
		if(curDir != Direction.DOWN)
			curDir = Direction.UP;
	}
	
	void goDown() {
		if(curDir != Direction.UP)
			curDir = Direction.DOWN;
	}
	
	void goLeft() {
		if(curDir != Direction.RIGHT)
			curDir = Direction.LEFT;
	}
	
	void goRight() {
		if(curDir != Direction.LEFT)
			curDir = Direction.RIGHT;
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(!isGameOver) {
			if(curDir == Direction.UP)
				s.moveUp();
			else if(curDir == Direction.DOWN)
				s.moveDown();
			else if(curDir == Direction.LEFT)
				s.moveLeft();
			else if(curDir == Direction.RIGHT)
				s.moveRight();
			GameLogic();
			repaint();
		}
    }
	
	public void GameLogic() {
		if(s.getX() == a.getX() &&
				s.getY() == a.getY())
		{			
			System.out.println("Eatan apple!");
			s.grow();
			a.redraw();
		}
		//
		int l = -1;
		for(tile t : s) {
			l++;
			if(l==0) continue;
			else {
				if(s.getX() == t.getX() && s.getY() == t.getY())
					isGameOver = true;
			}
		}
	}
}
