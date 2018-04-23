/*
 * Purpose: Data Structure and Algorithms Lab 10 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 04/12/18
 * Submitted:  04/12/18
 * Comment: test suite and sample run attached
 * @author: Michael Zacierka
 * @version: 2018.04.12
 */
public class SortsImproved {
	static int comparisons = 0;
	public static void main(String[] args) {
		String ms = "";
		int[] array = { 11, 1, 14, 14, 12, 9, 5, 3, 8, 7, 15, 10, 2, 6, 4, 13 };
		System.out.println("Quick Sort");
		for (int i : array) {
			ms += i + " ";
		}
		System.out.println("Input: " + ms);
		rQuickSort(array, 0, array.length - 1);
		ms = "";
		for (int i : array) {
			ms += i + " ";
		}
		System.out.println("Sorted: " + ms);
		System.out.println("# of Comparisons: " + comparisons);
		comparisons = 0;
		System.out.println("------------------------------------");
		int[] marray = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		ms = "";
		System.out.println("Merge Sort");
		for (int i : marray) {
			ms += i + " ";
		}
		System.out.println("Input: " + ms);
		iMergeSort(marray);
		ms = "";
		for (int i : marray) {
			ms += i + " ";
		}
		System.out.println("Sorted: " + ms);
		System.out.println("# of Comparisons: " + comparisons);
	}

	static void rQuickSort(int[] array, int low, int high) {
		if (low < high + 1) {
			int pivot = (low + high) / 2;
			int r = partition(array, low, high, pivot);
			rQuickSort(array, low, r - 1);
			rQuickSort(array, r + 1, high);
		}

	}

	static int partition(int[] array, int low, int high, int pivot) {
		swap(array, low, pivot);
		int left = low + 1;
		for (int i = left; i <= high; i++) {
			if (array[i] < array[low]) {
				comparisons++;
				swap(array, i, left++);
			}
		}
		swap(array, low, left - 1);
		return left - 1;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static void iMergeSort(int[] array) {
		int length = array.length;
		for (int i = 2; i < 2 * length; i = i * 2) {
			for (int j = 0; j < length; j = j + i) {
				int low = j;
				int mid = j + i / 2 - 1;
				int high = j + i - 1;
				if (mid >= length) {
					mid = length - 1;
					comparisons++;
				}
				if (high >= length) {
					high = length - 1;
					comparisons++;
				}
				merge(array, low, mid, high);
			}
		}
	}

	static void merge(int[] array, int low, int mid, int high) {
		int[] temp = new int[mid - low + 1];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = array[low + i];
		}
		int i = 0, j = mid + 1, curr = low;
		while (i < temp.length && j <= high) {
			comparisons++;
			if (temp[i] > array[j]) {
				comparisons++;
				array[curr++] = array[j++];
			} else {
				comparisons++;
				array[curr++] = temp[i++];
			}
		}
		for (int h = i; h < temp.length; h++) {
			comparisons++;
			array[curr++] = temp[h];
		}
	}

}
