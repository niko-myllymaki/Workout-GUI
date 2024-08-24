package com.javaproject.view;

import javax.swing.JTextArea;

public class MyTextArea extends JTextArea {

	//This is the component where all the the workout logs will be shown
	MyTextArea() {
		this.setRows(10);
		this.setColumns(44);
		this.setLineWrap(true);
		this.setEditable(false);	
	}
	
}
