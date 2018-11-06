package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

/**
 * InsertionSort 
 * @author Lillian
 *
 */
public class InsertionSort {

	/**
	 * Swap items in a list!
	 * @param items the list.
	 * @param i swap the item at this index with the one at j.
	 * @param j swap the item at this index with the one at i.
	 */
	public static void swap(List<Integer> items, int i, int j) {
		assert(i != j);
		int tmp = items.get(i);
		items.set(i,  items.get(j));
		items.set(j, tmp);
	}
	
	/**
	 * 
	 */
	public static void insertionSort(List<Integer> input) {
		List<Integer> sorted = new ArrayList<>();
		sorted.add(input.remove(0));
		while(input.size() != 0) {
			int num = input.remove(0);
			
			int index = binarysearch(num, sorted);
			sorted.add(index, num);
				
		}
		for(int i = 0 ; i<sorted.size();i++)
			input.set(i, sorted.get(i));
		
	}
	public static int binarysearch(int num, List<Integer> sorted) {
		boolean found = false;
		int start = 0;
		int end = sorted.size();
		int mid = 0;
		while(end>start && ! found) {
			mid = (start+end)/2;
			if(sorted.get(mid) == num) {
				found = true;
			}
			else{
				if(sorted.get(mid) > num) 
					end = mid-1;     
				else if(sorted.get(mid) < num) 
					start = mid+1;     
			}		
		}
		if(found)
			return mid;
		else 
			return start;
	}
	
	
}
