/**
 * 
 /* A linked implementation of the BinarySearchTree abstract data
 * type.  Each node is a LinkedBTNode which stores references to left
 * child, right child, and parent.
 *
 * @author Tia Newhall
 *
 * Copyright (c) 2000 Tia Newhall, Lisa Meeden
 */
import java.util.Iterator;
import java.util.Collections;
public abstract class LinkedBinarySearchTree implements BinarySearchTree {
    private int size;
    private LinkedBTNode root;
    
    /**
     * create an empty LinkedBinarySearchTree
     */
    public LinkedBinarySearchTree() 
    {
	root = null;
	size = 0;
    }

    /**
     * create a LinkedBinarySearchTree with element as root node
     * @param element object to store in root node of tree
     */
    public LinkedBinarySearchTree(Object element) 
    {
	root = new LinkedBTNode(element, null);
	size = 1;
    }

    /**
     * return number of nodes in the tree
     * @return number of nodes in the tree
     */
    public int size() 
    {
    	return size;
    }

    /**
     * return a reference to the root node
     * @return a reference to the root node
     */
    public BTNode root() 
    {
    	return root;
    }

    /**
     * return a reference to the left child of the current node
     * @param current a reference to a node in the tree
     * @return a reference to the left child of the current node
     */
    public BTNode getLeft(BTNode current) 
    {
    	return (BTNode)((LinkedBTNode)current).getLeft();
    }

    /**
     * return a reference to the right child of the current node
     * @param current a reference to a node in the tree
     * @return a reference to the right child of the current node
     */
    public BTNode getRight(BTNode current) 
    {
    	return (BTNode)((LinkedBTNode)current).getRight();
    }

    /**
     * return a reference to the parent of the current node
     * @param current a reference to a node in the tree
     * @return a reference to the parent of the current node
     */
    public BTNode getParent(BTNode current) 
    {
    	return (BTNode)((LinkedBTNode)current).getParent();
    }

    /**
     * returns true if the current node has a left child
     * @param current a reference to a node in the tree
     * @return true if the current node has a left child
     */
    public boolean hasLeft(BTNode current) 
    {
    	return getLeft(current) != null;
    }

    /**
     * returns true if the current node has a right child
     * @param current a reference to a node in the tree
     * @return true if the current node has a right child
     */
    public boolean hasRight(BTNode current) 
    {
    	return getRight(current) != null;
    }

    /**
     * returns true if the current node is a leaf
     * @param current a reference to a node in the tree
     * @return true if the current node  is a leaf
     */
    public boolean isLeaf(BTNode current) 
    {
    	return getLeft(current)==null && getRight(current)==null;
    }

    /**
     * remove and return a matching Object from the tree
     * @param elem the Object to find and remove from the tree
     * @return a reference to the Object removed from the tree or null
     */
    public Object removeElement(Object element) 
    {
    	BTNode node = findNode(element);
    	if (node == null) return null;
    	Object result = node.getElement();
    	if (size == 1) 
	    root = null;
    	else 
	    removeFromTree(node);
    	size--;
    	return result;

    }

    // Removes an element recursively by replacing it with
    // its predecessor or successor in the ordering of all
    // the elements, and then removing that element until
    // the bottom of the tree is reached.  
    private void removeFromTree(BTNode node) 
    {

         if (isLeaf(node)) 
         {
            LinkedBTNode parent = (LinkedBTNode)getParent(node);
            if(parent == null) 
            {
                root = null;
            } 
            else if (isLeft(node)) 
            {
                parent.setLeft(null);

            } 
            else 
            {
                parent.setRight(null);
            }
            ((LinkedBTNode)node).setParent(null);
            ((LinkedBTNode)node).setElement(null);
        } 
         else if (hasLeft(node)) 
         {
        	 BTNode max = findMaximumNode(getLeft(node));
        	 node.setElement(max.getElement());
        	 removeFromTree(max);
         } 
         else 
         {
        	 BTNode min = findMinimumNode(getRight(node));
        	 node.setElement(min.getElement());
        	 removeFromTree(min);
         }
    }
    /**
     * find and return a reference to a matching Object from the tree
     * If there is no matching Object in the tree then return null
     * @param elem the Object to find
     * @return a reference to the Object found in tree or null
     */
    public Object findElement(Object element) {
	BTNode node = findNode(element);
	if (node != null)
	    return node.getElement();
	else
	    return null;
    }

    /**
     * find and return a reference to the BTNode containing a matching
     * Object from the tree. If there is no matching Object in the
     * tree then return null.
     * @param elem the Object to find
     * @return a reference to the BTNode containing the matchin elm
     * or null if there is no match
     */
    public BTNode findNode(Object element) {
	if (size==0)
	    return null;
	else
	    return findInSubtree(root, element);
    }

    // Finds a node recursively by starting at the root and
    // working down until the element is found or the bottom
    // of the tree is reached.
    private BTNode findInSubtree(BTNode current, Object element) {
	Comparable currentValue = (Comparable)current.getElement();
	Comparable newValue = (Comparable)element;
	int result = newValue.compareTo(currentValue);
	if (result == 0)
	    return current;
	if (result < 0 && hasLeft(current))
	    return findInSubtree(getLeft(current), element);
	if (result > 0 && hasRight(current))
	    return findInSubtree(getRight(current), element);
	return null;
    }

    /**
     * return an Iterator over the tree elements in-order
     * @return an Iterator over the tree elements in-order
     */
    public Iterator inOrderElements() {
	return new TraversalIterator(this, "in");
    }

    /**
     * return an Iterator over the tree elements in pre-order
     * @return an Iterator over the tree elements in pre-order
     */
    public Iterator preOrderElements() {
	return new TraversalIterator(this, "pre");
    }

    /**
     * return an Iterator over the tree elements in post-order
     * @return an Iterator over the tree elements in post-order
     */
    public Iterator postOrderElements() {
	return new TraversalIterator(this, "post");
    }

    // Determines if the current node is a right child.
    private boolean isRight(BTNode current) {
	return getRight(getParent(current)) == current;
    }

    // Determines if the current node is a left child.
    private boolean isLeft(BTNode current) {
	return getLeft(getParent(current)) == current;
    }
    
    /** Returns the node containing the smallest element 
     * in the subtree rooted at current.
     *
     * THIS IS LEFT FOR YOU TO IMPLEMENT
     */
    private BTNode findMinimumNode(BTNode current) 
    {
    		Object obj = Collections.min(arrayList);
    }

    /** Returns the node containing the largest element 
     * in the subtree rooted at current.
     *
     * THIS IS LEFT FOR YOU TO IMPLEMENT
     */
    private BTNode findMaximumNode(BTNode current)
    {	
    		Object obj = Collections.max(arrayList);
    }
    /**
     * add an unique Object to the tree, if elem is not unique it is
     * not inserted into the tree
     * @param elem the Object to insert
     *
     * THIS IS LEFT FOR YOU TO IMPLEMENT
     */
    public void insert(BinarySearchTree element) 
    { 
            element.insertElement(element); 
    } 
}
    
		

