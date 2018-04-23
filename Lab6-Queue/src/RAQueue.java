/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/25/18
 * Submitted:  02/25/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.02.25
 */
public class RAQueue<T> implements QueueInterface<T> {
	protected int numItems;
	protected int front;
	protected int back;
	protected T items[];

	public RAQueue() {
		numItems = front = back = 0;
		items = (T[]) new Object[3];
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public void enqueue(T newItem) throws QueueException {
		if (numItems == items.length) {
			resize();
		}
		items[back] = newItem;
		back = (back + 1) % items.length;
		numItems++;
	}

	protected void resize() {
		T[] copy = (T[]) new Object[numItems * 2];
		for (int i = 0; i < items.length; i++) {
			copy[i] = (T) items[(front + i) % items.length];
		}
		front = 0;
		back = numItems;
		items = copy;
	}

	public T dequeue() throws QueueException {
		if (numItems == 0) {
			throw new QueueException("Queue is Empty");
		} else {
			T item = items[front];
			front = (front + 1) % items.length;
			--numItems;
			return item;
		}
	}

	public void dequeueAll() {
		numItems = front = back = 0;
		items = (T[]) new Object[3];
	}

	public T peek() throws QueueException {
		if (numItems == 0) {
			throw new QueueException("List is Empty");
		} else {
			return items[front];
		}
	}

	public String toString() {
		String string = "";
		for (int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				string += items[i].toString() + " ";
			}
		}
		return string;
	}

}
