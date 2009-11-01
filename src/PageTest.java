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
		}catch(DocumentException e){
			return;
		}
		fail("Should raise an exception");
	}
	public void testThatTheConstructorHasReadTheFile(){
		testPage.treeWalk();
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
	}
	public void testTheComparisonOfPages() throws DocumentException{
		testPage.getList().insert("nice");
		testPage.getList().insert("nice");
		assertEquals(2,testPage.getList().count("nice"));
		Page anotherTestPage = new Page("test.html");
		anotherTestPage.getList().insert("nice");
		assertEquals(1,anotherTestPage.getList().count("nice"));
		Page.searchTearm = "nice";
		assertEquals(1,testPage.compareTo(anotherTestPage));
		assertEquals(-1,anotherTestPage.compareTo(testPage));
	}

}
	