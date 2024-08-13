package com.javaproject.view;

import java.awt.Font;

import javax.swing.JTextArea;

public class MyTextArea extends JTextArea {

	MyTextArea() {
		this.setText("TESTING!!!");
		this.setRows(10);
		this.setColumns(44);
		//this.setFont(new Font("", Font.PLAIN, 16));
		this.setLineWrap(true);
		this.setEditable(false);	
	}
	
}
