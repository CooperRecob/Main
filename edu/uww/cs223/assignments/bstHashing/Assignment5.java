import java.util.ArrayList;
import java.util.Arrays;

public final class Assignment5 {
	private static final int[] NUMS_TO_INSERT = {11, 12, 15, 17, 12, 19, 4, 5, 11, 19, 20, 32, 77, 65, 66, 88, 99, 10, 8, 19, 15, 66, 11, 19, 0, 3, 2, 55, 67, 78, 39};
	private static final int[] NUMS_TO_SEARCH = {29, 3, 19, 27, 12, 34, 4, 5, 19, 20, 32, 45, 37, 25, 99, 25, 8, 24, 12, 16};
	private static final int[] NUMS_TO_DELETE = {11, 16, 12, 15, 5, 17, 19, 4, 5, 20, 32, 17, 19, 39, 99, 10, 8, 19, 15, 21, 0, 55, 3, 78, 66};

	private static void testBST(BST tree) {
		System.out.print("Inserting: ");
		System.out.println(Arrays.toString(NUMS_TO_INSERT));
		System.out.println();

		for (int i = 0; i < NUMS_TO_INSERT.length; i++) {
			tree.insert(NUMS_TO_INSERT[i]);
		}

		System.out.println("Tree (After Insertion):");
		System.out.println(tree);
		System.out.println();

		System.out.println("Searching...");
		ArrayList<Integer> found = new ArrayList<>();
		ArrayList<Integer> not_found = new ArrayList<>();

		for (int i = 0; i < NUMS_TO_SEARCH.length; i++) {
			BST.Node node = tree.search(NUMS_TO_SEARCH[i]);

			if (node == null) {
				not_found.add(NUMS_TO_SEARCH[i]);
			}
			else {
				found.add(node.value);
			}
		}

		System.out.print("Found: ");
		System.out.println(found);

		System.out.print("Not Found: ");
		System.out.println(not_found);
		System.out.println();

		System.out.println("Deleting...");
		ArrayList<Integer> deleted = new ArrayList<>();
		ArrayList<Integer> not_deleted = new ArrayList<>();

		for (int i = 0; i < NUMS_TO_DELETE.length; i++) {
			boolean success = tree.remove(NUMS_TO_DELETE[i]);

			if (success) {
				deleted.add(NUMS_TO_DELETE[i]);
			}
			else {
				not_deleted.add(NUMS_TO_DELETE[i]);
			}
		}

		System.out.print("Deleted: ");
		System.out.println(deleted);

		System.out.print("Not Deleted: ");
		System.out.println(not_deleted);
		System.out.println();

		System.out.println("Tree (After Deletion):");
		System.out.println(tree);
		System.out.println();
	}

	private static void testHashtable(Hashtable table) {
		System.out.print("Inserting: ");
		System.out.println(Arrays.toString(NUMS_TO_INSERT));
		System.out.println();

		ArrayList<Integer> inserted = new ArrayList<>();
		ArrayList<Integer> not_inserted = new ArrayList<>();

		for (int i = 0; i < NUMS_TO_INSERT.length; i++) {
			boolean result = table.insert(NUMS_TO_INSERT[i]);

			if (result) {
				inserted.add(NUMS_TO_INSERT[i]);
			}
			else {
				not_inserted.add(NUMS_TO_INSERT[i]);
			}
		}

		System.out.print("Inserted: ");
		System.out.println(inserted);
		System.out.print("Not Inserted: ");
		System.out.println(not_inserted);
		System.out.println();

		System.out.println("Table (After Insertion): ");
		System.out.println(table);

		System.out.printf("Size of Table: %d%n", table.getCount());
		System.out.println();

		System.out.println("Searching...");
		ArrayList<Integer> found = new ArrayList<>();
		ArrayList<Integer> not_found = new ArrayList<>();

		for (int i = 0; i < NUMS_TO_SEARCH.length; i++) {
			boolean result = table.search(NUMS_TO_SEARCH[i]);

			if (result) {
				found.add(NUMS_TO_SEARCH[i]);
			}
			else {
				not_found.add(NUMS_TO_SEARCH[i]);
			}
		}

		System.out.print("Found: ");
		System.out.println(found);

		System.out.print("Not Found: ");
		System.out.println(not_found);
		System.out.println();

		System.out.println("Deleting...");
		ArrayList<Integer> deleted = new ArrayList<>();
		ArrayList<Integer> not_deleted = new ArrayList<>();

		for (int i = 0; i < NUMS_TO_DELETE.length; i++) {
			boolean success = table.remove(NUMS_TO_DELETE[i]);

			if (success) {
				deleted.add(NUMS_TO_DELETE[i]);
			}
			else {
				not_deleted.add(NUMS_TO_DELETE[i]);
			}
		}

		System.out.print("Deleted: ");
		System.out.println(deleted);

		System.out.print("Not Deleted: ");
		System.out.println(not_deleted);
		System.out.println();

		System.out.println("Table (After Deletion): ");
		System.out.println(table);

		System.out.printf("Size of Table: %d%n", table.getCount());
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Part 1: Binary Search Tree");
		System.out.println();

		BST tree = new BST();
		testBST(tree);

		System.out.println("Part 2: Hash Table with Counting");
		System.out.println();

		Hashtable hashtable = new Hashtable(7);
		testHashtable(hashtable);
	}
}
