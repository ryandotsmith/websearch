// Usage:
//Page pageOne = new Page(fileName);
//
//Internet internet = new Internet();
//internet.addPage(PageOne);
//
// The pages are returned in descending order
// An empty array is returned if there are no search results
// internet.query("dog"); => [ pageOne, pageTwo, etc....] 



import java.util.Collection;

public interface Searchable {	
	public abstract Collection<Page> query(String searchString);
	public abstract Boolean addPage(Page newPage);
}


