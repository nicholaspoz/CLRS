package clrs.algorithms.sorting;

import clrs.datastructures.array.Heap;

/**
 * This algorithm utilizes the properties of a Heap. The Heap data structure and
 * its operations are implemented in the Heap class
 * 
 */
public class HeapSort extends SortingAlgorithm {

	public HeapSort(int n) {
		super(n);
	}

	@Override
	public int[] run() {

		Heap.buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			// exchange a[0] and a[i]
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;

			// Perform maxHeapify on shorter heap
			Heap.maxHeapify(array, 0, i - 1);
		}

		return array;
	}

	@Override
	public String toString() {
		return "HeapSort";
	}
}
