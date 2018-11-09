package edu.smith.cs.csc212.p7;

import java.util.ArrayList;

import java.util.List;

/**
 *
 * 
 */
public class MergeSort {
	
	/**
	 *MergeSort helps us to break down everything into one unit,
	 *after we hit one unit for all, stop the recursion and start to merge back(from the stack)
	 *
	 * @return merged sort parts
	 */
	public static List<Integer> recrusivemergeSort(List<Integer> input) {
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		if(input.size() > 1) {
			int mid = input.size()/2;
			left = recrusivemergeSort(input.subList(0,mid));
			right = recrusivemergeSort(input.subList(mid,input.size()));
			return merge(left, right);
		} else { 
			return input; }
	}
	/**
	 * After we break down the lists into one individual unit, Compare who is smaller, merge by order
	 *
	 */
	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		int p = 0;
		int q = 0;
		List<Integer> temp = new ArrayList<>();
		while(p<left.size() && q<right.size()) {
			if(left.get(p) <= right.get(q)) {
				temp.add(left.get(p));
				p++;
			}
			else {
				temp.add(right.get(q));
				q++;
			}
		}
		while (p<left.size()) {
			temp.add(left.get(p));
			p++;
		}
		while(q<right.size()) {
			temp.add(right.get(q));
			q++;
		}
		return temp;
	}
	
		
	}

	