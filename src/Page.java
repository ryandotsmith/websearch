import java.io.File;

import java.util.StringTokenizer;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class Page implements InternetDocument,Comparable  {

	public static String searchTerm;
	private WordList list;
	private Document document;
	private String title;
	
	public Page(String fileName) throws DocumentException{	
	    this.list = new WordList();
		this.title = fileName;
	    File file = new File(fileName);
		SAXReader xmlReader = new SAXReader();
		this.document = xmlReader.read(file);
		crawl();
	}

	public WordList getList() 		{return this.list;}
	public Document getDocument() 	{return this.document;}
	public String getText()			{return "TODO";}
	public String getTitle()			{return title;}

	public int compareTo(Object anotherPage) throws ClassCastException {
		if (!(anotherPage instanceof Page))
	      throw new ClassCastException("A Page object expected.");
	    int pageRank = this.getList().count(Page.searchTerm);
		int anotherPageRank = ((Page) anotherPage).getList().count(Page.searchTerm);  
	    return( pageRank > anotherPageRank ? 1 : (pageRank == anotherPageRank ? 0 : -1));    
	}
	public void crawl() {
        crawl( this.document.getRootElement() );
    }
    private void crawl(Element element) {
    		for ( int i = 0, size = element.nodeCount(); i < size; i++ ) {
            Node node = element.node(i);
            if ( node instanceof Element ) {
                crawl( (Element) node );
            }
            else {
            		String string = node.getText();
            		StringTokenizer st = new StringTokenizer(string);
            		while (st.hasMoreTokens()) {
            		  this.list.insert(st.nextToken());
            		}
            }
        }
    }
}
