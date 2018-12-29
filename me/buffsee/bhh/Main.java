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
		
		JFrame BHHMainFrame = new JFrame("BHH v2");
		
		
		BHH bhhthread = new BHH();
		bhhthread.start();
		
		TaskbarHider taskbarhider = new TaskbarHider();
		taskbarhider.hideTaskbar();
		
		
		JCheckBox BHHCheckBox = new JCheckBox();
		BHHCheckBox.setLocation(50, 0);
		BHHCheckBox.setSize(18, 18);
		BHHCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bhhthread.bhh.isVisible()) {
					bhhthread.hideWindow();
					//bhhthread.startExplorer();
				} else {
					bhhthread.showWindow();
					//bhhthread.stopExplorer();
				}
			}
		});
	
		
		JTextArea BHHText = new JTextArea("BHH 1v1:");
		BHHText.setLocation(0, 0);
		BHHText.setSize(25, 16);
		
		JTextArea BHHText2s = new JTextArea("2v2:");
		BHHText2s.setLocation(75, 0);
		BHHText2s.setSize(25, 16);
		

		BHHMainFrame.add(BHHCheckBox);
		BHHMainFrame.add(BHHText2s);
		BHHMainFrame.add(BHHText);

		BHHMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BHHMainFrame.addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	if(bhhthread.bhh.isVisible()) {
		    		//bhhthread.startExplorer();
		    	}
		    }
		});
		BHHMainFrame.setVisible(true);
		BHHMainFrame.setSize(300, 500);
	}

}
