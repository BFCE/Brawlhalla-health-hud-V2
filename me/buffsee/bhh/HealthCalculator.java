package me.buffsee.bhh;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

public class HealthCalculator {

	private final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	private Robot robot = null;
	
	public String getTopLeftHealth() {
		Rectangle screenRectLeft = new Rectangle((int) (screensize.getWidth() / 1.1),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.1) + 1,
				(int) screensize.getHeight() / 12);
		String toplefthealth = String.valueOf((int) this.getHealthFromPixel(screenRectLeft));
		return toplefthealth;
	}
	
	public String getTopRightHealth() {
		Rectangle rect = new Rectangle((int) (screensize.getWidth() / 1.04),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.04) + 1,
				(int) screensize.getHeight() / 12);
		String health = String.valueOf((int) this.getHealthFromPixel(rect));
		return health;
	}
	
	public String getBottomLeftHealth() {
		Rectangle rect = new Rectangle((int) (screensize.getWidth() / 1.1),
				(int) (screensize.getHeight() / 5.5) - 1, (int) (screensize.getWidth() / 1.1) + 1,
				(int) (screensize.getHeight() / 5.5));
		String health = String.valueOf((int) this.getHealthFromPixel(rect));
		return health;
	}
	
	public String getBottomRightHealth() {
		Rectangle rect = new Rectangle((int) (screensize.getWidth() / 1.04),
				(int)(screensize.getHeight() / 5.5) - 1, (int) (screensize.getWidth() / 1.04) + 1,
				(int) (screensize.getHeight() / 5.5));
		String health = String.valueOf((int) this.getHealthFromPixel(rect));
		return health;
	}
	
	
	public int[] getTopLeftColor() {
		Rectangle rect = new Rectangle((int) (screensize.getWidth() / 1.1),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.1) + 1,
				(int) screensize.getHeight() / 12);
		return this.getRGBFromPixel(rect);
	}
	
	public int[] getTopRightColor() {
		Rectangle rect = new Rectangle((int) (screensize.getWidth() / 1.04),
				((int) screensize.getHeight() / 12) - 1, (int) (screensize.getWidth() / 1.04) + 1,
				(int) screensize.getHeight() / 12);
		return this.getRGBFromPixel(rect);
	}
	
	public int[] getBottomLeftColor() {
		Rectangle rect = new Rectangle((int) (screensize.getWidth() / 1.1),
				(int) (screensize.getHeight() / 5.5) - 1, (int) (screensize.getWidth() / 1.1) + 1,
				(int) (screensize.getHeight() / 5.5));
		return this.getRGBFromPixel(rect);
	}
	
	public int[] getBottomRightColor() {
		Rectangle rect = new Rectangle((int) (screensize.getWidth() / 1.04),
				(int)(screensize.getHeight() / 5.5) - 1, (int) (screensize.getWidth() / 1.04) + 1,
				(int) (screensize.getHeight() / 5.5));
		return this.getRGBFromPixel(rect);
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

	private double getHealthFromPixel(Rectangle rect) {
		int tst[] = null;
		tst = robot.createScreenCapture(rect).getData().getPixel(0, 0, tst);
		
		return this.getHealthFromColor(tst);
	}
	
	private int[] getRGBFromPixel(Rectangle rect) {
		int tst[] = null;
		tst = robot.createScreenCapture(rect).getData().getPixel(0, 0, tst);
		
		return tst;
	}

	public void initRobot() {
		try {
			this.robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
