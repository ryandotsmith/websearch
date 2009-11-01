import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Internet implements Searchable {
	private ArrayList<Page> pages;
	
	public Internet(){
		pages = new ArrayList<Page>();
	}
	@Override
	public void addPage(Page newPage) {
		pages.add(newPage);
	}
	@Override
	public Collection<Page> query(String searchString) {
		Page.searchTerm = searchString;
		Collection<Page> results = new ArrayList<Page>();
		for( Page page : pages)
			if(page.getList().count(searchString) > 0)
				results.add(page);
		Collections.sort((ArrayList<Page>)results, new PageComparator());
		return results;
	}	
	public int getCount(){
		return this.pages.size();
	}

}
