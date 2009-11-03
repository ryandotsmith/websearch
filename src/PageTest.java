import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.dom4j.DocumentException;
import org.dom4j.tree.DefaultDocument;
import junit.framework.TestCase;


public class PageTest extends TestCase {
	private Page testPage;

	protected void setUp() throws Exception {
		super.setUp();
		String file = "test.html";
		testPage = new Page(file);
	}
	public void testExceptionGetsThrownOnBadFileName() throws DocumentException{
		try{
			Page blah = new Page("bad_file_name");
			fail("Should raise an exception");
		}catch(DocumentException e){
			;
		}
		
	}
	public void testThatTheConstructorHasReadTheFile(){
		assertEquals(1,testPage.getList().count("Title"));
	}
	public void testPage() {
		assertTrue(testPage instanceof Page);
	}
	public void testGetList(){
		assertTrue( testPage.getList() instanceof WordList);
	}
	public void testGetDocument(){
		assertTrue( testPage.getDocument() instanceof DefaultDocument);
		try{
			assertEquals( "<html><head><title>Page Title</title></head><body><h1>Content</h1></body></html>", testPage.getText());	
		}catch( IOException e ){
			;
		}
		
	}
	public void testTheComparisonWhenTheComparisonDoesNotMakeSense() throws ClassCastException{
		try{
			testPage.compareTo(42);
			fail("Should have raised exception");
		}catch( ClassCastException e ){
			;
		}		
	}
	public void testTheComparisonOfPages() throws DocumentException{
		testPage.getList().insert("nice");
		testPage.getList().insert("nice");
		assertEquals(2,testPage.getList().count("nice"));
		Page anotherTestPage = new Page("test.html");
		anotherTestPage.getList().insert("nice");
		assertEquals(1,anotherTestPage.getList().count("nice"));
		Page.searchTerm = "nice";
		assertEquals(1,testPage.compareTo(anotherTestPage));
		assertEquals(-1,anotherTestPage.compareTo(testPage));
	}
	public void testTheSortingOfPages() throws DocumentException{
		Page pageOne   = new Page("test.html");
		Page pageTwo   = new Page("test.html");
		Page pageThree = new Page("test.html");
		pageThree.getList().insert("Title");
		pageThree.getList().insert("Title");
		assertEquals(3, pageThree.getList().count("Title") );
		ArrayList array = new ArrayList();
		array.add(pageOne);
		array.add(pageThree);
		array.add(pageTwo);
		Page.searchTerm = "Title";
		assertEquals( -1, pageOne.compareTo(pageThree));
		assertEquals( 0, pageOne.compareTo(pageTwo));
		Collections.sort(array, new PageComparator());
		assertEquals( pageThree, array.get(0) );
	}
	public void testGettingTheTitleFromTheDom(){
		assertEquals( "test.html", testPage.getTitle() );
	}
}
	