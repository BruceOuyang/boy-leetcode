package club.bugmakers.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @see <a href="https://leetcode.com/problems/two-sum/">leetcode tow sum</a>
 * 给定一个数组 nums = [2, 7, 11, 15] 取出其中两个相加等于 9 的元素的下标
 */
public class Lc1TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 6, 7, 11, 15};
        int target = 26;
        System.out.println(Arrays.toString(solution1(nums, target)));
        System.out.println(Arrays.toString(solution2(nums, target)));
    }

    /**
     * 方案一：暴力破解
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方案二：遍历两次哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int [] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方案三：遍历一次哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] solution3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int [] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No tow sum solution");
    }

}
