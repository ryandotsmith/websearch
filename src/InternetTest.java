import java.util.ArrayList;

import org.dom4j.DocumentException;
import junit.framework.TestCase;


public class InternetTest extends TestCase {
	public Internet testInternet;
	protected void setUp() throws Exception {
		super.setUp();
		testInternet = new Internet();
	}
	public void testAddPage() throws DocumentException {
		assertEquals(0,testInternet.getCount());
		Page newPage = new Page("test.html");
		testInternet.addPage(newPage);
		assertEquals(1,testInternet.getCount());
	}
	public void testQueryWithPagesThatHaveSameWordCount() throws DocumentException {
		Page pageOne   = new Page("test.html");
		Page pageTwo   = new Page("test.html");
		Page pageThree = new Page("test.html");
		ArrayList arr  = new ArrayList();
		testInternet.addPage(pageOne);
		testInternet.addPage(pageTwo);
		testInternet.addPage(pageThree);
		arr.add(pageOne);
		arr.add(pageTwo);
		arr.add(pageThree);
		assertEquals( arr,testInternet.query("Title") );
	}
	public void testQueryWithPagesThatHaveDifferentWordCounts() throws DocumentException{
		Page pageOne   = new Page("test.html");
		Page pageTwo   = new Page("test.html");
		Page pageThree = new Page("test.html");
		ArrayList arr  = new ArrayList();
		testInternet.addPage(pageOne);
		testInternet.addPage(pageTwo);
		testInternet.addPage(pageThree);
		arr.add(pageOne);
		arr.add(pageTwo);
		arr.add(pageThree);
		assertEquals( arr,testInternet.query("Title") );		
	}
}
