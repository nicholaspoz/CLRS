package clrs.algorithm;

public abstract class Algorithm<T> {

	/**
	 * Initialize any data structures required by the algorithm
	 */
	public abstract void initializeData();

	/**
	 * perform the algorithm and return the result
	 * 
	 * @return the result of the algorithm represented
	 */
	public abstract T run();

	/**
	 * Verify that the algorithm performed correctly
	 * 
	 * @param data
	 * @return
	 */
	public abstract boolean verify(T data);

	public void runAlgorithm() {
		System.out.print(this.toString() + ": ");

		initializeData();
		long startTime = System.nanoTime();
		T data = run();
		double elapsedSeconds = (double) (System.nanoTime() - startTime) / 1000000000.0;

		String message = verify(data) ? "SUCCEEDED" : "FAILED";

		System.out.println(message + ", " + elapsedSeconds);

	}

}
