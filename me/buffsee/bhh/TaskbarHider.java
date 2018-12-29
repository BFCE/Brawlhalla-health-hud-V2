package me.buffsee.bhh;

import java.awt.Color;

import javax.swing.JFrame;

public class TaskbarHider {

	public void hideTaskbar() {
		JFrame Taskbarhider = new JFrame("");
		Taskbarhider.setAlwaysOnTop(true);
		Taskbarhider.setUndecorated(true);
		Taskbarhider.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		Taskbarhider.setBackground(new Color(0, 0, 0, 0));
		Taskbarhider.setVisible(true);
	}
	
}
