package codeTop.排序.快排;//给你一个整数数组 nums，请你将该数组升序排列。
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 981 👎 0


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = partition(nums, l, r);
            quickSort(nums, l, partition - 1);
            quickSort(nums, partition + 1, r);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left;
        int tt=nums[left];
        nums[left]=nums[i];
        nums[i]=tt;
        int tmp = nums[left];
        while (left < right) {
            // 找到比tmp小的数，放到它的左边
            while (left < right && nums[right] >= tmp) {
                right--;
            }
            nums[left] = nums[right];
            // 找到比tmp大的数，放到它的右边
            while (left < right && nums[left] <= tmp) {
                left++;
            }
            nums[right] = nums[left];
        }
        // 循环结束之后，left==right，此时这个位置就是==tmp左边全部小于它，tmp右边全部大于它
        // tmp实际上是我要找目的地的这个值，把他放到应在的位置
        nums[left] = tmp;
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
