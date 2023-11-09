import java.util.Stack;

public class BST {
	// DO NOT MODIFY
	private Node root;

	public BST() {
		root = null;
	}
	// END DO NOT MODIFY

	public Node search(int key) {
		
		throw new UnsupportedOperationException("search");
	}

	public Node insert(int key) {
		throw new UnsupportedOperationException("insert");
	}

	public boolean remove(int key) {
		throw new UnsupportedOperationException("remove");
	}

	private Node findMax(Node node) {
		throw new UnsupportedOperationException("findMax");
	}

	private void removeLeaf(Node leaf) {
		throw new UnsupportedOperationException("removeLeaf");
	}

	private void removeOneChild(Node node) {
		throw new UnsupportedOperationException("removeOneChild");
	}

	// DO NOT MODIFY
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node curr = root;
		Stack<Node> stack = new Stack<>();

		while (curr != null || stack.size() > 0) {
			while (curr != null) {
				sb.append(curr);
				sb.append(' ');
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			curr = curr.right;
		}

		return sb.toString();
	}

	public static class Node {
		public int value;
		public Node left, right, parent;

		public Node(int value) {
			this.value = value;
			left = right = parent = null;
		}

		@Override
		public String toString() {
			if (parent == null) {
				return String.format("<%d, null>", value);
			}

			return String.format("<%d, %d>", value, parent.value);
		}
	}
	// END DO NOT MODIFY
}
