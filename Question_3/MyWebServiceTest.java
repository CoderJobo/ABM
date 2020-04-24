import org.junit.Assert;
import org.junit.Test;

public class MyWebServiceTest {

	@Test
	public void returnsCorrectStatus() throws Exception{
		MyWebService myWS = new MyWebService();
		
		String filename = "document.xml";
        String fileInvalidComand = "documentInvalidCommand.xml";
        String fileInvalidSite = "documentInvalidSite.xml";
        
        int fileStatus = myWS.parseXML(filename);
        int fileInvalidCommandStatus = myWS.parseXML(fileInvalidComand);
        int fileInvalidSiteStatus = myWS.parseXML(fileInvalidSite);
        
        Assert.assertEquals(0, fileStatus);
        Assert.assertEquals(-1, fileInvalidCommandStatus);
        Assert.assertEquals(-2, fileInvalidSiteStatus);
	}

}