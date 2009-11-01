import java.util.Collection;

public interface Searchable {	
	public abstract Collection<Page> query(String searchString);
	public abstract Boolean addPage(Page newPage);
}

//Page pageOne = new Page(fileName)

//Internet internet = new Internet();
//internet.addPage(PageOne);
//internet.addPage(PageTwo);
//
//internet.query("dog");