package com.javaproject.xmlHandler;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.javaproject.entity.Workout;

public class Append {
	
	public static void appendDocuments(Workout workoutToList) {
		Document mainDocument = Reader.readXml();
		Document tempDocument = Builder.buildDocument(workoutToList);
		
		try {
			NodeList mainList = mainDocument.getElementsByTagName("workout");
			NodeList tempList = tempDocument.getElementsByTagName("workout");
			
			int amountOfNodes = mainList.getLength();
			
			//Append nodes from tempDocument to mainDocument
			for(int i = 0; i < mainList.getLength(); i++) {
				//Get main nodes
				Node mainDocumentNodes = mainList.item(i);
				
				for(int j = 0; j < tempList.getLength(); j++) {
					
					//Get temporary nodes
					Node tempDocumentNodes = tempList.item(j);
					
					//Import nodes from temporary document to main document
					Node imp = mainDocument.importNode(tempDocumentNodes, true);
					mainDocumentNodes.getParentNode().appendChild(imp);
				}
			
				//break when function has gone through all nodes
				if(mainList.getLength() >= amountOfNodes + tempList.getLength()) {
					break;
				}
				
			}
			
			//write out the modified document to a new file
			TransformerFactory tFactory = TransformerFactory.newInstance(); 
			Transformer transformer = null;
			
			
				transformer = tFactory.newTransformer();
			
			
			Source source = new DOMSource(mainDocument);
			Result output = new StreamResult("D:/Java_2024/RecapForJava/WriteToFileGUI/output.xml");
			
			
			transformer.transform(source, output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

}
