package com.javaproject.xmlHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.javaproject.entity.Workout;

public class Builder {
	
	//Create a new document and add workout to it
	public static Document buildDocument(Workout workoutToList) {
		// Create a DocumentBuilder 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
        DocumentBuilder builder = null;
        Document document = null;
        
		try {
			builder = factory.newDocumentBuilder();
			 
	        // Create a new Document 
	        document = builder.newDocument(); 
	        
	        // Create root element 
	        Element root = document.createElement("workouts"); 
	        document.appendChild(root); 
	        
	        Element workoutElement = document.createElement("workout");
	        	
	        Element dateElement = document.createElement("date");
	        dateElement.appendChild(document.createTextNode(workoutToList.getDate()));
	        	
	        Element typeElement = document.createElement("type");
	        typeElement.appendChild(document.createTextNode(workoutToList.getType()));
	        	
	        Element exercisesElement = document.createElement("exercises");
	        exercisesElement.appendChild(document.createTextNode(workoutToList.getExercises().toString()));
	        	
	        root.appendChild(workoutElement);
	        workoutElement.appendChild(dateElement);
	        workoutElement.appendChild(typeElement);
	        workoutElement.appendChild(exercisesElement);
		} catch (Exception e) {
			System.out.println(e);
		}
        
        return document;
	}
	
	

}
