package clrs.algorithms.orderstatistic;

import java.util.Arrays;

import clrs.algorithm.Algorithm;
import clrs.algorithms.utilities.DivideAndConquerHelper;

public class OrderedStatistic extends Algorithm<Integer> {
	private int i, n;
	private int array[];

	public OrderedStatistic(int n, int i) {
		// Validate input
		if (i > n || i < 0) {
			throw new IllegalArgumentException("index must be within the bounds of the array");
		}
		this.n = n;
		this.i = i;
	}

	@Override
	public void initializeData() {
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 1000);// inclusive
		}

	}

	@Override
	public Integer run() {
		// Perform randomizedSelect on the entire array
		return randomizedSelect(array, 0, array.length - 1, i);
	}

	@Override
	public boolean verify(Integer data) {
		Arrays.sort(array);
		if (data != array[i - 1]) {
			return false;
		} else {
			return true;
		}
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
	public static int randomizedSelect(int[] a, int p, int r, int i) {
		// Recursive Base Case: array of single element
		if (p == r) {
			return a[p];
		}

		// Partition using randomizedPartition subroutine
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

	@Override
	public String toString() {
		return "OrderStatistic";
	}

}
