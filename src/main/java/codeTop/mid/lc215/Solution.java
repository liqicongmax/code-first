package codeTop.mid.lc215;//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2422 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        int start=0;
        int end=len-1;
        while (start<=end){
            int idx = partition(nums,start,end);
            if(len-idx>k){
                start=idx+1;
            }else if(len-idx<k){
                end=idx-1;
            }else{
                return nums[idx];
            }
        }

        return -1;
    }

    private int partition(int[] nums,int start, int end){
        int tmp = nums[start];
        while(start<end){
            while (start<end&&nums[end]>=tmp){
                end--;
            }
            nums[start] = nums[end];
            while (start<end &&nums[start]<=tmp){
                start++;
            }
            nums[end]=nums[start];
        }
        nums[start] =tmp;
        return start;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
