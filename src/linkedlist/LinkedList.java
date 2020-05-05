package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedList<T extends Comparable<T>> implements Cloneable {

	private Node<T> head = null;

	public LinkedList() {
	}

	/**
	 * Append a new node to the end of the linked list.
	 */
	public void addNode(T data) {
		Node<T> curr = head;
		Node<T> next = new Node<T>(data);
		next.setNext(null);

		if (null == head) {
			head = next;
		} else if (null == head.getNext()) {
			head.setNext(next);
		} else {
			while (null != curr.getNext()) {
				curr = curr.getNext();
			}
			curr.setNext(next);
		}
	}

	/**
	 * Print all the nodes in the linked list.
	 */
	public void printNodes() {
		Node<T> curr = head;
		while (null != curr) {
			System.out.print(curr.toString() + " ");
			curr = curr.getNext();
		}
	}

	/**
	 * Count the number of nodes in the linked list.
	 */
	public int countNodes() {
		Node<T> curr = head;
		int count = 0;
		while (null != curr) {
			count = count + 1;
			curr = curr.getNext();
		}
		return count;

	}

	/**
	 * Return the first element in the linked list.
	 */
	public T popElement() {
		Node<T> curr = head;
		head = curr.getNext();
		return curr.getData();
	}

	/**
	 * Delete all the elements in the linked list.
	 */
	public void deleteLinkedList() {
		head = null;
	}

	/**
	 * Insert at the nth position in the list. Return if the number of nodes is less
	 * than n.
	 */
	public void insertNth(int n, T data) {
		Node<T> curr = head;
		Node<T> next = null;
		Node<T> node = new Node<T>(data);

		if (n == 0) {
			node.setNext(curr);
			head = node;
		} else {
			while (n-- > 1) {
				curr = curr.getNext();
				if (null == curr) {
					return;
				}
				next = curr.getNext();
			}
			node.setNext(next);
			curr.setNext(node);
		}
	}

	/**
	 * Insert the data into the correct position in a sorted list. Assume that the
	 * list is sorted in ascending order.
	 */
	public void insertSorted(T data) {
		Node<T> curr = head;
		Node<T> node = new Node<T>(data);
		Node<T> prev = head;

		if (head.getData().compareTo(data) > 0) {
			node.setNext(curr);
			head = node;
		} else {
			while (null != curr.getNext() && curr.getNext().getData().compareTo(data) < 0) {
				prev = curr;
				curr = curr.getNext();
			}
			prev = curr.getNext();
			curr.setNext(node);
			curr.getNext().setNext(prev);
		}
	}

	/**
	 * Append the nodes of the other list to the end of the curren list.
	 */
	public void appendList(LinkedList<T> ll) {
		Node<T> secondhead = ll.head;
		Node<T> curr = head;
		while (null != curr.getNext()) {
			curr = curr.getNext();
		}
		curr.setNext(secondhead);
	}

	/**
	 * Split a linked list into 2 equal parts. If there are an odd number of
	 * elements, the extra element should be in the first list.
	 */
	public List<Node<T>> frontBackSplit() {
		Node<T> curr = head;
		Node<T> front = new Node<T>(curr.getData());
		Node<T> temp = front;
		int count = countNodes();
		int split = (count % 2 == 0) ? count / 2 : count / 2 + 1;

		while (split > 0) {
			temp.setNext(new Node<T>(curr.getData()));
			temp = temp.getNext();
			curr = curr.getNext();
			split--;
		}

		return Arrays.asList(front.getNext(), curr);
	}

	/**
	 * Remove duplicates in a sorted list.
	 */
	public void removeDuplicates() {
		Node<T> curr = head;
		Node<T> next = null;
		while (null != curr.getNext()) {
			next = curr.getNext();
			if (next.getData().compareTo(curr.getData()) == 0) {
				curr.setNext(next.getNext());
			} else {
				curr = curr.getNext();
			}
		}
	}

	/**
	 * Move the head element or the first element from this list to the destination
	 * linked list as the destination's new head node.
	 */
	public void changeHead(LinkedList<T> destinationList) {
		Node<T> curr = new Node<T>(popElement());
		Node<T> dest = destinationList.head;
		destinationList.head = curr;
		destinationList.head.setNext(dest);
	}

	/**
	 * Create a new sorted list which is the merged from two original sorted lists.
	 * Assume the lists are sorted in ascending order.
	 */
	public LinkedList<T> sortedMergeList(LinkedList otherList) {
		Node<T> curr = head;
		Node<T> other = otherList.head;
		Node<T> dummy = new Node<T>(curr.getData());
		Node<T> sortedHead = dummy;
		LinkedList<T> sortedList = new LinkedList<T>();

		while (true) {
			if (curr == null) {
				sortedHead.setNext(other);
				break;
			}
			if (other == null) {
				sortedHead.setNext(curr);
				break;
			}

			if (curr.getData().compareTo(other.getData()) <= 0) {
				sortedHead.setNext(new Node<T>(curr.getData()));
				curr = curr.getNext();
			} else if (curr.getData().compareTo(other.getData()) > 0) {
				sortedHead.setNext(new Node<T>(other.getData()));
				other = other.getNext();
			}

			sortedHead = sortedHead.getNext();
		}
		sortedList.head = dummy.getNext();
		return sortedList;
	}

	/**
	 * Reverse all the nodes in the linked list so that the last node becomes the
	 * first node.
	 */
	public void reverseList() {
		Node<T> curr = head;
		Node<T> prev = null;
		while (null != curr) {
			Node<T> next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
	}

}
