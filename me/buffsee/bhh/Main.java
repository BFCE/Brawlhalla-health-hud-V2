package me.buffsee.bhh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class Main {
	
	public static void main(String[] args) {
		// might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails 
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // use false here to switch to hook instead of raw input

		System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");
		for(Entry<Long,String> keyboard:GlobalKeyboardHook.listKeyboards().entrySet())
			System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());
		
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override public void keyPressed(GlobalKeyEvent event) {
				if(event.getVirtualKeyCode()==GlobalKeyEvent.VK_F2) {
					System.exit(0);
				}

			}
		});
		
		
		JFrame asktwo = new JFrame("1v1 or 2v2?");
		asktwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("1v1 or 2v2?");
		label.setLocation(60, 0);
		label.setSize(200, 20);
		JCheckBox smash = new JCheckBox();
		smash.setLocation(120, 53);
		smash.setSize(25, 25);
		JLabel smashlabel = new JLabel("Smash mode:");
		smashlabel.setLocation(30, 54);
		smashlabel.setSize(200, 20);
		JButton one = new JButton("1v1");
		one.setLocation(30, 30);
		one.setSize(54, 20);
		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(smash.isSelected()) {
					Smash smash = new Smash();
					smash.setTwos(false);
					smash.run();
					asktwo.setVisible(false);
				} else {
					BHH bhhthread = new BHH();
					bhhthread.setTwos(false);
					bhhthread.start();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bhhthread.showWindow();
					asktwo.setVisible(false);
				}
			}
			
		});
		JButton two = new JButton("2v2");
		two.setLocation(100, 30);
		two.setSize(54, 20);
		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(smash.isSelected()) {
					Smash smash = new Smash();
					smash.setTwos(true);
					smash.start(); //TODO: Replace these with run();
					asktwo.setVisible(false);
				} else {
					BHH bhhthread = new BHH();
					bhhthread.setTwos(true);
					bhhthread.start();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					bhhthread.showWindow();
					asktwo.setVisible(false);
			}
			}
		});
		asktwo.setLayout(null);
		asktwo.add(smashlabel);
		asktwo.add(smash);
		asktwo.add(one);
		asktwo.add(two);
		asktwo.add(label);
		asktwo.setSize(200, 120);
		asktwo.setLocationRelativeTo(null);
		asktwo.setVisible(true);

		
		TaskbarHider taskbarhider = new TaskbarHider();
		taskbarhider.hideTaskbar();
	}

}
