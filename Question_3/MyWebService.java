
/**
 * This class contains two methods:
 * 
 * 1. Default constructor MyWebService()
 * 2. Method parseXML(String filename)
 * 
 * When an instance of MyWebService is created, the parseXML(String filename) can be 
 * used to determine the status of the input XML file:
 * 
 * 0 if the XML file was structured correctly
 * -1 if an invalid Command was specified
 * -2 if an invalid Site was specified
 * 
 * @author Joan Hickey 
 * @version 20/04/2020
 */

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;

public class MyWebService
{
    public MyWebService(){
    }
    
    public int parseXML(String filename) throws Exception{
        int status = 0;
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filename));

        Node declaration = doc.getElementsByTagName("Declaration").item(0);
        String commandValue = declaration.getAttributes().getNamedItem("Command").getNodeValue();
        String siteID = doc.getElementsByTagName("SiteID").item(0).getTextContent();
        if(!commandValue.equals("DEFAULT")){
            status = -1;
        }
        else if (!siteID.equals("DUB")){
            status = -2;
        }
        return status;
    }
}