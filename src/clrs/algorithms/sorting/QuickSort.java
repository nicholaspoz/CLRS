package clrs.algorithms.sorting;

import clrs.algorithms.utilities.DivideAndConquerHelper;

public class QuickSort extends SortingAlgorithm {

	public QuickSort(int n) {
		super(n);
	}

	@Override
	public int[] run() {
		// perform quicksort on the entire array
		quickSort(array, 0, array.length - 1);

		return array;
	}

	/**
	 * Recursive helper method to perform quicksort
	 * 
	 * @param a
	 *            array being sorted
	 * @param p
	 *            lower bound index of sub array to sort
	 * @param q
	 *            upper bound index of sub array to sort
	 */
	public void quickSort(int[] a, int p, int q) {
		// Recursive Base Case: empty array
		if (p >= q) {
			return;
		}
		int div = DivideAndConquerHelper.randomizedPartition(a, p, q);
		quickSort(a, p, div - 1);
		quickSort(a, div + 1, q);
	}

	@Override
	public String toString() {
		return "QuickSort";
	}

}
