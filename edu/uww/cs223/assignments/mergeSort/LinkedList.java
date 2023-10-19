public class LinkedList {
	private Node head, tail;
	private int size;

	public LinkedList(int[] values) {
		for (int value : values) {
			insertAtEnd(value);
		}
	}

	public Node insertAtFront(int value) {
		Node newNode = new Node(value);

		if (size == 0) {
			head = tail = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}

		size++;
		return newNode;
	}

	public Node insertAtEnd(int value) {
		Node newNode = new Node(value);

		if (size == 0) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}

		size++;
		return newNode;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int size() {
		return size;
	}

	@Override
	public String toString() {
		java.lang.StringBuilder result = new StringBuilder();

		Node temp = head;
		while (temp != null) {
			result.append(temp);
			result.append(" -> ");
			temp = temp.next;
		}

		result.append("null");
		return result.toString();
	}

	public static class Node {
		public int value;
		public Node next;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return Integer.toString(value);
		}
	}
}
