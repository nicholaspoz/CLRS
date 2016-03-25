package clrs.algorithms.sorting;

public class QuickSort extends ArraySortingAlgorithm {

	public QuickSort(int n) {
		super(n);
	}

	@Override
	public int[] sort() {
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
		int div = partitionClrs(a, p, q);
		quickSort(a, p, div - 1);
		quickSort(a, div + 1, q);
	}

	/**
	 * Partitioning algorithm as explained in CLRS chapter 7
	 * 
	 * @param a
	 *            array being sorted
	 * @param p
	 *            lower bound index of sub array to partition
	 * @param q
	 *            upper bound index of sub array to partition
	 * @return the index of the partitioned element
	 */
	private int partitionClrs(int[] a, int p, int q) {
		int part = a[q];

		int temp, i = p - 1;
		for (int j = p; j <= q - 1; j++) {
			if (a[j] <= part) {
				// exchange i+1 and j
				temp = a[j];
				a[j] = a[++i];
				a[i] = temp;
			}
		}

		// exchange i+1 and q
		a[q] = a[++i];
		a[i] = part;

		return i;
	}

	// /**
	// * Partitioning algorithm selects the q-th element as the partition and
	// * swaps large elements to the left with small elements one the right.
	// *
	// * @param a
	// * array being sorted
	// * @param p
	// * lower bound index of sub array to partition
	// * @param q
	// * upper bound index of sub array to partition
	// * @return the index of the partitioned element
	// */
	// private int partitionOther(int[] a, int p, int q) {
	// int part = a[q];
	//
	// int i = p;
	// int j = q - 1;
	// while (i <= j) {
	// if (a[i] > part) {
	// a[j + 1] = a[i];
	// a[i] = a[j];
	// j--;
	// } else {
	// i++;
	// }
	// }
	// a[i] = part;
	// return i;
	// }

	@Override
	public String toString() {
		return "QuickSort";
	}

}
