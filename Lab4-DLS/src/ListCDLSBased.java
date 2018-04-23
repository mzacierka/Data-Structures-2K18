
public class ListCDLSBased implements ListInterface {
	private DNode head;
	private int numItems;

	public ListCDLSBased() {
		head = null;
		numItems = 0;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public int size() {
		return numItems;
	}

	public void add(int index, Object item) throws ListIndexOutOfBoundsException {
		if (numItems == 0) {
			head = new DNode(item);
			numItems++;
		} else if(index >= 0 && index <= numItems) {
			DNode prev;
			if(index == 0) {
				prev = head.getBack();
			} else {
				prev = find(index - 1);
			}
			DNode curr = new DNode(item, prev.getNext(), prev);
			prev.setNext(curr);
			if(index == 0) {
				head = curr;
			}
			numItems++;
		}
	}

	public Object get(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index <= numItems - 1) {
			return find(index).getItem();
		} else {
			System.out.println("No items in index: " + index);
			return null;
		}
	}

	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index <= numItems && index >= 0) {
			DNode prev;
			if (index == 0) {
				prev = head.getBack();
			} else {
				prev = find(index - 1);
			}
			prev.getNext().setBack(prev);
			prev.setNext(prev.getNext());
			if (index == 0) {
				head = prev.getNext();
			}
		}
		numItems--;
	}

	public void removeAll() {
		head = null;
		numItems = 0;
	}

	private DNode find(int index) {
		DNode retrieve = head;
		if (index >= numItems / 2) {
			for (int i = 0; i < index; i++) {
				retrieve = retrieve.getNext();
			}
		} else {
			for (int i = 0; i < index; i++) {
				retrieve = retrieve.getBack();
			}
		}
		return retrieve;
	}

	public String toString() {
		String string = "";
		DNode curr = head;
		for (int i = 0; i < numItems; i++) {
			string += curr.getItem() + " ";
			curr = curr.getNext();
		}
		return string;
	}

}
