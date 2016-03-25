package clrs.algorithms.sorting;

import clrs.algorithms.Algorithm;

public abstract class SortingAlgorithm extends Algorithm<int[]> {
	protected final static int DEFAULT_MAX_VALUE = 1000;

	protected final int n;
	protected final int maxValue;
	protected int[] array;

	public SortingAlgorithm(int n) {
		this.n = n;
		this.maxValue = DEFAULT_MAX_VALUE;
	}

	public SortingAlgorithm(int n, int maxValue) {
		this.n = n;
		this.maxValue = maxValue;
	}

	@Override
	public void initializeData() {
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * (maxValue + 1));// inclusive
		}
	}

	@Override
	public boolean verify(int[] data) {
		int curr = data[0];
		for (int i = 1; i < data.length; i++) {
			if (curr > data[i]) {
				return false;
			}
			curr = data[i];
		}
		return true;
	}

}
