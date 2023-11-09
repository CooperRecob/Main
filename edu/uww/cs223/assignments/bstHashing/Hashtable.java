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
		try {
			return (37 * key + 61) % tableSize;
		} catch (Exception e) {
			throw new UnsupportedOperationException("computeHash");
		}
	}

	public boolean insert(int key) {
		try {
			if (search(key)) {
				return false;
			}
			int hash = computeHash(key);
			LinkedList<Integer> list = table.get(hash);
			if (list == null) {
				list = new LinkedList<>();
				table.set(hash, list);
			}
			list.add(key);
			count++;
			return true;
		} catch (Exception e) {
			throw new UnsupportedOperationException("insert");
		}
	}

	public boolean remove(int key) {
		try {
			int hash = computeHash(key);
			LinkedList<Integer> list = table.get(hash);
			if (list == null) {
				return false;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == key) {
					list.remove(i);
					count--;
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			throw new UnsupportedOperationException("remove");
		}
	}

	public boolean search(int key) {
		try {
			int hash = computeHash(key);
			LinkedList<Integer> list = table.get(hash);
			if (list == null) {
				return false;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == key) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			throw new UnsupportedOperationException("search");
		}
	}

	@Override
	public String toString() {
		try {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < tableSize; i++) {
				sb.append("Slot " + i + ": ");
				LinkedList<Integer> list = table.get(i);
				if (list == null) {
					continue;
				}
				for (int j = 0; j < list.size(); j++) {
					sb.append(list.get(j) + " ");
				}
				sb.append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new UnsupportedOperationException("toString");
		}
	}
}
