 
public class StackSLS<T> implements StackInterface<T> {
	private Node<T> top;

	
	public StackSLS() {
		top = null;
	}
	public boolean isEmpty() {
		return top == null;
	}

	public void popAll() {
		top = null;
	}

	public T pop() throws StackException {
		if(!isEmpty()) {
			Node<T> temp = top;
			top = top.getNext();
			return (T) temp.getItem();
		} else {
			return null;
		}
	}

	public T peek() throws StackException {
		if(!isEmpty()) {
			return (T) top.getItem();
		} else {
			return null;
		}
	}

	public String toString() {
		String string = "";
		for(Node<T> curr = top; curr != null; curr = curr.getNext()) {
			string += curr.getItem() + " ";
		}
		return string;
	}

	public void push(T newItem) throws StackException {
		top = new Node<T>(newItem, top);	
	}

}
