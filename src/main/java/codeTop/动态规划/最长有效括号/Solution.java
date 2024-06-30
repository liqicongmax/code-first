package codeTop.动态规划.最长有效括号;//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2519 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int[] dp=new int[s.length()];
        int l=0,r=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==')'){
                r++;
                if(r<=l){
                    dp[i]=dp[i-1]+1;
                    if(i-2*dp[i]>=0) {
                        dp[i] += dp[i - 2 * dp[i]];
                    }
                }else{
                    r=0;
                    l=0;
                }
            }else {
                l++;
            }
            max=Math.max(max,dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;

        // ((()((()
        // ((()))((()))
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.longestValidParentheses("((()((()"));
        System.out.println(s.longestValidParentheses("((()))((()))"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
