package clrs.datastructures.array;

public class Stack<T> {
	private T[] array;
	private int top; // The first available index of array

	public Stack(int size) {
		this.array = (T[]) new Object[size];
		top = 0;
	}

	/**
	 * Pushes an item on the top of the stack.
	 * 
	 * @param item
	 *            to push on top of the stack.
	 * @throws StackException
	 *             if the stack is full
	 */
	public void push(T item) throws StackException {
		if (isFull()) {
			throw new StackException("Stack is full!");
		}
		array[top++] = item;
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws StackException
	 *             if the stack is empty
	 */
	public T pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty!");
		}
		return array[--top];
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == array.length;
	}

	public static void main(String[] args) throws StackException {
		Stack<Integer> stack = new Stack<>(10);
		for (int i = 10; i >= 1; i--) {
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + ", ");
		}
	}

	/**
	 * Exception to throw for Stack operations.
	 *
	 */
	public static class StackException extends Exception {
		public StackException(String message) {
			super(message);
		}
	}

}
