import java.io.File;
import java.util.StringTokenizer;
import org.dom4j.*;
import org.dom4j.io.SAXReader;




public class Page implements Comparable {

	public static String searchTearm;
	private WordList list;
	private Document document;
	
	public Page(String fileName) throws DocumentException{	
	    this.list = new WordList();
		File file = new File(fileName);
		SAXReader xmlReader = new SAXReader();
		this.document = xmlReader.read(file);
	}
	public WordList getList() 		{return this.list;}
	public Document getDocument() 	{return this.document;}
	public int compareTo(Object anotherPage) throws ClassCastException {
		if (!(anotherPage instanceof Page))
	      throw new ClassCastException("A Page object expected.");
	    int anotherPageRank = ((Page) anotherPage).getList().count(Page.searchTearm);  
	    return this.getList().count(Page.searchTearm) - anotherPageRank;    
	}
	public void treeWalk() {
        treeWalk( this.document.getRootElement() );
    }
    private void treeWalk(Element element) {
    		for ( int i = 0, size = element.nodeCount(); i < size; i++ ) {
            Node node = element.node(i);
            if ( node instanceof Element ) {
                treeWalk( (Element) node );
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
