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
			int radius = ((int) (screensize.getWidth()/21.5));

			Rectangle poneRect1 = new Rectangle(((int) (screensize.getWidth()/1.128)), ((int) (screensize.getHeight()/60)), radius, radius);
			/*
			 * these are all a little bit too far to the left.
			 */
			int x1 = (int) (screensize.getWidth() / 5.5),
				y1 = (int) (screensize.getHeight() / 1.2);
			
			Rectangle poneRect2 = new Rectangle(((int) (screensize.getWidth()/1.066)), ((int) (screensize.getHeight()/60)), radius, radius);
			int x2 = (int) (screensize.getWidth() / 2.8),
				y2 = (int) (screensize.getHeight() / 1.2);
			
			Rectangle poneRect3 = new Rectangle(((int) (screensize.getWidth()/1.128)), ((int) (screensize.getHeight()/8.8)), radius, radius);
			int x3 = (int) (screensize.getWidth() / 1.86),
				y3 = (int) (screensize.getHeight() / 1.2);
			
			Rectangle poneRect4 = new Rectangle(((int) (screensize.getWidth()/1.066)), ((int) (screensize.getHeight()/8.8)), radius, radius);
			int x4 = (int) (screensize.getWidth() / 1.4),
				y4 = (int) (screensize.getHeight() / 1.2);
			
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
			new Thread("p3 updater thread") {
				@Override
				public void run() {
					SmashWindowObject p3 = new SmashWindowObject("p3", poneRect3, x3, y3);
				}
			}.start();
			new Thread("p4 updater thread") {
				@Override
				public void run() {
					SmashWindowObject p4 = new SmashWindowObject("p4", poneRect4, x4, y4);
				}
			}.start();
		} else {
			int radius = ((int) (screensize.getWidth()/21.5));

			Rectangle poneRect1 = new Rectangle(((int) (screensize.getWidth()/1.128)), ((int) (screensize.getHeight()/60)), radius, radius);
			int x1 = (int) (screensize.getWidth() / 7),
				y1 = (int) (screensize.getHeight() / 1.2);
			
			Rectangle poneRect2 = new Rectangle(((int) (screensize.getWidth()/1.066)), ((int) (screensize.getHeight()/60)), radius, radius);
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
