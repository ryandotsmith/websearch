import java.io.FileNotFoundException;
import junit.framework.TestCase;


public class PageTest extends TestCase {
	private Page testPage;

	protected void setUp() throws Exception {
		super.setUp();
		String file = "test.html";
		testPage = new Page(file);
	}

	public void testPage() {
		assertTrue(testPage instanceof Page);
	}
	public void testExceptionGetsThrownOnBadFileName() throws FileNotFoundException{
		//Page blah = new Page("bad_file_name");
	}
	
	public void testThatTheConstructorHasReadTheFile(){
		assertEquals(1,testPage.getList().count("Title"));
	}

}
