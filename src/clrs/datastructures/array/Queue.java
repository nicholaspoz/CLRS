package clrs.datastructures.array;

public class Queue<T> {

	private T[] array;
	private int head, tail;

	public Queue(int size) {
		// create an array of size n+1 - facilitates circular algorithm
		this.array = (T[]) new Object[size + 1];
		head = 0;
		tail = 0;
	}

	/**
	 * Add an item to the queue. If full, throws IllegalStateException
	 * 
	 * @param item
	 *            The item to insert into the Queue
	 */
	public void enqueue(T item) throws QueueException {
		if (isFull()) {
			throw new QueueException("Queue is full");
		}
		array[tail] = item;

		tail = nextPos(tail);
	}

	/**
	 * Retrieve and remove the item at the front of the Queue.
	 * 
	 * @return The item at the front of the Queue.
	 * @throws QueueException
	 */
	public T dequeue() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty");
		}
		T item = array[head];
		head = nextPos(head);

		return item;

	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return (nextPos(tail)) == head;
	}

	private int nextPos(int i) {
		return (i + 1) % array.length;
	}

	/**
	 * Exception to throw for Queue operations.
	 * 
	 */
	public static class QueueException extends Exception {

		public QueueException(String string) {
			super(string);
		}

	}

	public static void main(String[] args) throws QueueException {
		Queue<Integer> queue = new Queue<>(10);

		int i = 0;
		while (!queue.isFull()) {
			queue.enqueue(i++);
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}

}
