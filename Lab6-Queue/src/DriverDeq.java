import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/25/18
 * Submitted:  02/25/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.02.25
 */
public class DriverDeq {
	static Deq<String> deq = new Deq<String>();
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		boolean repeat = true;
		String option = "";
		System.out.print("Select from the following menu:\n" + "\t1. Insert item at back of Deq.\n"
				+ "\t2. Insert item at front of Deq.\n" + "\t3. Remove item from front of Deq.\n"
				+ "\t4. Remove item from back of Deq.\n" + "\t5. Display front item of Deq\n"
				+ "\t6. Display last item of Deq.\n" + "\t7. Clear Deq.\n" + "\t8. Display content of Deq.\n"
				+ "\t9. Exit. \n");

		do {

			System.out.print("Make your selection now: ");
			try {
				option = stdin.readLine().toString();
				System.out.println(option);
			} catch (IOException e) {
				e.printStackTrace();
			}

			switch (option) {
			case "1":
				insertItemBack(deq);
				break;
			case "2":
				insertItemFront(deq);
				break;
			case "3":
				removeFront(deq);
				break;
			case "4":
				removeBack(deq);
				break;
			case "5":
				displayFront(deq);
				break;
			case "6":
				displayBack(deq);
				break;
			case "7":
				clearDeq(deq);
				break;
			case "8":
				displayContent(deq);
				break;
			case "9": {
				repeat = false;
				System.out.println("Exiting program...Good Bye");
				break;
			}
			}
		} while (repeat);
	}

	private static void insertItemBack(Deq<String> deq2) {
		try {
			System.out.print("Item to insert at back: ");
			String newItem = stdin.readLine();
			deq2.enqueue(newItem);
			System.out.print(newItem + " inserted at back position. \n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void insertItemFront(Deq<String> deq2) {
		try {
			System.out.print("Item to insert at front: ");
			String newItem = stdin.readLine();
			deq2.enqueueFirst(newItem);
			System.out.print(newItem + " inserted at front position. \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void removeFront(Deq<String> deq2) {
		if (deq2.isEmpty()) {
			System.out.println("Queue is Empty.");
		} else {
			deq2.dequeue();
		}

	}

	private static void removeBack(Deq<String> deq2) {
		if (deq2.isEmpty()) {
			System.out.println("Queue is Empty.");
		} else {
			System.out.println(deq2.dequeueLast() + " removed.");

		}

	}

	private static void displayFront(Deq<String> deq2) {
		if (deq2.isEmpty()) {
			System.out.println("Deq is Empty.");
		} else {
			System.out.println("The front item in Deq is " + deq2.peek());
		}
	}

	private static void displayBack(Deq<String> deq2) {
		if (deq2.isEmpty()) {
			System.out.println("Deq is Empty");
		} else {
			System.out.println("The last item in Deq is " + deq2.peekLast());
		}
	}

	private static void displayContent(Deq<String> deq2) {
		if (!deq2.isEmpty()) {
			System.out.println(deq2.toString());
		} else {
			System.out.println("There is nothing in the queue");
		}
	}

	private static void clearDeq(Deq<String> deq2) {
		if (!deq2.isEmpty()) {
			deq2.dequeueAll();
			System.out.printf("Removed all items from queue.\n");
		} else {
			System.out.print("Nothing to remove \n");
		}
	}
}
