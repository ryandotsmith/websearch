// Usage:
// Page pageOne = new Page(fileName);
// PageData returns HTML 
// pageOne.getPageData(); => '<html><body><h1>Test</h1></body></html>' 



public interface InternetDocument {
	// PageData is the HTML data
	// Perhaps this should be a Document? 
	// TODO: Decide what data type the HTML rendering engine requires 
	public abstract String getText();
}
