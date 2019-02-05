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
	private JFrame p1 = new JFrame("Player 1");
	private JFrame p2 = new JFrame("Player 2");
	private JFrame p3 = new JFrame("Player 3");
	private JFrame p4 = new JFrame("Player 4");
	
	private boolean twos = false;
	
	@Override
	public void run() {

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(twos) {
			
		} else {
			
			JLabel label = null;
			try {
				label = new JLabel(new ImageIcon(new Robot().createScreenCapture(new Rectangle(50, 50))));
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			p1.add(label);

			p1.setUndecorated(true);
			p1.setOpacity(1f);
			p1.setBackground(new Color(0, 0, 0, 0));
			p1.setAlwaysOnTop(true);
			p1.setLocation((int) (screensize.getWidth() / 5), (int) (screensize.getHeight() / 1.2));

			p1.setVisible(true);
			while (true) {
				try {
					label.setIcon(new ImageIcon(this.getScaledImage(new Robot().createScreenCapture(new Rectangle(
							((int) (screensize.getWidth()/1.128)), ((int) (screensize.getHeight()/65)), ((int) (screensize.getWidth()/20)), ((int) (screensize.getHeight()/12)))))));
					p1.pack();
					System.out.println("setIcon!");
					
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	
	public boolean isTwos() {
		return this.twos;
	}

	public void setTwos(boolean twos) {
		this.twos = twos;
	}

	 /**
	 * Resizes an image using a Graphics2D object backed by a BufferedImage.
	 * @param srcImg - source image to scale
	 * @param w - desired width
	 * @param h - desired height
	 * @return - the new resized image
	 */
	private BufferedImage getScaledImage(Image srcImg){
		int w = (int) (srcImg.getWidth(null)*1.5);
		int h = (int) (srcImg.getHeight(null)*1.5);
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
	    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}
	
}
