
/**
 * Write a description of class TestMyWebService here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestMyWebService
{
    public TestMyWebService(){
    }

    public static void main(String[] args) throws Exception{
        MyWebService myWS = new MyWebService();
        String filename = "document.xml";
        String fileInvalidComand = "documentInvalidCommand.xml";
        String fileInvalidSite = "documentInvalidSite.xml";
        
        int fileStatus = myWS.parseXML(filename);
        System.out.println("The status code is " + fileStatus + "\n");
        
        System.out.println("Check for invalid command...");
        int fileInvalidCommandStatus = myWS.parseXML(fileInvalidComand);
        System.out.println("The status code is " + fileInvalidCommandStatus + "\n");
        
        System.out.println("Check for invalid site...");
        int fileInvalidSiteStatus = myWS.parseXML(fileInvalidSite);
        System.out.println("The status code is " + fileInvalidSiteStatus + "\n");
    }
}