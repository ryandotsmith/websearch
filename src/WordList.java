import java.util.ArrayList;

public class WordList {
	
	private ArrayList<Word> list;
	
	public WordList(){
		this.list = new ArrayList();
	}
	
	public int getSize(){
		return list.size();
	}
	public int count(String searchTerm){
		if( contains(searchTerm) == null )
			return 0;
		return this.contains(searchTerm).getCount();
	}
	
	public void insert(String newString){		
		Word result = contains(newString);
		if( result == null ){
			list.add(new Word(newString));	
		}else{
			result.incrementCount();
		}
	}
	public Word contains(String search_term){
		for(Word word : list)
			if(word.getData().equals(search_term))
				return word;
		return null;
	}

}
