package clrs.datastructures.array;

/**
 * Linked list implementation with internally defined Node inner class.
 * 
 * @param <T>
 *            Must extend comparable to facilitate searching the List
 */
public class LinkedList<T extends Comparable<T>> {

	public class Node {
		public T value;
		public Node next;
		public Node prev;

		public Node(T val) {
			this.value = val;
		}
	}

	private Node head = null;
	private Node tail = null;

	/**
	 * An O(n) method for determining the size of the list
	 * 
	 * @return The size of the list
	 */
	public int size() {
		int i = 0;
		Node curr = head;

		while (curr != null) {
			i++;
			curr = curr.next;
		}
		return i;
	}

	/**
	 * An O(1) method for inserting a value at the head of the list
	 * 
	 * @param value
	 *            The value to insert
	 */
	public void insert(T value) {
		Node node = new Node(value);

		node.next = head;
		if (head != null) {
			head.prev = node;
		}
		if (tail == null) {
			tail = node;
		}

		head = node;
	}

	/**
	 * An O(1) method for removing a particular node from the list
	 * 
	 * @param node
	 *            to remove
	 */
	public void delete(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		}

	}

	/**
	 * An O(n) method for finding the first occurrence of a particular value in
	 * the list
	 * 
	 * @param value
	 *            The value to search for in the List
	 * @return The node containing the first occurrence of value in the List, or
	 *         null if value is not present
	 */
	public Node searchList(T value) {
		Node curr = head;

		while (curr != null && !curr.value.equals(value)) {
			curr = curr.next;
		}

		return curr;
	}

}
