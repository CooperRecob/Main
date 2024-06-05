package edu.uww.cs223.assignments.binarySearch;

import java.util.Arrays;

public class Assignment3 {
	private static int countNumberOfKeys(int[] array, int key) {
		int minIndex = minIndexBinarySearch(array, key);
		int maxIndex = maxIndexBinarySearch(array, key);
		//I wasnt able to get it to work wihtout this added logic and I was hesitent to add because it wasnt really menioned in the assignment but it works atleast so I hope its ok
		if (minIndex == -1 || maxIndex == -1) {
			return 0;
		}
		return maxIndex - minIndex + 1;
	}

	private static int minIndexBinarySearch(int[] array, int key) {
		int minIndex = -1;
		int left = 0;
		int right = array.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (array[mid] == key) {
				minIndex = mid;
				right = mid - 1;
			} else if (array[mid] < key) {
				left = mid + 1;
			} else if (array[mid] > key) {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return minIndex;
	}

	private static int maxIndexBinarySearch(int[] array, int key) {
		int maxIndex = -1;
		int left = 0;
		int right = array.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (array[mid] == key) {
				maxIndex = mid;
				left = mid + 1;
			} else if (array[mid] < key) {
				left = mid + 1;
			} else if (array[mid] > key) {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return maxIndex;
	}

	private static int predecessor(int[] array, int key) {
		int predIndex = -1;
		int left = 0;
		int right = array.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (array[mid] == key) {
				predIndex = mid;
				break;
			} else if (array[mid] < key) {
				predIndex = mid;
				left = mid + 1;
			} else if (array[mid] > key) {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return predIndex;
	}

	private static int findPeak(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (left == right) {
				return left;
			} else if (right == left + 1) {
				if (array[left] > array[right]) {
					return left;
				} else {
					return right;
				}
			} else if (array[mid] < array[mid + 1]) {
				left = mid + 1;
			} else if (array[mid] < array[mid - 1]) {
				right = mid - 1;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}
		throw new UnsupportedOperationException("findPeak");
	}

	// DO NOT MODIFY
	public static void main(String[] args) {
		System.out.println("Part 1: Frequency");
		int[] a = {1, 1, 3, 7, 9, 14, 14, 14, 14, 14, 14, 18, 27, 39, 39, 39};
		System.out.printf("Array is %s]%n", Arrays.toString(a));
		int[] testKeys = {1, 14, 39, 7, 100, -88, 16};
		for (int key : testKeys) {
			System.out.printf("Frequency of %d is %d%n", key, countNumberOfKeys(a, key));
		}

		System.out.println("\nPart 2: Predecessor");
		testKeys = new int[]{1, 0, 39, 47, 36, 12, 6};
		System.out.printf("Array is %s%n", Arrays.toString(a));
		for (int key : testKeys) {
			int p = predecessor(a, key);

			if (p == -1) {
				System.out.printf("Predecessor of %d is undefined%n", key);
			}
			else {
				System.out.printf("Predecessor of %d is %d%n", key, a[p]);
			}
		}

		System.out.println("\nPart 3: Peak Finding");
		int[][] c = {
				new int[]{15, 18, 21, 25, 29, 31, 35, 23, 14, 9, 1, -1},
				new int[]{31, 35, 23, 14, 9, 1, -1},
				new int[]{31, 35, 37, 39},
				new int[]{36, 35, 32, 29}
		};

		for (int[] array : c) {
			System.out.printf("Array is %s%n", Arrays.toString(array));
			int peak = findPeak(array);
			System.out.printf("Peak is %d at index %d%n", array[peak], peak);
		}
	}
	// END DO NOT MODIFY
}
