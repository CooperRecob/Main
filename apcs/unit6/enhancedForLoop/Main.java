package enhancedForLoop;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        int i = 0;

        while (true) {
            System.out.println(nums[i]);
            if (i >= nums.length - 1) {
                break;
            }
            i++;
        }

        i = 0;

        while (i < nums.length) {
            System.out.println(nums[i]);
            i++;
        }
    }
}
