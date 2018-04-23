/*
 * Purpose: Data Structure and Algorithms Lab 9 Problem 1 REDO
 * Status: Complete and thoroughly tested
 * Last update: 04/16/18
 * Submitted:  04/16/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.04.16
 */
public class Sorts {
	public void bubbleSort(int[] array) {
		int passes = array.length - 1;
		int swaps = 0;
		int comparisons = 0;
		int iterations = array.length;
		while (iterations >= 1) {
			for (int index = 0; index < passes; index++) {
				if (array[index] > array[index + 1]) { // swap
					int temp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = temp;
					swaps++;
				}
				comparisons++;
			}
			passes--;
			iterations--;
		}
		System.out.println("Sorted data:");
		toString(array);
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps: " + swaps);
	}

	public void improvedBubbleSort(int[] array) {
		int passes = array.length - 1;
		int swaps = 0;
		int comparisons = 0;
		boolean swap = true;
		int iterations = array.length;
		while (iterations >= 1) {
			for (int index = 0; index < passes; index++) {
				if (array[index] > array[index + 1]) { // swap
					swap = false;
					int temp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = temp;
					swaps++;
				}
				comparisons++;
			}
			if (swap) {
				iterations = 1;
			} else {
				swap = true;
			}
			passes--;
			iterations--;
		}
		System.out.println("Sorted data:");
		toString(array);
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps: " + swaps);
	}

	public void selectionSort(int[] array) { // minimum number moves to front
		int passes = array.length - 1;
		int swap = 0;
		int comparisons = 0;
		int min = 0;
		boolean swapped = false;
		for (int idx = 0; idx < passes; idx++) {
			min = idx;
			for (int index = passes; index > idx; index--) { // compare values
				comparisons++;
				if (array[index] < array[min]) {
					min = index;
					swapped = true;
				}
			} // swap
			if (swapped) {
				int temp = array[min];
				array[min] = array[idx];
				array[idx] = temp;
				swap++;
			}
		}
		System.out.println("Sorted data:");
		toString(array);
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps: " + swap);
	}

	public void improvedSelectionSort(int[] array) { //REDO
		int passes = array.length;
		int swap = 0;
		int comparisons = 0;
		int min = 0;
		for (int idx = 0; idx < passes - 1; idx++) {
			comparisons++;
			min = idx;
			for (int index = idx + 1; index < passes; index++) { // compare values
				comparisons++;
				if (array[index] < array[min]) {
					comparisons++;
					min = index;
				}
			} // swap
			if(min < array[idx]) {
				int temp = array[min];
				array[min] = array[idx];
				array[idx] = temp;
				swap++;
				comparisons++;
			}
		}
		comparisons++;
		System.out.println("Sorted data:");
		toString(array);
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps: " + swap);
	}

	public void insertionSort(int[] array) {
		int length = array.length;
		int item = 0;
		int pos = 0;
		int swap = 0;
		int comparisons = 0;
		for (int i = 1; i < length; i++) {
			item = array[i];
			pos = i;
			while (pos > 0 && array[pos - 1] > item) {
				comparisons++;
				array[pos] = array[pos - 1];
				pos--;
			}
			array[pos] = item;
			swap++;
		}
		System.out.println("Sorted data:");
		toString(array);
		System.out.println("Number of comparisons: " + comparisons);
		System.out.println("Number of swaps: " + swap);
	}

	public void toString(int[] array) {
		String s = "";
		for (int i = 0; i < array.length; i++) {
			s += array[i] + " ";
		}
		System.out.println(s);
	}
}
