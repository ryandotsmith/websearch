import java.io.IOException;

// Usage:
// Page pageOne = new Page(fileName);
// PageData returns HTML 
// pageOne.getPageData(); => '<html><body><h1>Test</h1></body></html>' 

// To get the count of a word in a Page 
// pageOne.getList().count("word"); => retuns a count of the word: "word" 


public interface InternetDocument {
	// PageData is the HTML data
	// Perhaps this should be a Document? 
	// TODO: Decide what data type the HTML rendering engine requires 
	public abstract String getText() throws IOException;
	public abstract String getTitle();
}
