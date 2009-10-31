import java.util.Scanner; 
import java.io.*; 
import java.lang.ref.Reference;
//create word frequency object so the counter can be incremented when i appears in the binary
//search tree more than one then print on words with word frequency more than set amount into 
//print binary search tree,
//sort alphabetically 
public abstract class WordFrequencyTree implements BinarySearchTree 
{ 		
	public static int count;
    private Node root; 
    // int i;
    //private LinkedBinarySearchTree LinkedBinarySearchTree; 
    static String word; 
    LinkedBinarySearchTree WordFreqTree ;//= LinkedBinarySearchTree

    public int count(String searchTerm ){
    		return 1;
    }
    
    public static int wordFrequency =0;    
    public WordFrequencyTree ()
    {
    	   count = 0;
    	   root = null;
    
    }
       
    public WordFrequencyTree(File filename,int wordFrequency)
    {
    		printing(filename);
    }
              
    public static void printing(File filename )
    {
    		try{
    			FileOutputStream outFile = new FileOutputStream("html2.txt"); 
    			PrintStream printFile = new PrintStream( outFile ); 
            //File fileName = new File("html.txt"); 
             Scanner readFile = new Scanner(filename);    
				while (readFile.hasNext()&& count >= wordFrequency) 
                { 		count ++;
                        word = readFile.next(); 
                       
                     /* if (word)
                      {
                    	  //function to make sure duplicates dont make it to final tree
                    	  //issue because word is a string
                      }
                        System.out.println(word); 
                        printFile.println(word); 
                      */
                }readFile.close(); 
                
        	   }
        	catch(FileNotFoundException f)
        		{  System.out.println("read file error");
        			return;
        		}
              
        }     
                
      public static void main (String arg[]) throws IOException 
        { 
               ;// printing(File filename);
                
        } 

        public void insert( String element ) 
        { 
        		// build word object from element
        		// insert word object into the tree
        } 

        public void insertElement(int id, double dd) 
        { 
                Node newNode = new Node();    // make new node 
                newNode.iData = id;           // insert data 
                newNode.dData = dd; 
                if(root==null)                // no node in root 
                        root = newNode; 
                else                          // root occupied 
                { 
                        Node current = root;       // start at root 
                        Node parent; 
                        while(true)                // (exits internally) 
                        { 
                                parent = current; 
                              
                               if(id < current.iData)  // go left? 
                                { 
                                        current = current.leftChild; 
                                        if(current == null)  // if end of the line, 
                                        {                 // insert on left 
                                                parent.leftChild = newNode; 
                                                return; 
                                        } 
                                }  // end if go left 
                                else                    // or go right? 
                                { 
                                        current = current.rightChild; 
                                        if(current == null)  // if end of the line 
                                        {                 // insert on right 
                                                parent.rightChild = newNode; 
                                                return; 
                                        } 
                                }  // end else go right 
                        }  // end while 
                }  // end else not root 
        }  // end insert() 

        // Determines if the current node is a right child.
        public boolean isRight(BTNode current) 
        {
        	return getRight(getParent(current)) == current;
        }

        // Determines if the current node is a left child.
         public boolean isLeft(BTNode current) 	
        {
        	return getLeft(getParent(current)) == current;
        }

        public static void acending( String  x [ ] ) 
        { 
                int j; 
                boolean flag = true;  // will determine when the sort is finished 
                String temp; 

                while ( flag ) 
                { 
                        flag = false; 
                        for ( j = 0;  j < x.length - 1;  j++ ) 
                        { 
                                if ( x [ j ].compareToIgnoreCase( x [ j+1 ] ) > 0 ) 
                                {                                             // ascending sort 
                                        temp = x [ j ]; 
                                        x [ j ] = x [ j+1];     // swapping 
                                        x [ j+1] = temp; 
                                        flag = true; 
                                } 
                        } 
                } 
        } 

} 




