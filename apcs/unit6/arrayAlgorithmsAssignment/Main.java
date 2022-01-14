package arrayAlgorithmsAssignment;

public class Main {
	public static void main(String[] args) {
		// INTEGER ALGORITHMS
		int[] numbers1 = { 3, 2, 4, 5, 8, 2, 1, -5 };

		int max1 = findMaximum(numbers1); // Returns 8
		System.out.println(max1);
		int numEvens1 = findNumEvens(numbers1); // Returns 4
		System.out.println(numEvens1);

		int[] numbers2 = { -3, -5, -2, -8, -7 };

		int max2 = findMaximum(numbers2); // Returns -2
		System.out.println(max2);
		int numEvens2 = findNumEvens(numbers2); // Returns 2
		System.out.println(numEvens2);

		// STRING ALGORITHMS
		String[] words = { "play", "ring", "run", "ingrown", "thing", "tx" };

		String smallest = findShortest(words); // Returns "run"
		System.out.println(smallest);
		int numING = findNumING(words); // Returns 2 (don’t count "ingrown")
		System.out.println(numING);
		String firstLetters = getFirstLetters(words); // Returns prrit
		System.out.println(firstLetters);

		// OBJECTS ALGORITHMS

		Classroom[] fortHighSchool = new Classroom[50];
		fortHighSchool[0] = new Classroom("Mr. Sarbacker", "Comp Sci", 22);
		for (int i = 1; i < fortHighSchool.length - 1; i++) {
			fortHighSchool[i] = new Classroom("Example", "Classroom", 0);
		}
		fortHighSchool[49] = new Classroom("Mr. Daniels", "Info Tech", 25);

		int schoolCap = getTotalCapacity(fortHighSchool); // 47
		System.out.println(schoolCap);

		boolean math = hasMath(fortHighSchool); // false
		System.out.println(math);

		int danielsCap = getCapacity(fortHighSchool, "Mr. Daniels"); // 25
		System.out.println(danielsCap);
		int johnsonCap = getCapacity(fortHighSchool, "Mr. Johnson"); // -1
		System.out.println(johnsonCap);
		// Note Mr. Johnson doesn’t teach at Fort High School

		Classroom largest = getLargestClass(fortHighSchool); // Daniels obj
		System.out.println(largest);
	}

	public static int findMaximum(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
		}
		return max;
	}

	public static int findNumEvens(int[] nums) {
		int evenCount = 0;
		int size = nums.length;

		for (int i = 0; i < size; i++) {
			if (nums[i] % 2 == 0) {
				evenCount++;
			}
		}
		return evenCount;
	}

	public static String findShortest(String[] strs) {
		String shortest = strs[0];

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < shortest.length()) {
				shortest = strs[i];
			}
		}
		return shortest;
	}

	public static int findNumING(String[] strs) {
		int strWithING = 0;

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() > 3) {
				if (strs[i].substring(strs[i].length() - 3, strs[i].length()).equals("ing")) {
					strWithING++;
				}
			}
		}
		return strWithING;
	}

	public static String getFirstLetters(String[] strs) {
		String firstLetters = "";

		for (int i = 0; i < strs.length; i++) {
			firstLetters += strs[i].substring(0, 1);
		}

		return firstLetters;
	}

	public static int getTotalCapacity(Classroom[] school) {
		int capacity = 0;

		for (int i = 0; i < school.length; i++) {
			capacity += school[i].getStudentCapacity();
		}

		return capacity;
	}

	public static boolean hasMath(Classroom[] school) {
		boolean hasMath = false;

		for (int i = 0; i < school.length; i++) {
			if (school[i].getSubject().equals("Math")) {
				hasMath = true;
			}
		}

		return hasMath;
	}

	public static int getCapacity(Classroom[] school, String teacher) {
		int capacity = 0;

		for (int i = 0; i < school.length; i++) {
			if (school[i].getTeacherName().equals(teacher)) {
				capacity = school[i].getStudentCapacity();
			} else {
				capacity = -1;
			}
		}

		return capacity;
	}

	public static Classroom getLargestClass(Classroom[] school) {
		Classroom largest = null;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < school.length; i++) {
			if (school[i].getStudentCapacity() > max) {
				largest = school[i];
				max = school[i].getStudentCapacity();
			}
		}

		return largest;
	}
}