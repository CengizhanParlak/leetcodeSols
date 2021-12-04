import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class E_remove_duplicates_from_sorted_array {

    /**
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * 
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * 
     * 
     * Constraints:
     * 
     * 0 <= nums.length <= 3 * 104
     * -100 <= nums[i] <= 100
     * nums is sorted in non-decreasing order.
     */
    public static void main(String[] args) {
        int[] testNums = { 1, 1, 1, 1, 1, 2, 2, 3, 4, 4, 10 };
        // 1, 2, 3, 4, 10,_, _
        System.out.println(removeDuplicatesv3(testNums));
    }

    // rt 2ms - %28.26
    // mu 39.7mb - %99.57
    static int removeDuplicates(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<Integer>();
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (uniqueNums.contains(nums[i])) {
                continue;
            } else {
                uniqueNums.add(nums[i]);
                nums[lastIndex] = nums[i];
                lastIndex++;
            }
        }
        return lastIndex;
    }

    /*
     * Runtime: 1 ms, faster than 83.53% of Java online submissions for Remove
     * Duplicates from Sorted Array.
     * Memory Usage: 40.7 MB, less than 38.24% of Java online submissions for Remove
     * Duplicates from Sorted Array.
     */
    static int removeDuplicatesv2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int lastNumber = nums[0];
        int lastIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastNumber) {
                continue;
            } else {
                lastNumber = nums[i];
                nums[lastIndex] = nums[i];
                lastIndex++;
            }
        }
        return lastIndex;
    }

    /*
     * Runtime: 1 ms, faster than 83.53% of Java online submissions for Remove
     * Duplicates from Sorted Array.
     * Memory Usage: 40.1 MB, less than 96.07% of Java online submissions for Remove
     * Duplicates from Sorted Array.
     */
    static int removeDuplicatesv3(int[] nums) {
        int lastNumber = -101;
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == lastNumber) {
                continue;
            } else {
                lastNumber = nums[i];
                nums[lastIndex] = nums[i];
                lastIndex++;
            }
        }
        return lastIndex;
    }
}
