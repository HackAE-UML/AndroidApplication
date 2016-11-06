package com.example.spal.generation2you;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser {
	
	/*
	 * For test
	 */
	public static void main(String[] args){
		System.out.println("TestBegin");
		
		try{
			InputStream is = new FileInputStream("SeniorProfile1.xml");
			ProfileSenior p = XMLToSenior(is);
			
			System.out.println( p.getName());
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
	}
	/*XMLToSenior()
	 * 
	 * @param is
	 * 	Inputstream object containing an XML file from the S3 Server
	 * 
	 * @return
	 * 	ProfileSenior object created from the data within the input XML file
	 */
	public static ProfileSenior XMLToSenior(InputStream is)
	{
		ProfileSenior senior = new ProfileSenior();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
	         // use the factory to create a documentbuilder
	         DocumentBuilder builder = factory.newDocumentBuilder();

	         Document doc = builder.parse(is);

	         // get the first element
	         Element element = doc.getDocumentElement();

	         // get all child nodes
	         NodeList nodes = element.getChildNodes();

	         // print the text content of each child
	         for (int i = 0; i < nodes.getLength(); i++) {
	        	if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE)
	        	{
	        		Element el = (Element) nodes.item(i);
	        		
	        		if( el.getNodeName().contains("personal-info")){
	        			
	        			//concat first and last names
	        			senior.setName( el.getElementsByTagName("first-name").item(0).getTextContent() + " " +
	        							el.getElementsByTagName("last-name").item(0).getTextContent());
	        			
	        			//get the birthyear which is the first - delimeted part of the dob string
	        			String birthDate = el.getElementsByTagName("dob").item(0).getTextContent();
	        			birthDate = birthDate.split("-")[0];
	        			int birthYear = Integer.parseInt(birthDate);
	        			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	        			senior.setAge(currentYear - birthYear);
	        		}
	        		
	        		if( el.getNodeName().contains("address")){
	        			//retrieves all address fields and packages into a location
	        			String street = el.getElementsByTagName("street").item(0).getTextContent();
	        			String city = el.getElementsByTagName("city").item(0).getTextContent();
	        			String state = el.getElementsByTagName("state").item(0).getTextContent();
	        			int zipCode = Integer.parseInt( el.getElementsByTagName("zipcode").item(0).getTextContent());
	        			senior.setLocation(street, city, state);
	        		}
	        		
	        		//adds all the  likes one at a time
	        		if( el.getNodeName().contains("like")){
	        			senior.addLike(el.getTextContent());
	        		}
	        		
	        		//Can't directly figure out matched id of the young profile from info given in xml
	        		if( el.getNodeName().contains("matched")) {
	        			ProfileYoung y = new ProfileYoung();
		        		y.setLocation(
								" ",
								" ",
		        				el.getElementsByTagName("matched-location").item(0).getTextContent());
		        		senior.addMatch(y);
	        		}
	        	}
	         }
	      } catch (Exception ex) {
	    	 //TODO add more graceful error handling
	         ex.printStackTrace();
	      }
		
		return senior;
		
	}
	
	/*XMLToYoung()
	 * 
	 * @param is
	 * 	Inputstream object containing an XML file from the S3 Server
	 * 
	 * @return
	 * 	Profileyoung object created from the data within the input XML file
	 */
	public static ProfileYougn XMLToYoung(InputStream is)
	{
		ProfileYoung young = new ProfileYoung();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
	         // use the factory to create a documentbuilder
	         DocumentBuilder builder = factory.newDocumentBuilder();

	         Document doc = builder.parse(is);

	         // get the first element
	         Element element = doc.getDocumentElement();

	         // get all child nodes
	         NodeList nodes = element.getChildNodes();

	         // parse the text content of each child
	         for (int i = 0; i < nodes.getLength(); i++) {
	        	if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE)
	        	{
	        		Element el = (Element) nodes.item(i);
	        		
	        		if( el.getNodeName().contains("personal-info")){
	        			
	        			//concat first and last names
	        			young.setName( el.getElementsByTagName("first-name").item(0).getTextContent() + " " +
	        							el.getElementsByTagName("last-name").item(0).getTextContent());
	        			
	        			//Retrieve id
	        			young.setId( Integer.parseInt( el.getElementsByTagName("id").item(0).getTextContent()) );
	        			
	        			//get the birthyear which is the first - delimeted part of the dob string
	        			String birthDate = el.getElementsByTagName("dob").item(0).getTextContent();
	        			birthDate = birthDate.split("-")[0];
	        			int birthYear = Integer.parseInt(birthDate);
	        			int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	        			young.setAge(currentYear - birthYear);
	        		}
	        		
	        		if( el.getNodeName().contains("address")){
	        			//retrieves all address fields and packages into a location
	        			String street = el.getElementsByTagName("street").item(0).getTextContent();
	        			String city = el.getElementsByTagName("city").item(0).getTextContent();
	        			String state = el.getElementsByTagName("state").item(0).getTextContent();
	        			young.setLocation(street, city, state);
	        		}
	        		
	        		//Can't directly figure out matched id of the young profile from info given in xml
	        		if( el.getNodeName().contains("matched")) {
	        			ProfileSenior s = new ProfileSenior();
		        		s.setLocation(
								" ",
								" ",
		        				el.getElementsByTagName("matched-location").item(0).getTextContent());
		        		young.addMatch(s);
	        		}
	        	}
	         }
	      } catch (Exception ex) {
	    	 //TODO add more graceful error handling
	         ex.printStackTrace();
	      }
		
		return young;
		
	}
}