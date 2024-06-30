package codeTop.动态规划.正则表达式匹配10;//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3917 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        // https://leetcode.cn/problems/regular-expression-matching/solutions/652276/hen-rong-yi-li-jie-de-zheng-ze-biao-da-s-cpgp/
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        // 行列初始化
        // 列全是false
        // 行只要p[j]=*,dp[0][j+1]=dp[0][j-1]
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*'){
                dp[0][i+1]=dp[0][i-1];
            }
        }

        for(int i=1;i<=s.length();i++){
            char c=s.charAt(i-1);
            for(int j=1;j<=p.length();j++){
                char pattern = p.charAt(j-1);
                // pattern是. 继承上一个字符的结果
                if(pattern=='.'){
                    dp[i][j]=dp[i-1][j-1];
                } else if ('a'<=pattern&&pattern<='z') {
                    // pattern是字母a-z，也是继承上一个字符的结果
                    if(pattern==c){
                        dp[i][j]=dp[i-1][j-1];
                    }
                } else if (pattern == '*') {
                    // pattern为*时，根据前置字符2种情况区分
                    // 1.pre是.或者和s相等，dp[i][j]=dp[i][j-2](让x*去匹配空字符串)||dp[i-1][j](让x*去匹配单个字符)
                    // 2.pre非.或者和s不相等，继承d[i][j-2]，因为x*可以匹配空字符串，所以x=i
                    char pre=p.charAt(j-2);
                    if(pre=='.'||pre==c){
                        dp[i][j]=dp[i][j-2]||dp[i-1][j];
                    }else {
                        dp[i][j]=dp[i][j-2];
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
