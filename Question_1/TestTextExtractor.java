/**
 * This class tests the class ParseText by creating an instance of the class and passing it an input
 * String filename. It then calls the printElements() method to print out the elements extracted 
 * from the file.
 *
 * @author  Joan Hickey
 * @version 16/04/2020
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Vector;

public class TestTextExtractor
{
    public TestTextExtractor()
    {
    }
   
    public static void main (String[] args){
        String fileName = "MessageText.txt";
        TextExtractor edifactMessageText = new TextExtractor(fileName);
        edifactMessageText.printElements();
    }   
}
