import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverSLStack {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StackSLS<String> stack = new StackSLS<String>();

	public static void main(String[] args) {
		boolean repeat = true;
		String option = "";
		System.out.print("Select from the following menu:\n" + "\t1. Push item to stack.\n"
				+ "\t2. Pop item from stack.\n" + "\t3. Display top item from stack.\n"
				+ "\t4. Display items in stack.\n" + "\t5. Clear stack\n" + "\t6. Exit.\n");

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
				pushItem(stack);
				break;
			case "2":
				popTop(stack);
				break;
			case "3":
				displayItem(stack);
				break;
			case "4":
				printContent(stack);
				break;
			case "5":
				popAll(stack);
				break;
			case "6": {
				repeat = false;
				System.out.println("Exiting program...Good Bye");
			}
				break;
			}
		} while (repeat);
	}

	private static void printContent(StackSLS<String> stackS) {
		if (!stackS.isEmpty()) {
			System.out.println(stackS.toString());
		} else {
			System.out.println("There is nothing in the stack");
		}
	}

	private static void popAll(StackSLS<String> stackS) {
		if (!stackS.isEmpty()) {
			stackS.popAll();
			System.out.println("Cleared Stack entries");
		} else {
			System.out.println("Nothing to remove");
		}
	}

	private static void displayItem(StackSLS<String> stackS) {
		if (stackS.isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			System.out.printf(stackS.peek(), "is at the top.");
		}
	}

	private static void popTop(StackSLS<String> stackS) {
		if (stack.isEmpty()) {
			System.out.println("The stack is empty");
		} else {
			System.out.println(stackS.pop() + " has been removed");
		}
	}

	static void pushItem(StackSLS<String> stack2) {
		System.out.println("You are now inserting an item onto the stack.");
		System.out.print("\tEnter item: ");
		try {
			String item = stdin.readLine().trim();
			stack2.push(item);
			System.out.printf("added item: %s to the stack \n", item);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
