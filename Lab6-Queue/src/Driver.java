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
public class Driver {
	static RAQueue<String> queue = new RAQueue<String>();
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		boolean repeat = true;
		String option = "";
		System.out.print("Select from the following menu:\n" + "\t1. Insert item at back of queue.\n"
				+ "\t2. Remove item from front of queue.\n" + "\t3. Display front item of queue.\n"
				+ "\t4. Clear queue.\n" + "\t5. Display content of queue\n" + "\t6. Exit.\n");

		do {

			System.out.print("Make your selection now: ");
			try {
				option = stdin.readLine().trim();
				System.out.println(option);
			} catch (IOException e) {
				e.printStackTrace();
			}

			switch (option) {
			case "1":
				enqueueItem(queue);
				break;
			case "2":
				dequeueItem(queue);
				break;
			case "3":
				displayItem(queue);
				break;
			case "4":
				clearQueue(queue);
				break;
			case "5":
				displayContent(queue);
				break;
			case "6": {
				repeat = false;
				System.out.println("Exiting program...Good Bye");
			}
				break;
			}
		} while (repeat);
	}

	private static void displayContent(RAQueue<String> queue2) {
		if (!queue2.isEmpty()) {
			System.out.println(queue2.toString());
		} else {
			System.out.println("There is nothing in the queue");
		}
	}

	private static void clearQueue(RAQueue<String> queue2) {
		if (!queue2.isEmpty()) {
			queue2.dequeueAll();
			System.out.printf("Removed all items from queue.");
		} else {
			System.out.print("Nothing to remove \n");
		}
	}

	private static void displayItem(RAQueue<String> queue2) {
		if (queue2.isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			System.out.println(queue2.peek());
		}
	}

	private static void dequeueItem(RAQueue<String> queue2) {
		if (queue2.isEmpty()) {
			System.out.println("The Queue is empty");
		} else {
			System.out.println(queue2.dequeue() + " has been removed");
		}
	}

	static void enqueueItem(RAQueue<String> queue2) {
		System.out.println("You are now inserting an item.");
		System.out.print("\tEnter item: ");
		try {
			String item = stdin.readLine().trim();
			queue2.enqueue(item);
			System.out.printf("added item: %s to the queue \n", item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
