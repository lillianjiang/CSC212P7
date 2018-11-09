package edu.smith.cs.csc212.p7;



/**
 * 
 *
 */
public class DLLmergesort {

	public static DoublyLinkedList<Integer> ddlmerge(DoublyLinkedList<Integer> left, DoublyLinkedList<Integer> right) {

		DoublyLinkedList<Integer> temp = new DoublyLinkedList<>();
		while(!left.isEmpty() && !right.isEmpty()) {
			if(left.getFront() < right.getFront()) {
				temp.addBack(left.getFront());
				left.removeFront();
			}
			else {
				temp.addBack(right.getFront());
				right.removeFront();
			}
		}
		if (!left.isEmpty()) {
			for (int i: left) {
				temp.addBack(i);
			}
			}
		else if(!right.isEmpty()) {
			for (int i: right) {
				temp.addBack(i);
			}
		}	
		
		return temp;
	}
	
	//recrusive mergesort for double linkedlist
	public static DoublyLinkedList<Integer> ddlemergeSort(DoublyLinkedList<Integer> input) {
		DoublyLinkedList<Integer> left = new DoublyLinkedList<>();
		DoublyLinkedList<Integer> right = new DoublyLinkedList<>();
		
		if(input.size() < 2) {
			return input; }
		else {
		
			int mid = input.size() / 2;

			int count = 0;
			for (int i : input) {
				if (count < mid) {
					left.addBack(i);
				} else {
					right.addBack(i);
				}
				count++;
			}
			DoublyLinkedList<Integer> sortedl = ddlemergeSort(left);
			DoublyLinkedList<Integer> sortedr = ddlemergeSort(right);

			return ddlmerge(sortedl, sortedr);

	}
	}

}
