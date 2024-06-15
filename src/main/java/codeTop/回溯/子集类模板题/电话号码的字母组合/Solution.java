package codeTop.回溯.子集类模板题.电话号码的字母组合;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2838 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, List<String>> map = new HashMap<>();
    {
        map.put(2, Arrays.asList("a","b","c"));
        map.put(3,Arrays.asList("d","e","f"));
        map.put(4,Arrays.asList("g","h","i"));
        map.put(5,Arrays.asList("j","k","l"));
        map.put(6,Arrays.asList("m","n","o"));
        map.put(7,Arrays.asList("p","q","r","s"));
        map.put(8,Arrays.asList("t","u","v"));
        map.put(9,Arrays.asList("w","x","y","z"));
    }
    int n;
    List<String> res=new ArrayList<>();
    String digits;
    public List<String> letterCombinations(String digits) {
        n=digits.length();
        if(n==0){
            return res;
        }
        this.digits=digits;
        dfs(0,new ArrayList<>());
        return res;
    }

    public void dfs(int index,List<String> tmp){
        if(index>=n){
            return;
        }
        if(tmp.size()==n){
            res.add(String.join("",tmp));
            return;
        }
        int v= Integer.parseInt(digits.substring(index,index+1));
        for(String s:map.get(v)){
            tmp.add(s);
            dfs(index+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
