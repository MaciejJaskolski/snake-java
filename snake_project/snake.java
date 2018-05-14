package snake_project;

import java.util.ArrayList;
import java.util.Iterator;

import snake_project.tile.TYPE;


public class snake implements Iterable<tile>{
	
	private ArrayList<tile> snakeList= new ArrayList<>();
	int size = 1;
	
	snake() {
		snakeList.add(new tile(tile.TYPE.SNAKE, Constants.TILE_MIDDLE_W, Constants.TILE_MIDDLE_H));
	}
	
	public int getX() {
		return snakeList.get(0).getX();
	}
	
	public int getY() {
		return snakeList.get(0).getY();
	}
	
	synchronized void removeTail() {
		tile tail = snakeList.get(snakeList.size() - 1);
		if(snakeList.size() > size) {
			snakeList.remove(tail);
		}
	}
	
	void grow() {
		this.size++;
	}
	
	synchronized void moveUp() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		tile newHead;
		if(curY < 1)
			newHead = new tile(tile.TYPE.SNAKE, curX, Constants.TILE_VERTICAL -1);
		else 
			newHead = new tile(tile.TYPE.SNAKE, curX, curY - 1);
		
		snakeList.add(0, newHead);
		removeTail();
	}
	
	void moveRight() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		tile newHead;
		if(curX + 1 > 10) 
			newHead = new tile(tile.TYPE.SNAKE, 0, curY);
		else
			newHead = new tile(tile.TYPE.SNAKE, curX + 1, curY);
		if(newHead.getType() != TYPE.SNAKE) {
			System.out.println("game over");
		}
		else {
			snakeList.add(0, newHead);
		}
		removeTail();
	}
	
	synchronized void moveDown() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		tile newHead;
		if(curY > Constants.TILE_VERTICAL -2 )
			newHead = new tile(tile.TYPE.SNAKE, curX, 0);
		else
			newHead = new tile(tile.TYPE.SNAKE, curX, curY + 1);
		
		snakeList.add(0, newHead);
		removeTail();
	}
	
	synchronized void moveLeft() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		tile newHead; 
		if(curX < 1)
			newHead = new tile(tile.TYPE.SNAKE, Constants.TILE_HORIZONTAL - 1, curY);
		else
			newHead= new tile(tile.TYPE.SNAKE, curX - 1, curY);
		
		snakeList.add(0, newHead);
		removeTail();
	}

	@Override
	public Iterator<tile> iterator() {
		return snakeList.iterator();
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
}
