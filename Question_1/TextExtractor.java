/**
 * This class contains five methods:
 * 
 * 1. Default constructor TextExtractor()
 * 2. Parameterized constructor TextExtractor(String filename)
 * 3. Method extractElements(String filename)
 * 4. Method getElements()
 * 5. Method printElements()
 * 
 * When an instance of the class is created it takes a file in as a String parameter and passes it to 
 * the extractElements(String filename) method which then parses the file for lines beginning with 'LOC',
 * extracts the second and third element of each of those lines and places them into an array which is 
 * stored in a private variable called 'elements'. 
 * The method getElements() returns 'elements' as a Vector of String arrays
 * The method printElements() prints out the contents of 'elements'
 * 
 * @author (Joan Hickey) 
 * @version (16/04/2020)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Vector;

public class TextExtractor
{
    private static Vector<String[]> elements = new Vector<String[]>();
    
    public TextExtractor(){
    }
    
    public TextExtractor(String fileName){
        elements = extractElements(fileName);
    }
    
    public static Vector<String[]> extractElements(String fileName){
        BufferedReader reader; 
        try{
            reader = new BufferedReader(new FileReader("MessageText.txt"));
            String line = reader.readLine();
            while (line != null){
                if(line.substring(0, 3).equals("LOC")){
                    String lineElements = line.substring(4, line.length());                     
                    String[] separateElements = lineElements.split("\\+");
                    elements.add(separateElements);
                }
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return elements;
    }
    
    public Vector<String[]> getElements(){
    	return elements;
    }
    
    public void printElements(){
        System.out.println("Printing elements...");
        for (int i = 0; i < elements.size(); i++){
            String[] row = elements.get(i);
            for (int j = 0; j <= row.length-1; j++){
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
        System.out.println("End");
        System.out.println();
    }
}
