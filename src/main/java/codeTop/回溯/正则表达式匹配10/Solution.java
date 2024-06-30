package codeTop.回溯.正则表达式匹配10;//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
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
// Related Topics 递归 字符串 动态规划 👍 3912 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String s;
    List<String> patterns;
    public boolean isMatch(String s, String p) {
        List<String> patterns = getPatterns(p);
        this.s=s;
        this.patterns=patterns;
        return dfs(0,0);
    }

    public boolean dfs(int wordIndex,int patternIndex){
        if(patternIndex==patterns.size()-1){
            String word=s.substring(wordIndex);
            return isWordMatch(word,patterns.get(patternIndex));
        }
        for(int i=wordIndex;i<=s.length();i++) {
            String word = s.substring(wordIndex, i);
            if(isWordMatch(word,patterns.get(patternIndex))){
                boolean isMatch = dfs(i,patternIndex+1);
                if(isMatch){
                    return true;
                }
            }
        }
//        if(dfs(wordIndex, patternIndex+1)){
//            return true;
//        }

        return false;
    }

    public boolean isWordMatch(String word, String pattern){
        if(!pattern.contains(".")&&!pattern.contains("*")){
            return word.equals(pattern);
        }
        // .*
        // a*
        // .
        if(pattern.equals(".*")){
            return true;
        } else if (pattern.equals(".")) {
            return word.length()==1;
        }else {
            if(word.isEmpty()){
                return true;
            }
            int i=0;
            char c=pattern.charAt(0);
            while (i<word.length()&&word.charAt(i)==c){
                i++;
            }
            return i==word.length();
        }
    }

    public List<String> getPatterns(String p) {
        List<String> res = new ArrayList<>();
        int len = p.length();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = p.charAt(i);
            if ('a' <= c && c <= 'z') {
                if (s.length() > 0 && (s.charAt(s.length() - 1) == '.' || s.charAt(s.length() - 1) == '*')) {
                    res.add(s.toString());
                    s = new StringBuilder();
                }
                s.append(c);
            } else if (c == '.') {
                if (s.length() != 0) {
                    res.add(s.toString());
                    s = new StringBuilder();
                }
                s.append('.');
            } else if (c == '*') {
                if(s.length()>1){
                    int endIndex=s.length()-1;
                    res.add(s.substring(0,endIndex));
                    s.append('*');
                    res.add(s.substring(endIndex));
                }else {
                    s.append('*');
                    res.add(s.toString());
                }
                s = new StringBuilder();
            }
        }
        if(s.length()!=0) {
            res.add(s.toString());
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(Arrays.toString(s.getPatterns("abc.*..a*").toArray()));
//        System.out.println(Arrays.toString(s.getPatterns("a").toArray()));
//        System.out.println(Arrays.toString(s.getPatterns("a*").toArray()));
//        System.out.println(Arrays.toString(s.getPatterns(".*").toArray()));
//        System.out.println(Arrays.toString(s.getPatterns("c*a*b").toArray()));
//
//
//        System.out.println(s.isMatch("aa","a"));
//        System.out.println(s.isMatch("aa","a*"));
//        System.out.println(s.isMatch("aba",".*"));
//        System.out.println(s.isMatch("aabcdwwdf","a*bcdw*.*"));
//        System.out.println(s.isMatch("aab","c*a*b"));

//        System.out.println(Arrays.toString(s.getPatterns("mis*is*ip*.").toArray()));
//        System.out.println(s.isMatch("mississippi","mis*is*ip*."));

//        System.out.println(Arrays.toString(s.getPatterns("ab*a").toArray()));
//        System.out.println(s.isMatch("aaa","ab*a"));

        System.out.println(Arrays.toString(s.getPatterns("ab*").toArray()));
        System.out.println(s.isMatch("a","ab*"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
