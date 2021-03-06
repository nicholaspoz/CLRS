package clrs.algorithms.sorting;

public class InsertionSort extends SortingAlgorithm {
	public InsertionSort(int n) {
		super(n);
	}

	@Override
	public int[] run() {
		// Iterate from 1 to (n-1)
		for (int i = 1; i < array.length; i++) {
			// grab the ith element
			int temp = array[i];
			// look to the left (sorted)
			int j = i - 1;

			// Loop until end of array or until smaller element is found
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			// Insert the element in its sorted location
			array[j + 1] = temp;
		}
		
		return array;
	}

	@Override
	public String toString() {
		return "InsertionSort";
	}

}
