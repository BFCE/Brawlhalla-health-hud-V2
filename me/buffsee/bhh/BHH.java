package me.buffsee.bhh;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BHH extends Thread {
	public JFrame bhh = new JFrame("BHH");

	private boolean twos = false;
	
	@Override
	public void run() {
		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

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

		Rectangle screenRectLeft = new Rectangle((int) (screensize.getWidth() / 1.1),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.1) + 1,
				(int) screensize.getHeight() / 12);
		Rectangle screenRectRight = new Rectangle((int) (screensize.getWidth() / 1.04),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.04) + 1,
				(int) screensize.getHeight() / 12);

		Rectangle screenRectBottomLeft = new Rectangle((int) (screensize.getWidth() / 1.1),
				(int) (screensize.getHeight() / 5.5) - 1, (int) (screensize.getWidth() / 1.1) + 1,
				(int) (screensize.getHeight() / 5.5));
		Rectangle screenRectBottomRight = new Rectangle((int) (screensize.getWidth() / 1.04),
				(int)(screensize.getHeight() / 5.5) - 1, (int) (screensize.getWidth() / 1.04) + 1,
				(int) (screensize.getHeight() / 5.5));
		
		
		while (true) {
			if (bhh.isVisible()) {
				String toplefthealth = String.valueOf((int) this.getHealthFromPixel(0, 0, robot, screenRectLeft));
				String toprighthealth = String.valueOf((int) this.getHealthFromPixel(0, 0, robot, screenRectRight));
				if(this.isTwos()) {
					String topleftbottomhealth = String.valueOf((int) this.getHealthFromPixel(0, 0, robot, screenRectBottomLeft));
					String toprightbottomhealth = String.valueOf((int) this.getHealthFromPixel(0, 0, robot, screenRectBottomRight));
					healthleft.setText("<html>" + toplefthealth + " | " + toprighthealth + "<br>" +
					topleftbottomhealth  + " | " + toprightbottomhealth + "</br></html>");
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

	public double getHealthFromColor(int[] tst) {
		double algorithm = (765 - (tst[0] + tst[1] + tst[2])) / 5;
		if (algorithm >= 51)
			algorithm = (609 - (tst[0] + tst[1] + tst[2])) / 2;

		if (algorithm > 100)
			algorithm = (707 - (tst[0] + tst[1] + tst[2])) / 3;

		if (algorithm > 150)
			algorithm = 345.802 - (((tst[0] + tst[1] + tst[2])) / 0.655) / 2;

		if (algorithm > 201) {
			algorithm = 390 - (tst[0] + tst[1] + tst[2]);
		}
		if (algorithm > 251) {
			algorithm = 357.1 - (tst[0] + tst[1] + tst[2]) * 0.7692307692307692;
		}
		return algorithm;
	}

	public double getHealthFromPixel(int x, int y, Robot robot, Rectangle rect) {
		int tst[] = null;
		tst = robot.createScreenCapture(rect).getData().getPixel(x, y, tst);
		
		return this.getHealthFromColor(tst);
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
