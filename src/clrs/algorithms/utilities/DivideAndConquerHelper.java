package clrs.algorithms.utilities;

public class DivideAndConquerHelper {

	/**
	 * Partitions an array into two based on a randomly selected element.
	 * Described in CLRS 7.3
	 * 
	 * @param a
	 *            array being searched/sorted/etc.
	 * @param p
	 *            lower bound index of sub array to partition
	 * @param r
	 *            upper bound index of sub array to partition
	 * @return the index of the partitioned element
	 */
	public static int randomizedPartition(int[] a, int p, int r) {
		// Select random element in a[p..r] to partition and exchange with a[r]
		int randIndex = (int) (Math.random() * (r - p + 1)) + p;
		int temp = a[r];
		a[r] = a[randIndex];
		a[randIndex] = temp;

		// Access the partition value
		int part = a[r];

		// q tracks the last index less than the partition value
		int q = p - 1;
		for (int curr = p; curr <= r - 1; curr++) {
			if (a[curr] <= part) {
				// exchange q+1 and curr
				q++;
				temp = a[curr];
				a[curr] = a[q];
				a[q] = temp;
			}
		}

		// exchange q+1 and r
		q++;
		a[r] = a[q];
		a[q] = part;

		return q;
	}

}
