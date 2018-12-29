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
		bhh.setSize(300, 100);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		bhh.setLocation((int) (screensize.getWidth()) - 300, (int) screensize.getHeight() / 10);
		bhh.setAlwaysOnTop(true);

		Rectangle screenRectLeft = new Rectangle((int) (screensize.getWidth() / 1.1),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.1) + 1,
				(int) screensize.getHeight() / 12);
		Rectangle screenRectRight = new Rectangle((int) (screensize.getWidth() / 1.04),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.04) + 1,
				(int) screensize.getHeight() / 12);

		while (true) {
			if (bhh.isVisible()) {
				String toplefthealth = String.valueOf((int) this.getHealthFromPixel(0, 0, robot, screenRectLeft));
				String toprighthealth = String.valueOf((int) this.getHealthFromPixel(0, 0, robot, screenRectRight));

				healthleft.setText(toplefthealth + " | " + toprighthealth);
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

	public void startExplorer() {
		try {
			Runtime.getRuntime().exec("explorer.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stopExplorer() {
		try {
			Runtime.getRuntime().exec("taskkill /f /im explorer.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
