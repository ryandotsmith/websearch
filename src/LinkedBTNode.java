/**
 *
 * A linked implementation of the BTNode abstract data type. 
 * The location of a particular node's left child, right child,
 * and parent are stored as internal references.
 *
 * @author Tia Newhall
 *
 * Copyright (c) 2000 Tia Newhall, Lisa Meeden
 */

public class LinkedBTNode implements BTNode {
    private Object element;
    private LinkedBTNode parent, left, right;

    /**
     * create a new LinkedBTNode
     * @param contents element field
     * @param mother parent node
     */
    public LinkedBTNode(Object contents, LinkedBTNode mother) {
	element = contents;
	parent = mother;
	left = null;
	right = null;
    }

    /**
     * return a reference to the element field
     * @return a reference to the element field
     */
    public Object getElement() { return element; }
    /**
     * return a reference to the parent node or null
     * @return a reference to the parent node or null
     */
    public BTNode getParent() { return parent; }
    /**
     * return a reference to the left child node or null
     * @return a reference to the left child node or null
     */
    public BTNode getLeft() { return left; }
    /**
     * return a reference to the right child node or null
     * @return a reference to the right child node or null
     */
    public BTNode getRight() { return right; }

    /** set this node's element to newElement */
    public void setElement(Object newElement) { 
	element = newElement; 
    }
    /** set this node's the parent to newParent */
    public void setParent(BTNode newParent) { 
	parent = (LinkedBTNode) newParent; 
    }
    /** set this node's left child to newLeft */
    public void setLeft(BTNode newLeft) {
	left = (LinkedBTNode) newLeft; 
    }
    /** set this node's left child to newRight */
    public void setRight(BTNode newRight) { 
	right = (LinkedBTNode) newRight; 
    }
}
