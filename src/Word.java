public class Word {
	private String data;
	private Integer count;
	
	public Word(String newWord){
		this.data  = newWord;
		this.count = 1;
	}
	public String getData(){
		return this.data;
	}
	public int getCount(){
		return this.count;
	}
	public void incrementCount(){
		this.count++;
	}
}
