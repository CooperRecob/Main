package edu.uww.cs223.assignments.bstHashing;

import java.util.Stack;

public class BST {
	// DO NOT MODIFY
	private Node root;

	public BST() {
		root = null;
	}
	// END DO NOT MODIFY

	public Node search(int key) {
		try {
			if (root == null) {
				return null;
			}
			Node temp = root;
			while (temp != null) {
				if (key == temp.value) {
					return temp;
				} else if (key < temp.value) {
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}
			return null;
		} catch (Exception e) {
			throw new UnsupportedOperationException("search");
		}
	}

	public Node insert(int key) {
		try {
			if (root == null) {
				root = new Node(key);
				return root;
			}
			Node temp = root;
			Node parent = null;
			while (temp != null) {
				if (temp.value == key) {
					return null;
				} else if (temp.value < key) {
					parent = temp;
					temp = temp.right;
				} else {
					parent = temp;
					temp = temp.left;
				}
			}
			Node newNode = new Node(key);
			newNode.parent = parent;
			if (parent.value > key) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
			return newNode;
		} catch (Exception e) {
			throw new UnsupportedOperationException("insert");
		}
	}

	public boolean remove(int key) {
		try {
			Node nodeToDelete = search(key);
			if (nodeToDelete == null) {
				return false;
			}
			if (nodeToDelete.left != null && nodeToDelete.right != null) {
				Node max = findMax(nodeToDelete.left);
				nodeToDelete.value = max.value;
				nodeToDelete = max;
			}
			if (nodeToDelete.left == null && nodeToDelete.right == null) {
				removeLeaf(nodeToDelete);
			} else {
				removeOneChild(nodeToDelete);
			}
			return true;
		} catch (Exception e) {
			throw new UnsupportedOperationException("remove");
		}
	}

	private Node findMax(Node node) {
		try {
			if (node == null) {
				return null;
			}
			while (node.right != null) {
				node = node.right;
			}
			return node;
		} catch (Exception e) {
			throw new UnsupportedOperationException("findMax");
		}
	}

	private void removeLeaf(Node leaf) {
		try {
			if (leaf == null) {
				root = null;
			} else {
				Node parent = leaf.parent;
				if (parent.left == leaf) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				leaf.parent = null;
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException("removeLeaf");
		}
	}
	
	private void removeOneChild(Node node) {
		try {
			Node child;
			if (node.left != null) {
				child = node.left;
				node.left = null;
			} else {
				child = node.right;
				node.right = null;
			}
			if (node == root) {
				root = child;
				child.parent = null;
			} else {
				Node parent = node.parent;
				if (parent.left == node) {
					parent.left = child;
				} else {
					parent.right = child;
				}
				child.parent = parent;
				node.parent = null;
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException("removeOneChild");
		}
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
