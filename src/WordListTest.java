import junit.framework.TestCase;


public class WordListTest extends TestCase {
	private WordList testList;
	protected void setUp() throws Exception {
		super.setUp();
		testList = new WordList();
	}
	public void testGetSize(){
		assertEquals( 0,testList.getSize());
	}
	public void testInsert(){
		assertEquals(0,testList.getSize());
		testList.insert("horses-ass");
		assertEquals(1,testList.getSize());
	}
	public void testContains() {
		testList.insert("horses-ass");
		Word result = testList.contains("horses-ass");		
		assertTrue(result instanceof Word);
		Word anotherResult = testList.contains("not-in-list");
		assertEquals(null,anotherResult);
	}
	public void testInsertionDuplicatin(){
		assertEquals(0, testList.getSize());
		testList.insert("horses-ass");
		testList.insert("horses-ass");
		assertEquals(1, testList.getSize());
	}

	public void testInsertionDuplicatinIncrementsWordCount(){
		testList.insert("horses-ass");
		testList.insert("horses-ass");
		assertEquals(2,testList.count("horses-ass"));
	}
	public void testCountOfWordThatDoesNotExist(){
		assertEquals(0,testList.count("not_in_list"));
	}

}
