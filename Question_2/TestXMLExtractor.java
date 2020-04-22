/**
 * This class creates an instance of the class ExtractXML and checks first the values for 
 * RefCodes MWB, TRV and CAR in that order and prints them out. Then it checks the values
 * for RefCodes UCR, HWB, CAS, SRC, COM and KEY in that order and prints them out.
 *
 * @author  Joan Hickey
 * @version 17/04/2020
 */

public class TestXMLExtractor
{
    public TestXMLExtractor()
    {
    }
    
    public static void main (String[] args) throws Exception{
        String fileName = "document.xml", tagName = "Reference", itemName = "RefCode";
        String item1 = "MWB", item2 = "TRV", item3 = "CAR";
        String[] items = new String[]{item1, item2, item3};
        
        XMLExtractor extract = new XMLExtractor(fileName, tagName, itemName, items);
        extract.printValues();
        
        System.out.println("Now check the rest of the RefCodes working backwards....");
        String item4 = "KEY", item5 = "COM", item6 = "SRC", item7 = "CAS", item8 = "HWB", item9 = "UCR";
        String[] remainingItems = new String[]{item9, item8, item7, item6, item5, item4};
        
        XMLExtractor extractRemaining = new XMLExtractor(fileName, tagName, itemName, remainingItems);
        extractRemaining.printValues();
    }
}
