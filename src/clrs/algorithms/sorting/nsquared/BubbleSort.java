package clrs.algorithms.sorting.nsquared;

import clrs.algorithms.sorting.ArraySortingAlgorithm;

public class BubbleSort extends ArraySortingAlgorithm {

	public BubbleSort(int n) {
		super(n);
	}

	@Override
	public int[] sort() {
		// shrink the array from length to 2 elements
		for (int i = array.length - 1; i > 0; i--) {
			int j = 0;
			while (j < i) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				j++;
			}
		}
		
		return array;
	}

	@Override
	public String toString() {
		return "BubbleSort";
	}
}
