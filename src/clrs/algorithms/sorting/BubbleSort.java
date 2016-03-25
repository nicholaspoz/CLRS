package clrs.algorithms.sorting;

public class BubbleSort extends SortingAlgorithm {

	public BubbleSort(int n) {
		super(n);
	}

	@Override
	public int[] run() {
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
