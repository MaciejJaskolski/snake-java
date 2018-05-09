package snake_project;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class tile{

	private TYPE type;
	private int x, y;
	/**
	 * Create the panel.
	 */
	public tile(TYPE t, int x, int y) {
		this.x = x;
		this.y = y;
		this.type = t;
	}
	
	void setType(TYPE newType){
		this.type = newType;
	}
	
	TYPE getType(){
		return this.type;
	}
	
	int getX() {
		return this.x;
	}
	
	int getY() {
		return this.y;
	}
	
	
	enum TYPE {
		TILE,
		SNAKE,
		APPLE
	}

}
