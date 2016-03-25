package clrs.algorithms.sorting;

public class HeapSort extends ArraySortingAlgorithm {

	public HeapSort(int n) {
		super(n);
	}

	@Override
	public int[] sort() {

		buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			// exchange a[0] and a[i]
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;

			// Perform maxHeapify on shorter heap
			maxHeapify(array, 0, i - 1);
		}

		return array;
	}

	private void buildMaxHeap(int[] a) {
		int internal = (a.length - 1) / 2;

		for (int i = internal; i >= 0; i--) {
			maxHeapify(a, i, a.length - 1);
		}
	}

	private void maxHeapify(int[] a, int i, int heapEnd) {
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
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			maxHeapify(a, largest, heapEnd);
		}
	}

	private int parent(int currIndex) {
		// Will this cause some infinite loop?
		// if (currIndex == 0) {
		// return 0;
		// }
		return (currIndex - 1) / 2;
	}

	private int leftChild(int currIndex) {
		return (2 * currIndex) + 1;
	}

	private int rightChild(int currIndex) {
		return (2 * currIndex) + 2;
	}

	@Override
	public String toString() {
		return "HeapSort";
	}
}
