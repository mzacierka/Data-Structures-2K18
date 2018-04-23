import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 03/28/18
 * Submitted:  03/29/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.03.28
 */
public class DriverAOSL {

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static AscendinglyOrderedStringList list = new AscendinglyOrderedStringList();
	static boolean repeat = true;

	public static void main(String[] args) {
		String option = "";
		do {
			System.out.println("Select from the following menu: ");
			System.out.println("    1. Insert specified item into list.");
			System.out.println("    2. Remove item in specified position in the list.");
			System.out.println("    3. Search list for specified item.");
			System.out.println("    4. Clear list");
			System.out.println("    5. Print content of list.");
			System.out.println("    6. Exit program.");
			System.out.print("Make your menu selection now: \n");
			try {
				option = stdin.readLine().toString();
				System.out.println(option);
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (option) {
			case "1":
				insertInto();
				break;
			case "2":
				removeFromList();
				break;
			case "3":
				searchItem();
				break;
			case "4":
				clearList();
				break;
			case "5":
				printList();
				break;
			case "6":
				kill();
				break;
			}
		} while (repeat);
	}

	private static void insertInto() {
		try {
			System.out.print("You are now inserting an item into the list \n\t Enter item:");
			String item = stdin.readLine().trim();
			list.add(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void removeFromList() {
		System.out.print("Enter position to remove item from : ");
		try {
			int pos = Integer.parseInt(stdin.readLine().trim());
			if (pos < 0 || pos > list.size() - 1) {
				System.out.println("Position specified is out of range!");
			} else {
				System.out.println("Item " + list.get(pos) + " removed from position " + pos + " in the list.");
				list.remove(pos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void searchItem() {
		if(!list.isEmpty()) {
			try {
				int result = list.search(stdin.readLine().trim());
				if(result != 0) {
					System.out.println("Item is at index " + result);
				} else {
					System.out.println("List does not contain item. (" + result + ")");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void clearList() {
		if (!list.isEmpty()) {
			list.clear();
		}
	}

	private static void printList() {
		if (!list.isEmpty()) {
			System.out.println("List of size " + list.size() + " has the following items : " + list.toString() + ".");
		} else {
			System.out.println("List is empty");
		}
		
	}

	private static void kill() {
		repeat = false;
		System.out.println("Exiting Program. bye.");
	}

}
