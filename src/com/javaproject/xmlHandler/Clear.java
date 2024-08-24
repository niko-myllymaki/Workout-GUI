package com.javaproject.xmlHandler;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Clear {
	
	private static final String FILE_PATH = "Files/output.xml";

	public static void clearXmlFile() {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
	    DocumentBuilder builder = null;
	     
	 	try {
			builder = factory.newDocumentBuilder();
		
			// Create a new Document 
	        Document document = builder.newDocument(); 
	       
	        // Write to XML file 
	        TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
	        Transformer transformer = null;
			
			transformer = transformerFactory.newTransformer();
			
			
	        DOMSource source = new DOMSource(document); 
	 
	        // Specify your local file path 
	        StreamResult result = new StreamResult(FILE_PATH); 
	       
			transformer.transform(source, result);
	 	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteFile() {
		File fileToDelete = new File(FILE_PATH); 
		fileToDelete.delete();

	}
}
