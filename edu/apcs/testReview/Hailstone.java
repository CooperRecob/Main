package edu.apcs.testReview;

public class Hailstone {
    public static int hailstoneLength(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            count++;
        }
        return count;
    }

    public static boolean isLongSeq(int n) {
        int count = hailstoneLength(n);
        if (count > n) {
            return true;
        } else {
            return false;
        }
    }

    public static double propLong(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isLongSeq(i)) {
                count++;
            }
        }
        return (double) count / n;
    }
}