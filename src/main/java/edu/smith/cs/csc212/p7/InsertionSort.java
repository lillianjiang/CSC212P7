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
	 * O(n log n)
	 */
	public static void insertionSort(List<Integer> input) {
		List<Integer> sorted = new ArrayList<>();
		sorted.add(input.remove(0));
		while(input.size() != 0) {
			int num = input.remove(0);
			
			int index = binarysearch(num, sorted);
			sorted.add(index, num);
			//System.out.println(sorted);
				
		}
		input.addAll(sorted);
		
	}
	/*
	 * this should take O(log(n))
	 */
	public static int binarysearch(int num, List<Integer> sorted) {
		int start = 0;
		int end = sorted.size();
		int mid = 0;
		while(end>start) {
			mid = (start+end)/2;
			if(sorted.get(mid) == num) {
				return mid;
			}
			else{
				if(sorted.get(mid) > num) 
					end = mid;     
				else
					start = mid+1;     
			}		
		}
		
		return start;
	}
	
	
}
