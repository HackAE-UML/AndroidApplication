package com.example.spal.generation2you;

import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.logging.Logger;

/**
 * Created by spal on 11/5/16.
 */
public class ProfileYoung {
    private String mName;
    private int mAge;
    private Location location;
    private List<ProfileSenior> matches;

    /** Setters */
    public void setName(String name) {
        mName = name;
    }
    public void setAge(int age) {
        mAge = age;
    }
    public void setLocation(String street, String city, String state) {
        location = new Location(street, city, state);
    }
    public void addMatch(ProfileSenior profile) {
        matches.add(profile);
    }

    /** Getters */
    public String getName() {
        return mName;
    }
    public int getAge() {
        return mAge;
    }
    public Location getLocation() {
        return location;
    }
    public List<ProfileSenior> getMatches() {
        return matches;
    }

    /**
     * Check to see if a certain profile is a match with current Volunteer Profile
     * @param profile The profile object of the senior
     * @return true if match exists
     */
    public boolean checkProfileMatch(ProfileSenior profile) {
        return matches.contains(profile);
    }

    /**
     * DOM Parser - Create XML Document
     */
    public class createXMLFile
    {
        public void main(String[] args) {

            try {

                String temp_street = location.getStreet();
                String temp_city = location.getCity();
                String temp_state = location.getState();
                List<ProfileSenior> temp_matches = getMatches();
                String id = "";

                for(ProfileSenior matches:temp_matches)
                {
                    id = matches.getName();
                }


                DocumentBuilderFactory dbFactory =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder =
                        dbFactory.newDocumentBuilder();
                Document doc = dBuilder.newDocument();
                // root element
                Element rootElement = doc.createElement("volunteer");
                doc.appendChild(rootElement);

                // name element
                Element name = doc.createElement("name");
                name.appendChild(
                        doc.createTextNode(mName));
                name.appendChild(name);

                // age element
                Element age = doc.createElement("age");
                age.appendChild(
                        doc.createTextNode(String.valueOf(mAge)));
                age.appendChild(age);

                // location element
                Element location = doc.createElement("location");
                location.appendChild(location);

                //street element
                Element street = doc.createElement("street");
                street.appendChild(doc.createTextNode(temp_street));
                location.appendChild(street);

                //city element
                Element city = doc.createElement("city");
                city.appendChild(doc.createTextNode(temp_city));
                location.appendChild(city);

                //state element
                Element state = doc.createElement("state");
                state.appendChild(doc.createTextNode(temp_state));
                location.appendChild(state);

                // matches element
                Element matches = doc.createElement("matches");
                matches.appendChild(
                        doc.createTextNode(id));
                matches.appendChild(matches);


                // write the content into xml file
                TransformerFactory transformerFactory =
                        TransformerFactory.newInstance();
                Transformer transformer =
                        transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result =
                        new StreamResult(new File("young_profile.xml"));
                transformer.transform(source, result);
                // Output to console for testing
                StreamResult consoleResult =
                        new StreamResult(System.out);
                transformer.transform(source, consoleResult);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

