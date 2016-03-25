package clrs.algorithms.sorting;

public class CountingSort extends ArraySortingAlgorithm {

	public CountingSort(int n, int maxValue) {
		super(n, maxValue);
	}

	@Override
	public int[] sort() {
		// initialize the counts array
		int counts[] = new int[maxValue + 1];
		for (int i = 0; i < counts.length; i++) {
			counts[i] = 0;
		}

		for (int i : array) {
			counts[i]++;
		}

		// counts[x] = y means that x occurs y times in a[]
		int aIndex = 0;
		for (int val = 0; val < counts.length; val++) {
			while (counts[val] > 0) {
				array[aIndex] = val;
				counts[val]--;
				aIndex++;
			}
		}
		return array;
	}

	@Override
	public String toString() {
		return "CountingSort";
	}

}
