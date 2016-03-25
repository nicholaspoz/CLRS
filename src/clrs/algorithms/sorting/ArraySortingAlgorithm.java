package clrs.algorithms.sorting;

public abstract class ArraySortingAlgorithm extends SortingAlgorithm {
	protected int[] array;

	public ArraySortingAlgorithm(int n) {
		super(n);
	}

	public ArraySortingAlgorithm(int n, int maxValue) {
		super(n, maxValue);
	}

	@Override
	public void initializeDataStructure() {
		array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * (maxValue + 1));// inclusive
		}
	}

}
