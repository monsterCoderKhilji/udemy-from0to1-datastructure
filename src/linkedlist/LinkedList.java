package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T extends Comparable<T>> implements Cloneable {

	private Node<T> head = null;

	public LinkedList() {
	}

	/**
     * Append a new node to the end of the linked list.
     */
	public void addNode(T data) {

	}

	/**
     * Print all the nodes in the linked list.
     */
	public void printNodes() {

	}

	/**
     * Count the number of nodes in the linked list.
     */
    public int countNodes() {

	}

    /**
     * Return the first element in the linked list.
     */
    public T popElement() {

	}

    /**
     * Delete all the elements in the linked list.
     */
    public void deleteLinkedList() {

	}

    /**
     * Insert at the nth position in the list. Return if the number of nodes is
     * less than n.
     */
    public void insertNth(int n, T data) {

	}

	/**
	 * Insert the data into the correct position in a sorted list. Assume that the
	 * list is sorted in ascending order.
	 */
	public void insertSorted(T data) {

	}

	/**
	 * Append the nodes of the other list to the end of the curren list.
	 */
	public void appendList(LinkedList<T> ll) {

	}

	/**
	 * Split a linked list into 2 equal parts. If there are an odd number of
	 * elements, the extra element should be in the first list.
	 */
	public List<Node<T>> frontBackSplit() {

	}

	/**
	 * Remove duplicates in a sorted list.
	 */
	public void removeDuplicates() {

	}

	/**
	 * Move the head element or the first element from this list to the destination
	 * linked list as the destination's new head node.
	 */
	public void changeHead(LinkedList<T> destinationList) {

	}

	/**
	 * Create a new sorted list which is the merged from two original sorted lists.
	 * Assume the lists are sorted in ascending order.
	 */
	public LinkedList<T> sortedMergeList(LinkedList otherList) {

	}

	/**
	 * Reverse all the nodes in the linked list so that the last node becomes the
	 * first node.
	 */
	public void reverseList() {

	}

}
