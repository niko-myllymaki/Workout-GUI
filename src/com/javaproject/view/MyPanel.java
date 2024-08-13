package com.javaproject.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyPanel extends JPanel{
	
	private static final int HEIGHT_PANEL = 200;
	private static final int WIDTH_PANEL = 485;
	
	MyTextArea textArea;
	
	MyPanel() {
	
		textArea = new MyTextArea();

		this.setBackground(Color.GRAY);
		this.setBounds(0, 300, WIDTH_PANEL, HEIGHT_PANEL);
		textArea.setBackground(getBackground().brighter());

		this.add(textArea);
	}

}
