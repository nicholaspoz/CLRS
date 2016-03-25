

import java.util.ArrayList;
import java.util.List;

import clrs.algorithms.sorting.SortingAlgorithm;
import clrs.algorithms.sorting.linear.CountingSort;
import clrs.algorithms.sorting.nlogn.MergeSort;
import clrs.algorithms.sorting.nlogn.QuickSort;
import clrs.algorithms.sorting.nsquared.BubbleSort;
import clrs.algorithms.sorting.nsquared.InsertionSort;

public class Main {

	public static void main(String[] args) {
		final int n = 10000;
		List<SortingAlgorithm> algorithms = new ArrayList<SortingAlgorithm>();

		// O(n*n)
		algorithms.add(new BubbleSort(n));
		algorithms.add(new InsertionSort(n));
		// O(n*log(n))
		algorithms.add(new MergeSort(n));
		algorithms.add(new QuickSort(n));
		// O(n)
		algorithms.add(new CountingSort(n, 200));

		System.out.println("Running...");
		for (SortingAlgorithm alg : algorithms) {
			alg.runAlgorithm();
		}
	}

}
