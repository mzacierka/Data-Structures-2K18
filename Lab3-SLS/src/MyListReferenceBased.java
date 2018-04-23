public class MyListReferenceBased implements ListInterface {
	private Node head;

	
	public MyListReferenceBased() {
		head = null;
	}
	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public int size() {
		Node tempHead = head;
		int size = 0;
        while (tempHead != null)
        {
            size++;
            tempHead = tempHead.getNext();
        }
        return size;
	}

	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if(index < 0) {
			System.out.println("Index is not valid");
		} else {
			if(index != 0) {
				Node prev = find(index -1);
				prev.setNext(new Node(item, prev.getNext()));
			} else {
				head = new Node(item, head);
			}
		}
	}

	public Object get(int index) throws ListIndexOutOfBoundsException {
		if(index >= 0 && index < size()) {
			 return find(index).getItem();
		} else {
			return null;
		}
	}

	public void remove(int index) throws ListIndexOutOfBoundsException {
		if(index < 0) {
			System.out.println("Index is not valid");
		} else {
			if(index != 0) {
				Node prev = find(index -1);
				prev.setNext(prev.getNext().getNext());
			} else {
				head = head.getNext();
			}
		}
		
	}

	public void removeAll() {
		head = null;
	}
	
//	public String toString() {
//		return ;
//	}
	
	private Node find(int index) 
	  {
	  // --------------------------------------------------
	  // Locates a specified node in a linked list.
	  // Precondition: index is the number of the desired
	  // node. Assumes that 0 <= index <= numItems 
	  // Postcondition: Returns a reference to the desired 
	  // node.
	  // --------------------------------------------------
	    Node curr = head;
	    for (int skip = 0; skip < index; skip++) 
	    {
	      curr = curr.getNext();
	    } // end for
	    return curr;
	  } // end find
	
	public String toString() {
		return "t";
	}
	
	
	
}
