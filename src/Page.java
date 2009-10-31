import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;

public class Page implements Comparable {

	private static String searchTearm;
	private WordList list;
	private Scanner scanner;


	public Page(String fileName){
		try{
			scanner = new Scanner(fileName,Scanner.SCANFILE);
			//while(!scanner.atEndOfFile()){
				String token = scanner.getNextToken();
				
				//list.insert(token);
				//;
			//}
		}catch (FileNotFoundException e) {
		    System.out.println(e);
		}catch (IOException e) {
		    System.out.println(e);
		}

	}
	
	
	public WordList getList(){
		return this.list;
	}
	
	public int compareTo(Object anotherPage) throws ClassCastException {
		if (!(anotherPage instanceof Page))
	      throw new ClassCastException("A Page object expected.");
	    int anotherPageRank = ((Page) anotherPage).getList().count(Page.searchTearm);  
	    return this.getList().count(Page.searchTearm) - anotherPageRank;    
	}

}
