package codeTop.动态规划.环形打家劫舍213;
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1602 👎 0


import sun.nio.cs.ext.MacHebrew;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        // dp1第一间偷 dp2第一间不偷
        int[][] dp1=new int[2][nums.length];
        int[][] dp2=new int[2][nums.length];
        dp1[0][0]=nums[0];
        
        for(int i=1;i<len-1;i++){
            // dp1第二间只能是不偷
            if(i==1){
                dp1[0][1]=nums[0];
                dp1[1][1]=nums[0];
                
                dp2[1][1]=nums[1];
            }else {
                dp1[0][i]=Math.max(dp1[0][i-1],dp1[1][i-1]);
                dp1[1][i]=nums[i]+dp1[0][i-1];

                dp2[0][i]=Math.max(dp2[0][i-1],dp2[1][i-1]);
                dp2[1][i]=nums[i]+dp2[0][i-1];
            }
        }
        // 第一间偷了，最后一间不能偷
        dp1[0][len-1]=Math.max(dp1[0][len-2],dp1[1][len-2]);

        // 第一间没偷，最后一间可以偷
        dp2[1][len-1]=nums[len-1]+dp2[0][len-2];
        dp2[0][len-1]=Math.max(dp2[0][len-2],dp2[1][len-2]);
        return Math.max(dp1[0][len-1],Math.max(dp2[0][len-1],dp2[1][len-1]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
