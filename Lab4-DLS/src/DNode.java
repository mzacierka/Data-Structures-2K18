
public class DNode {
	  private Object item;
	  private DNode next;
	  private DNode previous;
	  public DNode(Object newItem) 
	  {
	    item = newItem;
	    next = this;
	    previous = this;
	  } // end constructor

	  public DNode(Object newItem, DNode nextNode, DNode previousNode) 
	  {
	    item = newItem;
	    next = nextNode;
	    previous = previousNode;
	  } // end constructor
	  

	  public void setItem(Object newItem) 
	  {
	    item = newItem;
	  } // end setItem

	  public Object getItem() 
	  {
	    return item;
	  } // end getItem

	  public void setNext(DNode nextNode) 
	  {
	    next = nextNode;
	  } // end setNext

	  public DNode getNext() 
	  {
	    return next;
	  } // end getNext

	  public DNode getBack() {
		return previous;
	  }

	  public void setBack(DNode previousNode) {
		previous = previousNode;
	  }
	  
} // end class Node
