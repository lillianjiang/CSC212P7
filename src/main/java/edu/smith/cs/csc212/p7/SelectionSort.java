package edu.smith.cs.csc212.p7;

import java.util.List;

/**
 * SelectionSort is a simple sort that is O(n^2).
 * @author lillian
 *
 */
public class SelectionSort {

	/**
	 * Swap items in a list!
	 * @param items the list.
	 * @param i swap the item at this index with the one at j.
	 * @param j swap the item at this index with the one at i.
	 */
	public static void swap(List<Integer> items, int i, int j) {
		assert (i != j);
		int tmp = items.get(i);
		items.set(i, items.get(j));
		items.set(j, tmp);
	}

	/**
	 * selectionSort is one of the simplest sorting method. 
	 * It process data more efficiently than bubble sort by avoiding too much swap method.
	 * Since it is a nested for-loop structure, the big O is O(n^2).
	 * Things need to notice:
	 * i,j,min is all index, not the number represented. 
	 */
	public static void selectionSort(List<Integer> input) {
		int i, j;
		int min;
		for (j = 0; j < input.size() - 1; j++) {
			min = j;
			for (i = j + 1; i < input.size(); i++) {
				if (input.get(min) > input.get(i)) {
					min = i;
				}
			}
			if (input.get(min) != input.get(j)) {
				swap(input, j, min);
			}
		}
	}
}
