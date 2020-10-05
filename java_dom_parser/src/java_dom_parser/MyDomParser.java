package java_dom_parser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyDomParser {

	public static void main(String[] args) {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder builder = factory.newDocumentBuilder(); //Allows to parse XML File in a DOM approach
		Document doc = builder.parse("people.xml");
		System.out.println("Root Element: " +doc.getDocumentElement().getNodeName()); // Read the root element
		NodeList personList = doc.getElementsByTagName("person"); //Read the array of person elements, this is called NodeList
		
		for(int i=0; i<personList.getLength();i++) { //traversing the whole list
			Node p=personList.item(i); //
			System.out.println("Node name: " +p.getNodeName() + " " + (i+1)); //Read the nodes
			//System.out.println("Person List:" +i); // List of persons with their indexes
			if(p.getNodeType()==Node.ELEMENT_NODE) { //Read the person data
				Element person = (Element) p;
				String id = person.getAttribute("id");
				NodeList nameList = person.getChildNodes();
				for (int j=0; j<nameList.getLength(); j++) {
					Node n = nameList.item(j);
					if(n.getNodeType()==Node.ELEMENT_NODE) {
						Element name = (Element) n;
						System.out.println("Person " + id + ":" +
						name.getTagName() + "=" + name.getTextContent());
					}
				}
			}
		}
			
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}

}
