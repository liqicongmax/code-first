package codeTop.dp.lc53;//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6623 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        // dp[i] 表示以i结尾的字串的最大值
        // if dp[i-1]>=0 dp[i]=dp[i-1]+nums[i]
        // if dp[i-1]<0 dp[i]=nums[i]
        int[] dp=new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            if(dp[i-1]>=0){
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=nums[i];
            }
        }
        int max=Integer.MIN_VALUE;
        for(int v:dp){
            max=Math.max(max,v);
        }

        return max;
    }

    public int maxSubArray1(int[] nums) {
        int len=nums.length;
        // dp[i] 表示以i结尾的字串的最大值
        // if dp[i-1]>=0 dp[i]=dp[i-1]+nums[i]
        // if dp[i-1]<0 dp[i]=nums[i]
        int realMax = nums[0];
        int max = nums[0];
        for(int i=1;i<len;i++){
            if(max>=0){
                max+=nums[i];
            }else{
                max=nums[i];
            }
            realMax=Math.max(realMax,max);
        }
        return realMax;
    }

    public int maxSubArray2(int[] nums) {
        int len=nums.length;
        // dp[i] 表示以i结尾的字串的最大值
        // if dp[i-1]>=0 dp[i]=dp[i-1]+nums[i]
        // if dp[i-1]<0 dp[i]=nums[i]
        int realMax = nums[0];
        int realLeft = 0;
        int realRight=0;
        int max = nums[0];
        int l=0;
        int r=0;
        for(int i=1;i<len;i++){
            if(max>=0){
                r=r+1;
                max+=nums[i];
            }else{
                l=i;
                r=i;
                max=nums[i];
            }
            if(max>realMax){
                realMax=max;
                realLeft = l;
                realRight = r;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,realLeft,realRight)));
        return realMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
