package com.javaproject.view;

import java.awt.Color;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	private static final int HEIGHT_PANEL = 200;
	private static final int WIDTH_PANEL = 485;
	
	MyTextArea textArea;
	
	MyPanel() {
	
		this.setBackground(Color.GRAY);
		this.setBounds(0, 300, WIDTH_PANEL, HEIGHT_PANEL);
		
		textArea = new MyTextArea();
		textArea.setBackground(getBackground().brighter());
		
		//This panel contains the text area 
		//where workout log will be shown to the user
		this.add(textArea);
	}

}
