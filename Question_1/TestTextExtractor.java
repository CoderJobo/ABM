/**
 * This class tests the class TextExtractor by creating an instance of the class and passing it an input
 * String filename. It then calls the printElements() method to print out the elements extracted 
 * from the file.
 *
 * @author  Joan Hickey
 * @version 16/04/2020
 */

public class TestTextExtractor
{
    public TestTextExtractor(){
    }
   
    public static void main (String[] args){
    	
        String fileName = "MessageText.txt";
        
        // Test extractElements(String filename) method
        TextExtractor messageText = new TextExtractor(fileName);
        
        // Test getElements() method
        System.out.print("There are " + messageText.getElements().size() + " LOC segments ");
        System.out.println("each containing " + messageText.getElements().get(0).length + " elements\n");
        
        // Test printElements() method
        messageText.printElements();
    }   
}
