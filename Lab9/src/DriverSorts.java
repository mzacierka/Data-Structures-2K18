import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 9 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 04/04/18
 * Submitted:  04/05/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.04.04
 */
public class DriverSorts {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static boolean repeat = true;
	static Sorts sort = new Sorts();

	public static void main(String[] args) {
		System.out.print("Enter number of integers: ");
		try {
			int input = Integer.parseInt(stdin.readLine().trim());
			System.out.println(input);
			int[] array = new int[input];
			for (int i = 1; i <= input; i++) {
				System.out.print("Enter integer number " + i + ": ");
				int in = Integer.parseInt(stdin.readLine().trim());
				System.out.println(in);
				array[i - 1] = in;
			}
			System.out.print(" \t1. Bubble Sort\n" + "\t2. Improved Bubble Sort\n" + "\t3. Selection Sort\n"
					+ "\t4. Improved Selection Sort\n" + "\t5. Insertion Sort\n" + "Make a selection: ");
			int selection = Integer.parseInt(stdin.readLine().trim());
			System.out.println(selection);
			switch (selection) {
			case 1:
				System.out.println("Input data:");
				sort.toString(array);
				System.out.println("--Bubble Sort--");
				sort.bubbleSort(array);
				break;
			case 2:
				System.out.println("Input data:");
				sort.toString(array);
				System.out.println("--Improved Bubble Sort--");
				sort.improvedBubbleSort(array);
				break;
			case 3:
				System.out.println("Input data:");
				sort.toString(array);
				System.out.println("--Selection Sort--");
				sort.selectionSort(array);
				break;
			case 4:
				System.out.println("Input data:");
				sort.toString(array);
				System.out.println("--Improved Selection Sort--");
				sort.improvedSelectionSort(array);
				break;
			case 5:
				System.out.println("Input data:");
				sort.toString(array);
				System.out.println("--Insertion Sort--");
				sort.insertionSort(array);
				break;
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
