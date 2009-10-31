/**
 *
 * An abstract data type for binary tree nodes.  
 * 
 * @author Tia Newhall
 * 
 * Copyright (c) 2000 Tia Newhall, Lisa Meeden
 */
public interface BTNode {
    /**
     * return a reference to the element field 
     * @return a reference to the element field 
     */
    public Object getElement();
    /**
     * modify the element field 
     */
    public void setElement(Object newElement);
}
