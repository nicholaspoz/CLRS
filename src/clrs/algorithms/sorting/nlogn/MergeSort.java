package clrs.algorithms.sorting.nlogn;

import clrs.algorithms.sorting.ArraySortingAlgorithm;

public class MergeSort extends ArraySortingAlgorithm {

	public MergeSort(int n) {
		super(n);
	}

	@Override
	public int[] sort() {
		mergeSort(array, 0, array.length - 1);
		return array;
	}

	/**
	 * Recursive helper method for performing mergesort
	 * 
	 * @param a
	 *            array being sorted
	 * @param p
	 *            lower bound index of sub array to sort
	 * @param q
	 *            upper bound index of sub array to sort
	 */
	private void mergeSort(int[] a, int p, int q) {
		// Base Case - cannot divide any more
		if (p >= q) {
			return;
		}
		// Split into 2 sub arrays
		int div = (p + q) / 2;

		mergeSort(a, p, div);
		mergeSort(a, div + 1, q);
		merge(a, p, div, q);
	}

	/**
	 * Merges two sorted sub arrays a[p - q] and a[q+1 - r] into one sorted list
	 * in a[p - r ]
	 * 
	 * @param a
	 *            array being sorted
	 * @param x
	 *            lower bound index of left sub array
	 * @param y
	 *            partition index/upper bound of left sub array
	 * @param z
	 *            upper bound of right sub array
	 */
	private void merge(int[] a, int x, int y, int z) {
		int i, j, k;

		// Create left array
		int l1 = y - x + 1;
		int L[] = new int[l1 + 1];
		for (i = 0; i < l1; i++) {
			L[i] = a[x + i];
		}
		L[l1] = Integer.MAX_VALUE; // Sentinal placeholder

		// Create right array
		int l2 = z - (y + 1) + 1;
		int R[] = new int[l2 + 1];
		for (j = 0; j < l2; j++) {
			R[j] = a[y + 1 + j];
		}
		R[l2] = Integer.MAX_VALUE; // Sentinel placeholder

		//
		i = 0;
		j = 0;
		for (k = x; k <= z; k++) {
			if (L[i] < R[j]) {
				a[k] = L[i++];
			} else {
				a[k] = R[j++];
			}
		}

	}

	@Override
	public String toString() {
		return "MergeSort";
	}

}
