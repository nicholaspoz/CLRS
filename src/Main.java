
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clrs.algorithms.orderstatistic.OrderedStatistic;
import clrs.algorithms.sorting.BubbleSort;
import clrs.algorithms.sorting.CountingSort;
import clrs.algorithms.sorting.HeapSort;
import clrs.algorithms.sorting.InsertionSort;
import clrs.algorithms.sorting.MergeSort;
import clrs.algorithms.sorting.QuickSort;
import clrs.algorithms.sorting.SortingAlgorithm;

public class Main {
	public static void main(String[] args) {

		System.out.println("Running Sorting Algorithms...");
		runSortingAlgorithms();

		System.out.println("\nRunning ordered statistic...");
		runOrderStatistic();
	}

	private static void runSortingAlgorithms() {
		final int n = 10000;
		List<SortingAlgorithm> algorithms = new ArrayList<SortingAlgorithm>();

		// O(n*n)
		algorithms.add(new BubbleSort(n));
		algorithms.add(new InsertionSort(n));

		// O(n*log(n))
		algorithms.add(new MergeSort(n));
		algorithms.add(new QuickSort(n));
		algorithms.add(new HeapSort(n));

		// O(n)
		algorithms.add(new CountingSort(n, 200));

		for (SortingAlgorithm alg : algorithms) {
			alg.runAlgorithm();
		}
	}

	private static void runOrderStatistic() {
		final int n = 100, k = 28;
		new OrderedStatistic(n, k).runAlgorithm();;

	}

}
