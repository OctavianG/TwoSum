import java.lang.reflect.Array;
import java.util.*;

public class Main {
    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    // the "naive" solution - time complexity O(n^2); space complexity - O(1)
    public static int[] twoSumN1(int[] nums, int target) {
        int[] result = new int[2];

        // looping throw the array 2 times
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }

        return result;
    }

    // the efficient solution using HashMap
    // time complexity O(n); space complexity - O(1)
    public static int[] twoSumN2(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            if (hm.get(nums[i]) != null) {
                return new int[] {hm.get(nums[i]), i};
            }

            hm.put(target - nums[i], i);
        }

        return new int[] {-1, -1};
    }



    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 2, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumN1(array, target)));
        System.out.println(Arrays.toString(twoSumN2(array, target)));
    }
}