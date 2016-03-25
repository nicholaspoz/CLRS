package clrs.algorithms.orderstatistic;

import clrs.algorithms.utilities.DivideAndConquerHelper;

public class OrderedStatistic {

	/**
	 * Performs the average-case linear selection algorithm for finding the i'th
	 * greatest element of a[]
	 * 
	 * @param a
	 * @param i
	 * @return
	 */
	public int findDesiredElement(int[] a, int i) {
		// Validate input
		if (i > a.length || i < 0) {
			throw new IllegalArgumentException("index must be within the bounds of the array");
		}

		return randomizedSelect(a, 0, a.length - 1, i);
	}

	/**
	 * Partitions the array into two sub-arrays. Recursively searches the
	 * partition containing the desired element. Described in CLRS 9.2
	 * 
	 * @param a
	 *            the array to search
	 * @param p
	 *            the lower bound index of the sub array being selected
	 * @param r
	 *            the upper bound inded of the sub array being selected
	 * @param i
	 *            the index of the desired element
	 * @return the value of the index-ordered statistic
	 */
	private int randomizedSelect(int[] a, int p, int r, int i) {
		// Recursive Base Case: array of single element
		if (p == r) {
			return a[p];
		}

		// Partition
		int q = DivideAndConquerHelper.randomizedPartition(a, p, r);

		int k = q - p + 1;
		if (k == i) { // return the i'th element if found
			return a[q];
		} else if (i < k) { // If i < k, search the left sub array
			return randomizedSelect(a, p, q - 1, i);
		} else { // If i > k, search the right sub array
			return randomizedSelect(a, q + 1, r, i - k);
		}
	}

}
