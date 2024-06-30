package codeTop.动态规划.解码方法91;//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26" 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
//
// Related Topics 字符串 动态规划 👍 1524 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 123123123=['1'+dp(23123123)]+['12'+dp(3123123)]
     * 123123
     * dp[i]表示截取到第i位有dp[i]种截取方式，如何递推？
     * 截取到dp[i]有2种方式，(char[i]+dp[i+1]) or (char[i,i+1]+dp[i+2]}
     * 即dp[i]=dp[i+1]+dp[i+2]
     * char[i]=='0'时跳过，dp[i]=0
     */
    public int numDecodings(String s) {
        char[] chars=s.toCharArray();
        if(chars[0]=='0'){
            return 0;
        }
        int[]dp=new int[s.length()];
        int len=s.length();
        for(int i=len-1;i>=0;i--){
            if(chars[i]=='0'){
                dp[i]=0;
                continue;
            }
            // 只取char[i]
            int cur=0;
            cur=((i+1)<len?dp[i+1]:1);
            // 取chars[i] & chars[i+1]
            int next=0;
            if(i+1<len&&isValid(chars[i],chars[i+1])){
                next=((i+2)<len?dp[i+2]:1);
            }
            dp[i]+=cur+next;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public boolean isValid(char c1,char c2){
        // 10~26
        if(c1=='1'){
            return '0'<=c2&&c2<='9';
        } else if (c1 == '2') {
            return '0'<=c2&&c2<='6';
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.numDecodings("123123"));
        System.out.println(s.numDecodings("12"));
        System.out.println(s.numDecodings("226"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
