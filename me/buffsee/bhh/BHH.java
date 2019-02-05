package me.buffsee.bhh;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BHH extends Thread {
	private JFrame bhh = new JFrame("BHH");

	private boolean twos = false;
	
	@Override
	public void run() {
		JLabel healthleft = new JLabel("? | ?", SwingConstants.CENTER);
		healthleft.setFont(new Font("Verdana", Font.PLAIN, 42));

		bhh.add(healthleft);
		bhh.setUndecorated(true);
		bhh.setOpacity(0.8f);
		bhh.setSize(300, 50);
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		if(this.isTwos())
			bhh.setLocation((int) ((screensize.getWidth())/1.01) - bhh.getWidth(), (int) screensize.getHeight() / 5);
		else
			bhh.setLocation((int) ((screensize.getWidth())/1.01) - bhh.getWidth(), (int) screensize.getHeight() / 10);
		
		bhh.setAlwaysOnTop(true);
		
		HealthCalculator healthcalc = new HealthCalculator();
		healthcalc.initRobot();
		
		
		while (true) {
			if (bhh.isVisible()) {
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
					bhh.setLocation((int) ((screensize.getWidth())/1.01) - bhh.getWidth(), (int) screensize.getHeight() / 5);
				else
					bhh.setLocation((int) ((screensize.getWidth())/1.01) - bhh.getWidth(), (int) screensize.getHeight() / 10);

			}
			try {
				Thread.sleep(200);
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
