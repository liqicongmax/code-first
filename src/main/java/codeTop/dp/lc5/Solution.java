package codeTop.dp.lc5;//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7165 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        char[] chars = s.toCharArray();
        char[] reversedChars = new StringBuffer(s).reverse().toString().toCharArray();
        int[][] data=new int[len][len];
        int maxLen=0;
        int maxEnd = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(chars[i]==reversedChars[j]){
                    if(i==0||j==0){
                        data[i][j]=1;
                    }else{
                        data[i][j]=data[i-1][j-1]+1;
                    }
                }
                // 检查倒置后最后一个点的index还原到倒置前，是否和倒置前坐标一样
                if(data[i][j]>maxLen){
                    int beforeRev = len-j-1;
                    if(beforeRev+data[i][j]-1==i){
                        maxLen=data[i][j];
                        maxEnd=i;
                    }
                }
            }
        }
        return s.substring(maxEnd-maxLen+1,maxEnd+1);
    }

    public String longestPalindrome1(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        char[] chars=s.toCharArray();
        int maxLen=0;
        int left=0;
        int right=0;
        for(int l=0;l<len;l++){
            for(int i=0;i+l<len;i++){
                int j=i+l;
                if(i==j){
                    dp[i][j]=true;
                } else {
                    boolean b = chars[i] == chars[j];
                    if (l == 1) {
                        dp[i][j]= b;
                    }else{
                        dp[i][j]= b &&dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&l+1>maxLen){
                    maxLen=l+1;
                    left=i;
                    right=j;
                }
            }
        }
        return s.substring(left,right+1);
    }

    public String longestPalindrome2(String s) {
        char[] chars =s.toCharArray();
        int maxLen=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            int l=i-1;
            int r=i+1;
            int len=1;
            while (l>=0&&chars[l]==chars[i]){
                len++;
                l--;
            }
            while (r<s.length()&&chars[r]==chars[i]){
                len++;
                r++;
            }
            while (l>=0&&r<s.length()&&chars[r]==chars[l]){
                l--;
                r++;
                len+=2;
            }
            if(len>maxLen){
                maxLen=len;
                ans=s.substring(l,r+1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
