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
		ArrayList<Page> arr  = new ArrayList<Page>();
		testInternet.addPage(pageOne);
		testInternet.addPage(pageTwo);
		testInternet.addPage(pageThree);
		arr.add(pageOne);
		arr.add(pageTwo);
		arr.add(pageThree);
		assertEquals( arr,testInternet.query("Title"));
	}
	public void testQueryWithPagesThatHaveDifferentWordCounts() throws DocumentException{
		Page pageOne   = new Page("test.html");
		Page pageTwo   = new Page("test.html");
		Page pageThree = new Page("test.html");
		pageThree.getList().insert("Title");
		ArrayList<Page> arr  = new ArrayList<Page>();
		testInternet.addPage(pageOne);
		testInternet.addPage(pageTwo);
		testInternet.addPage(pageThree);
		arr.add(pageThree);
		arr.add(pageOne);
		arr.add(pageTwo);
		assertEquals( arr,testInternet.query("Title"));		
	}
	public void testQueryThatHasZeroSearchResults() throws DocumentException {
		Page pageOne   = new Page("test.html");
		assertEquals( new ArrayList<Page>(), testInternet.query("NotInPage") );
	}
	public void testQueryThatHasMultipleSearchTerms() throws DocumentException{
		Page pageOne   = new Page("test.html");
		Page pageTwo   = new Page("test.html");
		Page pageThree = new Page("test.html");
		pageThree.getList().insert("Red");
		pageOne.getList().insert("Red");
		ArrayList<Page> arr  = new ArrayList<Page>();
		testInternet.addPage(pageOne);
		testInternet.addPage(pageTwo);
		testInternet.addPage(pageThree);
		arr.add(pageOne);
		arr.add(pageThree);
		ArrayList<String> input = testInternet.clean("Page Title Red");
		assertEquals( arr,testInternet.query(input));				
	}
	public void testCleaningQueryInputWithOneTerm() throws DocumentException {
		Page pageOne = new Page("test.html");
		testInternet.addPage(pageOne);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Title");
		assertEquals(expected,testInternet.clean("Title"));		
	}
	public void testCleaningQueryInputWithTwoTerms() throws DocumentException{
		Page pageOne = new Page("test.html");
		testInternet.addPage(pageOne);
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Page");
		expected.add("Title");
		assertEquals(expected,testInternet.clean("Page Title"));
		
	}
}
