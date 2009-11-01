import org.dom4j.Document;

public interface InternetDocument {
	// PageData is the HTML data
	// Perhaps this should be a Document? 
	// TODO: Decide what data type the HTML rendering engine requires 
	public abstract String getPageData();
}
