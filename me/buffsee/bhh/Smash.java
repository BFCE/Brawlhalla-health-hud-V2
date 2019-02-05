package me.buffsee.bhh;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Smash extends Thread {
	
	private boolean twos = false;
	
	@Override
	public void run() {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(twos) {
			
		} else {
			Rectangle poneRect1 = new Rectangle(((int) (screensize.getWidth()/1.128)), 0, ((int) (screensize.getWidth()/20)), ((int) (screensize.getHeight()/10)));
			int x1 = (int) (screensize.getWidth() / 6),
				y1 = (int) (screensize.getHeight() / 1.2);
			
			Rectangle poneRect2 = new Rectangle(((int) (screensize.getWidth()/1.068)), 0, ((int) (screensize.getWidth()/20)), ((int) (screensize.getHeight()/10)));
			int x2 = (int) (screensize.getWidth() / 1.3),
				y2 = (int) (screensize.getHeight() / 1.2);
			
			new Thread("p1 updater thread") {
				@Override
				public void run() {
					SmashWindowObject p1 = new SmashWindowObject("p1", poneRect1, x1, y1);
					
				}
			}.start();
			new Thread("p2 updater thread") {
				@Override
				public void run() {
					SmashWindowObject p2 = new SmashWindowObject("p2", poneRect2, x2, y2);
				}
			}.start();

		}
	}

	
	public boolean isTwos() {
		return this.twos;
	}

	public void setTwos(boolean twos) {
		this.twos = twos;
	}


	
}
