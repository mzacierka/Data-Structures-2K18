/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3 REDO
 * Status: Complete and thoroughly tested
 * Last update: 04/09/18
 * Submitted:  04/10/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.04.09
 */
public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface {
	protected Object[] items; // an array of list items
	protected int numItems; // number of items in list
	private static final int MAX_LIST = 4;

	public AscendinglyOrderedStringList() {
		items = new Object[MAX_LIST];
		numItems = 0;
	} // end default constructor

	public boolean isEmpty() {
		return (numItems == 0);
	} // end isEmpty

	public int size() {
		return numItems;
	} // end size

	public void clear() {
		// Creates a new array; marks old array for
		// garbage collection.
		items = new Object[MAX_LIST];
		numItems = 0;

	} // end removeAll

	public void add(String item) throws ListIndexOutOfBoundsException { //redo corrected
		if (numItems == items.length) {
			resize();
		} else {
			if (numItems == 0) {
				items[0] = item; // add to beginning
				numItems++;
			} else {
				int search = search(item);
				for (int indx = numItems - 1; indx >= search; indx--) {
					items[indx + 1] = items[indx];
				}
				items[search] = item;
				numItems++;
			}
		}

	} // end add

	public String get(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < numItems) {
			return items[index].toString();
		} else {
			// index out of range
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on get");
		} // end if
	} // end get

	public void remove(int index) throws ListIndexOutOfBoundsException {
		if (index >= 0 && index < numItems) {
			// delete item by shifting all items at
			// positions > index toward the beginning of the list
			// (no shift if index == size)
			for (int pos = index + 1; pos < numItems; pos++) // textbook code modified to eliminate logic error causing
			// ArrayIndexOutOfBoundsException

			{
				items[pos - 1] = items[pos];
			} // end for
			items[numItems - 1] = null; // fixes memory leak
			numItems--;
		} else {
			// index out of range
			throw new ListIndexOutOfBoundsException("ListIndexOutOfBoundsException on remove");
		} // end if
	} // end remove

	/*
	 *****************************************************
	 * Version 1 of the Binary Search from lecture notes
	 *****************************************************
	 */
	public int search(String item) {
		int mid = 0;
		int high = numItems - 1;
		int low = 0;
		int ret = 0;
		while (low <= high) {
			ret = item.compareTo(items[mid].toString());
			mid = (low + high)/2;
			if(item == items[mid].toString()) {
				low = Integer.MAX_VALUE; //end loop at any size
			} else if(ret < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if((mid == 0 && ret >= 1) || (mid == numItems-1 && ret >= 1) ) {
			mid++;
		}
		return mid;
	}

	public void resize() {
		Object[] copy = new Object[numItems];
		for (int i = 0; i < items.length; i++) {
			copy[i] = items[i];
		}
	}

	public String toString() {
		String list = "";
		for (int j = 0; j < numItems; j++) {
			if (items[j] != null) {
				String object = items[j].toString();
				list += object + " ";
			}
		}
		return list;

	}
}
