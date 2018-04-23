
public class StackRA<T> implements StackInterface<T> {
	private T items[];
	private int numItems = 0;
	
	public StackRA() {
		items = (T[]) new Object[3];
		numItems = 0;
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public void popAll() {
		items = (T[]) new Object[3];
		numItems = 0;		
	}

	public void push(T newItem) throws StackException {
		if(numItems == items.length) {
			resize();
		}
		items[numItems++] = newItem;
	}

    public void resize() {
        T[] copy = (T[]) new Object[numItems * 2];
        for(int i = 0; i < items.length; i++) {
            copy[i] = (T) items[i];
        }
        items = copy;
    }

	public T pop() throws StackException {
		if(numItems != 0) {
			T item = items[--numItems];
			items[numItems] = null;
			return item;
		} else {
			throw new StackException("Stack is Empty on pop");
		}
	}
	public T peek() throws StackException {
		if(numItems != 0) {
			return items[numItems - 1];
		} else {
			throw new StackException("Stack is empty on pop.");
		}
	}
	
	public String toString() {
		String string = "";
		for(int i = 0; i < numItems; i++) {
			string += items[i] + " ";
		}
		return string;
	}
	
	
}
