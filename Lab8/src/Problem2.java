import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 2 REDO
 * Status: Complete and thoroughly tested
 * Last update: 04/09/18
 * Submitted:  04/10/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.04.09
 */
public class Problem2 {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static ListArrayBasedPlus<Integer> list = new ListArrayBasedPlus<Integer>();
	static boolean repeat = true;

	public static void main(String[] args) {
		String option = "";
		do {
			System.out.println("Select from the following menu: ");
			System.out.println("    1. Insert item to ordered list.");
			System.out.println("    2. Remove item from list.");
			System.out.println("    3. Get item from list.");
			System.out.println("    4. Search for a specified item in the list."); // new
			System.out.println("    5. Clear list");
			System.out.println("    6. Print size and content of list.");
			System.out.println("    7. Exit program.");
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
				retrieveItem();
				break;
			case "4":
				search();
				break;
			case "5":
				clearList();
				break;
			case "6":
				print();
				break;
			case "7":
				kill();
				break;
			}
		} while (repeat);
	}

	private static void search() {
		if (!list.isEmpty()) {
			System.out.print("Specify item to search for: ");
			try {
				int item = Integer.parseInt(stdin.readLine().trim());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("List is empty");
		}

	}

	private static void kill() {
		repeat = false;
		System.out.println("Exiting program...Good Bye");
	}

	private static void print() {
		if (!list.isEmpty()) {
			System.out.println("List of size " + list.size() + " has the following items : " + list.toString() + ".");
		} else {
			System.out.println("List is empty");
		}
	}

	private static void clearList() {
		if (!list.isEmpty()) {
			list.removeAll();
		}
	}

	private static void retrieveItem() {
		System.out.print("Enter position to retrieve item from : ");
		try {
			int pos = Integer.parseInt(stdin.readLine().trim());
			if (pos >= 0 && pos <= list.size()) {
				System.out.println("Item " + list.get(pos) + " retrieved from position " + pos + " in the list.");
			} else {
				System.out.println("Position specified is out of range!");
			}
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

	/**
	 * For this method I had used method 3 Implementation B to solve this problem.
	 */
	private static void insertInto() { //redo
		System.out.println("You are now inserting an item into the list.");
		System.out.print("Enter item: ");
		try {
			int item = Integer.parseInt(stdin.readLine().trim());
			if(!list.isEmpty()) {
				int search = searchItem(item);
				list.add(search, item);
				System.out.println("Added: " + item + " to list at index " + search + ".");
			} else {
				list.add(0, item);
				System.out.println("Added: " + item + " to list at index 0.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int searchItem(int item) { //redo
		boolean stop = false;
		int i = 0;
		int ret = 0;
		while (!stop && i < list.size()) { //advance
			int listItem = list.get(i);
			if (item > listItem) {
				i++;
			} else if(item == listItem) { //success
				ret = i;
				stop = true;
			} else { //unsuccessful
				ret = i;
				stop = true;
			}
		}
		if(ret == 0) {
			ret = i;
		}
		return ret;
	}
}