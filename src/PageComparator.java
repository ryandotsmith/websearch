import java.util.Comparator;

public class PageComparator implements Comparator<Page> {
	public int compare( Page page, Page anotherPage){
		if(page.compareTo(anotherPage) == 1 )
			return 1;
		if( page.compareTo(anotherPage) == -1)
			return -1;
		return 0;
	}
}
