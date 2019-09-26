package me.buffsee.bhh;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BHH extends Thread {
	private JFrame bhh = new JFrame("BHH");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	private int x = (int) (((screensize.getWidth())/1.01) - bhh.getWidth());
	private int y = (int) screensize.getHeight() / 5;
	private boolean twos = false;
	
	@Override
	public void run() {
		JLabel healthleft = new JLabel("? | ?", SwingConstants.CENTER);
		healthleft.setFont(new Font("Verdana", Font.PLAIN, 42));

		bhh.add(healthleft);
		bhh.setUndecorated(true);
		bhh.setOpacity(0.8f);
		bhh.setSize(300, 50);
		
		if(this.isTwos()) {
			x = (int) ((screensize.getWidth())/1.01) - bhh.getWidth();
			y = (int) screensize.getHeight() / 5;
		} else {
			x = (int) ((screensize.getWidth())/1.01) - bhh.getWidth();
			y = (int) screensize.getHeight() / 10;
		}
		bhh.setLocation(x, y);
		bhh.setAlwaysOnTop(true);
		
		HealthCalculator healthcalc = new HealthCalculator();
		healthcalc.initRobot();
		
		while (true) {
			if (bhh.isVisible()) {
				if(Main.alt && Main.control && Main.shift) {
					x = MouseInfo.getPointerInfo().getLocation().x-250;
					y = MouseInfo.getPointerInfo().getLocation().y;
				}
				String toplefthealth = healthcalc.getTopLeftHealth();
				String toprighthealth = healthcalc.getTopRightHealth();
				if(this.isTwos()) {
					String leftbottomhealth = healthcalc.getBottomLeftHealth();
					String rightbottomhealth = healthcalc.getBottomRightHealth();
					healthleft.setText("<html>" + toplefthealth + " | " + toprighthealth + "<br>" +
					leftbottomhealth  + " | " + rightbottomhealth + "</br></html>");
				} else
					healthleft.setText("<html>" + toplefthealth + " | " + toprighthealth + " " + "</html>");
				
				
				bhh.pack();
				if(this.isTwos())
					bhh.setLocation(x + 250 - bhh.getWidth(), y);
				else
					bhh.setLocation(x + 250 - bhh.getWidth(), y);

			}
			try {
				if(!(Main.alt && Main.control && Main.shift)) 
					Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void hideWindow() {
		bhh.setVisible(false);
	}

	public void showWindow() {
		bhh.setVisible(true);
	}

	public boolean isTwos() {
		return twos;
	}

	public void setTwos(boolean twos) {
		this.twos = twos;
	}

}
