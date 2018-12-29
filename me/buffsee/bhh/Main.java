package me.buffsee.bhh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Main {

	public static void main(String[] args) {
		BHH bhhthread = new BHH();
		bhhthread.start();
		
		TaskbarHider taskbarhider = new TaskbarHider();
		taskbarhider.hideTaskbar();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bhhthread.showWindow();
	}

}
