/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/26/18
 * Submitted:  02/26/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.02.26
 */
public class Deq<T> extends RAQueue implements ExtendedQueueInterface<T> {
	public void enqueueFirst(T newItem) throws ExtendedQueueException {
		if (numItems == items.length) {
			resize();
		}
		front = ((front - 1) + items.length) % items.length;
		items[front] = (T) newItem;
		numItems++;
	}

	public T dequeueLast() throws ExtendedQueueException {
		back = (back + items.length - 1) % items.length;
		T result = (T) items[back];
		items[back] = null;
		numItems--;
		return result;
	}

	public T peekLast() throws ExtendedQueueException {
		return (T) items[(back + items.length - 1 ) % items.length];
	}

}
