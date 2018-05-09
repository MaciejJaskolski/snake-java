package snake_project;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class main_window extends JFrame {

	private board Canvas = new board();
	private snake s = new snake();
	private Apple a = new Apple();
	
	private static main_window frame = new main_window();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//main_window frame = new main_window();
					//frame.repaint();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setFocusable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		//JFrame fr = new main_window();
	}
	
	void goUp() {
		s.moveUp();
	}
	
	 private class keyAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent keyEvent) {

	            if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
	            	s.moveUp(); 
	            	frame.add(Canvas);
	            } 
	            else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
	            	s.moveRight(); 
	            	frame.add(Canvas);
	            }
	            else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
	            	s.moveDown(); 
	            	frame.add(Canvas);
	            }
	            else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
	            	s.moveLeft(); 
	            	frame.add(Canvas);
	            }
	        }
	        
	}
	
	public void drawSnake(Graphics g) {
		int x, y;
		for(tile t : s) {
			x = t.getX() * Constants.TILE_SIZE;
			y = t.getY() * Constants.TILE_SIZE;
			
			g.setColor(Constants.snakeColor);
			g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
		}
	}


	/**
	 * Create the frame.
	 */
	public main_window() {
		setLayout(new BorderLayout());
		int width = Constants.TILE_SIZE * Constants.TILE_HORIZONTAL;
		int height = Constants.TILE_SIZE * Constants.TILE_VERTICAL;
		//setPreferredSize(new Dimension(width, height));
		setSize(new Dimension(width+5, height+30));
		setTitle("Snake");
		setVisible(true);
		setFocusable(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(Canvas);
		
		setLocationRelativeTo(null);
		addKeyListener(new keyAdapter());
	}
	
	private class board extends Canvas {
		//draws board
		@Override
		public void paint(Graphics g) {
		
			//fills the background
			g.setColor(Constants.backgroundColor);
			g.fillRect(0, 0, Constants.TILE_SIZE*Constants.TILE_HORIZONTAL ,  Constants.TILE_SIZE*Constants.TILE_VERTICAL);
			for(int i =0;i<Constants.TILE_HORIZONTAL;i++) {
				for(int j=0;j<Constants.TILE_VERTICAL;j++) {
					//draws borders
					g.setColor(Constants.borderColor);
					g.drawLine(i*Constants.TILE_SIZE, 0, i*Constants.TILE_SIZE, Constants.TILE_SIZE * Constants.TILE_VERTICAL);
					g.drawLine(0, j*Constants.TILE_SIZE, Constants.TILE_SIZE * Constants.TILE_HORIZONTAL, j*Constants.TILE_SIZE);
				}
			}
			a.paint(g);
			drawSnake(g);
		}
	}

}
