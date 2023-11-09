import java.util.ArrayList;
import java.util.LinkedList;

public class Hashtable {
	// DO NOT MODIFY
	private final int tableSize;
	private final ArrayList<LinkedList<Integer>> table;
	private int count;

	public Hashtable(int tableSize) {
		this.tableSize = tableSize;
		table = new ArrayList<>(tableSize);

		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<>());
		}
	}

	public int getCount() {
		return count;
	}
	// END DO NOT MODIFY

	private int computeHash(int key) {
		throw new UnsupportedOperationException("computeHash");
	}

	public boolean insert(int key) {
		throw new UnsupportedOperationException("insert");
	}

	public boolean remove(int key) {
		throw new UnsupportedOperationException("remove");
	}

	public boolean search(int key) {
		throw new UnsupportedOperationException("search");
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException("toString");
	}
}
