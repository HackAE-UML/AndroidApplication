package com.example.spal.generation2you;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
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
//		System.out.println("TestBegin");
		
//		try{
//			InputStream is = new FileInputStream("SeniorProfile1.xml");
//			ProfileSenior p = XMLToSenior(is);
//
//			System.out.println( p.getName());
//		}
//		catch(FileNotFoundException e){
//			System.out.println(e.getMessage());
//		}
		
	}

	public static ProfileSenior XMLToSenior(InputStream stream) throws Exception {
		ProfileSenior senior = new ProfileSenior();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
	         // use the factory to create a documentbuilder
	         DocumentBuilder builder = factory.newDocumentBuilder();

	         Document doc = builder.parse(stream);

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

                        // get ID
                        String id = el.getElementsByTagName("id").item(0).getTextContent();
                        senior.setID(Integer.parseInt(id));

                        // get Gender
                        String gender = el.getElementsByTagName("gender").item(0).getTextContent();
                        senior.setGender(gender);

                        //retrieves all address fields and packages into a location
                        String street = el.getElementsByTagName("street").item(0).getTextContent();
                        String city = el.getElementsByTagName("city").item(0).getTextContent();
                        String state = el.getElementsByTagName("state").item(0).getTextContent();
                        senior.setLocation(street, city, state);
	        		}

                    if (el.getNodeName().contains("activities")) {
                        //adds all the  likes one at a time
                        NodeList likes = el.getElementsByTagName("like");
                        if (likes.getLength() > 0) {
                            for (int j = 0; j < likes.getLength(); j++) {
                                senior.addLike(likes.item(j).getTextContent());
                            }
                        }
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
             // No data found
             return null;
	      }
		
		return senior;
	}

	/*
	* May be redundant. Kept during merge to minimize breaks because time constraint
	*/
    public static ProfileYoung XMLToVolunteer(InputStream stream) throws Exception {
        ProfileYoung volunteer = new ProfileYoung();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to create a documentbuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(stream);

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
                        volunteer.setName( el.getElementsByTagName("first-name").item(0).getTextContent() + " " +
                                el.getElementsByTagName("last-name").item(0).getTextContent());

                        //get the birthyear which is the first - delimeted part of the dob string
                        String birthDate = el.getElementsByTagName("dob").item(0).getTextContent();
                        birthDate = birthDate.split("-")[0];
                        int birthYear = Integer.parseInt(birthDate);
                        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                        volunteer.setAge(currentYear - birthYear);

                        //retrieves all address fields and packages into a location
                        String street = el.getElementsByTagName("street").item(0).getTextContent();
                        String city = el.getElementsByTagName("city").item(0).getTextContent();
                        String state = el.getElementsByTagName("state").item(0).getTextContent();
                        volunteer.setLocation(street, city, state);

                        // get ID
                        int id = Integer.parseInt(el.getElementsByTagName("id").item(0).getTextContent());
                        volunteer.setId(id);
                    }

                    if (el.getNodeName().contains("activities")) {
                        //adds all the  likes one at a time
                        NodeList likes = el.getElementsByTagName("like");
                        if (likes.getLength() > 0) {
                            for (int j = 0; j < likes.getLength(); j++) {
                                volunteer.addLike(likes.item(j).getTextContent());
                            }
                        }
                    }

                    //Can't directly figure out matched id of the young profile from info given in xml
                    if( el.getNodeName().contains("matched")) {
                        ProfileSenior y = new ProfileSenior();
                        y.setLocation(
                                " ",
                                " ",
                                el.getElementsByTagName("matched-location").item(0).getTextContent());
                        volunteer.addMatch(y);
                    }
                }
            }
        } catch (Exception ex) {
            // No data found
            return null;
        }

        return volunteer;
    }
}