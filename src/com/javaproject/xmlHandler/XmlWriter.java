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
	
	private static final String FILE_PATH = "Files/output.xml";

	//Create the actual xml-file
	public static void writeToXml(Workout workoutToList) {
	
		//Contents of document object will be added to the xml-file
		Document document = Builder.buildDocument(workoutToList);
		
	    TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
	    Transformer transformer = null;
	    try {
	    	transformer = transformerFactory.newTransformer();
		    DOMSource source = new DOMSource(document); 
		  
		    // Specify your local file path 
		    StreamResult result = new StreamResult(FILE_PATH); 
	    	transformer.transform(source, result);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
	  
	}
}
