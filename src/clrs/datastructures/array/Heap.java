package clrs.datastructures.array;

public class Heap {
	/*
	 * private int[] array; private int heapSize;
	 * 
	 * private Heap(int[] array, int heapSize) { this.array = array;
	 * this.heapSize = heapSize; }
	 * 
	 * public int getHeapSize() { return this.heapSize; }
	 * 
	 * public void incrementHeapSize() { this.heapSize++; }
	 * 
	 * public void decrementHeapSize() { this.heapSize--; }
	 * 
	 * public int[] getArray() { return this.array; }
	 */

	// -------------------------------
	// Static Max Heapifying Functions
	// -------------------------------

	/**
	 * Initializes a[] to a max heap by calling maxHeapify on all internal tree
	 * elements.
	 * 
	 * @param a
	 *            the array being sorted
	 */
	public static void /* Heap */ buildMaxHeap(int[] a) {
		int internal = (a.length - 1) / 2;

		for (int i = internal; i >= 0; i--) {
			maxHeapify(a, i, a.length - 1);
		}

		// return new Heap(a, a.length);
	}

	/**
	 * Performs recursive 'bubble-down' of a[i] in order to maintain the max
	 * heap property of a[i].
	 * 
	 * @param a
	 *            the array being sorted
	 * @param i
	 *            the index of the array to heapify
	 * @param heapEnd
	 *            the upper bound index of the sub array to treat as heap
	 */
	public static void maxHeapify(int[] a, int i, int heapEnd) {
		int left = leftChild(i);
		int right = rightChild(i);
		int largest;

		if (left <= heapEnd && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= heapEnd && a[right] > a[largest]) {
			largest = right;
		}

		if (largest != i) {
			// exchange a[i] and a[largest]
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;

			maxHeapify(a, largest, heapEnd);
		}
	}

	// -----------------------------
	// Max Priority Queue Operations
	// -----------------------------

	public static int heapMaximum(int[] heap) {
		return heap[0];
	}

	// TODO implement priority queue

	// ---------------
	// Heap Properties
	// ---------------

	public static int parent(int currIndex) {
		// Will this cause infinite loop?
		// if (currIndex == 0) {
		// return 0;
		// }
		return (currIndex - 1) / 2;
	}

	public static int leftChild(int currIndex) {
		return (2 * currIndex) + 1;
	}

	public static int rightChild(int currIndex) {
		return (2 * currIndex) + 2;
	}
}
