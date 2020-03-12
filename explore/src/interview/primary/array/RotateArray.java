package interview.primary.array;

import java.util.Arrays;

/**
 * 旋转数组
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 *
 * @author kefate
 * @date 2020/3/10
 */
public class RotateArray {
    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     * <p>
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     * <p>
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     */


    private static void rotate3(int[] nums, int k) {

    }

    /**
     * Solution-3：非原地，空间复杂度O(n)
     * 执行用时：0 ms
     * 内存消耗：42.4 MB
     */
    private static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        if (k <= 0) {
            return;
        }

        int[] copy = new int[k];
        System.arraycopy(nums, nums.length - k, copy, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(copy, 0, nums, 0, k);
    }

    /**
     * Solution-1：每次旋转一位，旋转k次
     * 执行用时：50 ms（faster than 36.68%）
     * 内存消耗：42.2 MB
     */
    private static void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        if (k <= 0) {
            return;
        }

        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] a2 = new int[]{-1, -100, 3, 99};
        int[] a3 = new int[]{1, 2, 3, 4, 5, 6};
        rotate2(a1, 3);
        rotate2(a2, 2);
        rotate2(a3, 2);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
    }
}
