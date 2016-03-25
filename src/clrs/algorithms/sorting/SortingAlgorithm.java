package clrs.algorithms.sorting;

public abstract class SortingAlgorithm {
	protected final static int DEFAULT_MAX_VALUE = 1000;

	protected final int n;
	protected final int maxValue;

	public SortingAlgorithm(int n) {
		this.n = n;
		this.maxValue = DEFAULT_MAX_VALUE;
	}

	public SortingAlgorithm(int n, int maxValue) {
		this.n = n;
		this.maxValue = maxValue;
	}

	/**
	 * perform the sorting operation and return a sorted array
	 * 
	 * @return the result of the algorithm represented as an array
	 */
	public abstract int[] sort();

	/**
	 * Build the necessary set of randomized values for the algorithm
	 */
	public abstract void initializeDataStructure();

	public void runAlgorithm() {
		System.out.print(this.toString() + ": ");

		initializeDataStructure();
		long startTime = System.nanoTime();
		int[] a = sort();
		double elapsedSeconds = (double) (System.nanoTime() - startTime) / 1000000000.0;

		// Verify is sorted and print results
		String message = "SUCCEEDED";
		int curr = a[0];
		for (int i = 1; i < a.length; i++) {
			if (curr > a[i]) {
				message = "FAILED";
				break;
			}
			curr = a[i];
		}

		System.out.println(message + ", " + elapsedSeconds);

	}

}
