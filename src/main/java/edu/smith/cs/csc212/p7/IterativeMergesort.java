package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Iterative mergesort cited from:
 * https://www.geeksforgeeks.org/iterative-merge-sort/
 *
 */
public class IterativeMergesort {

	public static void Iterativemergesort(List<Integer> input) {
		int n = input.size() - 1;
		// For current size of input to
		// be merged curr_size varies from
		// 1 to n/2
		int curr_size;

		// For picking starting index of
		// left sublist to be merged
		int left_start;

		/**
		 * Merge sublist in bottom up manner. First merge sublist of size 1 to
		 * create sorted sublist of size 2, then merge sublist of size 2 to create
		 * sorted sublist of size 4, and so on.
		 * 
		 */
		for (curr_size = 1; curr_size <= n; curr_size *= 2) {
			// Pick starting point of different
			// sublist of current size
			for (left_start = 0; left_start < n; left_start += 2 * curr_size) {
				// Find ending point of left
				// sublist. mid+1 is starting
				// point of right
				int mid = left_start + curr_size - 1;

				int right_end = Math.min(left_start + 2 * curr_size - 1, n);

				// Merge left and right sublists
				merge(input, left_start, mid, right_end);
			}

		}

	}

		/*
		 * merge the two lists
		 */
		private static void merge(List<Integer> input, int l, int m, int r) {
			List<Integer> left = new ArrayList<>();
			List<Integer> right = new ArrayList<>();
	
			for (int i = l; i <= m; i++) {
				left.add(input.get(i));
			}
			for (int i = m + 1; i <= r; i++) {
				right.add(input.get(i));
			}
	
			int il = 0;
	
			int ir = 0;
	
			int indexI = l;
			
			//compare and putback
			while (il < left.size() && ir < right.size()) {
	
				if (left.get(il) <= right.get(ir)) {
					input.set(indexI, left.get(il));
					il++;
				} else {
					input.set(indexI, right.get(ir));
					ir++;
				}
				indexI++;
			}
	
			// add the whole left/right list if one list is longer than the other.
			while (il < left.size()) {
				input.set(indexI, left.get(il));
				indexI++;
				il++;
			}
			while (ir < right.size()) {
				input.set(indexI, right.get(ir));
				ir++;
				indexI++;
			}
		}
	}
