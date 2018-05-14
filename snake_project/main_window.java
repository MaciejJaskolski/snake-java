package snake_project;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class main_window extends JFrame implements ActionListener {

	private board Canvas = new board();
	private gameboard b;
	Direction dir = Direction.UP;
	boolean shouldDrawApple = true;
	
	public JButton btnSpeedUp = new JButton("Speed Up");
	public JButton btnSpeedDown = new JButton("Speed Down");
	public JButton btnRestart = new JButton("Restart");
	

	private static main_window frame = new main_window();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setFocusable(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
	}
	
	
	 private class keyAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent keyEvent) {

	            if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {  
	            	b.goUp();
	            }
	            else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
	            	b.goRight();
	            }
	            else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
	            	b.goDown();
	            }
	            else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
	            	b.goLeft();
	            }
	            else if(keyEvent.getKeyCode() == KeyEvent.VK_A) {
	            	b.speedUp();
	            }
	            else if(keyEvent.getKeyCode() == KeyEvent.VK_S) {
	            	b.speedDown();
	            }
	        }
	        
	}

	/**
	 * Create the frame.
	 */
	public main_window() {
		setLayout(new BorderLayout());
		int width = Constants.TILE_SIZE * Constants.TILE_HORIZONTAL;
		int height = Constants.TILE_SIZE * Constants.TILE_VERTICAL + 90;
		setSize(new Dimension(width+5, height+30));
		setTitle("Snake");
		setFocusable(true);
		b = new gameboard();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnSpeedUp.setBounds(30, 600, 100, 35);
		btnSpeedDown.setBounds(150, 600, 150, 35);
		btnRestart.setBounds(430, 600, 100, 35);
		btnSpeedUp.addActionListener(this);
		btnSpeedDown.addActionListener(this);
		btnRestart.addActionListener(this);
		add(btnSpeedUp);
		add(btnSpeedDown);
		add(btnRestart);
		btnSpeedUp.setFocusable(false);
		btnSpeedDown.setFocusable(false);
		btnRestart.setFocusable(false);
		add(b);
		addKeyListener(new keyAdapter());
		add(Canvas);
		setLocationRelativeTo(null);
		addKeyListener(new keyAdapter());
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == btnSpeedUp ) {
			System.out.println("Speed up!");
			b.speedUp();
		}
		else if(evt.getSource() == btnSpeedDown ) {
			System.out.println("Speed down!");
			b.speedDown();
		}
		else if(evt.getSource() == btnRestart ) {
			b.reset();
		}
	}
	
	public class board extends Canvas {
		//draws board
		@Override
		public void paint(Graphics g) {
			repaint();
		
			b.paintComponent(g);
			try {
				Thread.sleep(Constants.BASE_GAME_SPEED);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
