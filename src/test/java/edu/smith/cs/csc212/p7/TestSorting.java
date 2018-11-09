package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) > items.get(i+1)) {
				System.err.println("items out of order: "+items.get(i)+", "+items.get(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	//@override
	//for doublylinkedlist
	private static boolean checkSorted(DoublyLinkedList<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		sortMe.addAll(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}

	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));

		// For good measure, let's shuffle it and sort it again to see if that works,
		// too.
		Collections.shuffle(sortMe);
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}

	@Test
	public void testInsertionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));

	//	for (int i=0; i<10000; i++) {
			// For good measure, let's shuffle it and sort it again to see if that works,
			// too.
			Collections.shuffle(sortMe);
			InsertionSort.insertionSort(sortMe);
	//			System.out.println(sortMe);
			Assert.assertTrue(checkSorted(sortMe));
	//	}
	}
	
		@Test
		public void testMergeSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		List<Integer> fixed = MergeSort.recrusivemergeSort(sortMe);
		Assert.assertTrue(checkSorted(fixed));
		IterativeMergesort.Iterativemergesort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));

		// For good measure, let's shuffle it and sort it again to see if that works,
		// too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = MergeSort.recrusivemergeSort(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
		IterativeMergesort.Iterativemergesort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
}
		
		
		public DoublyLinkedList<Integer> makeFullDDL(){
			Random rand = new Random();
			DoublyLinkedList<Integer> data = new DoublyLinkedList<Integer>();
			for(int i=10;i>=0;i--) {
				data.addBack(rand.nextInt(20));
			}		
			return data;
		}
		
		@Test
		public void testMergeSortIterativeDDL() {
			DoublyLinkedList<Integer> sortMe = makeFullDDL();
			DoublyLinkedList<Integer> temp=DLLmergesort.ddlemergeSort(sortMe);	
			Assert.assertTrue(checkSorted(temp));
		}
			

		
}
