package com.javaproject.xmlHandler;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.javaproject.entity.Workout;


public class XmlWriter {

	public static void writeToXml(Workout workoutToList) {
	
		Document document = Builder.buildDocument(workoutToList);
		
	    TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
	    Transformer transformer = null;
	    try {
	    	transformer = transformerFactory.newTransformer();
		    DOMSource source = new DOMSource(document); 
		  
		    // Specify your local file path 
		    StreamResult result = new StreamResult("D:/Java_2024/RecapForJava/WriteToFileGUI/output.xml"); 
	    	transformer.transform(source, result);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
	  
	}
}
