/************************************************************************

This is just a file for testing the Perceptron.
If you deside to download the perceptron you should not use this file.
This is just an example.

Author: Lucas Gillberg Kling

************************************************************************/

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

public class Source extends Canvas implements Runnable {
	static point[] points;
	
	int length = points.length;
	int right  = 0;
	
	private static final long serialVersionUID = 1L;	//Not needed
	
	static Perceptron ptron = new Perceptron();
	
	public static int HEIGHT;
	public static int WIDTH;
	
	private Thread thread;
	private BufferStrategy bs = null;
	private Graphics graphics = null;
	
	private boolean running = false;
	
	public static void main(String[] args) {
        points = new point[Integer.parseInt(args[0])];
        ptron.learningrate = Double.parseDouble(args[1]);
        
        if (args[2] != null) {
            WIDTH = Integer.parseInt(args[2]);
            HEIGHT = WIDTH;
        }
        
        new Source();
	}
	
	private Source() {

        
        JFrame frame = new JFrame("Machine Learning");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(this);
		
		for (int i = 0; i < points.length; i++) {
			points[i] = new point();
		}
		
		thread = new Thread(this);
		
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		if(bs == null) {
			createBufferStrategy(2);
			bs = getBufferStrategy();
			graphics = bs.getDrawGraphics();
			
			thread.start();
			running = true;
		}
	}
	
	public void render() {
		right = 0;
		graphics.clearRect(0, 0, WIDTH, HEIGHT);
		graphics.setColor(Color.black);
		for (int i = 0; i < points.length; i++) {
			ptron.train(points[i].inputs, points[i].label);
			int guess = ptron.feedForward(points[i].inputs);
			
			if (guess == points[i].label) {
				right++;
				graphics.setColor(Color.GREEN);
				
				if(points[i].label == 1) {
					graphics.drawString("Up", points[i].x, points[i].y);
				} else {
					graphics.drawString("Down", points[i].x, points[i].y);
				}
			} else {
				graphics.setColor(Color.RED);
				
				if(points[i].label == 1) {
					graphics.drawString("Down", points[i].x, points[i].y);
				} else {
					graphics.drawString("Up", points[i].x, points[i].y);
				}
			}
			
			points[i].show(graphics);
			graphics.setColor(Color.BLACK);
			graphics.drawLine(WIDTH/2, HEIGHT/2, WIDTH, HEIGHT/2);
        }
	}
	
	@Override
	public void run() {
		while(running) {
			render();
			
			bs.show();
			
			Thread.currentThread();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
			}
		}
	}
}
