package me.buffsee.bhh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	public static void main(String[] args) {

		JFrame asktwo = new JFrame("1v1 or 2v2?");
		JLabel label = new JLabel("1v1 or 2v2?");
		label.setLocation(60, 0);
		label.setSize(200, 20);
		JButton one = new JButton("1v1");
		one.setLocation(30, 30);
		one.setSize(54, 20);
		one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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
			}
			
		});
		JButton two = new JButton("2v2");
		two.setLocation(100, 30);
		two.setSize(54, 20);
		two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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
			}
			
		});
		asktwo.setLayout(null);
		asktwo.add(one);
		asktwo.add(two);
		asktwo.add(label);
		asktwo.setSize(200, 100);
		asktwo.setLocationRelativeTo(null);
		asktwo.setVisible(true);

		
		TaskbarHider taskbarhider = new TaskbarHider();
		taskbarhider.hideTaskbar();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
