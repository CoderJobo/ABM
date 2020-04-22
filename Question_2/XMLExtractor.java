
/**
 * This class contains three methods: 
 * 
 * 1. Default constructor ExtractXML()
 * 2. Parameterized constructor ExtractXML(String fileName, String tagName, String itemName, String[] items)
 * 3. Method extractValues(String fileName, String tagName, String itemName, String[] items)
 * 4. Method printValues()
 * 
 * When an instance of the class is created, it takes in an XML file as well as the name of a tag, the name
 * of an item in the tag and an array of string values. These are passed to the 
 * extractValues(String fileName, String tagName, String itemName, String[] items) method and the contents of 
 * the XML file are parsed and placed into a document file. The values of the input items are extracted and 
 * stored in a private String array called 'values'. 
 * The method printValues() prints out the contents of 'values'.
 * 
 * @author Joan Hickey 
 * @version 17/04/2020
 */

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class XMLExtractor
{
    private static String[] values; 

    public XMLExtractor(){
    }

    public XMLExtractor(String fileName, String tagName, String itemName, String[] items) throws Exception{
        values = new String[items.length];
        values = extractValues(fileName, tagName, itemName, items);
    }

    public static String[] extractValues(String fileName, String tagName, String itemName, String[] items)throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));
        
        NodeList tagNames = doc.getElementsByTagName(tagName);
        for(int i = 0; i < items.length; i++){
            for(int j = 0; j < tagNames.getLength(); j++){
                Node n = tagNames.item(j);
                String code = n.getAttributes().getNamedItem(itemName).getNodeValue();
                if(code.equals(items[i])){
                    String value = n.getChildNodes().item(1).getTextContent();
                    values[i] = value;
                }
            }
        }
        return values;
    }
    
    public void printValues(){
        System.out.println("Printing values...");
        for(int i = 0; i < values.length; i++){
            System.out.println(values[i]);
        }
        System.out.println("End");
        System.out.println();
    }
}
