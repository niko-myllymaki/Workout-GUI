package com.javaproject.xmlHandler;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Reader {
	
	public static Document readXml() {
		Document document = null;
		try  {
			File xmlFile = new File("D:/Java_2024/RecapForJava/WriteToFileGUI/output.xml"); 
			
	        // Create a DocumentBuilder 
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
	        DocumentBuilder builder = null;
			
			builder = factory.newDocumentBuilder();
			
	        // Parse the XML file 
			document = builder.parse(xmlFile);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
  
		return document;
	}
	
	public static String getTextFromDocument() {
		String contents = "";
		try {
			File file = new File("D:/Java_2024/RecapForJava/WriteToFileGUI/output.xml"); 
			
			if(!file.exists()) {
				JOptionPane.showMessageDialog(null, "File Not Found", "File Not Found", JOptionPane.ERROR_MESSAGE);
			}
			else {
        
			 
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
	        
				// Creating an object of builder to parse the  xml file. 
		        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				
				Document document = documentBuilder.parse(file);
			
		        document.getDocumentElement().normalize(); 
		        
		        // NodeList that contains all the nodes with the name workout. 
		        NodeList nodeList = document.getElementsByTagName("workout");
		        
		        for (int i = 0; i < nodeList.getLength(); ++i) {
		        	Node node = nodeList.item(i);
		        	
		        	if (node.getNodeType() == Node.ELEMENT_NODE ) {
		        		Element element = (Element)node;
		        		String date = element.getElementsByTagName("date").item(0).getTextContent();
		        		String type = element.getElementsByTagName("type").item(0).getTextContent();
		        		String exercises = element.getElementsByTagName("exercises").item(0).getTextContent();
		        		contents += date + " " + type + " " + exercises + "\n";
		        	}
		        }
			}
		  } catch (Exception e) {
			  System.out.println(e);
		  }
	  return contents;
	}
	  

}
