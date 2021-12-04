import java.util.ArrayList;

class E_remove_element {
    /*
     * Given an integer array nums and an integer val, remove all occurrences of val
     * in nums in-place. The relative order of the elements may be changed.
     * 
     * Constraints:
     * 
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     */
    public static void main(String[] args) {
        System.out.println(removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
        System.out.println(removeElement(new int[] { 2, 0, 1, 4, 2, 2, 2, 2, 2, 2 }, 2));
        System.out.println(removeElement(new int[] { 0, 1, 1, 2, 2, 2, 2 }, 2));
        System.out.println(removeElement(new int[] { 2, 2, 1, 1, 1, 1, 1, 12, 2, 2, 2 }, 2));
    }

    /*
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove
     * Element.
     * Memory Usage: 37.5 MB, less than 77.21% of Java online submissions for Remove
     * Element.
     */
    static int removeElement(int[] nums, int val) {
        int lastIndex = -1;
        int usualNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (lastIndex == -1) {
                    lastIndex = i;
                }
            } else {
                if (lastIndex == -1) {
                    lastIndex = i;
                }
                nums[lastIndex] = nums[i];
                if (lastIndex != i)
                    nums[i] = -1;
                lastIndex++;
                usualNumbers++;
            }
        }
        // printArray(nums);
        return usualNumbers;
    }

    /*
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove
     * Element.
     * Memory Usage: 37.6 MB, less than 64.40% of Java online submissions for Remove
     * Element.
     */
    static int removeElementv2(int[] nums, int val) {
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[lastIndex] = nums[i];
                if (lastIndex != i)
                    nums[i] = -1;
                lastIndex++;
            }
        }
        return lastIndex;
    }

    static void printArray(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }
}