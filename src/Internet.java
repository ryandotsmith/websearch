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
		if(searchString.length() > 1 )
			return( query(clean(searchString)));
		Page.searchTerm = searchString;
		Collection<Page> results = new ArrayList<Page>();
		for( Page page : pages)
			if(page.getList().count(searchString) > 0)
				results.add(page);
		Collections.sort((ArrayList<Page>)results, new PageComparator());
		return results;
	}	

	public Collection<Page> query(ArrayList<String> searchTerms) {
		ArrayList<ArrayList<Page>> results = new ArrayList<ArrayList<Page>>(); 
		for( String term : searchTerms){
			Page.searchTerm = term;
			ArrayList<Page> searchResults = new ArrayList<Page>();
			for( Page page : pages)
				if(page.getList().count(term) > 0)
					searchResults.add(page);
			Collections.sort((ArrayList<Page>)searchResults, new PageComparator());				
			results.add(searchResults);
		}
		if( results.size() == 0 )
			return(new ArrayList<Page>());
		ArrayList<Page> first = results.get(0);
		for( ArrayList<Page> result : results)
			first.retainAll(result);
		return first;
	}	

	public int getCount(){
		return this.pages.size();
	}
	public ArrayList<String> clean(String string) {
		String[] words = string.split(" ");
		ArrayList<String> results = new ArrayList<String>();
		for(String word : words)
			results.add(word);
		return results;
	}

}
