/**
 *  Iterator over binary trees
 * 
 * @author Tia Newhall
 *
 * Copyright (c) 2000 Tia Newhall, Lisa Meeden
 */
import java.util.*;

public class TraversalIterator implements Iterator {
    ArrayList list;
    int index;

    /**
     * create a TraversalIterator over the binary tree nodes
     * order should be the string "in", "pre", or "post"
     * does post order by default
     * @param tree the tree to iterate over
     * @parm order the type of traversal
     */
    public TraversalIterator(BinarySearchTree tree, String order) {
	index = 0; 
	list = new ArrayList();
        if(tree.size() == 0) return;
	if (order.equals("in"))
	    inOrderTraverse(tree, tree.root());
	else if (order.equals("pre"))
	    preOrderTraverse(tree, tree.root());
	else 
	    postOrderTraverse(tree, tree.root());
    }

    private void inOrderTraverse(BinarySearchTree tree, BTNode current) {
	if (tree.hasLeft(current))
	    inOrderTraverse(tree, tree.getLeft(current));
	list.add(current.getElement());
	if (tree.hasRight(current))
	    inOrderTraverse(tree, tree.getRight(current));
    }

    private void preOrderTraverse(BinarySearchTree tree, BTNode current) {
	list.add(current.getElement());
	if (tree.hasLeft(current))
	    preOrderTraverse(tree, tree.getLeft(current));
	if (tree.hasRight(current))
	    preOrderTraverse(tree, tree.getRight(current));
    }

    private void postOrderTraverse(BinarySearchTree tree, BTNode current) {
	if (tree.hasLeft(current))
	    postOrderTraverse(tree, tree.getLeft(current));
	if (tree.hasRight(current))
	    postOrderTraverse(tree, tree.getRight(current));
	list.add(current.getElement());
    }
    
    /**
     * return true if there is a next Object in the iteration
     * @return true if there is a next Object in the iteration
     */
    public boolean hasNext() {
	return index < list.size();
    }

    /**
     * return the next Object in the iteration
     * @return the next Object in the iteration
     */
    public Object next() {
	return list.get(index++);
    }
    
    /**
     * not implmented on purpose
     */
    public void remove() {
	;
    }

}
	
    
