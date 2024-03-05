package codeTop.mid.leetcode3;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10011 👎 0


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int len = s.length();
        for (int l = 0, r = 0; r < len; r++) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                l++;
                r = l - 1;
                set.clear();
                continue;
            }
            set.add(c);
            max = Math.max(max, r - l + 1);

        }

        return max;
    }


    public int s1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // 如果出现重复的位置在左游标的右边才需要移动左游标
            if (map.containsKey(c)) {
                l = Math.max(l, map.get(c)+1);
            }
            map.put(c, r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.s1("pwwkew"));
        System.out.println(s.s1("abcabcbb"));
        System.out.println(s.s1("cccccc"));
        System.out.println(s.s1("dvdf"));
        System.out.println(s.s1("tmmzuxt"));
        System.out.println(s.s1(" "));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
