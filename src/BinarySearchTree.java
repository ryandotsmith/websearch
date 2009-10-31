/**
 * 
 * An abstract data type for binary search trees.  Each position in a
 * binary search tree is represented as a BTNode.  Each node stores
 * an element.  The element's class must implement the Comparable interface 
 * to determine their ordering.  
 *
 * @author Tia Newhall
 * 
 * Copyright (c) 2000 Tia Newhall, Lisa Meeden
 */
import java.util.*;

public interface BinarySearchTree {
    /**
     * return the size of the tree
     */
    public int size();
    /**
     * return the node at the root of the tree
     */
    public BTNode root();
    /**
     * return the left child of the given node in the tree
     */
    public BTNode getLeft(BTNode current);
    /**
     * return the right child of the given node in the tree
     */
    public BTNode getRight(BTNode current);
    /**
     * return the parent of the given node in the tree
     */
    public BTNode getParent(BTNode current);
    /**
     * determine if the given node has a left child
     */
    public boolean hasLeft(BTNode current);
    /**
     * determine if the given node has a right child
     */
    public boolean hasRight(BTNode current);
    /**
     * determine if the given node is a leaf
     */
    public boolean isLeaf(BTNode current);
    /**
     * remove an element from the tree
     */
    public Object removeElement(Object element);
    /**
     * insert an element into the tree at the proper location
     */
    public void insertElement(Object element);
    /**
     * locate an element 
     */
    public Object findElement(Object element);
    /**
     * locate a node
     */
    public BTNode findNode(Object element);
    /**
     * return an Iterator of an in-order traversal of the tree
     */
    public Iterator inOrderElements();
    /**
     * return an Iterator of a pre-order traversal of the tree
     */
    public Iterator preOrderElements();
    /**
     * return an Iterator of a post-order traversal of the tree
     */
    public Iterator postOrderElements();
}
