import java.util.Arrays;

public class tester {

	public static void main(String[] args) {
		int[] list = {1,2,3,4,5};
		System.out.println(Arrays.toString(list));
		System.out.println();
		selectionSort(list);
		System.out.println(Arrays.toString(list));
		
		
	}
	
	static void selectionSort(int[] array) {
		int comp = 0;
		int swap = 0;
		int i, j, min, minIndex, temp = 0;
		for(i = 0; i < array.length; i++) {
			comp++;
			min = array[i];
			minIndex = i;
			for(j = i + 1; j < array.length; j++) {
				comp++;
				if(array[j] < min) {
					comp++;
					min = array[j];
					minIndex = j;
				}
			}
			if(min < array[i]) {
				temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
				swap++;
			}
		}
		System.out.println("Comp: " + comp);
		System.out.println("Swap: " + swap);
	}

}
