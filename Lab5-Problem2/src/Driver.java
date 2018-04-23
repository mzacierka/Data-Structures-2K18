import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/20/18
 * Submitted:  02/20/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.02.20
 */
public class Driver {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StackSLS<Package> stack = new StackSLS<Package>();
	static StackSLS<Package> stackSample = new StackSLS<Package>();
	static int numPackages = 0;
	static double totalWeight = 0.0;
	static int numSamplePackages = 0;
	static double totalSampleWeight = 0.0;

	public static void main(String[] args) {
		boolean repeat = true;
		String option = "";
		System.out.print("Select from the following menu:\n" + "\t0. Exit.\n" + "\t1. Pick up an order.\n"
				+ "\t2. Drop off an order.\n" + "\t3. Display number of packages and weight of bag.\n"
				+ "\t4. Display number of items and weight of the bag of samples \n"
				+ "\t5. Enjoy an item from the bag of samples.\n" + "\t6. Empty the bag of samples. \n");

		do {

			System.out.print("You know the options.Make your menu selection now: ");
			try {
				option = stdin.readLine().toString();
				System.out.println(option);
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (option) {
			case "0":
				repeat = false;
				System.out.println("Bye");
				break;
			case "1":
				pickUpOrder();
				break;
			case "2":
				dropOffOrder();
				break;
			case "3":
				displayPandW();
				break;
			case "4":
				displaySample();
				break;
			case "5":
				enjoyItem();
				break;
			case "6":
				emptyBagSamples();
				break;
			}
		} while (repeat);
	}

	private static void pickUpOrder() {
		System.out.println("Please specify package info:");
		System.out.print("item name: ");
		try {
			String name = stdin.readLine();
			System.out.print("item weight: ");
			double weight = Double.parseDouble(stdin.readLine());
			System.out.print("number of items: ");
			int number = Integer.parseInt(stdin.readLine());
			System.out.print("sender: ");
			String sender = stdin.readLine();
			System.out.print("recepient: ");
			String recepient = stdin.readLine();
			if(number > 1) {
				name = name + "s";
			}
			System.out.println("A package of " + name + " each weighing " + weight + " lbs are now in the bag");
			stack.push(new Package(name, weight, number, sender, recepient));
			numPackages++;
			totalWeight += weight * number;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void dropOffOrder() {
		if (stack.isEmpty()) {
			System.out.println("No deliveries to process!");
		} else {
			System.out.printf("Here is your package " + stack.peek().getRecipient()
					+ ". May I please, please keep a sample(Y/N)?");
			try {
				String response = stdin.readLine();
				if (response.equalsIgnoreCase("y")) {
					Package p = stack.peek();
					String name = p.getName() + "";
					if (p.getNumber() > 1) {
						name = name + "s";
					}
					System.out.printf("Your package contains: %s %s each weighing %s lbs from %s to %s. \n",
							p.getNumber(), name, p.getWeight(), p.getSender(), p.getRecipient());
					System.out.println("  Thanks for letting me keep a " + p.getName());
					totalWeight -= p.getWeight() * p.getNumber();
					p.setNumber(1);
					stackSample.push(p);
					numSamplePackages++;
					totalSampleWeight += totalSampleWeight + p.getWeight();
					stack.pop();
					numPackages--;
				} else if (response.equalsIgnoreCase("n")) {
					Package p = stack.peek();
					numPackages--;
					totalWeight -= totalWeight - (p.getWeight() * p.getNumber());
					System.out.println("  Thanks anyway.");
					stack.pop();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void displayPandW() {
		System.out.println("Bag has " + numPackages + " packages and weighs " + totalWeight + " lbs.");
	}

	private static void displaySample() {
		System.out.printf("Sample bag has %s items and weighs %s lbs. \n", numSamplePackages, totalSampleWeight);
	}

	private static void enjoyItem() {
		if (stack.isEmpty()) {
			System.out.println("No samples to enjoy!");
		} else {
			System.out.printf("This %s is amazing. I love free stuff \n", stackSample.peek().getName());
		}

	}

	private static void emptyBagSamples() {
		if (stackSample.isEmpty()) {
			System.out.println("Sample bag is already empty.");
		} else {
			stackSample.popAll();
		}
	}

}
