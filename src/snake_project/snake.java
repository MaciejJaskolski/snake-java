package snake_project;

import java.util.ArrayList;
import java.util.Iterator;


public class snake implements Iterable<tile>{
	
	private ArrayList<tile> snakeList= new ArrayList<>();
	int size = 1;
	
	snake() {
		snakeList.add(new tile(tile.TYPE.SNAKE, Constants.TILE_MIDDLE_W, Constants.TILE_MIDDLE_H));
	}
	
	public int getX() {
		return snakeList.get(0).getX();
	}
	
	void removeTail() {
		tile tail = snakeList.get(snakeList.size() - 1);
		if(snakeList.size() > size) {
			snakeList.remove(tail);
		}
	}
	
	void eatApple() {
		this.size++;
	}
	
	void moveUp() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		System.out.println(curX);
		System.out.println(curY);
		tile newHead = new tile(tile.TYPE.SNAKE, curX, curY - 1);
		
		snakeList.add(0, newHead);
		removeTail();
	}
	
	void moveRight() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		tile newHead = new tile(tile.TYPE.SNAKE, curX + 1, curY);
		
		snakeList.add(0, newHead);
		removeTail();
	}
	
	void moveDown() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		tile newHead = new tile(tile.TYPE.SNAKE, curX, curY + 1);
		
		snakeList.add(0, newHead);
		removeTail();
	}
	
	void moveLeft() {
		int curX = snakeList.get(0).getX();
		int curY = snakeList.get(0).getY();
		tile newHead = new tile(tile.TYPE.SNAKE, curX - 1, curY);
		
		snakeList.add(0, newHead);
		removeTail();
	}

	@Override
	public Iterator<tile> iterator() {
		return snakeList.iterator();
	}
	
	
}
