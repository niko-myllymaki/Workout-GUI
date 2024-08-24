package com.javaproject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.javaproject.entity.Exercise;
import com.javaproject.entity.Workout;
import com.javaproject.xmlHandler.Append;
import com.javaproject.xmlHandler.Clear;
import com.javaproject.xmlHandler.Reader;
import com.javaproject.xmlHandler.XmlWriter;

public class MyFrame extends JFrame implements ActionListener{
	
	private static final int HEIGHT_FRAME = 500;
	private static final int WIDTH_FRAME = 500;
	private static final String FILE_PATH = "Files/output.xml";
	
	JButton addButton, submitButton, readButton, clearButton;
	JTextField exerciseTextField, setsTextField, repetitionsTextField, weightTextField, dateTextField;
	JLabel exerciseLabel, setsLabel, repetitionsLabel, weightLabel;
	JRadioButton pushDayButton, pullDayButton, legDayButton;
	ButtonGroup radioButtonGroup;
	
	String radioButtonPressed = "";
	Exercise exercise;
	ArrayList<Exercise> exercises;

	Workout workout;
	String date;

	MyPanel textPanel;
	MyTextArea textArea;
	String errorMessage = "Not all fields are filled";
	
	public MyFrame() {
		this.setTitle("Workout Log");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH_FRAME, HEIGHT_FRAME);
		this.setBackground(Color.green);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);

		//Radio Buttons
		pushDayButton = new JRadioButton("Push");
		pushDayButton.setBounds(25, 5, 60, 20);
		pushDayButton.setFocusable(false);
		pushDayButton.addActionListener(this);
		
		pullDayButton = new JRadioButton("Pull");
		pullDayButton.setBounds(pushDayButton.getX() + 60 , pushDayButton.getY(), pushDayButton.getWidth(), pushDayButton.getHeight());
		pullDayButton.setFocusable(false);
		pullDayButton.addActionListener(this);

		legDayButton = new JRadioButton("Leg");
		legDayButton.setBounds(pullDayButton.getX() + 60, pushDayButton.getY(), pushDayButton.getWidth(), pushDayButton.getHeight());
		legDayButton.setFocusable(false);
		legDayButton.addActionListener(this);

		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(pushDayButton);
		radioButtonGroup.add(pullDayButton);
		radioButtonGroup.add(legDayButton);
	
		//Buttons
		addButton = new JButton("Add");
		addButton.setBounds(25, 55, 100, 50);
		addButton.addActionListener(this);
		addButton.setFocusable(false);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(addButton.getX(), addButton.getY() + 60, 100, 50);
		submitButton.addActionListener(this);
		submitButton.setFocusable(false);
		
		readButton = new JButton("Read");
		readButton.setBounds(addButton.getX(), submitButton.getY() + 60, addButton.getWidth(), addButton.getHeight());
		readButton.addActionListener(this);
		readButton.setFocusable(false);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(addButton.getX(), readButton.getY() + 60, addButton.getWidth(), addButton.getHeight());
		clearButton.addActionListener(this);
		clearButton.setFocusable(false);
		
		//Labels
		exerciseLabel = new JLabel("Exercise");
		exerciseLabel.setBounds(150, 35, 60, 20);
		exerciseLabel.setOpaque(true);
		
		weightLabel = new JLabel("Weight");
		weightLabel.setBounds(exerciseLabel.getX() + 140, exerciseLabel.getY(), 60, 20);
		weightLabel.setOpaque(true);
		
		setsLabel = new JLabel("Sets");
		setsLabel.setBounds(weightLabel.getX() + 50, exerciseLabel.getY(), 40, 20);
		setsLabel.setOpaque(true);
		
		repetitionsLabel = new JLabel("Repetitions");
		repetitionsLabel.setBounds(setsLabel.getX() + 50, exerciseLabel.getY(), 70, 20);
		repetitionsLabel.setOpaque(true);
		
		//Text Fields
		exerciseTextField = new JTextField();
		exerciseTextField.setBounds(150, 55, 130, 40);
		exerciseTextField.setFont(new Font("", Font.PLAIN, 16));
		
		weightTextField = new JTextField();
		weightTextField.setBounds(290, 55, 30, 40);
		weightTextField.setFont(new Font("", Font.PLAIN, 16));
		
		setsTextField = new JTextField();
		setsTextField.setBounds(340, 55, 30, 40);
		setsTextField.setFont(new Font("", Font.PLAIN, 16));
		
		repetitionsTextField = new JTextField();
		repetitionsTextField.setBounds(390, 55, 30, 40);
		repetitionsTextField.setFont(new Font("", Font.PLAIN, 16));
		
		dateTextField = new JTextField("dd-MM-yyyy");
		dateTextField.setBounds(legDayButton.getX() + 100, pushDayButton.getY(), 85, 30);
		dateTextField.setFont(new Font("", Font.PLAIN, 14));
		
		exercises = new ArrayList<>();
		textPanel = new MyPanel();

		this.add(pushDayButton);
		this.add(pullDayButton);
		this.add(legDayButton);
		this.add(textPanel);
		this.add(addButton);
		this.add(submitButton);
		this.add(readButton);
		this.add(clearButton);
		this.add(exerciseTextField);
		this.add(setsTextField);
		this.add(repetitionsTextField);
		this.add(weightTextField);
		this.add(dateTextField);
		this.add(exerciseLabel);
		this.add(setsLabel);
		this.add(repetitionsLabel);
		this.add(weightLabel);

		this.setVisible(true); //Make this visible
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
			case "Add":
				if(exerciseTextField.getText().equals("") || weightTextField.getText().equals("") || setsTextField.getText().equals("") || repetitionsTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, errorMessage, "Empty Fields", JOptionPane.ERROR_MESSAGE);
					break;
				}	
			
				exercise = new Exercise(exerciseTextField.getText(), Double.parseDouble(weightTextField.getText()), Integer.parseInt(setsTextField.getText()), Integer.parseInt(repetitionsTextField.getText()));
				exercises.add(exercise);
							
				exerciseTextField.setText("");
				weightTextField.setText("");
				setsTextField.setText("");
				repetitionsTextField.setText("");
				
				break;
			case "Submit":
				if(radioButtonPressed.equals("") || exercises.isEmpty() || dateTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, errorMessage, "Empty Fields", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				//Validate date
				date = dateTextField.getText();
			
				if(!DateHandler.dateValidator(date)) {
					JOptionPane.showMessageDialog(null, "Date isn't valid. dd-MM-yyyy e.g 06-12-2024", "Date Validator", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				//This workout object will be added to the XML file
				workout = new Workout(date, radioButtonPressed, exercises);
				
				//Calling XMLHandler
				File xmlFile = new File(FILE_PATH); 
				if(!xmlFile.exists()) {
					XmlWriter.writeToXml(workout);
				}
				else {
					Append.appendDocuments(workout);
				}
				
				radioButtonGroup.clearSelection();
				
				//Creating a new exercises list for new workouts
				exercises = new ArrayList<>();
				
				exerciseTextField.setText("");
				weightTextField.setText("");
				setsTextField.setText("");
				repetitionsTextField.setText("");
				dateTextField.setText("");
				break;
			case "Read":
				textPanel.textArea.setText(Reader.getTextFromDocument());
				break;
			case "Clear":
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the file?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(option == 0) {
					Clear.deleteFile();
				}
				else {
					break;
				}
				
				break;
			case "Push":
			case "Pull":
			case "Leg":
				radioButtonPressed = e.getActionCommand();
				break;
		}
	}
	
}
